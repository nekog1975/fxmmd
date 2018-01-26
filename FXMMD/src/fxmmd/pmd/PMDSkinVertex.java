/**
 *
 */
package fxmmd.pmd;

import fxmmd.Vector3;

/**
 * 表情座標情報です。
 * @author neko爺
 *
 */
public final class PMDSkinVertex {

	private int index;
	private Vector3 pos;

	/**
	 * コンストラクタ
	 * @param index 頂点番号
	 * @param pos 座標
	 */
	public PMDSkinVertex(int index, Vector3 pos) {
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
	public Vector3 getPos() {
		return pos;
	}


}
