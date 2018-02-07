/**
 *
 */
package fxmmd.common.util;

import fxmmd.Quat4;
import javafx.geometry.Point3D;
import javafx.scene.transform.Affine;
import javafx.scene.transform.MatrixType;

/**
 * @author lg062
 *
 */
public final class PointUtil {

	public enum MATRIX{
		CREATE,
		NORMAL
	}

	private static final double[] matrix = {
			1,  0,  0,  0,
			0,  -1,  0,  0,
			0,  0,  1,  0,
			0,  0,  0,  1,
		};

	private static final double[] normal_matrix = {
			1,  0,  0,  0,
			0,  1,  0,  0,
			0,  0,  1,  0,
			0,  0,  0,  1,
		};

	/**
	 * 4次元アファインを取得する
	 * @return アファイン
	 */
	public static Affine create4DAffine(PointUtil.MATRIX mat) {

		if(mat == MATRIX.CREATE) {
			return new Affine(matrix, MatrixType.MT_3D_4x4, 0);
		}

		return new Affine(normal_matrix, MatrixType.MT_3D_4x4, 0);
	}


	/**
	 * 4次元アファインを取得する
	 * @return アファイン
	 */
	public static Affine create4DAffine() {

		return create4DAffine(PointUtil.MATRIX.CREATE);
	}

	/**
	 * 三次元データをアフィンに設定する
	 * @param p ３次元データ
	 * @param a アフィン
	 */
	public static void point3DtoAffine(Point3D p, Affine a) {

		a.setTx(p.getX());
		a.setTy(p.getY());
		a.setTz(p.getZ());

	}

	/**
	 * クォータニオンからアフィンに変換する
	 * @param q クォータニオン
	 * @param a アフィン
	 */
	public static void  quaternionToAffine(Quat4 q, Affine a) {

		double w = q.getW(), x = q.getX(), y = q.getY(), z = q.getZ();

		a.setMxx(1.0 - 2.0 * y * y - 2.0 * z * z);
		a.setMxy(2.0 * x * y + 2.0 * w * z);
		a.setMxz(2.0 * x * z - 2.0 * w * y);
		a.setMyx(2.0 * x * y - 2.0 * w * z);
		a.setMyy(1.0 - 2.0 * x * x - 2.0 * z * z);
		a.setMyz(2.0 * y * z * + 2.0 * w * x);
		a.setMzx(2.0 * x * z + 2.0 * w * y);
		a.setMzy(2.0 * y * z - 2.0 * w * x);
		a.setMzz(1.0 - 2.0 * x * x - 2.0 * y * y);

	}

}
