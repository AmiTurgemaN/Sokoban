package model.receiver;

import level.Level;

public class DisplayReceiver extends GeneralReceiver {

	private Level level;
	
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public DisplayReceiver(Level level) {
		super();
		this.level = level;
	}

	@Override
	public void action() {
		System.out.println(this.level.getLevelString());
	}

}
