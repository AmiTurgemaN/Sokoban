package view;

import java.io.PrintWriter;

import model.data.level.Level;

public interface View{
	String getExitString();
	void displayError(String msg);
	void displayMessage(String msg);
	void start();
	void displayLevel(Level level);
	void exit(String exitString);
	PrintWriter getOut();
}
