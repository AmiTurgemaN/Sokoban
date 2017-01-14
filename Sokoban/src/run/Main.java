package run;

import userInterface.CLI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Main {

	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		CLI cli;
		try {
			cli = new CLI(reader, writer);
			cli.start();
		} catch (ClassNotFoundException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
