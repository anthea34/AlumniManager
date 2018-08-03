
package alumnimanager.databaseAssisstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public final class DatabaseHandler {
    
    
   /** private static DatabaseHandler handler;
        
    private static final String DB_URL = "jdbc:derby:database;create=true";    
    private static Connection conn = null;
    private static Statement stmt = null;
    
    public DatabaseHandler(){
        createConnection();
        setupProfileTable();
    }
   
    
     void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_URL);
            }
        catch (Exception e) {
            e.printStackTrace();
        }
     }
     
     void setupProfileTable(){
        String TABLE_NAME = "PROFILE";
         
         try{
             stmt = conn.createStatement();
             DatabaseMetaData dbm = conn.getMetaData();
             ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null); 
             if(tables.next()){
                 System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
                              }             else{

                    stmt.execute("CREATE TABLE" + TABLE_NAME + "("
                            + "       alumName varchar(80) primary key,\n"
                            + "       gender varchar(10),\n"
                            + "       birthdate varchar(8),\n"
                            + "       gradYear varchar(4),\n"
                            + "       country varchar(50),\n"
                            + "       occupation varchar(30),\n"
                            + "       email varchar(50),\n"
                            + "  )" );
                 }
            }
         catch(SQLException e){
            System.err.println(e.getMessage() + "...setupDatabase");
        } finally {
                  }
     }
     public ResultSet execQuery(String query) {
        ResultSet result;
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        }
        catch (SQLException ex) {
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return null;
        }
        finally {
        }
        return result;
    }

    public boolean execAction(String qu) {
        try {
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return false;
        }
        finally {
        }
        * }
   **/ 
}
