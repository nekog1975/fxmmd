/**
 *
 */
package fxmmd.pmd;

/**
 * IK情報です。
 * @author neko爺
 *
 */
public final class PMDIk {

	private int index;
	private int target_index;
	private int chain_length;
	private int iterations;
	private float control_weight;
	private int[] child_indexs;

	/**
	 * コンストラクタ
	 * @param index IK番号
	 * @param target_index ターゲットボーン番号
	 * @param chain_length チェーンの長さ
	 * @param iterations 再帰演算回数
	 * @param control_weight １演算あたりの制限角度
	 * @param child_indexs 影響下のボーン番号（int配列）
	 */
	public PMDIk(int index, int target_index, int chain_length, int iterations, float control_weight, int[] child_indexs) {
		this.index = index;
		this.target_index = target_index;
		this.chain_length = chain_length;
		this.iterations = iterations;
		this.control_weight = control_weight;
		this.child_indexs = child_indexs;
	}

	/**
	 * @return index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @return target_index
	 */
	public int getTarget_index() {
		return target_index;
	}

	/**
	 * @return chain_length
	 */
	public int getChain_length() {
		return chain_length;
	}

	/**
	 * @return iterations
	 */
	public int getIterations() {
		return iterations;
	}

	/**
	 * @return control_weight
	 */
	public float getControl_weight() {
		return control_weight;
	}

	/**
	 * @return child_indexs
	 */
	public int[] getChild_indexs() {
		return child_indexs;
	}

}
