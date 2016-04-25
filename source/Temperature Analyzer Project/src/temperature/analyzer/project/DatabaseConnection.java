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
    
    
    String dbName = "mytap";
    String protocol = "jdbc:derby:";
    private String dbURL = protocol + dbName + ";create=true";
    public DatabaseConnection() {
        try {
            // Connect to the network database
            // String host = "jdbc:derby://localhost:1527/mytap";
            // String uName = "root";
            // String uPass = "pass";
            // con = DriverManager.getConnection(host, uName, uPass);
            //Connect to embedded database
            
            Properties props = new Properties();
            con = DriverManager.getConnection(dbURL, props);
            con.setAutoCommit(true);
            
            stmt = con.createStatement();
            statements.add(stmt);
            con.setAutoCommit(false);

            //creates Location table
            String query ="CREATE TABLE LOCATION (\"Symbol\" VARCHAR(3) NOT NULL primary key," +
                                                  "\"Location\" VARCHAR(45) NOT NULL)";
            //creates Sensor Table
            String query2 = "CREATE TABLE SENSOR("+
                                "\"Serial_Number\" INTEGER NOT NULL primary key," +
                                "\"Location_Symbol\" VARCHAR(3) REFERENCES LOCATION (\"Symbol\"))";
            //creates Measurement Table
            String query3 = "CREATE TABLE MEASUREMENT (\"Temperature\" DECIMAL (9,4)," +
               "\"Date\" DATE, \"Time\" TIME,\"Location_Symbol\" VARCHAR(3) NOT NULL "
               + "REFERENCES LOCATION (\"Symbol\"))";

            //add queries
            boolean locationExist = isTableExist("Location", query);
            boolean sensorExist = isTableExist("Sensor", query2);
            boolean measurementExist  = isTableExist("Measurement",query3);
            
            if(!locationExist){
               stmt.execute(loadLocation());
            }
            if(!sensorExist){
               stmt.execute(loadSensor());
            }

        } catch (SQLException err) {
            MessageDialogs.noConnectionError(err.getMessage());
            if (err.getNextException() !=null) {
                MessageDialogs.noConnectionError(err.getNextException().getMessage());
            }
        }
    }
    
    private boolean isTableExist(String sTablename, String query) throws SQLException{
        boolean exists = false;
        if(con!=null) {
            DatabaseMetaData dbmd = con.getMetaData();
            try (ResultSet db = dbmd.getTables(null, null, sTablename.toUpperCase(),null)) {
                if (db.next()) {
                    exists=true;
                    //System.out.println("Table "+db.getString("TABLE_NAME")+"already exists !!");
                } else {
                    //System.out.println("Write your create table function here !!!");
                    // XXX: Do we need this code if it's not necessary for determining if a table exists?
                    stmt.execute(query);
                }
            }
        }
        return exists;
    }   
    
    private String loadSensor() {
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
        
    private String loadLocation() {
        return "INSERT INTO APP.LOCATION VALUES ('BMS', 'Bald Mesa')," +
            "('BBR', 'Beaver Ba Rd Camp'), ('BOR', 'Boren Mesa')," +
            "('BRR', 'Brumley Ridge'), ('BPA', 'Burro Pass')," +
            "('BPT', 'Burro Pass Trail'), ('CCR', 'Chicken Creek')," +
            "('CKL', 'Clark Lake'), ('DIN', 'Dinosaur Tracks')," +
            "('DFM', 'Dry Fork Mill Cr'), ('EDC', 'E. Dark Canyon')," +
            "('EMP', 'E. Mt. Peale'), ('GEP', 'Geyser Pass')," +
            "('GOB', 'Gold Basin'), ('GBR', 'Gold Basin Road')," +
            "('GRV', 'Grandview'), ('HRC', 'Horse Creek')," +
            "('HWY', 'Hwy 46 La Sal'), ('LSP', 'La Sal Pass')," +
            "('LPJ', 'L SAl Pass Jct'), ('LSS', 'La Sal SNOTEL site')," +
            "('LBB', 'Lower Beaver Basin'), ('LGP', 'Lower Geyser Pa Rd')," +
            "('MER', 'Mellenthin E Ridge'), ('MEM', 'Mellenthin Meadows')," +
            "('MOM', 'Moonlight Meadows'), ('MEL', 'Mt. Mellenthin')," +
            "('NPE', 'N. Peale RG'), ('SBM', 'South Beaver Mesa')," +
            "('UBB', 'Upper Beaver Basin'), ('UD1', 'Upper Dark Canyon')," +
            "('UDC', 'Upper Dark Canyon 2'), ('WME', 'Warner Meadows')," +
            "('WFM', 'Wet Fork Mill Cr'), ('OFF', 'Office')";    
 }
    
    public void save() {
        try {
            if (this.rs != null) {
                this.rs.close();
            }
            if (this.stmt != null) {
                this.stmt.close();
            }
            if (this.con != null) {
                this.con.commit();
                DriverManager.getConnection(dbURL + ";shutdown=true");
                this.con.close();
            }           
        } catch (SQLException err) {
            MessageDialogs.noConnectionError(err.getMessage());
        }

    }
    
    public void addData(DatabaseConnection db, String loc, String date, String time, String temp){
        try {
            String SQL = "INSERT INTO Measurement VALUES (" + temp +
                ", '" + date + "', '" + time + "', (SELECT \"Symbol\" FROM" +
                " LOCATION WHERE \"Symbol\" = '" + loc + "'))"; 
           
            //MessageDialogs.DEBUG(SQL, debug);
            db.stmt = db.con.createStatement();
            db.stmt.executeUpdate(SQL);
            db.stmt.close();
            
        } catch (SQLException err) {
            MessageDialogs.noConnectionError(err.getMessage());
        }
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
            codeRS.close();
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
            String SQL = "SELECT * FROM Location WHERE \"Symbol\" = '" +
                    code + "' AND  \"Location\" = '" + loc + "'";
            ResultSet codeRS = this.stmt.executeQuery(SQL);
            if (!codeRS.isBeforeFirst()){
                //here if RS is empty
                exist = false;
            }
            codeRS.close();
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
            String SQL = "SELECT * FROM Sensor WHERE \"Serial_Number\" = " + serial;
            ResultSet codeRS = this.stmt.executeQuery(SQL);
            if (!codeRS.isBeforeFirst()){
                //here if RS is empty
                exist = false;
            }
            codeRS.close();
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
            String SQL = "INSERT INTO Location VALUES ('" + code + "', '" + loc + "')";
            this.stmt.executeUpdate(SQL);
                               MessageDialogs.confirm("Location Deleted Successfully");

            
        } catch (SQLException err) {
            MessageDialogs.noConnectionError(err.getMessage());
        }
    }
    
    // Function to remove a location from the table
    public boolean removeLoc(String code, String loc){
        boolean done = false;
        try {
            if (!this.checkDependency(code)) {
                String SQL = "DELETE FROM Location WHERE \"Symbol\" = '" +
                        code + "' AND \"Location\" = '" + loc + "'";
                this.stmt = con.createStatement();
                this.stmt.executeUpdate(SQL);
                done = true;
                
            } else {
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
            String SQL = "UPDATE Sensor SET \"Location_Symbol\" = '" +
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
            String SQL = "INSERT INTO Sensor VALUES (" + serial;
            SQL = SQL + ", (select \"Symbol\" from Location where \"Symbol\" = 'OFF'))";
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
            String SQL = "DELETE FROM Sensor WHERE \"Serial_Number\" = " + s;
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
            String SQL = "SELECT * FROM Sensor WHERE \"Location_Symbol\" = '"+ c + "'";
            ResultSet test = this.stmt.executeQuery(SQL);
            
            if (test.isBeforeFirst()) {
                exists = true;
            }
            test.close();
            this.stmt.close();
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
