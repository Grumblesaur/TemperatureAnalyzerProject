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

import static temperature.analyzer.project.TemperatureAnalyzerProject.debug;

/**
 *
 * @author ruth
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
    
    public void addData(String loc, String date, String temp){
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM APP.Tester";
            rs = stmt.executeQuery(SQL);
            
            rs.last();
            int id_num = rs.getRow() + 1;
            
                     
            rs.moveToInsertRow();
            
            rs.updateInt("ID", id_num);
            rs.updateString("Location", loc);
            rs.updateString("Date", date);
            rs.updateString("Temp", temp);
            
            rs.insertRow();
            
            stmt.close();
            rs.close();
            
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM APP.Tester";
            rs = stmt.executeQuery(SQL);
                
        } 
        catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        /*
        
        try {
            String id;
            if (!rs.last()){
                id = "1";
            }
            else {
               rs.last();
               id = rs.getString("ID"); 
               curRow = Integer.parseInt(id) + 1;
               id = String.valueOf(curRow);
            }
       
            
            MessageDialogs.DEBUG("Inserting", debug);
            String SQL = "INSERT INTO APP.Tester VALUES("+ loc + ", " + date + ", " + temp +")";
            stmt = this.con.createStatement();
            stmt.executeUpdate(SQL);
         
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }*/
    }
}
