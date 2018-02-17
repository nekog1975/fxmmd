/**
 *
 */
package fx3d.model.pmd;

import javafx.scene.paint.Color;

/**
 * 色をRGBAで表すクラスです。
 * @author neko爺
 *
 */
public final class Rgba {

	private Color color;

	/**
	 * コンストラクタ
	 * @param rgba RGBA値の配列
	 */
	public Rgba(float[] rgba) {

		if(rgba.length != 4) {

			throw new IllegalArgumentException();

		}

		color = new Color(rgba[0], rgba[1], rgba[2], rgba[3]);
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

	/**
	 * アルファブレンドの値を取得する
	 * @return A値
	 */
	public float getA() {

		return (float)color.getOpacity();

	}

}
