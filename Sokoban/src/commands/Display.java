package commands;

import level.Level;
import reciever.DisplayReciever;

public class Display extends GeneralCommand {

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Display(Level level) {
		this.level=level;
	}

	@Override
	public void execute() {
		DisplayReciever dr = new DisplayReciever(level);
		dr.action();
	}

	@Override
	public void doCommand(String arg) {
		if(arg!=null)
		{
			System.out.println("Invalid command");
			return;
		}
		if(this.level!=null)
			execute();
		else
			System.out.println("Level not loaded");
	}

}
