/**
 *
 */
package fx3d.motion.vmd;

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
	private List<VMDLight> lights;
	private List<VMDSelfShadow> selfshadows;

	/**
	 * コンストラクタ
	 * @param path パス
	 * @param header ヘッダ情報
	 * @param motions モーション情報
	 * @param skins 表情情報
	 * @param cameras カメラ情報
	 * @param lights 照明情報
	 * @param selfshadows セルフシャドウ情報
	 */
	public VMD(Path path,
				VMDHeader header,
				List<VMDMotion> motions,
				List<VMDSkin> skins,
				List<VMDCamera> cameras,
				List<VMDLight> lights,
				List<VMDSelfShadow> selfshadows
			) {

		this.path = path;
		this.header = header;
		this.motions = motions;
		this.skins = skins;
		this.cameras = cameras;
		this.lights = lights;
		this.selfshadows = selfshadows;

	}

	/**
	 * @return path
	 */
	public Path getPath() {
		return path;
	}

	/**
	 * @return header
	 */
	public VMDHeader getHeader() {
		return header;
	}

	/**
	 * @return motions
	 */
	public List<VMDMotion> getMotions() {
		return motions;
	}

	/**
	 * @return skins
	 */
	public List<VMDSkin> getSkins() {
		return skins;
	}

	/**
	 * @return cameras
	 */
	public List<VMDCamera> getCameras() {
		return cameras;
	}

	/**
	 * @return lights
	 */
	public List<VMDLight> getLights() {
		return lights;
	}

	/**
	 * @return selfshadows
	 */
	public List<VMDSelfShadow> getSelfshadows() {
		return selfshadows;
	}


}
