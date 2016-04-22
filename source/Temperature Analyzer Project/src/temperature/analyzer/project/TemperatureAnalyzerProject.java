package temperature.analyzer.project;

import java.sql.ResultSet;

/**
 * @author james
 * @author Quinntero
 * @author rcatlett
 */
public class TemperatureAnalyzerProject {
    // debug booleans
    public static boolean debug = false;
    public static boolean presentation = false;
    public static boolean sessionData = false;
    public static boolean testing = true;
    
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
