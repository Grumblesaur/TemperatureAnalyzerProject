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
		println("\n\n\n\n");
		println("========| ******************************** |========");
		println("========| Temperature Analysis Application |========");
		println("========| ******************************** |========");
		println("\n\n");
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
		/* Dummy object for compilation's sake. Will need to replace with an
			object that represents a connection to a database later.
		*/
		Object database = null;
		
		/* User input resources. */
		Scanner input = new Scanner(System.in);
		String option, filename;
		
		splashScreen();
		
		boolean validCommand = false;
		do {
			mainMenu();
			option = input.nextLine();
			switch (option.toLowerCase().charAt(0)) {
				case 'i':
					print("File to parse: ");
					filename = input.nextLine();
					validCommand = importHelper(database, filename);
					break;
				case 'q':
					System.exit(0);
				default:
					validCommand = false;
					break;
			}
			println("\n");
		} while (!validCommand);
		
	}
	
	static boolean importHelper(Object database, String filename) {

		boolean failed = false;
		try {
			CSVParser.importFile(database, filename);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			failed = true;
		} finally {
			return failed;
		}
	}
}                                    
