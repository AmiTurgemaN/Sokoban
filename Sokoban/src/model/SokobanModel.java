package model;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Observable;

import controller.commands.Direction;
import level.GeneralLevelLoader;
import level.GeneralLevelSaver;
import level.Level;
import model.receiver.ExitReceiver;
import model.receiver.LoadLevelReceiver;
import model.receiver.MoveReceiver;
import model.receiver.SaveLevelReceiver;

public class SokobanModel extends Observable implements Model,Serializable {

	private static final long serialVersionUID = 1L;
	private Level level;
	
	public SokobanModel(Level level) {
		this.level = level;
	}
	
	public SokobanModel() {
	}

	@Override
	public Level getLevel() {
		return this.level;
	}
	@Override
	public void move(Direction direction) {
		MoveReceiver cm = new MoveReceiver(direction, this);
		cm.action();
	}

	@Override
	public void setLevel(Level level) {
		this.level=level;
	}

	@Override
	public void saveLevel(GeneralLevelSaver generalLevelSaver, OutputStream outputStream) {
		SaveLevelReceiver slr = new SaveLevelReceiver(generalLevelSaver,outputStream);
		slr.action();
	}

	@Override
	public void loadLevel(GeneralLevelLoader generalLevelLoader, InputStream inputStream) {
		LoadLevelReceiver llr = new LoadLevelReceiver(generalLevelLoader, inputStream);
		llr.action();
		setLevel(llr.getLevel());
	}

	@Override
	public void exit(String exitString) {
		ExitReceiver er = new ExitReceiver(exitString);
		er.action();
	}

}
