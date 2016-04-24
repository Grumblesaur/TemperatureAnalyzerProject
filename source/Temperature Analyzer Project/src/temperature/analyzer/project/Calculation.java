/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature.analyzer.project;

/**
 *
 * @author james
 * @author rcatlett
 */

import java.sql.*; // END MY LIFE
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.function.Consumer;
import static temperature.analyzer.project.TemperatureAnalyzerProject.dataForSession;
import static temperature.analyzer.project.TemperatureAnalyzerProject.debug;

public class Calculation {
    
    // required for completion: knowing the form of a result set
    // may need to cast result set to some type of list (probably ArrayList)
    
    /** Calculate record high for entire result set.
     * @return A double.
     * @param data an SQL ResultSet
     */
    public static double recordHigh(ArrayList<BigDecimal> data) {
        double high = 0.00;
        for (BigDecimal i : data) {
            if (i == null) {
                continue;
            }
            double d = i.doubleValue();
            if (d > high) {
                high = d;
            }
        }
        return high; // dummy value for compilation
    }
    
    /** Calculate record low for entire result set.
     * @param data The working result set.
     * @return whatever
     */
    public static double recordLow(ResultSet data) {
        return 0.00; // dummy value for compilation
    }
    
    /** Calculate average for entire result set.
     * @param data The working result set.
     * @return I'm only using this tag because NetBeans is yelling at me.
     */
    public static double average(ResultSet data) {
        return 0.00; // dummy value for compilation
    }
    
    /** Obtain an array of highs for each month.
     * @param data THe working result set
     * @return whatev', yo
     */
    public static double[] monthlyHighs(ResultSet data) {
        int monthCount = 0;
        double[] ret = new double[monthCount];
        // break list into slices of months
        // for each month slice, call recordHigh() to find the high
        //     add each recordHigh() value to the return array
        return ret;
    }
    
    /** Obtain an array of lows for each month.
     * @param data The working result set
     * @return whatev', yo
     */
    public static double[] monthlyLows(ResultSet data) {
        int monthCount = 0;
        double[] ret = new double[monthCount];
        // break list into slices of months
        // for each month slice, call recordLow() to find the low
        //     add each recordLow() value to the return array
        return ret;
    }
    
    /** Obtain an array of average temperatures for each month.
     * @param data
     * @return something
     */
    public static double[] monthlyAverage(ResultSet data) {
        int monthCount = 0;
        double[] ret = new double[monthCount];
        // break list into slices of month
        // for each month slice, call average() to find the average
        //     add each average() value to the return array
        return ret;
    }
    
    // TODO create methods that will find values for each month in a result set.
}
