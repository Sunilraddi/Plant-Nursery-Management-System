/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantshop8;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import keeptoo.KButton;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Akash Pawar
 */
public class displayTable {
    public static void all(String tblname, JTable table, JLabel lbl, KButton btn){
        try{
            table.setVisible(true);
            lbl.setText(btn.getText());
            Connection con;
            con = ConnectTo.getConnection();
            String psString = "select * from "+tblname;
            PreparedStatement ps = (PreparedStatement) con.prepareStatement
                (psString);
            ResultSet rs = ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            ps.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void setSingle(JTable table, ResultSet rs){
        try{
            table.setVisible(true);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e); 
        }
    }
    
    public static void tblSearch(String tblName, String colName, String searchString, JTable table){
        try{
            Connection con;
            con = ConnectTo.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement
                ("select * from "+tblName+" where "+colName+" like \'%"+searchString+"%\';");
            ResultSet rs = ps.executeQuery();
            displayTable.setSingle(table, rs);                            
            ps.close();
            rs.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void listCheck(String tblName, String colName, JTable table, String abc){
        try{
            Connection con;
            con = ConnectTo.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement
                ("select * from "+tblName+" where "+colName+" like \'%"+abc+"%\';");
            ResultSet rs = ps.executeQuery();
            displayTable.setSingle(table, rs);                            
            ps.close();
            rs.close();
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static String getClickedID(JTable table){
        try{
            ListSelectionModel model = table.getSelectionModel();
            if(!model.isSelectionEmpty()){
                int selectedRow =model.getMinSelectionIndex();
                String id = table.getModel().getValueAt(selectedRow, 0).toString();
                //JOptionPane.showMessageDialog(null, id);
                return id;
            } 
        }
        catch(HeadlessException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return null;
    }
    
    public static void top5(String choice,JXDatePicker from, JXDatePicker to, JTable table, JLabel lbl, JPanel printPanel){
        try{
            String TEorNot = checkEmpty.isTableEmpty("sold");
            if(TEorNot.equals("Empty")){
                JOptionPane.showMessageDialog(null, "No plants sold yet.");
            }
            else{
                if((from.getDate() == null) && (to.getDate() == null)){
                    JOptionPane.showMessageDialog(null, "Please enter both the dates!");
                }
                else{
                    Date today = Date.valueOf(LocalDate.now());
                    java.sql.Date queryDateFrom = new java.sql.Date(from.getDate().getTime());
                    java.sql.Date queryDateTo = new java.sql.Date(to.getDate().getTime());
                    
                        if((queryDateFrom.before(today) || queryDateFrom.equals(today)) && 
                            (queryDateTo.before(today) || queryDateTo.equals(today))){
                            if(queryDateFrom.before(queryDateTo)){
                                try{
                                    Connection con;
                                    con = ConnectTo.getConnection();
                                    PreparedStatement ps1 = (PreparedStatement) con.prepareStatement
                                        ("select PID,Stock_ID,sum(quantity) as Quantity from sold where plant_issue_date"
                                         + " between \""+queryDateFrom+"\" and \""+queryDateTo+"\" group by PID order by sum(quantity) desc limit 5;");
                                    PreparedStatement ps2 = (PreparedStatement) con.prepareStatement
                                        ("select PID,Stock_ID,sum(quantity) as Quantity from sold where plant_issue_date"
                                         + " between \""+queryDateFrom+"\" and \""+queryDateTo+"\" group by PID order by sum(quantity) limit 5;");
                                    if(choice.equals("most")){
                                        ResultSet rs = ps1.executeQuery();
                                        table.setVisible(true);
                                        lbl.setText(null);
                                        table.setModel(DbUtils.resultSetToTableModel(rs)); 
                                        printPanel.setVisible(true);
                                        rs.close();
                                        ps1.close();
                                        con.close();
                                    }
                                    if(choice.equals("least")){
                                        ResultSet rs = ps2.executeQuery();
                                        table.setVisible(true);
                                        lbl.setText(null);
                                        table.setModel(DbUtils.resultSetToTableModel(rs)); 
                                        printPanel.setVisible(true);
                                        rs.close();
                                        ps2.close();
                                        con.close();
                                    }                                                       
                                }
                                catch(ClassNotFoundException | SQLException e){
                                    JOptionPane.showMessageDialog(null, e);
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "The FROM date should appear before TO date.");
                            }               
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "You cannot select the date\nof the day yet to appear.");
                        }                                     
                }              
            }
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
