/**
 *
 */
package fx3d;

import fx3d.geometry.Matrix;
import fx3d.geometry.Quat4;
import javafx.geometry.Point3D;

/**
 * @author lg062
 *
 */
public final class Motion {

	private Integer bone_no;
	private Point3D translation;
	private Quat4 rotation;
	private Matrix transform;

	public Motion(Integer bone_no, Point3D translation, Quat4 rotation) {

		this.bone_no = bone_no;
		this.translation = translation;
		this.rotation = rotation;
		this.transform = Matrix.translate(translation);
		this.transform.append(Matrix.quaternio(rotation));

	}

	/**
	 * @return bone_no
	 */
	public Integer getBone_no() {
		return bone_no;
	}

	/**
	 * @return translation
	 */
	public Point3D getTranslation() {
		return translation;
	}

	/**
	 * @return rotation
	 */
	public Quat4 getRotation() {
		return rotation;
	}

	/**
	 * @return transform
	 */
	public Matrix getTransform() {
		return transform;
	}

}
