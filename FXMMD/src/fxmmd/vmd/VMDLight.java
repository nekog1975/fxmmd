/**
 *
 */
package fxmmd.vmd;

import fxmmd.Rgb;
import fxmmd.Vector3;

/**
 * 照明のデータです。
 * @author neko爺
 *
 */
public final class VMDLight {

	private int franme_no;
	private Rgb color;
	private Vector3 location;

	/**
	 * コンストラクタ
	 * @param frame_no フレーム番号
	 * @param color カラー
	 * @param location ロケーション
	 */
	public VMDLight(int frame_no, Rgb color, Vector3 location) {

		this.franme_no = frame_no;
		this.color = color;
		this.location = location;

	}

	/**
	 * @return franme_no
	 */
	public int getFranme_no() {
		return franme_no;
	}

	/**
	 * @return color
	 */
	public Rgb getColor() {
		return color;
	}

	/**
	 * @return location
	 */
	public Vector3 getLocation() {
		return location;
	}


}
