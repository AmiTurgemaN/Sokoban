package gameObjects;

import point.GeneralIntegerPoint;

public class Box extends GeneralGameObject {

	private static final long serialVersionUID = -3615622134611243390L;
	
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
