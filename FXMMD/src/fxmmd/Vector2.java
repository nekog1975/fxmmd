package fxmmd;

/**
 * 二次元座標（x,y)を表すクラスです。二次元座標（UV座標）のy軸座標については、+-の逆転は発生しません。
 * @author neko爺
 *
 */
public final class Vector2 {

	private float x;
	private float y;

	/**
	 * コンストラクタ
	 * @param coordinate 座標配列
	 */
	public Vector2(float[] coordinate) {

		if(coordinate.length != 2) {

			throw new IllegalArgumentException();

		}

		x = coordinate[0];
		y = coordinate[1];

	}

	/**
	 * コンストラクタ
	 * @param x X座標
	 * @param y Y座標
	 */
	public Vector2(float x, float y) {

		this.x = x;
		this.y = y;

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

}
