/**
 *
 */
package fxmmd.vmd;

import java.util.List;

/**
 * フレーム単位のモーションデータです。
 * @author neko爺
 *
 */
public final class VMDFrame {

	private int frame_no;
	private List<VMDMotion> motions;

	/**
	 * コンストラクタ
	 * @param framae_no フレーム番号
	 * @param motions モーションデータ
	 */
	public VMDFrame(int framae_no, List<VMDMotion> motions) {

		this.frame_no = framae_no;
		this.motions = motions;

	}

	/**
	 * @return frame_no
	 */
	public int getFrame_no() {
		return frame_no;
	}

	/**
	 * @return motions
	 */
	public List<VMDMotion> getMotions() {
		return motions;
	}

}
