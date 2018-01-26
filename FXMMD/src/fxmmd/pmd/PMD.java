/**
 *
 */
package fxmmd.pmd;

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
	private int[] skin_indexs;
	private String[] bone_names;
	private List<PMDBoneFrame> bone_frames;

	public PMD(
			Path path,
			PMDHeader header,
			List<PMDVertex> vertexs,
			List<PMDFace> faces,
			List<PMDMaterial> materials,
			List<PMDBone> bones,
			List<PMDIk> iks,
			List<PMDSkin> skins,
			int[] skin_indexs,
			String[] bone_names,
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
	public int[] getSkin_indexs() {
		return skin_indexs;
	}

	/**
	 * @return bone_names
	 */
	public String[] getBone_names() {
		return bone_names;
	}

	/**
	 * @return bone_frames
	 */
	public List<PMDBoneFrame> getBone_frames() {
		return bone_frames;
	}

}
