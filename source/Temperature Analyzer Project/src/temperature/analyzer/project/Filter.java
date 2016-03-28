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
import java.util.ArrayList;

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
        String query = "";
        
        // TODO: requisite concatenations
        
        return query;
    }

}
