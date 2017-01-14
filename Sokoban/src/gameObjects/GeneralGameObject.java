package gameObjects;

import java.io.Serializable;

import point.*;

public abstract class GeneralGameObject implements Serializable, gameObject {

	private static final long serialVersionUID = -3615622134611243390L;
	protected GeneralIntegerPoint point;
	
	public GeneralIntegerPoint getPoint() {
		return point;
	}
	public void setPoint(GeneralIntegerPoint point) {
		this.point=point;
	}
	public abstract objectType getType();
	
	public GeneralGameObject(GeneralIntegerPoint point) {
		super();
		this.point = point;
	}
	public GeneralGameObject() {
		super();
	}
	public abstract char getSymbol();
}
