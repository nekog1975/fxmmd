/**
 *
 */
package fx3d.model.pmd;

/**
 * 面頂点情報のクラスです。
 * PMDデータとJavaFX上でのy座標データが+-逆転するため、面頂点情報の順番もPMDデータから読み込んだままではなく、
 * 逆順に指定する必要があるため、コンストラクタの時点で順番を逆に指定しています。
 * @author neko爺
 *
 */
public final class PMDFace {

	private int p0;
	private int p1;
	private int p2;

	/**
	 * コンストラクタ
	 * @param coordinate X,Y,Zの配列
	 */
	public PMDFace(int[] coordinate) {

		if(coordinate.length != 3) {

			throw new IllegalArgumentException();

		}

		this.p0 = coordinate[2];
		this.p1 = coordinate[1];
		this.p2 = coordinate[0];

	}

	/**
	 * コンストラクタ
	 * @param p0 頂点1
	 * @param p1 頂点2
	 * @param p2 頂点3
	 */
	public PMDFace(int p0, int p1, int p2) {

		this.p0 = p2;
		this.p1 = p1;
		this.p2 = p0;

	}

	/**
	 * p0を取得する
	 * @return p0
	 */
	public int getP0() {

		return p0;

	}

	/**
	 * p1を取得する
	 * @return p1
	 */
	public int getP1() {

		return p1;

	}

	/**
	 * p2を取得する
	 * @return p2
	 */
	public int getP2() {

		return p2;

	}



}
