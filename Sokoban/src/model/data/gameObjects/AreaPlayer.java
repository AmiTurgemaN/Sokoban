package model.data.gameObjects;

import model.data.point.GeneralIntegerPoint;

public class AreaPlayer extends GeneralGameObject {

	private static final long serialVersionUID = 1L;
	
	public AreaPlayer()
	{
		super();
	}
	
	public AreaPlayer(GeneralIntegerPoint point)
	{
		super(point);
	}

	@Override
	public objectType getType() {
		return objectType.AREAPLAYER;
	}
	
	@Override
	public char getSymbol() {
		return 'B';
	}

}
