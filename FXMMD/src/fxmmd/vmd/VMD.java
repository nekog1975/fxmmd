/**
 *
 */
package fxmmd.vmd;

import java.nio.file.Path;
import java.util.List;

/**
 * vmdデータを読み込んで展開したクラスです。
 * @author shigeo
 *
 */
public final class VMD {

	private Path path;
	private VMDHeader header;
	private int data_count;
	private List<VMDMotion> motions;

	public VMD(Path path,
				VMDHeader header,
				int data_count,
				List<VMDMotion> motions
			) {
		this.path = path;
		this.header = header;
		this.data_count = data_count;
		this.motions = motions;
	}

}
