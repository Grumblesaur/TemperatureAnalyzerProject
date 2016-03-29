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
    public static ResultSet dataForSession;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Home().setVisible(true);
        
    }
    
}
