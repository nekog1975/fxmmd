/**
 *
 */
package fxmmd.pmd;

import fxmmd.Vector2;
import fxmmd.Vector3;

/**
 * 座標情報です。
 * @author neko爺
 *
 */
public final class PMDVertex {

	private Vector3 pos;
	private Vector3 normal;
	private Vector2 uv;
	private int[] bone_no = new int[2];
	private byte bone_weight;
	private byte edge_flag;

	/**
	 * 頂点情報
	 * @param pos 座標
	 * @param normal 法線ベクトル
	 * @param uv UV座標
	 * @param bone_no ボーン番号１、ボーン番号２
	 * @param bone_weight ボーンに与える影響度
	 * @param edge_flag エッジ（輪郭）
	 */
	public PMDVertex(Vector3 pos, Vector3 normal, Vector2 uv, int[] bone_no, byte bone_weight, byte edge_flag) {
		this.pos = pos;
		this.normal = normal;
		this.uv = uv;
		if(bone_no.length != 2) {
			throw new IllegalArgumentException();
		}
		this.bone_no[0] = bone_no[0];
		this.bone_no[1] = bone_no[1];
		this.bone_weight = bone_weight;
		this.edge_flag = edge_flag;
	}

	/**
	 * @return pos
	 */
	public Vector3 getPos() {
		return pos;
	}

	/**
	 * @return normal
	 */
	public Vector3 getNormal() {
		return normal;
	}

	/**
	 * @return uv
	 */
	public Vector2 getUv() {
		return uv;
	}

	/**
	 * @return bone_no
	 */
	public int[] getBone_no() {
		return bone_no;
	}

	/**
	 * @return bone_weight
	 */
	public byte getBone_weight() {
		return bone_weight;
	}

	/**
	 * @return edge_flag
	 */
	public byte getEdge_flag() {
		return edge_flag;
	}


}
