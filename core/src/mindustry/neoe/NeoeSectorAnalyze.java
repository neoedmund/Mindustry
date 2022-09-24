package mindustry.neoe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mindustry.content.Blocks;
import mindustry.ctype.UnlockableContent;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.type.Sector;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.defense.turrets.Turret;
import mindustry.world.blocks.power.PowerGenerator;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.blocks.units.UnitFactory.UnitPlan;
import mindustry.world.consumers.Consume;
import mindustry.world.consumers.ConsumeItemFilter;
import mindustry.world.consumers.ConsumeItems;
import mindustry.world.consumers.ConsumePower;
import neoe.util.Config;

public class NeoeSectorAnalyze {
	StringBuilder sb = new StringBuilder();
	private Sector sector;
	static List<Block> _allBlocks;
	Set<Item> availRes = new HashSet();
	private boolean hasPower;

	static synchronized List<Block> getAllBlocks() {
		if (_allBlocks != null)
			return _allBlocks;
		List<Block> bs = new ArrayList<>();
		List<String> names = (List) Config.get(Neoe.getConf(), "allBlocks");
		for (String name : names) {
			Block b = tryGetStaticField(Blocks.class, name);
			if (b == null)
				continue;
			bs.add(b);
		}
		Neoe.log("init allblocks cnt=%,d", bs.size());
		return _allBlocks = bs;
	}

	private static Block tryGetStaticField(Class<?> clz, String name) {
		Field f;
		try {
			f = clz.getDeclaredField(name);
			return (Block) f.get(null);
		} catch (Exception e) {
			return null;
		}

	}

	public void run(Sector sector) throws Exception {
		this.sector = sector;
		print("selected :" + sector.name());
		printResource();
		checkPower();
		printAvailProduct();
		printAvailArmy();
		printAvailTurret();
		print("\n--------\n");
		Neoe.log(sb.toString());
	}

	private void checkPower() {
		for (Block b : getAllBlocks()) {// eg. graphite-press
			if (b == null)
				continue;
			if (b instanceof PowerGenerator) {
				PowerGenerator b1 = (PowerGenerator) b;
				if (b1.consumers.length == 0)
					continue;
				if (meetAny(b1.consumers)) {
					printPowerGenerator(b1);
					hasPower = true;
				}
			}
		}

	}

	private void printPowerGenerator(PowerGenerator b1) {
		print("\n PowerGen: %s cost: %s \n  in:%s ", b1.localizedName, Arrays.deepToString(b1.requirements),
				getString(b1.consumers));
	}

	private String getString(Consume[] consumers) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Consume c : consumers) {
			if (c instanceof ConsumeItems) {
				sb.append(" [");
				boolean first = true;
				for (ItemStack it : ((ConsumeItems) c).items) {
					if (first)
						first = false;
					else
						sb.append(" + ");
					sb.append(it);
				}
				sb.append("]");

			} else {
				sb.append(" " + c.getClass().getSimpleName());
			}
		}

		return sb.toString();
	}

	private void printAvailProduct() throws Exception {
		Set<Item> more = new HashSet<>();
		for (Block b : getAllBlocks()) {// eg. graphite-press
			if (b == null)
				continue;
			if (b instanceof GenericCrafter) {
				GenericCrafter b1 = (GenericCrafter) b;
				if (meetAny(b1.consumers)) {
					printGenericCrafter(b1);
					if (b1.outputItem != null) {
						Item out = b1.outputItem.item;
						print("\n \t  out -> " + out);
						if (!availRes.contains(out)) {
							availRes.add(out);
							more.add(out);
						}
					}
				}
			}
		}
		if (!more.isEmpty()) {
			print("\nSum Produced:" + more);
		}

	}

	private void printResource() {
		print("\n  res [ ");
		for (UnlockableContent uc : sector.info.resources) {
			if (uc == null)
				continue;
			print(uc.localizedName);
			if (uc instanceof Item) {
				availRes.add((Item) uc);
				print("+");
			}
			print(" ");
		}
		print("]");
	}

	private void printAvailArmy() {

		for (Block b : getAllBlocks()) { // eg. ground-factory
			if (b == null)
				continue;
			if (b instanceof UnitFactory) {
				UnitFactory b1 = (UnitFactory) b;
				boolean ok = false;
				for (UnitPlan x : b1.plans) {
					if (meet(x.requirements)) {
						printUnitPlan(x);
						ok = true;
					}
				}
				if (ok) {
					printFactory(b1);
				}
			}
		}
	}

	private void printAvailTurret() {
		print("\n Turret:");
		for (Block b : getAllBlocks()) { // eg. scatter , arc
			if (b == null)
				continue;
			if (b instanceof ItemTurret) {
				ItemTurret b1 = (ItemTurret) b;
				boolean ok = false;
				for (Item x : b1.ammoTypes.keys()) {
					if (meet(x)) {
						printItemTurret(b1);
						ok = true;
						break;
					}
				}

			} else if (b instanceof PowerTurret) {
				PowerTurret b1 = (PowerTurret) b;
				printTurret(b1);
				printPower();
			}
		}
	}

	private void printPower2(boolean needpower) {
		if (needpower) {
			if (!hasPower)
				print("\n (*power)");
			else
				print("\n (power)");
		} else {
			print("\n");
		}
	}

	private void printPower() {
		if (!hasPower)
			print("(*power)");
		else
			print(" power ");
	}

//	private boolean needPower(Consume[] consumers) {
//		for (Consume c : consumers) {
//			if (c instanceof ConsumePower) {
//				return true;
//			}
//		}
//		return false;
//	}

	private void printTurret(Turret b1) {
		print("\n %s cost: %s ", b1.localizedName, Arrays.deepToString(b1.requirements));

	}

	private void printItemTurret(ItemTurret b1) {
		print("\n %s cost: %s ammo: %s ", b1.localizedName, Arrays.deepToString(b1.requirements), b1.ammoTypes.keys().toSeq());

	}

	private boolean meet(Item x) {
		return availRes.contains(x);
	}

	private void printFactory(UnitFactory b1) {
		print("\n    by Fac: %s cost: %s", b1.localizedName, Arrays.deepToString(b1.requirements));

	}

	private void printUnitPlan(UnitPlan x) {
		print("\n  Unit: %s cost:%s", x.unit.localizedName, Arrays.deepToString(x.requirements));

	}

	private boolean meet(ItemStack[] requirements) {
		for (ItemStack is : requirements) {
			if (!availRes.contains(is.item))
				return false;
		}
		return true;
	}

	private boolean meetAny(Consume[] consumers) {
		boolean needpower = false;
		for (Consume c : consumers) {
			if (c instanceof ConsumePower) {
				needpower = true;
			}
		}
		for (Consume c : consumers) {
			if (c instanceof ConsumeItemFilter) {
				if (has((ConsumeItemFilter) c)) {
					printPower2(needpower);
					return true;
				}
			} else if (c instanceof ConsumeItems) {
				if (meet(((ConsumeItems) c).items)) {
					printPower2(needpower);
					return true;
				}
			} else {
				// ignore?
			}
		}
		return false;
	}

	private boolean has(ConsumeItemFilter c) {
		return availRes.stream().anyMatch(x -> c.filter.get(x));
	}

	private void printGenericCrafter(GenericCrafter b1) {
		print(" Crafter: %s  cost: %s \n \t  in: %s", b1.localizedName, Arrays.deepToString(b1.requirements),
				getString(b1.consumers));

	}

	private void print(String fmt, Object... args) {
		sb.append(String.format(fmt, args));
	}

}
