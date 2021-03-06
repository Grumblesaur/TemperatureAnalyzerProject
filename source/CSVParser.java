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
		
		/* Inform client about input requirements, demonstrate how gnarly
			an xls file is under the hood to support this point.
		*/
		if (!filename.contains(".csv")) {
			throw new Exception("Error! Not a .csv file!");
		} 
		
		FileReader fr = null;
		BufferedReader bufr = null;
		
		/* Initialize file I/O resources. */
		try {
			fr = new FileReader(filename);
		} catch (Exception e) { // TODO: use more specific exceptions later
			throw new Exception("FileReader failed!");
		}
		try {
			bufr = new BufferedReader(fr);
		} catch (Exception e) { // TODO: use more specific exceptions later
			throw new Exception("BufferedReader failed!");
		}
		
		/* Grab the header for the location code. */
		String line, location, date, temp;
		try { // XXX: this try-block might not be necessary
			line = bufr.readLine();
			location = line.split(",")[1];
		} catch (Exception e) { // TODO: use more specific exceptions later
			throw new Exception("Issue with header capture!");
		}
		
		/* Obtain one line at a time and write the temperature data to DB.*/
		line = bufr.readLine();
		String[] point = null;
		while (line != null) {
			line = bufr.readLine();
			point = line.split(",");
			date = point[0];
			
			/* Assign NaN if no measurement was recorded at this time. */
			if (point.length == 2) {
				temp = point[1];
			} else {
				temp = "NaN";
			}
			
			writeToDB(location, date, temp);
		}
	}
	
	/* Actual database communication pending. Write output to console. */
	private static void writeToDB(String loc, String date, String temp) {
		/* Semi-redundant variables for parsing to ease reading. */
		float degrees = 0.0f;
		if (temp.equals("NaN")) {
			degrees = Float.NaN;
		} else {
			degrees = Float.parseFloat(temp);
		}
		
		/* Named variables for data capture */
		String year, month, day = "";
		String fullDate, clockTime;
		String[] dateParts = date.split(" ");
		fullDate = dateParts[0];
		clockTime = dateParts[1];
		
		/* Break down the date into integers. */
		String[] fullDateParts = fullDate.split("/");
		year = "20" + fullDateParts[2];
		month = fullDateParts[0];
		
		/* Prepend a zero to date if it's a single-digit date. */
		if (fullDateParts[1].length() < 2) {
			day = "0" + fullDateParts[1];
		} else {
			day = fullDateParts[1];
		}
		//TODO:
		// create SQL statement with: degrees, year, month, day, clockTime
		
		/* Print a test output table to console */
		TESTOUT(Float.toString(degrees) + "°C\t" + year + "\t" + month +
			"\t" + day + "\t" + clockTime + "\t" + loc);
	}
	
	// debug print, basically
	private static void TESTOUT(String message) {
		System.out.println(message);
	}
}
