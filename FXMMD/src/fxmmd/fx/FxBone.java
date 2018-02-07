/**
 *
 */
package fxmmd.fx;

import java.util.ArrayList;
import java.util.List;

import fxmmd.common.util.PointUtil;
import fxmmd.common.util.PointUtil.MATRIX;
import javafx.geometry.Point3D;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;

/**
 * @author lg062
 *
 */
public final class FxBone {

	private Integer index;
	private List<Integer> children = new ArrayList<Integer>();
	private Affine init = PointUtil.create4DAffine(MATRIX.NORMAL);
	private Affine offset;

	public FxBone(Integer index, Point3D pos) throws NonInvertibleTransformException {

		this.index = index;
		this.init.appendTranslation(pos.getX(), pos.getY(), pos.getZ());
		this.offset = this.init.clone();
		this.offset.invert();

	}

	/**
	 * @return index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * @return children
	 */
	public List<Integer> getChildren() {
		return children;
	}

	/**
	 * @return init
	 */
	public Affine getInit() {
		return init;
	}

	/**
	 * @param init セットする init
	 */
	public void setInit(Affine init) {
		this.init = init;
	}

	/**
	 * @return offset
	 */
	public Affine getOffset() {
		return offset;
	}

	/**
	 * @param offset セットする offset
	 */
	public void setOffset(Affine offset) {
		this.offset = offset;
	}

}
