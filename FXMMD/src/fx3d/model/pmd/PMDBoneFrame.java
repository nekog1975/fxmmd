/**
 *
 */
package fx3d.model.pmd;

/**
 * ボーン枠情報のクラスです
 * @author neko爺
 *
 */
public final class PMDBoneFrame {

	private int index;
	private int frame_index;

	/**
	 * コンストラクタ
	 * @param index 枠用ボーン番号
	 * @param frame_index 表示枠番号
	 */
	public PMDBoneFrame(int index, int frame_index) {

		this.index = index;
		this.frame_index = frame_index;

	}

	/**
	 * @return index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @return frame_index
	 */
	public int getFrame_index() {
		return frame_index;
	}

}
