package gameObjects;

import point.GeneralIntegerPoint;

public class Space extends GeneralGameObject {

	private static final long serialVersionUID = -3615622134611243390L;
	
	public Space()
	{
		super();
	}
	
	public Space(GeneralIntegerPoint point)
	{
		super(point);
	}

	@Override
	public objectType getType() {
		return objectType.SPACE;
	}

	@Override
	public char getSymbol() {
		return ' ';
	}
}
