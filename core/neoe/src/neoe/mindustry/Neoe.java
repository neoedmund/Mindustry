package neoe.mindustry;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import mindustry.Vars;
import mindustry.type.Sector;
import mindustry.world.Block;
import mindustry.world.Tiles;
import neoe.textfrog.interprete.Interpreter;
import neoe.util.Log;

public class Neoe {

	public static Object call(String cmd, Object... args) {
		try {
			switch (cmd) {
			case "anaSector": {
				anaSector((Sector) args[0]);
				return null;
			}
			case "cmdline": {
				return cmdline((String) args[0]);
			}
			default:
				mlog.log0("unknown command:" + cmd);
			}
			return null;
		} catch (Exception e) {
			mlog.log0("err", e);
			return "err:" + e;
		}
	}

	private static Object cmdline(String cmd) throws Exception {
		checkTextfrog();
		return tfg.callFunc("cmdline", cmd).ret;
	}

	static Interpreter tfg;
	static Log mlog = Log.getLog();

	static void anaSector(Sector sector) throws Exception {
		checkTextfrog();
		tfg.callFunc("anaSector", sector);
	}

	static void checkTextfrog() throws Exception {
		if (tfg == null) {
			tfg = neoe.textfrog.Main.run(new String[] { "mindustry.tfg" }, 0);
			mlog = neoe.textfrog.interprete.builtin.func.log.getLog();
		}
	}

	public void patchlize(List sb, Tiles tiles) {
		new Patchlize(sb, tiles).run();
	}

	void test() throws Exception {
//		getClass().isAssignableFrom(null);
//		Field f;
//		getClass().getField("");
//		// new HashSet().contains(f)
//		Iterator it;
//		Block b;
//		Vars.player.unit().x(0);
//		new File("").lastModified();
//		Map m;m.entrySet().forEach(a->{a.});;
//		b.id;
//		for(Object i:it);
	}
}
