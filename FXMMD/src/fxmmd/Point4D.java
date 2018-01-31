package fxmmd;

/**
 * 4次元座標データ（x,y,z,t）です。3次元座標については、PMDデータとJavaFX3D上で、Y軸座標の+-逆転が発生するため、コンストラクタの時点で値を逆転させています。
 * @author neko爺
 *
 */
public final class Point4D {

	private float[] coordinate = new float[4];

	/**
	 * コンストラクタ
	 * @param coordinate 座標配列
	 */
	public Point4D(float[] coordinate) {

		if(coordinate.length != 4) {

			throw new IllegalArgumentException();

		}

		this.coordinate[0] = coordinate[0];
		this.coordinate[1] = -coordinate[1];
		this.coordinate[2] = coordinate[2];
		this.coordinate[3] = coordinate[3];

	}

	/**
	 * コンストラクタ
	 * @param x X座標
	 * @param y Y座標
	 * @param z Z座標
	 * @param t 回転
	 */
	public Point4D(float x, float y, float z, float t) {

		this.coordinate[0] = x;
		this.coordinate[1] = -y;
		this.coordinate[2] = z;
		this.coordinate[3] = t;

	}

	/**
	 * 座標データの配列を取得する
	 * @return float配列
	 */
	public float[] getVectorArray() {
		return coordinate;
	}

	/**
	 * X座標を取得する
	 * @return X座標
	 */
	public float getX() {

		return coordinate[0];

	}

	/**
	 * Y座標を取得する
	 * @return Y座標
	 */
	public float getY() {

		return coordinate[1];

	}

	/**
	 * Z座標を取得する
	 * @return Z座標
	 */
	public float getZ() {

		return coordinate[2];

	}

	/**
	 * 回転を取得する
	 * @return 回転
	 */
	public float getT() {

		return coordinate[3];

	}

}
