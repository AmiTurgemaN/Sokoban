package commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import level.Level;

public class CommandCreator implements Serializable{

	protected static final long serialVersionUID = -3615622134611243390L;
	private HashMap<String,GeneralCommandCreator> commandsHashMap;
	
	public CommandCreator(FileInputStream fileInputStream) {
		try {
			initHash(fileInputStream);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public CommandCreator()
	{
		initHash();
	}

	public HashMap<String, GeneralCommandCreator> getCommandsHashMap() {
		return commandsHashMap;
	}

	public void setCommandsHashMap(HashMap<String, GeneralCommandCreator> commandsHashMap) {
		this.commandsHashMap = commandsHashMap;
	}
	
	private class displayCommandCreator  implements GeneralCommandCreator,Serializable{
		protected static final long serialVersionUID = -3615622134611243390L;
		public GeneralCommand create(Level level) {
			return new Display(level);
		}
	}
	private class exitCommandCreator  implements GeneralCommandCreator,Serializable{
		protected static final long serialVersionUID = -3615622134611243390L;
		public GeneralCommand create(Level level) {
			return new Exit(level);
		}
	}
	private class loadCommandCreator  implements GeneralCommandCreator,Serializable{
		protected static final long serialVersionUID = -3615622134611243390L;
		public GeneralCommand create(Level level) {
			return new LoadFile(level);
		}
	}
	
	private class saveCommandCreator  implements GeneralCommandCreator,Serializable{
		protected static final long serialVersionUID = -3615622134611243390L;
		public GeneralCommand create(Level level) {
			return new SaveFile(level);
		}
	}
	
	private class moveCommandCreator  implements GeneralCommandCreator,Serializable{
		protected static final long serialVersionUID = -3615622134611243390L;
		public GeneralCommand create(Level level) {
			return new Move(level);
		}
	}
	
	private void initHash() {
		this.commandsHashMap = new HashMap <String,GeneralCommandCreator>();
		this.commandsHashMap.put("save",new saveCommandCreator());
		this.commandsHashMap.put("load",new loadCommandCreator());
		this.commandsHashMap.put("display",new displayCommandCreator());
		this.commandsHashMap.put("exit",new exitCommandCreator());
		this.commandsHashMap.put("move",new moveCommandCreator());
	}
	
	public void serializeHash() throws FileNotFoundException, IOException
	{
			ObjectOutputStream saveOut = new ObjectOutputStream(new FileOutputStream("commandHashMap.obj"));
			saveOut.writeObject(this.commandsHashMap);
			saveOut.close();
            System.out.println("Serialized HashMap data has been is saved");
	}
	
	@SuppressWarnings("unchecked")
	private void initHash(InputStream commandHashMapInput) throws IOException, ClassNotFoundException {
		this.commandsHashMap = new HashMap <String,GeneralCommandCreator>();
		ObjectInputStream saveIn = new ObjectInputStream(commandHashMapInput);
		this.commandsHashMap=(HashMap<String, GeneralCommandCreator>) saveIn.readObject();
		saveIn.close();
	}
	
}
