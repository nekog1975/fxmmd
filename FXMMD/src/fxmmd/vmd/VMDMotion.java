/**
 *
 */
package fxmmd.vmd;

import fxmmd.Quat4;
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
	private Quat4 rotation;
	private int[] interpolations;

	/**
	 * コンストラクタ
	 * @param bone_name ボーン名
	 * @param frame_no フレーム番号
	 * @param location 位置
	 * @param rotation 回転
	 * @param interpolations 補完
	 */
	public VMDMotion(String bone_name, int frame_no, Point3D location, Quat4 rotation, int[] interpolations) {
		this.bone_name = bone_name;
		this.frame_no = frame_no;
		this.location = location;
		this.rotation = rotation;
		this.interpolations = interpolations;
	}

	/**
	 * 座標移動があるか
	 * @return true / false
	 */
	public boolean isLocation() {
		return (location.getX() != 0 || location.getY() != 0 || location.getZ() != 0);
	}

	/**
	 * 回転があるか
	 * @return true / false
	 */
	public boolean isRotation() {
		return (rotation.getX() != 0 || rotation.getY() != 0 || rotation.getZ() != 0 || rotation.getW() != 0);
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
	public Quat4 getRotation() {
		return rotation;
	}

	/**
	 * @return interpolations
	 */
	public int[] getInterpolations() {
		return interpolations;
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VMDMotion [bone_name=" + bone_name + ", frame_no=" + frame_no + ", location=" + location + ", rotation="
				+ rotation.toString() + "]";
	}


}
