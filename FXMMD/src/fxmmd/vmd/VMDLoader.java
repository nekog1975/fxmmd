/**
 *
 */
package fxmmd.vmd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import fxmmd.Vector3;
import fxmmd.Vector4;
import fxmmd.common.util.ByteUtil;

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

		int offset = 0;

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

		List<VMDMotion> motions = new ArrayList<VMDMotion>();
		for(int i=0; i<motionCount; i++) {

			motions.add(new VMDMotion(
					ByteUtil.toString(bytes, offset, 15),
					ByteUtil.toDWInt(bytes, offset + 15),
					new Vector3(ByteUtil.toFloatArray(bytes, offset + 19, 3)),
					new Vector4(ByteUtil.toFloatArray(bytes, offset + 31, 3)),
					ByteUtil.toUByteArray(bytes, offset + 47 , 64)
				)
			);

			offset += 111;

		}

		// 表情情報を読み込む
		List<VMDSkin> skins = new ArrayList<VMDSkin>();

		// カメラ情報を読み込む
		List<VMDCamera> cameras = new ArrayList<VMDCamera>();

		// 照明情報を読み込む
		List<VMDLight> lights = new ArrayList<VMDLight>();

		// セルフシャドウ情報を読み込む
		List<VMDSelfShadow> selfshadows = new ArrayList<VMDSelfShadow>();

		// VMDクラス生成
		return new VMD(path, header, motions, skins, cameras, lights, selfshadows);

	}

}
