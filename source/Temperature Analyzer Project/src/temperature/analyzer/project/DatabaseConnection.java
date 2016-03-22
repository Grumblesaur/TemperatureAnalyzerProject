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
            String id;
            if (curRow == 0){
                id = "1";
            }
            else {
               rs.last();
               curRow= rs.getInt("#") + 1; 
               id = Integer.toString(curRow);
            }
       
            String SQL = "INSERT INTO APP.Tester VALUES("+ id + ", "+ loc + ", " + date + ", " + temp +")";
            stmt = this.con.createStatement();
            stmt.executeUpdate(SQL);
         
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
}
