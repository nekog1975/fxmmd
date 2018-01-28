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
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.LightBase;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.shape.MeshView;
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

		// PMD読み込み
		PMD pmd = PMDLoader.load(Paths.get("D:\\mmd\\（PMD_FBX）社畜ちゃんVer.2.1\\影書き込みVer\\PMD\\社畜ちゃんVer.2.1.pmd"));

		// メッシュ作成
		List<MeshView> meshes = PMDConverter.convert(pmd);

		// Groupにメッシュを追加
		root.getChildren().addAll(meshes);

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
