package commands;

import level.Level;
import reciever.ExitReciever;

public class Exit extends GeneralCommand {

	private String exitString;
	
	public Exit(Level level)
	{
		this.level=level;
	}
	
	@Override
	public void execute() {
		if(this.commandArgs!=null)
		{
			System.out.println("Error: Exit command does not require any arguments.");
			return;
		}
		this.exitString="Exiting";
		ExitReciever er = new ExitReciever(exitString);
		er.action();
	}
}
