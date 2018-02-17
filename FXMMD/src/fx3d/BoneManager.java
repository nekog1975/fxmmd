/**
 *
 */
package fx3d;

import java.util.List;
import java.util.stream.Collectors;

import fx3d.geometry.Matrix;
import javafx.scene.transform.Affine;

/**
 * @author lg062
 *
 */
public final class BoneManager {

	private List<Bone> bones;

	private static final class SingletonHolder {
		private static final BoneManager instance = new BoneManager();
	}

	private BoneManager() {}

	public static BoneManager getInstance() {
		return SingletonHolder.instance;
	}

	public void init(List<Bone> bones) {
		this.bones = bones;
		relative(bones.get(0), new Matrix());
	}

	public void setMotion(List<Motion> motions) {

		// モーション初期化
		bones.stream().forEach(bone -> bone.setMotion(new Matrix()));

		// モーション設定
		motions.stream().forEach(motion -> {
			bones.get(motion.getBone_no()).setMotion(motion.getTransform());
		});
	}

	public List<Matrix> getCombs(){
		return bones.stream().map(b -> b.getComb()).collect(Collectors.toList());
	}

	public void update() {

		// モーション適用
		bones.stream().forEach(bone -> bone.update());

		// ボーン座標変換
		updateBone(bones.get(0), new Matrix());
	}

	private void updateBone(Bone me, Matrix parent) {
		me.getBone().append(parent);
		me.getChildren().stream().forEach(bone -> updateBone(bone, me.getBone()));
	}

	private void relative(Bone me, Affine parent) {
		me.getChildren().stream().forEach(b -> relative(b, me.getOffset()));
		me.getInit().append(parent);
	}

	/**
	 * @return bones
	 */
	public List<Bone> getBones() {
		return bones;
	}

}
