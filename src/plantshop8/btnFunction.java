/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantshop8;

import Operations_package.Operations;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Akash Pawar
 */
public class btnFunction {
    public static String AddNew(JPanel parentPanel, JPanel addPanel, String tblName, String colName,
            int maxRecords, int substringLimit, String Alphabet){
        try{
            Connection con;
            con = ConnectTo.getConnection();
            String psString = "select "+colName+" from "+tblName+" order by "+colName+" desc limit 1";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement
                (psString);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String strID = rs.getString(colName);
                int intID = Integer.parseInt(strID.substring(1, substringLimit));
                if(intID <= maxRecords - 1){
                    parentPanel.setVisible(false);
                    addPanel.setVisible(true);
                    int next_id = intID + 1;
                    int NoOfDigits = Number.getCount(next_id) + 1;
                    
                    String final_id;
                    try {
                        final_id = FinalID.getID(Alphabet, next_id, NoOfDigits); 
                        try{
                            String REorNot = checkEmpty.isRecordExist(tblName, colName, final_id);
                            if(REorNot.equals("notExists")){
                                return final_id;      
                            }                          
                        }
                        catch(ClassNotFoundException | SQLException e){
                            JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
                        }  
                    } 
                    catch (Exception ex) {
                        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }  
                else{
                    JOptionPane.showMessageDialog(null, "Database full. Contact the developer!");
                }
            }
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public static void Delete(String ID, String tblName, String colName, JPanel parentPanel, JPanel addPanel){
        int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this record?");
        if(JOptionPane.YES_OPTION == result){
            int result1 = JOptionPane.showConfirmDialog(null,"You won't be able to recover the deleted record?\n\nSure to proceed?");
            if(JOptionPane.YES_OPTION == result1){
                try{
                    Connection con;
                    con = ConnectTo.getConnection();
                    try{
                        String EorNot = checkEmpty.isTableEmpty(tblName);
                        if(EorNot.equals(("Empty"))){
                            JOptionPane.showMessageDialog(null, "The database is empty\n Add a record to proceed further!");
                            parentPanel.setVisible(false);
                            addPanel.setVisible(true);
                        }
                        if(EorNot.equals("notEmpty")){
                            String recEorNot = checkEmpty.isRecordExist(tblName, colName, ID);
                            if(recEorNot.equals("Exists")){
                                String psString1 = "delete from "+tblName+" where "+colName+" = \""+ID+"\"";
                                PreparedStatement st1 = (PreparedStatement) con.prepareStatement
                                   (psString1);
                                if(ID.substring(0,1).equals("P")){
                                    PreparedStatement st2 = (PreparedStatement) con.prepareStatement
                                        ("delete from stock where pid=?;");
                                    st2.setString(1, ID);
                                    int n1 = st1.executeUpdate();
                                    int n2 = st2.executeUpdate();
                                    if(n1==1 && n2==1){
                                        JOptionPane.showMessageDialog(null,"Record deleted.");
                                        try{
                                            String EorNot1 = checkEmpty.isTableEmpty(tblName);
                                            if(EorNot1.equals("Empty")){
                                                JOptionPane.showMessageDialog(null, "The record table is empty."
                                                    + "\nAdd a record to proceed further.");
                                            }
                                            if(EorNot1.equals("notEmpty")){
                                                JOptionPane.showMessageDialog(null,"Press the Previous or the Next button to refresh the records.");
                                            }
                                        }
                                        catch(HeadlessException | SQLException e){
                                            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                                        }
                                    }
                                    st1.close();
                                    st2.close();
                                }
                                if(ID.substring(0,1).equals("G") || ID.substring(0,1).equals("H")){
                                    int n1 = st1.executeUpdate();
                                    if(n1==1){
                                        JOptionPane.showMessageDialog(null,"Record deleted.");
                                        try{
                                            String EorNot1 = checkEmpty.isTableEmpty(tblName);
                                            if(EorNot1.equals("Empty")){
                                                JOptionPane.showMessageDialog(null, "The record table is empty."
                                                    + "\nAdd a record to proceed further.");
                                            }
                                            if(EorNot1.equals("notEmpty")){
                                                JOptionPane.showMessageDialog(null,"Press the Previous or the Next button to refresh the records.");
                                            }
                                        }
                                        catch(HeadlessException | SQLException e){
                                            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                                        }
                                    }
                                    st1.close();
                                    }
                            }
                            if(recEorNot.equals("notExists")){
                                JOptionPane.showMessageDialog(null, "This record has already been altered / deleted."
                                    + "\n\nNote :\nAlways remember to refresh the screen "
                                    + "\nafter adding / updating / deleting record(s).");
                            }    
                        }                              
                    }
                    catch(HeadlessException | SQLException e){
                        JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                    }    
                    con.close();
                }
                catch(HeadlessException | ClassNotFoundException | SQLException e){
                    JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                }
            }
        }
    }
}
