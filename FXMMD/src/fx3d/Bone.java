/**
 *
 */
package fx3d;

import java.util.ArrayList;
import java.util.List;

import fx3d.geometry.Matrix;
import javafx.geometry.Point3D;
import javafx.scene.transform.NonInvertibleTransformException;

/**
 * @author lg062
 *
 */
public final class Bone {

	private Integer index;
	private Bone parent;
	private List<Bone> children = new ArrayList<Bone>();
	private Matrix init;
	private Matrix offset;
	private Matrix bone;
	private Matrix motion;
	private Matrix comb;

	public Bone(Integer index, Point3D pos) throws NonInvertibleTransformException {

		this.index = index;
		this.init= Matrix.translate(pos);
		this.offset= Matrix.translate(pos);
		this.offset.invert();
		this.bone = new Matrix();
		this.motion = new Matrix();

	}

	public void update() {
		bone.append(motion);
		bone.append(init);
		comb = new Matrix();
		comb.append(offset);
		comb.append(bone);
	}

	/**
	 * @return index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * @param index セットする index
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}

	/**
	 * @return parent
	 */
	public Bone getParent() {
		return parent;
	}

	/**
	 * @param parent セットする parent
	 */
	public void setParent(Bone parent) {
		this.parent = parent;
	}

	/**
	 * @return children
	 */
	public List<Bone> getChildren() {
		return children;
	}

	/**
	 * @return init
	 */
	public Matrix getInit() {
		return init;
	}

	/**
	 * @return offset
	 */
	public Matrix getOffset() {
		return offset;
	}

	/**
	 * @return bone
	 */
	public Matrix getBone() {
		return bone;
	}

	/**
	 * @return motion
	 */
	public Matrix getMotion() {
		return motion;
	}

	/**
	 * @param motion セットする motion
	 */
	public void setMotion(Matrix motion) {
		this.motion = motion;
	}

	/**
	 * @return comb
	 */
	public Matrix getComb() {
		return comb;
	}

}
