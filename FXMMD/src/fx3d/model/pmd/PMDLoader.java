/**
 *
 */
package fx3d.model.pmd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import fx3d.geometry.Matrix;
import fx3d.util.ByteUtil;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;

/**
 * PMD形式ファイルを読み込み、PMDクラスを生成します。
 * @author neko爺
 *
 */
public final class PMDLoader {

	/**
	 * PMDデータを読み込む
	 * @param path PMDファイルのパス
	 * @return PMDデータ
	 * @throws IOException ファイル読み込み失敗時や、指定文字コード不正時
	 */
	public static PMD load(Path path) throws IOException {

		Matrix matrix = new Matrix();
		matrix.PMDtoFx();

		int offset = 0;

		// ファイルを読み込む
		byte[] bytes = Files.readAllBytes(path);

		// ヘッダの情報を読み込む
		PMDHeader header;

		header = new PMDHeader(
				ByteUtil.toString(bytes, offset, 3),
				ByteUtil.toFloat(bytes, 3),
				ByteUtil.toString(bytes, 7, 20),
				ByteUtil.toString(bytes, 27, 256)
			);

		// マジックナンバーチェック
		if(!header.getMagic().toLowerCase().equals("pmd")) {
			throw new IOException("Not PMD data format.");
		}

		offset += 283;

		// 頂点情報を読み込む
		List<PMDVertex> vertexs = new ArrayList<PMDVertex>();

		int vertexCount = ByteUtil.toDWInt(bytes, offset);

		offset += 4;

		for(int i=0; i<vertexCount; i++) {

			vertexs.add(new PMDVertex(
						i,
						matrix.transform(new Point3D(ByteUtil.toFloat(bytes, offset), ByteUtil.toFloat(bytes, offset + 4), ByteUtil.toFloat(bytes, offset + 8))),
						matrix.transform(new Point3D(ByteUtil.toFloat(bytes, offset + 12), ByteUtil.toFloat(bytes, offset + 16), ByteUtil.toFloat(bytes, offset + 20))),
						new Point2D(ByteUtil.toFloat(bytes, offset + 24), ByteUtil.toFloat(bytes, offset + 28)),
						ByteUtil.toWIntArray(bytes, offset + 32, 2),
						bytes[offset + 36],
						bytes[offset + 37]
					)
				);

			offset += 38;
		}

		// 面頂点を読み込む
		List<PMDFace> faces = new ArrayList<PMDFace>();

		int faceCount = ByteUtil.toDWInt(bytes, offset) / 3;

		offset += 4;

		for(int i=0; i<faceCount;i++ ) {

			faces.add(new PMDFace(
						ByteUtil.toWIntArray(bytes, offset, 3)
					)
				);

			offset += 6;

		}

		// 材質を読み込む
		List<PMDMaterial> materials = new ArrayList<PMDMaterial>();

		int materialCount = ByteUtil.toDWInt(bytes, offset);

		offset += 4;

		for(int i=0; i<materialCount; i++) {

			materials.add(new PMDMaterial(
						new Rgba(ByteUtil.toFloatArray(bytes, offset, 4)),
						ByteUtil.toFloat(bytes, offset + 16),
						new Rgb(ByteUtil.toFloatArray(bytes, offset + 20, 3)),
						new Rgb(ByteUtil.toFloatArray(bytes, offset + 32, 3)),
						Byte.toUnsignedInt(bytes[offset + 44]),
						bytes[offset + 45],
						ByteUtil.toDWInt(bytes, offset + 46),
						ByteUtil.toString(bytes, offset + 50, 20)
					)
				);

			offset += 70;

		}

		// ボーン情報を読み込む
		List<PMDBone> bones = new ArrayList<PMDBone>();

		int boneCount = ByteUtil.toWInt(bytes, offset);

		offset += 2;

		for(int i=0; i<boneCount; i++) {

			bones.add(new PMDBone(
					i,
					ByteUtil.toString(bytes, offset, 20),
					ByteUtil.toWInt(bytes, offset + 20),
					ByteUtil.toWInt(bytes, offset + 22),
					bytes[offset + 24],
					ByteUtil.toWInt(bytes, offset + 25),
					matrix.transform(new Point3D(ByteUtil.toFloat(bytes, offset + 27), ByteUtil.toFloat(bytes, offset + 31), ByteUtil.toFloat(bytes, offset + 35)))
				)
			);

			offset += 39;
		}

		// IK情報読み込み
		List<PMDIk> iks = new ArrayList<PMDIk>();

		if(offset < bytes.length) {

			int ikCount = ByteUtil.toWInt(bytes, offset);

			offset += 2;

			for(int i=0; i<ikCount; i++) {

				int chainLength = Byte.toUnsignedInt(bytes[offset + 4]);
				iks.add(new PMDIk(
						ByteUtil.toWInt(bytes, offset),
						ByteUtil.toWInt(bytes, offset + 2),
						chainLength,
						ByteUtil.toWInt(bytes, offset + 3),
						ByteUtil.toFloat(bytes, offset + 5),
						ByteUtil.toWIntArray(bytes, offset + 9, chainLength)
					)
				);

				offset += (11 + 2 * chainLength);
			}

		}

		// 表情情報読み込み
		List<PMDSkin> skins = new ArrayList<PMDSkin>();

		if(offset < bytes.length) {

			int skinCount = ByteUtil.toWInt(bytes, offset);

			offset += 2;

			for(int i=0; i<skinCount; i++) {

				List<PMDSkinVertex> skinVertexs = new ArrayList<PMDSkinVertex>();
				int skinVerLength = ByteUtil.toDWInt(bytes, offset + 20);

				for(int j=0; j<skinVerLength; j++) {
					skinVertexs.add(new PMDSkinVertex(
							ByteUtil.toDWInt(bytes, offset + 25 + j * 16),
							matrix.transform(new Point3D(ByteUtil.toFloat(bytes, 25 + j * 16 + 4), ByteUtil.toFloat(bytes, 25 + j * 16 + 8), ByteUtil.toFloat(bytes, 25 + j * 16 + 12)))
						)
					);
				}

				skins.add(new PMDSkin(
						ByteUtil.toString(bytes, offset, 20),
						skinVerLength,
						bytes[offset + 24],
						skinVertexs
					)
				);

				offset += (25 + skinVerLength * 16);
			}

		}

		// 表情枠表示用情報読み込み
		List<Integer> skin_indexs = new ArrayList<Integer>();
		if(offset < bytes.length) {

			int skinIndexCount = Byte.toUnsignedInt(bytes[offset]);

			offset += 1;

			for(int i=0; i<skinIndexCount; i++) {

				skin_indexs.add(ByteUtil.toWInt(bytes, offset));

				offset += 2;

			}

		}

		// ボーン枠用枠名リスト
		List<String> bone_names = new ArrayList<String>();
		if(offset < bytes.length) {

			int boneNameCount = Byte.toUnsignedInt(bytes[offset]);

			offset += 1;

			for(int i=0; i<boneNameCount; i++) {

				bone_names.add(ByteUtil.toString(bytes, offset, 50));

				offset += 50;

			}

		}

		// ボーン枠表示用情報読み込み
		List<PMDBoneFrame> bone_frames = new ArrayList<PMDBoneFrame>();

		if(offset < bytes.length) {

			int boneFrameCount = ByteUtil.toDWInt(bytes, offset);

			offset += 4;

			for(int i=0; i<boneFrameCount; i++) {

				bone_frames.add(new PMDBoneFrame(
						ByteUtil.toWInt(bytes, offset),
						Byte.toUnsignedInt(bytes[offset + 2])
					)
				);

				offset += 3;

			}

		}

		// オブジェクト生成
		return new PMD(
				path,
				header,
				vertexs,
				faces,
				materials,
				bones,
				iks,
				skins,
				skin_indexs,
				bone_names,
				bone_frames
			);

	}

}
