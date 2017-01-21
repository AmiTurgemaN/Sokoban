package model.data.gameObjects;

import model.data.point.GeneralIntegerPoint;

public class Box extends GeneralGameObject {

	private static final long serialVersionUID = 1L;
	
	public Box()
	{
		super();
	}
	
	public Box(GeneralIntegerPoint point)
	{
		super(point);
	}

	@Override
	public objectType getType() {
		return objectType.BOX;
	}
	
	public char getSymbol() {
		return '@';
	}
}
