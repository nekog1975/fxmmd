/**
 *
 */
package fxmmd.vmd;

/**
 * セルフシャドウのデータです。
 * @author shigeo
 *
 */
public final class VMDSelfShadow {

	private int frame_no;
	private byte mode;
	private float distance;

	/**
	 * コンストラクタ
	 * @param frame_no フレーム番号
	 * @param mode モード
	 * @param distance 距離
	 */
	public VMDSelfShadow(int frame_no, byte mode, float distance) {

		this.frame_no = frame_no;
		this.mode = mode;
		this.distance = distance;

	}

	/**
	 * @return frame_no
	 */
	public int getFrame_no() {
		return frame_no;
	}

	/**
	 * @return mode
	 */
	public byte getMode() {
		return mode;
	}

	/**
	 * @return distance
	 */
	public float getDistance() {
		return distance;
	}


}
