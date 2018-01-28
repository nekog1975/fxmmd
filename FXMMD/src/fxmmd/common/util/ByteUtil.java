/**
 *
 */
package fxmmd.common.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * バイト配列のデータから色々な形式でデータを取り出す処理を提供します。
 * @author neko爺
 *
 */
public final class ByteUtil{

	/**
	 * byte配列からunsigned byteの値をint配列として取得する
	 * @param bytes バイト配列
	 * @param offset 取得開始位置
	 * @param count 配列個数
	 * @return int値配列
	 */
	public static int[] toUByteArray(byte[] bytes, int offset, int count) {

		int[] dst = new int[count];
		for(int i=0; i<count; i++) {
			dst[i] = Byte.toUnsignedInt(bytes[offset + i]);
		}

		return dst;

	}

	/**
	 * byte配列からfloatの配列を取得する
	 * @param bytes バイト配列
	 * @param offset 取得開始位置
	 * @param count 配列個数
	 * @return float値配列
	 */
	public static float[] toFloatArray(byte[] bytes, int offset, int count) {

		float[] dst = new float[count];

		for(int i=0;i<count;i++) {
			dst[i] = toFloat(bytes, offset + i * 4);
		}

		return dst;

	}

	/**
	 * byte配列からintの配列を取得する(2バイトunsignedをint)
	 * @param bytes バイト配列
	 * @param offset 取得開始位置
	 * @param count 配列個数
	 * @return int値配列
	 */
	public static int[] toWIntArray(byte[] bytes, int offset, int count) {

		int[] dst = new int[count];

		for(int i=0;i<count;i++) {
			dst[i] = toWInt(bytes, offset + i * 2);
		}

		return dst;

	}

	/**
	 * byte配列からintの配列を取得する(4バイトunsignedをint)
	 * @param bytes バイト配列
	 * @param offset 取得開始位置
	 * @param count 配列個数
	 * @return int値配列
	 */
	public static int[] toDWIntArray(byte[] bytes, int offset, int count) {

		int[] dst = new int[count];

		for(int i=0;i<count;i++) {
			dst[i] = toDWInt(bytes, offset + i * 4);
		}

		return dst;

	}

	/**
	 * byte配列からfloatを取得する
	 * @param bytes バイト配列
	 * @param offset 取得開始位置
	 * @return float値
	 */
	public static float toFloat(byte[] bytes, int offset) {

		return ByteBuffer.wrap(bytes, offset, 4).order(ByteOrder.LITTLE_ENDIAN).getFloat();

	}

	/**
	 * byte配列からintを取得する(2バイトunsignedをint)
	 * @param bytes バイト配列
	 * @param offset 取得開始位置
	 * @return int値
	 */
	public static int toWInt(byte[] bytes, int offset) {

		return Short.toUnsignedInt(ByteBuffer.wrap(bytes, offset, 2).order(ByteOrder.LITTLE_ENDIAN).getShort());

	}

	/**
	 * byte配列からintを取得する(4バイトunsignedをint)
	 * @param bytes バイト配列
	 * @param offset 取得開始位置
	 * @return int値
	 */
	public static int toDWInt(byte[] bytes, int offset) {

		return ByteBuffer.wrap(bytes, offset, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();

	}

	/**
	 * byte配列からStringの配列を取得する（MS932）
	 * @param bytes バイト配列
	 * @param offset 開始位置
	 * @param length 長さ
	 * @param count 取得する個数
	 * @return 取得した文字列の配列
	 * @throws UnsupportedEncodingException 文字コード不正時
	 */
	public static String[] toStringArray(byte[] bytes, int offset, int length, int count) throws UnsupportedEncodingException {

		return ByteUtil.toStringArray(bytes, offset, length, "MS932", count);

	}

	/**
	 * byte配列からStringの配列を取得する（文字コード指定）
	 * @param bytes バイト配列
	 * @param offset 開始位置
	 * @param length 長さ
	 * @param charset 文字コード
	 * @param count 取得する個数
	 * @return 取得した文字列の配列
	 * @throws UnsupportedEncodingException 文字コード不正時
	 */
	public static String[] toStringArray(byte[] bytes, int offset, int length, String charset, int count) throws UnsupportedEncodingException {

		String[] arrays = new String[count];
		for(int i=0; i<count; i++) {
			arrays[i] = ByteUtil.toString(bytes, offset + i * length, length, charset);
		}

		return arrays;

	}

	/**
	 * byte配列からStringを取得する（MS932）
	 * @param bytes バイト配列
	 * @param offset 開始位置
	 * @param length 長さ
	 * @return 取得した文字列
	 * @throws UnsupportedEncodingException 文字コード不正時
	 */
	public static String toString(byte[] bytes, int offset, int length) throws UnsupportedEncodingException {

		return toString(bytes, offset, length, "MS932");

	}

	/**
	 * byte配列からStringを取得する（文字コード指定）
	 * @param bytes バイト配列
	 * @param offset 開始位置
	 * @param length 長さ
	 * @param charset 文字コード
	 * @return 取得した文字列
	 * @throws UnsupportedEncodingException 文字コード不正時
	 */
	public static String toString(byte[] bytes, int offset, int length, String charset) throws UnsupportedEncodingException {

		byte[] src = new byte[length];

		ByteBuffer.wrap(bytes, offset, length).get(src);

		// ターミネーターまでに切り詰める
		int l = 0;
		for(byte b : src) {
			if(b == 0x00) break;
			l++;
		}
		byte[] dst = new byte[l];
		System.arraycopy(src, 0, dst, 0, l);
		return new String(dst, charset);

	}
}
