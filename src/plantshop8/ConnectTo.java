/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantshop8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Akash Pawar
 */
public class ConnectTo {

    //private final String conn;
    public static Connection con;
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/";
            String dbname ="plantshop";
            String user = "root";
            String pass = "root";
        
            Class.forName(driver);
            Connection con = (Connection)
               DriverManager.getConnection
                (url+dbname+"?autoReconnect=true&"
                + "useUnicode=true&"
                + "characterEncoding=UTF-8&"
                + "zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&"
                + "jdbcCompliantTruncation=false&"
                + "useSSL=false&"
                + "maxReconnects=10",
                user, pass);

            return con; 
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
