/** Search function source file.
 * @author James Murphy
 * CPSC 430 / Software Engineering
 * Sprint 2
 */

/* API Resources */
import java.sql.*; // Using wildcard to cover my bases for SQL BS
import java.util.ArrayList;

public class Search {
	
	private static String locationFilter(Connection con, String dbName) {
		String query = "SELECT Symbol FROM Location";
		ArrayList<String> Locations = new ArrayList<String>();
		String rule = "";
		
		// TODO
		
	}
	
	
	
}
