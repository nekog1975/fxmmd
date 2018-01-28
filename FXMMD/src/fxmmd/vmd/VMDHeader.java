/**
 *
 */
package fxmmd.vmd;

/**
 * vmdデータのヘッダです。
 * @author shigeo
 *
 */
public final class VMDHeader {

	private String header;
	private String model_name;

	/**
	 * コンストラクタ
	 * @param header ヘッダー
	 * @param model_name モデル名
	 */
	public VMDHeader(String header, String model_name) {
		this.header = header;
		this.model_name = model_name;
	}

	/**
	 * @return header
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * @return model_name
	 */
	public String getModel_name() {
		return model_name;
	}

}
