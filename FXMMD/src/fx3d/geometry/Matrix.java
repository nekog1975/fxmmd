/**
 *
 */
package fx3d.geometry;

import javafx.geometry.Point3D;
import javafx.scene.transform.Affine;
import javafx.scene.transform.MatrixType;

/**
 * @author lg062
 *
 */
public class Matrix extends Affine{

	private static final double[] matrix = {
			1,  0,  0,  0,
			0,  1,  0,  0,
			0,  0,  1,  0,
			0,  0,  0,  1,
		};


	public Matrix() {
		super(matrix, MatrixType.MT_3D_4x4, 0);
	}

	public static Matrix translate(Point3D point) {
		Matrix matrix = new Matrix();
		matrix.setTranslate(point);
		return matrix;
	}

	public static Matrix quaternio(Quat4 quat) {
		Matrix matrix = new Matrix();
		matrix.setQuaternion(quat);
		return matrix;
	}

	public void PMDtoFx() {
		setMyy(-1);
	}

	public void setTranslate(Point3D point) {
		setTx(point.getX());
		setTy(point.getY());
		setTz(point.getZ());
	}

	public void setQuaternion(Quat4 quat) {
		double w = quat.getW(), x = quat.getX(), y = quat.getY(), z = quat.getZ();

		setMxx(1.0 - 2.0 * y * y - 2.0 * z * z);
		setMxy(2.0 * x * y + 2.0 * w * z);
		setMxz(2.0 * x * z - 2.0 * w * y);
		setMyx(2.0 * x * y - 2.0 * w * z);
		setMyy(1.0 - 2.0 * x * x - 2.0 * z * z);
		setMyz(2.0 * y * z * + 2.0 * w * x);
		setMzx(2.0 * x * z + 2.0 * w * y);
		setMzy(2.0 * y * z - 2.0 * w * x);
		setMzz(1.0 - 2.0 * x * x - 2.0 * y * y);
	}
}
