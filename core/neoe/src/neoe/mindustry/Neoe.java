package neoe.mindustry;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import mindustry.type.Sector;
import neoe.textfrog.interprete.Interpreter;
import neoe.util.FileUtil;
import neoe.util.Log;
import neoe.util.PyData;

public class Neoe {

	private static Log mlog;

	public static void log(String fmt, Object... args) {
		getLog().logs0(fmt, args);
	}

	private static Map conf;

	public synchronized static Map getConf() {
		if (conf != null)
			return conf;
		try {
			conf = (Map) PyData.parseAll(FileUtil.readString(Neoe.class.getResourceAsStream("neoe.conf"), null));
			log("neoe.conf inited " + conf.keySet());
		} catch (Exception e) {
			getLog().log0("cannot get neoe.conf", e);
			conf = new HashMap();
		}
		return conf;
	}

	private static synchronized Log getLog() {
		if (mlog != null)
			return mlog;
		mlog = Log.getLog("mindustry");
		try {
			mlog.clear();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mlog;
	}

	static Interpreter tfg;

	public static void anaSector(Sector sector) {
		try {
			// new NeoeSectorAnalyze().run(sector);
			if (tfg == null)
				tfg = neoe.textfrog.Main.run(new String[] { "mindustry.tfg" }, 0);
			tfg.callFunc("anaSector", sector);
		} catch (Exception e) {
			e.printStackTrace();
			if (tfg != null) {
				neoe.textfrog.interprete.builtin.func.log.getLog().log0("err", e);
			} else {
				getLog().log0("err", e);
			}
		}
	}
void test() {
	getClass().isAssignableFrom(null);
	Field f;
	//new HashSet().contains(f)
}
}
