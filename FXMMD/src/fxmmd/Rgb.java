/**
 *
 */
package fxmmd;

import javafx.scene.paint.Color;

/**
 * 色をRGBで表すクラスです。
 * @author neko爺
 *
 */
public final class Rgb {

	private Color color;

	/**
	 * コンストラクタ
	 * @param rgb RGB値の配列
	 */
	public Rgb(float[] rgb) {

		if(rgb.length != 3) {

			throw new IllegalArgumentException();

		}

		color = new Color(rgb[0], rgb[1], rgb[2], 1.0);
	}

	/**
	 * カラーを取得する
	 * @return Colorオブジェクト
	 */
	public Color getColor() {

		return color;

	}

	/**
	 * 赤の値を取得する
	 * @return R値
	 */
	public float getR() {

		return (float)color.getRed();

	}

	/**
	 * 緑の値を取得する
	 * @return G値
	 */
	public float getG() {

		return (float)color.getGreen();

	}

	/**
	 * 青の値を取得する
	 * @return B値
	 */
	public float getB() {

		return (float)color.getBlue();

	}

}
