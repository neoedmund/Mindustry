package neoe.mindustry;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import arc.struct.ObjectMap.Entry;
import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.ctype.UnlockableContent;
import mindustry.game.SectorInfo.ExportStat;
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
import mindustry.world.consumers.ConsumeItemExplode;
import mindustry.world.consumers.ConsumeItemFilter;
import mindustry.world.consumers.ConsumeItemFlammable;
import mindustry.world.consumers.ConsumeItems;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.world.consumers.ConsumePower;
import neoe.util.Config;

public class NeoeSectorAnalyze {
	static List<Block> _allBlocks;

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

	Set<Item> availRes = new HashSet();
	private boolean hasPower;

	StringBuilder sb = new StringBuilder();

	private Sector sector;

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
					sb.append(itemStack(it));
				}
				sb.append("]");

			} else if (c instanceof ConsumePower) {
				sb.append(" 电 x " + ((ConsumePower) c).usage);
			} else if (c instanceof ConsumeLiquid) {
				sb.append(" 液体 x " + ((ConsumeLiquid) c).amount);
			} else if (c instanceof ConsumeItemFlammable) {
				ConsumeItemFlammable c1 = (ConsumeItemFlammable) c;
				sb.append(" 燃烧物 >=" + c1.minFlammability + meetStr(c1));
			} else if (c instanceof ConsumeItemExplode) {
				ConsumeItemExplode c1 = (ConsumeItemExplode) c;
				sb.append(" 爆炸物 >=" + c1.threshold + meetStr(c1));
			} else {
				sb.append(" " + c.getClass().getSimpleName());
			}
		}
		sb.append("]");
		return sb.toString();
	}

	private String meetStr(ConsumeItemFilter c1) {
		return availRes.stream().filter(x -> c1.filter.get(x)).toList().toString();
	}

	private boolean has(ConsumeItemFilter c) {
		return availRes.stream().anyMatch(x -> c.filter.get(x));
	}

	private String item(Item i) {
		if (availRes.contains(i))
			return i.localizedName;
		return "-" + i.localizedName;
	}

	private String itemList(Seq<Item> seq) {
		StringBuilder sb = new StringBuilder("[");
		boolean first = true;
		for (Item i : seq) {
			if (first)
				first = false;
			else
				sb.append(" ");
			sb.append(item(i));
		}
		sb.append("]");
		return sb.toString();
	}

	private String itemStack(ItemStack it) {
		return item(it.item) + " x " + it.amount;
	}

	private boolean meet(Item x) {
		return availRes.contains(x);
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

	private void print(String fmt, Object... args) {
		sb.append(String.format(fmt, args));
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

//	private boolean needPower(Consume[] consumers) {
//		for (Consume c : consumers) {
//			if (c instanceof ConsumePower) {
//				return true;
//			}
//		}
//		return false;
//	}

	private void printAvailProduct() throws Exception {
		Set<Item> added = new HashSet<>();
		Set<Block> done = new HashSet<>();
		while (true) {
			int more = 0;
			for (Block b : getAllBlocks()) {// eg. graphite-press
				if (b == null)
					continue;
				if (done.contains(b))
					continue;
				if (b instanceof GenericCrafter) {
					GenericCrafter b1 = (GenericCrafter) b;
					if (meetAny(b1.consumers)) {
						done.add(b1);
						printGenericCrafter(b1);
						if (b1.outputItem != null) {
							Item out = b1.outputItem.item;
							print("\n \t  out -> " + out);
							if (!availRes.contains(out)) {
								if (out.unlocked()) {
									availRes.add(out);
									added.add(out);
									more++;
								}
							}
						}
					}
				}
			}
			if (more == 0)
				break;
		}
		if (!added.isEmpty()) {
			print("\n--- Sum Produced:" + added);
		}
		Set<Item> todo = new HashSet<>(availRes);
		ArrayList<Item> p =new ArrayList();
		for(Entry<Item, ExportStat> x : sector.info.production) {
			if (x.value.mean>0) {
				p.add(x.key);
			}
		}
		print("\n Producing:" + p);
		todo.removeAll(p);
		if (!todo.isEmpty()) {
			print("\n---Todo Produce:" + todo);
		}
	}

	private void printAvailTurret() {
		print("\n---Turrets:");
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

	private void printFactory(UnitFactory b1) {
		print("\n    by Factory: %s%s 建造材料: %s", b1.localizedName, unlocked(b1), Arrays.deepToString(b1.requirements));

	}

	private void printGenericCrafter(GenericCrafter b1) {
		print(" 制造厂: %s%s  建造材料: %s \n \t  in: %s", b1.localizedName, unlocked(b1),
				Arrays.deepToString(b1.requirements), getString(b1.consumers));

	}

	private String unlocked(UnlockableContent b1) {
		if (b1.unlocked())
			return "";
		else
			return "?";
	}

	private void printItemTurret(ItemTurret b1) {
		print("\n %s%s 建造材料: %s ammo: %s ", b1.localizedName, unlocked(b1), Arrays.deepToString(b1.requirements),
				itemList(b1.ammoTypes.keys().toSeq()));

	}

	private void printPower() {
		if (!hasPower)
			print("(*要电)");
		else
			print(" (要电)");
	}

	private void printPower2(boolean needpower) {
		if (needpower) {
			if (!hasPower)
				print("\n (*要电)");
			else
				print("\n (要电)");
		} else {
			print("\n");
		}
	}

	private void printPowerGenerator(PowerGenerator b1) {
		print("\n 供电: %s 建造材料: %s%s \n  in:%s ", b1.localizedName, unlocked(b1), Arrays.deepToString(b1.requirements),
				getString(b1.consumers));
	}

	private void printResource() {
		print("\n  Resource [ ");
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

	private void printTurret(Turret b1) {
		print("\n %s%s 建造材料: %s ", b1.localizedName, unlocked(b1), Arrays.deepToString(b1.requirements));

	}

	private void printUnitPlan(UnitPlan x) {
		print("\n  Unit: %s%s 建造材料:%s", x.unit.localizedName, unlocked(x.unit), Arrays.deepToString(x.requirements));

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

}
