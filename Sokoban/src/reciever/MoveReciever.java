package reciever;

import commands.Direction;
import gameObjects.GeneralGameObject;
import level.Level;
import point.GeneralIntegerPoint;

public class MoveReciever extends GeneralReciever {

	private Direction direction;
	private Level level;
	private GeneralIntegerPoint playerPoint;

	public GeneralIntegerPoint getPlayerPoint() {
		return playerPoint;
	}

	public void setPlayerPoint(GeneralIntegerPoint playerPoint) {
		this.playerPoint = playerPoint;
	}

	public MoveReciever(Direction direction,Level level,GeneralIntegerPoint playerPoint)
	{
		this.direction=direction;
		this.level=level;
		this.playerPoint=playerPoint;
	}

	public GeneralIntegerPoint getDestinationPoint()
	{
		return playerPoint.getNextPointByDirection(this.direction);
	}

	public GeneralIntegerPoint getBoxNewDestinationPoint()
	{
		return playerPoint.getNextPointByDirection(this.direction).getNextPointByDirection(this.direction);
	}

	public void action()
	{
		GeneralIntegerPoint destPoint = getDestinationPoint();
		GeneralIntegerPoint newDestPoint = getBoxNewDestinationPoint();
		GeneralGameObject sourceObject = level.getObjectByPoint(playerPoint);
		sourceObject.setPoint(playerPoint);
		GeneralGameObject destObject = level.getObjectByPoint(destPoint);
		destObject.setPoint(getDestinationPoint());
		GeneralGameObject boxNewDestObject = level.getObjectByPoint(newDestPoint);
		if(boxNewDestObject!=null)
			boxNewDestObject.setPoint(getBoxNewDestinationPoint());
		if(checkMove(sourceObject,destObject,boxNewDestObject) == true)
			level.updateLevel(sourceObject,destObject,boxNewDestObject);
		else
			System.out.println("Error: Cannot move "+this.direction.toString());
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public boolean checkMove(GeneralGameObject source,GeneralGameObject dest,GeneralGameObject newDest)
	{
		switch(dest.getType())
		{
		case BOX:
		case BOXEDAREA:
			switch(newDest.getType())
			{
			case BOX:
			case PLAYER:
			case AREAPLAYER:
			case BOXEDAREA:
			case WALL:
				return level.getPolicy().pushBlockedBox();
			default:
				return true;
			}
		case PLAYER:
		case AREAPLAYER:
			return false;
		case WALL:
			return level.getPolicy().WalkThroughWall();
		default :
			return true;
		}
	}
}
