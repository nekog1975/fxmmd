/**
 *
 */
package fx3d;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shigeo
 *
 */
public final class FrameManager {

	private List<Frame> frames = new ArrayList<Frame>();

	private static final class SingletonHolder {
		private static final FrameManager instance = new FrameManager();
	}

	private FrameManager() {}

	public static FrameManager getInstance() {
		return SingletonHolder.instance;
	}

	public void init(List<Frame> frames) {

		this.frames = frames;

	}

}
