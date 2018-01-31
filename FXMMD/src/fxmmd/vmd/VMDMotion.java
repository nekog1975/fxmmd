/**
 *
 */
package fxmmd.vmd;

import fxmmd.Point4D;
import javafx.geometry.Point3D;

/**
 * モーションデータです。
 * @author neko爺
 *
 */
public final class VMDMotion {

	private String bone_name;
	private int frame_no;
	private Point3D location;
	private Point4D rotation;
	private int[] interpolations;

	/**
	 * コンストラクタ
	 * @param bone_name ボーン名
	 * @param frame_no フレーム番号
	 * @param location 位置
	 * @param rotation 回転
	 * @param interpolations 補完
	 */
	public VMDMotion(String bone_name, int frame_no, Point3D location, Point4D rotation, int[] interpolations) {
		this.bone_name = bone_name;
		this.frame_no = frame_no;
		this.location = location;
		this.rotation = rotation;
		this.interpolations = interpolations;
	}

	/**
	 * @return bone_name
	 */
	public String getBone_name() {
		return bone_name;
	}

	/**
	 * @return frame_no
	 */
	public int getFrame_no() {
		return frame_no;
	}

	/**
	 * @return location
	 */
	public Point3D getLocation() {
		return location;
	}

	/**
	 * @return rotation
	 */
	public Point4D getRotation() {
		return rotation;
	}

	/**
	 * @return interpolations
	 */
	public int[] getInterpolations() {
		return interpolations;
	}
}
