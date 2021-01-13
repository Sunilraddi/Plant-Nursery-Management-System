/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantshop8;

import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Akash Pawar
 */
public class myNotification {
    public static void set(){
        try{
            Connection conn;
            conn = ConnectTo.getConnection();
            Date today = Date.valueOf(LocalDate.now());
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement
                ("select count(*) from notify;");
            ResultSet rs1 = ps.executeQuery();
            if(rs1.next()){
                int count = rs1.getInt(1);                       
                try{
                    String tblName = "notify";
                    String EorNot = checkEmpty.isTableEmpty(tblName);
                    if(EorNot.equals("notEmpty")){
                        for(int i=1 ; i<998; i++){
                            int next_id = i + 1;
                            int NoOfDigits = plantshop8.Number.getCount(next_id) + 1;
                            String final_id;
                            try {
                                final_id = FinalID.getID("N", i, NoOfDigits);
                                try{  
                                    PreparedStatement st1 = (PreparedStatement) conn.prepareStatement
                                        ("select nid from notify where nid=?;");
                                    st1.setString(1, final_id);
                                    ResultSet rs2 = st1.executeQuery();
                                    if(rs2.next()){
                                        String NID = rs2.getString("NID");
                                        for(int j=0; j<count; j++){
                                            //PreparedStatement p = (PreparedStatement) conn.prepareStatement
                                            //   ("select * from notify where NID = (select min(NID) from notify where NID > \""+NID+"\");");
                                            String status = "Active";
                                            PreparedStatement ps1 = (PreparedStatement) conn.prepareStatement
                                                ("select * from notify where notifyOn = \""+today+"\" && NID = \""+NID+"\" && status = \""+status+"\";");
                                            ResultSet rsps1 = ps1.executeQuery();
                                            
                                            if(rsps1.next()){
                                                String PID = rsps1.getString("PID");
                                                Date N_entryDate = rsps1.getDate("N_entryDate");
                                                Date notifyOn = rsps1.getDate("notifyOn");
                                                String Note = rsps1.getString("notifyNote");
                                                
                                                PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement
                                                    ("select P_Name, P_SciName from plants_data where PID = \""+PID+"\";");
                                                ResultSet rsps2 = ps2.executeQuery();
                                                if(rsps2.next()){
                                                    String PName = rsps2.getString("P_Name");
                                                    String PSciName = rsps2.getString("P_SciName");
                                                    
                                                    //Obtain only one instance of the SystemTray object
                                                    SystemTray tray = SystemTray.getSystemTray();

                                                    //If the icon is a file
                                                    Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
                                                    //Alternative (if the icon is on the classpath):
                                                    //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

                                                    TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
                                                    //Let the system resize the image if needed
                                                    trayIcon.setImageAutoSize(true);
                                                    //Set tooltip text for the tray icon
                                                    trayIcon.setToolTip("System tray icon demo");
                                                    tray.add(trayIcon);

                                                    trayIcon.displayMessage("Blue Blossoms - 🌸 Plant Alert!",PID+" - "+PName+" - "+PSciName+
                                                            "\nNotification set for : "+notifyOn+"\nEntry Date : "+N_entryDate+"\nNote : "+Note, 
                                                            TrayIcon.MessageType.NONE);
                                                    
                                                    ps2.close();
                                                    rsps2.close();
                                                break;
                                                }
                                            }
                                            ps1.close();
                                            rsps1.close();
                                        }
                                    }
                                }
                                catch(SQLException e){
                                    JOptionPane.showMessageDialog(null, e);
                                }
                            }
                            catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }
                        }
                    }
                }
                catch(ClassNotFoundException | SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
                rs1.close();
            }
            ps.close();
        }   
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
