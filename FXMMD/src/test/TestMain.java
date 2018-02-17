/**
 *
 */
package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fx3d.Bone;
import fx3d.BoneManager;
import fx3d.Frame;
import fx3d.Motion;
import fx3d.geometry.Quat4;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.LightBase;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.stage.Stage;

/**
 * @author neko爺
 *
 */
public class TestMain extends Application{


	@Override
	public void start(Stage primaryStage) throws IOException, NonInvertibleTransformException {

		Group root = new Group();
		Scene scene = new Scene(root,1000,600,true);
		scene.setFill(Paint.valueOf("blue"));

//		PMD pmd = PMDLoader.load(Paths.get("C:\\tools\\mmd\\PMD\\syachiku_chan.pmd"));
//		VMD vmd = VMDLoader.load(Paths.get("C:\\tools\\mmd\\nakachan.vmd"));


		List<Bone> bones = new ArrayList<Bone>() {
			{add(new Bone(0, new Point3D( 0,  0, 0)));}
			{add(new Bone(0, new Point3D( 0, -2, 0)));}
			{add(new Bone(0, new Point3D( 0, -4, 0)));}
		};

		bones.get(0).getChildren().add(bones.get(1));
		bones.get(1).getChildren().add(bones.get(2));
		bones.get(1).setParent(bones.get(0));
		bones.get(2).setParent(bones.get(1));

		// ボーンデータ作成
		BoneManager.getInstance().init(bones);

		// ボーンを動かす
		List<Frame> frames = new ArrayList<Frame>() {
			{add(new Frame(0));}
		};
		frames.get(0).getMotions().add(new Motion(
				1,
				new Point3D(0, 0, 0),
				new Quat4(0, 0, -0.5f, 0.4f)
			)
		);

		BoneManager.getInstance().setMotion(frames.get(0).getMotions());

		BoneManager.getInstance().getCombs();

		// カメラ設定
		PerspectiveCamera   camera  = new PerspectiveCamera( true );
		camera.setFarClip( 300 );
		camera.setTranslateY( -10 );
		camera.setTranslateZ( -50 );
		scene.setCamera( camera );

		// 光源設定
		LightBase   light       = new PointLight();
		light.setTranslateY(-20);
		light.setTranslateZ( -50 );
		root.getChildren().add( light );

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
