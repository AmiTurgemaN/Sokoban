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
		if(this.commandArgs!=null)
		{
			System.out.println("Error: Display command does not require any arguments.");
			return;
		}
		if(this.level==null)
		{
			System.out.println("Error: Level not loaded");
			return;
		}
		DisplayReciever dr = new DisplayReciever(level);
		dr.action();
	}
}
