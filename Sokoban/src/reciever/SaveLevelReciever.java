package reciever;

import java.io.OutputStream;

import level.GeneralLevelSaver;

public class SaveLevelReciever extends GeneralReciever {

	private GeneralLevelSaver levelSaver;
	private OutputStream os;
	
	public SaveLevelReciever(GeneralLevelSaver levelSaver, OutputStream os) {
		this.levelSaver = levelSaver;
		this.os = os;
	}

	public GeneralLevelSaver getLevelSaver() {
		return levelSaver;
	}

	public void setLevelSaver(GeneralLevelSaver levelSaver) {
		this.levelSaver = levelSaver;
	}

	public OutputStream getOs() {
		return os;
	}

	public void setOs(OutputStream os) {
		this.os = os;
	}

	@Override
	public void action() {
		this.levelSaver.saveLevel(os);
	}

}
