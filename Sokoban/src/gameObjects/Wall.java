package gameObjects;

import model.data.point.GeneralIntegerPoint;

public class Wall extends GeneralGameObject {

	private static final long serialVersionUID = 1L;
	
	public Wall()
	{
		super();
	}
	
	public Wall(GeneralIntegerPoint point)
	{
		super(point);
	}

	@Override
	public objectType getType() {
		return objectType.WALL;
	}
	
	@Override
	public char getSymbol() {
		return '#';
	}
}
