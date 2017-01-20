package commands;

import level.Level;
import reciever.MoveReciever;

public class Move extends GeneralCommand {

	private Direction direction;

	public Move(Level level)
	{
		this.level=level;
	}

	public Move(Direction direction,Level level)
	{
		this.direction=direction;
		this.level=level;
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

	@Override
	public void execute() {
		if(this.commandArgs==null)
		{
			System.out.println("Error: Invalid move command");
			return;
		}
		switch (this.commandArgs) {
		case "up":
			this.direction=Direction.UP;
			break;
		case "down":
			this.direction=Direction.DOWN;
			break;
		case "left":
			this.direction=Direction.LEFT;
			break;
		case "right":
			this.direction=Direction.RIGHT;
			break;
		default:
			System.out.println("Error: Invalid move command");
			return;
		}
		if(this.level==null)
		{
			System.out.println("Error: Level not loaded");
			return;
		}
		if(!this.level.isCompleted())
		{
			MoveReciever cm = new MoveReciever(direction, level,level.getPlayerLocation());
			cm.action();
		}
	}

}
