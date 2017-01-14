package commands;

import level.Level;

public abstract class GeneralCommand implements Command {

	protected Level level;
	
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public abstract void doCommand(String arg);

	@Override
	public abstract void execute();

}
