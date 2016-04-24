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
        return high;
    }
    
    /** Calculate record low for entire result set.
     * @param data The working result set.
     * @return whatever
     */
    public static double recordLow(ArrayList<BigDecimal> data) {
        double low = 0.00;
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
    public static double average(ArrayList<BigDecimal> data) {
        double total = 0.00;
        int count = 0;
        for (BigDecimal i : data) {
            if (i == null) {
                continue;
            }
            double d = i.doubleValue();
            total += d;
            count++;
        }
        return total / count;
    }
}
