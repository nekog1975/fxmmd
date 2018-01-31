/**
 *
 */
package test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import fxmmd.pmd.PMD;
import fxmmd.pmd.PMDConverter;
import fxmmd.pmd.PMDLoader;
import fxmmd.vmd.VMD;
import fxmmd.vmd.VMDConverter;
import fxmmd.vmd.VMDFrame;
import fxmmd.vmd.VMDLoader;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.LightBase;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Affine;
import javafx.stage.Stage;

/**
 * @author neko爺
 *
 */
public class TestMain extends Application{

	@Override
	public void start(Stage primaryStage) throws IOException {

		Group root = new Group();
		Scene scene = new Scene(root,1000,600,true);
		scene.setFill(Paint.valueOf("blue"));

		PMD pmd = PMDLoader.load(Paths.get("C:\\Users\\lg062\\Desktop\\sakai\\pmd\\社蓄ちゃん\\社畜ちゃんVer.2.1.pmd"));

		List<MeshView> meshes = PMDConverter.convert(pmd);

		VMD vmd = VMDLoader.load(Paths.get("C:\\Users\\lg062\\Desktop\\sakai\\キネクトサンプルデータ_vol_005\\恋の2-4-11_多段結合_那珂ちゃん用.vmd"));

		List<VMDFrame> frames = VMDConverter.convertMotion(vmd);

		// フレーム0を設定
		Affine af = new Affine(
				1,  0,  0,  2,
				0, -1,  0,  2,
				0,  0,  1,  2
			);

		Point3D pt = new Point3D(1, 1, 1);

		System.out.println(af.transform(pt));

//		root.getChildren().addAll(meshes);

		// カメラ設定
		PerspectiveCamera   camera  = new PerspectiveCamera( true );
		camera.setFarClip( 300 );
		camera.setTranslateY( -10 );
		camera.setTranslateZ( -60 );
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
