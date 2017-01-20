package commands;

import level.Level;

public abstract class GeneralCommand implements Command {

	protected Level level;
	protected String commandArgs;
	
	public String getCommandArgs() {
		return commandArgs;
	}

	public void setCommandArgs(String commandArgs) {
		this.commandArgs = commandArgs;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public abstract void execute();

}
