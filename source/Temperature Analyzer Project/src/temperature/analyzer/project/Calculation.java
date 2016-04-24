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

import java.util.ArrayList;
import java.math.BigDecimal;

public class Calculation {
    
    // required for completion: knowing the form of a result set
    // may need to cast result set to some type of list (probably ArrayList)
    
    /** Calculate record high for entire result set.
     * @return A double.
     * @param data an SQL ResultSet
     */
    public static double recordHigh(ArrayList<BigDecimal> data) {
        double high = data.get(0).doubleValue();
        for (BigDecimal i : data) {
            if (i == null) {
                continue;
            }
            double d = i.doubleValue();
            if (d > high) {
                high = d;
            }
        }
        return high;
    }
    
    /** Calculate record low for entire result set.
     * @param data The working result set.
     * @return whatever
     */
    public static double recordLow(ArrayList<BigDecimal> data) {
        double low = data.get(0).doubleValue();
        for (BigDecimal i : data) {
            if (i == null) {
                continue;
            }
            double d = i.doubleValue();
            if (d < low) {
                low = d;
            }
        }
        return low;
    }
    
    /** Calculate average for entire result set.
     * @param data The working result set.
     * @return I'm only using this tag because NetBeans is yelling at me.
     */
    public static ResultTuple average(ArrayList<BigDecimal> data) {
        double total = 0.00;
        double squareTotal = 0.00;
        double sd;
        double mean;
        int count = 0;
        // first pass to calculate mean
        for (BigDecimal i : data) {
            if (i == null) {
                continue;
            }
            double d = i.doubleValue();
            total += d;
            count++;
        }
        try {
            // second pass to calculate standard deviation
            mean = total / count;
            for (BigDecimal i : data) {
                if (i == null) {
                    continue;
                }
                double d = i.doubleValue();
                squareTotal += (mean - d) * (mean - d);
            }
            sd = Math.sqrt(squareTotal / count);
        } catch (ArithmeticException e) {
            // divided by zero!
            mean = 0.0;
            sd = 0.0;
        }
        
        return new ResultTuple(mean, sd, count);
    }
}
