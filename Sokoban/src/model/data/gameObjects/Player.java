package model.data.gameObjects;

import model.data.point.GeneralIntegerPoint;

public class Player extends GeneralGameObject {

	private static final long serialVersionUID = 1L;
	
	public Player()
	{
		super();
	}
	
	public Player(GeneralIntegerPoint point)
	{
		super(point);
	}

	@Override
	public objectType getType() {
		return objectType.PLAYER;
	}
	
	@Override
	public char getSymbol() {
		return 'A';
	}
	
}
