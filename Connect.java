
package alumnimanager.databaseAssisstant;

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class Connect {
   Connection conn = null;
   private static String path = "\\src\\alumnimanager\\database01.db";
   
     private static Statement stmt = null;
     
      private Connect(){}
             
      
       public static Connection ConnectDB(){
           try{
               Class.forName("org.sqlite.JDBC");
               String url = "jdbc:sqlite:" + path;
               Connection conn = DriverManager.getConnection(url);
               JOptionPane.showMessageDialog(null, "Connect");
               System.out.println("etienne");
               return conn;
               
           } catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
           }
           return null;
       }
       //SQL-structured query language
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
    }

}

