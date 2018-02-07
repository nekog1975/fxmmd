/**
 *
 */
package fxmmd.fx;

import fxmmd.Quat4;
import javafx.geometry.Point3D;

/**
 * @author shigeo
 *
 */
public final class FxMotion {

	private Integer bone_index;
	private Point3D location;
	private Quat4 rotation;

	public FxMotion(Integer bone_index, Point3D location, Quat4 rotation) {

		this.bone_index = bone_index;
		this.location = location;
		this.rotation = rotation;

	}

	/**
	 * @return bone_index
	 */
	public Integer getBone_index() {
		return bone_index;
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

}
