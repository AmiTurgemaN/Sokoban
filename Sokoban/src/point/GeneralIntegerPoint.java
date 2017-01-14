package point;

import java.io.Serializable;

import commands.Direction;

public abstract class GeneralIntegerPoint implements Serializable,Comparable<GeneralIntegerPoint>{

	private static final long serialVersionUID = -3615622134611243390L;
	
	protected int x;
	protected int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public abstract GeneralIntegerPoint getNextPointByDirection(Direction direction);
}
