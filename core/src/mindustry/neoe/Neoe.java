package mindustry.neoe;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import mindustry.type.Sector;
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

	public static void logSelected(Sector sector) {
		try {
			new NeoeSectorAnalyze().run(sector);
		} catch (Exception e) {
			e.printStackTrace();
			getLog().log0("err", e);
		}
	}

}
