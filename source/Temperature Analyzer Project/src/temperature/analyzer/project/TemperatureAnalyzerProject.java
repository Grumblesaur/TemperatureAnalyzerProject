/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature.analyzer.project;

import java.sql.ResultSet;

/*
 *
 * @author Quinntero
 * @author rcatlett
 */
public class TemperatureAnalyzerProject {
    // debug bool
    public static boolean debug = true;
    public static boolean presentation = false;
    public static boolean sessionData = false;
    public static boolean testing = false;
    
    public static String locationFile = "src/temperature/analyzer/project/persistent/locations.txt";
    public static String previousQueries = "src/temperature/analyzer/project/persistent/history.txt";
    public static String serialNumbers = "src/temperature/analyzer/project/persistent/history.txt";
    
    public static ResultSet dataForSession;

    /**
     *
     */
    public static DatabaseConnection databaseCon = new DatabaseConnection();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        new Home().setVisible(true);
        
    }
    
}
