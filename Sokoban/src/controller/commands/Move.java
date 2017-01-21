package controller.commands;

import model.Model;

public class Move extends GeneralCommand {

	private static final long serialVersionUID = 1L;
	private Direction direction;

	public Move(Model model)
	{
		this.model=model;
	}

	public Move(Direction direction,Model model)
	{
		this.direction=direction;
		this.model=model;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public void execute() {
		if(this.commandArgs==null)
		{
			view.displayError("Invalid move command");
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
			view.displayError("Invalid move command");
			return;
		}
		if(this.model.getLevel()==null)
		{
			view.displayError("Level not loaded");
			return;
		}
		if(!this.model.getLevel().isCompleted())
		{
			this.model.move(direction);
		}
	}

}
