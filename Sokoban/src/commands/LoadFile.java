package commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import level.GeneralLevelLoader;
import level.GeneralLevelLoaderCreator;
import level.Level;
import level.LevelCreator;
import reciever.LoadLevelReciever;

public class LoadFile extends GeneralCommand {

	private GeneralLevelLoader generalLevelLoader;
	private InputStream inputStream;
	private LevelCreator lc;
	private String fileName;

	public LoadFile(GeneralLevelLoader generalLevelLoader,InputStream inputStream)
	{
		this.generalLevelLoader=generalLevelLoader;
		this.inputStream=inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LoadFile(LevelCreator lc)
	{
		this.lc=lc;
	}

	public LoadFile(Level level) {
		this.level=level;
	}

	public LevelCreator getLc() {
		return lc;
	}

	public void setLc(LevelCreator lc) {
		this.lc = lc;
	}

	public GeneralLevelLoader getGeneralLevelLoader() {
		return generalLevelLoader;
	}

	public void setGeneralLevelLoader(GeneralLevelLoader generalLevelLoader) {
		this.generalLevelLoader = generalLevelLoader;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public void execute() {
		try {
			this.fileName=this.commandArgs;
			if(this.commandArgs==null)
			{
				System.out.println("Error: Invalid level file name.");
				return;
			}
			this.lc = new LevelCreator(new FileInputStream("Hash Maps/saveHashMap.obj"),new FileInputStream("Hash Maps/loadHashMap.obj"));
			GeneralLevelLoaderCreator gllc = this.lc.getLoadHashMap().get(util.Utilities.getExtension(fileName));
			if(!this.commandArgs.contains("."))
			{
				System.out.println("Error: File extension is needed.");
				return;
			}
			else if(gllc==null)
			{
				System.out.println("Error: "+util.Utilities.getExtension(this.commandArgs)+" extension is not supported.");
				return;
			}
			this.inputStream = new FileInputStream ("Level Files/"+this.commandArgs);
			this.generalLevelLoader = gllc.create();
		} catch (FileNotFoundException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		LoadLevelReciever llr = new LoadLevelReciever(generalLevelLoader, inputStream);
		llr.action();
		setLevel(llr.getLevel());
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
		this.level.setLevelName(fileName.replaceAll("."+util.Utilities.getExtension(fileName), ""));
		level.init2DLevel();
		if(this.level.getLevelString()!="")
			System.out.println("Level "+level.getLevelName()+" has been loaded from "+util.Utilities.getExtension(fileName)+" file");
	}
}
