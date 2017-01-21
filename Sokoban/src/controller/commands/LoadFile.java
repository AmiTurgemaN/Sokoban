package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import level.GeneralLevelLoader;
import level.GeneralLevelLoaderCreator;
import level.LevelCreator;
import model.Model;
import policy.MySokobanPolicy;
import view.View;

public class LoadFile extends GeneralCommand {

	private static final long serialVersionUID = 1L;
	private GeneralLevelLoader generalLevelLoader;
	private InputStream inputStream;
	private LevelCreator lc;
	private String fileName;

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public LoadFile(GeneralLevelLoader generalLevelLoader,InputStream inputStream,Model model)
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

	public LoadFile(Model model,View view) {
		this.view=view;
		this.model=model;
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
				view.displayError("Invalid level file name.");
				return;
			}
			this.lc = new LevelCreator(new FileInputStream("Hash Maps/saveHashMap.obj"),new FileInputStream("Hash Maps/loadHashMap.obj"));
			GeneralLevelLoaderCreator gllc = this.lc.getLoadHashMap().get(util.Utilities.getExtension(fileName));
			if(!this.commandArgs.contains("."))
			{
				view.displayError("File extension is needed.");
				return;
			}
			else if(gllc==null)
			{
				view.displayError(util.Utilities.getExtension(this.commandArgs)+" extension is not supported.");
				return;
			}
			this.inputStream = new FileInputStream ("Level Files/"+this.commandArgs);
			this.generalLevelLoader = gllc.create();
		} catch (FileNotFoundException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		this.model.loadLevel(generalLevelLoader, inputStream);
		setLevel();
	}

	public void setLevel() {
		this.model.getLevel().setPolicy(new MySokobanPolicy());
		model.setLevel(this.model.getLevel());
		this.model.getLevel().setLevelName(fileName.replaceAll("."+util.Utilities.getExtension(fileName), ""));
		this.model.getLevel().init2DLevel();
		if(this.model.getLevel().getLevelString()!="")
			view.displayMessage("Level "+model.getLevel().getLevelName()+" has been loaded from "+util.Utilities.getExtension(fileName)+" file");
	}
}
