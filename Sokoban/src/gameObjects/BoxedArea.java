package gameObjects;

import model.data.point.GeneralIntegerPoint;

public class BoxedArea extends GeneralGameObject {

	private static final long serialVersionUID = 1L;
	
	public BoxedArea()
	{
		super();
	}
	
	public BoxedArea(GeneralIntegerPoint point)
	{
		super(point);
	}

	@Override
	public objectType getType() {
		return objectType.BOXEDAREA;
	}
	
	@Override
	public char getSymbol() {
		return '$';
	}

}
