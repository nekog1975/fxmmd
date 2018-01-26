/**
 *
 */
package fxmmd.pmd;

import fxmmd.Rgb;
import fxmmd.Rgba;

/**
 * 材質情報です。
 * @author neko爺
 *
 */
public final class PMDMaterial {

	private Rgba diffuse;
	private float specularity;
	private Rgb specular_color;
	private Rgb mirror_color;
	private int toon_index;
	private byte edge_flag;
	private int surface_count;
	private String texture_name;

	/**
	 * コンストラクタ
	 * @param diffuse 減衰色
	 * @param specularity 反射強度
	 * @param specular_color 反射色
	 * @param mirror_color 環境色
	 * @param toon_index トーン番号
	 * @param edge_flag エッジ有無
	 * @param surface_count 面頂点数
	 * @param texture_name テクスチャファイル名
	 */
	public PMDMaterial(Rgba diffuse, float specularity, Rgb specular_color, Rgb mirror_color,
			int toon_index, byte edge_flag, int surface_count, String texture_name) {

		this.diffuse = diffuse;
		this.specularity = specularity;
		this.specular_color = specular_color;
		this.mirror_color = mirror_color;
		this.toon_index = toon_index;
		this.edge_flag = edge_flag;
		this.surface_count = surface_count;
		this.texture_name = texture_name;

	}

	/**
	 * @return diffuse
	 */
	public Rgba getDiffuse() {
		return diffuse;
	}

	/**
	 * @return specularity
	 */
	public float getSpecularity() {
		return specularity;
	}

	/**
	 * @return specular_color
	 */
	public Rgb getSpecular_color() {
		return specular_color;
	}

	/**
	 * @return mirror_color
	 */
	public Rgb getMirror_color() {
		return mirror_color;
	}

	/**
	 * @return toon_index
	 */
	public int getToon_index() {
		return toon_index;
	}

	/**
	 * @return edge_flag
	 */
	public byte getEdge_flag() {
		return edge_flag;
	}

	/**
	 * @return surface_count
	 */
	public int getSurface_count() {
		return surface_count;
	}

	/**
	 * @return texture_name
	 */
	public String getTexture_name() {
		return texture_name;
	}



}
