package model.receiver;

import controller.commands.Direction;
import gameObjects.GeneralGameObject;
import model.Model;
import model.data.point.GeneralIntegerPoint;

public class MoveReceiver extends GeneralReceiver {

	private Direction direction;
	private GeneralIntegerPoint playerPoint;
	private Model model;

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public GeneralIntegerPoint getPlayerPoint() {
		return playerPoint;
	}

	public void setPlayerPoint(GeneralIntegerPoint playerPoint) {
		this.playerPoint = playerPoint;
	}

	public MoveReceiver(Direction direction,GeneralIntegerPoint playerPoint)
	{
		this.direction=direction;
		this.playerPoint=playerPoint;
	}

	public MoveReceiver(Direction direction, Model model) {
		this.direction=direction;
		this.model = model;
		this.playerPoint=model.getLevel().getPlayerLocation();
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
		GeneralGameObject sourceObject = model.getLevel().getObjectByPoint(playerPoint);
		sourceObject.setPoint(playerPoint);
		GeneralGameObject destObject = model.getLevel().getObjectByPoint(destPoint);
		destObject.setPoint(getDestinationPoint());
		GeneralGameObject boxNewDestObject = model.getLevel().getObjectByPoint(newDestPoint);
		if(boxNewDestObject!=null)
			boxNewDestObject.setPoint(getBoxNewDestinationPoint());
		if(checkMove(sourceObject,destObject,boxNewDestObject) == true)
			model.getLevel().updateLevel(sourceObject,destObject,boxNewDestObject);
		else
			System.out.println("Error: Cannot move "+this.direction.toString());
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
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
				return model.getLevel().getPolicy().pushBlockedBox();
			default:
				return true;
			}
		case PLAYER:
		case AREAPLAYER:
			return false;
		case WALL:
			return model.getLevel().getPolicy().WalkThroughWall();
		default :
			return true;
		}
	}
}
