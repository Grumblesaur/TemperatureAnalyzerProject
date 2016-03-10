/** CSVParser to add data points to database.
	@author James Murphy
	TAP Sprint 1
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVParser {
	/** Parser algorithm to move data points to database.
	 * @param database A connection to a MySQL database.
	 * @param filename The name of the file to be parsed.
	 * @throws Exception Because non-generic exceptions are too
	 * obnoxious to actually invest time in.
	*/
	public static void importFile(Object database, String filename)
		throws Exception {
		if (!filename.contains(".csv")) {
			throw new Exception("Error! Not a .csv file!");
		} 
		
		FileReader fr = null;
		BufferedReader bufr = null;
		
		/* Initialize file I/O resources. */
		try {
			fr = new FileReader(filename);
		} catch (Exception e) {
			throw new Exception("FileReader failed!");
		}
		
		try {
			bufr = new BufferedReader(fr);
		} catch (Exception e) {
			throw new Exception("BufferedReader failed!");
		}
		
		/* Grab the header for the location code. */
		String line = bufr.readLine();
		String location = line.split(",")[1];
		
		String date, temp;
		
		/* Obtain one line at a time and write the temperature data to DB.*/
		line = bufr.readLine();
		String[] point = null;
		while (line != null) {
			point = line.split(",");
			date = point[0];
			temp = point[1];
			writeToDB(location, date, temp);
		}
	}
	
	private static void writeToDB(String loc, String date, String temp) {
		/* Semi-redundant variables for parsing to ease reading. */
		float degrees = Float.parseFloat(temp);
		int year, month, day;
		String fullDate, clockTime;
		String[] dateParts = date.split("");
		fullDate = dateParts[0];
		clockTime = dateParts[1];
		
		/* Break down the date into integers. */
		String[] fullDateParts = fullDate.split("/");
		year = Integer.parseInt(fullDateParts[2]);
		month = Integer.parseInt(fullDateParts[0]);
		day = Integer.parseInt(fullDateParts[1]);
		
		//TODO:
		// create SQL statement with: degrees, year, month, day, clockTime
		TESTOUT(Float.toString(degrees) + "°F\t" + year + "\t" + month +
			"\t" + day + "\t" + clockTime);
	}
	
	private static void TESTOUT(String message) {
		System.out.println(message);
	}
}
