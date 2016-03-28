/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature.analyzer.project;

/** Class used to wrap date values and determine relative occurrence.
 *
 * @author james
 */
public class SimpleDate implements Comparable<SimpleDate> {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    
    /** Construct a SimpleDate from String arguments.
     * 
     * @param day The day.
     * @param mon The month.
     * @param yr The year.
     * @param hr The hour.
     * @param min The minute.
     */
    public SimpleDate(String day, String mon, String yr, String hr, String min) {
        this.day = Integer.parseInt(day);
        this.month = Integer.parseInt(mon);
        this.year = Integer.parseInt(yr);
        this.hour = Integer.parseInt(hr);
        this.minute = Integer.parseInt(min);
    }
    /** Construct a SimpleDate from int arguments. 
     * 
     * @param day The day.
     * @param mon The month.
     * @param yr The year.
     * @param hr The hour.
     * @param min The minute.
     */
    public SimpleDate(int day, int mon, int yr, int hr, int min) {
        this.day = day;
        this.month = mon;
        this.year = yr;
        this.hour = hr;
        this.minute = min;
    }
    
    /** Implement Comparable interface for SimpleDate. 
     * 
     * @param rhs The parameter date.
     * @return 1 if calling object > after argument, 0 if equal, -1 if before.
     */
    
    @Override
    public int compareTo(SimpleDate rhs) {
        /* Year comparison. */
        if (this.year < rhs.year) {
            return -1;
        } else if (this.year > rhs.year) {
            return 1;
        }

        /* Month comparison. */
        if (this.month > rhs.month) {
            return 1;
        } else if (this.month < rhs.month) {
            return -1;
        }

        /* Date comparison. */
        if (this.day > rhs.day) {
            return 1;
        } else if (this.day < rhs.day) {
            return -1;
        }
        
        /* Hour comparison. */
        if (this.hour > rhs.hour) {
            return 1;
        } else if (this.hour < rhs.hour) {
            return -1;
        }
        
        /* Minute comparison. */
        if (this.minute > rhs.minute) {
            return 1;
        } else if (this.minute < rhs.minute) {
            return -1;
        }
        
        /* Dates are equal. */
        return 0;
    }
    
}

