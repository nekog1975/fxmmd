/**
 *
 */
package fxmmd.vmd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import fxmmd.Point4D;
import fxmmd.Rgb;
import fxmmd.common.util.ByteUtil;
import javafx.geometry.Point3D;
import javafx.scene.transform.Affine;

/**
 * VMD形式ファイルを読み込み、VMDクラスを生成します。
 * @author neko爺
 *
 */
public final class VMDLoader {

	/**
	 * VMDデータを読み込む
	 * @param path VMDファイルのパス
	 * @return PMDデータ
	 * @throws IOException ファイル読み込み失敗時や、指定文字コード不正時
	 */
	public static VMD load(Path path) throws IOException {

		Affine affine = new Affine(
				1,  0,  0,  0,
				0, -1,  0,  0,
				0,  0,  1,  0
			);

		int offset = 0;
		List<VMDMotion> motions = new ArrayList<VMDMotion>();
		List<VMDSkin> skins = new ArrayList<VMDSkin>();
		List<VMDCamera> cameras = new ArrayList<VMDCamera>();
		List<VMDLight> lights = new ArrayList<VMDLight>();
		List<VMDSelfShadow> selfshadows = new ArrayList<VMDSelfShadow>();

		// ファイルを読み込む
		byte[] bytes = Files.readAllBytes(path);

		// ヘッダ
		VMDHeader header = new VMDHeader(
				ByteUtil.toString(bytes, 0, 30),
				ByteUtil.toString(bytes, 30, 20)
			);

		offset += 50;

		// モーション情報を読み込む
		int motionCount = ByteUtil.toDWInt(bytes, offset);

		offset += 4;

		for(int i=0; i<motionCount; i++) {

			motions.add(new VMDMotion(
					ByteUtil.toString(bytes, offset, 15),
					ByteUtil.toDWInt(bytes, offset + 15),
					affine.transform(new Point3D(ByteUtil.toFloat(bytes, offset + 19), ByteUtil.toFloat(bytes, offset + 23), ByteUtil.toFloat(bytes, offset + 27))),
					new Point4D(ByteUtil.toFloatArray(bytes, offset + 31, 4)),
					ByteUtil.toUByteArray(bytes, offset + 47 , 64)
				)
			);

			offset += 111;

		}

		// 表情情報を読み込む
		if(offset < bytes.length) {

			int skinCount = ByteUtil.toDWInt(bytes, offset);

			offset += 4;

			for(int i=0; i<skinCount; i++) {

				skins.add(new VMDSkin(
						ByteUtil.toString(bytes, offset, 15),
						ByteUtil.toDWInt(bytes, offset + 15),
						ByteUtil.toFloat(bytes, offset + 19)
					)
				);

				offset += 23;

			}

		}

		// カメラ情報を読み込む
		if(offset < bytes.length) {

			int cameraCount = ByteUtil.toDWInt(bytes, offset);

			offset += 4;

			for(int i=0; i<cameraCount; i++) {

				cameras.add(new VMDCamera(
						ByteUtil.toDWInt(bytes, offset),
						ByteUtil.toFloat(bytes, offset + 4),
						affine.transform(new Point3D(ByteUtil.toFloat(bytes, offset + 8), ByteUtil.toFloat(bytes, offset + 12), ByteUtil.toFloat(bytes, offset + 16))),
						affine.transform(new Point3D(ByteUtil.toFloat(bytes, offset + 20), ByteUtil.toFloat(bytes, offset + 24), ByteUtil.toFloat(bytes, offset + 28))),
						ByteUtil.toUByteArray(bytes, offset + 32, 24),
						ByteUtil.toDWInt(bytes, offset + 56),
						bytes[offset + 60]
					)
				);

				offset += 61;

			}

		}

		// 照明情報を読み込む
		if(offset < bytes.length) {

			int lightCount = ByteUtil.toDWInt(bytes, offset);

			offset += 4;

			for(int i=0; i<lightCount; i++) {

				lights.add(new VMDLight(
						ByteUtil.toDWInt(bytes, offset),
						new Rgb(ByteUtil.toFloatArray(bytes, offset + 4, 3)),
						affine.transform(new Point3D(ByteUtil.toFloat(bytes, offset + 16), ByteUtil.toFloat(bytes, offset + 20), ByteUtil.toFloat(bytes, offset + 24)))
					)
				);

				offset += 28;

			}

		}

		// セルフシャドウ情報を読み込む
		if(offset < bytes.length) {

			int selfshadowCount = ByteUtil.toDWInt(bytes, offset);

			offset += 4;

			for(int i=0; i<selfshadowCount; i++) {

				selfshadows.add(new VMDSelfShadow(
						ByteUtil.toDWInt(bytes, offset),
						bytes[offset + 4],
						ByteUtil.toFloat(bytes, offset + 5)
					)
				);

				offset += 9;

			}

		}

		// VMDクラス生成
		return new VMD(path, header, motions, skins, cameras, lights, selfshadows);

	}

}
