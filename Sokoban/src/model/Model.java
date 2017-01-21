package model;

import java.io.InputStream;
import java.io.OutputStream;

import controller.commands.Direction;
import level.GeneralLevelLoader;
import level.GeneralLevelSaver;
import level.Level;

public interface Model {
	Level getLevel();
	void setLevel(Level level);
	void move(Direction direction);
	void saveLevel(GeneralLevelSaver generalLevelSaver, OutputStream outputStream);
	void loadLevel(GeneralLevelLoader generalLevelLoader, InputStream inputStream);
	void exit(String exitString);
}
