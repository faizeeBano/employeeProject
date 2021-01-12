/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empMgmtApp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class DBConnection {
    private static Connection conn;
    static{
      try
      {
          Class.forName("oracle.jdbc.OracleDriver");
          conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","jarvis");   
          JOptionPane.showMessageDialog(null,"Connected Successfully to db");
          
      }
      catch(Exception ex)
      {
          ex.printStackTrace();
          JOptionPane.showMessageDialog(null,"Error in Connection");
      }
      
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {
            conn.close();
        }
        catch(Exception ex)
      {
          ex.printStackTrace();
          JOptionPane.showMessageDialog(null,"Can not close the Connection");
      }
    }
}