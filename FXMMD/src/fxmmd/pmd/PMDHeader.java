/**
 *
 */
package fxmmd.pmd;

/**
 * ヘッダ情報です。
 * @author neko爺
 *
 */
public final class PMDHeader {

	private String magic;
	private float version;
	private String model_name;
	private String comment;

	/**
	 * PMDヘッダ
	 * @param magic マジックナンバー
	 * @param version バージョン
	 * @param model_name モデル名
	 * @param comment コメント
	 */
	public PMDHeader(String magic, float version, String model_name, String comment){
		this.magic = magic;
		this.version = version;
		this.model_name = model_name;
		this.comment = comment;
	}

	/**
	 * マジックナンバーを取得する
	 * @return マジックナンバー
	 */
	public String getMagic() {

		return magic;

	}

	/**
	 * バージョンを取得する
	 * @return バージョン
	 */
	public float getVersion() {

		return version;

	}

	/**
	 * モデル名を取得する
	 * @return モデル名
	 */
	public String getModel_name() {

		return model_name;

	}

	/**
	 * コメントを取得する
	 * @return コメントt
	 */
	public String getComment() {

		return comment;

	}

}
