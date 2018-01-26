/**
 *
 */
package fxmmd.pmd;

import java.util.List;

/**
 * 表情情報です。
 * @author neko爺
 *
 */
public final class PMDSkin {

	private String name;
	private int vert_count;
	private byte type;
	private List<PMDSkinVertex> skin_vertexs;

	/**
	 * コンストラクタ
	 * @param name 表情名
	 * @param vert_count 表情頂点情報数
	 * @param type タイプ
	 * @param skin_vertexs 頂点データ
	 */
	public PMDSkin(String name, int vert_count, byte type, List<PMDSkinVertex> skin_vertexs) {
		this.name = name;
		this.vert_count = vert_count;
		this.type = type;
		this.skin_vertexs = skin_vertexs;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return vert_count
	 */
	public int getVert_count() {
		return vert_count;
	}

	/**
	 * @return type
	 */
	public byte getType() {
		return type;
	}

	/**
	 * @return skin_vertexs
	 */
	public List<PMDSkinVertex> getSkin_vertexs() {
		return skin_vertexs;
	}


}
