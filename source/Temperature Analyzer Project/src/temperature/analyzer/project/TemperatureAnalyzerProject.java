package temperature.analyzer.project;

import java.sql.ResultSet;

/*
 *
 * @author Quinntero
 * @author rcatlett
 */
public class TemperatureAnalyzerProject {
    // debug booleans
    public static boolean debug = true;
    public static boolean presentation = false;
    public static boolean sessionData = false;
    public static boolean testing = true;
    
    
    // TODO change these locations - wrong, using SQL files now - perhaps use to start tables?
    public static String locationFile = "src/temperature/analyzer/project/persistent/locations.txt";
    public static String previousQueries = "src/temperature/analyzer/project/persistent/history.txt";
    public static String serialNumbers = "src/temperature/analyzer/project/persistent/history.txt";
    
    public static ResultSet dataForSession;

    /**
     * Create the database for the running instance
     */
    public static DatabaseConnection databaseCon = new DatabaseConnection();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Home().setVisible(true);
        
    }
    
}
