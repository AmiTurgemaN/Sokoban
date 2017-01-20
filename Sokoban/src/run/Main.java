package run;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import view.CLI;

public class Main {

	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		CLI cli;
		try {
			cli = new CLI(reader, writer,"exit");
			cli.start();
		} catch (ClassNotFoundException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
