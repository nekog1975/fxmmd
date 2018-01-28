/**
 *
 */
package fxmmd.vmd;

import java.nio.file.Path;
import java.util.List;

/**
 * vmdデータを読み込んで展開したクラスです。
 * @author neko爺
 *
 */
public final class VMD {

	private Path path;
	private VMDHeader header;
	private List<VMDMotion> motions;
	private List<VMDSkin> skins;
	private List<VMDCamera> cameras;

	public VMD(Path path,
				VMDHeader header,
				List<VMDMotion> motions,
				List<VMDSkin> skins,
				List<VMDCamera> cameras
			) {

		this.path = path;
		this.header = header;
		this.motions = motions;
		this.skins = skins;
		this.cameras = cameras;

	}

}
