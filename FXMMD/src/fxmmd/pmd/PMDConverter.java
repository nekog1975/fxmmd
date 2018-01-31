/**
 *
 */
package fxmmd.pmd;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

/**
 * PMDクラスからJavaFXで使用するMeshViewに変換するクラスです。
 * @author neko爺
 *
 */
public final class PMDConverter {

	/**
	 * PMDデータをJavaFXのMeshViewに変換する
	 * @param pmd pmdデータ
	 * @return MeshViewのリスト
	 */
	public static List<MeshView> convert(PMD pmd){
		return convert(pmd, DrawMode.FILL);
	}

	/**
	 * PMDデータをJavaFXのMeshViewに変換する
	 * @param pmd pmdデータ
	 * @param mode 描画モード
	 * @return MeshViewのリスト
	 */
	public static List<MeshView> convert(PMD pmd, DrawMode mode){
		List<MeshView> meshviews = new ArrayList<MeshView>();


		// 頂点データより必要なデータを生成
		float[] points = new float[pmd.getVertexs().size() * 3];
		float[] texcoords = new float[pmd.getVertexs().size() * 2];
		float[] normals = new float[pmd.getVertexs().size() * 3];

		for(int i=0; i<pmd.getVertexs().size(); i++) {
			PMDVertex v = pmd.getVertexs().get(i);

			points[i * 3] = (float)v.getPos().getX();
			points[i * 3 + 1] = (float)v.getPos().getY();
			points[i * 3 + 2] = (float)v.getPos().getZ();
			texcoords[i * 2] = (float)v.getUv().getX();
			texcoords[i * 2 + 1] = (float)v.getUv().getY();
			normals[i * 3] = (float)v.getNormal().getX();
			normals[i * 3 + 1] = (float)v.getNormal().getY();
			normals[i * 3 + 2] = (float)v.getNormal().getZ();

		}



		// 材質を基準に生成
		int surfecCount = 0;
		for(PMDMaterial m : pmd.getMaterials()) {

			TriangleMesh mesh = new TriangleMesh();

			// 頂点情報
			mesh.getPoints().addAll(points);
			mesh.getTexCoords().addAll(texcoords);
			mesh.getNormals().addAll(normals);

			// 面情報
			int surfeces = m.getSurface_count() / 3;
			for(int i=surfecCount; i<surfecCount + surfeces; i++) {
				PMDFace s = pmd.getFaces().get(i);
				mesh.getFaces().addAll(s.getP0(), s.getP0(), s.getP1(), s.getP1(), s.getP2(), s.getP2());
				mesh.getFaceSmoothingGroups().addAll(16);
			}
			surfecCount += surfeces;

			// Mesh設定
			MeshView meshview = new MeshView(mesh);
			meshview.setCullFace(CullFace.NONE);

			// 材質設定
			if(mode == DrawMode.FILL) {
				Path path =Paths.get(pmd.getPath().toString(), m.getTexture_name());
				Image image = new Image(path.toUri().toString());
				PhongMaterial pmt = new PhongMaterial(m.getDiffuse().getColor(), image, null, null, null);
				pmt.setSpecularColor(m.getSpecular_color().getColor());
				pmt.setSpecularPower(m.getSpecularity());
				meshview.setMaterial(pmt);
			}


			// 描画モード
			meshview.setDrawMode(mode);

			meshviews.add(meshview);
		}


		return meshviews;
	}


}
