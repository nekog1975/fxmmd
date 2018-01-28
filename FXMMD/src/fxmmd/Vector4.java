package fxmmd;

/**
 * 4次元座標データ（x,y,z,t）です。3次元座標については、PMDデータとJavaFX3D上で、Y軸座標の+-逆転が発生するため、コンストラクタの時点で値を逆転させています。
 * @author neko爺
 *
 */
public final class Vector4 {

	private float x;
	private float y;
	private float z;
	private float t;

	/**
	 * コンストラクタ
	 * @param coordinate 座標配列
	 */
	public Vector4(float[] coordinate) {

		if(coordinate.length != 4) {

			throw new IllegalArgumentException();

		}

		x = coordinate[0];
		y = -coordinate[1];
		z = coordinate[2];
		t = coordinate[3];

	}

	/**
	 * コンストラクタ
	 * @param x X座標
	 * @param y Y座標
	 * @param z Z座標
	 * @param t 回転
	 */
	public Vector4(float x, float y, float z, float t) {

		this.x = x;
		this.y = -y;
		this.z = z;
		this.t = t;

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

	/**
	 * 回転を取得する
	 * @return 回転
	 */
	public float getT() {

		return t;

	}

}
