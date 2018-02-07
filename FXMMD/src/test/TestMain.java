/**
 *
 */
package test;

import java.io.IOException;
import java.nio.file.Paths;

import fxmmd.fx.FxMMD;
import fxmmd.pmd.PMDLoader;
import fxmmd.vmd.VMDLoader;
import javafx.application.Application;
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

		FxMMD.getInstance().create(
				PMDLoader.load(Paths.get("D:\\mmd\\PMD\\pmd.pmd")),
				VMDLoader.load(Paths.get("D:\\mmd\\nakachan.vmd"))
//				PMDLoader.load(Paths.get("C:\\tools\\mmd\\PMD\\syachiku_chan.pmd")),
//				VMDLoader.load(Paths.get("C:\\tools\\mmd\\nakachan.vmd"))
		);

		root.getChildren().addAll(FxMMD.getInstance().getViews());

		// カメラ設定
		PerspectiveCamera   camera  = new PerspectiveCamera( true );
		camera.setFarClip( 300 );
		camera.setTranslateY( 10 );
		camera.setTranslateZ( -70 );
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
