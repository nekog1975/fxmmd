/**
 *
 */
package fxmmd.vmd;

/**
 * 表情データです。
 * @author neko爺
 *
 */
public final class VMDSkin {

	private String skin_name;
	private int franme_no;
	private float weight;

	/**
	 * コンストラクタ
	 * @param skin_name 表情名
	 * @param frame_no フレーム番号
	 * @param weight 表情の設定値
	 */
	public VMDSkin(String skin_name, int frame_no, float weight) {

		this.skin_name = skin_name;
		this.franme_no = frame_no;
		this.weight = weight;

	}

	/**
	 * @return skin_name
	 */
	public String getSkin_name() {
		return skin_name;
	}

	/**
	 * @return franme_no
	 */
	public int getFranme_no() {
		return franme_no;
	}

	/**
	 * @return weight
	 */
	public float getWeight() {
		return weight;
	}


}
