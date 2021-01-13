/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantshop8;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Akash Pawar
 */
public class cmbBox {
    public static void addtocmbBox(String tblName, String colName, JComboBox cmbBoxName){
        List<String> ls = new ArrayList<>();
        try {
            Connection con;
            con = ConnectTo.getConnection();
            try{
                String psString = "select "+colName+" from "+ tblName;
                PreparedStatement ps =  (PreparedStatement) con.prepareStatement
                    (psString);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){         
                    String pat = rs.getString(colName);
                    ls.add(pat);
                    cmbBoxName.removeAllItems();                   
                    cmbBoxName.setModel(new DefaultComboBoxModel<>(ls.toArray(new String[0])));
                }
                ps.close();
                rs.close();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
            }  
            con.close();
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
        }
    }
}
