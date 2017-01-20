package view;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Observable;
import java.util.Scanner;

import commands.CommandCreator;
import commands.GeneralCommand;
import commands.GeneralCommandCreator;
import level.Level;
import policy.MySokobanPolicy;

public class CLI extends Observable implements View{
	private BufferedReader in;
	private PrintWriter out;
	private Level level;
	private HashMap<String,GeneralCommandCreator> commandHashMap;
	private String exitString;

	public CLI(BufferedReader in, PrintWriter out,String exitString) throws ClassNotFoundException, FileNotFoundException
	{
		this.in = in;
		this.out = out;
		this.level = null;
		this.commandHashMap = new CommandCreator(new FileInputStream("Hash Maps/commandHashMap.obj")).getCommandsHashMap();
		this.exitString = exitString;
	}

	public void start()
	{
		soloGame();
	}

	private void soloGame() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(in);
				GeneralCommand command = null;
				String line="";
				while (!line.equals(exitString))
				{	
					line = scanner.nextLine();
					String[] sp = line.split(" ");

					String commandName = sp[0].toLowerCase();
					String arg = null;
					if (sp.length == 2)
						arg = sp[1].toLowerCase();
					if(sp.length>2)
					{
						displayError("Invalid command");
						line = scanner.nextLine();
						continue;
					}
					GeneralCommandCreator gcc = commandHashMap.get(commandName);
					if(gcc!=null)
					{
						command = gcc.create(level);
						command.setCommandArgs(arg);
						command.execute();
						level=command.getLevel();
						if(level!=null)
							level.setPolicy(new MySokobanPolicy());
					}
					else
						displayError("Invalid command");
				}
			}
		});
		thread.start();
	}	

	@Override
	public void displayError(String msg) {
		out.println("Error: " + msg);
		out.flush();
	}
}
