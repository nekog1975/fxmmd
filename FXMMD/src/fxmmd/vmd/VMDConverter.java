/**
 *
 */
package fxmmd.vmd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author neko爺
 *
 */
public final class VMDConverter {

	/**
	 * モーションデータからフレーム単位のデータを取得する
	 * @param vmd モーションデータ
	 * @return フレーム単位データのリスト
	 */
	public static List<VMDFrame> convertMotion(VMD vmd) {

		Map<Integer, VMDFrame> framemap = new HashMap<Integer, VMDFrame>();

		// モーションデータをフレーム毎に設定
		try(Stream<VMDMotion> motionstream = vmd.getMotions().stream()){
			motionstream.forEach(m -> {
				Integer frame_no = Integer.valueOf(m.getFrame_no());
				if(framemap.containsKey(frame_no)) {
					framemap.get(frame_no).getMotions().add(m);
				}else {
					framemap.put(frame_no, new VMDFrame(frame_no.intValue(), new ArrayList<VMDMotion>()));
				}
			});
		}

		return new ArrayList<VMDFrame>(framemap.values());

	}

}
