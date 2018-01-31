/**
 *
 */
package fxmmd.pmd;

import javafx.geometry.Point3D;

/**
 * 表情座標情報です。
 * @author neko爺
 *
 */
public final class PMDSkinVertex {

	private int index;
	private Point3D pos;

	/**
	 * コンストラクタ
	 * @param index 頂点番号
	 * @param pos 座標
	 */
	public PMDSkinVertex(int index, Point3D pos) {
		this.index = index;
		this.pos = pos;
	}

	/**
	 * @return index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @return pos
	 */
	public Point3D getPos() {
		return pos;
	}


}
