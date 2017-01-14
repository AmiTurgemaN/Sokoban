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
		ExitReciever er = new ExitReciever(exitString);
		er.action();
	}

	@Override
	public void doCommand(String arg) {
		if(arg!=null)
		{
			System.out.println("Invalid command");
			return;
		}
		this.exitString="Exiting";
		execute();
	}
}
