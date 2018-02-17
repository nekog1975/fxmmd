/**
 *
 */
package fx3d.model.pmd;

import java.nio.file.Path;
import java.util.List;

/**
 * PMD形式のファイルから読み込んだデータを展開したクラスです。
 * @author neko爺
 *
 */
public final class PMD {

	private Path path;
	private PMDHeader header;
	private List<PMDVertex> vertexs;
	private List<PMDFace> faces;
	private List<PMDMaterial> materials;
	private List<PMDBone> bones;
	private List<PMDIk> iks;
	private List<PMDSkin> skins;
	private List<Integer> skin_indexs;
	private List<String> bone_names;
	private List<PMDBoneFrame> bone_frames;

	/**
	 * コンストラクタ
	 * @param path フォルダパス
	 * @param header ヘッダー
	 * @param vertexs 頂点情報
	 * @param faces 面情報
	 * @param materials 材質情報
	 * @param bones ボーン情報
	 * @param iks IK情報
	 * @param skins 表情情報
	 * @param skin_indexs 表情表示情報
	 * @param bone_names ボーン名情報
	 * @param bone_frames ボーン枠名情報
	 */
	public PMD(
			Path path,
			PMDHeader header,
			List<PMDVertex> vertexs,
			List<PMDFace> faces,
			List<PMDMaterial> materials,
			List<PMDBone> bones,
			List<PMDIk> iks,
			List<PMDSkin> skins,
			List<Integer> skin_indexs,
			List<String> bone_names,
			List<PMDBoneFrame> bone_frames
		) {

		this.path = path.getParent();
		this.header = header;
		this.vertexs = vertexs;
		this.faces = faces;
		this.materials = materials;
		this.bones = bones;
		this.iks = iks;
		this.skins = skins;
		this.skin_indexs = skin_indexs;
		this.bone_names = bone_names;
		this.bone_frames = bone_frames;

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
	public PMDHeader getHeader() {
		return header;
	}

	/**
	 * @return vertexs
	 */
	public List<PMDVertex> getVertexs() {
		return vertexs;
	}

	/**
	 * @return faces
	 */
	public List<PMDFace> getFaces() {
		return faces;
	}

	/**
	 * @return materials
	 */
	public List<PMDMaterial> getMaterials() {
		return materials;
	}

	/**
	 * @return bones
	 */
	public List<PMDBone> getBones() {
		return bones;
	}

	/**
	 * @return iks
	 */
	public List<PMDIk> getIks() {
		return iks;
	}

	/**
	 * @return skins
	 */
	public List<PMDSkin> getSkins() {
		return skins;
	}

	/**
	 * @return skin_indexs
	 */
	public List<Integer> getSkin_indexs() {
		return skin_indexs;
	}

	/**
	 * @return bone_names
	 */
	public List<String> getBone_names() {
		return bone_names;
	}

	/**
	 * @return bone_frames
	 */
	public List<PMDBoneFrame> getBone_frames() {
		return bone_frames;
	}

}
