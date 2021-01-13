package plantshop8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Akash Pawar
 */
public class checkEmpty {
    public static String isTableEmpty(String tableName) throws SQLException, ClassNotFoundException{
        String ans = null;
        Connection con;
        con = ConnectTo.getConnection();
        String psString = ("select exists(select 1 from "+ tableName +");");
        PreparedStatement ps = (PreparedStatement) con.prepareStatement
            (psString);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            if(rs.getInt(1)==0){
                ans = "Empty";
            }
            if(rs.getInt(1)==1){
                ans = "notEmpty";
            }
        }      
        con.close();
        ps.close();
        rs.close();
        return ans;
    }
    
    public static String isRecordExist(String tableName, String recordName, String recordID) throws SQLException, ClassNotFoundException{
        String ans = null;
        Connection con;
        con = ConnectTo.getConnection();
        String psString = ("select exists(select 1 from "+ tableName +" where "+ recordName +" = \""+recordID+"\");");
        PreparedStatement ps = (PreparedStatement) con.prepareStatement
            (psString);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            if(rs.getInt(1)==0){
                ans = "notExists";
            }
            if(rs.getInt(1)==1){
                ans = "Exists";
            }
        }      
        con.close();
        ps.close();
        rs.close();
        return ans;     
    }
}