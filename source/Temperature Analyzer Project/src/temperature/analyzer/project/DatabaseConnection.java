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
import javax.swing.JOptionPane;

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
    
    public void addData(DatabaseConnection db, String loc, String date, String temp){
        try {
            db.stmt = db.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM APP.Tester";
            db.rs = db.stmt.executeQuery(SQL);
            
            db.rs.last();
            int id_num = db.rs.getRow() + 1;
            
            db.rs.moveToInsertRow();
            
            db.rs.updateInt("ID", id_num);
            db.rs.updateString("Location", loc);
            db.rs.updateString("Date", date);
            db.rs.updateString("Temp", temp);
            
            db.rs.insertRow();
            
            db.stmt.close();
            db.rs.close();
            
            db.stmt = db.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM APP.Tester";
            db.rs = db.stmt.executeQuery(SQL);
                
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
    
    // Function to add a location the the database

    /**
     *
     * @param code
     * @param loc
     */
    public void addLoc(String code, String loc){
        try {
            this.stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM APP.Location";
            this.rs = this.stmt.executeQuery(SQL);
            
            this.rs.last();

            this.rs.moveToInsertRow();

            this.rs.updateString("Symbol", code);
            this.rs.updateString("Location", loc);

            this.rs.insertRow();

            this.stmt.close();
            this.rs.close();

            this.stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM APP.Location";
            this.rs = this.stmt.executeQuery(SQL);
            
        } catch (SQLException err) {
            MessageDialogs.noConnectionError(err.getMessage());
        }
    }
    
    public boolean removeLoc(String code, String loc){
        boolean done = false;
        try {
            if (!this.checkDependency(code)) {
                String SQL = "DELETE FROM APP.Location WHERE \"Symbol\" = '" + code + "' AND \"Location\" = '" + loc + "'";
                this.stmt.executeUpdate(SQL);
                done = true;

                this.stmt.close();

                this.stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                SQL = "SELECT * FROM APP.Location";
                this.rs = this.stmt.executeQuery(SQL);
            }
            else {
                MessageDialogs.dependent();
            }
            
        } catch (SQLException err) {
            MessageDialogs.noConnectionError(err.getMessage());
        }
        return done;
    }
    
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
