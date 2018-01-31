/**
 *
 */
package fxmmd.common.util;

/**
 * @author lg062
 *
 */
public final class TimeUtil {

	private static long start = 0;

	public static void start() {
		start = System.currentTimeMillis();
	}

	public static void end() {
		System.out.println("time = " + (System.currentTimeMillis() - start) + " ms");
	}

}
