/**
 *
 */
package fxmmd.fx;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shigeo
 *
 */
public final class FxMotionFrame {

	private Integer franme_no;
	private List<FxMotion> motions = new ArrayList<FxMotion>();

	public FxMotionFrame(Integer frame_no) {

		this.franme_no = frame_no;

	}

	/**
	 * @return franme_no
	 */
	public Integer getFranme_no() {
		return franme_no;
	}

	/**
	 * @return motions
	 */
	public List<FxMotion> getMotions() {
		return motions;
	}

}
