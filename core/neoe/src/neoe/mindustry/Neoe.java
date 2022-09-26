package neoe.mindustry;

import java.lang.reflect.Field;

import mindustry.type.Sector;
import neoe.textfrog.interprete.Interpreter;
import neoe.util.Log;

public class Neoe {

	public static Object call(String cmd, Object... args) throws Exception {
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

	private static void checkTextfrog() throws Exception {
		if (tfg == null) {
			tfg = neoe.textfrog.Main.run(new String[] { "mindustry.tfg" }, 0);
			mlog = neoe.textfrog.interprete.builtin.func.log.getLog();
		}
	}

	void test() throws  Exception {
		getClass().isAssignableFrom(null);
		Field f;
		getClass().getField("");
		// new HashSet().contains(f)
	}
}
