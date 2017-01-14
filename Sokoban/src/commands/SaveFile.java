package commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import level.GeneralLevelSaver;
import level.GeneralLevelSaverCreator;
import level.Level;
import level.LevelCreator;
import reciever.SaveLevelReciever;

public class SaveFile extends GeneralCommand {

	private GeneralLevelSaver generalLevelSaver;
	private OutputStream outputStream;
	private LevelCreator lc;
	public LevelCreator getLc() {
		return lc;
	}

	public void setLc(LevelCreator lc) {
		this.lc = lc;
	}

	private Level level;

	public SaveFile(LevelCreator lc)
	{
		this.lc=lc;
	}

	public GeneralLevelSaver getGeneralLevelSaver() {
		return generalLevelSaver;
	}

	public void setGeneralLevelSaver(GeneralLevelSaver generalLevelSaver) {
		this.generalLevelSaver = generalLevelSaver;
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public SaveFile(GeneralLevelSaver generalLevelSaver,OutputStream outputStream,Level level)
	{
		this.generalLevelSaver=generalLevelSaver;
		this.outputStream=outputStream;
		this.level=level;
	}

	public SaveFile(Level level)
	{
		this.level=level;
	}

	@Override
	public void execute() {
		SaveLevelReciever slr = new SaveLevelReciever(generalLevelSaver,outputStream);
		slr.action();
	}

	@Override
	public void doCommand(String arg) {
		try {
			String extension = util.Utilities.getExtension(arg);
			this.lc = new LevelCreator(new FileInputStream("Hash Maps/saveHashMap.obj"),new FileInputStream("Hash Maps/loadHashMap.obj"));
			GeneralLevelSaverCreator glsc = this.lc.getSaveHashMap().get(extension);
			if(!arg.contains("."))
			{
				System.out.println("file extension is needed.");
				return;
			}
			else if(glsc==null)
			{
				System.out.println(extension+" extension is not supported.");
				return;
			}
			this.outputStream=new FileOutputStream(new File("Level Files/"+arg));
			this.generalLevelSaver = glsc.create(level);
			this.level.setLevelName(arg.replaceAll("."+extension, ""));
			execute();
			System.out.println("Level "+level.getLevelName()+" has been saved as "+extension+" file");
		} catch (FileNotFoundException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
