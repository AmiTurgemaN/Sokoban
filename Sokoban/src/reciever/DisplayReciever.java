package reciever;

import level.Level;

public class DisplayReciever extends GeneralReciever {

	private Level level;
	
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public DisplayReciever(Level level) {
		super();
		this.level = level;
	}

	@Override
	public void action() {
		System.out.println(this.level.getLevelString());
	}

}
