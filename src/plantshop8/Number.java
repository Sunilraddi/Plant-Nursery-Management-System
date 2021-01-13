package plantshop8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Akash Pawar
 */
public class Number {
    public static int getCount(int num) {
        int count = 0;
        while(num != 0)
        {
            num /= 10;
            ++count;
        }
        return count;     
    } 
    
    public static boolean isNumber(String str) { 
        try{  
            Integer.parseInt(str);  
            return true;
        } 
        catch(NumberFormatException e){  
            return false;  
        }  
    }
    
    public static String noOfRecord(String tblName, String colName, String recID) throws SQLException, ClassNotFoundException{
        Connection con;
        con = ConnectTo.getConnection();
        String psString = "SELECT COUNT(*) FROM " +tblName+
            " WHERE "+colName+"< (SELECT "+colName+" FROM "+tblName+" WHERE "+colName+" = \""+recID+"\");";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement
            (psString);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int n = rs.getInt(1);
            n+=1;
            String ans = Integer.toString(n);
            //JOptionPane.showMessageDialog(null, ans);
            con.close();
            ps.close();
            rs.close();
            return ans;
        }      
        return null;
    }
    
    public static String totalRecords(String tblName) throws SQLException, ClassNotFoundException{
        Connection con;
        con = ConnectTo.getConnection();
        String psString = "SELECT COUNT(*) FROM " +tblName+ ";";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement
            (psString);
        ResultSet rs = ps.executeQuery();
        //JOptionPane.showMessageDialog(null, "3");
        if(rs.next()){
            int n = rs.getInt(1);
            String ans = Integer.toString(n);
            con.close();
            ps.close();
            rs.close();
            return ans;
        }      
        return null;
    }
}
