package mindustry;

import java.lang.reflect.Method;
import java.util.Arrays;

public class NeoeInject {

	static boolean inited;
	private static Method callMethod;

	public static Object call(String cmd, Object... args) {
		if (!inited)
			init();
		if (callMethod == null)
			return null;
		try {
			return callMethod.invoke(null, cmd, args);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.printf("failed NeoeInject.call(%s, %s)", cmd, Arrays.deepToString(args));
			return "err:" + e;
		}
	}

	private static void init() {
		inited = true;
		try {
			Class neoeclass = NeoeInject.class.getClassLoader().loadClass("neoe.mindustry.Neoe");
			callMethod = neoeclass.getMethod("call", new Class[] { String.class, Object[].class });
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("NeoeInject failed:" + e);
		}
	}

}
