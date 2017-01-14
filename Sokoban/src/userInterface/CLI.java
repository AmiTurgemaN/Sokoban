package userInterface;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import commands.CommandCreator;
import commands.GeneralCommand;
import commands.GeneralCommandCreator;
import level.Level;
import policy.MySokobanPolicy;

public class CLI {
	private BufferedReader in;
	private PrintWriter out;
	private Level level;
	private HashMap<String,GeneralCommandCreator> commandHashMap;

	public CLI(BufferedReader in, PrintWriter out) throws ClassNotFoundException, FileNotFoundException
	{
		this.in = in;
		this.out = out;
		this.level = null;
		this.commandHashMap = new CommandCreator(new FileInputStream("commandHashMap.obj")).getCommandsHashMap();
	}

	public void start()
	{
		soloGame();
	}

	private void soloGame() {
		GeneralCommand command = null;
		try {
			String line = in.readLine();

			while (true)
			{	

				String[] sp = line.split(" ");

				String commandName = sp[0].toLowerCase();
				String arg = null;
				if (sp.length == 2)
					arg = sp[1].toLowerCase();
				if(sp.length>2)
				{
					System.out.println("Invalid command");
					line = in.readLine();
					continue;
				}
				GeneralCommandCreator gcc = this.commandHashMap.get(commandName);
				if(gcc!=null)
				{
					command = gcc.create(level);
					command.doCommand(arg);
					this.level=command.getLevel();
					if(this.level!=null)
						this.level.setPolicy(new MySokobanPolicy());
				}
				else
					System.out.println("Invalid command");
				line = in.readLine();
			}

		} catch (IOException e) {			
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}			
		}	
	}
}
