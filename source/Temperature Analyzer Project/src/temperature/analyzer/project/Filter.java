package temperature.analyzer.project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author james
 */
public class Filter {
    public static String[] dateBreak(String longDate) {
        // string of the form "MM/DD/YYYY HH:MM [P^A]M"
        // format:       MM  DD  YY  T
        String dateArray[] = {"", "", "", ""};
        String[] dateAndTime = longDate.split(" ");
        String[] dateOnly = dateAndTime[0].split("/");
        String hourAndMinute = dateAndTime[1];
        String meridiem = dateAndTime[2];
       
        
        return dateArray;
    }
    
    
}
