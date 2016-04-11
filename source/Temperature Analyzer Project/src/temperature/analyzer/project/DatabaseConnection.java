/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature.analyzer.project;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
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
    ArrayList<Statement> statements = new ArrayList<>();
    String protocol = "jdbc:derby:";
    public DatabaseConnection() {
        try {
               // Connect to the network database
              // String host = "jdbc:derby://localhost:1527/mytap";
              // String uName = "root";
              // String uPass = "pass";
              // con = DriverManager.getConnection(host, uName, uPass);
              //Connect to embedded database
              Properties props = new Properties();
              String dbName = "mytap";
              con = DriverManager.getConnection(protocol + dbName + ";create=true",
                      props);
              
              stmt = con.createStatement();
              statements.add(stmt);
              con.setAutoCommit(false);
              
              //creates Location table
              String query ="CREATE TABLE APP.LOCATION (\"Symbol\" VARCHAR(3) NOT NULL primary key," +
                                                    "\"Location\" VARCHAR(45) NOT NULL)";
              //creates Sensor Table
              String query2 = "CREATE TABLE APP.SENSOR("+
                                  "\"Serial_Number\" INTEGER NOT NULL primary key," +
                                  "\"Location_Symbol\" VARCHAR(3) REFERENCES APP.LOCATION (\"Symbol\"))";
              //creates Measurement Table
              String query3 = "CREATE TABLE APP.MEASUREMENT (\"Temperature\" DECIMAL (9,4)," +
                 "\"Date\" DATE, \"Time\" TIME,\"Location_Symbol\" VARCHAR(3) NOT NULL "
                 + "REFERENCES APP.Location (\"Symbol\"))";
              
              //add queries
              boolean locationExist = isTableExist("Location", query);
              boolean sensorExist = isTableExist("Sensor", query2);
              boolean measurementExist  = isTableExist("Measurement",query3);
              if(locationExist){
                
                DatabaseMetaData meta = con.getMetaData();
                    try (ResultSet res = meta.getTables(null, null, null, new String[] {"TABLE"})) {
                        System.out.println("List of Tables: ");
                        while (res.next()){
                            System.out.println(res.getString("TABLE_NAME"));
                        }   }
            }
            if(locationExist){
               stmt.execute("Delete From Sensor Where 1=1");
               stmt.execute(loadLocation());
               stmt.execute(loadSensor());
            }

           } catch (SQLException err) {
               MessageDialogs.noConnectionError(err.getMessage());
           }
    }
    private boolean isTableExist(String sTablename, String query) throws SQLException{
        boolean exists = false;
        if(con!=null)
        {
        
            DatabaseMetaData dbmd = con.getMetaData();
            ResultSet db = dbmd.getTables(null, null, sTablename.toUpperCase(),null);
            if(db.next()){
                exists=true;
                    //System.out.println("Table "+db.getString("TABLE_NAME")+"already exists !!");
            }else {
            //System.out.println("Write your create table function here !!!");
            stmt.execute(query);
            }   return exists; }
        return exists;
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
        private String loadSensor() throws SQLException{
        return  "INSERT INTO APP.SENSOR (\"Serial_Number\", \"Location_Symbol\") VALUES " +
"(441384,(select \"Symbol\" from APP.Location where \"Symbol\" = 'OFF'))," +
"(532797, (select \"Symbol\" from APP.Location where \"Symbol\" = 'BMS'))," +
"(532798, (select \"Symbol\" from APP.Location where \"Symbol\" = 'BPA'))," +
"(532800, (select \"Symbol\" from APP.Location where \"Symbol\" = 'HRC'))," +
"(532801, (select \"Symbol\" from APP.Location where \"Symbol\" = 'NPE'))," +
"(533551, (select \"Symbol\" from APP.Location where \"Symbol\" = 'BPT'))," +
"(533560, (select \"Symbol\" from APP.Location where \"Symbol\" = 'EMP'))," +
"(555494, (select \"Symbol\" from APP.Location where \"Symbol\" = 'MEL'))," +
"(555497, (select \"Symbol\" from APP.Location where \"Symbol\" = 'GRV'))," +
"(555498, (select \"Symbol\" from APP.Location where \"Symbol\" = 'MER'))," +
"(555501, (select \"Symbol\" from APP.Location where \"Symbol\" = 'GEP'))," +
"(555502, (select \"Symbol\" from APP.Location where \"Symbol\" = 'WFM'))," +
"(555505, (select \"Symbol\" from APP.Location where \"Symbol\" = 'BOR'))," +
"(555506, (select \"Symbol\" from APP.Location where \"Symbol\" = 'LSP'))," +
"(625100, (select \"Symbol\" from APP.Location where \"Symbol\" = 'MOM'))," +
"(625102, (select \"Symbol\" from APP.Location where \"Symbol\" = 'DIN'))," +
"(695788, (select \"Symbol\" from APP.Location where \"Symbol\" = 'OFF'))," +
"(710736, (select \"Symbol\" from APP.Location where \"Symbol\" = 'MEL'))," +
"(710737, (select \"Symbol\" from APP.Location where \"Symbol\" = 'GOB'))," +
"(710738, (select \"Symbol\" from APP.Location where \"Symbol\" = 'OFF'))," +
"(710739, (select \"Symbol\" from APP.Location where \"Symbol\" = 'SBM'))," +
"(733935, (select \"Symbol\" from APP.Location where \"Symbol\" = 'WME'))," +
"(733936, (select \"Symbol\" from APP.Location where \"Symbol\" = 'GBR'))," +
"(733937, (select \"Symbol\" from APP.Location where \"Symbol\" = 'MEM'))," +
"(733938, (select \"Symbol\" from APP.Location where \"Symbol\" = 'OFF'))," +
"(733939, (select \"Symbol\" from APP.Location where \"Symbol\" = 'CKL'))," +
"(984395, (select \"Symbol\" from APP.Location where \"Symbol\" = 'HWY'))," +
"(1001871, (select \"Symbol\" from APP.Location where \"Symbol\" = 'BRR'))," +
"(1001872, (select \"Symbol\" from APP.Location where \"Symbol\" = 'EDC'))," +
"(1001873, (select \"Symbol\" from APP.Location where \"Symbol\" = 'CCR'))," +
"(1001874, (select \"Symbol\" from APP.Location where \"Symbol\" = 'LPJ'))";

    }
        
 private String loadLocation() throws SQLException{
        stmt.execute("Delete From Location Where 1=1");
        return "INSERT INTO APP.LOCATION VALUES\n" +
"('BMS', 'Bald Mesa'),\n" +
"('BBR', 'Beaver Ba Rd Camp'),\n" +
"('BOR', 'Boren Mesa'),\n" +
"('BRR', 'Brumley Ridge'),\n" +
"('BPA', 'Burro Pass'),\n" +
"('BPT', 'Burro Pass Trail'),\n" +
"('CCR', 'Chicken Creek'),\n" +
"('CKL', 'Clark Lake'),\n" +
"('DIN', 'Dinosaur Tracks'),\n" +
"('DFM', 'Dry Fork Mill Cr'),\n" +
"('EDC', 'E. Dark Canyon'),\n" +
"('EMP', 'E. Mt. Peale'),\n" +
"('GEP', 'Geyser Pass'),\n" +
"('GOB', 'Gold Basin'),\n" +
"('GBR', 'Gold Basin Road'),\n" +
"('GRV', 'Grandview'),\n" +
"('HRC', 'Horse Creek'),\n" +
"('HWY', 'Hwy 46 La Sal'),\n" +
"('LSP', 'La Sal Pass'),\n" +
"('LPJ', 'L SAl Pass Jct'),\n" +
"('LSS', 'La Sal SNOTEL site'),\n" +
"('LBB', 'Lower Beaver Basin'),\n" +
"('LGP', 'Lower Geyser Pa Rd'),\n" +
"('MER', 'Mellenthin E Ridge'),\n" +
"('MEM', 'Mellenthin Meadows'),\n" +
"('MOM', 'Moonlight Meadows'),\n" +
"('MEL', 'Mt. Mellenthin'),\n" +
"('NPE', 'N. Peale RG'),\n" +
"('SBM', 'South Beaver Mesa'),\n" +
"('UBB', 'Upper Beaver Basin'),\n" +
"('UD1', 'Upper Dark Canyon'),\n" +
"('UDC', 'Upper Dark Canyon 2'),\n" +
"('WME', 'Warner Meadows'),\n" +
"('WFM', 'Wet Fork Mill Cr'),\n" +
"('OFF', 'Office')";    
 }
    // Funciton to check if a location is unique
    public boolean canAdd(String code, String loc) {
        boolean canAdd = false;
        try {
            this.stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM APP.Location WHERE \"Symbol\" = '" +
                    code + "' OR  \"Location\" = '" + loc + "'";
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
            this.stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM APP.Location WHERE \"Symbol\" = '" +
                    code + "' AND  \"Location\" = '" + loc + "'";
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
            this.stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
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
                String SQL = "DELETE FROM APP.Location WHERE \"Symbol\" = '" +
                        code + "' AND \"Location\" = '" + loc + "'";
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
            String SQL = "UPDATE APP.Sensor SET \"Location_Symbol\" = '" +
                    newLoc + "' WHERE \"Serial_Number\" IN " + toMove;
            
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
            this.stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
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
            this.stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
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
            db.stmt = db.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            db.rs = db.stmt.executeQuery(query);
        } catch (SQLException err) {
            MessageDialogs.noConnectionError(err.getMessage());
        }
    }
    
    /* only select locations who have more than threshold hours logged a year
    public ArrayList<String> filterLocs (String starty, String endy,
        ArrayList<String> locs, String threshold) {
        ArrayList<String> ret = new ArrayList<>();
        // TODO (?)
        
        
        return ret;
    } */
}
