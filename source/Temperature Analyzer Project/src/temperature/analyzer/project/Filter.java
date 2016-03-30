package temperature.analyzer.project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Helper module for parsing field data from search page and creating SQL
 * queries.
 * @author james
 */

/* Imports */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import static temperature.analyzer.project.Search.debug;
import static temperature.analyzer.project.TemperatureAnalyzerProject.databaseCon;

public class Filter {
    /** Transforms locations into their three-letter codes.
     * 
     * @param locs An ArrayList of location Strings
     * @return An ArrayList of location three-letter codes
     */
    public static ArrayList<String> parseLocationCodes(ArrayList<String> locs) {
        ArrayList<String> newlocs = new ArrayList<String>();
        for (String loc : locs) {
            newlocs.add(loc.split(" ")[0]);
        }
        return newlocs;
    }
    
    /** Construct SQL query as a String.
     * 
     * @param sd The starting day.
     * @param ed The ending day.
     * @param sm The starting month.
     * @param em The ending month.
     * @param sy The starting year.
     * @param ey The ending year.
     * @param sh The starting hour.
     * @param eh The ending hour.
     * @param smin The starting minute.
     * @param emin The ending minute.
     * @param locations A list of sensor locations.
     * @param threshold A minimum number of hours' worth of data per sensor.
     * @return An SQL query as a string.
     */ /* This is mainly to avoid doing it all in Search.java */
    public static String createDataQuery(String sd, String ed, String sm,
        String em, String sy, String ey, String sh, String eh, String smin,
        String emin, ArrayList<String> locations, String threshold) {
        // Beginning of every query (for tester)
        
        //TODO: filter locations over thresholds
        //ArrayList<String> limitedLocation;
        //limiedLocation = DatabaseConnection.filterLocs(sy, ey, locations, threshold);
        
        String query = "SELECT * FROM APP.Tester WHERE ";
        
        // Creating date strings
        String startDate = createDate(sd, sm, sy, sh, smin);
        String endDate = createDate(ed, em, ey, eh, emin);
        //query = query + "DATE BETWEEN " + startDate + " AND " + endDate;
        
        // will return "", "LOCATION = x", or "LOCATION IN (x,y,z)"
        String locString = createLocation(locations);
        if (locString.length() > 0) {
            //query = query + " AND "+ locString;
            query = query + locString;
        }
       
        
        return query;
    }
    
    //getting dates together as string
    public static String createDate (String day, String month, String year, String hour, String min) {
        String q = month + "/" + day + "/" + year + " " + hour + ":" + min;
        return q;
    }
    
    // Piecing together the location list for the query
    public static String createLocation (ArrayList<String> locs) {
        String q = "";
        int size = locs.size();
        if (size != 0) {
            q = q + "LOCATION ";
            if (size == 1) {
                q = q + "= '" + locs.get(0) + "'";
            }
            else {
                q = q + "IN ( '" + String.join("', '", locs) + "')";
            }
        }
        
        return q;
    }
    
    public static boolean isEmptyOrWhitespace(String s) {
        return !s.isEmpty() && !s.trim().isEmpty();
    }
    
    
    /** Method to obtain location names stored in a database table.
     * 
     * @return An ArrayList populated with location names.
     */
    public static ArrayList<String> getLocations() {
        ArrayList<String> locs = new ArrayList<>();
        // From database
        try {
            databaseCon.searchData(databaseCon, "SELECT * FROM APP.LOCATION","");
            String locationInfo;
            while(databaseCon.rs.next()) {
                locationInfo = databaseCon.rs.getString(1) + " " + databaseCon.rs.getString(2);
                MessageDialogs.DEBUG(locationInfo, debug);
                locs.add(locationInfo);
            }
        } catch (SQLException err) {
            MessageDialogs.readDatabase(err.getMessage());
        }
        return locs;
    }
    
    /** Method to obtain location names stored in a database table.
     * 
     * @return An ArrayList populated with location names.
     */
    public static ArrayList<Integer> getSensors() {
        ArrayList<Integer> sensors = new ArrayList<>();
        // From database
        try {
            databaseCon.searchData(databaseCon, "SELECT * FROM APP.SENSOR","");
            Integer serial;
            while(databaseCon.rs.next()) {
                serial = databaseCon.rs.getInt(1);
                MessageDialogs.DEBUG(serial.toString(), debug);
                sensors.add(serial);
            }
        } catch (SQLException err) {
            MessageDialogs.readDatabase(err.getMessage());
        }
        return sensors;
    }
    
}
