/**
 *
 */
package fxmmd.vmd;

import fxmmd.Vector3;

/**
 * カメラの情報です。
 * @author neko爺
 *
 */
public final class VMDCamera {

	private int frame_no;
	private float length;
	private Vector3 location;
	private Vector3 rotation;
	private int[] interporations;
	private int viewing_angle;
	private byte perspective;

	/**
	 * コンストラクタ
	 * @param frame_no フレーム番号
	 * @param length 距離
	 * @param location 位置
	 * @param rotation 回転
	 * @param interporations 補完
	 * @param viewing_angle 視界角
	 * @param perspective パースペクティブ
	 */
	public VMDCamera(int frame_no, float length, Vector3 location, Vector3 rotation, int[] interporations, int viewing_angle, byte perspective) {

		this.frame_no = frame_no;
		this.length = length;
		this.location = location;
		this.rotation = rotation;
		this.interporations = interporations;
		this.viewing_angle = viewing_angle;
		this.perspective = perspective;

	}

	/**
	 * @return frame_no
	 */
	public int getFrame_no() {
		return frame_no;
	}

	/**
	 * @return length
	 */
	public float getLength() {
		return length;
	}

	/**
	 * @return location
	 */
	public Vector3 getLocation() {
		return location;
	}

	/**
	 * @return rotation
	 */
	public Vector3 getRotation() {
		return rotation;
	}

	/**
	 * @return interporations
	 */
	public int[] getInterporations() {
		return interporations;
	}

	/**
	 * @return viewing_angle
	 */
	public int getViewing_angle() {
		return viewing_angle;
	}

	/**
	 * @return perspective
	 */
	public byte getPerspective() {
		return perspective;
	}


}
