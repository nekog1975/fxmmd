/**
 *
 */
package fxmmd.fx;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import fxmmd.pmd.PMD;
import fxmmd.pmd.PMDFace;
import fxmmd.pmd.PMDMaterial;
import fxmmd.pmd.PMDVertex;
import fxmmd.vmd.VMD;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;

/**
 * @author lg062
 *
 */
public final class FxMMD {

	// https://qiita.com/JI1LDG/items/7d8f02421dcdc6d83143

	private static final class SingletonHolder{
		private static final FxMMD instance = new FxMMD();
	}

	// ボーンインデックスデータ
	private List<FxBone> bone_index = new ArrayList<FxBone>();

	// モーションフレームデータ
	private List<FxMotionFrame> frames;

	// モデル頂点データ
	private float[] points;

	// モデルテクスチャ頂点データ
	private float[] texcoords;

	// 法線ベクトルデータ
	private float[] normals;

	// モデルビュー
	private List<MeshView> views = new ArrayList<MeshView>();

	/**
	 * コンストラクタ
	 */
	private FxMMD() {}

	/**
	 * インスタンス取得
	 * @return インスタンス
	 */
	public static FxMMD getInstance() { return SingletonHolder.instance; }

	/**
	 * 指定フレーム番号のモーションを実行する
	 * @param frame_no フレーム番号
	 */
	public void updane(Integer frame_no) {

		frames.get(frame_no).getMotions().stream().forEach(motion -> {

		});

	}

	/**
	 * MMDデータの生成
	 * @param pmd モデルデータ
	 * @param vmd モーションデータ
	 * @throws NonInvertibleTransformException ボーンオフセット失敗時
	 */
	public void create(PMD pmd, VMD vmd) throws NonInvertibleTransformException {

		// 頂点データより必要なデータを生成
		points = new float[pmd.getVertexs().size() * 3];
		texcoords = new float[pmd.getVertexs().size() * 2];
		normals = new float[pmd.getVertexs().size() * 3];

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
			meshview.setDrawMode(DrawMode.FILL);

			// 材質設定
			Path path =Paths.get(pmd.getPath().toString(), m.getTexture_name());
			Image image = new Image(path.toUri().toString());
			PhongMaterial pmt = new PhongMaterial(m.getDiffuse().getColor(), image, null, null, null);
			pmt.setSpecularColor(m.getSpecular_color().getColor());
			pmt.setSpecularPower(m.getSpecularity());
			meshview.setMaterial(pmt);

			views.add(meshview);

		}

		// ボーンインデックス生成
		pmd.getBones().stream().forEach(bone -> {

			// ボーン情報生成
			FxBone b;

			try {

				b = new FxBone(bone.getIndex(), bone.getHead_pos());

			} catch (NonInvertibleTransformException e) {

				throw new RuntimeException(e);

			}

			// 子インデックス登録
			pmd.getBones().stream().forEach(child ->{

				if(b.getIndex() == child.getParent_index()) {

					b.getChildren().add(child.getIndex());

				}

			});

			bone_index.add(b);

		});

		// オフセット行列生成
		createOffset(bone_index.get(0), bone_index.get(0).getOffset());

		// ボーン名からボーンのインデックスを取得するマップを作成
		Map<String, Integer> bone_name_map = pmd.getBones().stream().collect(Collectors.toMap(b -> b.getName(), b -> b.getIndex()));

		// モーションフレームの生成
		Map<Integer, FxMotionFrame> map = new TreeMap<Integer, FxMotionFrame>();

		// モーションデータをフレーム番号単位でまとめる
		vmd.getMotions().stream().forEach(motion ->{

			// モデルデータ中のボーン名と一致しないモーションは除外
			if(!bone_name_map.containsKey(motion.getBone_name())) return;

			// モーションフレームの作成とモーションデータの登録
			Integer index = motion.getFrame_no();

			if(!map.containsKey(index)) {

				map.put(index, new FxMotionFrame(index));

			}

			map.get(index).getMotions().add(new FxMotion(
					bone_name_map.get(motion.getBone_name()),
					motion.getLocation(),
					motion.getRotation()
				)
			);

		});

		frames = new ArrayList<>(map.values());

	}

	/**
	 * オフセット行列生成
	 * @param me ボーン情報
	 * @param parent 親のオフセット
	 */
	private void createOffset(FxBone me, Affine parent) {

		me.getChildren().stream().forEach(index -> {
			createOffset(bone_index.get(index), me.getOffset());
		});
		me.getInit().append(parent);

	}

	/**
	 * メッシュビューのリストを作成する
	 * @return メッシュビューのリスト
	 */
	public List<MeshView> getViews(){
		return views;
	}

}
