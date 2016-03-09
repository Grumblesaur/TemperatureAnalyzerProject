/** Stand-in Command Line Interface.
	@author James Murphy
	TAP Iteration 1
*/

import java.util.Scanner;

public class Interface {
	
	/* Typing System.out.print*() all the time sucks. */
	static void print(String message) {
		System.out.print(message);
	}
	static void println(String message) {
		System.out.println(message);
	}
	
	/* Show off a bit. */
	static void splashScreen() {
		println("========| ******************************** |========");
		println("========| Temperature Analysis Application |========");
		println("========| ******************************** |========");
		println("");
		println("");
	}
	
	/* Main menu text */
	static void mainMenu() {
		println("Select an action:");
		println("\t(I)mport file");
		println("\t(C)alculate {to be implemented}");
		println("\t(E)xport analysis {to be implemented}");
		println("\t(Q)uit");
		print(" > ");
	}
	
	public static void main(String[] args) {
		Object database = null;
		Scanner input = new Scanner(System.in);
		String option;
		
		splashScreen();
		
		boolean validCommand = false;
		do {
			mainMenu();
			switch (option.toLowerCase().charAt(0)) {
				case 'i':
					//importFile();
					validCommand = true;
					break;
				case 'q':
					System.exit(0);
				default:
					validCommand = false;
					break;
			}
			println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		} while (!validCommand);
		
	}
}                                    
