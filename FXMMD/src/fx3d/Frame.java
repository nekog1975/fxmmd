/**
 *
 */
package fx3d;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lg062
 *
 */
public final class Frame {

	private Integer frame_no;
	private List<Motion> motions = new ArrayList<Motion>();

	public Frame(Integer frame_no) {
		this.frame_no = frame_no;
	}

	/**
	 * @return frame_no
	 */
	public Integer getFrame_no() {
		return frame_no;
	}

	/**
	 * @return motions
	 */
	public List<Motion> getMotions() {
		return motions;
	}

}
