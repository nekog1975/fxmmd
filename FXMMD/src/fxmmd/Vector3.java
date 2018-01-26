package fxmmd;

/**
 * 3次元座標データ（x,y,x）です。3次元座標については、PMDデータとJavaFX3D上で、Y軸座標の+-逆転が発生するため、コンストラクタの時点で値を逆転させています。
 * @author neko爺
 *
 */
public final class Vector3 {

	private float x;
	private float y;
	private float z;

	/**
	 * コンストラクタ
	 * @param coordinate 座標配列
	 */
	public Vector3(float[] coordinate) {

		if(coordinate.length != 3) {

			throw new IllegalArgumentException();

		}

		x = coordinate[0];
		y = -coordinate[1];
		z = coordinate[2];

	}

	/**
	 * コンストラクタ
	 * @param x X座標
	 * @param y Y座標
	 * @param z Z座標
	 */
	public Vector3(float x, float y, float z) {

		this.x = x;
		this.y = -y;
		this.z = z;

	}

	/**
	 * X座標を取得する
	 * @return X座標
	 */
	public float getX() {

		return x;

	}

	/**
	 * Y座標を取得する
	 * @return Y座標
	 */
	public float getY() {

		return y;

	}

	/**
	 * Z座標を取得する
	 * @return Z座標
	 */
	public float getZ() {

		return z;

	}

}
