package reciever;

import java.io.InputStream;

import level.GeneralLevelLoader;
import level.Level;

public class LoadLevelReciever extends GeneralReciever {

	private GeneralLevelLoader levelLoader;
	private InputStream is;
	private Level level;
	
	
	public Level getLevel() {
		return level;
	}


	public void setLevel(Level level) {
		this.level = level;
	}


	public LoadLevelReciever(GeneralLevelLoader levelLoader, InputStream is) {
		super();
		this.levelLoader = levelLoader;
		this.is = is;
	}


	public GeneralLevelLoader getLevelLoader() {
		return levelLoader;
	}


	public void setLevelLoader(GeneralLevelLoader levelLoader) {
		this.levelLoader = levelLoader;
	}


	public InputStream getIs() {
		return is;
	}


	public void setIs(InputStream is) {
		this.is = is;
	}


	@Override
	public void action() {
		this.level=this.getLevelLoader().loadLevel(is);
	}

}
