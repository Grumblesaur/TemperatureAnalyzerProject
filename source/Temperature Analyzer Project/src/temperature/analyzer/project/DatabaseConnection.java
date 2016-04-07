/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature.analyzer.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import static temperature.analyzer.project.Search.debug;

/**
 *
 * @author rcatlett
 */
public class DatabaseConnection {
    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;
        
    public DatabaseConnection() {
        try {
               // Connect to the database
               String host = "jdbc:derby://localhost:1527/mytap";
               String uName = "root";
               String uPass = "pass";
               con = DriverManager.getConnection(host, uName, uPass);

           } catch (SQLException err) {
               MessageDialogs.noConnectionError(err.getMessage());
           }
    }
    
    public void addData(DatabaseConnection db, String loc, String date, String time, String temp){
        try {
            String SQL = "INSERT INTO APP.Measurement VALUES (" + temp +
                ", '" + date + "', '" + time + "', (SELECT \"Symbol\" FROM" +
                " APP.LOCATION WHERE \"Symbol\" = '" + loc + "'))"; 
           
            //MessageDialogs.DEBUG(SQL, debug);
            db.stmt = db.con.createStatement();
            db.stmt.executeUpdate(SQL);
            
        } catch (SQLException err) {
            MessageDialogs.noConnectionError(err.getMessage());
        }
    }
    
    // Funciton to check if a location is unique
    public boolean canAdd(String code, String loc) {
        boolean canAdd = false;
        try {
            this.stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM APP.Location WHERE \"Symbol\" = '" + code + "' OR  \"Location\" = '" + loc + "'";
            ResultSet codeRS = this.stmt.executeQuery(SQL);
            if (!codeRS.isBeforeFirst()){
                canAdd = true;
            }
        } catch (SQLException err) {
           MessageDialogs.noConnectionError(err.getMessage());
        }
        return canAdd;
    }
    
    // Funciton to check if a location exists
    public boolean exists(String code, String loc) {
        boolean exist = true;
        try {
            this.stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM APP.Location WHERE \"Symbol\" = '" + code + "' AND  \"Location\" = '" + loc + "'";
            ResultSet codeRS = this.stmt.executeQuery(SQL);
            if (!codeRS.isBeforeFirst()){
                //here if RS is empty
                exist = false;
            }
        } catch (SQLException err) {
           MessageDialogs.noConnectionError(err.getMessage());
        }
        return exist;
    }
    
    // Checks if serial number exists
    public boolean exists(Integer serial) {
        boolean exist = true;
        try {
            this.stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM APP.Sensor WHERE \"Serial_Number\" = " + serial;
            ResultSet codeRS = this.stmt.executeQuery(SQL);
            if (!codeRS.isBeforeFirst()){
                //here if RS is empty
                exist = false;
            }
        } catch (SQLException err) {
           MessageDialogs.noConnectionError(err.getMessage());
        }
        return exist;
    }
    
    // Function to add a location the the database

    /**
     *
     * @param code
     * @param loc
     */
    public void addLoc(String code, String loc){
        try {
            String SQL = "INSERT INTO APP.Location VALUES ('" + code + "', '" + loc + "')";
            this.stmt.executeUpdate(SQL);
          
            this.stmt.close();
            
        } catch (SQLException err) {
            MessageDialogs.noConnectionError(err.getMessage());
        }
    }
    
    // Function to remove a location from the table
    public boolean removeLoc(String code, String loc){
        boolean done = false;
        try {
            if (!this.checkDependency(code)) {
                String SQL = "DELETE FROM APP.Location WHERE \"Symbol\" = '" + code + "' AND \"Location\" = '" + loc + "'";
                this.stmt.executeUpdate(SQL);
                done = true;

                this.stmt.close();
            }
            else {
                MessageDialogs.dependent();
            }
            
        } catch (SQLException err) {
            MessageDialogs.noConnectionError(err.getMessage());
        }
        return done;
    }
    
    public boolean moveSensors(ArrayList<Integer> sensors, String newLoc) {
        // TODO: Code moving the sensors - update the sensor location
        boolean moved = false;
        try {
            String toMove = "(" + sensors.get(0).toString();
            for (int i = 1; i < sensors.size(); i++){
                 toMove += ", " + sensors.get(i).toString();
            }
            toMove += ")";
            
            this.stmt = this.con.createStatement();
            String SQL = "UPDATE APP.Sensor SET \"Location_Symbol\" = '" + newLoc + "' WHERE \"Serial_Number\" IN " + toMove;
            
            this.stmt.executeUpdate(SQL);
            moved = true;
        } catch (SQLException err) {
            MessageDialogs.editError(err.getMessage());
        }
        return moved;
    }
    
    // Function to add a serial from the table
    public void addSerial(Integer serial){
        try {
            this.stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "INSERT INTO APP.Sensor VALUES (" + serial;
            SQL = SQL + ", (select \"Symbol\" from APP.Location where \"Symbol\" = 'OFF'))";
            this.stmt.executeUpdate(SQL);
            
            this.stmt.close();
            
        } catch (SQLException err) {
            MessageDialogs.noConnectionError(err.getMessage());
        }
    }
    
    // Function to remove a serial from the table
    public boolean removeSerial(Integer serial){
        boolean done = false;
        try {
            String s = serial.toString();
            String SQL = "DELETE FROM APP.Sensor WHERE \"Serial_Number\" = " + s;
            this.stmt.executeUpdate(SQL);
            done = true;

            this.stmt.close();
            
        } catch (SQLException err) {
            MessageDialogs.noConnectionError(err.getMessage());
        }
        return done;
    }
    
    // Checks to see if a location is being used in a sensor
    public boolean checkDependency(String c) {
        boolean exists = false;
        try {
            this.stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM APP.Sensor WHERE \"Location_Symbol\" = '"+ c + "'";
            ResultSet test = this.stmt.executeQuery(SQL);
            
            if (test.isBeforeFirst()) {
                exists = true;
            }
        } catch (SQLException err) {
            MessageDialogs.noConnectionError(err.getMessage());
        }
        return exists;
    }
    
    public void searchData (DatabaseConnection db, String query, String threshold) {
       
        try {
            db.stmt = db.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            db.rs = db.stmt.executeQuery(query);
        } catch (SQLException err) {
            MessageDialogs.noConnectionError(err.getMessage());
        }
    }
    
    // only select locations who have more than threshold hours lpgged a year
    /*public ArrayList<String> filterLocs (String starty, String endy, ArrayList<String> locs, String threshold) {
        TO DO
    }*/
}
