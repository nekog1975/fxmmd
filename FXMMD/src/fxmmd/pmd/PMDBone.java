/**
 *
 */
package fxmmd.pmd;

import javafx.geometry.Point3D;

/**
 * ボーン情報のクラスです。
 * @author neko爺
 *
 */
public final class PMDBone {

	private int index;
	private String name;
	private int parent_index;
	private int tail_pos_index;
	private byte type;
	private int ik_parent_index;
	private Point3D head_pos;

	/**
	 * コンストラクタ
	 * @param index インデックス
	 * @param name ボーン名
	 * @param parent_index 親ボーン番号
	 * @param tail_pos_index tail位置のボーン番号
	 * @param type タイプ
	 * @param ik_parent_index IKボーン番号
	 * @param head_pos ボーンのヘッドの位置
	 */
	public PMDBone(int index, String name, int parent_index, int tail_pos_index, byte type, int ik_parent_index, Point3D head_pos) {

		this.index = index;
		this.name = name;
		this.parent_index = parent_index;
		this.tail_pos_index = tail_pos_index;
		this.type = type;
		this.ik_parent_index = ik_parent_index;
		this.head_pos = head_pos;

	}

	/**
	 * @return index
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return parent_index
	 */
	public int getParent_index() {
		return parent_index;
	}

	/**
	 * @return tail_pos_index
	 */
	public int getTail_pos_index() {
		return tail_pos_index;
	}

	/**
	 * @return type
	 */
	public byte getType() {
		return type;
	}

	/**
	 * @return ik_parent_index
	 */
	public int getIk_parent_index() {
		return ik_parent_index;
	}

	/**
	 * @return head_pos
	 */
	public Point3D getHead_pos() {
		return head_pos;
	}

}
