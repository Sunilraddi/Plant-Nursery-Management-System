package Operations_package;

import Login_package.LoginPanel;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import plantshop8.ConnectTo;
import plantshop8.Number;
import plantshop8.FinalID;
import plantshop8.btnFunction;
import plantshop8.checkEmpty;
import plantshop8.cmbBox;
import plantshop8.displayTable;
import plantshop8.printThis;
import plantshop8.verify;

/**
 *
 * @author Akash Pawar
 */
public class Operations extends javax.swing.JFrame {
    
    ButtonGroup Lists_btnGrp_Search;
    ButtonGroup Navigate_btnGrp_Search;
    ButtonGroup NavigateAdd_btnGrp_Exp;
    ButtonGroup NavigateModify_btnGrp_Exp;
    
    public Operations(String username) {
        setUndecorated(true);
        initComponents();
        top_lbl_username.setText(username);
        
        Lists_btnGrp_Search = new ButtonGroup();
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByPName);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByPID);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByPtag);       
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByGID);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByGName);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByHName);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByHID);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByHybrid); 
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByNID);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchBynotifyPID);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByEntryDate);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByNotificationDate);    
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByPlantIssueID);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchBysoldPID);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByCustomerName);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchBySellingDate);        
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByStockID);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchBystockPID);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByPQuantity);
        Lists_btnGrp_Search.add(Lists_rdbtn_SearchByPPrice);     
        
        NavigateAdd_btnGrp_Exp = new ButtonGroup();
        NavigateAdd_btnGrp_Exp.add(NavigateAdd_rdbtn_ExpYes);
        NavigateAdd_btnGrp_Exp.add(NavigateAdd_rdbtn_ExpNo);
        
        NavigateModify_btnGrp_Exp = new ButtonGroup();
        NavigateModify_btnGrp_Exp.add(NavigateModify_rdbtn_ExpYes);
        NavigateModify_btnGrp_Exp.add(NavigateModify_rdbtn_ExpNo);
        /*
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        System.out.println("Screen Bounds: " + bounds );

        GraphicsDevice screen = env.getDefaultScreenDevice();
        GraphicsConfiguration config = screen.getDefaultConfiguration();
        System.out.println("Screen Size  : " + config.getBounds());
        */           
        Start_InsidePanel.setBackground(new Color(0,0,0,120));       
        Lists_InsidePanel.setBackground(new Color(0,0,0,120));       
        Navigate_InsidePanel.setBackground(new Color(0,0,0,120));
        Navigate_InsidePanel_2.setBackground(new Color(0,0,0,0));
        NavigateAdd_InsidePanel.setBackground(new Color(0,0,0,120));
        NavigateModify_InsidePanel.setBackground(new Color(0,0,0,120));     
        Garden_InsidePanel.setBackground(new Color(0,0,0,120));
        Garden_InsidePanel_2.setBackground(new Color(0,0,0,0));
        GardenAdd_InsidePanel.setBackground(new Color(0,0,0,120));
        GardenModify_InsidePanel.setBackground(new Color(0,0,0,120));      
        Hybrid_InsidePanel.setBackground(new Color(0,0,0,120));
        Hybrid_InsidePanel_2.setBackground(new Color(0,0,0,0));
        HybridAdd_InsidePanel.setBackground(new Color(0,0,0,120));
        HybridModify_InsidePanel.setBackground(new Color(0,0,0,120));       
        Notify_InsidePanel.setBackground(new Color(0,0,0,120));       
        Report_InsidePanel.setBackground(new Color(0,0,0,120));        
        Sell_InsidePanel.setBackground(new Color(0,0,0,120));        
        Settings_InsidePanel.setBackground(new Color(0,0,0,120));
        
        allColorPanelsFalse();
        
        Navigate_ta_PNote.setLineWrap(true);
        Navigate_ta_PNote.setWrapStyleWord(true);
        NavigateAdd_ta_PNote.setLineWrap(true);
        NavigateAdd_ta_PNote.setWrapStyleWord(true);
        NavigateModify_ta_PNote.setLineWrap(true);
        NavigateModify_ta_PNote.setWrapStyleWord(true);       
        Garden_ta_GNote.setLineWrap(true);
        Garden_ta_GNote.setWrapStyleWord(true);
        Garden_ta_GAddress.setLineWrap(true);
        Garden_ta_GAddress.setWrapStyleWord(true);
        GardenAdd_ta_GNote.setLineWrap(true);
        GardenAdd_ta_GNote.setWrapStyleWord(true);
        GardenAdd_ta_GAddress.setLineWrap(true);
        GardenAdd_ta_GAddress.setWrapStyleWord(true);
        GardenModify_ta_GNote.setLineWrap(true);
        GardenModify_ta_GNote.setWrapStyleWord(true);        
        Hybrid_ta_HNote.setLineWrap(true);
        Hybrid_ta_HNote.setWrapStyleWord(true);
        HybridAdd_ta_HNote.setLineWrap(true);
        HybridAdd_ta_HNote.setWrapStyleWord(true);
        HybridModify_ta_HNote.setLineWrap(true);
        HybridModify_ta_HNote.setWrapStyleWord(true);        
        Notify_ta_Note.setLineWrap(true);
        Notify_ta_Note.setWrapStyleWord(true);
        
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void makePanelVisible(JPanel panel){
        Panel_Lists.setVisible(false);  
        Panel_Navigate.setVisible(false);
        Panel_NavigateAdd.setVisible(false);
        Panel_NavigateModify.setVisible(false);        
        Panel_Garden.setVisible(false);
        Panel_GardenAdd.setVisible(false);
        Panel_GardenModify.setVisible(false);       
        Panel_Hybrid.setVisible(false);
        Panel_HybridAdd.setVisible(false);
        Panel_HybridModify.setVisible(false);       
        Panel_Notify.setVisible(false);
        Panel_Sell.setVisible(false);
        Panel_Start.setVisible(false);
        Panel_Settings.setVisible(false);  
        Panel_Report.setVisible(false);
        panel.setVisible(true);
        panel.validate();
    }
    
    void allColorPanelsFalse(){
        Left_colorPanel_Lists.setVisible(false);
        Left_colorPanel_Navigate.setVisible(false);
        Left_colorPanel_Garden.setVisible(false);
        Left_colorPanel_Hybrid.setVisible(false);
        Left_colorPanel_Notify.setVisible(false);
        Left_colorPanel_Sell.setVisible(false);
        Left_colorPanel_Settings.setVisible(false);
        Left_colorPanel_Report.setVisible(false);
    }
    
    void makeColorPanelVisible(JPanel panel){
        allColorPanelsFalse();
        panel.setVisible(true);
    }
    
    void allListsBasePanelFalse(){
        Lists_basePanel_Blank.setVisible(false);
        Lists_basePanel_Plants.setVisible(false);
        Lists_basePanel_Garden.setVisible(false);
        Lists_basePanel_Hybrid.setVisible(false);
        Report_insidePanel_Print.setVisible(false);
    }
    
    void allListsCheckboxUnselected(){
        Lists_btnGrp_Search.clearSelection();
    }
    
    void makeListsBasePanelVisible(JPanel panel){
        allListsBasePanelFalse();
        panel.setVisible(true);
        Report_insidePanel_Print.setVisible(true);
    }
    
    void makeSettingsPanelVisible(JPanel panel){
        Settings_InsidePanel_3_enterPassword.setVisible(false);
        Settings_InsidePanel_3_updatePassword.setVisible(false);
        Settings_InsidePanel_3_updateDetails.setVisible(false);
        panel.setVisible(true);
    }
    
    void setPanelComponentsNull(JPanel panel){
        if(panel == Panel_NavigateAdd){
            NavigateAdd_tb_PName.setText(null);
            NavigateAdd_tb_PSciName.setText(null);
            NavigateAdd_tb_PQuantity.setText(null);
            NavigateAdd_tb_PPrice.setText(null);
            NavigateAdd_tb_PABP.setText("NA");
            NavigateAdd_tb_PTag1.setText(null);
            NavigateAdd_tb_PTag2.setText(null);
            NavigateAdd_tb_PTag3.setText(null);
            NavigateAdd_tb_PTag4.setText(null);
            NavigateAdd_tb_PTag5.setText(null);
            NavigateAdd_ta_PNote.setText(null);
        }
        if(panel == Panel_Navigate){
            Navigate_tb_PID.setText(null);
            Navigate_tb_PName.setText(null);
            Navigate_tb_PSciName.setText(null);
            Navigate_tb_PQuantity.setText(null);
            Navigate_tb_PPrice.setText(null);
            Navigate_tb_PABP.setText(null);
            Navigate_tb_Ptag1.setText(null);
            Navigate_tb_Ptag2.setText(null);
            Navigate_tb_Ptag3.setText(null);
            Navigate_tb_Ptag4.setText(null);
            Navigate_tb_Ptag5.setText(null);
            Navigate_ta_PNote.setText(null);
        }  
        if(panel == Panel_Garden){
            Garden_tb_GID.setText(null);
            Garden_tb_GName.setText(null);
            Garden_ta_GAddress.setText(null);
            Garden_tb_GExpiry.setText(null);
            Garden_ta_GNote.setText(null);
        }
        if(panel == Panel_GardenAdd){
            GardenAdd_tb_GName.setText(null);
            GardenAdd_ta_GAddress.setText(null);
            GardenAdd_ta_GNote.setText(null);
            GardenAdd_dtPicker_GExpiry.setDate(null);
        }              
        if(panel == Panel_Hybrid){
            Hybrid_tb_HID.setText(null);
            Hybrid_tb_HName.setText(null);
            Hybrid_tb_HSpecies1.setText(null);
            Hybrid_tb_HSpecies2.setText(null);
            Hybrid_tb_HSpecies3.setText(null);
            Hybrid_tb_HSpecies4.setText(null);
            Hybrid_tb_HSpecies5.setText(null);
            Hybrid_ta_HNote.setText(null);
            Hybrid_tb_HDate.setText(null);
        }        
        if(panel == Panel_HybridAdd){
            HybridAdd_tb_HName.setText(null);
            HybridAdd_tb_HSpecies1.setText(null);
            HybridAdd_tb_HSpecies2.setText(null);
            HybridAdd_tb_HSpecies3.setText(null);
            HybridAdd_tb_HSpecies4.setText(null);
            HybridAdd_tb_HSpecies5.setText(null);
            HybridAdd_ta_HNote.setText(null);
            HybridAdd_dtPicker_HDate.setDate(null);
        }
        if(panel == Panel_Notify){
            Notify_tb_NID.setText(null);
            Notify_tb_PName.setText(null);
            Notify_tb_PSciName.setText(null);
            Notify_dtPicker_NDate.setDate(null);
            Notify_ta_Note.setText(null);
            Notify_tb_PTag1.setText(null);
            Notify_tb_PTag2.setText(null);
            Notify_tb_PTag3.setText(null);
            Notify_tb_PTag4.setText(null);
            Notify_tb_PTag5.setText(null);
        }
        if(panel == Panel_Sell){
            Sell_tb_PID.setText(null);
            Sell_tb_PQuantity_toSell.setText(null);
            Sell_tb_custName.setText(null);
            Sell_tb_custContact.setText(null);
            Sell_tb_stockID.setText(null);
            Sell_tb_PName.setText(null);
            Sell_tb_PSciname.setText(null);
            Sell_tb_PQuantity_Remaining.setText(null);
            Sell_tb_PPrice.setText(null);
            Sell_IP_lbl_dis_PID.setText(null);
            Sell_IP_lbl_dis_PName.setText(null);
            Sell_IP_lbl_dis_Quantity.setText(null);
            Sell_IP_lbl_dis_PricePerUnit.setText(null);
            Sell_IP_lbl_dis_totalPrice.setText(null); 
        }
        if(panel == Panel_Report){
            Report_dtPicker_Soldfrom.setDate(null);
            Report_dtPicker_Soldto.setDate(null);
        }
        if(panel == Panel_Settings){
            Settings_passFld_newPassword.setText(null);
            Settings_passFld_conPassword.setText(null);
            Settings_tb_contact.setText(null);
            Settings_tb_contact.setText(null);
            Settings_tb_secAns.setText(null);
        }
    }
    
    void makeCheckboxPanelVisible(JPanel panel){
        Lists_tb_SearchBox.setText(null);
        Lists_InsidePanel_checkboxBlank.setVisible(false);
        Lists_InsidePanel_checkboxNavigate.setVisible(false);
        Lists_InsidePanel_checkboxGarden.setVisible(false);
        Lists_InsidePanel_checkboxHybrid.setVisible(false);
        Lists_InsidePanel_checkboxNotify.setVisible(false);
        Lists_InsidePanel_checkboxSold.setVisible(false);
        Lists_InsidePanel_checkboxStock.setVisible(false);
        panel.setVisible(true);
    }
    
    void NavigateSet(ResultSet a, ResultSet b) throws SQLException{
        String PID = a.getString("PID");
        String P_name = a.getString("P_name");
        String P_sciname = a.getString("P_sciname");
        String P_Quantity = b.getString("P_Quantity");
        String P_Price = b.getString("P_Price");
        String P_ABPna = a.getString("P_ABPNa");
        String Ptag1 = a.getString("Ptag1");
        String Ptag2 = a.getString("Ptag2");
        String Ptag3 = a.getString("Ptag3");
        String Ptag4 = a.getString("Ptag4");
        String Ptag5 = a.getString("Ptag5").trim();
        String P_experimented = a.getString("P_experimented");
        String P_note = a.getString("P_note");
        Navigate_tb_PID.setText(PID);
        Navigate_tb_PName.setText(P_name);
        Navigate_tb_PSciName.setText(P_sciname);
        Navigate_tb_PQuantity.setText(P_Quantity);
        Navigate_tb_PPrice.setText(P_Price);
        Navigate_tb_PABP.setText(P_ABPna);
        Navigate_tb_Ptag1.setText(Ptag1);
        Navigate_tb_Ptag2.setText(Ptag2);
        Navigate_tb_Ptag3.setText(Ptag3);
        Navigate_tb_Ptag4.setText(Ptag4);
        Navigate_tb_Ptag5.setText(Ptag5);
        Navigate_tb_PExp.setText(P_experimented);
        Navigate_ta_PNote.setText(P_note);
    }
    
    void HybridSet(ResultSet a) throws SQLException{
        String HID = a.getString("HID");
        String HName = a.getString("HName");
        String HSpecies1 = a.getString("HSpecies1");
        String HSpecies2 = a.getString("HSpecies2");
        String HSpecies3 = a.getString("HSpecies3");
        String HSpecies4 = a.getString("HSpecies4");
        String HSpecies5 = a.getString("HSpecies5");
        String HDate = a.getDate("HDate").toString();
        String HNote = a.getString("HNote");
        Hybrid_tb_HID.setText(HID);
        Hybrid_tb_HName.setText(HName);
        Hybrid_tb_HSpecies1.setText(HSpecies1);
        Hybrid_tb_HSpecies2.setText(HSpecies2);
        Hybrid_tb_HSpecies3.setText(HSpecies3);
        Hybrid_tb_HSpecies4.setText(HSpecies4);
        Hybrid_tb_HSpecies5.setText(HSpecies5);
        Hybrid_tb_HDate.setText(HDate);
        Hybrid_ta_HNote.setText(HNote);
    }
    
    void GardenSet(ResultSet a) throws SQLException{
        String GID = a.getString("GID");
        String GName = a.getString("GName");
        String GAddress = a.getString("GAddress");
        Date GExpiry = a.getDate("GExpiry");
        String GNote = a.getString("GNote");
        Garden_tb_GID.setText(GID);
        Garden_tb_GName.setText(GName);
        Garden_ta_GAddress.setText(GAddress);
        Garden_tb_GExpiry.setText(GExpiry.toString());
        Garden_ta_GNote.setText(GNote);
    }
    
    void ReportCode(String act){
        int a = Report_tbl_maintable.getRowCount();
        try{
            String from = Report_dtPicker_Soldfrom.getDate().toString();
            String to = Report_dtPicker_Soldto.getDate().toString();
            String a0 = Report_tbl_maintable.getValueAt(0, 0).toString();
            String a1 = Report_tbl_maintable.getValueAt(1, 0).toString();
            String a2 = Report_tbl_maintable.getValueAt(2, 0).toString();
            String a3 = Report_tbl_maintable.getValueAt(3, 0).toString();
            String a4 = Report_tbl_maintable.getValueAt(4, 0).toString(); 
            String b0 = Report_tbl_maintable.getValueAt(0, 2).toString();
            String b1 = Report_tbl_maintable.getValueAt(1, 2).toString();
            String b2 = Report_tbl_maintable.getValueAt(2, 2).toString();
            String b3 = Report_tbl_maintable.getValueAt(3, 2).toString();
            String b4 = Report_tbl_maintable.getValueAt(4, 2).toString();
            
            List<String> list = new ArrayList<String>(){{
                    add(a0);
                    add(a1);
                    add(a2);
                    add(a3);
                    add(a4);
                }};
            List<String> ans = new ArrayList<>();
            for(int i=0; i<list.size(); i++){
                try{
                    Connection con;
                    con= ConnectTo.getConnection();
                    PreparedStatement ps = (PreparedStatement) con.prepareStatement
                        ("select P_Name from plants_data where pid = ?");
                    ps.setString(1, list.get(i));
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                        String p = rs.getString("P_Name");                
                        ans.add(p);           
                        if(i==4){
                            String p1 = ans.get(0);
                            String p2 = ans.get(1);
                            String p3 = ans.get(2);
                            String p4 = ans.get(3);
                            String p5 = ans.get(4);
                            JOptionPane.showMessageDialog(null, "Your generated report...");
                            ReportPrinter r = new ReportPrinter(act,from, to, a0,a1,a2,a3,a4,b0,b1,b2,b3,b4,p1,p2,p3,p4,p5);
                            r.setVisible(true);
                        }
                    }  
                    rs.close();
                    ps.close();
                    con.close();
                }
                catch(ClassNotFoundException | SQLException e){                   
                }
            }        
        }
        catch(HeadlessException e){       
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BasePanelTop = new javax.swing.JPanel();
        Panel_Top = new javax.swing.JPanel();
        top_btn_LogOut = new keeptoo.KButton();
        top_lbl_close = new javax.swing.JLabel();
        top_lbl_minimize = new javax.swing.JLabel();
        top_lbl_username = new javax.swing.JLabel();
        PanelTop_lbl_bg = new javax.swing.JLabel();
        BasePanelLeft = new javax.swing.JPanel();
        btn_RDto_ListsPanel = new keeptoo.KButton();
        btn_RDto_NavigatePanel = new keeptoo.KButton();
        btn_RDto_GardenPanel = new keeptoo.KButton();
        btn_RDto_HybridPanel = new keeptoo.KButton();
        btn_RDto_NotifyPanel = new keeptoo.KButton();
        btn_RDto_SellPanel = new keeptoo.KButton();
        btn_RDto_ReportPanel = new keeptoo.KButton();
        btn_RDto_SettingsPanel = new keeptoo.KButton();
        Left_InsidePanel_2 = new javax.swing.JPanel();
        Left_colorPanel_Lists = new javax.swing.JPanel();
        Left_colorPanel_Lists_lblIcon = new javax.swing.JLabel();
        Left_colorPanel_Navigate = new javax.swing.JPanel();
        Left_colorPanel_Navigate_lblIcon = new javax.swing.JLabel();
        Left_colorPanel_Garden = new javax.swing.JPanel();
        Left_colorPanel_Garden_lblIcon = new javax.swing.JLabel();
        Left_colorPanel_Hybrid = new javax.swing.JPanel();
        Left_colorPanel_Hybrid_lblIcon = new javax.swing.JLabel();
        Left_colorPanel_Notify = new javax.swing.JPanel();
        Left_colorPanel_Notify_lblIcon = new javax.swing.JLabel();
        Left_colorPanel_Sell = new javax.swing.JPanel();
        Left_colorPanel_Sell_lblIcon = new javax.swing.JLabel();
        Left_colorPanel_Settings = new javax.swing.JPanel();
        Left_colorPanel_Settings_lblIcon = new javax.swing.JLabel();
        Left_colorPanel_Report = new javax.swing.JPanel();
        Left_colorPanel_Report_lblIcon = new javax.swing.JLabel();
        Left_InsidePanel_1 = new javax.swing.JPanel();
        left_lbl_bg = new javax.swing.JLabel();
        BasePanelRight = new javax.swing.JPanel();
        Panel_Start = new javax.swing.JPanel();
        Start_InsidePanel = new javax.swing.JPanel();
        Start_lbl_bg = new javax.swing.JLabel();
        Panel_Lists = new javax.swing.JPanel();
        Lists_InsidePanel = new javax.swing.JPanel();
        Lists_btn_Stock = new keeptoo.KButton();
        Lists_btn_Sold = new keeptoo.KButton();
        Lists_btn_Garden = new keeptoo.KButton();
        Lists_btn_Plants = new keeptoo.KButton();
        Lists_btn_Notify = new keeptoo.KButton();
        Lists_btn_Hybrid = new keeptoo.KButton();
        Lists_InsidePanel_tablePanel = new javax.swing.JPanel();
        Lists_InsidePanel_basePanel = new javax.swing.JPanel();
        Lists_basePanel_Blank = new javax.swing.JPanel();
        Lists_basePanel_Plants = new javax.swing.JPanel();
        Lists_basePanel_btn_Plant = new keeptoo.KButton();
        Lists_basePanel_Garden = new javax.swing.JPanel();
        Lists_basePanel_btn_Garden = new keeptoo.KButton();
        Lists_basePanel_Hybrid = new javax.swing.JPanel();
        Lists_basePanel_btn_Hybrid = new keeptoo.KButton();
        Lists_InsidePanel_checkboxPanel = new javax.swing.JPanel();
        Lists_InsidePanel_checkboxBlank = new javax.swing.JPanel();
        Lists_InsidePanel_checkboxNavigate = new javax.swing.JPanel();
        Lists_rdbtn_SearchByPID = new javax.swing.JRadioButton();
        Lists_rdbtn_SearchByPName = new javax.swing.JRadioButton();
        Lists_rdbtn_SearchByPtag = new javax.swing.JRadioButton();
        Lists_InsidePanel_checkboxGarden = new javax.swing.JPanel();
        Lists_rdbtn_SearchByGID = new javax.swing.JRadioButton();
        Lists_rdbtn_SearchByGName = new javax.swing.JRadioButton();
        Lists_InsidePanel_checkboxHybrid = new javax.swing.JPanel();
        Lists_rdbtn_SearchByHID = new javax.swing.JRadioButton();
        Lists_rdbtn_SearchByHName = new javax.swing.JRadioButton();
        Lists_rdbtn_SearchByHybrid = new javax.swing.JRadioButton();
        Lists_InsidePanel_checkboxNotify = new javax.swing.JPanel();
        Lists_rdbtn_SearchByNID = new javax.swing.JRadioButton();
        Lists_rdbtn_SearchBynotifyPID = new javax.swing.JRadioButton();
        Lists_rdbtn_SearchByEntryDate = new javax.swing.JRadioButton();
        Lists_rdbtn_SearchByNotificationDate = new javax.swing.JRadioButton();
        Lists_InsidePanel_checkboxSold = new javax.swing.JPanel();
        Lists_rdbtn_SearchByPlantIssueID = new javax.swing.JRadioButton();
        Lists_rdbtn_SearchBysoldPID = new javax.swing.JRadioButton();
        Lists_rdbtn_SearchByCustomerName = new javax.swing.JRadioButton();
        Lists_rdbtn_SearchBySellingDate = new javax.swing.JRadioButton();
        Lists_InsidePanel_checkboxStock = new javax.swing.JPanel();
        Lists_rdbtn_SearchByStockID = new javax.swing.JRadioButton();
        Lists_rdbtn_SearchBystockPID = new javax.swing.JRadioButton();
        Lists_rdbtn_SearchByPQuantity = new javax.swing.JRadioButton();
        Lists_rdbtn_SearchByPPrice = new javax.swing.JRadioButton();
        Lists_tb_SearchBox = new javax.swing.JTextField();
        Lists_lbl_Search = new javax.swing.JLabel();
        Lists_lbl_tblName = new javax.swing.JLabel();
        Lists_ScrPane_mainTable = new javax.swing.JScrollPane();
        Lists_tbl_maintable = new javax.swing.JTable();
        Lists_lbl_bg = new javax.swing.JLabel();
        Panel_Navigate = new javax.swing.JPanel();
        Navigate_InsidePanel = new javax.swing.JPanel();
        Navigate_lbl_PID = new javax.swing.JLabel();
        Navigate_lbl_PName = new javax.swing.JLabel();
        Navigate_lbl_PSciName = new javax.swing.JLabel();
        Navigate_lbl_PQuantity = new javax.swing.JLabel();
        Navigate_lbl_PPrice = new javax.swing.JLabel();
        Navigate_lbl_PABP = new javax.swing.JLabel();
        Navigate_lbl_PTags = new javax.swing.JLabel();
        Navigate_lbl_Experimented = new javax.swing.JLabel();
        Navigate_lbl_PNote = new javax.swing.JLabel();
        Navigate_tb_PID = new javax.swing.JTextField();
        Navigate_tb_PName = new javax.swing.JTextField();
        Navigate_tb_PSciName = new javax.swing.JTextField();
        Navigate_tb_PQuantity = new javax.swing.JTextField();
        Navigate_tb_PPrice = new javax.swing.JTextField();
        Navigate_tb_PABP = new javax.swing.JTextField();
        Navigate_tb_Ptag1 = new javax.swing.JTextField();
        Navigate_tb_Ptag2 = new javax.swing.JTextField();
        Navigate_tb_Ptag3 = new javax.swing.JTextField();
        Navigate_tb_Ptag4 = new javax.swing.JTextField();
        Navigate_tb_Ptag5 = new javax.swing.JTextField();
        Navigate_ScrPane_PNote = new javax.swing.JScrollPane();
        Navigate_ta_PNote = new javax.swing.JTextArea();
        Navigate_InsidePanel_2 = new javax.swing.JPanel();
        Navigate_btnIcon_First = new javax.swing.JLabel();
        Navigate_btnIcon_Previous = new javax.swing.JLabel();
        Navigate_btnIcon_Next = new javax.swing.JLabel();
        Navigate_btnIcon_Last = new javax.swing.JLabel();
        Navigate_btn_First = new keeptoo.KButton();
        Navigate_btn_Previous = new keeptoo.KButton();
        Navigate_btn_Next = new keeptoo.KButton();
        Navigate_btn_Last = new keeptoo.KButton();
        Navigate_lbl_first = new javax.swing.JLabel();
        Navigate_lbl_previous = new javax.swing.JLabel();
        Navigate_lbl_next = new javax.swing.JLabel();
        Navigate_lbl_last = new javax.swing.JLabel();
        Navigate_btn_AddNew = new keeptoo.KButton();
        Navigate_btn_Modify = new keeptoo.KButton();
        Navigate_btn_Delete = new keeptoo.KButton();
        Navigate_InsidePanel_3 = new javax.swing.JPanel();
        Navigate_lbl_Count = new javax.swing.JLabel();
        Navigate_tb_PExp = new javax.swing.JTextField();
        Navigate_lbl_Search = new javax.swing.JLabel();
        Navigate_tb_SearchBox = new javax.swing.JTextField();
        Navigate_btn_Search = new keeptoo.KButton();
        Navigate_lbl_bg = new javax.swing.JLabel();
        Panel_NavigateAdd = new javax.swing.JPanel();
        NavigateAdd_InsidePanel = new javax.swing.JPanel();
        NavigateAdd_lbl_PID = new javax.swing.JLabel();
        NavigateAdd_tb_PID = new javax.swing.JTextField();
        NavigateAdd_lbl_PName = new javax.swing.JLabel();
        NavigateAdd_tb_PName = new javax.swing.JTextField();
        NavigateAdd_lbl_PSciName = new javax.swing.JLabel();
        NavigateAdd_tb_PSciName = new javax.swing.JTextField();
        NavigateAdd_lbl_PQuantity = new javax.swing.JLabel();
        NavigateAdd_tb_PQuantity = new javax.swing.JTextField();
        NavigateAdd_lbl_PPrice = new javax.swing.JLabel();
        NavigateAdd_tb_PPrice = new javax.swing.JTextField();
        NavigateAdd_lbl_PABP = new javax.swing.JLabel();
        NavigateAdd_tb_PABP = new javax.swing.JTextField();
        NavigateAdd_cmb_PABP = new javax.swing.JComboBox<>();
        NavigateAdd_lbl_PTags = new javax.swing.JLabel();
        NavigateAdd_tb_PTag1 = new javax.swing.JTextField();
        NavigateAdd_tb_PTag2 = new javax.swing.JTextField();
        NavigateAdd_tb_PTag3 = new javax.swing.JTextField();
        NavigateAdd_tb_PTag4 = new javax.swing.JTextField();
        NavigateAdd_tb_PTag5 = new javax.swing.JTextField();
        NavigateAdd_lbl_Experimented = new javax.swing.JLabel();
        NavigateAdd_rdbtn_ExpYes = new javax.swing.JRadioButton();
        NavigateAdd_rdbtn_ExpNo = new javax.swing.JRadioButton();
        NavigateAdd_lbl_PNote = new javax.swing.JLabel();
        NavigateAdd_btn_Add = new keeptoo.KButton();
        NavigateAdd_lbl_RDto_Navigate = new javax.swing.JLabel();
        NavigateAdd_btn_RDto_Navigate = new keeptoo.KButton();
        NavigateAdd_lbl_Return = new javax.swing.JLabel();
        NavigateAdd_ScrPane_PNote = new javax.swing.JScrollPane();
        NavigateAdd_ta_PNote = new javax.swing.JTextArea();
        NavigateAdd_btn_clearAll = new keeptoo.KButton();
        NavigateAdd_lbl_bg = new javax.swing.JLabel();
        Panel_NavigateModify = new javax.swing.JPanel();
        NavigateModify_InsidePanel = new javax.swing.JPanel();
        NavigateModify_lbl_PID = new javax.swing.JLabel();
        NavigateModify_tb_PID = new javax.swing.JTextField();
        NavigateModify_lbl_PName = new javax.swing.JLabel();
        NavigateModify_tb_PName = new javax.swing.JTextField();
        NavigateModify_btn_EditPName = new keeptoo.KButton();
        NavigateModify_lbl_PSciName = new javax.swing.JLabel();
        NavigateModify_tb_PSciName = new javax.swing.JTextField();
        NavigateModify_btn_EditPSciName = new keeptoo.KButton();
        NavigateModify_lbl_PQuantity = new javax.swing.JLabel();
        NavigateModify_tb_PQuantity = new javax.swing.JTextField();
        NavigateModify_lbl_PPrice = new javax.swing.JLabel();
        NavigateModify_tb_PPrice = new javax.swing.JTextField();
        NavigateModify_lbl_PABP = new javax.swing.JLabel();
        NavigateModify_tb_PABP = new javax.swing.JTextField();
        NavigateModify_cmb_PABP = new javax.swing.JComboBox<>();
        NavigateModify_lbl_PTags = new javax.swing.JLabel();
        NavigateModify_tb_PTag1 = new javax.swing.JTextField();
        NavigateModify_tb_PTag2 = new javax.swing.JTextField();
        NavigateModify_tb_PTag3 = new javax.swing.JTextField();
        NavigateModify_tb_PTag4 = new javax.swing.JTextField();
        NavigateModify_tb_PTag5 = new javax.swing.JTextField();
        NavigateModify_lbl_Experimented = new javax.swing.JLabel();
        NavigateModify_rdbtn_ExpYes = new javax.swing.JRadioButton();
        NavigateModify_rdbtn_ExpNo = new javax.swing.JRadioButton();
        NavigateModify_lbl_PNote = new javax.swing.JLabel();
        NavigateModify_ScrPane_PNote = new javax.swing.JScrollPane();
        NavigateModify_ta_PNote = new javax.swing.JTextArea();
        NavigateModify_btn_Update = new keeptoo.KButton();
        NavigateModify_lbl_RDto_Navigate = new javax.swing.JLabel();
        NavigateModify_btn_RDto_Navigate = new keeptoo.KButton();
        NavigateModify_lbl_Return = new javax.swing.JLabel();
        NavigateModify_lbl_bg = new javax.swing.JLabel();
        Panel_Garden = new javax.swing.JPanel();
        Garden_InsidePanel = new javax.swing.JPanel();
        Garden_lbl_GID = new javax.swing.JLabel();
        Garden_lbl_GName = new javax.swing.JLabel();
        Garden_lbl_GAddress = new javax.swing.JLabel();
        Garden_lbl_GExpires = new javax.swing.JLabel();
        Garden_tb_GID = new javax.swing.JTextField();
        Garden_tb_GName = new javax.swing.JTextField();
        Garden_tb_GExpiry = new javax.swing.JTextField();
        Garden_lbl_GNote = new javax.swing.JLabel();
        Garden_ScrPane_GNote = new javax.swing.JScrollPane();
        Garden_ta_GNote = new javax.swing.JTextArea();
        Garden_InsidePanel_2 = new javax.swing.JPanel();
        Garden_btnIcon_First = new javax.swing.JLabel();
        Garden_btnIcon_Previous = new javax.swing.JLabel();
        Garden_btnIcon_Next = new javax.swing.JLabel();
        Garden_btnIcon_Last = new javax.swing.JLabel();
        Garden_btn_First = new keeptoo.KButton();
        Garden_btn_Previous = new keeptoo.KButton();
        Garden_btn_Next = new keeptoo.KButton();
        Garden_btn_Last = new keeptoo.KButton();
        Garden_lbl_first = new javax.swing.JLabel();
        Garden_lbl_previous = new javax.swing.JLabel();
        Garden_lbl_next = new javax.swing.JLabel();
        Garden_lbl_last = new javax.swing.JLabel();
        Garden_btn_AddNew = new keeptoo.KButton();
        Garden_btn_Delete = new keeptoo.KButton();
        Garden_btn_Modify = new keeptoo.KButton();
        Garden_InsidePanel_3 = new javax.swing.JPanel();
        Garden_lbl_Count = new javax.swing.JLabel();
        Garden_ScrPane_GAddress = new javax.swing.JScrollPane();
        Garden_ta_GAddress = new javax.swing.JTextArea();
        Garden_lbl_dateFormat = new javax.swing.JLabel();
        Garden_lbl_Search = new javax.swing.JLabel();
        Garden_tb_SearchBox = new javax.swing.JTextField();
        Garden_btn_Search = new keeptoo.KButton();
        Garden_lbl_bg = new javax.swing.JLabel();
        Panel_GardenAdd = new javax.swing.JPanel();
        GardenAdd_InsidePanel = new javax.swing.JPanel();
        GardenAdd_lbl_GID = new javax.swing.JLabel();
        GardenAdd_lbl_GName = new javax.swing.JLabel();
        GardenAdd_lbl_GAddress = new javax.swing.JLabel();
        GardenAdd_lbl_GExpiry = new javax.swing.JLabel();
        GardenAdd_tb_GID = new javax.swing.JTextField();
        GardenAdd_tb_GName = new javax.swing.JTextField();
        GardenAdd_lbl_GNote = new javax.swing.JLabel();
        GardenAdd_ScrPane_GNote = new javax.swing.JScrollPane();
        GardenAdd_ta_GNote = new javax.swing.JTextArea();
        GardenAdd_btn_Add = new keeptoo.KButton();
        GardenAdd_lbl_RDto_Garden = new javax.swing.JLabel();
        GardenAdd_btn_RDto_Garden = new keeptoo.KButton();
        GardenAdd_lbl_Return = new javax.swing.JLabel();
        GardenAdd_ScrPane_GAddress = new javax.swing.JScrollPane();
        GardenAdd_ta_GAddress = new javax.swing.JTextArea();
        GardenAdd_dtPicker_GExpiry = new org.jdesktop.swingx.JXDatePicker();
        GardenAdd_lbl_dateFormat = new javax.swing.JLabel();
        GardenAdd_btn_clearAll = new keeptoo.KButton();
        GardenAdd_lbl_bg = new javax.swing.JLabel();
        Panel_GardenModify = new javax.swing.JPanel();
        GardenModify_InsidePanel = new javax.swing.JPanel();
        GardenModify_lbl_GID = new javax.swing.JLabel();
        GardenModify_lbl_GName = new javax.swing.JLabel();
        GardenModify_lbl_GAddress = new javax.swing.JLabel();
        GardenModify_lbl_GExpiry = new javax.swing.JLabel();
        GardenModify_tb_GID = new javax.swing.JTextField();
        GardenModify_tb_GName = new javax.swing.JTextField();
        GardenModify_lbl_GNote = new javax.swing.JLabel();
        GardenModify_ScrPane_GNote = new javax.swing.JScrollPane();
        GardenModify_ta_GNote = new javax.swing.JTextArea();
        GardenModify_btn_Update = new keeptoo.KButton();
        GardenModify_lbl_RDto_Garden = new javax.swing.JLabel();
        GardenModify_btn_RDto_Garden = new keeptoo.KButton();
        GardenModify_lbl_Return = new javax.swing.JLabel();
        GardenModify_btn_editGName = new keeptoo.KButton();
        GardenModify_ScrPane_GAddress = new javax.swing.JScrollPane();
        GardenModify_ta_GAddress = new javax.swing.JTextArea();
        GardenModify_dtPicker_GExpiry = new org.jdesktop.swingx.JXDatePicker();
        GardenModify_lbl_dateFormat = new javax.swing.JLabel();
        GardenModify_lbl_bg = new javax.swing.JLabel();
        Panel_Hybrid = new javax.swing.JPanel();
        Hybrid_InsidePanel = new javax.swing.JPanel();
        Hybrid_lbl_HID = new javax.swing.JLabel();
        Hybrid_lbl_HName = new javax.swing.JLabel();
        Hybrid_lbl_HSpecies = new javax.swing.JLabel();
        Hybrid_tb_HID = new javax.swing.JTextField();
        Hybrid_tb_HName = new javax.swing.JTextField();
        Hybrid_tb_HSpecies1 = new javax.swing.JTextField();
        Hybrid_tb_HSpecies2 = new javax.swing.JTextField();
        Hybrid_tb_HSpecies3 = new javax.swing.JTextField();
        Hybrid_tb_HSpecies4 = new javax.swing.JTextField();
        Hybrid_tb_HSpecies5 = new javax.swing.JTextField();
        Hybrid_lbl_Hdate = new javax.swing.JLabel();
        Hybrid_tb_HDate = new javax.swing.JTextField();
        Hybrid_lbl_HNote = new javax.swing.JLabel();
        Hybrid_ScrPane_HNote = new javax.swing.JScrollPane();
        Hybrid_ta_HNote = new javax.swing.JTextArea();
        Hybrid_InsidePanel_2 = new javax.swing.JPanel();
        Hybrid_btnIcon_First = new javax.swing.JLabel();
        Hybrid_btnIcon_Previous = new javax.swing.JLabel();
        Hybrid_btnIcon_Next = new javax.swing.JLabel();
        Hybrid_btnIcon_Last = new javax.swing.JLabel();
        Hybrid_btn_First = new keeptoo.KButton();
        Hybrid_btn_Previous = new keeptoo.KButton();
        Hybrid_btn_Next = new keeptoo.KButton();
        Hybrid_btn_Last = new keeptoo.KButton();
        Hybrid_lbl_previous = new javax.swing.JLabel();
        Hybrid_lbl_next = new javax.swing.JLabel();
        Hybrid_lbl_first = new javax.swing.JLabel();
        Hybrid_lbl_last = new javax.swing.JLabel();
        Hybrid_btn_AddNew = new keeptoo.KButton();
        Hybrid_btn_Modify = new keeptoo.KButton();
        Hybrid_btn_Delete = new keeptoo.KButton();
        Hybrid_InsidePanel_3 = new javax.swing.JPanel();
        Hybrid_lbl_Count = new javax.swing.JLabel();
        Hybrid_lbl_Search = new javax.swing.JLabel();
        Hybrid_tb_SearchBox = new javax.swing.JTextField();
        Hybrid_btn_Search = new keeptoo.KButton();
        PanelHybrid_lbl_bg = new javax.swing.JLabel();
        Panel_HybridAdd = new javax.swing.JPanel();
        HybridAdd_InsidePanel = new javax.swing.JPanel();
        HybridAdd_lbl_HID = new javax.swing.JLabel();
        HybridAdd_lbl_HName = new javax.swing.JLabel();
        HybridAdd_lbl_HSpecies = new javax.swing.JLabel();
        HybridAdd_tb_HID = new javax.swing.JTextField();
        HybridAdd_tb_HName = new javax.swing.JTextField();
        HybridAdd_tb_HSpecies1 = new javax.swing.JTextField();
        HybridAdd_tb_HSpecies2 = new javax.swing.JTextField();
        HybridAdd_tb_HSpecies3 = new javax.swing.JTextField();
        HybridAdd_tb_HSpecies4 = new javax.swing.JTextField();
        HybridAdd_tb_HSpecies5 = new javax.swing.JTextField();
        HybridAdd_cmb_HSpecies1 = new javax.swing.JComboBox<>();
        HybridAdd_cmb_HSpecies2 = new javax.swing.JComboBox<>();
        HybridAdd_cmb_HSpecies3 = new javax.swing.JComboBox<>();
        HybridAdd_cmb_HSpecies4 = new javax.swing.JComboBox<>();
        HybridAdd_cmb_HSpecies5 = new javax.swing.JComboBox<>();
        HybridAdd_lbl_HDate = new javax.swing.JLabel();
        HybridAdd_lbl_HNote = new javax.swing.JLabel();
        HybridAdd_ScrPane_HNote = new javax.swing.JScrollPane();
        HybridAdd_ta_HNote = new javax.swing.JTextArea();
        HybridAdd_btn_hsp1Clear = new keeptoo.KButton();
        HybridAdd_btn_hsp2Clear = new keeptoo.KButton();
        HybridAdd_btn_hsp3Clear = new keeptoo.KButton();
        HybridAdd_btn_hsp4Clear = new keeptoo.KButton();
        HybridAdd_btn_hsp5Clear = new keeptoo.KButton();
        HybridAdd_btn_Add = new keeptoo.KButton();
        HybridAdd_dtPicker_HDate = new org.jdesktop.swingx.JXDatePicker();
        HybridAdd_lbl_RDto_Hybrid = new javax.swing.JLabel();
        HybridAdd_btn_RDto_Hybrid = new keeptoo.KButton();
        HybridAdd_lbl_Return = new javax.swing.JLabel();
        HybridAdd_btn_clearAll = new keeptoo.KButton();
        PanelHybridAdd_lbl_bg = new javax.swing.JLabel();
        Panel_HybridModify = new javax.swing.JPanel();
        HybridModify_InsidePanel = new javax.swing.JPanel();
        HybridModify_lbl_HID = new javax.swing.JLabel();
        HybridModify_lbl_HName = new javax.swing.JLabel();
        HybridModify_lbl_HSpecies = new javax.swing.JLabel();
        HybridModify_tb_HID = new javax.swing.JTextField();
        HybridModify_tb_HName = new javax.swing.JTextField();
        HybridModify_tb_HSpecies1 = new javax.swing.JTextField();
        HybridModify_tb_HSpecies2 = new javax.swing.JTextField();
        HybridModify_tb_HSpecies3 = new javax.swing.JTextField();
        HybridModify_tb_HSpecies4 = new javax.swing.JTextField();
        HybridModify_tb_HSpecies5 = new javax.swing.JTextField();
        HybridModify_cmb_HSpecies1 = new javax.swing.JComboBox<>();
        HybridModify_cmb_HSpecies2 = new javax.swing.JComboBox<>();
        HybridModify_cmb_HSpecies3 = new javax.swing.JComboBox<>();
        HybridModify_cmb_HSpecies4 = new javax.swing.JComboBox<>();
        HybridModify_cmb_HSpecies5 = new javax.swing.JComboBox<>();
        HybridModify_lbl_HDate = new javax.swing.JLabel();
        HybridModify_lbl_HNote = new javax.swing.JLabel();
        HybridModify_ScrPane_HNote = new javax.swing.JScrollPane();
        HybridModify_ta_HNote = new javax.swing.JTextArea();
        HybridModify_btn_hsp1Clear = new keeptoo.KButton();
        HybridModify_btn_hsp2Clear = new keeptoo.KButton();
        HybridModify_btn_hsp3Clear = new keeptoo.KButton();
        HybridModify_btn_hsp4Clear = new keeptoo.KButton();
        HybridModify_btn_hsp5Clear = new keeptoo.KButton();
        HybridModify_btn_Update = new keeptoo.KButton();
        HybridModify_lbl_RDto_Hybrid = new javax.swing.JLabel();
        HybridModify_btn_RDto_Hybrid = new keeptoo.KButton();
        HybridModify_lbl_Return = new javax.swing.JLabel();
        HybridModify_dtPicker_HDate = new org.jdesktop.swingx.JXDatePicker();
        HybridModify_btn_editHName = new keeptoo.KButton();
        PanelHybridModify_lbl_bg = new javax.swing.JLabel();
        Panel_Notify = new javax.swing.JPanel();
        Notify_InsidePanel = new javax.swing.JPanel();
        Notify_lbl_NID = new javax.swing.JLabel();
        Notify_lbl_PID = new javax.swing.JLabel();
        Notify_lbl_NDate = new javax.swing.JLabel();
        Notify_tb_NID = new javax.swing.JTextField();
        Notify_cmb_PID = new javax.swing.JComboBox<>();
        Notify_dtPicker_NDate = new org.jdesktop.swingx.JXDatePicker();
        Notify_btn_setNotification = new keeptoo.KButton();
        Notify_ScrPane_Note = new javax.swing.JScrollPane();
        Notify_ta_Note = new javax.swing.JTextArea();
        Notify_lbl_Note = new javax.swing.JLabel();
        Notify_lbl_PName = new javax.swing.JLabel();
        Notify_tb_PName = new javax.swing.JTextField();
        Notify_lbl_PSciName = new javax.swing.JLabel();
        Notify_tb_PSciName = new javax.swing.JTextField();
        Notify_lbl_PQuantity = new javax.swing.JLabel();
        Notify_tb_PTag1 = new javax.swing.JTextField();
        Notify_tb_PTag2 = new javax.swing.JTextField();
        Notify_tb_PTag3 = new javax.swing.JTextField();
        Notify_tb_PTag4 = new javax.swing.JTextField();
        Notify_tb_PTag5 = new javax.swing.JTextField();
        PanelNotify_lbl_bg = new javax.swing.JLabel();
        Panel_Sell = new javax.swing.JPanel();
        Sell_InsidePanel = new javax.swing.JPanel();
        Sell_lbl_issueID = new javax.swing.JLabel();
        Sell_tb_SID = new javax.swing.JTextField();
        Sell_lbl_issueDate = new javax.swing.JLabel();
        Sell_tb_issueDate = new javax.swing.JTextField();
        Sell_lbl_PID = new javax.swing.JLabel();
        Sell_tb_PID = new javax.swing.JTextField();
        Sell_lbl_PName = new javax.swing.JLabel();
        Sell_tb_PName = new javax.swing.JTextField();
        Sell_lbl_PSciname = new javax.swing.JLabel();
        Sell_tb_PSciname = new javax.swing.JTextField();
        Sell_lbl_PQuantity_toSell = new javax.swing.JLabel();
        Sell_tb_PQuantity_toSell = new javax.swing.JTextField();
        Sell_lbl_PPrice = new javax.swing.JLabel();
        Sell_tb_PPrice = new javax.swing.JTextField();
        Sell_lbl_custName = new javax.swing.JLabel();
        Sell_tb_custName = new javax.swing.JTextField();
        Sell_lbl_custContact = new javax.swing.JLabel();
        Sell_tb_custContact = new javax.swing.JTextField();
        Sell_btn_Confirm = new keeptoo.KButton();
        Sell_cmb_PName = new javax.swing.JComboBox<>();
        Sell_tb_PQuantity_Remaining = new javax.swing.JTextField();
        Sell_lbl_PQuantity_Remaining = new javax.swing.JLabel();
        Sell_InsidePanel_2 = new javax.swing.JPanel();
        Sell_IP_lbl_PID = new javax.swing.JLabel();
        Sell_IP_lbl_PName = new javax.swing.JLabel();
        Sell_IP_lbl_QuantitytoSell = new javax.swing.JLabel();
        Sell_IP_lbl_PricePerUnit = new javax.swing.JLabel();
        Sell_IP_lbl_totalPrice = new javax.swing.JLabel();
        Sell_IP_lbl_dis_PID = new javax.swing.JLabel();
        Sell_IP_lbl_dis_PName = new javax.swing.JLabel();
        Sell_IP_lbl_dis_Quantity = new javax.swing.JLabel();
        Sell_IP_lbl_dis_PricePerUnit = new javax.swing.JLabel();
        Sell_IP_lbl_dis_totalPrice = new javax.swing.JLabel();
        Sell_btn_checkPrice = new keeptoo.KButton();
        jLabel2 = new javax.swing.JLabel();
        Sell_tb_stockID = new javax.swing.JTextField();
        PanelSell_lbl_bg = new javax.swing.JLabel();
        Panel_Report = new javax.swing.JPanel();
        Report_InsidePanel = new javax.swing.JPanel();
        Report_btn_Stock = new keeptoo.KButton();
        Report_btn_Sold = new keeptoo.KButton();
        Report_btn_Garden = new keeptoo.KButton();
        Report_btn_Plants = new keeptoo.KButton();
        Report_btn_Notify = new keeptoo.KButton();
        Report_btn_Hybrid = new keeptoo.KButton();
        Report_InsidePanel_tablePanel = new javax.swing.JPanel();
        Report_lbl_tblName = new javax.swing.JLabel();
        Report_ScrPane_mainTable = new javax.swing.JScrollPane();
        Report_tbl_maintable = new javax.swing.JTable();
        Report_InsidePanel_functionsPanel = new javax.swing.JPanel();
        Report_btn_mostSoldplantFrom = new keeptoo.KButton();
        Report_btn_leastSoldplantFrom = new keeptoo.KButton();
        Report_dtPicker_Soldfrom = new org.jdesktop.swingx.JXDatePicker();
        Report_dtPicker_Soldto = new org.jdesktop.swingx.JXDatePicker();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Report_insidePanel_Print = new javax.swing.JPanel();
        Report_basePanel_btn_printTable = new keeptoo.KButton();
        PanelReport_lbl_bg = new javax.swing.JLabel();
        Panel_Settings = new javax.swing.JPanel();
        Settings_InsidePanel = new javax.swing.JPanel();
        Settings_InsidePanel_2 = new javax.swing.JPanel();
        Settings_btn_deleteAccount = new keeptoo.KButton();
        Settings_btn_updateAccountDetails = new keeptoo.KButton();
        Settings_btn_changePassword = new keeptoo.KButton();
        Settings_InsidePanel_3_updateDetails = new keeptoo.KGradientPanel();
        Settings_lbl_email = new javax.swing.JLabel();
        Settings_lbl_contact = new javax.swing.JLabel();
        Settings_lbl_secAns = new javax.swing.JLabel();
        Settings_lbl_place = new javax.swing.JLabel();
        Settings_tb_email = new javax.swing.JTextField();
        Settings_tb_contact = new javax.swing.JTextField();
        Settings_tb_secAns = new javax.swing.JTextField();
        Settings_btn_updateDetails = new keeptoo.KButton();
        Settings_InsidePanel_3_enterPassword = new keeptoo.KGradientPanel();
        Settings_lbl_currPass = new javax.swing.JLabel();
        Settings_passFld_currentPassword = new javax.swing.JPasswordField();
        Settings_btn_Proceed = new keeptoo.KButton();
        Settings_InsidePanel_3_updatePassword = new keeptoo.KGradientPanel();
        Settings_lbl_newPass = new javax.swing.JLabel();
        Settings_lbl_conPass = new javax.swing.JLabel();
        Settings_passFld_newPassword = new javax.swing.JPasswordField();
        Settings_passFld_conPassword = new javax.swing.JPasswordField();
        Settings_btn_updatePassword = new keeptoo.KButton();
        Settings_InsidePanel_1 = new javax.swing.JLabel();
        PanelSetting_lbl_bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BasePanelTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Top.setOpaque(false);
        Panel_Top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        top_btn_LogOut.setText("Log out");
        top_btn_LogOut.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        top_btn_LogOut.setkEndColor(new java.awt.Color(153, 51, 0));
        top_btn_LogOut.setkHoverEndColor(new java.awt.Color(255, 0, 0));
        top_btn_LogOut.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        top_btn_LogOut.setkHoverStartColor(new java.awt.Color(255, 255, 102));
        top_btn_LogOut.setkPressedColor(new java.awt.Color(51, 255, 255));
        top_btn_LogOut.setkSelectedColor(new java.awt.Color(255, 255, 51));
        top_btn_LogOut.setkStartColor(new java.awt.Color(255, 0, 0));
        top_btn_LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                top_btn_LogOutActionPerformed(evt);
            }
        });
        Panel_Top.add(top_btn_LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1790, 50, 110, -1));

        top_lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/close-window-45 (2).png"))); // NOI18N
        top_lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                top_lbl_closeMouseClicked(evt);
            }
        });
        Panel_Top.add(top_lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1860, 0, 40, -1));

        top_lbl_minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/minimize-window-40.png"))); // NOI18N
        top_lbl_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                top_lbl_minimizeMouseClicked(evt);
            }
        });
        Panel_Top.add(top_lbl_minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1820, 2, 40, 40));

        top_lbl_username.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        top_lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        top_lbl_username.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        Panel_Top.add(top_lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, 700, 45));

        BasePanelTop.add(Panel_Top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 100));

        PanelTop_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/1920x100annie-spratt-AtF1jn20qoA-unsplash.png"))); // NOI18N
        BasePanelTop.add(PanelTop_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 100));

        getContentPane().add(BasePanelTop, java.awt.BorderLayout.PAGE_START);

        BasePanelLeft.setPreferredSize(new java.awt.Dimension(300, 930));
        BasePanelLeft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_RDto_ListsPanel.setText("Lists");
        btn_RDto_ListsPanel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_RDto_ListsPanel.setkBorderRadius(0);
        btn_RDto_ListsPanel.setkEndColor(new java.awt.Color(0, 0, 204));
        btn_RDto_ListsPanel.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btn_RDto_ListsPanel.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_RDto_ListsPanel.setkPressedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_ListsPanel.setkSelectedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_ListsPanel.setkStartColor(new java.awt.Color(0, 204, 204));
        btn_RDto_ListsPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RDto_ListsPanelActionPerformed(evt);
            }
        });
        BasePanelLeft.add(btn_RDto_ListsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, -1));

        btn_RDto_NavigatePanel.setText("Navigate");
        btn_RDto_NavigatePanel.setFocusable(false);
        btn_RDto_NavigatePanel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_RDto_NavigatePanel.setkBorderRadius(0);
        btn_RDto_NavigatePanel.setkEndColor(new java.awt.Color(0, 0, 204));
        btn_RDto_NavigatePanel.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btn_RDto_NavigatePanel.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_RDto_NavigatePanel.setkPressedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_NavigatePanel.setkSelectedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_NavigatePanel.setkStartColor(new java.awt.Color(0, 204, 204));
        btn_RDto_NavigatePanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RDto_NavigatePanelActionPerformed(evt);
            }
        });
        BasePanelLeft.add(btn_RDto_NavigatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 250, -1));

        btn_RDto_GardenPanel.setText("Garden");
        btn_RDto_GardenPanel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_RDto_GardenPanel.setkBorderRadius(0);
        btn_RDto_GardenPanel.setkEndColor(new java.awt.Color(0, 0, 204));
        btn_RDto_GardenPanel.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btn_RDto_GardenPanel.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_RDto_GardenPanel.setkPressedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_GardenPanel.setkSelectedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_GardenPanel.setkStartColor(new java.awt.Color(0, 204, 204));
        btn_RDto_GardenPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RDto_GardenPanelActionPerformed(evt);
            }
        });
        BasePanelLeft.add(btn_RDto_GardenPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 250, -1));

        btn_RDto_HybridPanel.setText("Hybrid");
        btn_RDto_HybridPanel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_RDto_HybridPanel.setkBorderRadius(0);
        btn_RDto_HybridPanel.setkEndColor(new java.awt.Color(0, 0, 204));
        btn_RDto_HybridPanel.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btn_RDto_HybridPanel.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_RDto_HybridPanel.setkPressedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_HybridPanel.setkSelectedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_HybridPanel.setkStartColor(new java.awt.Color(0, 204, 204));
        btn_RDto_HybridPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RDto_HybridPanelActionPerformed(evt);
            }
        });
        BasePanelLeft.add(btn_RDto_HybridPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 250, -1));

        btn_RDto_NotifyPanel.setText("Notify");
        btn_RDto_NotifyPanel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_RDto_NotifyPanel.setkBorderRadius(0);
        btn_RDto_NotifyPanel.setkEndColor(new java.awt.Color(0, 0, 204));
        btn_RDto_NotifyPanel.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btn_RDto_NotifyPanel.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_RDto_NotifyPanel.setkPressedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_NotifyPanel.setkSelectedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_NotifyPanel.setkStartColor(new java.awt.Color(0, 204, 204));
        btn_RDto_NotifyPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RDto_NotifyPanelActionPerformed(evt);
            }
        });
        BasePanelLeft.add(btn_RDto_NotifyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 250, -1));

        btn_RDto_SellPanel.setText("Sell");
        btn_RDto_SellPanel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_RDto_SellPanel.setkBorderRadius(0);
        btn_RDto_SellPanel.setkEndColor(new java.awt.Color(0, 0, 204));
        btn_RDto_SellPanel.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btn_RDto_SellPanel.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_RDto_SellPanel.setkPressedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_SellPanel.setkSelectedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_SellPanel.setkStartColor(new java.awt.Color(0, 204, 204));
        btn_RDto_SellPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RDto_SellPanelActionPerformed(evt);
            }
        });
        BasePanelLeft.add(btn_RDto_SellPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 250, -1));

        btn_RDto_ReportPanel.setText("Report");
        btn_RDto_ReportPanel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_RDto_ReportPanel.setkBorderRadius(0);
        btn_RDto_ReportPanel.setkEndColor(new java.awt.Color(0, 0, 204));
        btn_RDto_ReportPanel.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btn_RDto_ReportPanel.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_RDto_ReportPanel.setkPressedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_ReportPanel.setkSelectedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_ReportPanel.setkStartColor(new java.awt.Color(0, 204, 204));
        btn_RDto_ReportPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RDto_ReportPanelActionPerformed(evt);
            }
        });
        BasePanelLeft.add(btn_RDto_ReportPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 750, 250, -1));

        btn_RDto_SettingsPanel.setText("Settings");
        btn_RDto_SettingsPanel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_RDto_SettingsPanel.setkBorderRadius(0);
        btn_RDto_SettingsPanel.setkEndColor(new java.awt.Color(0, 0, 204));
        btn_RDto_SettingsPanel.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btn_RDto_SettingsPanel.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_RDto_SettingsPanel.setkPressedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_SettingsPanel.setkSelectedColor(new java.awt.Color(255, 255, 51));
        btn_RDto_SettingsPanel.setkStartColor(new java.awt.Color(0, 204, 204));
        btn_RDto_SettingsPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RDto_SettingsPanelActionPerformed(evt);
            }
        });
        BasePanelLeft.add(btn_RDto_SettingsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 850, 250, -1));

        Left_InsidePanel_2.setOpaque(false);
        Left_InsidePanel_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left_colorPanel_Lists.setBackground(new java.awt.Color(153, 255, 255));
        Left_colorPanel_Lists.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left_colorPanel_Lists_lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/clover-30.png"))); // NOI18N
        Left_colorPanel_Lists.add(Left_colorPanel_Lists_lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 17, 30, 30));

        Left_InsidePanel_2.add(Left_colorPanel_Lists, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 300, 65));

        Left_colorPanel_Navigate.setBackground(new java.awt.Color(153, 255, 255));
        Left_colorPanel_Navigate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left_colorPanel_Navigate_lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/clover-30.png"))); // NOI18N
        Left_colorPanel_Navigate.add(Left_colorPanel_Navigate_lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 17, -1, -1));

        Left_InsidePanel_2.add(Left_colorPanel_Navigate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 300, 65));

        Left_colorPanel_Garden.setBackground(new java.awt.Color(153, 255, 255));
        Left_colorPanel_Garden.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left_colorPanel_Garden_lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/clover-30.png"))); // NOI18N
        Left_colorPanel_Garden.add(Left_colorPanel_Garden_lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 17, -1, -1));

        Left_InsidePanel_2.add(Left_colorPanel_Garden, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 300, 65));

        Left_colorPanel_Hybrid.setBackground(new java.awt.Color(153, 255, 255));
        Left_colorPanel_Hybrid.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left_colorPanel_Hybrid_lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/clover-30.png"))); // NOI18N
        Left_colorPanel_Hybrid.add(Left_colorPanel_Hybrid_lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 17, -1, -1));

        Left_InsidePanel_2.add(Left_colorPanel_Hybrid, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 300, 65));

        Left_colorPanel_Notify.setBackground(new java.awt.Color(153, 255, 255));
        Left_colorPanel_Notify.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left_colorPanel_Notify_lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/clover-30.png"))); // NOI18N
        Left_colorPanel_Notify.add(Left_colorPanel_Notify_lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 17, -1, -1));

        Left_InsidePanel_2.add(Left_colorPanel_Notify, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 300, 65));

        Left_colorPanel_Sell.setBackground(new java.awt.Color(153, 255, 255));
        Left_colorPanel_Sell.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left_colorPanel_Sell_lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/clover-30.png"))); // NOI18N
        Left_colorPanel_Sell.add(Left_colorPanel_Sell_lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 17, -1, -1));

        Left_InsidePanel_2.add(Left_colorPanel_Sell, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 300, 65));

        Left_colorPanel_Settings.setBackground(new java.awt.Color(153, 255, 255));
        Left_colorPanel_Settings.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left_colorPanel_Settings_lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/clover-30.png"))); // NOI18N
        Left_colorPanel_Settings.add(Left_colorPanel_Settings_lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 17, -1, -1));

        Left_InsidePanel_2.add(Left_colorPanel_Settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 840, 300, 65));

        Left_colorPanel_Report.setBackground(new java.awt.Color(153, 255, 255));
        Left_colorPanel_Report.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left_colorPanel_Report_lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/clover-30.png"))); // NOI18N
        Left_colorPanel_Report.add(Left_colorPanel_Report_lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 17, -1, -1));

        Left_InsidePanel_2.add(Left_colorPanel_Report, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 300, 65));

        BasePanelLeft.add(Left_InsidePanel_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 930));

        Left_InsidePanel_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        left_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/300x930annie-spratt-AtF1jn20qoA-unsplash.png"))); // NOI18N
        Left_InsidePanel_1.add(left_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 930));

        BasePanelLeft.add(Left_InsidePanel_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 930));

        getContentPane().add(BasePanelLeft, java.awt.BorderLayout.LINE_START);

        BasePanelRight.setPreferredSize(new java.awt.Dimension(300, 930));
        BasePanelRight.setLayout(new java.awt.CardLayout());

        Panel_Start.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout Start_InsidePanelLayout = new javax.swing.GroupLayout(Start_InsidePanel);
        Start_InsidePanel.setLayout(Start_InsidePanelLayout);
        Start_InsidePanelLayout.setHorizontalGroup(
            Start_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1580, Short.MAX_VALUE)
        );
        Start_InsidePanelLayout.setVerticalGroup(
            Start_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );

        Panel_Start.add(Start_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        Start_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/rodion-kutsaev-rPz96Kdsmok-unsplash.png"))); // NOI18N
        Panel_Start.add(Start_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_Start, "card7");

        Panel_Lists.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lists_InsidePanel.setBackground(new java.awt.Color(153, 153, 153));
        Lists_InsidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lists_btn_Stock.setText("Stock");
        Lists_btn_Stock.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lists_btn_Stock.setkBorderRadius(0);
        Lists_btn_Stock.setkEndColor(new java.awt.Color(153, 255, 255));
        Lists_btn_Stock.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Lists_btn_Stock.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Lists_btn_Stock.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Lists_btn_Stock.setkPressedColor(new java.awt.Color(255, 204, 51));
        Lists_btn_Stock.setkStartColor(new java.awt.Color(51, 0, 153));
        Lists_btn_Stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lists_btn_StockActionPerformed(evt);
            }
        });
        Lists_InsidePanel.add(Lists_btn_Stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(1315, 65, -1, -1));

        Lists_btn_Sold.setText("Sold");
        Lists_btn_Sold.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lists_btn_Sold.setkBorderRadius(0);
        Lists_btn_Sold.setkEndColor(new java.awt.Color(153, 255, 255));
        Lists_btn_Sold.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Lists_btn_Sold.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Lists_btn_Sold.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Lists_btn_Sold.setkPressedColor(new java.awt.Color(255, 204, 51));
        Lists_btn_Sold.setkStartColor(new java.awt.Color(51, 0, 153));
        Lists_btn_Sold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lists_btn_SoldActionPerformed(evt);
            }
        });
        Lists_InsidePanel.add(Lists_btn_Sold, new org.netbeans.lib.awtextra.AbsoluteConstraints(1052, 65, -1, -1));

        Lists_btn_Garden.setText("Garden");
        Lists_btn_Garden.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lists_btn_Garden.setkBorderRadius(0);
        Lists_btn_Garden.setkEndColor(new java.awt.Color(153, 255, 255));
        Lists_btn_Garden.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Lists_btn_Garden.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Lists_btn_Garden.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Lists_btn_Garden.setkPressedColor(new java.awt.Color(255, 204, 51));
        Lists_btn_Garden.setkStartColor(new java.awt.Color(51, 0, 153));
        Lists_btn_Garden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lists_btn_GardenActionPerformed(evt);
            }
        });
        Lists_InsidePanel.add(Lists_btn_Garden, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 65, -1, -1));

        Lists_btn_Plants.setText("Plants");
        Lists_btn_Plants.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lists_btn_Plants.setkBorderRadius(0);
        Lists_btn_Plants.setkEndColor(new java.awt.Color(153, 255, 255));
        Lists_btn_Plants.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Lists_btn_Plants.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Lists_btn_Plants.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Lists_btn_Plants.setkPressedColor(new java.awt.Color(255, 204, 51));
        Lists_btn_Plants.setkStartColor(new java.awt.Color(51, 0, 153));
        Lists_btn_Plants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lists_btn_PlantsActionPerformed(evt);
            }
        });
        Lists_InsidePanel.add(Lists_btn_Plants, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, -1, -1));

        Lists_btn_Notify.setText("Notify");
        Lists_btn_Notify.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lists_btn_Notify.setkBorderRadius(0);
        Lists_btn_Notify.setkEndColor(new java.awt.Color(153, 255, 255));
        Lists_btn_Notify.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Lists_btn_Notify.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Lists_btn_Notify.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Lists_btn_Notify.setkPressedColor(new java.awt.Color(255, 204, 51));
        Lists_btn_Notify.setkStartColor(new java.awt.Color(51, 0, 153));
        Lists_btn_Notify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lists_btn_NotifyActionPerformed(evt);
            }
        });
        Lists_InsidePanel.add(Lists_btn_Notify, new org.netbeans.lib.awtextra.AbsoluteConstraints(789, 65, -1, -1));

        Lists_btn_Hybrid.setText("Hybrid");
        Lists_btn_Hybrid.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lists_btn_Hybrid.setkBorderRadius(0);
        Lists_btn_Hybrid.setkEndColor(new java.awt.Color(153, 255, 255));
        Lists_btn_Hybrid.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Lists_btn_Hybrid.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Lists_btn_Hybrid.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Lists_btn_Hybrid.setkPressedColor(new java.awt.Color(255, 204, 51));
        Lists_btn_Hybrid.setkStartColor(new java.awt.Color(51, 0, 153));
        Lists_btn_Hybrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lists_btn_HybridActionPerformed(evt);
            }
        });
        Lists_InsidePanel.add(Lists_btn_Hybrid, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 65, -1, -1));

        Lists_InsidePanel_tablePanel.setBackground(new java.awt.Color(0, 0, 0));
        Lists_InsidePanel_tablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lists_InsidePanel_basePanel.setBackground(new java.awt.Color(0, 0, 0));
        Lists_InsidePanel_basePanel.setLayout(new java.awt.CardLayout());

        Lists_basePanel_Blank.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout Lists_basePanel_BlankLayout = new javax.swing.GroupLayout(Lists_basePanel_Blank);
        Lists_basePanel_Blank.setLayout(Lists_basePanel_BlankLayout);
        Lists_basePanel_BlankLayout.setHorizontalGroup(
            Lists_basePanel_BlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1480, Short.MAX_VALUE)
        );
        Lists_basePanel_BlankLayout.setVerticalGroup(
            Lists_basePanel_BlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Lists_InsidePanel_basePanel.add(Lists_basePanel_Blank, "card3");

        Lists_basePanel_Plants.setBackground(new java.awt.Color(0, 0, 0));

        Lists_basePanel_btn_Plant.setText("View plant");
        Lists_basePanel_btn_Plant.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lists_basePanel_btn_Plant.setkBorderRadius(0);
        Lists_basePanel_btn_Plant.setkEndColor(new java.awt.Color(255, 51, 255));
        Lists_basePanel_btn_Plant.setkForeGround(new java.awt.Color(0, 0, 0));
        Lists_basePanel_btn_Plant.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Lists_basePanel_btn_Plant.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Lists_basePanel_btn_Plant.setkPressedColor(new java.awt.Color(153, 255, 153));
        Lists_basePanel_btn_Plant.setkStartColor(java.awt.Color.pink);
        Lists_basePanel_btn_Plant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lists_basePanel_btn_PlantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Lists_basePanel_PlantsLayout = new javax.swing.GroupLayout(Lists_basePanel_Plants);
        Lists_basePanel_Plants.setLayout(Lists_basePanel_PlantsLayout);
        Lists_basePanel_PlantsLayout.setHorizontalGroup(
            Lists_basePanel_PlantsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lists_basePanel_PlantsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lists_basePanel_btn_Plant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1283, Short.MAX_VALUE))
        );
        Lists_basePanel_PlantsLayout.setVerticalGroup(
            Lists_basePanel_PlantsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lists_basePanel_PlantsLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(Lists_basePanel_btn_Plant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Lists_InsidePanel_basePanel.add(Lists_basePanel_Plants, "card2");

        Lists_basePanel_Garden.setBackground(new java.awt.Color(0, 0, 0));

        Lists_basePanel_btn_Garden.setText("View garden");
        Lists_basePanel_btn_Garden.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lists_basePanel_btn_Garden.setkBorderRadius(0);
        Lists_basePanel_btn_Garden.setkEndColor(new java.awt.Color(255, 51, 255));
        Lists_basePanel_btn_Garden.setkForeGround(new java.awt.Color(0, 0, 0));
        Lists_basePanel_btn_Garden.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Lists_basePanel_btn_Garden.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Lists_basePanel_btn_Garden.setkPressedColor(new java.awt.Color(153, 255, 153));
        Lists_basePanel_btn_Garden.setkStartColor(java.awt.Color.pink);
        Lists_basePanel_btn_Garden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lists_basePanel_btn_GardenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Lists_basePanel_GardenLayout = new javax.swing.GroupLayout(Lists_basePanel_Garden);
        Lists_basePanel_Garden.setLayout(Lists_basePanel_GardenLayout);
        Lists_basePanel_GardenLayout.setHorizontalGroup(
            Lists_basePanel_GardenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lists_basePanel_GardenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lists_basePanel_btn_Garden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1283, Short.MAX_VALUE))
        );
        Lists_basePanel_GardenLayout.setVerticalGroup(
            Lists_basePanel_GardenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lists_basePanel_GardenLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(Lists_basePanel_btn_Garden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Lists_InsidePanel_basePanel.add(Lists_basePanel_Garden, "card2");

        Lists_basePanel_Hybrid.setBackground(new java.awt.Color(0, 0, 0));

        Lists_basePanel_btn_Hybrid.setText("View hybrid");
        Lists_basePanel_btn_Hybrid.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lists_basePanel_btn_Hybrid.setkBorderRadius(0);
        Lists_basePanel_btn_Hybrid.setkEndColor(new java.awt.Color(255, 51, 255));
        Lists_basePanel_btn_Hybrid.setkForeGround(new java.awt.Color(0, 0, 0));
        Lists_basePanel_btn_Hybrid.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Lists_basePanel_btn_Hybrid.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Lists_basePanel_btn_Hybrid.setkPressedColor(new java.awt.Color(153, 255, 153));
        Lists_basePanel_btn_Hybrid.setkStartColor(java.awt.Color.pink);
        Lists_basePanel_btn_Hybrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lists_basePanel_btn_HybridActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Lists_basePanel_HybridLayout = new javax.swing.GroupLayout(Lists_basePanel_Hybrid);
        Lists_basePanel_Hybrid.setLayout(Lists_basePanel_HybridLayout);
        Lists_basePanel_HybridLayout.setHorizontalGroup(
            Lists_basePanel_HybridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lists_basePanel_HybridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lists_basePanel_btn_Hybrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1283, Short.MAX_VALUE))
        );
        Lists_basePanel_HybridLayout.setVerticalGroup(
            Lists_basePanel_HybridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lists_basePanel_HybridLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(Lists_basePanel_btn_Hybrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Lists_InsidePanel_basePanel.add(Lists_basePanel_Hybrid, "card2");

        Lists_InsidePanel_tablePanel.add(Lists_InsidePanel_basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 1480, 100));

        Lists_InsidePanel_checkboxPanel.setBackground(new java.awt.Color(102, 102, 102));
        Lists_InsidePanel_checkboxPanel.setLayout(new java.awt.CardLayout());

        Lists_InsidePanel_checkboxBlank.setBackground(new java.awt.Color(0, 0, 0));
        Lists_InsidePanel_checkboxBlank.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Lists_InsidePanel_checkboxBlankLayout = new javax.swing.GroupLayout(Lists_InsidePanel_checkboxBlank);
        Lists_InsidePanel_checkboxBlank.setLayout(Lists_InsidePanel_checkboxBlankLayout);
        Lists_InsidePanel_checkboxBlankLayout.setHorizontalGroup(
            Lists_InsidePanel_checkboxBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        Lists_InsidePanel_checkboxBlankLayout.setVerticalGroup(
            Lists_InsidePanel_checkboxBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Lists_InsidePanel_checkboxPanel.add(Lists_InsidePanel_checkboxBlank, "card3");

        Lists_InsidePanel_checkboxNavigate.setBackground(new java.awt.Color(0, 0, 0));
        Lists_InsidePanel_checkboxNavigate.setForeground(new java.awt.Color(255, 255, 255));
        Lists_InsidePanel_checkboxNavigate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lists_rdbtn_SearchByPID.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByPID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByPID.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByPID.setText("PID");
        Lists_rdbtn_SearchByPID.setOpaque(false);
        Lists_InsidePanel_checkboxNavigate.add(Lists_rdbtn_SearchByPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Lists_rdbtn_SearchByPName.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByPName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByPName.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByPName.setText("Plant Name");
        Lists_rdbtn_SearchByPName.setOpaque(false);
        Lists_InsidePanel_checkboxNavigate.add(Lists_rdbtn_SearchByPName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        Lists_rdbtn_SearchByPtag.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByPtag.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByPtag.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByPtag.setText("Tag");
        Lists_rdbtn_SearchByPtag.setOpaque(false);
        Lists_InsidePanel_checkboxNavigate.add(Lists_rdbtn_SearchByPtag, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        Lists_InsidePanel_checkboxPanel.add(Lists_InsidePanel_checkboxNavigate, "card2");

        Lists_InsidePanel_checkboxGarden.setBackground(new java.awt.Color(0, 0, 0));
        Lists_InsidePanel_checkboxGarden.setForeground(new java.awt.Color(255, 255, 255));
        Lists_InsidePanel_checkboxGarden.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lists_rdbtn_SearchByGID.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByGID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByGID.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByGID.setText("Garden ID");
        Lists_rdbtn_SearchByGID.setOpaque(false);
        Lists_InsidePanel_checkboxGarden.add(Lists_rdbtn_SearchByGID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Lists_rdbtn_SearchByGName.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByGName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByGName.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByGName.setText("Garden Name");
        Lists_rdbtn_SearchByGName.setOpaque(false);
        Lists_InsidePanel_checkboxGarden.add(Lists_rdbtn_SearchByGName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));

        Lists_InsidePanel_checkboxPanel.add(Lists_InsidePanel_checkboxGarden, "card4");

        Lists_InsidePanel_checkboxHybrid.setBackground(new java.awt.Color(0, 0, 0));
        Lists_InsidePanel_checkboxHybrid.setForeground(new java.awt.Color(255, 255, 255));
        Lists_InsidePanel_checkboxHybrid.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lists_rdbtn_SearchByHID.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByHID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByHID.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByHID.setText("Hybrid ID");
        Lists_rdbtn_SearchByHID.setOpaque(false);
        Lists_InsidePanel_checkboxHybrid.add(Lists_rdbtn_SearchByHID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Lists_rdbtn_SearchByHName.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByHName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByHName.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByHName.setText("Hybrid Name");
        Lists_rdbtn_SearchByHName.setOpaque(false);
        Lists_InsidePanel_checkboxHybrid.add(Lists_rdbtn_SearchByHName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        Lists_rdbtn_SearchByHybrid.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByHybrid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByHybrid.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByHybrid.setText("Species");
        Lists_rdbtn_SearchByHybrid.setOpaque(false);
        Lists_InsidePanel_checkboxHybrid.add(Lists_rdbtn_SearchByHybrid, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        Lists_InsidePanel_checkboxPanel.add(Lists_InsidePanel_checkboxHybrid, "card5");

        Lists_InsidePanel_checkboxNotify.setBackground(new java.awt.Color(0, 0, 0));
        Lists_InsidePanel_checkboxNotify.setForeground(new java.awt.Color(255, 255, 255));
        Lists_InsidePanel_checkboxNotify.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lists_rdbtn_SearchByNID.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByNID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByNID.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByNID.setText("Notification ID");
        Lists_rdbtn_SearchByNID.setOpaque(false);
        Lists_InsidePanel_checkboxNotify.add(Lists_rdbtn_SearchByNID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Lists_rdbtn_SearchBynotifyPID.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchBynotifyPID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchBynotifyPID.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchBynotifyPID.setText("Plant ID");
        Lists_rdbtn_SearchBynotifyPID.setOpaque(false);
        Lists_InsidePanel_checkboxNotify.add(Lists_rdbtn_SearchBynotifyPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        Lists_rdbtn_SearchByEntryDate.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByEntryDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByEntryDate.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByEntryDate.setText("Entry Date");
        Lists_rdbtn_SearchByEntryDate.setOpaque(false);
        Lists_InsidePanel_checkboxNotify.add(Lists_rdbtn_SearchByEntryDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        Lists_rdbtn_SearchByNotificationDate.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByNotificationDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByNotificationDate.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByNotificationDate.setText("Notification Date");
        Lists_rdbtn_SearchByNotificationDate.setOpaque(false);
        Lists_InsidePanel_checkboxNotify.add(Lists_rdbtn_SearchByNotificationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        Lists_InsidePanel_checkboxPanel.add(Lists_InsidePanel_checkboxNotify, "card6");

        Lists_InsidePanel_checkboxSold.setBackground(new java.awt.Color(0, 0, 0));
        Lists_InsidePanel_checkboxSold.setForeground(new java.awt.Color(255, 255, 255));
        Lists_InsidePanel_checkboxSold.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lists_rdbtn_SearchByPlantIssueID.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByPlantIssueID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByPlantIssueID.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByPlantIssueID.setText("Plant Issue ID");
        Lists_rdbtn_SearchByPlantIssueID.setOpaque(false);
        Lists_InsidePanel_checkboxSold.add(Lists_rdbtn_SearchByPlantIssueID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Lists_rdbtn_SearchBysoldPID.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchBysoldPID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchBysoldPID.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchBysoldPID.setText("Plant ID");
        Lists_rdbtn_SearchBysoldPID.setOpaque(false);
        Lists_InsidePanel_checkboxSold.add(Lists_rdbtn_SearchBysoldPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        Lists_rdbtn_SearchByCustomerName.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByCustomerName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByCustomerName.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByCustomerName.setText("Customer Name");
        Lists_rdbtn_SearchByCustomerName.setOpaque(false);
        Lists_InsidePanel_checkboxSold.add(Lists_rdbtn_SearchByCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, -1));

        Lists_rdbtn_SearchBySellingDate.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchBySellingDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchBySellingDate.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchBySellingDate.setText("Sold Date");
        Lists_rdbtn_SearchBySellingDate.setOpaque(false);
        Lists_InsidePanel_checkboxSold.add(Lists_rdbtn_SearchBySellingDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        Lists_InsidePanel_checkboxPanel.add(Lists_InsidePanel_checkboxSold, "card7");

        Lists_InsidePanel_checkboxStock.setBackground(new java.awt.Color(0, 0, 0));
        Lists_InsidePanel_checkboxStock.setForeground(new java.awt.Color(255, 255, 255));
        Lists_InsidePanel_checkboxStock.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lists_rdbtn_SearchByStockID.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByStockID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByStockID.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByStockID.setText("Stock ID");
        Lists_rdbtn_SearchByStockID.setOpaque(false);
        Lists_InsidePanel_checkboxStock.add(Lists_rdbtn_SearchByStockID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Lists_rdbtn_SearchBystockPID.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchBystockPID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchBystockPID.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchBystockPID.setText("Plant ID");
        Lists_rdbtn_SearchBystockPID.setOpaque(false);
        Lists_InsidePanel_checkboxStock.add(Lists_rdbtn_SearchBystockPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        Lists_rdbtn_SearchByPQuantity.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByPQuantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByPQuantity.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByPQuantity.setText("Quantity remaining");
        Lists_rdbtn_SearchByPQuantity.setOpaque(false);
        Lists_InsidePanel_checkboxStock.add(Lists_rdbtn_SearchByPQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        Lists_rdbtn_SearchByPPrice.setBackground(new java.awt.Color(0, 0, 0));
        Lists_rdbtn_SearchByPPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Lists_rdbtn_SearchByPPrice.setForeground(new java.awt.Color(255, 255, 255));
        Lists_rdbtn_SearchByPPrice.setText("Price");
        Lists_rdbtn_SearchByPPrice.setOpaque(false);
        Lists_InsidePanel_checkboxStock.add(Lists_rdbtn_SearchByPPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        Lists_InsidePanel_checkboxPanel.add(Lists_InsidePanel_checkboxStock, "card8");

        Lists_InsidePanel_tablePanel.add(Lists_InsidePanel_checkboxPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 70, 450, 100));

        Lists_tb_SearchBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lists_tb_SearchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Lists_tb_SearchBoxKeyReleased(evt);
            }
        });
        Lists_InsidePanel_tablePanel.add(Lists_tb_SearchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 450, 45));

        Lists_lbl_Search.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lists_lbl_Search.setForeground(new java.awt.Color(255, 255, 255));
        Lists_lbl_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/search25px1.png"))); // NOI18N
        Lists_lbl_Search.setText("Search : ");
        Lists_InsidePanel_tablePanel.add(Lists_lbl_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        Lists_lbl_tblName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lists_lbl_tblName.setForeground(new java.awt.Color(255, 255, 255));
        Lists_InsidePanel_tablePanel.add(Lists_lbl_tblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 350, 45));

        Lists_ScrPane_mainTable.setBackground(new java.awt.Color(0, 0, 0));

        Lists_tbl_maintable.setBackground(new java.awt.Color(0, 0, 0));
        Lists_tbl_maintable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Lists_tbl_maintable.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lists_tbl_maintable.setForeground(new java.awt.Color(102, 255, 0));
        Lists_tbl_maintable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null", "null", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Lists_tbl_maintable.setGridColor(new java.awt.Color(0, 255, 255));
        Lists_tbl_maintable.setRowHeight(40);
        Lists_tbl_maintable.setSelectionBackground(new java.awt.Color(51, 0, 153));
        Lists_ScrPane_mainTable.setViewportView(Lists_tbl_maintable);

        Lists_InsidePanel_tablePanel.add(Lists_ScrPane_mainTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 1460, 420));

        Lists_InsidePanel.add(Lists_InsidePanel_tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 128, 1500, 780));

        Panel_Lists.add(Lists_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        Lists_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/prashant-gurung-eI7fZsIVbeU-unsplash.png"))); // NOI18N
        Panel_Lists.add(Lists_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_Lists, "card11");

        Panel_Navigate.setPreferredSize(new java.awt.Dimension(1980, 1090));
        Panel_Navigate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Navigate_InsidePanel.setBackground(new java.awt.Color(102, 102, 102));
        Navigate_InsidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Navigate_lbl_PID.setText("Plant ID : ");
        Navigate_lbl_PID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_lbl_PID.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_InsidePanel.add(Navigate_lbl_PID, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 46, -1, -1));

        Navigate_lbl_PName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_lbl_PName.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_lbl_PName.setText("Plant Name : ");
        Navigate_InsidePanel.add(Navigate_lbl_PName, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 109, -1, -1));

        Navigate_lbl_PSciName.setText("Scientific Name : ");
        Navigate_lbl_PSciName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_lbl_PSciName.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_InsidePanel.add(Navigate_lbl_PSciName, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 172, -1, -1));

        Navigate_lbl_PQuantity.setText("Quantity : ");
        Navigate_lbl_PQuantity.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_lbl_PQuantity.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_InsidePanel.add(Navigate_lbl_PQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 235, -1, -1));

        Navigate_lbl_PPrice.setText("Price : ");
        Navigate_lbl_PPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_lbl_PPrice.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_InsidePanel.add(Navigate_lbl_PPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 298, -1, -1));

        Navigate_lbl_PABP.setText("A/B/P : ");
        Navigate_lbl_PABP.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_lbl_PABP.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_InsidePanel.add(Navigate_lbl_PABP, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 358, -1, -1));

        Navigate_lbl_PTags.setText("Tags : ");
        Navigate_lbl_PTags.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_lbl_PTags.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_InsidePanel.add(Navigate_lbl_PTags, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 424, -1, -1));

        Navigate_lbl_Experimented.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_lbl_Experimented.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_lbl_Experimented.setText("Experimented : ");
        Navigate_InsidePanel.add(Navigate_lbl_Experimented, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 293, -1, -1));

        Navigate_lbl_PNote.setText("Note : ");
        Navigate_lbl_PNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_lbl_PNote.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_InsidePanel.add(Navigate_lbl_PNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 353, -1, -1));

        Navigate_tb_PID.setEditable(false);
        Navigate_tb_PID.setBackground(new java.awt.Color(204, 204, 204));
        Navigate_tb_PID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_InsidePanel.add(Navigate_tb_PID, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 38, 250, 45));

        Navigate_tb_PName.setEditable(false);
        Navigate_tb_PName.setBackground(new java.awt.Color(204, 204, 204));
        Navigate_tb_PName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_InsidePanel.add(Navigate_tb_PName, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 101, 450, 45));

        Navigate_tb_PSciName.setEditable(false);
        Navigate_tb_PSciName.setBackground(new java.awt.Color(204, 204, 204));
        Navigate_tb_PSciName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_InsidePanel.add(Navigate_tb_PSciName, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 164, 450, 45));

        Navigate_tb_PQuantity.setEditable(false);
        Navigate_tb_PQuantity.setBackground(new java.awt.Color(204, 204, 204));
        Navigate_tb_PQuantity.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_InsidePanel.add(Navigate_tb_PQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 227, 250, 45));

        Navigate_tb_PPrice.setEditable(false);
        Navigate_tb_PPrice.setBackground(new java.awt.Color(204, 204, 204));
        Navigate_tb_PPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_InsidePanel.add(Navigate_tb_PPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 290, 250, 45));

        Navigate_tb_PABP.setEditable(false);
        Navigate_tb_PABP.setBackground(new java.awt.Color(204, 204, 204));
        Navigate_tb_PABP.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_InsidePanel.add(Navigate_tb_PABP, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 353, 250, 45));

        Navigate_tb_Ptag1.setEditable(false);
        Navigate_tb_Ptag1.setBackground(new java.awt.Color(153, 255, 153));
        Navigate_tb_Ptag1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_InsidePanel.add(Navigate_tb_Ptag1, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 416, 200, 45));

        Navigate_tb_Ptag2.setEditable(false);
        Navigate_tb_Ptag2.setBackground(new java.awt.Color(153, 255, 153));
        Navigate_tb_Ptag2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_InsidePanel.add(Navigate_tb_Ptag2, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 479, 200, 45));

        Navigate_tb_Ptag3.setEditable(false);
        Navigate_tb_Ptag3.setBackground(new java.awt.Color(153, 255, 153));
        Navigate_tb_Ptag3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_InsidePanel.add(Navigate_tb_Ptag3, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 542, 200, 45));

        Navigate_tb_Ptag4.setEditable(false);
        Navigate_tb_Ptag4.setBackground(new java.awt.Color(153, 255, 153));
        Navigate_tb_Ptag4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_InsidePanel.add(Navigate_tb_Ptag4, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 605, 200, 45));

        Navigate_tb_Ptag5.setEditable(false);
        Navigate_tb_Ptag5.setBackground(new java.awt.Color(153, 255, 153));
        Navigate_tb_Ptag5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_InsidePanel.add(Navigate_tb_Ptag5, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 668, 200, 45));

        Navigate_ta_PNote.setEditable(false);
        Navigate_ta_PNote.setBackground(new java.awt.Color(255, 255, 153));
        Navigate_ta_PNote.setColumns(20);
        Navigate_ta_PNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_ta_PNote.setRows(5);
        Navigate_ScrPane_PNote.setViewportView(Navigate_ta_PNote);

        Navigate_InsidePanel.add(Navigate_ScrPane_PNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 348, 452, 188));

        Navigate_InsidePanel_2.setBackground(new java.awt.Color(204, 204, 204));
        Navigate_InsidePanel_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Navigate_btnIcon_First.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/fast-backward-50.png"))); // NOI18N
        Navigate_InsidePanel_2.add(Navigate_btnIcon_First, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 50, -1));

        Navigate_btnIcon_Previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/back-arrow-50.png"))); // NOI18N
        Navigate_InsidePanel_2.add(Navigate_btnIcon_Previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, -1, -1));

        Navigate_btnIcon_Next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/front-arrow-50.png"))); // NOI18N
        Navigate_InsidePanel_2.add(Navigate_btnIcon_Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        Navigate_btnIcon_Last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/fast-forward-50.png"))); // NOI18N
        Navigate_InsidePanel_2.add(Navigate_btnIcon_Last, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, -1, -1));

        Navigate_btn_First.setkBorderRadius(0);
        Navigate_btn_First.setkEndColor(new java.awt.Color(0, 0, 0));
        Navigate_btn_First.setkHoverEndColor(new java.awt.Color(255, 0, 51));
        Navigate_btn_First.setkHoverStartColor(new java.awt.Color(255, 153, 153));
        Navigate_btn_First.setkPressedColor(new java.awt.Color(255, 255, 102));
        Navigate_btn_First.setkStartColor(new java.awt.Color(255, 255, 255));
        Navigate_btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Navigate_btn_FirstActionPerformed(evt);
            }
        });
        Navigate_InsidePanel_2.add(Navigate_btn_First, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 60, 100, 50));

        Navigate_btn_Previous.setkBorderRadius(0);
        Navigate_btn_Previous.setkEndColor(new java.awt.Color(0, 0, 0));
        Navigate_btn_Previous.setkHoverStartColor(new java.awt.Color(204, 255, 255));
        Navigate_btn_Previous.setkPressedColor(new java.awt.Color(255, 255, 102));
        Navigate_btn_Previous.setkStartColor(new java.awt.Color(255, 255, 255));
        Navigate_btn_Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Navigate_btn_PreviousActionPerformed(evt);
            }
        });
        Navigate_InsidePanel_2.add(Navigate_btn_Previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 60, 100, 50));

        Navigate_btn_Next.setkBorderRadius(0);
        Navigate_btn_Next.setkEndColor(new java.awt.Color(0, 0, 0));
        Navigate_btn_Next.setkHoverStartColor(new java.awt.Color(204, 255, 255));
        Navigate_btn_Next.setkPressedColor(new java.awt.Color(255, 255, 102));
        Navigate_btn_Next.setkStartColor(new java.awt.Color(255, 255, 255));
        Navigate_btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Navigate_btn_NextActionPerformed(evt);
            }
        });
        Navigate_InsidePanel_2.add(Navigate_btn_Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 60, 100, 50));

        Navigate_btn_Last.setkBorderRadius(0);
        Navigate_btn_Last.setkEndColor(new java.awt.Color(0, 0, 0));
        Navigate_btn_Last.setkHoverEndColor(new java.awt.Color(255, 0, 51));
        Navigate_btn_Last.setkHoverStartColor(new java.awt.Color(255, 153, 153));
        Navigate_btn_Last.setkPressedColor(new java.awt.Color(255, 255, 102));
        Navigate_btn_Last.setkStartColor(new java.awt.Color(255, 255, 255));
        Navigate_btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Navigate_btn_LastActionPerformed(evt);
            }
        });
        Navigate_InsidePanel_2.add(Navigate_btn_Last, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 60, 100, 50));

        Navigate_lbl_first.setText("First");
        Navigate_lbl_first.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_lbl_first.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_InsidePanel_2.add(Navigate_lbl_first, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, -1));

        Navigate_lbl_previous.setText("Previous");
        Navigate_lbl_previous.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_lbl_previous.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_InsidePanel_2.add(Navigate_lbl_previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, -1, -1));

        Navigate_lbl_next.setText("Next");
        Navigate_lbl_next.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_lbl_next.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_InsidePanel_2.add(Navigate_lbl_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, -1, -1));

        Navigate_lbl_last.setText("Last");
        Navigate_lbl_last.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_lbl_last.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_InsidePanel_2.add(Navigate_lbl_last, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 110, -1, -1));

        Navigate_btn_AddNew.setText("Add New");
        Navigate_btn_AddNew.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_btn_AddNew.setkBorderRadius(0);
        Navigate_btn_AddNew.setkEndColor(new java.awt.Color(255, 51, 255));
        Navigate_btn_AddNew.setkForeGround(new java.awt.Color(0, 0, 0));
        Navigate_btn_AddNew.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Navigate_btn_AddNew.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Navigate_btn_AddNew.setkPressedColor(new java.awt.Color(153, 255, 153));
        Navigate_btn_AddNew.setkStartColor(java.awt.Color.pink);
        Navigate_btn_AddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Navigate_btn_AddNewActionPerformed(evt);
            }
        });
        Navigate_InsidePanel_2.add(Navigate_btn_AddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(1355, 0, -1, -1));

        Navigate_btn_Modify.setText("Modify");
        Navigate_btn_Modify.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_btn_Modify.setkBorderRadius(0);
        Navigate_btn_Modify.setkEndColor(new java.awt.Color(255, 51, 255));
        Navigate_btn_Modify.setkForeGround(new java.awt.Color(0, 0, 0));
        Navigate_btn_Modify.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Navigate_btn_Modify.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Navigate_btn_Modify.setkPressedColor(new java.awt.Color(153, 255, 153));
        Navigate_btn_Modify.setkStartColor(java.awt.Color.pink);
        Navigate_btn_Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Navigate_btn_ModifyActionPerformed(evt);
            }
        });
        Navigate_InsidePanel_2.add(Navigate_btn_Modify, new org.netbeans.lib.awtextra.AbsoluteConstraints(1355, 55, -1, -1));

        Navigate_btn_Delete.setText("Delete");
        Navigate_btn_Delete.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_btn_Delete.setkBorderRadius(0);
        Navigate_btn_Delete.setkEndColor(new java.awt.Color(255, 51, 255));
        Navigate_btn_Delete.setkForeGround(new java.awt.Color(0, 0, 0));
        Navigate_btn_Delete.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Navigate_btn_Delete.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Navigate_btn_Delete.setkPressedColor(new java.awt.Color(153, 255, 153));
        Navigate_btn_Delete.setkStartColor(java.awt.Color.pink);
        Navigate_btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Navigate_btn_DeleteActionPerformed(evt);
            }
        });
        Navigate_InsidePanel_2.add(Navigate_btn_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1355, 110, -1, -1));

        Navigate_InsidePanel_3.setBackground(new java.awt.Color(0, 0, 0));
        Navigate_InsidePanel_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Navigate_lbl_Count.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Navigate_lbl_Count.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Navigate_lbl_Count.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_InsidePanel_3.add(Navigate_lbl_Count, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 7, 306, 45));

        Navigate_InsidePanel_2.add(Navigate_InsidePanel_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 0, 400, 60));

        Navigate_InsidePanel.add(Navigate_InsidePanel_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 715, -1, -1));

        Navigate_tb_PExp.setEditable(false);
        Navigate_tb_PExp.setBackground(new java.awt.Color(204, 204, 204));
        Navigate_tb_PExp.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_InsidePanel.add(Navigate_tb_PExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 290, 100, 45));

        Navigate_lbl_Search.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_lbl_Search.setForeground(new java.awt.Color(255, 255, 255));
        Navigate_lbl_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/search25px1.png"))); // NOI18N
        Navigate_lbl_Search.setText("Search : ");
        Navigate_InsidePanel.add(Navigate_lbl_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        Navigate_tb_SearchBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_InsidePanel.add(Navigate_tb_SearchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 360, 45));

        Navigate_btn_Search.setText("Search");
        Navigate_btn_Search.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Navigate_btn_Search.setkBorderRadius(0);
        Navigate_btn_Search.setkEndColor(new java.awt.Color(255, 153, 153));
        Navigate_btn_Search.setkForeGround(new java.awt.Color(0, 0, 0));
        Navigate_btn_Search.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        Navigate_btn_Search.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Navigate_btn_Search.setkHoverStartColor(new java.awt.Color(204, 255, 51));
        Navigate_btn_Search.setkPressedColor(new java.awt.Color(255, 255, 255));
        Navigate_btn_Search.setkSelectedColor(new java.awt.Color(255, 255, 255));
        Navigate_btn_Search.setkStartColor(new java.awt.Color(255, 204, 0));
        Navigate_btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Navigate_btn_SearchActionPerformed(evt);
            }
        });
        Navigate_InsidePanel.add(Navigate_btn_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 20, -1, -1));

        Panel_Navigate.add(Navigate_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        Navigate_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/louis-hansel-shotsoflouis-Fjkkz1fmfWk-unsplash.png"))); // NOI18N
        Navigate_lbl_bg.setOpaque(true);
        Panel_Navigate.add(Navigate_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_Navigate, "card2");

        Panel_NavigateAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NavigateAdd_InsidePanel.setBackground(new java.awt.Color(102, 102, 102));
        NavigateAdd_InsidePanel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        NavigateAdd_InsidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NavigateAdd_lbl_PID.setText("Plant ID : ");
        NavigateAdd_lbl_PID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_lbl_PID.setForeground(new java.awt.Color(255, 255, 255));
        NavigateAdd_InsidePanel.add(NavigateAdd_lbl_PID, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 46, -1, -1));

        NavigateAdd_tb_PID.setEditable(false);
        NavigateAdd_tb_PID.setBackground(new java.awt.Color(204, 204, 204));
        NavigateAdd_tb_PID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_InsidePanel.add(NavigateAdd_tb_PID, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 38, 250, 45));

        NavigateAdd_lbl_PName.setText("Plant Name : ");
        NavigateAdd_lbl_PName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_lbl_PName.setForeground(new java.awt.Color(255, 255, 255));
        NavigateAdd_InsidePanel.add(NavigateAdd_lbl_PName, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 109, -1, -1));

        NavigateAdd_tb_PName.setBackground(new java.awt.Color(204, 204, 204));
        NavigateAdd_tb_PName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_InsidePanel.add(NavigateAdd_tb_PName, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 101, 450, 45));

        NavigateAdd_lbl_PSciName.setText("Scientific Name : ");
        NavigateAdd_lbl_PSciName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_lbl_PSciName.setForeground(new java.awt.Color(255, 255, 255));
        NavigateAdd_InsidePanel.add(NavigateAdd_lbl_PSciName, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 172, -1, -1));

        NavigateAdd_tb_PSciName.setBackground(new java.awt.Color(204, 204, 204));
        NavigateAdd_tb_PSciName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_InsidePanel.add(NavigateAdd_tb_PSciName, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 164, 450, 45));

        NavigateAdd_lbl_PQuantity.setText("Quantity : ");
        NavigateAdd_lbl_PQuantity.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_lbl_PQuantity.setForeground(new java.awt.Color(255, 255, 255));
        NavigateAdd_InsidePanel.add(NavigateAdd_lbl_PQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 235, -1, -1));

        NavigateAdd_tb_PQuantity.setBackground(new java.awt.Color(204, 204, 204));
        NavigateAdd_tb_PQuantity.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_InsidePanel.add(NavigateAdd_tb_PQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 227, 250, 45));

        NavigateAdd_lbl_PPrice.setText("Price : ");
        NavigateAdd_lbl_PPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_lbl_PPrice.setForeground(new java.awt.Color(255, 255, 255));
        NavigateAdd_InsidePanel.add(NavigateAdd_lbl_PPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 298, -1, -1));

        NavigateAdd_tb_PPrice.setBackground(new java.awt.Color(204, 204, 204));
        NavigateAdd_tb_PPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_InsidePanel.add(NavigateAdd_tb_PPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 290, 250, 45));

        NavigateAdd_lbl_PABP.setText("A/B/P : ");
        NavigateAdd_lbl_PABP.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_lbl_PABP.setForeground(new java.awt.Color(255, 255, 255));
        NavigateAdd_InsidePanel.add(NavigateAdd_lbl_PABP, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 358, -1, -1));

        NavigateAdd_tb_PABP.setEditable(false);
        NavigateAdd_tb_PABP.setBackground(new java.awt.Color(204, 204, 204));
        NavigateAdd_tb_PABP.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_InsidePanel.add(NavigateAdd_tb_PABP, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 353, 250, 45));

        NavigateAdd_cmb_PABP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NA", "Annual", "Biennial", "Perennial" }));
        NavigateAdd_cmb_PABP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NavigateAdd_cmb_PABP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavigateAdd_cmb_PABPActionPerformed(evt);
            }
        });
        NavigateAdd_InsidePanel.add(NavigateAdd_cmb_PABP, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 353, 110, 45));

        NavigateAdd_lbl_PTags.setText("Tags : ");
        NavigateAdd_lbl_PTags.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_lbl_PTags.setForeground(new java.awt.Color(255, 255, 255));
        NavigateAdd_InsidePanel.add(NavigateAdd_lbl_PTags, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 424, -1, -1));

        NavigateAdd_tb_PTag1.setBackground(new java.awt.Color(153, 255, 153));
        NavigateAdd_tb_PTag1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_InsidePanel.add(NavigateAdd_tb_PTag1, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 416, 200, 45));

        NavigateAdd_tb_PTag2.setBackground(new java.awt.Color(153, 255, 153));
        NavigateAdd_tb_PTag2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_InsidePanel.add(NavigateAdd_tb_PTag2, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 479, 200, 45));

        NavigateAdd_tb_PTag3.setBackground(new java.awt.Color(153, 255, 153));
        NavigateAdd_tb_PTag3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_InsidePanel.add(NavigateAdd_tb_PTag3, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 542, 200, 45));

        NavigateAdd_tb_PTag4.setBackground(new java.awt.Color(153, 255, 153));
        NavigateAdd_tb_PTag4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_InsidePanel.add(NavigateAdd_tb_PTag4, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 605, 200, 45));

        NavigateAdd_tb_PTag5.setBackground(new java.awt.Color(153, 255, 153));
        NavigateAdd_tb_PTag5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_InsidePanel.add(NavigateAdd_tb_PTag5, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 668, 200, 45));

        NavigateAdd_lbl_Experimented.setText("Experimented : ");
        NavigateAdd_lbl_Experimented.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_lbl_Experimented.setForeground(new java.awt.Color(255, 255, 255));
        NavigateAdd_InsidePanel.add(NavigateAdd_lbl_Experimented, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 293, -1, -1));

        NavigateAdd_rdbtn_ExpYes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_rdbtn_ExpYes.setForeground(new java.awt.Color(255, 255, 255));
        NavigateAdd_rdbtn_ExpYes.setText("Yes");
        NavigateAdd_rdbtn_ExpYes.setOpaque(false);
        NavigateAdd_InsidePanel.add(NavigateAdd_rdbtn_ExpYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 290, -1, 40));

        NavigateAdd_rdbtn_ExpNo.setSelected(true);
        NavigateAdd_rdbtn_ExpNo.setText("No");
        NavigateAdd_rdbtn_ExpNo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_rdbtn_ExpNo.setForeground(new java.awt.Color(255, 255, 255));
        NavigateAdd_rdbtn_ExpNo.setOpaque(false);
        NavigateAdd_InsidePanel.add(NavigateAdd_rdbtn_ExpNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(997, 290, -1, 40));

        NavigateAdd_lbl_PNote.setText("Note : ");
        NavigateAdd_lbl_PNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_lbl_PNote.setForeground(new java.awt.Color(255, 255, 255));
        NavigateAdd_InsidePanel.add(NavigateAdd_lbl_PNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 353, -1, -1));

        NavigateAdd_btn_Add.setText("Add");
        NavigateAdd_btn_Add.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_btn_Add.setkBorderRadius(0);
        NavigateAdd_btn_Add.setkEndColor(new java.awt.Color(255, 51, 255));
        NavigateAdd_btn_Add.setkForeGround(new java.awt.Color(0, 0, 0));
        NavigateAdd_btn_Add.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        NavigateAdd_btn_Add.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        NavigateAdd_btn_Add.setkPressedColor(new java.awt.Color(153, 255, 153));
        NavigateAdd_btn_Add.setkStartColor(java.awt.Color.pink);
        NavigateAdd_btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavigateAdd_btn_AddActionPerformed(evt);
            }
        });
        NavigateAdd_InsidePanel.add(NavigateAdd_btn_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 720, -1, -1));

        NavigateAdd_lbl_RDto_Navigate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/back-arrow-50.png"))); // NOI18N
        NavigateAdd_InsidePanel.add(NavigateAdd_lbl_RDto_Navigate, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 815, 50, 40));

        NavigateAdd_btn_RDto_Navigate.setkBorderRadius(0);
        NavigateAdd_btn_RDto_Navigate.setkEndColor(new java.awt.Color(0, 0, 0));
        NavigateAdd_btn_RDto_Navigate.setkHoverStartColor(new java.awt.Color(204, 255, 255));
        NavigateAdd_btn_RDto_Navigate.setkPressedColor(new java.awt.Color(255, 255, 102));
        NavigateAdd_btn_RDto_Navigate.setkStartColor(new java.awt.Color(255, 255, 255));
        NavigateAdd_btn_RDto_Navigate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavigateAdd_btn_RDto_NavigateActionPerformed(evt);
            }
        });
        NavigateAdd_InsidePanel.add(NavigateAdd_btn_RDto_Navigate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 810, 55, 50));

        NavigateAdd_lbl_Return.setText("Return");
        NavigateAdd_lbl_Return.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        NavigateAdd_lbl_Return.setForeground(new java.awt.Color(0, 255, 255));
        NavigateAdd_InsidePanel.add(NavigateAdd_lbl_Return, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 860, -1, -1));

        NavigateAdd_ScrPane_PNote.setPreferredSize(new java.awt.Dimension(404, 149));

        NavigateAdd_ta_PNote.setBackground(new java.awt.Color(255, 255, 153));
        NavigateAdd_ta_PNote.setColumns(20);
        NavigateAdd_ta_PNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_ta_PNote.setRows(5);
        NavigateAdd_ScrPane_PNote.setViewportView(NavigateAdd_ta_PNote);

        NavigateAdd_InsidePanel.add(NavigateAdd_ScrPane_PNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 348, 452, 188));

        NavigateAdd_btn_clearAll.setText("Clear all fields");
        NavigateAdd_btn_clearAll.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateAdd_btn_clearAll.setkBorderRadius(0);
        NavigateAdd_btn_clearAll.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        NavigateAdd_btn_clearAll.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        NavigateAdd_btn_clearAll.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        NavigateAdd_btn_clearAll.setkPressedColor(new java.awt.Color(255, 255, 0));
        NavigateAdd_btn_clearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavigateAdd_btn_clearAllActionPerformed(evt);
            }
        });
        NavigateAdd_InsidePanel.add(NavigateAdd_btn_clearAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 815, 185, -1));

        Panel_NavigateAdd.add(NavigateAdd_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        NavigateAdd_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/louis-hansel-shotsoflouis-Fjkkz1fmfWk-unsplash.png"))); // NOI18N
        Panel_NavigateAdd.add(NavigateAdd_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_NavigateAdd, "card8");

        Panel_NavigateModify.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NavigateModify_InsidePanel.setBackground(new java.awt.Color(102, 102, 102));
        NavigateModify_InsidePanel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_InsidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NavigateModify_lbl_PID.setText("Plant ID : ");
        NavigateModify_lbl_PID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_lbl_PID.setForeground(new java.awt.Color(255, 255, 255));
        NavigateModify_InsidePanel.add(NavigateModify_lbl_PID, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 46, -1, -1));

        NavigateModify_tb_PID.setEditable(false);
        NavigateModify_tb_PID.setBackground(new java.awt.Color(204, 204, 204));
        NavigateModify_tb_PID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_InsidePanel.add(NavigateModify_tb_PID, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 38, 250, 45));

        NavigateModify_lbl_PName.setText("Plant Name : ");
        NavigateModify_lbl_PName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_lbl_PName.setForeground(new java.awt.Color(255, 255, 255));
        NavigateModify_InsidePanel.add(NavigateModify_lbl_PName, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 109, -1, -1));

        NavigateModify_tb_PName.setBackground(new java.awt.Color(204, 204, 204));
        NavigateModify_tb_PName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_InsidePanel.add(NavigateModify_tb_PName, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 101, 450, 45));

        NavigateModify_btn_EditPName.setText("Edit");
        NavigateModify_btn_EditPName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_btn_EditPName.setkBorderRadius(0);
        NavigateModify_btn_EditPName.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        NavigateModify_btn_EditPName.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        NavigateModify_btn_EditPName.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        NavigateModify_btn_EditPName.setkPressedColor(new java.awt.Color(255, 255, 0));
        NavigateModify_btn_EditPName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavigateModify_btn_EditPNameActionPerformed(evt);
            }
        });
        NavigateModify_InsidePanel.add(NavigateModify_btn_EditPName, new org.netbeans.lib.awtextra.AbsoluteConstraints(747, 101, -1, -1));

        NavigateModify_lbl_PSciName.setText("Scientific Name : ");
        NavigateModify_lbl_PSciName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_lbl_PSciName.setForeground(new java.awt.Color(255, 255, 255));
        NavigateModify_InsidePanel.add(NavigateModify_lbl_PSciName, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 167, -1, -1));

        NavigateModify_tb_PSciName.setBackground(new java.awt.Color(204, 204, 204));
        NavigateModify_tb_PSciName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_InsidePanel.add(NavigateModify_tb_PSciName, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 159, 450, 45));

        NavigateModify_btn_EditPSciName.setText("Edit");
        NavigateModify_btn_EditPSciName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_btn_EditPSciName.setkBorderRadius(0);
        NavigateModify_btn_EditPSciName.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        NavigateModify_btn_EditPSciName.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        NavigateModify_btn_EditPSciName.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        NavigateModify_btn_EditPSciName.setkPressedColor(new java.awt.Color(255, 255, 0));
        NavigateModify_btn_EditPSciName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavigateModify_btn_EditPSciNameActionPerformed(evt);
            }
        });
        NavigateModify_InsidePanel.add(NavigateModify_btn_EditPSciName, new org.netbeans.lib.awtextra.AbsoluteConstraints(747, 159, -1, -1));

        NavigateModify_lbl_PQuantity.setText("Quantity : ");
        NavigateModify_lbl_PQuantity.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_lbl_PQuantity.setForeground(new java.awt.Color(255, 255, 255));
        NavigateModify_InsidePanel.add(NavigateModify_lbl_PQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 230, -1, -1));

        NavigateModify_tb_PQuantity.setBackground(new java.awt.Color(204, 204, 204));
        NavigateModify_tb_PQuantity.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_InsidePanel.add(NavigateModify_tb_PQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 222, 250, 45));

        NavigateModify_lbl_PPrice.setText("Price : ");
        NavigateModify_lbl_PPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_lbl_PPrice.setForeground(new java.awt.Color(255, 255, 255));
        NavigateModify_InsidePanel.add(NavigateModify_lbl_PPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 293, -1, -1));

        NavigateModify_tb_PPrice.setBackground(new java.awt.Color(204, 204, 204));
        NavigateModify_tb_PPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_InsidePanel.add(NavigateModify_tb_PPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 285, 250, 45));

        NavigateModify_lbl_PABP.setText("A/B/P : ");
        NavigateModify_lbl_PABP.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_lbl_PABP.setForeground(new java.awt.Color(255, 255, 255));
        NavigateModify_InsidePanel.add(NavigateModify_lbl_PABP, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 353, -1, -1));

        NavigateModify_tb_PABP.setEditable(false);
        NavigateModify_tb_PABP.setBackground(new java.awt.Color(204, 204, 204));
        NavigateModify_tb_PABP.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_InsidePanel.add(NavigateModify_tb_PABP, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 348, 250, 45));

        NavigateModify_cmb_PABP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NA", "Annual", "Biennial", "Perennial" }));
        NavigateModify_cmb_PABP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NavigateModify_cmb_PABP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavigateModify_cmb_PABPActionPerformed(evt);
            }
        });
        NavigateModify_InsidePanel.add(NavigateModify_cmb_PABP, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 348, 110, 45));

        NavigateModify_lbl_PTags.setText("Tags : ");
        NavigateModify_lbl_PTags.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_lbl_PTags.setForeground(new java.awt.Color(255, 255, 255));
        NavigateModify_InsidePanel.add(NavigateModify_lbl_PTags, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 419, -1, -1));

        NavigateModify_tb_PTag1.setBackground(new java.awt.Color(153, 255, 153));
        NavigateModify_tb_PTag1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_InsidePanel.add(NavigateModify_tb_PTag1, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 411, 200, 45));

        NavigateModify_tb_PTag2.setBackground(new java.awt.Color(153, 255, 153));
        NavigateModify_tb_PTag2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_InsidePanel.add(NavigateModify_tb_PTag2, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 474, 200, 45));

        NavigateModify_tb_PTag3.setBackground(new java.awt.Color(153, 255, 153));
        NavigateModify_tb_PTag3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_InsidePanel.add(NavigateModify_tb_PTag3, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 537, 200, 45));

        NavigateModify_tb_PTag4.setBackground(new java.awt.Color(153, 255, 153));
        NavigateModify_tb_PTag4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_InsidePanel.add(NavigateModify_tb_PTag4, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 600, 200, 45));

        NavigateModify_tb_PTag5.setBackground(new java.awt.Color(153, 255, 153));
        NavigateModify_tb_PTag5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_InsidePanel.add(NavigateModify_tb_PTag5, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 663, 200, 45));

        NavigateModify_lbl_Experimented.setText("Experimented : ");
        NavigateModify_lbl_Experimented.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_lbl_Experimented.setForeground(new java.awt.Color(255, 255, 255));
        NavigateModify_InsidePanel.add(NavigateModify_lbl_Experimented, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 293, -1, -1));

        NavigateModify_rdbtn_ExpYes.setText("Yes");
        NavigateModify_rdbtn_ExpYes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_rdbtn_ExpYes.setForeground(new java.awt.Color(255, 255, 255));
        NavigateModify_rdbtn_ExpYes.setOpaque(false);
        NavigateModify_InsidePanel.add(NavigateModify_rdbtn_ExpYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 290, -1, 40));

        NavigateModify_rdbtn_ExpNo.setSelected(true);
        NavigateModify_rdbtn_ExpNo.setText("No");
        NavigateModify_rdbtn_ExpNo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_rdbtn_ExpNo.setForeground(new java.awt.Color(255, 255, 255));
        NavigateModify_rdbtn_ExpNo.setOpaque(false);
        NavigateModify_InsidePanel.add(NavigateModify_rdbtn_ExpNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(997, 290, -1, 40));

        NavigateModify_lbl_PNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_lbl_PNote.setForeground(new java.awt.Color(255, 255, 255));
        NavigateModify_lbl_PNote.setText("Note : ");
        NavigateModify_InsidePanel.add(NavigateModify_lbl_PNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 353, -1, -1));

        NavigateModify_ScrPane_PNote.setPreferredSize(new java.awt.Dimension(404, 149));

        NavigateModify_ta_PNote.setBackground(new java.awt.Color(255, 255, 153));
        NavigateModify_ta_PNote.setColumns(20);
        NavigateModify_ta_PNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_ta_PNote.setRows(5);
        NavigateModify_ScrPane_PNote.setViewportView(NavigateModify_ta_PNote);

        NavigateModify_InsidePanel.add(NavigateModify_ScrPane_PNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 348, 452, 188));

        NavigateModify_btn_Update.setText("Update");
        NavigateModify_btn_Update.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NavigateModify_btn_Update.setkBorderRadius(0);
        NavigateModify_btn_Update.setkEndColor(new java.awt.Color(255, 51, 255));
        NavigateModify_btn_Update.setkForeGround(new java.awt.Color(0, 0, 0));
        NavigateModify_btn_Update.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        NavigateModify_btn_Update.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        NavigateModify_btn_Update.setkPressedColor(new java.awt.Color(153, 255, 153));
        NavigateModify_btn_Update.setkStartColor(java.awt.Color.pink);
        NavigateModify_btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavigateModify_btn_UpdateActionPerformed(evt);
            }
        });
        NavigateModify_InsidePanel.add(NavigateModify_btn_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 715, -1, -1));

        NavigateModify_lbl_RDto_Navigate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/back-arrow-50.png"))); // NOI18N
        NavigateModify_InsidePanel.add(NavigateModify_lbl_RDto_Navigate, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 815, 50, 40));

        NavigateModify_btn_RDto_Navigate.setkBorderRadius(0);
        NavigateModify_btn_RDto_Navigate.setkEndColor(new java.awt.Color(0, 0, 0));
        NavigateModify_btn_RDto_Navigate.setkHoverStartColor(new java.awt.Color(204, 255, 255));
        NavigateModify_btn_RDto_Navigate.setkPressedColor(new java.awt.Color(255, 255, 102));
        NavigateModify_btn_RDto_Navigate.setkStartColor(new java.awt.Color(255, 255, 255));
        NavigateModify_btn_RDto_Navigate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavigateModify_btn_RDto_NavigateActionPerformed(evt);
            }
        });
        NavigateModify_InsidePanel.add(NavigateModify_btn_RDto_Navigate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 810, 55, 50));

        NavigateModify_lbl_Return.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        NavigateModify_lbl_Return.setForeground(new java.awt.Color(0, 255, 255));
        NavigateModify_lbl_Return.setText("Return");
        NavigateModify_InsidePanel.add(NavigateModify_lbl_Return, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 860, -1, -1));

        Panel_NavigateModify.add(NavigateModify_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        NavigateModify_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/louis-hansel-shotsoflouis-Fjkkz1fmfWk-unsplash.png"))); // NOI18N
        NavigateModify_lbl_bg.setOpaque(true);
        Panel_NavigateModify.add(NavigateModify_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_NavigateModify, "card10");

        Panel_Garden.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Garden_InsidePanel.setBackground(new java.awt.Color(102, 102, 102));
        Garden_InsidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Garden_lbl_GID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_lbl_GID.setForeground(new java.awt.Color(255, 255, 255));
        Garden_lbl_GID.setText("Garden ID : ");
        Garden_InsidePanel.add(Garden_lbl_GID, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 154, -1, -1));

        Garden_lbl_GName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_lbl_GName.setForeground(new java.awt.Color(255, 255, 255));
        Garden_lbl_GName.setText("Garden name : ");
        Garden_InsidePanel.add(Garden_lbl_GName, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 217, -1, -1));

        Garden_lbl_GAddress.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_lbl_GAddress.setForeground(new java.awt.Color(255, 255, 255));
        Garden_lbl_GAddress.setText("Address : ");
        Garden_InsidePanel.add(Garden_lbl_GAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 272, -1, -1));

        Garden_lbl_GExpires.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_lbl_GExpires.setForeground(new java.awt.Color(255, 255, 255));
        Garden_lbl_GExpires.setText("Expires on :");
        Garden_InsidePanel.add(Garden_lbl_GExpires, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 469, -1, -1));

        Garden_tb_GID.setEditable(false);
        Garden_tb_GID.setBackground(new java.awt.Color(204, 204, 204));
        Garden_tb_GID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_InsidePanel.add(Garden_tb_GID, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 146, 250, 45));

        Garden_tb_GName.setEditable(false);
        Garden_tb_GName.setBackground(new java.awt.Color(204, 204, 204));
        Garden_tb_GName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_InsidePanel.add(Garden_tb_GName, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 209, 400, 45));

        Garden_tb_GExpiry.setEditable(false);
        Garden_tb_GExpiry.setBackground(new java.awt.Color(204, 204, 204));
        Garden_tb_GExpiry.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_InsidePanel.add(Garden_tb_GExpiry, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 461, 250, 45));

        Garden_lbl_GNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_lbl_GNote.setForeground(new java.awt.Color(255, 255, 255));
        Garden_lbl_GNote.setText("Note : ");
        Garden_InsidePanel.add(Garden_lbl_GNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 154, -1, -1));

        Garden_ta_GNote.setEditable(false);
        Garden_ta_GNote.setBackground(new java.awt.Color(255, 255, 153));
        Garden_ta_GNote.setColumns(20);
        Garden_ta_GNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_ta_GNote.setRows(5);
        Garden_ScrPane_GNote.setViewportView(Garden_ta_GNote);

        Garden_InsidePanel.add(Garden_ScrPane_GNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 146, 400, 171));

        Garden_InsidePanel_2.setBackground(new java.awt.Color(153, 153, 153));
        Garden_InsidePanel_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Garden_btnIcon_First.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/fast-backward-50.png"))); // NOI18N
        Garden_InsidePanel_2.add(Garden_btnIcon_First, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 50, -1));

        Garden_btnIcon_Previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/back-arrow-50.png"))); // NOI18N
        Garden_InsidePanel_2.add(Garden_btnIcon_Previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, -1, -1));

        Garden_btnIcon_Next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/front-arrow-50.png"))); // NOI18N
        Garden_InsidePanel_2.add(Garden_btnIcon_Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        Garden_btnIcon_Last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/fast-forward-50.png"))); // NOI18N
        Garden_InsidePanel_2.add(Garden_btnIcon_Last, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, -1, -1));

        Garden_btn_First.setkBorderRadius(0);
        Garden_btn_First.setkEndColor(new java.awt.Color(0, 0, 0));
        Garden_btn_First.setkHoverEndColor(new java.awt.Color(255, 0, 51));
        Garden_btn_First.setkHoverStartColor(new java.awt.Color(255, 153, 153));
        Garden_btn_First.setkPressedColor(new java.awt.Color(255, 255, 102));
        Garden_btn_First.setkStartColor(new java.awt.Color(255, 255, 255));
        Garden_btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Garden_btn_FirstActionPerformed(evt);
            }
        });
        Garden_InsidePanel_2.add(Garden_btn_First, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 60, 100, 50));

        Garden_btn_Previous.setkBorderRadius(0);
        Garden_btn_Previous.setkEndColor(new java.awt.Color(0, 0, 0));
        Garden_btn_Previous.setkHoverStartColor(new java.awt.Color(204, 255, 255));
        Garden_btn_Previous.setkPressedColor(new java.awt.Color(255, 255, 102));
        Garden_btn_Previous.setkStartColor(new java.awt.Color(255, 255, 255));
        Garden_btn_Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Garden_btn_PreviousActionPerformed(evt);
            }
        });
        Garden_InsidePanel_2.add(Garden_btn_Previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 60, 100, 50));

        Garden_btn_Next.setkBorderRadius(0);
        Garden_btn_Next.setkEndColor(new java.awt.Color(0, 0, 0));
        Garden_btn_Next.setkHoverStartColor(new java.awt.Color(204, 255, 255));
        Garden_btn_Next.setkPressedColor(new java.awt.Color(255, 255, 102));
        Garden_btn_Next.setkStartColor(new java.awt.Color(255, 255, 255));
        Garden_btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Garden_btn_NextActionPerformed(evt);
            }
        });
        Garden_InsidePanel_2.add(Garden_btn_Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 60, 100, 50));

        Garden_btn_Last.setkBorderRadius(0);
        Garden_btn_Last.setkEndColor(new java.awt.Color(0, 0, 0));
        Garden_btn_Last.setkHoverEndColor(new java.awt.Color(255, 0, 51));
        Garden_btn_Last.setkHoverStartColor(new java.awt.Color(255, 153, 153));
        Garden_btn_Last.setkPressedColor(new java.awt.Color(255, 255, 102));
        Garden_btn_Last.setkStartColor(new java.awt.Color(255, 255, 255));
        Garden_btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Garden_btn_LastActionPerformed(evt);
            }
        });
        Garden_InsidePanel_2.add(Garden_btn_Last, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 60, 100, 50));

        Garden_lbl_first.setText("First");
        Garden_lbl_first.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_lbl_first.setForeground(new java.awt.Color(255, 255, 255));
        Garden_InsidePanel_2.add(Garden_lbl_first, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, -1));

        Garden_lbl_previous.setText("Previous");
        Garden_lbl_previous.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_lbl_previous.setForeground(new java.awt.Color(255, 255, 255));
        Garden_InsidePanel_2.add(Garden_lbl_previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, -1, -1));

        Garden_lbl_next.setText("Next");
        Garden_lbl_next.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_lbl_next.setForeground(new java.awt.Color(255, 255, 255));
        Garden_InsidePanel_2.add(Garden_lbl_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, -1, -1));

        Garden_lbl_last.setText("Last");
        Garden_lbl_last.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_lbl_last.setForeground(new java.awt.Color(255, 255, 255));
        Garden_InsidePanel_2.add(Garden_lbl_last, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 110, -1, -1));

        Garden_btn_AddNew.setText("Add new");
        Garden_btn_AddNew.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_btn_AddNew.setkBorderRadius(0);
        Garden_btn_AddNew.setkEndColor(new java.awt.Color(255, 51, 255));
        Garden_btn_AddNew.setkForeGround(new java.awt.Color(0, 0, 0));
        Garden_btn_AddNew.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Garden_btn_AddNew.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Garden_btn_AddNew.setkPressedColor(new java.awt.Color(153, 255, 153));
        Garden_btn_AddNew.setkStartColor(java.awt.Color.pink);
        Garden_btn_AddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Garden_btn_AddNewActionPerformed(evt);
            }
        });
        Garden_InsidePanel_2.add(Garden_btn_AddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(1355, 0, -1, -1));

        Garden_btn_Delete.setText("Delete");
        Garden_btn_Delete.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_btn_Delete.setkBorderRadius(0);
        Garden_btn_Delete.setkEndColor(new java.awt.Color(255, 51, 255));
        Garden_btn_Delete.setkForeGround(new java.awt.Color(0, 0, 0));
        Garden_btn_Delete.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Garden_btn_Delete.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Garden_btn_Delete.setkPressedColor(new java.awt.Color(153, 255, 153));
        Garden_btn_Delete.setkStartColor(java.awt.Color.pink);
        Garden_btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Garden_btn_DeleteActionPerformed(evt);
            }
        });
        Garden_InsidePanel_2.add(Garden_btn_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1355, 108, -1, -1));

        Garden_btn_Modify.setText("Modify");
        Garden_btn_Modify.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_btn_Modify.setkBorderRadius(0);
        Garden_btn_Modify.setkEndColor(new java.awt.Color(255, 51, 255));
        Garden_btn_Modify.setkForeGround(new java.awt.Color(0, 0, 0));
        Garden_btn_Modify.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Garden_btn_Modify.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Garden_btn_Modify.setkPressedColor(new java.awt.Color(153, 255, 153));
        Garden_btn_Modify.setkStartColor(java.awt.Color.pink);
        Garden_btn_Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Garden_btn_ModifyActionPerformed(evt);
            }
        });
        Garden_InsidePanel_2.add(Garden_btn_Modify, new org.netbeans.lib.awtextra.AbsoluteConstraints(1355, 55, -1, -1));

        Garden_InsidePanel_3.setBackground(new java.awt.Color(0, 0, 0));
        Garden_InsidePanel_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Garden_lbl_Count.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Garden_lbl_Count.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Garden_lbl_Count.setForeground(new java.awt.Color(255, 255, 255));
        Garden_InsidePanel_3.add(Garden_lbl_Count, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 7, 306, 45));

        Garden_InsidePanel_2.add(Garden_InsidePanel_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 0, 400, 60));

        Garden_InsidePanel.add(Garden_InsidePanel_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 715, -1, -1));

        Garden_ta_GAddress.setEditable(false);
        Garden_ta_GAddress.setBackground(new java.awt.Color(204, 204, 204));
        Garden_ta_GAddress.setColumns(20);
        Garden_ta_GAddress.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_ta_GAddress.setRows(5);
        Garden_ScrPane_GAddress.setViewportView(Garden_ta_GAddress);

        Garden_InsidePanel.add(Garden_ScrPane_GAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 271, 400, 171));

        Garden_lbl_dateFormat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_lbl_dateFormat.setForeground(new java.awt.Color(255, 255, 255));
        Garden_lbl_dateFormat.setText("yyyy-mm-dd");
        Garden_InsidePanel.add(Garden_lbl_dateFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 513, 250, -1));

        Garden_lbl_Search.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_lbl_Search.setForeground(new java.awt.Color(255, 255, 255));
        Garden_lbl_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/search25px1.png"))); // NOI18N
        Garden_lbl_Search.setText("Search : ");
        Garden_InsidePanel.add(Garden_lbl_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        Garden_tb_SearchBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_InsidePanel.add(Garden_tb_SearchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 360, 45));

        Garden_btn_Search.setText("Search");
        Garden_btn_Search.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Garden_btn_Search.setkBorderRadius(0);
        Garden_btn_Search.setkEndColor(new java.awt.Color(255, 153, 153));
        Garden_btn_Search.setkForeGround(new java.awt.Color(0, 0, 0));
        Garden_btn_Search.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        Garden_btn_Search.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Garden_btn_Search.setkHoverStartColor(new java.awt.Color(204, 255, 51));
        Garden_btn_Search.setkPressedColor(new java.awt.Color(255, 255, 255));
        Garden_btn_Search.setkSelectedColor(new java.awt.Color(255, 255, 255));
        Garden_btn_Search.setkStartColor(new java.awt.Color(255, 204, 0));
        Garden_btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Garden_btn_SearchActionPerformed(evt);
            }
        });
        Garden_InsidePanel.add(Garden_btn_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 20, -1, -1));

        Panel_Garden.add(Garden_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        Garden_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/manikandan-annamalai-XEBASsgifEc-unsplash.png"))); // NOI18N
        Panel_Garden.add(Garden_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_Garden, "card6");

        Panel_GardenAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GardenAdd_InsidePanel.setBackground(new java.awt.Color(102, 102, 102));
        GardenAdd_InsidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GardenAdd_lbl_GID.setText("Garden ID : ");
        GardenAdd_lbl_GID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenAdd_lbl_GID.setForeground(new java.awt.Color(255, 255, 255));
        GardenAdd_InsidePanel.add(GardenAdd_lbl_GID, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 154, -1, -1));

        GardenAdd_lbl_GName.setText("Garden name : ");
        GardenAdd_lbl_GName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenAdd_lbl_GName.setForeground(new java.awt.Color(255, 255, 255));
        GardenAdd_InsidePanel.add(GardenAdd_lbl_GName, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 217, -1, -1));

        GardenAdd_lbl_GAddress.setText("Address : ");
        GardenAdd_lbl_GAddress.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenAdd_lbl_GAddress.setForeground(new java.awt.Color(255, 255, 255));
        GardenAdd_InsidePanel.add(GardenAdd_lbl_GAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 271, -1, -1));

        GardenAdd_lbl_GExpiry.setText("Expires on :");
        GardenAdd_lbl_GExpiry.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenAdd_lbl_GExpiry.setForeground(new java.awt.Color(255, 255, 255));
        GardenAdd_InsidePanel.add(GardenAdd_lbl_GExpiry, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 474, -1, -1));

        GardenAdd_tb_GID.setEditable(false);
        GardenAdd_tb_GID.setBackground(new java.awt.Color(204, 204, 204));
        GardenAdd_tb_GID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenAdd_InsidePanel.add(GardenAdd_tb_GID, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 146, 250, 45));

        GardenAdd_tb_GName.setBackground(new java.awt.Color(204, 204, 204));
        GardenAdd_tb_GName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenAdd_InsidePanel.add(GardenAdd_tb_GName, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 209, 400, 45));

        GardenAdd_lbl_GNote.setText("Note : ");
        GardenAdd_lbl_GNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenAdd_lbl_GNote.setForeground(new java.awt.Color(255, 255, 255));
        GardenAdd_InsidePanel.add(GardenAdd_lbl_GNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(802, 154, -1, -1));

        GardenAdd_ta_GNote.setBackground(new java.awt.Color(255, 255, 153));
        GardenAdd_ta_GNote.setColumns(20);
        GardenAdd_ta_GNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenAdd_ta_GNote.setRows(5);
        GardenAdd_ScrPane_GNote.setViewportView(GardenAdd_ta_GNote);

        GardenAdd_InsidePanel.add(GardenAdd_ScrPane_GNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 146, 400, 171));

        GardenAdd_btn_Add.setText("Add");
        GardenAdd_btn_Add.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenAdd_btn_Add.setkBorderRadius(0);
        GardenAdd_btn_Add.setkEndColor(new java.awt.Color(255, 51, 255));
        GardenAdd_btn_Add.setkForeGround(new java.awt.Color(0, 0, 0));
        GardenAdd_btn_Add.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        GardenAdd_btn_Add.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        GardenAdd_btn_Add.setkPressedColor(new java.awt.Color(153, 255, 153));
        GardenAdd_btn_Add.setkStartColor(java.awt.Color.pink);
        GardenAdd_btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GardenAdd_btn_AddActionPerformed(evt);
            }
        });
        GardenAdd_InsidePanel.add(GardenAdd_btn_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 734, -1, -1));

        GardenAdd_lbl_RDto_Garden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/back-arrow-50.png"))); // NOI18N
        GardenAdd_InsidePanel.add(GardenAdd_lbl_RDto_Garden, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 829, -1, 40));

        GardenAdd_btn_RDto_Garden.setkEndColor(new java.awt.Color(0, 0, 0));
        GardenAdd_btn_RDto_Garden.setkHoverStartColor(new java.awt.Color(204, 255, 255));
        GardenAdd_btn_RDto_Garden.setkPressedColor(new java.awt.Color(255, 255, 102));
        GardenAdd_btn_RDto_Garden.setkStartColor(new java.awt.Color(255, 255, 255));
        GardenAdd_btn_RDto_Garden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GardenAdd_btn_RDto_GardenActionPerformed(evt);
            }
        });
        GardenAdd_InsidePanel.add(GardenAdd_btn_RDto_Garden, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 824, 55, 50));

        GardenAdd_lbl_Return.setText("Return");
        GardenAdd_lbl_Return.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        GardenAdd_lbl_Return.setForeground(new java.awt.Color(0, 255, 255));
        GardenAdd_InsidePanel.add(GardenAdd_lbl_Return, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 874, -1, -1));

        GardenAdd_ta_GAddress.setBackground(new java.awt.Color(204, 204, 204));
        GardenAdd_ta_GAddress.setColumns(20);
        GardenAdd_ta_GAddress.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenAdd_ta_GAddress.setRows(5);
        GardenAdd_ScrPane_GAddress.setViewportView(GardenAdd_ta_GAddress);

        GardenAdd_InsidePanel.add(GardenAdd_ScrPane_GAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 271, 400, 171));

        GardenAdd_dtPicker_GExpiry.setBackground(new java.awt.Color(255, 255, 255));
        GardenAdd_dtPicker_GExpiry.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenAdd_InsidePanel.add(GardenAdd_dtPicker_GExpiry, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 466, 250, 45));

        GardenAdd_lbl_dateFormat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenAdd_lbl_dateFormat.setForeground(new java.awt.Color(255, 255, 255));
        GardenAdd_lbl_dateFormat.setText("dd/mm/yyyy");
        GardenAdd_InsidePanel.add(GardenAdd_lbl_dateFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 518, 250, -1));

        GardenAdd_btn_clearAll.setText("Clear all fields");
        GardenAdd_btn_clearAll.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenAdd_btn_clearAll.setkBorderRadius(0);
        GardenAdd_btn_clearAll.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        GardenAdd_btn_clearAll.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        GardenAdd_btn_clearAll.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        GardenAdd_btn_clearAll.setkPressedColor(new java.awt.Color(255, 255, 0));
        GardenAdd_btn_clearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GardenAdd_btn_clearAllActionPerformed(evt);
            }
        });
        GardenAdd_InsidePanel.add(GardenAdd_btn_clearAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 815, 185, -1));

        Panel_GardenAdd.add(GardenAdd_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        GardenAdd_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/manikandan-annamalai-XEBASsgifEc-unsplash.png"))); // NOI18N
        Panel_GardenAdd.add(GardenAdd_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_GardenAdd, "card6");

        Panel_GardenModify.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GardenModify_InsidePanel.setBackground(new java.awt.Color(102, 102, 102));
        GardenModify_InsidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GardenModify_lbl_GID.setText("Garden ID : ");
        GardenModify_lbl_GID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenModify_lbl_GID.setForeground(new java.awt.Color(255, 255, 255));
        GardenModify_InsidePanel.add(GardenModify_lbl_GID, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 154, -1, -1));

        GardenModify_lbl_GName.setText("Garden name : ");
        GardenModify_lbl_GName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenModify_lbl_GName.setForeground(new java.awt.Color(255, 255, 255));
        GardenModify_InsidePanel.add(GardenModify_lbl_GName, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 217, -1, -1));

        GardenModify_lbl_GAddress.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenModify_lbl_GAddress.setForeground(new java.awt.Color(255, 255, 255));
        GardenModify_lbl_GAddress.setText("Address : ");
        GardenModify_InsidePanel.add(GardenModify_lbl_GAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 271, -1, -1));

        GardenModify_lbl_GExpiry.setText("Expires on : ");
        GardenModify_lbl_GExpiry.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenModify_lbl_GExpiry.setForeground(new java.awt.Color(255, 255, 255));
        GardenModify_InsidePanel.add(GardenModify_lbl_GExpiry, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 469, -1, -1));

        GardenModify_tb_GID.setEditable(false);
        GardenModify_tb_GID.setBackground(new java.awt.Color(204, 204, 204));
        GardenModify_tb_GID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenModify_InsidePanel.add(GardenModify_tb_GID, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 146, 250, 45));

        GardenModify_tb_GName.setBackground(new java.awt.Color(204, 204, 204));
        GardenModify_tb_GName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenModify_InsidePanel.add(GardenModify_tb_GName, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 209, 400, 45));

        GardenModify_lbl_GNote.setText("Note : ");
        GardenModify_lbl_GNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenModify_lbl_GNote.setForeground(new java.awt.Color(255, 255, 255));
        GardenModify_InsidePanel.add(GardenModify_lbl_GNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 154, -1, -1));

        GardenModify_ta_GNote.setBackground(new java.awt.Color(255, 255, 153));
        GardenModify_ta_GNote.setColumns(20);
        GardenModify_ta_GNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenModify_ta_GNote.setRows(5);
        GardenModify_ScrPane_GNote.setViewportView(GardenModify_ta_GNote);

        GardenModify_InsidePanel.add(GardenModify_ScrPane_GNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 146, 400, 171));

        GardenModify_btn_Update.setText("Update");
        GardenModify_btn_Update.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenModify_btn_Update.setkBorderRadius(0);
        GardenModify_btn_Update.setkEndColor(new java.awt.Color(255, 51, 255));
        GardenModify_btn_Update.setkForeGround(new java.awt.Color(0, 0, 0));
        GardenModify_btn_Update.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        GardenModify_btn_Update.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        GardenModify_btn_Update.setkPressedColor(new java.awt.Color(153, 255, 153));
        GardenModify_btn_Update.setkStartColor(java.awt.Color.pink);
        GardenModify_btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GardenModify_btn_UpdateActionPerformed(evt);
            }
        });
        GardenModify_InsidePanel.add(GardenModify_btn_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 715, -1, -1));

        GardenModify_lbl_RDto_Garden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/back-arrow-50.png"))); // NOI18N
        GardenModify_InsidePanel.add(GardenModify_lbl_RDto_Garden, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 806, -1, 40));

        GardenModify_btn_RDto_Garden.setkBorderRadius(0);
        GardenModify_btn_RDto_Garden.setkEndColor(new java.awt.Color(0, 0, 0));
        GardenModify_btn_RDto_Garden.setkHoverStartColor(new java.awt.Color(204, 255, 255));
        GardenModify_btn_RDto_Garden.setkPressedColor(new java.awt.Color(255, 255, 102));
        GardenModify_btn_RDto_Garden.setkStartColor(new java.awt.Color(255, 255, 255));
        GardenModify_btn_RDto_Garden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GardenModify_btn_RDto_GardenActionPerformed(evt);
            }
        });
        GardenModify_InsidePanel.add(GardenModify_btn_RDto_Garden, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 801, 55, 50));

        GardenModify_lbl_Return.setText("Return");
        GardenModify_lbl_Return.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        GardenModify_lbl_Return.setForeground(new java.awt.Color(0, 255, 255));
        GardenModify_InsidePanel.add(GardenModify_lbl_Return, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 851, -1, -1));

        GardenModify_btn_editGName.setText("Edit");
        GardenModify_btn_editGName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenModify_btn_editGName.setkBorderRadius(0);
        GardenModify_btn_editGName.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        GardenModify_btn_editGName.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        GardenModify_btn_editGName.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        GardenModify_btn_editGName.setkPressedColor(new java.awt.Color(255, 255, 0));
        GardenModify_btn_editGName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GardenModify_btn_editGNameActionPerformed(evt);
            }
        });
        GardenModify_InsidePanel.add(GardenModify_btn_editGName, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, -1, -1));

        GardenModify_ta_GAddress.setBackground(new java.awt.Color(204, 204, 204));
        GardenModify_ta_GAddress.setColumns(20);
        GardenModify_ta_GAddress.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenModify_ta_GAddress.setRows(5);
        GardenModify_ScrPane_GAddress.setViewportView(GardenModify_ta_GAddress);

        GardenModify_InsidePanel.add(GardenModify_ScrPane_GAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 271, 400, 171));

        GardenModify_dtPicker_GExpiry.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenModify_InsidePanel.add(GardenModify_dtPicker_GExpiry, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 461, 250, 45));

        GardenModify_lbl_dateFormat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        GardenModify_lbl_dateFormat.setForeground(new java.awt.Color(255, 255, 255));
        GardenModify_lbl_dateFormat.setText("dd/mm/yyyy");
        GardenModify_InsidePanel.add(GardenModify_lbl_dateFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 513, 250, -1));

        Panel_GardenModify.add(GardenModify_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        GardenModify_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/manikandan-annamalai-XEBASsgifEc-unsplash.png"))); // NOI18N
        Panel_GardenModify.add(GardenModify_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_GardenModify, "card6");

        Panel_Hybrid.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Hybrid_InsidePanel.setBackground(new java.awt.Color(102, 102, 102));
        Hybrid_InsidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Hybrid_lbl_HID.setText("Hybrid ID : ");
        Hybrid_lbl_HID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_lbl_HID.setForeground(new java.awt.Color(255, 255, 255));
        Hybrid_InsidePanel.add(Hybrid_lbl_HID, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 163, -1, -1));

        Hybrid_lbl_HName.setText("Name : ");
        Hybrid_lbl_HName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_lbl_HName.setForeground(new java.awt.Color(255, 255, 255));
        Hybrid_InsidePanel.add(Hybrid_lbl_HName, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 226, -1, -1));

        Hybrid_lbl_HSpecies.setText("Species : ");
        Hybrid_lbl_HSpecies.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_lbl_HSpecies.setForeground(new java.awt.Color(255, 255, 255));
        Hybrid_InsidePanel.add(Hybrid_lbl_HSpecies, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 294, -1, -1));

        Hybrid_tb_HID.setEditable(false);
        Hybrid_tb_HID.setBackground(new java.awt.Color(204, 204, 204));
        Hybrid_tb_HID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_InsidePanel.add(Hybrid_tb_HID, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 155, 250, 45));

        Hybrid_tb_HName.setEditable(false);
        Hybrid_tb_HName.setBackground(new java.awt.Color(204, 204, 204));
        Hybrid_tb_HName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_InsidePanel.add(Hybrid_tb_HName, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 218, 400, 45));

        Hybrid_tb_HSpecies1.setEditable(false);
        Hybrid_tb_HSpecies1.setBackground(new java.awt.Color(255, 153, 153));
        Hybrid_tb_HSpecies1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_InsidePanel.add(Hybrid_tb_HSpecies1, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 286, 250, 45));

        Hybrid_tb_HSpecies2.setEditable(false);
        Hybrid_tb_HSpecies2.setBackground(new java.awt.Color(153, 204, 255));
        Hybrid_tb_HSpecies2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_InsidePanel.add(Hybrid_tb_HSpecies2, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 352, 250, 45));

        Hybrid_tb_HSpecies3.setEditable(false);
        Hybrid_tb_HSpecies3.setBackground(new java.awt.Color(153, 255, 153));
        Hybrid_tb_HSpecies3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_InsidePanel.add(Hybrid_tb_HSpecies3, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 418, 250, 45));

        Hybrid_tb_HSpecies4.setEditable(false);
        Hybrid_tb_HSpecies4.setBackground(new java.awt.Color(255, 255, 204));
        Hybrid_tb_HSpecies4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_InsidePanel.add(Hybrid_tb_HSpecies4, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 484, 250, 45));

        Hybrid_tb_HSpecies5.setEditable(false);
        Hybrid_tb_HSpecies5.setBackground(new java.awt.Color(153, 102, 255));
        Hybrid_tb_HSpecies5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_InsidePanel.add(Hybrid_tb_HSpecies5, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 550, 250, 45));

        Hybrid_lbl_Hdate.setText("Date : ");
        Hybrid_lbl_Hdate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_lbl_Hdate.setForeground(new java.awt.Color(255, 255, 255));
        Hybrid_InsidePanel.add(Hybrid_lbl_Hdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 163, -1, -1));

        Hybrid_tb_HDate.setEditable(false);
        Hybrid_tb_HDate.setBackground(new java.awt.Color(204, 204, 204));
        Hybrid_tb_HDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_InsidePanel.add(Hybrid_tb_HDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 155, 250, 45));

        Hybrid_lbl_HNote.setText("Note : ");
        Hybrid_lbl_HNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_lbl_HNote.setForeground(new java.awt.Color(255, 255, 255));
        Hybrid_InsidePanel.add(Hybrid_lbl_HNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 294, -1, -1));

        Hybrid_ta_HNote.setBackground(new java.awt.Color(255, 255, 153));
        Hybrid_ta_HNote.setColumns(20);
        Hybrid_ta_HNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_ta_HNote.setRows(5);
        Hybrid_ScrPane_HNote.setViewportView(Hybrid_ta_HNote);

        Hybrid_InsidePanel.add(Hybrid_ScrPane_HNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 286, 452, 188));

        Hybrid_InsidePanel_2.setBackground(new java.awt.Color(204, 204, 204));
        Hybrid_InsidePanel_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Hybrid_btnIcon_First.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/fast-backward-50.png"))); // NOI18N
        Hybrid_InsidePanel_2.add(Hybrid_btnIcon_First, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 50, -1));

        Hybrid_btnIcon_Previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/back-arrow-50.png"))); // NOI18N
        Hybrid_InsidePanel_2.add(Hybrid_btnIcon_Previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, -1, -1));

        Hybrid_btnIcon_Next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/front-arrow-50.png"))); // NOI18N
        Hybrid_InsidePanel_2.add(Hybrid_btnIcon_Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        Hybrid_btnIcon_Last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/fast-forward-50.png"))); // NOI18N
        Hybrid_InsidePanel_2.add(Hybrid_btnIcon_Last, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, -1, -1));

        Hybrid_btn_First.setkBorderRadius(0);
        Hybrid_btn_First.setkEndColor(new java.awt.Color(0, 0, 0));
        Hybrid_btn_First.setkHoverEndColor(new java.awt.Color(255, 0, 51));
        Hybrid_btn_First.setkHoverStartColor(new java.awt.Color(255, 153, 153));
        Hybrid_btn_First.setkPressedColor(new java.awt.Color(255, 255, 102));
        Hybrid_btn_First.setkStartColor(new java.awt.Color(255, 255, 255));
        Hybrid_btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hybrid_btn_FirstActionPerformed(evt);
            }
        });
        Hybrid_InsidePanel_2.add(Hybrid_btn_First, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 60, 100, 50));

        Hybrid_btn_Previous.setkBorderRadius(0);
        Hybrid_btn_Previous.setkEndColor(new java.awt.Color(0, 0, 0));
        Hybrid_btn_Previous.setkHoverStartColor(new java.awt.Color(204, 255, 255));
        Hybrid_btn_Previous.setkPressedColor(new java.awt.Color(255, 255, 102));
        Hybrid_btn_Previous.setkStartColor(new java.awt.Color(255, 255, 255));
        Hybrid_btn_Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hybrid_btn_PreviousActionPerformed(evt);
            }
        });
        Hybrid_InsidePanel_2.add(Hybrid_btn_Previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 60, 100, 50));

        Hybrid_btn_Next.setkBorderRadius(0);
        Hybrid_btn_Next.setkEndColor(new java.awt.Color(0, 0, 0));
        Hybrid_btn_Next.setkHoverStartColor(new java.awt.Color(204, 255, 255));
        Hybrid_btn_Next.setkPressedColor(new java.awt.Color(255, 255, 102));
        Hybrid_btn_Next.setkStartColor(new java.awt.Color(255, 255, 255));
        Hybrid_btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hybrid_btn_NextActionPerformed(evt);
            }
        });
        Hybrid_InsidePanel_2.add(Hybrid_btn_Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 60, 100, 50));

        Hybrid_btn_Last.setkBorderRadius(0);
        Hybrid_btn_Last.setkEndColor(new java.awt.Color(0, 0, 0));
        Hybrid_btn_Last.setkHoverEndColor(new java.awt.Color(255, 0, 51));
        Hybrid_btn_Last.setkHoverStartColor(new java.awt.Color(255, 153, 153));
        Hybrid_btn_Last.setkPressedColor(new java.awt.Color(255, 255, 102));
        Hybrid_btn_Last.setkStartColor(new java.awt.Color(255, 255, 255));
        Hybrid_btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hybrid_btn_LastActionPerformed(evt);
            }
        });
        Hybrid_InsidePanel_2.add(Hybrid_btn_Last, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 60, 100, 50));

        Hybrid_lbl_previous.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_lbl_previous.setForeground(new java.awt.Color(255, 255, 255));
        Hybrid_lbl_previous.setText("Previous");
        Hybrid_InsidePanel_2.add(Hybrid_lbl_previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, -1, -1));

        Hybrid_lbl_next.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_lbl_next.setForeground(new java.awt.Color(255, 255, 255));
        Hybrid_lbl_next.setText("Next");
        Hybrid_InsidePanel_2.add(Hybrid_lbl_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, -1, -1));

        Hybrid_lbl_first.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_lbl_first.setForeground(new java.awt.Color(255, 255, 255));
        Hybrid_lbl_first.setText("First");
        Hybrid_InsidePanel_2.add(Hybrid_lbl_first, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, -1));

        Hybrid_lbl_last.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_lbl_last.setForeground(new java.awt.Color(255, 255, 255));
        Hybrid_lbl_last.setText("Last");
        Hybrid_InsidePanel_2.add(Hybrid_lbl_last, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 110, -1, -1));

        Hybrid_btn_AddNew.setText("Add new");
        Hybrid_btn_AddNew.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_btn_AddNew.setkBorderRadius(0);
        Hybrid_btn_AddNew.setkEndColor(new java.awt.Color(255, 51, 255));
        Hybrid_btn_AddNew.setkForeGround(new java.awt.Color(0, 0, 0));
        Hybrid_btn_AddNew.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Hybrid_btn_AddNew.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Hybrid_btn_AddNew.setkPressedColor(new java.awt.Color(153, 255, 153));
        Hybrid_btn_AddNew.setkStartColor(java.awt.Color.pink);
        Hybrid_btn_AddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hybrid_btn_AddNewActionPerformed(evt);
            }
        });
        Hybrid_InsidePanel_2.add(Hybrid_btn_AddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(1355, 0, -1, -1));

        Hybrid_btn_Modify.setText("Modify");
        Hybrid_btn_Modify.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_btn_Modify.setkBorderRadius(0);
        Hybrid_btn_Modify.setkEndColor(new java.awt.Color(255, 51, 255));
        Hybrid_btn_Modify.setkForeGround(new java.awt.Color(0, 0, 0));
        Hybrid_btn_Modify.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Hybrid_btn_Modify.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Hybrid_btn_Modify.setkPressedColor(new java.awt.Color(153, 255, 153));
        Hybrid_btn_Modify.setkStartColor(java.awt.Color.pink);
        Hybrid_btn_Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hybrid_btn_ModifyActionPerformed(evt);
            }
        });
        Hybrid_InsidePanel_2.add(Hybrid_btn_Modify, new org.netbeans.lib.awtextra.AbsoluteConstraints(1355, 52, -1, -1));

        Hybrid_btn_Delete.setText("Delete");
        Hybrid_btn_Delete.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_btn_Delete.setkBorderRadius(0);
        Hybrid_btn_Delete.setkEndColor(new java.awt.Color(255, 51, 255));
        Hybrid_btn_Delete.setkForeGround(new java.awt.Color(0, 0, 0));
        Hybrid_btn_Delete.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Hybrid_btn_Delete.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Hybrid_btn_Delete.setkPressedColor(new java.awt.Color(153, 255, 153));
        Hybrid_btn_Delete.setkStartColor(java.awt.Color.pink);
        Hybrid_btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hybrid_btn_DeleteActionPerformed(evt);
            }
        });
        Hybrid_InsidePanel_2.add(Hybrid_btn_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1355, 108, -1, -1));

        Hybrid_InsidePanel_3.setBackground(new java.awt.Color(0, 0, 0));
        Hybrid_InsidePanel_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Hybrid_lbl_Count.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Hybrid_lbl_Count.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Hybrid_lbl_Count.setForeground(new java.awt.Color(255, 255, 255));
        Hybrid_InsidePanel_3.add(Hybrid_lbl_Count, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 7, 306, 45));

        Hybrid_InsidePanel_2.add(Hybrid_InsidePanel_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 0, 400, 60));

        Hybrid_InsidePanel.add(Hybrid_InsidePanel_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 715, -1, -1));

        Hybrid_lbl_Search.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_lbl_Search.setForeground(new java.awt.Color(255, 255, 255));
        Hybrid_lbl_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/search25px1.png"))); // NOI18N
        Hybrid_lbl_Search.setText("Search : ");
        Hybrid_InsidePanel.add(Hybrid_lbl_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        Hybrid_tb_SearchBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_InsidePanel.add(Hybrid_tb_SearchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 360, 45));

        Hybrid_btn_Search.setText("Search");
        Hybrid_btn_Search.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Hybrid_btn_Search.setkBorderRadius(0);
        Hybrid_btn_Search.setkEndColor(new java.awt.Color(255, 153, 153));
        Hybrid_btn_Search.setkForeGround(new java.awt.Color(0, 0, 0));
        Hybrid_btn_Search.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        Hybrid_btn_Search.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Hybrid_btn_Search.setkHoverStartColor(new java.awt.Color(204, 255, 51));
        Hybrid_btn_Search.setkPressedColor(new java.awt.Color(255, 255, 255));
        Hybrid_btn_Search.setkSelectedColor(new java.awt.Color(255, 255, 255));
        Hybrid_btn_Search.setkStartColor(new java.awt.Color(255, 204, 0));
        Hybrid_btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hybrid_btn_SearchActionPerformed(evt);
            }
        });
        Hybrid_InsidePanel.add(Hybrid_btn_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 20, -1, -1));

        Panel_Hybrid.add(Hybrid_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        PanelHybrid_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/phillip-larking-G7zQ_y2cSGk-unsplash.png"))); // NOI18N
        PanelHybrid_lbl_bg.setOpaque(true);
        Panel_Hybrid.add(PanelHybrid_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_Hybrid, "card3");

        Panel_HybridAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HybridAdd_InsidePanel.setBackground(new java.awt.Color(102, 102, 102));
        HybridAdd_InsidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HybridAdd_lbl_HID.setText("Hybrid ID : ");
        HybridAdd_lbl_HID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_lbl_HID.setForeground(new java.awt.Color(255, 255, 255));
        HybridAdd_InsidePanel.add(HybridAdd_lbl_HID, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 163, -1, -1));

        HybridAdd_lbl_HName.setText("Name : ");
        HybridAdd_lbl_HName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_lbl_HName.setForeground(new java.awt.Color(255, 255, 255));
        HybridAdd_InsidePanel.add(HybridAdd_lbl_HName, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 226, -1, -1));

        HybridAdd_lbl_HSpecies.setText("Species : ");
        HybridAdd_lbl_HSpecies.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_lbl_HSpecies.setForeground(new java.awt.Color(255, 255, 255));
        HybridAdd_InsidePanel.add(HybridAdd_lbl_HSpecies, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 294, -1, -1));

        HybridAdd_tb_HID.setEditable(false);
        HybridAdd_tb_HID.setBackground(new java.awt.Color(204, 204, 204));
        HybridAdd_tb_HID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_InsidePanel.add(HybridAdd_tb_HID, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 155, 250, 45));

        HybridAdd_tb_HName.setBackground(new java.awt.Color(204, 204, 204));
        HybridAdd_tb_HName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_InsidePanel.add(HybridAdd_tb_HName, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 218, 470, 45));

        HybridAdd_tb_HSpecies1.setEditable(false);
        HybridAdd_tb_HSpecies1.setBackground(new java.awt.Color(255, 153, 153));
        HybridAdd_tb_HSpecies1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_InsidePanel.add(HybridAdd_tb_HSpecies1, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 286, 250, 45));

        HybridAdd_tb_HSpecies2.setEditable(false);
        HybridAdd_tb_HSpecies2.setBackground(new java.awt.Color(153, 204, 255));
        HybridAdd_tb_HSpecies2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_InsidePanel.add(HybridAdd_tb_HSpecies2, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 352, 250, 45));

        HybridAdd_tb_HSpecies3.setEditable(false);
        HybridAdd_tb_HSpecies3.setBackground(new java.awt.Color(153, 255, 153));
        HybridAdd_tb_HSpecies3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_InsidePanel.add(HybridAdd_tb_HSpecies3, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 418, 250, 45));

        HybridAdd_tb_HSpecies4.setEditable(false);
        HybridAdd_tb_HSpecies4.setBackground(new java.awt.Color(255, 255, 204));
        HybridAdd_tb_HSpecies4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_InsidePanel.add(HybridAdd_tb_HSpecies4, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 484, 250, 45));

        HybridAdd_tb_HSpecies5.setEditable(false);
        HybridAdd_tb_HSpecies5.setBackground(new java.awt.Color(153, 102, 255));
        HybridAdd_tb_HSpecies5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_InsidePanel.add(HybridAdd_tb_HSpecies5, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 550, 250, 45));

        HybridAdd_cmb_HSpecies1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HybridAdd_cmb_HSpecies1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridAdd_cmb_HSpecies1ActionPerformed(evt);
            }
        });
        HybridAdd_InsidePanel.add(HybridAdd_cmb_HSpecies1, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 286, 200, 45));

        HybridAdd_cmb_HSpecies2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HybridAdd_cmb_HSpecies2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridAdd_cmb_HSpecies2ActionPerformed(evt);
            }
        });
        HybridAdd_InsidePanel.add(HybridAdd_cmb_HSpecies2, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 352, 200, 45));

        HybridAdd_cmb_HSpecies3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HybridAdd_cmb_HSpecies3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridAdd_cmb_HSpecies3ActionPerformed(evt);
            }
        });
        HybridAdd_InsidePanel.add(HybridAdd_cmb_HSpecies3, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 418, 200, 45));

        HybridAdd_cmb_HSpecies4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HybridAdd_cmb_HSpecies4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridAdd_cmb_HSpecies4ActionPerformed(evt);
            }
        });
        HybridAdd_InsidePanel.add(HybridAdd_cmb_HSpecies4, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 484, 200, 45));

        HybridAdd_cmb_HSpecies5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HybridAdd_cmb_HSpecies5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridAdd_cmb_HSpecies5ActionPerformed(evt);
            }
        });
        HybridAdd_InsidePanel.add(HybridAdd_cmb_HSpecies5, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 550, 200, 45));

        HybridAdd_lbl_HDate.setText("Date : ");
        HybridAdd_lbl_HDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_lbl_HDate.setForeground(new java.awt.Color(255, 255, 255));
        HybridAdd_InsidePanel.add(HybridAdd_lbl_HDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(963, 163, -1, -1));

        HybridAdd_lbl_HNote.setText("Note : ");
        HybridAdd_lbl_HNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_lbl_HNote.setForeground(new java.awt.Color(255, 255, 255));
        HybridAdd_InsidePanel.add(HybridAdd_lbl_HNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(963, 294, -1, -1));

        HybridAdd_ta_HNote.setBackground(new java.awt.Color(255, 255, 153));
        HybridAdd_ta_HNote.setColumns(20);
        HybridAdd_ta_HNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_ta_HNote.setRows(5);
        HybridAdd_ScrPane_HNote.setViewportView(HybridAdd_ta_HNote);

        HybridAdd_InsidePanel.add(HybridAdd_ScrPane_HNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(1055, 286, 452, 188));

        HybridAdd_btn_hsp1Clear.setText("Clear");
        HybridAdd_btn_hsp1Clear.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_btn_hsp1Clear.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        HybridAdd_btn_hsp1Clear.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        HybridAdd_btn_hsp1Clear.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        HybridAdd_btn_hsp1Clear.setkPressedColor(new java.awt.Color(255, 255, 0));
        HybridAdd_btn_hsp1Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridAdd_btn_hsp1ClearActionPerformed(evt);
            }
        });
        HybridAdd_InsidePanel.add(HybridAdd_btn_hsp1Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 286, -1, -1));

        HybridAdd_btn_hsp2Clear.setText("Clear");
        HybridAdd_btn_hsp2Clear.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_btn_hsp2Clear.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        HybridAdd_btn_hsp2Clear.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        HybridAdd_btn_hsp2Clear.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        HybridAdd_btn_hsp2Clear.setkPressedColor(new java.awt.Color(255, 255, 0));
        HybridAdd_btn_hsp2Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridAdd_btn_hsp2ClearActionPerformed(evt);
            }
        });
        HybridAdd_InsidePanel.add(HybridAdd_btn_hsp2Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 352, -1, -1));

        HybridAdd_btn_hsp3Clear.setText("Clear");
        HybridAdd_btn_hsp3Clear.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_btn_hsp3Clear.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        HybridAdd_btn_hsp3Clear.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        HybridAdd_btn_hsp3Clear.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        HybridAdd_btn_hsp3Clear.setkPressedColor(new java.awt.Color(255, 255, 0));
        HybridAdd_btn_hsp3Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridAdd_btn_hsp3ClearActionPerformed(evt);
            }
        });
        HybridAdd_InsidePanel.add(HybridAdd_btn_hsp3Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 418, -1, -1));

        HybridAdd_btn_hsp4Clear.setText("Clear");
        HybridAdd_btn_hsp4Clear.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_btn_hsp4Clear.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        HybridAdd_btn_hsp4Clear.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        HybridAdd_btn_hsp4Clear.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        HybridAdd_btn_hsp4Clear.setkPressedColor(new java.awt.Color(255, 255, 0));
        HybridAdd_btn_hsp4Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridAdd_btn_hsp4ClearActionPerformed(evt);
            }
        });
        HybridAdd_InsidePanel.add(HybridAdd_btn_hsp4Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 484, -1, -1));

        HybridAdd_btn_hsp5Clear.setText("Clear");
        HybridAdd_btn_hsp5Clear.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_btn_hsp5Clear.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        HybridAdd_btn_hsp5Clear.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        HybridAdd_btn_hsp5Clear.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        HybridAdd_btn_hsp5Clear.setkPressedColor(new java.awt.Color(255, 255, 0));
        HybridAdd_btn_hsp5Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridAdd_btn_hsp5ClearActionPerformed(evt);
            }
        });
        HybridAdd_InsidePanel.add(HybridAdd_btn_hsp5Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 550, -1, -1));

        HybridAdd_btn_Add.setText("Add");
        HybridAdd_btn_Add.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_btn_Add.setkBorderRadius(0);
        HybridAdd_btn_Add.setkEndColor(new java.awt.Color(255, 51, 255));
        HybridAdd_btn_Add.setkForeGround(new java.awt.Color(0, 0, 0));
        HybridAdd_btn_Add.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        HybridAdd_btn_Add.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        HybridAdd_btn_Add.setkPressedColor(new java.awt.Color(153, 255, 153));
        HybridAdd_btn_Add.setkStartColor(java.awt.Color.pink);
        HybridAdd_btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridAdd_btn_AddActionPerformed(evt);
            }
        });
        HybridAdd_InsidePanel.add(HybridAdd_btn_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 720, -1, -1));

        HybridAdd_dtPicker_HDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_InsidePanel.add(HybridAdd_dtPicker_HDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1055, 155, 250, 45));

        HybridAdd_lbl_RDto_Hybrid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/back-arrow-50.png"))); // NOI18N
        HybridAdd_InsidePanel.add(HybridAdd_lbl_RDto_Hybrid, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 815, 50, 40));

        HybridAdd_btn_RDto_Hybrid.setkBorderRadius(0);
        HybridAdd_btn_RDto_Hybrid.setkEndColor(new java.awt.Color(0, 0, 0));
        HybridAdd_btn_RDto_Hybrid.setkHoverStartColor(new java.awt.Color(204, 255, 255));
        HybridAdd_btn_RDto_Hybrid.setkPressedColor(new java.awt.Color(255, 255, 102));
        HybridAdd_btn_RDto_Hybrid.setkStartColor(new java.awt.Color(255, 255, 255));
        HybridAdd_btn_RDto_Hybrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridAdd_btn_RDto_HybridActionPerformed(evt);
            }
        });
        HybridAdd_InsidePanel.add(HybridAdd_btn_RDto_Hybrid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 810, 55, 50));

        HybridAdd_lbl_Return.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        HybridAdd_lbl_Return.setForeground(new java.awt.Color(0, 255, 255));
        HybridAdd_lbl_Return.setText("Return");
        HybridAdd_InsidePanel.add(HybridAdd_lbl_Return, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 860, -1, -1));

        HybridAdd_btn_clearAll.setText("Clear all fields");
        HybridAdd_btn_clearAll.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridAdd_btn_clearAll.setkBorderRadius(0);
        HybridAdd_btn_clearAll.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        HybridAdd_btn_clearAll.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        HybridAdd_btn_clearAll.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        HybridAdd_btn_clearAll.setkPressedColor(new java.awt.Color(255, 255, 0));
        HybridAdd_btn_clearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridAdd_btn_clearAllActionPerformed(evt);
            }
        });
        HybridAdd_InsidePanel.add(HybridAdd_btn_clearAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 815, 185, -1));

        Panel_HybridAdd.add(HybridAdd_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        PanelHybridAdd_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/phillip-larking-G7zQ_y2cSGk-unsplash.png"))); // NOI18N
        PanelHybridAdd_lbl_bg.setOpaque(true);
        Panel_HybridAdd.add(PanelHybridAdd_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_HybridAdd, "card3");

        Panel_HybridModify.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HybridModify_InsidePanel.setBackground(new java.awt.Color(102, 102, 102));
        HybridModify_InsidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HybridModify_lbl_HID.setText("Hybrid ID : ");
        HybridModify_lbl_HID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_lbl_HID.setForeground(new java.awt.Color(255, 255, 255));
        HybridModify_InsidePanel.add(HybridModify_lbl_HID, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 163, -1, -1));

        HybridModify_lbl_HName.setText("Name : ");
        HybridModify_lbl_HName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_lbl_HName.setForeground(new java.awt.Color(255, 255, 255));
        HybridModify_InsidePanel.add(HybridModify_lbl_HName, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 226, -1, -1));

        HybridModify_lbl_HSpecies.setText("Species : ");
        HybridModify_lbl_HSpecies.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_lbl_HSpecies.setForeground(new java.awt.Color(255, 255, 255));
        HybridModify_InsidePanel.add(HybridModify_lbl_HSpecies, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 294, -1, -1));

        HybridModify_tb_HID.setBackground(new java.awt.Color(204, 204, 204));
        HybridModify_tb_HID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_InsidePanel.add(HybridModify_tb_HID, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 155, 250, 45));

        HybridModify_tb_HName.setBackground(new java.awt.Color(204, 204, 204));
        HybridModify_tb_HName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_InsidePanel.add(HybridModify_tb_HName, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 218, 470, 45));

        HybridModify_tb_HSpecies1.setEditable(false);
        HybridModify_tb_HSpecies1.setBackground(new java.awt.Color(255, 153, 153));
        HybridModify_tb_HSpecies1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_InsidePanel.add(HybridModify_tb_HSpecies1, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 286, 250, 45));

        HybridModify_tb_HSpecies2.setEditable(false);
        HybridModify_tb_HSpecies2.setBackground(new java.awt.Color(153, 204, 255));
        HybridModify_tb_HSpecies2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_InsidePanel.add(HybridModify_tb_HSpecies2, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 352, 250, 45));

        HybridModify_tb_HSpecies3.setEditable(false);
        HybridModify_tb_HSpecies3.setBackground(new java.awt.Color(153, 255, 153));
        HybridModify_tb_HSpecies3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_InsidePanel.add(HybridModify_tb_HSpecies3, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 418, 250, 45));

        HybridModify_tb_HSpecies4.setEditable(false);
        HybridModify_tb_HSpecies4.setBackground(new java.awt.Color(255, 255, 204));
        HybridModify_tb_HSpecies4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_InsidePanel.add(HybridModify_tb_HSpecies4, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 484, 250, 45));

        HybridModify_tb_HSpecies5.setEditable(false);
        HybridModify_tb_HSpecies5.setBackground(new java.awt.Color(153, 102, 255));
        HybridModify_tb_HSpecies5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_InsidePanel.add(HybridModify_tb_HSpecies5, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 550, 250, 45));

        HybridModify_cmb_HSpecies1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HybridModify_cmb_HSpecies1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridModify_cmb_HSpecies1ActionPerformed(evt);
            }
        });
        HybridModify_InsidePanel.add(HybridModify_cmb_HSpecies1, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 286, 200, 45));

        HybridModify_cmb_HSpecies2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HybridModify_cmb_HSpecies2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridModify_cmb_HSpecies2ActionPerformed(evt);
            }
        });
        HybridModify_InsidePanel.add(HybridModify_cmb_HSpecies2, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 352, 200, 45));

        HybridModify_cmb_HSpecies3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HybridModify_cmb_HSpecies3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridModify_cmb_HSpecies3ActionPerformed(evt);
            }
        });
        HybridModify_InsidePanel.add(HybridModify_cmb_HSpecies3, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 418, 200, 45));

        HybridModify_cmb_HSpecies4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HybridModify_cmb_HSpecies4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridModify_cmb_HSpecies4ActionPerformed(evt);
            }
        });
        HybridModify_InsidePanel.add(HybridModify_cmb_HSpecies4, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 484, 200, 45));

        HybridModify_cmb_HSpecies5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HybridModify_cmb_HSpecies5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridModify_cmb_HSpecies5ActionPerformed(evt);
            }
        });
        HybridModify_InsidePanel.add(HybridModify_cmb_HSpecies5, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 550, 200, 45));

        HybridModify_lbl_HDate.setText("Date : ");
        HybridModify_lbl_HDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_lbl_HDate.setForeground(new java.awt.Color(255, 255, 255));
        HybridModify_InsidePanel.add(HybridModify_lbl_HDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(963, 163, -1, -1));

        HybridModify_lbl_HNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_lbl_HNote.setForeground(new java.awt.Color(255, 255, 255));
        HybridModify_lbl_HNote.setText("Note : ");
        HybridModify_InsidePanel.add(HybridModify_lbl_HNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(963, 294, -1, -1));

        HybridModify_ta_HNote.setBackground(new java.awt.Color(255, 255, 153));
        HybridModify_ta_HNote.setColumns(20);
        HybridModify_ta_HNote.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_ta_HNote.setRows(5);
        HybridModify_ScrPane_HNote.setViewportView(HybridModify_ta_HNote);

        HybridModify_InsidePanel.add(HybridModify_ScrPane_HNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(1055, 286, 452, 188));

        HybridModify_btn_hsp1Clear.setText("Clear");
        HybridModify_btn_hsp1Clear.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_btn_hsp1Clear.setkBorderRadius(0);
        HybridModify_btn_hsp1Clear.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        HybridModify_btn_hsp1Clear.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        HybridModify_btn_hsp1Clear.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        HybridModify_btn_hsp1Clear.setkPressedColor(new java.awt.Color(255, 255, 0));
        HybridModify_btn_hsp1Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridModify_btn_hsp1ClearActionPerformed(evt);
            }
        });
        HybridModify_InsidePanel.add(HybridModify_btn_hsp1Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 286, -1, -1));

        HybridModify_btn_hsp2Clear.setText("Clear");
        HybridModify_btn_hsp2Clear.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_btn_hsp2Clear.setkBorderRadius(0);
        HybridModify_btn_hsp2Clear.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        HybridModify_btn_hsp2Clear.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        HybridModify_btn_hsp2Clear.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        HybridModify_btn_hsp2Clear.setkPressedColor(new java.awt.Color(255, 255, 0));
        HybridModify_btn_hsp2Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridModify_btn_hsp2ClearActionPerformed(evt);
            }
        });
        HybridModify_InsidePanel.add(HybridModify_btn_hsp2Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 352, -1, -1));

        HybridModify_btn_hsp3Clear.setText("Clear");
        HybridModify_btn_hsp3Clear.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_btn_hsp3Clear.setkBorderRadius(0);
        HybridModify_btn_hsp3Clear.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        HybridModify_btn_hsp3Clear.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        HybridModify_btn_hsp3Clear.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        HybridModify_btn_hsp3Clear.setkPressedColor(new java.awt.Color(255, 255, 0));
        HybridModify_btn_hsp3Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridModify_btn_hsp3ClearActionPerformed(evt);
            }
        });
        HybridModify_InsidePanel.add(HybridModify_btn_hsp3Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 418, -1, -1));

        HybridModify_btn_hsp4Clear.setText("Clear");
        HybridModify_btn_hsp4Clear.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_btn_hsp4Clear.setkBorderRadius(0);
        HybridModify_btn_hsp4Clear.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        HybridModify_btn_hsp4Clear.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        HybridModify_btn_hsp4Clear.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        HybridModify_btn_hsp4Clear.setkPressedColor(new java.awt.Color(255, 255, 0));
        HybridModify_btn_hsp4Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridModify_btn_hsp4ClearActionPerformed(evt);
            }
        });
        HybridModify_InsidePanel.add(HybridModify_btn_hsp4Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 484, -1, -1));

        HybridModify_btn_hsp5Clear.setText("Clear");
        HybridModify_btn_hsp5Clear.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_btn_hsp5Clear.setkBorderRadius(0);
        HybridModify_btn_hsp5Clear.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        HybridModify_btn_hsp5Clear.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        HybridModify_btn_hsp5Clear.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        HybridModify_btn_hsp5Clear.setkPressedColor(new java.awt.Color(255, 255, 0));
        HybridModify_btn_hsp5Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridModify_btn_hsp5ClearActionPerformed(evt);
            }
        });
        HybridModify_InsidePanel.add(HybridModify_btn_hsp5Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 550, -1, -1));

        HybridModify_btn_Update.setText("Update");
        HybridModify_btn_Update.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_btn_Update.setkBorderRadius(0);
        HybridModify_btn_Update.setkEndColor(new java.awt.Color(255, 51, 255));
        HybridModify_btn_Update.setkForeGround(new java.awt.Color(0, 0, 0));
        HybridModify_btn_Update.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        HybridModify_btn_Update.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        HybridModify_btn_Update.setkPressedColor(new java.awt.Color(153, 255, 153));
        HybridModify_btn_Update.setkStartColor(java.awt.Color.pink);
        HybridModify_btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridModify_btn_UpdateActionPerformed(evt);
            }
        });
        HybridModify_InsidePanel.add(HybridModify_btn_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 715, -1, -1));

        HybridModify_lbl_RDto_Hybrid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/back-arrow-50.png"))); // NOI18N
        HybridModify_InsidePanel.add(HybridModify_lbl_RDto_Hybrid, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 806, -1, 40));

        HybridModify_btn_RDto_Hybrid.setkBorderRadius(0);
        HybridModify_btn_RDto_Hybrid.setkEndColor(new java.awt.Color(0, 0, 0));
        HybridModify_btn_RDto_Hybrid.setkHoverStartColor(new java.awt.Color(204, 255, 255));
        HybridModify_btn_RDto_Hybrid.setkPressedColor(new java.awt.Color(255, 255, 102));
        HybridModify_btn_RDto_Hybrid.setkStartColor(new java.awt.Color(255, 255, 255));
        HybridModify_btn_RDto_Hybrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridModify_btn_RDto_HybridActionPerformed(evt);
            }
        });
        HybridModify_InsidePanel.add(HybridModify_btn_RDto_Hybrid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 801, 55, 50));

        HybridModify_lbl_Return.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        HybridModify_lbl_Return.setForeground(new java.awt.Color(0, 255, 255));
        HybridModify_lbl_Return.setText("Return");
        HybridModify_InsidePanel.add(HybridModify_lbl_Return, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 851, -1, -1));

        HybridModify_dtPicker_HDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_InsidePanel.add(HybridModify_dtPicker_HDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1055, 155, 250, 45));

        HybridModify_btn_editHName.setText("Edit");
        HybridModify_btn_editHName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HybridModify_btn_editHName.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        HybridModify_btn_editHName.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        HybridModify_btn_editHName.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        HybridModify_btn_editHName.setkPressedColor(new java.awt.Color(255, 255, 0));
        HybridModify_btn_editHName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridModify_btn_editHNameActionPerformed(evt);
            }
        });
        HybridModify_InsidePanel.add(HybridModify_btn_editHName, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 218, -1, -1));

        Panel_HybridModify.add(HybridModify_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        PanelHybridModify_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/phillip-larking-G7zQ_y2cSGk-unsplash.png"))); // NOI18N
        PanelHybridModify_lbl_bg.setOpaque(true);
        Panel_HybridModify.add(PanelHybridModify_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_HybridModify, "card3");

        Panel_Notify.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Notify_InsidePanel.setBackground(new java.awt.Color(102, 102, 102));

        Notify_lbl_NID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Notify_lbl_NID.setForeground(new java.awt.Color(255, 255, 255));
        Notify_lbl_NID.setText("Notification  ID : ");

        Notify_lbl_PID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Notify_lbl_PID.setForeground(new java.awt.Color(255, 255, 255));
        Notify_lbl_PID.setText("Plant ID : ");

        Notify_lbl_NDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Notify_lbl_NDate.setForeground(new java.awt.Color(255, 255, 255));
        Notify_lbl_NDate.setText("Notify on : ");

        Notify_tb_NID.setEditable(false);
        Notify_tb_NID.setBackground(new java.awt.Color(204, 204, 204));
        Notify_tb_NID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        Notify_cmb_PID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Notify_cmb_PID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Notify_cmb_PIDActionPerformed(evt);
            }
        });

        Notify_dtPicker_NDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        Notify_btn_setNotification.setText("Set notification");
        Notify_btn_setNotification.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Notify_btn_setNotification.setkBorderRadius(0);
        Notify_btn_setNotification.setkEndColor(new java.awt.Color(255, 51, 255));
        Notify_btn_setNotification.setkForeGround(new java.awt.Color(0, 0, 0));
        Notify_btn_setNotification.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Notify_btn_setNotification.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Notify_btn_setNotification.setkPressedColor(new java.awt.Color(153, 255, 153));
        Notify_btn_setNotification.setkStartColor(java.awt.Color.pink);
        Notify_btn_setNotification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Notify_btn_setNotificationActionPerformed(evt);
            }
        });

        Notify_ta_Note.setColumns(20);
        Notify_ta_Note.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Notify_ta_Note.setRows(5);
        Notify_ScrPane_Note.setViewportView(Notify_ta_Note);

        Notify_lbl_Note.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Notify_lbl_Note.setForeground(new java.awt.Color(255, 255, 255));
        Notify_lbl_Note.setText("Note : ");

        Notify_lbl_PName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Notify_lbl_PName.setForeground(new java.awt.Color(255, 255, 255));
        Notify_lbl_PName.setText("Plant name : ");

        Notify_tb_PName.setBackground(new java.awt.Color(204, 204, 204));
        Notify_tb_PName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        Notify_lbl_PSciName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Notify_lbl_PSciName.setForeground(new java.awt.Color(255, 255, 255));
        Notify_lbl_PSciName.setText("Scientific name : ");

        Notify_tb_PSciName.setEditable(false);
        Notify_tb_PSciName.setBackground(new java.awt.Color(204, 204, 204));
        Notify_tb_PSciName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        Notify_lbl_PQuantity.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Notify_lbl_PQuantity.setForeground(new java.awt.Color(255, 255, 255));
        Notify_lbl_PQuantity.setText("Tags : ");

        Notify_tb_PTag1.setEditable(false);
        Notify_tb_PTag1.setBackground(new java.awt.Color(153, 255, 153));
        Notify_tb_PTag1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        Notify_tb_PTag2.setEditable(false);
        Notify_tb_PTag2.setBackground(new java.awt.Color(153, 255, 153));
        Notify_tb_PTag2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        Notify_tb_PTag3.setEditable(false);
        Notify_tb_PTag3.setBackground(new java.awt.Color(153, 255, 153));
        Notify_tb_PTag3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        Notify_tb_PTag4.setEditable(false);
        Notify_tb_PTag4.setBackground(new java.awt.Color(153, 255, 153));
        Notify_tb_PTag4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        Notify_tb_PTag5.setEditable(false);
        Notify_tb_PTag5.setBackground(new java.awt.Color(153, 255, 153));
        Notify_tb_PTag5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout Notify_InsidePanelLayout = new javax.swing.GroupLayout(Notify_InsidePanel);
        Notify_InsidePanel.setLayout(Notify_InsidePanelLayout);
        Notify_InsidePanelLayout.setHorizontalGroup(
            Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Notify_InsidePanelLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Notify_lbl_NID)
                        .addGroup(Notify_InsidePanelLayout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(Notify_lbl_PID)))
                    .addComponent(Notify_lbl_NDate)
                    .addComponent(Notify_lbl_Note))
                .addGap(18, 18, 18)
                .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Notify_tb_NID, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Notify_InsidePanelLayout.createSequentialGroup()
                        .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Notify_InsidePanelLayout.createSequentialGroup()
                                .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Notify_cmb_PID, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Notify_dtPicker_NDate, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Notify_ScrPane_Note, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Notify_lbl_PSciName)
                                    .addComponent(Notify_lbl_PName)
                                    .addComponent(Notify_lbl_PQuantity)))
                            .addComponent(Notify_btn_setNotification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Notify_tb_PTag3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Notify_tb_PName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Notify_tb_PSciName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Notify_tb_PTag1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Notify_tb_PTag5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Notify_tb_PTag2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Notify_tb_PTag4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
        );
        Notify_InsidePanelLayout.setVerticalGroup(
            Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Notify_InsidePanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Notify_InsidePanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(Notify_lbl_NID)
                        .addGap(29, 29, 29)
                        .addComponent(Notify_lbl_PID))
                    .addGroup(Notify_InsidePanelLayout.createSequentialGroup()
                        .addComponent(Notify_tb_NID, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Notify_InsidePanelLayout.createSequentialGroup()
                                .addComponent(Notify_cmb_PID, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Notify_dtPicker_NDate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Notify_lbl_NDate))
                                .addGap(18, 18, 18)
                                .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Notify_lbl_Note)
                                    .addComponent(Notify_ScrPane_Note)))
                            .addGroup(Notify_InsidePanelLayout.createSequentialGroup()
                                .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Notify_lbl_PName)
                                    .addComponent(Notify_tb_PName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Notify_lbl_PSciName)
                                    .addComponent(Notify_tb_PSciName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Notify_lbl_PQuantity)
                                    .addComponent(Notify_tb_PTag1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(Notify_tb_PTag2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Notify_tb_PTag3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(Notify_tb_PTag4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Notify_InsidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Notify_tb_PTag5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Notify_btn_setNotification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(334, Short.MAX_VALUE))
        );

        Panel_Notify.add(Notify_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        PanelNotify_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/hunter-desmarais-hUc3HEtxl14-unsplash.png"))); // NOI18N
        Panel_Notify.add(PanelNotify_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_Notify, "card4");

        Panel_Sell.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Sell_InsidePanel.setBackground(new java.awt.Color(102, 102, 102));
        Sell_InsidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Sell_lbl_issueID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_lbl_issueID.setForeground(new java.awt.Color(255, 255, 255));
        Sell_lbl_issueID.setText("Issue  ID : ");
        Sell_InsidePanel.add(Sell_lbl_issueID, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 118, -1, -1));

        Sell_tb_SID.setEditable(false);
        Sell_tb_SID.setBackground(new java.awt.Color(204, 204, 204));
        Sell_tb_SID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_InsidePanel.add(Sell_tb_SID, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 110, 300, 45));

        Sell_lbl_issueDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_lbl_issueDate.setForeground(new java.awt.Color(255, 255, 255));
        Sell_lbl_issueDate.setText("Issue Date : ");
        Sell_InsidePanel.add(Sell_lbl_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 118, -1, -1));

        Sell_tb_issueDate.setEditable(false);
        Sell_tb_issueDate.setBackground(new java.awt.Color(204, 204, 204));
        Sell_tb_issueDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_InsidePanel.add(Sell_tb_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 400, 45));

        Sell_lbl_PID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_lbl_PID.setForeground(new java.awt.Color(255, 255, 255));
        Sell_lbl_PID.setText("Plant ID : ");
        Sell_InsidePanel.add(Sell_lbl_PID, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 244, -1, -1));

        Sell_tb_PID.setEditable(false);
        Sell_tb_PID.setBackground(new java.awt.Color(204, 204, 204));
        Sell_tb_PID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_InsidePanel.add(Sell_tb_PID, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 236, 300, 45));

        Sell_lbl_PName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_lbl_PName.setForeground(new java.awt.Color(255, 255, 255));
        Sell_lbl_PName.setText("Plant Name : ");
        Sell_InsidePanel.add(Sell_lbl_PName, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 244, -1, -1));

        Sell_tb_PName.setEditable(false);
        Sell_tb_PName.setBackground(new java.awt.Color(204, 204, 204));
        Sell_tb_PName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_InsidePanel.add(Sell_tb_PName, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 236, 300, 45));

        Sell_lbl_PSciname.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_lbl_PSciname.setForeground(new java.awt.Color(255, 255, 255));
        Sell_lbl_PSciname.setText("Scientific Name : ");
        Sell_InsidePanel.add(Sell_lbl_PSciname, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 307, -1, -1));

        Sell_tb_PSciname.setEditable(false);
        Sell_tb_PSciname.setBackground(new java.awt.Color(204, 204, 204));
        Sell_tb_PSciname.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_InsidePanel.add(Sell_tb_PSciname, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 299, 300, 45));

        Sell_lbl_PQuantity_toSell.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_lbl_PQuantity_toSell.setForeground(new java.awt.Color(255, 255, 255));
        Sell_lbl_PQuantity_toSell.setText("Quantity to sell : ");
        Sell_InsidePanel.add(Sell_lbl_PQuantity_toSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        Sell_tb_PQuantity_toSell.setBackground(new java.awt.Color(255, 255, 153));
        Sell_tb_PQuantity_toSell.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_InsidePanel.add(Sell_tb_PQuantity_toSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 362, 300, 45));

        Sell_lbl_PPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_lbl_PPrice.setForeground(new java.awt.Color(255, 255, 255));
        Sell_lbl_PPrice.setText("Price per unit : ");
        Sell_InsidePanel.add(Sell_lbl_PPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 433, -1, -1));

        Sell_tb_PPrice.setEditable(false);
        Sell_tb_PPrice.setBackground(new java.awt.Color(204, 204, 204));
        Sell_tb_PPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_InsidePanel.add(Sell_tb_PPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 425, 300, 45));

        Sell_lbl_custName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_lbl_custName.setForeground(new java.awt.Color(255, 255, 255));
        Sell_lbl_custName.setText("Customer's name : ");
        Sell_InsidePanel.add(Sell_lbl_custName, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 433, -1, -1));

        Sell_tb_custName.setBackground(new java.awt.Color(255, 255, 153));
        Sell_tb_custName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_InsidePanel.add(Sell_tb_custName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 425, 300, 45));

        Sell_lbl_custContact.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_lbl_custContact.setForeground(new java.awt.Color(255, 255, 255));
        Sell_lbl_custContact.setText("Customer's contact :");
        Sell_InsidePanel.add(Sell_lbl_custContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 496, -1, -1));

        Sell_tb_custContact.setBackground(new java.awt.Color(255, 255, 153));
        Sell_tb_custContact.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_InsidePanel.add(Sell_tb_custContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 488, 300, 45));

        Sell_btn_Confirm.setText("Confirm");
        Sell_btn_Confirm.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_btn_Confirm.setkBorderRadius(0);
        Sell_btn_Confirm.setkEndColor(new java.awt.Color(255, 51, 255));
        Sell_btn_Confirm.setkForeGround(new java.awt.Color(0, 0, 0));
        Sell_btn_Confirm.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Sell_btn_Confirm.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Sell_btn_Confirm.setkPressedColor(new java.awt.Color(153, 255, 153));
        Sell_btn_Confirm.setkStartColor(java.awt.Color.pink);
        Sell_btn_Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sell_btn_ConfirmActionPerformed(evt);
            }
        });
        Sell_InsidePanel.add(Sell_btn_Confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 720, -1, -1));

        Sell_cmb_PName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_cmb_PName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sell_cmb_PNameActionPerformed(evt);
            }
        });
        Sell_InsidePanel.add(Sell_cmb_PName, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 173, 300, 45));

        Sell_tb_PQuantity_Remaining.setEditable(false);
        Sell_tb_PQuantity_Remaining.setBackground(new java.awt.Color(204, 204, 204));
        Sell_tb_PQuantity_Remaining.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_InsidePanel.add(Sell_tb_PQuantity_Remaining, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 362, 300, 45));

        Sell_lbl_PQuantity_Remaining.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_lbl_PQuantity_Remaining.setForeground(new java.awt.Color(255, 255, 255));
        Sell_lbl_PQuantity_Remaining.setText("Quantity remaining : ");
        Sell_InsidePanel.add(Sell_lbl_PQuantity_Remaining, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 370, -1, -1));

        Sell_InsidePanel_2.setBackground(new java.awt.Color(79, 81, 90));
        Sell_InsidePanel_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Sell_IP_lbl_PID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sell_IP_lbl_PID.setForeground(new java.awt.Color(255, 255, 255));
        Sell_IP_lbl_PID.setText("Plant ID : ");
        Sell_InsidePanel_2.add(Sell_IP_lbl_PID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        Sell_IP_lbl_PName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sell_IP_lbl_PName.setForeground(new java.awt.Color(255, 255, 255));
        Sell_IP_lbl_PName.setText("Plant name : ");
        Sell_InsidePanel_2.add(Sell_IP_lbl_PName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        Sell_IP_lbl_QuantitytoSell.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sell_IP_lbl_QuantitytoSell.setForeground(new java.awt.Color(255, 255, 255));
        Sell_IP_lbl_QuantitytoSell.setText("Quantity to sell :");
        Sell_InsidePanel_2.add(Sell_IP_lbl_QuantitytoSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 100, -1, -1));

        Sell_IP_lbl_PricePerUnit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sell_IP_lbl_PricePerUnit.setForeground(new java.awt.Color(255, 255, 255));
        Sell_IP_lbl_PricePerUnit.setText("Price per unit : ");
        Sell_InsidePanel_2.add(Sell_IP_lbl_PricePerUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 140, -1, -1));

        Sell_IP_lbl_totalPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sell_IP_lbl_totalPrice.setForeground(new java.awt.Color(255, 255, 255));
        Sell_IP_lbl_totalPrice.setText("Total price : ");
        Sell_InsidePanel_2.add(Sell_IP_lbl_totalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 180, -1, -1));

        Sell_IP_lbl_dis_PID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sell_IP_lbl_dis_PID.setForeground(new java.awt.Color(255, 255, 255));
        Sell_InsidePanel_2.add(Sell_IP_lbl_dis_PID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 400, 25));

        Sell_IP_lbl_dis_PName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sell_IP_lbl_dis_PName.setForeground(new java.awt.Color(255, 255, 255));
        Sell_InsidePanel_2.add(Sell_IP_lbl_dis_PName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 400, 25));

        Sell_IP_lbl_dis_Quantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sell_IP_lbl_dis_Quantity.setForeground(new java.awt.Color(255, 255, 255));
        Sell_InsidePanel_2.add(Sell_IP_lbl_dis_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 400, 25));

        Sell_IP_lbl_dis_PricePerUnit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sell_IP_lbl_dis_PricePerUnit.setForeground(new java.awt.Color(255, 255, 255));
        Sell_InsidePanel_2.add(Sell_IP_lbl_dis_PricePerUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 400, 25));

        Sell_IP_lbl_dis_totalPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Sell_IP_lbl_dis_totalPrice.setForeground(new java.awt.Color(255, 255, 255));
        Sell_InsidePanel_2.add(Sell_IP_lbl_dis_totalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 400, 25));

        Sell_btn_checkPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_btn_checkPrice.setkBorderRadius(0);
        Sell_btn_checkPrice.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        Sell_btn_checkPrice.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Sell_btn_checkPrice.setkHoverStartColor(new java.awt.Color(153, 255, 255));
        Sell_btn_checkPrice.setkPressedColor(new java.awt.Color(255, 255, 0));
        Sell_btn_checkPrice.setLabel("Check Price");
        Sell_btn_checkPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sell_btn_checkPriceActionPerformed(evt);
            }
        });
        Sell_InsidePanel_2.add(Sell_btn_checkPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, -1, -1));

        Sell_InsidePanel.add(Sell_InsidePanel_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 570, 290));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Stock ID : ");
        Sell_InsidePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 180, -1, -1));

        Sell_tb_stockID.setEditable(false);
        Sell_tb_stockID.setBackground(new java.awt.Color(204, 204, 204));
        Sell_tb_stockID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Sell_InsidePanel.add(Sell_tb_stockID, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 173, 300, 45));

        Panel_Sell.add(Sell_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        PanelSell_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/phillip-larking-SKSu6QOJBjo-unsplash.png"))); // NOI18N
        Panel_Sell.add(PanelSell_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_Sell, "card5");

        Panel_Report.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Report_InsidePanel.setBackground(new java.awt.Color(153, 153, 153));
        Report_InsidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Report_btn_Stock.setText("Stock");
        Report_btn_Stock.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Report_btn_Stock.setkBorderRadius(0);
        Report_btn_Stock.setkEndColor(new java.awt.Color(153, 255, 255));
        Report_btn_Stock.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Report_btn_Stock.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Report_btn_Stock.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Report_btn_Stock.setkPressedColor(new java.awt.Color(153, 255, 255));
        Report_btn_Stock.setkStartColor(new java.awt.Color(255, 0, 0));
        Report_btn_Stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Report_btn_StockActionPerformed(evt);
            }
        });
        Report_InsidePanel.add(Report_btn_Stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(1315, 65, -1, -1));

        Report_btn_Sold.setText("Sold");
        Report_btn_Sold.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Report_btn_Sold.setkBorderRadius(0);
        Report_btn_Sold.setkEndColor(new java.awt.Color(153, 255, 255));
        Report_btn_Sold.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Report_btn_Sold.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Report_btn_Sold.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Report_btn_Sold.setkPressedColor(new java.awt.Color(153, 255, 255));
        Report_btn_Sold.setkStartColor(new java.awt.Color(255, 0, 0));
        Report_btn_Sold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Report_btn_SoldActionPerformed(evt);
            }
        });
        Report_InsidePanel.add(Report_btn_Sold, new org.netbeans.lib.awtextra.AbsoluteConstraints(1052, 65, -1, -1));

        Report_btn_Garden.setText("Garden");
        Report_btn_Garden.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Report_btn_Garden.setkBorderRadius(0);
        Report_btn_Garden.setkEndColor(new java.awt.Color(153, 255, 255));
        Report_btn_Garden.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Report_btn_Garden.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Report_btn_Garden.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Report_btn_Garden.setkPressedColor(new java.awt.Color(153, 255, 255));
        Report_btn_Garden.setkStartColor(new java.awt.Color(255, 0, 0));
        Report_btn_Garden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Report_btn_GardenActionPerformed(evt);
            }
        });
        Report_InsidePanel.add(Report_btn_Garden, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 65, -1, -1));

        Report_btn_Plants.setText("Plants");
        Report_btn_Plants.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Report_btn_Plants.setkBorderRadius(0);
        Report_btn_Plants.setkEndColor(new java.awt.Color(153, 255, 255));
        Report_btn_Plants.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Report_btn_Plants.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Report_btn_Plants.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Report_btn_Plants.setkPressedColor(new java.awt.Color(153, 255, 255));
        Report_btn_Plants.setkStartColor(new java.awt.Color(255, 0, 0));
        Report_btn_Plants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Report_btn_PlantsActionPerformed(evt);
            }
        });
        Report_InsidePanel.add(Report_btn_Plants, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, -1, -1));

        Report_btn_Notify.setText("Notify");
        Report_btn_Notify.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Report_btn_Notify.setkBorderRadius(0);
        Report_btn_Notify.setkEndColor(new java.awt.Color(153, 255, 255));
        Report_btn_Notify.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Report_btn_Notify.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Report_btn_Notify.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Report_btn_Notify.setkPressedColor(new java.awt.Color(153, 255, 255));
        Report_btn_Notify.setkStartColor(new java.awt.Color(255, 0, 0));
        Report_btn_Notify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Report_btn_NotifyActionPerformed(evt);
            }
        });
        Report_InsidePanel.add(Report_btn_Notify, new org.netbeans.lib.awtextra.AbsoluteConstraints(789, 65, -1, -1));

        Report_btn_Hybrid.setText("Hybrid");
        Report_btn_Hybrid.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Report_btn_Hybrid.setkBorderRadius(0);
        Report_btn_Hybrid.setkEndColor(new java.awt.Color(153, 255, 255));
        Report_btn_Hybrid.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Report_btn_Hybrid.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Report_btn_Hybrid.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Report_btn_Hybrid.setkPressedColor(new java.awt.Color(153, 255, 255));
        Report_btn_Hybrid.setkStartColor(new java.awt.Color(255, 0, 0));
        Report_btn_Hybrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Report_btn_HybridActionPerformed(evt);
            }
        });
        Report_InsidePanel.add(Report_btn_Hybrid, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 65, -1, -1));

        Report_InsidePanel_tablePanel.setBackground(new java.awt.Color(0, 0, 0));
        Report_InsidePanel_tablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Report_lbl_tblName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Report_lbl_tblName.setForeground(new java.awt.Color(255, 255, 255));
        Report_InsidePanel_tablePanel.add(Report_lbl_tblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 350, 45));

        Report_tbl_maintable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Report_ScrPane_mainTable.setViewportView(Report_tbl_maintable);

        Report_InsidePanel_tablePanel.add(Report_ScrPane_mainTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 600, 690));

        Report_InsidePanel_functionsPanel.setBackground(new java.awt.Color(0, 0, 0));
        Report_InsidePanel_functionsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Report_btn_mostSoldplantFrom.setText("Top 5 most sold plants");
        Report_btn_mostSoldplantFrom.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Report_btn_mostSoldplantFrom.setkBorderRadius(0);
        Report_btn_mostSoldplantFrom.setkEndColor(new java.awt.Color(153, 153, 153));
        Report_btn_mostSoldplantFrom.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Report_btn_mostSoldplantFrom.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Report_btn_mostSoldplantFrom.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Report_btn_mostSoldplantFrom.setkPressedColor(new java.awt.Color(153, 255, 255));
        Report_btn_mostSoldplantFrom.setkStartColor(new java.awt.Color(255, 0, 0));
        Report_btn_mostSoldplantFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Report_btn_mostSoldplantFromActionPerformed(evt);
            }
        });
        Report_InsidePanel_functionsPanel.add(Report_btn_mostSoldplantFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 300, -1));

        Report_btn_leastSoldplantFrom.setText("Top 5 least sold plants");
        Report_btn_leastSoldplantFrom.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Report_btn_leastSoldplantFrom.setkBorderRadius(0);
        Report_btn_leastSoldplantFrom.setkEndColor(new java.awt.Color(153, 153, 153));
        Report_btn_leastSoldplantFrom.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Report_btn_leastSoldplantFrom.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Report_btn_leastSoldplantFrom.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Report_btn_leastSoldplantFrom.setkPressedColor(new java.awt.Color(153, 255, 255));
        Report_btn_leastSoldplantFrom.setkStartColor(new java.awt.Color(255, 0, 0));
        Report_btn_leastSoldplantFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Report_btn_leastSoldplantFromActionPerformed(evt);
            }
        });
        Report_InsidePanel_functionsPanel.add(Report_btn_leastSoldplantFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 300, -1));

        Report_dtPicker_Soldfrom.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Report_InsidePanel_functionsPanel.add(Report_dtPicker_Soldfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 220, 40));

        Report_dtPicker_Soldto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Report_InsidePanel_functionsPanel.add(Report_dtPicker_Soldto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 220, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("From : ");
        Report_InsidePanel_functionsPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("To : ");
        Report_InsidePanel_functionsPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        Report_InsidePanel_tablePanel.add(Report_InsidePanel_functionsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, 340, 430));

        Report_insidePanel_Print.setBackground(new java.awt.Color(0, 0, 0));
        Report_insidePanel_Print.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Report_basePanel_btn_printTable.setText("Print table");
        Report_basePanel_btn_printTable.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Report_basePanel_btn_printTable.setkBorderRadius(0);
        Report_basePanel_btn_printTable.setkEndColor(new java.awt.Color(255, 51, 255));
        Report_basePanel_btn_printTable.setkForeGround(new java.awt.Color(0, 0, 0));
        Report_basePanel_btn_printTable.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        Report_basePanel_btn_printTable.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Report_basePanel_btn_printTable.setkPressedColor(new java.awt.Color(153, 255, 153));
        Report_basePanel_btn_printTable.setkStartColor(java.awt.Color.pink);
        Report_basePanel_btn_printTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Report_basePanel_btn_printTableActionPerformed(evt);
            }
        });
        Report_insidePanel_Print.add(Report_basePanel_btn_printTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        Report_InsidePanel_tablePanel.add(Report_insidePanel_Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 620, 300, 100));

        Report_InsidePanel.add(Report_InsidePanel_tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 128, 1540, 780));

        Panel_Report.add(Report_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        PanelReport_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/elyssa-fahndrich-6o_eitnR-3o-unsplash.png"))); // NOI18N
        Panel_Report.add(PanelReport_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_Report, "card17");

        Panel_Settings.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Settings_InsidePanel.setBackground(new java.awt.Color(153, 153, 153));
        Settings_InsidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Settings_InsidePanel_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Settings_btn_deleteAccount.setText("Delete account");
        Settings_btn_deleteAccount.setActionCommand("");
        Settings_btn_deleteAccount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_btn_deleteAccount.setkBorderRadius(0);
        Settings_btn_deleteAccount.setkEndColor(new java.awt.Color(153, 255, 255));
        Settings_btn_deleteAccount.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Settings_btn_deleteAccount.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Settings_btn_deleteAccount.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Settings_btn_deleteAccount.setkPressedColor(new java.awt.Color(153, 255, 255));
        Settings_btn_deleteAccount.setkStartColor(new java.awt.Color(255, 0, 0));
        Settings_btn_deleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Settings_btn_deleteAccountActionPerformed(evt);
            }
        });
        Settings_InsidePanel_2.add(Settings_btn_deleteAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 340, 205, -1));

        Settings_btn_updateAccountDetails.setText("Update account details");
        Settings_btn_updateAccountDetails.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_btn_updateAccountDetails.setkBorderRadius(0);
        Settings_btn_updateAccountDetails.setkEndColor(new java.awt.Color(153, 255, 255));
        Settings_btn_updateAccountDetails.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Settings_btn_updateAccountDetails.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Settings_btn_updateAccountDetails.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Settings_btn_updateAccountDetails.setkPressedColor(new java.awt.Color(153, 255, 255));
        Settings_btn_updateAccountDetails.setkStartColor(new java.awt.Color(255, 0, 0));
        Settings_btn_updateAccountDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Settings_btn_updateAccountDetailsActionPerformed(evt);
            }
        });
        Settings_InsidePanel_2.add(Settings_btn_updateAccountDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 340, 300, -1));

        Settings_btn_changePassword.setText("Change password");
        Settings_btn_changePassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_btn_changePassword.setkBorderRadius(0);
        Settings_btn_changePassword.setkEndColor(new java.awt.Color(153, 255, 255));
        Settings_btn_changePassword.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Settings_btn_changePassword.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Settings_btn_changePassword.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Settings_btn_changePassword.setkPressedColor(new java.awt.Color(153, 255, 255));
        Settings_btn_changePassword.setkStartColor(new java.awt.Color(255, 0, 0));
        Settings_btn_changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Settings_btn_changePasswordActionPerformed(evt);
            }
        });
        Settings_InsidePanel_2.add(Settings_btn_changePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 340, 230, -1));

        Settings_InsidePanel_3_updateDetails.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Settings_InsidePanel_3_updateDetails.setkBorderRadius(0);
        Settings_InsidePanel_3_updateDetails.setkEndColor(new java.awt.Color(0, 0, 0));
        Settings_InsidePanel_3_updateDetails.setkStartColor(new java.awt.Color(204, 204, 204));
        Settings_InsidePanel_3_updateDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Settings_lbl_email.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_lbl_email.setForeground(new java.awt.Color(255, 255, 255));
        Settings_lbl_email.setText("Enter existing/new email : ");
        Settings_InsidePanel_3_updateDetails.add(Settings_lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 290, -1));

        Settings_lbl_contact.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_lbl_contact.setForeground(new java.awt.Color(255, 255, 255));
        Settings_lbl_contact.setText("Enter existing/new contact : ");
        Settings_InsidePanel_3_updateDetails.add(Settings_lbl_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 310, -1));

        Settings_lbl_secAns.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_lbl_secAns.setForeground(new java.awt.Color(255, 255, 255));
        Settings_lbl_secAns.setText("Enter answer to the security question : ");
        Settings_InsidePanel_3_updateDetails.add(Settings_lbl_secAns, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 246, -1, -1));

        Settings_lbl_place.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Settings_lbl_place.setForeground(new java.awt.Color(255, 255, 255));
        Settings_lbl_place.setText("Which place would you like to go?");
        Settings_InsidePanel_3_updateDetails.add(Settings_lbl_place, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 282, 310, -1));

        Settings_tb_email.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_InsidePanel_3_updateDetails.add(Settings_tb_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 73, 350, 45));

        Settings_tb_contact.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_InsidePanel_3_updateDetails.add(Settings_tb_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 183, 350, 45));

        Settings_tb_secAns.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Settings_InsidePanel_3_updateDetails.add(Settings_tb_secAns, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 314, 350, 45));

        Settings_btn_updateDetails.setBorder(null);
        Settings_btn_updateDetails.setText("Update Details");
        Settings_btn_updateDetails.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_btn_updateDetails.setkBorderRadius(0);
        Settings_btn_updateDetails.setkEndColor(new java.awt.Color(153, 255, 255));
        Settings_btn_updateDetails.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Settings_btn_updateDetails.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Settings_btn_updateDetails.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Settings_btn_updateDetails.setkPressedColor(new java.awt.Color(153, 255, 255));
        Settings_btn_updateDetails.setkStartColor(new java.awt.Color(255, 0, 0));
        Settings_btn_updateDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Settings_btn_updateDetailsActionPerformed(evt);
            }
        });
        Settings_InsidePanel_3_updateDetails.add(Settings_btn_updateDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 372, -1, -1));

        Settings_InsidePanel_2.add(Settings_InsidePanel_3_updateDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 397, 450, 430));

        Settings_InsidePanel_3_enterPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Settings_InsidePanel_3_enterPassword.setkBorderRadius(0);
        Settings_InsidePanel_3_enterPassword.setkEndColor(new java.awt.Color(0, 0, 0));
        Settings_InsidePanel_3_enterPassword.setkStartColor(new java.awt.Color(204, 204, 204));
        Settings_InsidePanel_3_enterPassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Settings_lbl_currPass.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_lbl_currPass.setForeground(new java.awt.Color(255, 255, 255));
        Settings_lbl_currPass.setText("Enter current password : ");
        Settings_InsidePanel_3_enterPassword.add(Settings_lbl_currPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 45, 280, -1));

        Settings_passFld_currentPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Settings_InsidePanel_3_enterPassword.add(Settings_passFld_currentPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 87, 350, 45));

        Settings_btn_Proceed.setText("Proceed");
        Settings_btn_Proceed.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_btn_Proceed.setkBorderRadius(0);
        Settings_btn_Proceed.setkEndColor(new java.awt.Color(153, 255, 255));
        Settings_btn_Proceed.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Settings_btn_Proceed.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Settings_btn_Proceed.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Settings_btn_Proceed.setkPressedColor(new java.awt.Color(153, 255, 255));
        Settings_btn_Proceed.setkStartColor(new java.awt.Color(255, 0, 0));
        Settings_btn_Proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Settings_btn_ProceedActionPerformed(evt);
            }
        });
        Settings_InsidePanel_3_enterPassword.add(Settings_btn_Proceed, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 150, 185, -1));

        Settings_InsidePanel_2.add(Settings_InsidePanel_3_enterPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 450, 230));

        Settings_InsidePanel_3_updatePassword.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Settings_InsidePanel_3_updatePassword.setkBorderRadius(0);
        Settings_InsidePanel_3_updatePassword.setkEndColor(new java.awt.Color(0, 0, 0));
        Settings_InsidePanel_3_updatePassword.setkStartColor(new java.awt.Color(204, 204, 204));
        Settings_InsidePanel_3_updatePassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Settings_lbl_newPass.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_lbl_newPass.setForeground(new java.awt.Color(255, 255, 255));
        Settings_lbl_newPass.setText("Enter new password : ");
        Settings_InsidePanel_3_updatePassword.add(Settings_lbl_newPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 45, 245, -1));

        Settings_lbl_conPass.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_lbl_conPass.setForeground(new java.awt.Color(255, 255, 255));
        Settings_lbl_conPass.setText("Re-type new password : ");
        Settings_InsidePanel_3_updatePassword.add(Settings_lbl_conPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 144, 270, -1));

        Settings_passFld_newPassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_InsidePanel_3_updatePassword.add(Settings_passFld_newPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 81, 350, 45));

        Settings_passFld_conPassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_InsidePanel_3_updatePassword.add(Settings_passFld_conPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 186, 350, 45));

        Settings_btn_updatePassword.setText("Update password");
        Settings_btn_updatePassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Settings_btn_updatePassword.setkBorderRadius(0);
        Settings_btn_updatePassword.setkEndColor(new java.awt.Color(153, 255, 255));
        Settings_btn_updatePassword.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Settings_btn_updatePassword.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        Settings_btn_updatePassword.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Settings_btn_updatePassword.setkPressedColor(new java.awt.Color(153, 255, 255));
        Settings_btn_updatePassword.setkStartColor(new java.awt.Color(255, 0, 0));
        Settings_btn_updatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Settings_btn_updatePasswordActionPerformed(evt);
            }
        });
        Settings_InsidePanel_3_updatePassword.add(Settings_btn_updatePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 249, 213, -1));

        Settings_InsidePanel_2.add(Settings_InsidePanel_3_updatePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 420, 330));

        Settings_InsidePanel_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/annie-spratt-hS46bsAASwQ-unsplash.png"))); // NOI18N
        Settings_InsidePanel_2.add(Settings_InsidePanel_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 900));

        Settings_InsidePanel.add(Settings_InsidePanel_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1540, 900));

        Panel_Settings.add(Settings_InsidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1580, 910));

        PanelSetting_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/annie-spratt-hS46bsAASwQ-unsplash.png"))); // NOI18N
        PanelSetting_lbl_bg.setOpaque(true);
        Panel_Settings.add(PanelSetting_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 930));

        BasePanelRight.add(Panel_Settings, "card9");

        getContentPane().add(BasePanelRight, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleName("MainOperationsFrame");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RDto_NavigatePanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RDto_NavigatePanelActionPerformed
        makePanelVisible(Panel_Navigate);
        makeColorPanelVisible(Left_colorPanel_Navigate);
        try{
            Connection con;
            con = ConnectTo.getConnection();
            String tblName = "plants_data";
            String TEorNot = checkEmpty.isTableEmpty(tblName);      
            if(TEorNot.equals("Empty")){
                this.makePanelVisible(Panel_NavigateAdd);
                NavigateAdd_tb_PID.setText("P0001");
                NavigateAdd_tb_PABP.setText("NA");
                JOptionPane.showMessageDialog(null,"The database is empty.\nAdd a record to proceed further!");
                setPanelComponentsNull(Panel_NavigateAdd);
            }
            if(TEorNot.equals("notEmpty")){              
                for(int i=1 ;i<10000 ;i++){
                    int next_id = i + 1;
                    int NoOfDigits = Number.getCount(next_id) + 1;
                    String final_id;
                    try{
                        final_id = FinalID.getID("P", i, NoOfDigits);
                        try{
                            PreparedStatement st = (PreparedStatement) con.prepareStatement
                                ("select * from plants_data where PID=?;");
                            PreparedStatement st1 = (PreparedStatement) con.prepareStatement
                                ("select P_Quantity, P_Price from stock where PID=?;");
                            st.setString(1, final_id);
                            st1.setString(1, final_id);
                            ResultSet rs = st.executeQuery();
                            ResultSet rs1 = st1.executeQuery();
                            if(rs.next() && rs1.next()){
                                NavigateSet(rs, rs1);  
                                break;
                            }
                            st.close();
                            st1.close();
                            rs.close();
                            rs1.close();            
                        } 
                        catch (SQLException ex) {
                            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                        }        
                    }
                    catch (Exception ex) {
                        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            con.close();     
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
        }    
    }//GEN-LAST:event_btn_RDto_NavigatePanelActionPerformed

    private void btn_RDto_GardenPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RDto_GardenPanelActionPerformed
        this.makePanelVisible(Panel_Garden);
        this.makeColorPanelVisible(Left_colorPanel_Garden);
        try{
            Connection con;
            con = ConnectTo.getConnection();
            String tblName = "Garden";
            String EorNot = checkEmpty.isTableEmpty(tblName);            
            if(EorNot.equals("Empty")){
                this.makePanelVisible(Panel_GardenAdd);
                GardenAdd_tb_GID.setText("G001");
                JOptionPane.showMessageDialog(null,"The database is empty.\nAdd a record to proceed further!");
                setPanelComponentsNull(Panel_GardenAdd);
            }
            if(EorNot.equals("notEmpty")){
                for(int i=1; i<1000; i++){
                    int next_id = i + 1;
                    int NoOfDigits = Number.getCount(next_id) + 1;
                    String final_id;
                    try{
                        final_id = FinalID.getID("G", i, NoOfDigits);
                        try{
                            PreparedStatement st = (PreparedStatement) con.prepareStatement
                                ("select * from garden where GID=?;");
                            st.setString(1, final_id);
                            ResultSet rs = st.executeQuery();
                            if(rs.next()){
                                GardenSet(rs);                               
                                break;
                            }
                            st.close();
                            rs.close();            
                        } 
                        catch (SQLException ex) {
                            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                        }        
                    }
                    catch (Exception ex) {
                        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            con.close();     
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
        }
    }//GEN-LAST:event_btn_RDto_GardenPanelActionPerformed

    private void btn_RDto_HybridPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RDto_HybridPanelActionPerformed
        this.makePanelVisible(Panel_Hybrid);
        this.makeColorPanelVisible(Left_colorPanel_Hybrid);       
        try{
            Connection con;
            con = ConnectTo.getConnection();
            String tblName = "Hybrid";
            String TEorNot = checkEmpty.isTableEmpty(tblName);          
            if(TEorNot.equals("Empty")){
                this.makePanelVisible(Panel_HybridAdd);
                HybridAdd_tb_HID.setText("H001");
                JOptionPane.showMessageDialog(null,"The database is empty.\nAdd a record to proceed further!");
                setPanelComponentsNull(Panel_HybridAdd);
                String tblName1 = "plants_data";
                String colName1 = "P_Name";
                cmbBox.addtocmbBox(tblName1, colName1, HybridAdd_cmb_HSpecies1);
                cmbBox.addtocmbBox(tblName1, colName1, HybridAdd_cmb_HSpecies2);
                cmbBox.addtocmbBox(tblName1, colName1, HybridAdd_cmb_HSpecies3);
                cmbBox.addtocmbBox(tblName1, colName1, HybridAdd_cmb_HSpecies4);
                cmbBox.addtocmbBox(tblName1, colName1, HybridAdd_cmb_HSpecies5);               
            }
            if(TEorNot.equals("notEmpty")){
                for(int i=1; i<1000; i++){
                    int next_id = i + 1;
                    int NoOfDigits = Number.getCount(next_id) + 1;
                    String final_id;
                    try{
                        final_id = FinalID.getID("H", i, NoOfDigits);
                        try{
                            PreparedStatement st = (PreparedStatement) con.prepareStatement
                                ("select * from hybrid where HID=?;");
                            st.setString(1, final_id);
                            ResultSet rs = st.executeQuery();
                            if(rs.next()){
                                HybridSet(rs);                                 
                                break;
                            }
                            st.close();
                            rs.close();            
                        } 
                        catch (SQLException ex) {
                            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                        }        
                    }
                    catch (Exception ex) {
                        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            con.close();     
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
        }
    }//GEN-LAST:event_btn_RDto_HybridPanelActionPerformed

    private void btn_RDto_NotifyPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RDto_NotifyPanelActionPerformed
        setPanelComponentsNull(Panel_Notify);
        String tblName = "plants_data";
        String colName = "PID";
        try{
            String TEorNot = checkEmpty.isTableEmpty("plants_data");
            if(TEorNot.equals("Empty")){
                JOptionPane.showMessageDialog(null, "There are no records of plants.\nYou can add record(s) in the Navigate tab.");
            }
            if(TEorNot.equals("notEmpty")){
                String TEorNot1 = checkEmpty.isTableEmpty("notify");
                if(TEorNot1.equals("Empty")){
                    this.makePanelVisible(Panel_Notify);
                    this.makeColorPanelVisible(Left_colorPanel_Notify);
                    Notify_tb_NID.setText("N001");
                    cmbBox.addtocmbBox(tblName, colName, Notify_cmb_PID);
                }
                if(TEorNot1.equals("notEmpty")){
                    this.makePanelVisible(Panel_Notify);
                    this.makeColorPanelVisible(Left_colorPanel_Notify);
                    cmbBox.addtocmbBox(tblName, colName, Notify_cmb_PID);        
                    String ID = btnFunction.AddNew(Panel_Notify, Panel_Notify, "notify", "NID", 999, 4, "N");
                    Notify_tb_NID.setText(ID);                   
                }
            }
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_btn_RDto_NotifyPanelActionPerformed

    private void btn_RDto_SellPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RDto_SellPanelActionPerformed
        setPanelComponentsNull(Panel_Sell);
        String tblName = "plants_data";
        String colName = "P_Name";
        try{
            String TEorNot = checkEmpty.isTableEmpty("plants_data");
            if(TEorNot.equals("Empty")){
                JOptionPane.showMessageDialog(null, "There are no records of plants.\nYou can add record(s) in the Navigate tab.");
            }
            if(TEorNot.equals("notEmpty")){
                String TEorNot1 = checkEmpty.isTableEmpty("sold");
                if(TEorNot1.equals("Empty")){
                    this.makePanelVisible(Panel_Sell);
                    this.makeColorPanelVisible(Left_colorPanel_Sell);
                    Sell_tb_SID.setText("S0001");
                    cmbBox.addtocmbBox(tblName, colName, Sell_cmb_PName);        
                    Date date = Date.valueOf(LocalDate.now());
                    Sell_tb_issueDate.setText(date.toString());
                }
                if(TEorNot1.equals("notEmpty")){
                    this.makePanelVisible(Panel_Sell);
                    this.makeColorPanelVisible(Left_colorPanel_Sell);
                    cmbBox.addtocmbBox(tblName, colName, Sell_cmb_PName);        
                    Date date = Date.valueOf(LocalDate.now());
                    Sell_tb_issueDate.setText(date.toString());
                    String ID = btnFunction.AddNew(Panel_Sell, Panel_Sell, "Sold", "Plant_Issue_ID", 9999, 5, "S");
                    Sell_tb_SID.setText(ID);                   
                }
            }
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_RDto_SellPanelActionPerformed

    private void NavigateAdd_btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavigateAdd_btn_AddActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();        
            int result = JOptionPane.showConfirmDialog(null, "Do you want to add this record to the database?", "Confirm", WIDTH);
            if(JOptionPane.YES_OPTION==result){
                String txtPID = NavigateAdd_tb_PID.getText();
                String txtPName = NavigateAdd_tb_PName.getText();
                String txtPSciName = NavigateAdd_tb_PSciName.getText();
                String txtQuantity = NavigateAdd_tb_PQuantity.getText();
                String txtPPrice = NavigateAdd_tb_PPrice.getText();
                String txtPABP = NavigateAdd_tb_PABP.getText();
                String txtPTag1 = NavigateAdd_tb_PTag1.getText();
                String txtPTag2 = NavigateAdd_tb_PTag2.getText();
                String txtPTag3 = NavigateAdd_tb_PTag3.getText();
                String txtPTag4 = NavigateAdd_tb_PTag4.getText();
                String txtPTag5 = NavigateAdd_tb_PTag5.getText();
                String txtPNote = NavigateAdd_ta_PNote.getText().trim();
                String ExpChoice = null;
                
                String abc = txtPID.substring(1,5);
                int txtPID_no = Integer.parseInt(abc);
                int txtPID_digits = Number.getCount(txtPID_no);
                String stockID;
                if(txtPName.isEmpty()==false && txtPSciName.isEmpty()==false){
                    try{
                        if(verify.verifyAlphabets(txtPName) && verify.verifyAlphabets(txtPSciName)){
                            PreparedStatement ps = (PreparedStatement) con.prepareStatement
                               ("select P_Name from plants_data where P_Name=?;");
                            ps.setString(1, txtPName);
                            ResultSet rs = ps.executeQuery();
                            if(!rs.next()){
                                PreparedStatement ps1 = (PreparedStatement) con.prepareStatement
                                    ("select P_SciName from plants_data where P_SciName=?;");
                                ps1.setString(1, txtPSciName);
                                ResultSet rs1 = ps1.executeQuery();
                                if(!rs1.next()){
                                    if(txtQuantity.isEmpty()==false){
                                        if(Number.isNumber(txtQuantity) && Integer.parseInt(txtQuantity)>=0 && Integer.parseInt(txtQuantity)<=65535){
                                            if(txtPPrice.isEmpty()==false){
                                                if(Number.isNumber(txtPPrice) && (Integer.parseInt(txtPPrice)>=0) && (Integer.parseInt(txtPPrice)<=65535)){
                                                    if(NavigateAdd_rdbtn_ExpYes.isSelected()){
                                                        ExpChoice = "Yes";
                                                    }
                                                    if(NavigateAdd_rdbtn_ExpNo.isSelected()){
                                                        ExpChoice = "No";
                                                    }	
                                                    try{
                                                        PreparedStatement st = (PreparedStatement) con.prepareStatement
                                                          ("insert into plants_data values(?,?,?,?,?,?,?,?,?,?,?)");    
                                                        st.setString(1, txtPID);
                                                        st.setString(2, txtPName);
                                                        st.setString(3, txtPSciName);
                                                        st.setString(4, txtPABP);
                                                        st.setString(5, txtPTag1);
                                                        st.setString(6, txtPTag2);
                                                        st.setString(7, txtPTag3);
                                                        st.setString(8, txtPTag4);
                                                        st.setString(9, txtPTag5);
                                                        st.setString(10, ExpChoice);
                                                        st.setString(11, txtPNote);
                                                        try{
                                                            stockID = FinalID.getID("ST", txtPID_no, txtPID_digits);
                                                            PreparedStatement st1 = (PreparedStatement) con.prepareStatement
                                                                ("insert into stock values(?,?,?,?);");
                                                            st1.setString(1, stockID);
                                                            st1.setString(2, txtPID);
                                                            st1.setString(3, txtQuantity);
                                                            st1.setString(4, txtPPrice);
                                                            int n = st.executeUpdate();
                                                            int n1 = st1.executeUpdate();
                                                            if(n==1 && n1==1){
                                                                Panel_NavigateAdd.setVisible(false);
                                                                Panel_Navigate.setVisible(true);
                                                                JOptionPane.showMessageDialog(null, "Record added.");
                                                                JOptionPane.showMessageDialog(null, "Press the Previous or the Next button to refresh the records.");
                                                                setPanelComponentsNull(Panel_NavigateAdd);
                                                            }             
                                                            st.close();
                                                            st1.close();
                                                        }
                                                        catch(Exception e){
                                                            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                                                        } 
                                                    }
                                                    catch(SQLException e){
                                                        JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                                                    } 
                                                    catch (HeadlessException ex) {
                                                        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                                                    } 
                                                }
                                                else{
                                                    JOptionPane.showMessageDialog(null,"1) The price must be a number.\n"
                                                        + "2) It must be greater than or equal to 0.\n"
                                                        + "3) It must be less than or equal to 65535.");
                                                }          
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null,"Please enter the selling price of the plant.");
                                            }
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null,"1) The quantity must be a number.\n"
                                                    + "2) It must be greater than or equal to 0.\n"
                                                    + "3) It must be less than or equal to 65535.");
                                        }            
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"Please enter a quantity for the plant. If none, proceed with 0.");
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Enter another scientific name for the plant.\n"
                                        + "This scientific name already exists.");
                                }
                                ps1.close();
                                rs1.close();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Enter another name for the plant.\n"
                                    + "This name already exists.");
                            }
                            ps.close();
                            rs.close();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "The name and the scientifc name\nof the plantshould contain only alphabets");
                        }
                    }
                    catch(HeadlessException | SQLException e){
                        JOptionPane.showMessageDialog(null, e);
                    }  
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter the common name and the scientific name of the plant.");
                }
            }
            con.close();
        }
        catch(HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_NavigateAdd_btn_AddActionPerformed

    private void NavigateAdd_cmb_PABPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavigateAdd_cmb_PABPActionPerformed
        NavigateAdd_tb_PABP.setText((String) NavigateAdd_cmb_PABP.getSelectedItem());
    }//GEN-LAST:event_NavigateAdd_cmb_PABPActionPerformed

    private void btn_RDto_SettingsPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RDto_SettingsPanelActionPerformed
        makePanelVisible(Panel_Settings);
        makeColorPanelVisible(Left_colorPanel_Settings);
        Settings_btn_changePassword.setVisible(false);
        Settings_btn_updateAccountDetails.setVisible(false);
        Settings_btn_deleteAccount.setVisible(false);       
        makeSettingsPanelVisible(Settings_InsidePanel_3_enterPassword);
    }//GEN-LAST:event_btn_RDto_SettingsPanelActionPerformed

    private void Navigate_btn_AddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Navigate_btn_AddNewActionPerformed
        try{
            setPanelComponentsNull(Panel_NavigateAdd);
            String ID = btnFunction.AddNew(Panel_Navigate, Panel_NavigateAdd, "plants_data", "PID",
                9999, 5, "P");
            NavigateAdd_tb_PABP.setText("NA");
            NavigateAdd_tb_PID.setText(ID);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Navigate_btn_AddNewActionPerformed

    private void Navigate_btn_ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Navigate_btn_ModifyActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            try{
                String tblName = "plants_data";
                String EorNot = checkEmpty.isTableEmpty(tblName);
                if(EorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed.");
                    Panel_Navigate.setVisible(false);
                    Panel_NavigateAdd.setVisible(true);
                }
                if(EorNot.equals("notEmpty")){
                    String recEorNot = checkEmpty.isRecordExist(tblName, "PID", Navigate_tb_PID.getText());
                    if(recEorNot.equals("Exists")){
                        Panel_NavigateModify.setVisible(true);
                        Panel_Navigate.setVisible(false);
                        NavigateModify_tb_PSciName.setEditable(false);
                        NavigateModify_tb_PName.setEditable(false);
                        PreparedStatement ps = (PreparedStatement) con.prepareStatement
                            ("select * from plants_data where PID=?;");
                        PreparedStatement ps1 = (PreparedStatement) con.prepareStatement
                            ("select * from stock where PID=?;");
                        ps.setString(1,Navigate_tb_PID.getText());
                        ps1.setString(1,Navigate_tb_PID.getText());
                        ResultSet rs = ps.executeQuery();
                        ResultSet rs1 = ps1.executeQuery();
                        if(rs.next() && rs1.next()){                     
                            String ExpChoice = rs.getString("P_experimented");
                            if(ExpChoice.equals("Yes")){
                                NavigateModify_rdbtn_ExpYes.setSelected(true); 
                            }
                            if(ExpChoice.equals("No")){
                                NavigateModify_rdbtn_ExpNo.setSelected(true);
                            }
                            String P_name = rs.getString("P_name");
                            String P_sciname = rs.getString("P_sciname");
                            String P_Quantity = rs1.getString("P_Quantity");
                            String P_Price = rs1.getString("P_Price");
                            String P_ABPna = rs.getString("P_ABPNa");
                            String Ptag1 = rs.getString("Ptag1");
                            String Ptag2 = rs.getString("Ptag2");
                            String Ptag3 = rs.getString("Ptag3");
                            String Ptag4 = rs.getString("Ptag4");
                            String Ptag5 = rs.getString("Ptag5");
                            String P_note = rs.getString("P_note");                            
                            NavigateModify_tb_PID.setText(Navigate_tb_PID.getText());
                            NavigateModify_tb_PName.setText(P_name);
                            NavigateModify_tb_PSciName.setText(P_sciname);
                            NavigateModify_tb_PQuantity.setText(P_Quantity);
                            NavigateModify_tb_PPrice.setText(P_Price);
                            NavigateModify_tb_PABP.setText(P_ABPna);
                            NavigateModify_tb_PTag1.setText(Ptag1);
                            NavigateModify_tb_PTag2.setText(Ptag2);
                            NavigateModify_tb_PTag3.setText(Ptag3);
                            NavigateModify_tb_PTag4.setText(Ptag4);
                            NavigateModify_tb_PTag5.setText(Ptag5);
                            NavigateModify_ta_PNote.setText(P_note);
                        }
                        ps.close();
                        rs.close();
                        ps1.close();
                        rs1.close();
                    }
                    if(recEorNot.equals("notExists")){
                        JOptionPane.showMessageDialog(null, "This record has already been altered / deleted."
                            + "\n\nNote :\nAlways remember to refresh the screen "
                            + "\nafter adding/ updating/ deleting record(s).");
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
    }//GEN-LAST:event_Navigate_btn_ModifyActionPerformed

    private void Navigate_btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Navigate_btn_LastActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            try{
                String tblName = "plants_data";
                String EorNot = checkEmpty.isTableEmpty(tblName);
                if(EorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed further.");
                    setPanelComponentsNull(Panel_Navigate);     
                    Navigate_lbl_Count.setText("Empty");
                }
                if(EorNot.equals("notEmpty")){
                    try{
                        PreparedStatement st = (PreparedStatement) con.prepareStatement
                            ("select * from plants_data ORDER BY pid DESC LIMIT 1;");
                        ResultSet rs = st.executeQuery();
                        if(rs.next()){
                            String PID = rs.getString("PID");
                            try{
                                PreparedStatement st1 = (PreparedStatement) con.prepareStatement
                                    ("select P_Quantity, P_Price from stock where PID = ?;");
                                st1.setString(1, PID);
                                ResultSet rs1 = st1.executeQuery();
                                if(rs1.next()){
                                    NavigateSet(rs, rs1);                                   
                                    String a = Number.noOfRecord(tblName, "PID", PID);
                                    String n = Number.totalRecords(tblName);
                                    Navigate_lbl_Count.setText(a +" of "+ n);
                                }
                                rs1.close();
                                st1.close();
                            }
                            catch(SQLException e){
                                JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                            }
                        }
                        st.close();
                        rs.close();
                    }
                    catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
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
    }//GEN-LAST:event_Navigate_btn_LastActionPerformed

    private void Navigate_btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Navigate_btn_NextActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            try{
                String tblName = "plants_data";
                String EorNot = checkEmpty.isTableEmpty(tblName);
                if(EorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed further.");       
                    setPanelComponentsNull(Panel_Navigate);
                    Navigate_lbl_Count.setText("Empty");
                }
                if(EorNot.equals("notEmpty")){
                    if(Navigate_tb_PID.getText().isEmpty()){
                        try{
                            PreparedStatement st = (PreparedStatement) con.prepareStatement
                                ("select * from plants_data ORDER BY pid DESC LIMIT 1;");
                            ResultSet rs = st.executeQuery();
                            if(rs.next()){
                                String PID = rs.getString("PID");
                                try{
                                    PreparedStatement st1 = (PreparedStatement) con.prepareStatement
                                        ("select P_Quantity, P_Price from stock where PID = ?;");
                                    st1.setString(1, PID);
                                    ResultSet rs1 = st1.executeQuery();
                                    if(rs1.next()){                                                                                
                                        NavigateSet(rs, rs1);            
                                    }
                                    st1.close();
                                    rs1.close();
                                }
                                catch(SQLException e){
                                    JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                                }
                            }
                            st.close();
                            rs.close();
                        }
                        catch(SQLException e){
                            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                        }
                    }
                    else{
                        try{
                            String ID_now_str = Navigate_tb_PID.getText().substring(1,5);
                            int ID_now_int = Integer.parseInt(ID_now_str);
                            try{
                                PreparedStatement st = (PreparedStatement) con.prepareStatement
                                    ("select pid from plants_data ORDER BY pid DESC LIMIT 1;");
                                ResultSet rs = st.executeQuery();
                                if(rs.next()){
                                    String ID_str = rs.getString(1).substring(1, 5);    
                                    int id_int = Integer.parseInt(ID_str);
                                    for(int i = ID_now_int ; i < id_int ; i++){
                                        int next_id = i + 1;
                                        int NoOfDigits = Number.getCount(next_id) + 1;
                                        String final_id;
                                        try{
                                            final_id = FinalID.getID("P", next_id, NoOfDigits);
                                            try{                       
                                                PreparedStatement st1 =  (PreparedStatement)
                                                    con.prepareStatement("select * from plants_data where pid=?;");
                                                st1.setString(1, final_id);
                                                ResultSet rs1 = st1.executeQuery();
                                                if(rs1.next()){
                                                    String PID = rs1.getString("PID");
                                                    try{
                                                        PreparedStatement st2 =  (PreparedStatement)
                                                            con.prepareStatement("select P_Quantity, P_Price from stock where pid=?;");
                                                        st2.setString(1, PID);
                                                        ResultSet rs2 = st2.executeQuery();
                                                        if(rs2.next()){
                                                            NavigateSet(rs1, rs2);
                                                            String a = Number.noOfRecord(tblName, "PID", PID);
                                                            String n = Number.totalRecords(tblName);
                                                            Navigate_lbl_Count.setText(a +" of "+ n);
                                                            break;
                                                        }
                                                        rs2.close();
                                                        st2.close();
                                                    }
                                                    catch(SQLException e){
                                                        JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                                                    }
                                                }
                                                rs1.close();
                                                st1.close();
                                            }
                                            catch(HeadlessException | SQLException e){
                                                JOptionPane.showMessageDialog(null, e);
                                            }
                                        } 
                                        catch (Exception ex) {
                                            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }    
                                }    
                                rs.close();
                                st.close();
                            }
                            catch(HeadlessException | SQLException e){
                                JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
                            }
                        }
                        catch(HeadlessException e){
                            JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
                        }
                    }    
                }
            }
            catch(HeadlessException | ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
            }
            con.close();
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
        }
    }//GEN-LAST:event_Navigate_btn_NextActionPerformed

    private void Navigate_btn_PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Navigate_btn_PreviousActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            String tblName = "plants_data";
            String EorNot = checkEmpty.isTableEmpty(tblName);
            if(EorNot.equals("Empty")){
                JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed further.");
                setPanelComponentsNull(Panel_Navigate);
                Navigate_lbl_Count.setText("Empty");
            }
            if(EorNot.equals("notEmpty")){
                if(Navigate_tb_PID.getText().isEmpty()){
                    for(int i=1 ;i<10000 ;i++){
                        int next_id = i + 1;
                        if(next_id>9999){
                            next_id=9999;
                        }
                        int NoOfDigits = Number.getCount(next_id) + 1;
                        String final_id;
                        try {
                            final_id = FinalID.getID("P", i, NoOfDigits);               
                            try{  
                                PreparedStatement st = (PreparedStatement) con.prepareStatement
                                    ("select * from plants_data where PID=?;");
                                st.setString(1, final_id);
                                ResultSet rs = st.executeQuery();
                                if(rs.next()){
                                    String PID = rs.getString("PID");
                                    try{
                                        PreparedStatement st1 = (PreparedStatement) con.prepareStatement
                                            ("select P_Quantity, P_Price from stock where PID=?;");
                                        st1.setString(1, PID);
                                        ResultSet rs1 = st1.executeQuery();
                                        if(rs1.next()){
                                            NavigateSet(rs, rs1); 
                                            break;
                                        }
                                        st1.close();
                                        rs1.close();
                                    }
                                    catch(SQLException e){
                                        JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                                    }   
                                }
                                st.close();
                                rs.close();           
                            }
                            catch(SQLException e){
                                JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
                            }               
                        } 
                        catch (Exception ex) {
                            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    }
                }
                else{
                    String ID_now_str = Navigate_tb_PID.getText().substring(1,5);
                    int ID_now_int = Integer.parseInt(ID_now_str);
                    for(int i = ID_now_int; i > 0 ; i--){                    
                        int ID_then_num = ID_now_int - 1;        
                        try{
                            int prev_id = i - 1;
                            int NoOfDigits = Number.getCount(prev_id) + 1;
                            String final_id;
                            try{
                                final_id = FinalID.getID("P", prev_id, NoOfDigits);                                              
                                PreparedStatement st =  (PreparedStatement)
                                    con.prepareStatement("select * from plants_data where pid=?;");
                                st.setString(1, final_id);
                                ResultSet rs = st.executeQuery();
                                if(rs.next()){
                                    String PID = rs.getString("PID");
                                    try{
                                        PreparedStatement st1 =  (PreparedStatement)
                                            con.prepareStatement("select P_Quantity,P_Price from stock where pid=?;");
                                        st1.setString(1, PID);
                                        ResultSet rs1 = st1.executeQuery();
                                        if(rs1.next()){
                                            NavigateSet(rs, rs1);   
                                            String a = Number.noOfRecord(tblName, "PID", final_id);
                                            String n = Number.totalRecords(tblName);
                                            Navigate_lbl_Count.setText(a +" of "+ n);
                                            break;           
                                        }
                                        st1.close();
                                        rs1.close();
                                    }
                                    catch(SQLException e){
                                        JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                                    }
                                }
                                rs.close();
                                st.close();
                            }   
                            catch (Exception ex) {
                                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                            }    
                        }
                        catch(HeadlessException e){
                            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                        }
                    }
                }     
            }
            con.close();
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
        }
    }//GEN-LAST:event_Navigate_btn_PreviousActionPerformed

    private void Navigate_btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Navigate_btn_FirstActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            try{
                String tblName = "plants_data";
                String EorNot = checkEmpty.isTableEmpty(tblName);
                if(EorNot.equals("notEmpty")){
                    for(int i=1 ;i<9998 ;i++){
                        int next_id = i + 1;
                        int NoOfDigits = Number.getCount(next_id) + 1;
                        String final_id;
                        try {
                            final_id = FinalID.getID("P", i, NoOfDigits);               
                            try{  
                                PreparedStatement st = (PreparedStatement) con.prepareStatement
                                    ("select * from plants_data where PID=?;");
                                st.setString(1, final_id);
                                ResultSet rs = st.executeQuery();
                                if(rs.next()){
                                    String PID = rs.getString("PID");
                                    try{
                                        PreparedStatement st1 = (PreparedStatement) con.prepareStatement
                                            ("select P_Quantity, P_Price from stock where PID=?;");
                                        st1.setString(1, PID);
                                        ResultSet rs1 = st1.executeQuery();
                                        if(rs1.next()){
                                            NavigateSet(rs, rs1);                                           
                                            String a = Number.noOfRecord(tblName, "PID", final_id);
                                            String n = Number.totalRecords(tblName);
                                            Navigate_lbl_Count.setText(a +" of "+ n);
                                            break;
                                        }
                                        st1.close();
                                        rs1.close();
                                    }
                                    catch(SQLException e){
                                        JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                                    }   
                                }
                                st.close();
                                rs.close();           
                            }
                            catch(SQLException e){
                                JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
                            }               
                        } 
                        catch (Exception ex) {
                            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    }
                }
                if(EorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed further.");
                    setPanelComponentsNull(Panel_Navigate);
                    Navigate_lbl_Count.setText("Empty");
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
    }//GEN-LAST:event_Navigate_btn_FirstActionPerformed

    private void Settings_btn_changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Settings_btn_changePasswordActionPerformed
        makeSettingsPanelVisible(Settings_InsidePanel_3_updatePassword);
        setPanelComponentsNull(Panel_Settings);
    }//GEN-LAST:event_Settings_btn_changePasswordActionPerformed

    private void Settings_btn_updateAccountDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Settings_btn_updateAccountDetailsActionPerformed
        makeSettingsPanelVisible(Settings_InsidePanel_3_updateDetails);
        setPanelComponentsNull(Panel_Settings);
    }//GEN-LAST:event_Settings_btn_updateAccountDetailsActionPerformed

    private void Settings_btn_deleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Settings_btn_deleteAccountActionPerformed
        setPanelComponentsNull(Panel_Settings);
        int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete your account?");
        if(JOptionPane.YES_OPTION == result){
            int result1 = JOptionPane.showConfirmDialog(null,"You would be required to create\na new account to manage the records,\nif you decide to delete this one..\n\nSure to proceed?");
            if(JOptionPane.YES_OPTION == result1){
                try{
                    Connection con;
                    con = ConnectTo.getConnection();
                    String user = top_lbl_username.getText();
                    PreparedStatement ps = (PreparedStatement) con.prepareStatement
                        ("delete from login where username=?;");
                    ps.setString(1, user);
                    int n = ps.executeUpdate();
                    if(n==1){
                        JOptionPane.showMessageDialog(null, "Account deleted");
                        this.dispose();
                        LoginPanel l = new LoginPanel();
                        l.setVisible(true);
                    }
                    ps.close();
                    con.close();
                }
                catch(ClassNotFoundException | SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_Settings_btn_deleteAccountActionPerformed

    private void Settings_btn_ProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Settings_btn_ProceedActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            String user = top_lbl_username.getText();
            String pass = Arrays.toString(Settings_passFld_currentPassword.getPassword());
            if(!pass.isEmpty()){
                PreparedStatement ps = (PreparedStatement) con.prepareStatement
                    ("select password from login where username=?;");
                ps.setString(1, user);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    String password = rs.getString("password");
                    if(password.equals(pass)){
                        Settings_InsidePanel_3_enterPassword.setVisible(false);
                        Settings_btn_changePassword.setVisible(true);
                        Settings_btn_updateAccountDetails.setVisible(true);
                        Settings_btn_deleteAccount.setVisible(true);
                        Settings_passFld_currentPassword.setText(null);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Wrong Password!");
                        Settings_passFld_currentPassword.setText(null);
                    }
                }
                ps.close();
                rs.close();
            }
            else{
                JOptionPane.showMessageDialog(null, "No password has been input.");
            }  
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Settings_btn_ProceedActionPerformed

    private void NavigateModify_cmb_PABPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavigateModify_cmb_PABPActionPerformed
        NavigateModify_tb_PABP.setText((String) NavigateModify_cmb_PABP.getSelectedItem());
    }//GEN-LAST:event_NavigateModify_cmb_PABPActionPerformed

    private void NavigateModify_btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavigateModify_btn_UpdateActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            String txtPID = NavigateModify_tb_PID.getText();
            String txtPName = NavigateModify_tb_PName.getText();
            String txtPSciName = NavigateModify_tb_PSciName.getText();
            String txtQuantity = NavigateModify_tb_PQuantity.getText();
            String txtPPrice = NavigateModify_tb_PPrice.getText();
            String txtPABP = NavigateModify_tb_PABP.getText();
            String txtPTag1 = NavigateModify_tb_PTag1.getText();
            String txtPTag2 = NavigateModify_tb_PTag2.getText();
            String txtPTag3 = NavigateModify_tb_PTag3.getText();
            String txtPTag4 = NavigateModify_tb_PTag4.getText();
            String txtPTag5 = NavigateModify_tb_PTag5.getText();
            String txtPNote = NavigateModify_ta_PNote.getText().trim();	
            String ExpChoice = null;
            if(txtPName.isEmpty()==false && txtPSciName.isEmpty()==false){
                if(verify.verifyAlphabets(txtPName) || verify.verifyAlphabets(txtPSciName)){
                    if(txtQuantity.isEmpty()==false){
                        if(Number.isNumber(txtQuantity) && Integer.parseInt(txtQuantity)>=0 && Integer.parseInt(txtQuantity)<=65535){
                            if(txtPPrice.isEmpty()==false){
                                if(Number.isNumber(txtPPrice) && Integer.parseInt(txtPPrice)>=0 && Integer.parseInt(txtPPrice)<=65535){
                                    if(NavigateModify_rdbtn_ExpNo.isSelected()){
                                        ExpChoice = "No";  
                                    }
                                    if(NavigateModify_rdbtn_ExpYes.isSelected()){
                                        ExpChoice = "Yes";  
                                    }
                                    try{
                                        PreparedStatement st = (PreparedStatement) con.prepareStatement
                                            ("update plants_data set P_name=?, P_sciname=?, P_ABPna=?, Ptag1=?, "
                                            + "Ptag2=?, Ptag3=?, Ptag4=?, Ptag5=?, P_experimented=?, P_note=? where pid=?;");
                                        PreparedStatement st1 = (PreparedStatement) con.prepareStatement
                                            ("update stock set P_Quantity=?, P_Price=? where pid=?;");
                                        st.setString(1, txtPName);
                                        st.setString(2, txtPSciName);
                                        st.setString(3, txtPABP);
                                        st.setString(4, txtPTag1);
                                        st.setString(5, txtPTag2);
                                        st.setString(6, txtPTag3);
                                        st.setString(7, txtPTag4);
                                        st.setString(8, txtPTag5);
                                        st.setString(9, ExpChoice);
                                        st.setString(10, txtPNote);
                                        st.setString(11, txtPID);
                                        st1.setString(1, txtQuantity);
                                        st1.setString(2, txtPPrice);
                                        st1.setString(3, txtPID);
                                        int n = st.executeUpdate();
                                        int n1 = st1.executeUpdate();
                                        if(n>0 && n1>0){
                                            JOptionPane.showMessageDialog(null, "Record updated");
                                            Panel_NavigateModify.setVisible(false);
                                            Panel_Navigate.setVisible(true);
                                            JOptionPane.showMessageDialog(null, "Press the Previous or the Next button to refresh the records.");
                                        }
                                        st.close();
                                        st1.close();
                                    }
                                    catch(HeadlessException | SQLException e){
                                        JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                                    } 
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"1) The price must be a number.\n"
                                    + "2) It must be greater than or equal to 0.\n"
                                    + "3) It must be less than or equal to 65535.");        
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Please enter the selling price of the plant.");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"1) The quantity must be a number.\n"
                            + "2) It must be greater than or equal to 0.\n"
                            + "3) It must be less than or equal to 65535.");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please enter a quantity for the plant. If none, proceed with 0.");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "The name and the scientifc name\nof the plantshould contain only alphabets");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter either the common name and the scientific name of the plant.");
            }  
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }             
    }//GEN-LAST:event_NavigateModify_btn_UpdateActionPerformed

    private void NavigateModify_btn_EditPNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavigateModify_btn_EditPNameActionPerformed
        NavigateModify_tb_PName.setEditable(true);
    }//GEN-LAST:event_NavigateModify_btn_EditPNameActionPerformed

    private void NavigateModify_btn_EditPSciNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavigateModify_btn_EditPSciNameActionPerformed
        NavigateModify_tb_PSciName.setEditable(true);
    }//GEN-LAST:event_NavigateModify_btn_EditPSciNameActionPerformed

    private void Navigate_btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Navigate_btn_DeleteActionPerformed
        try{
            btnFunction.Delete(Navigate_tb_PID.getText(), "plants_data", "PID", Panel_Navigate, Panel_NavigateAdd);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Navigate_btn_DeleteActionPerformed

    private void btn_RDto_ListsPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RDto_ListsPanelActionPerformed
        makePanelVisible(Panel_Lists);
        makeColorPanelVisible(Left_colorPanel_Lists);  
        Lists_tbl_maintable.setVisible(false);
        Lists_lbl_tblName.setText(null);
        makeCheckboxPanelVisible(Lists_InsidePanel_checkboxBlank);
        makeListsBasePanelVisible(Lists_basePanel_Blank);
    }//GEN-LAST:event_btn_RDto_ListsPanelActionPerformed

    private void NavigateAdd_btn_RDto_NavigateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavigateAdd_btn_RDto_NavigateActionPerformed
        Panel_NavigateAdd.setVisible(false);
        Panel_Navigate.setVisible(true);
        setPanelComponentsNull(Panel_NavigateAdd);
    }//GEN-LAST:event_NavigateAdd_btn_RDto_NavigateActionPerformed

    private void NavigateModify_btn_RDto_NavigateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavigateModify_btn_RDto_NavigateActionPerformed
        Panel_NavigateModify.setVisible(false);
        Panel_Navigate.setVisible(true);
    }//GEN-LAST:event_NavigateModify_btn_RDto_NavigateActionPerformed

    private void GardenAdd_btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GardenAdd_btn_AddActionPerformed
        try{
            int result = JOptionPane.showConfirmDialog(null, "Do you want to add this record to the database?", "Confirm", WIDTH);
            if(JOptionPane.YES_OPTION==result){
                String txtGID = GardenAdd_tb_GID.getText();
                String txtGName = GardenAdd_tb_GName.getText();
                String txtGAddress = GardenAdd_ta_GAddress.getText().trim();
                String txtGNote = GardenAdd_ta_GNote.getText().trim(); 
                if(txtGName.isEmpty()==false){
                    if(txtGAddress.isEmpty()==false){
                        if(GardenAdd_dtPicker_GExpiry.getDate() == null){
                            JOptionPane.showMessageDialog(null, "Please enter the expiry date of the contract.");
                        }
                        else{
                            try{
                                Connection con;
                                con = ConnectTo.getConnection();
                                PreparedStatement st = (PreparedStatement) con.prepareStatement
                                    ("insert into garden values(?,?,?,?,?)");
                                java.sql.Date sqldtGExpiry = new java.sql.Date(GardenAdd_dtPicker_GExpiry.getDate().getTime());
                                st.setString(1, txtGID);
                                st.setString(2, txtGName);
                                st.setString(3, txtGAddress);
                                st.setDate(4, sqldtGExpiry);
                                st.setString(5, txtGNote);                                       
                                int n = st.executeUpdate();
                                if(n==1){
                                    Panel_GardenAdd.setVisible(false);
                                    Panel_Garden.setVisible(true);
                                    setPanelComponentsNull(Panel_GardenAdd);
                                    JOptionPane.showMessageDialog(null, "Record added.");
                                    JOptionPane.showMessageDialog(null, "Press the Previous or the Next button to refresh the records.");
                                    setPanelComponentsNull(Panel_GardenAdd);
                                }             
                                con.close();
                                st.close();
                            }
                            catch(ClassNotFoundException | SQLException e){
                                JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                            } 
                            catch (HeadlessException ex) {
                                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                            } 
                        }                      
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please enter the address of the garden.");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter the name of the garden.");
                }
            }
        }
        catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_GardenAdd_btn_AddActionPerformed

    private void GardenModify_btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GardenModify_btn_UpdateActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            String txtGID = GardenModify_tb_GID.getText();
            String txtGName = GardenModify_tb_GName.getText();
            String txtGAddress = GardenModify_ta_GAddress.getText().trim();
            String txtGNote = GardenModify_ta_GNote.getText().trim(); 
            if(txtGName.isEmpty()==false){
                if(txtGAddress.isEmpty()==false){
                    if(GardenModify_dtPicker_GExpiry.getDate() == null){
                        JOptionPane.showMessageDialog(null, "Please enter the expiry date of the contract.");
                    }
                    else{
                        try{
                            PreparedStatement st = (PreparedStatement) con.prepareStatement
                                ("update garden set GName=?, GAddress=?, GExpiry=?, GNote=? where gid=?;");
                            java.sql.Date sqldtGExpiry = new java.sql.Date(GardenModify_dtPicker_GExpiry.getDate().getTime());
                            st.setString(1, txtGName);
                            st.setString(2, txtGAddress);
                            st.setDate(3, sqldtGExpiry);
                            st.setString(4, txtGNote);
                            st.setString(5, txtGID);
                            int n = st.executeUpdate();
                            if(n>0){
                                JOptionPane.showMessageDialog(null, "Record updated");
                                Panel_GardenModify.setVisible(false);
                                Panel_Garden.setVisible(true);
                                JOptionPane.showMessageDialog(null, "Press the Previous or the Next button to refresh the records.");
                            }
                            st.close();
                        }
                        catch(HeadlessException | SQLException e){
                            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "The garden address field is empty.\nEnter to proceed.");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "The garden name is set to empty.\nEnter to proceed.");
            }
            con.close();
        }
        catch(SQLException | HeadlessException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
        }             
    }//GEN-LAST:event_GardenModify_btn_UpdateActionPerformed

    private void GardenModify_btn_RDto_GardenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GardenModify_btn_RDto_GardenActionPerformed
        Panel_GardenModify.setVisible(false);
        Panel_Garden.setVisible(true);
    }//GEN-LAST:event_GardenModify_btn_RDto_GardenActionPerformed

    private void GardenAdd_btn_RDto_GardenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GardenAdd_btn_RDto_GardenActionPerformed
        Panel_GardenAdd.setVisible(false);
        Panel_Garden.setVisible(true);
        setPanelComponentsNull(Panel_GardenAdd);
    }//GEN-LAST:event_GardenAdd_btn_RDto_GardenActionPerformed

    private void Garden_btn_AddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Garden_btn_AddNewActionPerformed
        try{
            String TEorNot = checkEmpty.isTableEmpty("garden");
            if(TEorNot.equals("notEmpty")){
                String ID = btnFunction.AddNew(Panel_Garden, Panel_GardenAdd, "garden", "GID",
                    999, 4, "G");
                GardenAdd_tb_GID.setText(ID);
            }
            else{
                Panel_Garden.setVisible(false);
                Panel_GardenAdd.setVisible(true);
                setPanelComponentsNull(Panel_GardenAdd);
                GardenAdd_tb_GID.setText("G001");
            }
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Garden_btn_AddNewActionPerformed

    private void Garden_btn_ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Garden_btn_ModifyActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            try{
                String tblName = "garden";
                String EorNot = checkEmpty.isTableEmpty(tblName);
                if(EorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed.");
                }
                if(EorNot.equals("notEmpty")){
                    String recEorNot = checkEmpty.isRecordExist(tblName, "GID", Garden_tb_GID.getText());
                    if(recEorNot.equals("Exists")){
                        Panel_Garden.setVisible(false);
                        Panel_GardenModify.setVisible(true);
                        GardenModify_tb_GName.setEditable(false);                       
                        PreparedStatement st = (PreparedStatement) con.prepareStatement
                            ("select * from garden where GID=?;");
                        st.setString(1, Garden_tb_GID.getText());
                        ResultSet rs = st.executeQuery();
                        if(rs.next()){
                            Date dtGExpiry = rs.getDate("GExpiry");
                            String GID = rs.getString("GID");
                            String GName = rs.getString("GName");
                            String GAddress = rs.getString("GAddress");
                            String GNote = rs.getString("GNote");                             
                            GardenModify_tb_GID.setText(GID);
                            GardenModify_tb_GName.setText(GName);
                            GardenModify_ta_GAddress.setText(GAddress);
                            GardenModify_dtPicker_GExpiry.setDate(dtGExpiry);
                            GardenModify_ta_GNote.setText(GNote);
                        }
                        st.close();
                        rs.close();
                    }
                    if(recEorNot.equals("notExists")){
                        JOptionPane.showMessageDialog(null, "This record has already been altered / deleted."
                            + "\n\nNote :\nAlways remember to refresh the screen "
                            + "\nafter adding/ updating/ deleting record(s).");
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
    }//GEN-LAST:event_Garden_btn_ModifyActionPerformed

    private void Garden_btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Garden_btn_DeleteActionPerformed
        try{
            btnFunction.Delete(Garden_tb_GID.getText(), "garden", "GID", Panel_Garden, Panel_GardenAdd);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Garden_btn_DeleteActionPerformed

    private void Sell_btn_ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sell_btn_ConfirmActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            String issueID = Sell_tb_SID.getText();
            String issueDate = Sell_tb_issueDate.getText();
            String stockID = Sell_tb_stockID.getText();
            String PID = Sell_tb_PID.getText();
            String strSellQty = Sell_tb_PQuantity_toSell.getText();
            String custName = Sell_tb_custName.getText();
            String custContact = Sell_tb_custContact.getText();
            if(!PID.isEmpty() && !strSellQty.isEmpty()){
                if(Number.isNumber(strSellQty)){
                    int sellQty = Integer.parseInt(strSellQty);
                    int remQty = Integer.parseInt(Sell_tb_PQuantity_Remaining.getText());
                    int p = Integer.parseInt(Sell_tb_PPrice.getText());
                    if(sellQty <= remQty){
                        if(sellQty>0){
                            int totalPrice = sellQty * p;
                            if(!custName.isEmpty()){
                                if(verify.verifyContact(custContact) || verify.verifyEmail(custContact) || custContact.isEmpty()){
                                    remQty -= sellQty;
                                    PreparedStatement ps = (PreparedStatement) con.prepareStatement
                                        ("update stock set P_Quantity=? where PID=?;");
                                    ps.setInt(1,remQty);
                                    ps.setString(2,PID);
                                    PreparedStatement ps1 = (PreparedStatement) con.prepareStatement
                                        ("insert into sold values (?,?,?,?,?,?,?);");
                                    ps1.setString(1, issueID);
                                    ps1.setString(2, PID);
                                    ps1.setString(3, stockID);
                                    ps1.setInt(4, Integer.parseInt(strSellQty));
                                    ps1.setString(5, custName);
                                    ps1.setString(6, custContact);
                                    ps1.setDate(7, Date.valueOf(issueDate));
                                    int n = ps.executeUpdate();
                                    int n1= ps1.executeUpdate();
                                    if(n==1 && n1==1){
                                        JOptionPane.showMessageDialog(null,"Transaction successful.");
                                        ReceiptPrinter r = new ReceiptPrinter
            (issueID, custName, Sell_tb_PName.getText(), strSellQty, Sell_tb_PPrice.getText(), totalPrice, Date.valueOf(issueDate));
                                        r.setVisible(true);  
                                        setPanelComponentsNull(Panel_Sell);
                                        String ID = btnFunction.AddNew(Panel_Sell, Panel_Sell, "Sold", "Plant_Issue_ID", 9999, 5, "S");
                                        Sell_tb_SID.setText(ID);
                                    }
                                    ps.close();
                                    ps1.close();
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"The contact details can be either :\ni) Empty\nii) Email\niii) Phone number");
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Enter the name of the customer");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Quantity to be sold should be greater than 0.");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"The quantity to sell should be lesser than the remaining quantity.");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Quantity should be a number");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Required credentials are not specified.\n\n"
                        + "i) Select a plant\nii) Enter the quantity to sell");
            }
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Sell_btn_ConfirmActionPerformed

    private void HybridAdd_cmb_HSpecies1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridAdd_cmb_HSpecies1ActionPerformed
        HybridAdd_tb_HSpecies1.setText((String)HybridAdd_cmb_HSpecies1.getSelectedItem());
    }//GEN-LAST:event_HybridAdd_cmb_HSpecies1ActionPerformed

    private void HybridAdd_cmb_HSpecies2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridAdd_cmb_HSpecies2ActionPerformed
        HybridAdd_tb_HSpecies2.setText((String)HybridAdd_cmb_HSpecies2.getSelectedItem());
    }//GEN-LAST:event_HybridAdd_cmb_HSpecies2ActionPerformed

    private void HybridAdd_cmb_HSpecies3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridAdd_cmb_HSpecies3ActionPerformed
        HybridAdd_tb_HSpecies3.setText((String)HybridAdd_cmb_HSpecies3.getSelectedItem());
    }//GEN-LAST:event_HybridAdd_cmb_HSpecies3ActionPerformed

    private void HybridAdd_cmb_HSpecies4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridAdd_cmb_HSpecies4ActionPerformed
        HybridAdd_tb_HSpecies4.setText((String)HybridAdd_cmb_HSpecies4.getSelectedItem());
    }//GEN-LAST:event_HybridAdd_cmb_HSpecies4ActionPerformed

    private void HybridAdd_cmb_HSpecies5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridAdd_cmb_HSpecies5ActionPerformed
        HybridAdd_tb_HSpecies5.setText((String)HybridAdd_cmb_HSpecies5.getSelectedItem());
    }//GEN-LAST:event_HybridAdd_cmb_HSpecies5ActionPerformed

    private void HybridModify_cmb_HSpecies1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridModify_cmb_HSpecies1ActionPerformed
        HybridModify_tb_HSpecies1.setText((String)HybridModify_cmb_HSpecies1.getSelectedItem());
    }//GEN-LAST:event_HybridModify_cmb_HSpecies1ActionPerformed

    private void HybridModify_cmb_HSpecies2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridModify_cmb_HSpecies2ActionPerformed
        HybridModify_tb_HSpecies2.setText((String)HybridModify_cmb_HSpecies2.getSelectedItem());
    }//GEN-LAST:event_HybridModify_cmb_HSpecies2ActionPerformed

    private void HybridModify_cmb_HSpecies3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridModify_cmb_HSpecies3ActionPerformed
        HybridModify_tb_HSpecies3.setText((String)HybridModify_cmb_HSpecies3.getSelectedItem());
    }//GEN-LAST:event_HybridModify_cmb_HSpecies3ActionPerformed

    private void HybridModify_cmb_HSpecies4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridModify_cmb_HSpecies4ActionPerformed
        HybridModify_tb_HSpecies4.setText((String)HybridModify_cmb_HSpecies4.getSelectedItem());
    }//GEN-LAST:event_HybridModify_cmb_HSpecies4ActionPerformed

    private void HybridModify_cmb_HSpecies5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridModify_cmb_HSpecies5ActionPerformed
        HybridModify_tb_HSpecies5.setText((String)HybridModify_cmb_HSpecies5.getSelectedItem());
    }//GEN-LAST:event_HybridModify_cmb_HSpecies5ActionPerformed

    private void Hybrid_btn_AddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hybrid_btn_AddNewActionPerformed
        try{
            String TEorNot = checkEmpty.isTableEmpty("hybrid");
            if(TEorNot.equals("notEmpty")){
                String ID = btnFunction.AddNew(Panel_Hybrid, Panel_HybridAdd, "hybrid", "HID",
                999, 4, "H");
                setPanelComponentsNull(Panel_HybridAdd);
                HybridAdd_tb_HID.setText(ID);
            }
            else{
                makePanelVisible(Panel_HybridAdd);
                setPanelComponentsNull(Panel_HybridAdd);
                HybridAdd_tb_HID.setText("H001");
            }           
            String tblName = "plants_data";
            String colName = "P_Name";
            cmbBox.addtocmbBox(tblName, colName, HybridAdd_cmb_HSpecies1);
            cmbBox.addtocmbBox(tblName, colName, HybridAdd_cmb_HSpecies2);
            cmbBox.addtocmbBox(tblName, colName, HybridAdd_cmb_HSpecies3);
            cmbBox.addtocmbBox(tblName, colName, HybridAdd_cmb_HSpecies4);
            cmbBox.addtocmbBox(tblName, colName, HybridAdd_cmb_HSpecies5);                         
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Hybrid_btn_AddNewActionPerformed

    private void Hybrid_btn_ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hybrid_btn_ModifyActionPerformed
        Panel_Hybrid.setVisible(false);
        Panel_HybridModify.setVisible(true);
        try{
            Connection con;
            con = ConnectTo.getConnection();
            try{
                String tblName = "hybrid";
                String colName = "HID";               
                String TEorNot = checkEmpty.isTableEmpty(tblName);
                if(TEorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed.");
                    makePanelVisible(Panel_HybridAdd);
                    setPanelComponentsNull(Panel_HybridAdd);
                    HybridAdd_tb_HID.setText("H001");
                }
                if(TEorNot.equals("notEmpty")){
                    String recEorNot = checkEmpty.isRecordExist(tblName, colName, Hybrid_tb_HID.getText());
                    if(recEorNot.equals("Exists")){
                        Panel_Hybrid.setVisible(false);
                        Panel_HybridModify.setVisible(true);
                        HybridModify_tb_HName.setEditable(false);
                        
                        PreparedStatement st = (PreparedStatement) con.prepareStatement
                            ("select * from hybrid where HID=?;");
                        st.setString(1, Hybrid_tb_HID.getText());
                        ResultSet rs = st.executeQuery();
                        if(rs.next()){                          
                            String tblName1 = "plants_data";
                            String colName1 = "P_Name";
                            cmbBox.addtocmbBox(tblName1, colName1, HybridModify_cmb_HSpecies1);
                            cmbBox.addtocmbBox(tblName1, colName1, HybridModify_cmb_HSpecies2);
                            cmbBox.addtocmbBox(tblName1, colName1, HybridModify_cmb_HSpecies3);
                            cmbBox.addtocmbBox(tblName1, colName1, HybridModify_cmb_HSpecies4);
                            cmbBox.addtocmbBox(tblName1, colName1, HybridModify_cmb_HSpecies5);                          
                            String HID = rs.getString("HID");
                            String HName = rs.getString("HName");
                            String HSpecies1 = rs.getString("HSpecies1");
                            String HSpecies2 = rs.getString("HSpecies2");
                            String HSpecies3 = rs.getString("HSpecies3");
                            String HSpecies4 = rs.getString("HSpecies4");
                            String HSpecies5 = rs.getString("HSpecies5");
                            Date dtHDate = rs.getDate("HDate");
                            String HNote = rs.getString("HNote");                         
                            HybridModify_tb_HID.setText(HID);
                            HybridModify_tb_HName.setText(HName);
                            HybridModify_tb_HSpecies1.setText(HSpecies1);
                            HybridModify_tb_HSpecies2.setText(HSpecies2);
                            HybridModify_tb_HSpecies3.setText(HSpecies3);
                            HybridModify_tb_HSpecies4.setText(HSpecies4);
                            HybridModify_tb_HSpecies5.setText(HSpecies5);
                            HybridModify_dtPicker_HDate.setDate(dtHDate);
                            HybridModify_ta_HNote.setText(HNote);
                        }
                        st.close();
                        rs.close();
                    }
                    if(recEorNot.equals("notExists")){
                        JOptionPane.showMessageDialog(null, "This record has already been deleted."
                            + "\n\nNote :\nAlways remember to refresh the screen "
                            + "\nafter adding/ updating/ deleting record(s).");
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
    }//GEN-LAST:event_Hybrid_btn_ModifyActionPerformed

    private void Garden_btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Garden_btn_FirstActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            try{
                String tblName = "garden";
                String EorNot = checkEmpty.isTableEmpty(tblName);
                if(EorNot.equals("notEmpty")){
                    for(int i=1 ;i<998 ;i++){
                        int next_id = i + 1;
                        int NoOfDigits = Number.getCount(next_id) + 1;
                        String final_id;
                        try {
                            final_id = FinalID.getID("G", i, NoOfDigits);               
                            try{  
                                PreparedStatement st = (PreparedStatement) con.prepareStatement
                                    ("select * from garden where GID=?;");
                                st.setString(1, final_id);
                                ResultSet rs = st.executeQuery();
                                if(rs.next()){
                                    GardenSet(rs);
                                    String a = Number.noOfRecord(tblName, "GID", final_id);
                                    String n = Number.totalRecords(tblName);
                                    Garden_lbl_Count.setText(a +" of "+ n);
                                    break;
                                }
                                st.close();
                                rs.close();           
                            }
                            catch(SQLException e){
                                JOptionPane.showMessageDialog(null, e);
                            }               
                        } 
                        catch (Exception ex) {
                            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    }
                }
                if(EorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed further.");
                    setPanelComponentsNull(Panel_Garden);
                    Garden_lbl_Count.setText("Empty");
                }
            }
            catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
            con.close();
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
        }
    }//GEN-LAST:event_Garden_btn_FirstActionPerformed

    private void Garden_btn_PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Garden_btn_PreviousActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            String tblName = "garden";
            String EorNot = checkEmpty.isTableEmpty(tblName);
            if(EorNot.equals("Empty")){
                JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed further.");
                setPanelComponentsNull(Panel_Garden);
                Garden_lbl_Count.setText("Empty");
            }
            if(EorNot.equals("notEmpty")){
                if(Garden_tb_GID.getText().isEmpty()){
                    for(int i=1 ;i<1000 ;i++){
                        int next_id = i + 1;
                        if(next_id>999){
                            next_id=1;
                        }
                        int NoOfDigits = Number.getCount(next_id) + 1;
                        String final_id;
                        try {
                            final_id = FinalID.getID("G", i, NoOfDigits);               
                            try{  
                                PreparedStatement st = (PreparedStatement) con.prepareStatement
                                    ("select * from garden where GID=?;");
                                st.setString(1, final_id);
                                ResultSet rs = st.executeQuery();
                                if(rs.next()){
                                    GardenSet(rs);
                                    String a = Number.noOfRecord(tblName, "GID", final_id);
                                    String n = Number.totalRecords(tblName);
                                    Garden_lbl_Count.setText(a +" of "+ n);
                                    break;   
                                }
                                st.close();
                                rs.close();           
                            }
                            catch(SQLException e){
                                JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
                            }               
                        } 
                        catch (Exception ex) {
                            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    }
                }
                else{
                    String ID_now_str = Garden_tb_GID.getText().substring(1,4);
                    int ID_now_int = Integer.parseInt(ID_now_str);
                    for(int i = ID_now_int; i > 0 ; i--){        
                        try{
                            int prev_id = i - 1;
                            int NoOfDigits = Number.getCount(prev_id) + 1;
                            String final_id;
                            try {
                                final_id = FinalID.getID("G", prev_id, NoOfDigits);                                              
                                PreparedStatement st =  (PreparedStatement)
                                    con.prepareStatement("select * from garden where gid=?;");
                                st.setString(1, final_id);
                                ResultSet rs = st.executeQuery();
                                if(rs.next()){
                                    GardenSet(rs);
                                    String a = Number.noOfRecord(tblName, "GID", final_id);
                                    String n = Number.totalRecords(tblName);
                                    Garden_lbl_Count.setText(a +" of "+ n);
                                    break;
                                }
                                rs.close();
                                st.close();
                            }   
                            catch (Exception ex) {
                                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                            }    
                        }
                        catch(HeadlessException e){
                            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                        }
                    }
                }     
            }
            con.close();
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
        }
    }//GEN-LAST:event_Garden_btn_PreviousActionPerformed

    private void Garden_btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Garden_btn_LastActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            try{
                String tblName = "garden";
                String EorNot = checkEmpty.isTableEmpty(tblName);
                if(EorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed further.");
                    setPanelComponentsNull(Panel_Garden);     
                    Garden_lbl_Count.setText("Empty");
                }
                if(EorNot.equals("notEmpty")){
                    try{
                        PreparedStatement st = (PreparedStatement) con.prepareStatement
                            ("select * from garden ORDER BY GID DESC LIMIT 1;");
                        ResultSet rs = st.executeQuery();
                        if(rs.next()){
                            String GID = rs.getString("GID");
                            GardenSet(rs);
                            String a = Number.noOfRecord(tblName, "GID", GID);
                            String n = Number.totalRecords(tblName);
                            Garden_lbl_Count.setText(a +" of "+ n);        
                        }
                        st.close();
                        rs.close();
                    }
                    catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
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
    }//GEN-LAST:event_Garden_btn_LastActionPerformed

    private void Garden_btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Garden_btn_NextActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            try{
                String tblName = "garden";
                String EorNot = checkEmpty.isTableEmpty(tblName);
                if(EorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed further.");       
                    setPanelComponentsNull(Panel_Garden);
                    Garden_lbl_Count.setText("Empty");
                }
                if(EorNot.equals("notEmpty")){
                    if(Garden_tb_GID.getText().isEmpty()){
                        try{
                            PreparedStatement st = (PreparedStatement) con.prepareStatement
                                ("select * from garden ORDER BY gid DESC LIMIT 1;");
                            ResultSet rs = st.executeQuery();
                            if(rs.next()){
                                String GID = rs.getString("GID");
                                GardenSet(rs);
                                String a = Number.noOfRecord(tblName, "GID", GID);
                                String n = Number.totalRecords(tblName);
                                Garden_lbl_Count.setText(a +" of "+ n);  
                            }
                            st.close();
                            rs.close();
                        }
                        catch(SQLException e){
                            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                        }
                    }
                    else{
                        try{
                            String ID_now_str = Garden_tb_GID.getText().substring(1,4);
                            int ID_now_int = Integer.parseInt(ID_now_str);
                            try{
                                PreparedStatement st = (PreparedStatement) con.prepareStatement
                                    ("select gid from garden ORDER BY gid DESC LIMIT 1;");
                                ResultSet rs = st.executeQuery();
                                if(rs.next()){
                                    String ID_str = rs.getString(1).substring(1, 4);    
                                    int id_int = Integer.parseInt(ID_str);
                                    for(int i = ID_now_int ; i < id_int ; i++){
                                        int next_id = i + 1;
                                        int NoOfDigits = Number.getCount(next_id) + 1;
                                        String final_id;
                                        try{
                                            final_id = FinalID.getID("G", next_id, NoOfDigits);
                                            try{                       
                                                PreparedStatement st1 =  (PreparedStatement)
                                                    con.prepareStatement("select * from garden where gid=?;");
                                                st1.setString(1, final_id);
                                                ResultSet rs1 = st1.executeQuery();
                                                if(rs1.next()){
                                                    String GID = rs1.getString("GID");
                                                    GardenSet(rs1);
                                                    String a = Number.noOfRecord(tblName, "GID", GID);
                                                    String n = Number.totalRecords(tblName);
                                                    Garden_lbl_Count.setText(a +" of "+ n); 
                                                    break;  
                                                }
                                                rs1.close();
                                                st1.close();
                                            }
                                            catch(HeadlessException | SQLException e){
                                                JOptionPane.showMessageDialog(null, e);
                                            }
                                        } 
                                        catch (Exception ex) {
                                            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }    
                                }    
                                rs.close();
                                st.close();
                            }
                            catch(HeadlessException | SQLException e){
                                JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
                            }
                        }
                        catch(HeadlessException e){
                            JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
                        }
                    }    
                }
            }
            catch(HeadlessException | ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
            }
            con.close();
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
        }
    }//GEN-LAST:event_Garden_btn_NextActionPerformed

    private void GardenModify_btn_editGNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GardenModify_btn_editGNameActionPerformed
        GardenModify_tb_GName.setEditable(true);
    }//GEN-LAST:event_GardenModify_btn_editGNameActionPerformed

    private void NavigateAdd_btn_clearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavigateAdd_btn_clearAllActionPerformed
        setPanelComponentsNull(Panel_NavigateAdd);
    }//GEN-LAST:event_NavigateAdd_btn_clearAllActionPerformed

    private void GardenAdd_btn_clearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GardenAdd_btn_clearAllActionPerformed
        setPanelComponentsNull(Panel_GardenAdd);
    }//GEN-LAST:event_GardenAdd_btn_clearAllActionPerformed

    private void Hybrid_btn_PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hybrid_btn_PreviousActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            String tblName = "hybrid";
            String EorNot = checkEmpty.isTableEmpty(tblName);
            if(EorNot.equals("Empty")){
                JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed further.");
                setPanelComponentsNull(Panel_Hybrid);
                Hybrid_lbl_Count.setText("Empty");
            }
            if(EorNot.equals("notEmpty")){
                if(Hybrid_tb_HID.getText().isEmpty()){
                    for(int i=1 ;i<999 ;i++){
                        int next_id = i + 1;
                        int NoOfDigits = Number.getCount(next_id) + 1;
                        String final_id;
                        try {
                            final_id = FinalID.getID("H", i, NoOfDigits);               
                            try{  
                                PreparedStatement st = (PreparedStatement) con.prepareStatement
                                    ("select * from hybrid where HID=?;");
                                st.setString(1, final_id);
                                ResultSet rs = st.executeQuery();
                                if(rs.next()){
                                    HybridSet(rs);
                                    String a = Number.noOfRecord(tblName, "HID", final_id);
                                    String n = Number.totalRecords(tblName);
                                    Hybrid_lbl_Count.setText(a +" of "+ n);
                                    break;
                                }
                                st.close();
                                rs.close();           
                            }
                            catch(SQLException e){
                                JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
                            }               
                        } 
                        catch (Exception ex) {
                            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    }
                }
                else{
                    String ID_now_str = Hybrid_tb_HID.getText().substring(1,4);
                    int ID_now_int = Integer.parseInt(ID_now_str);
                    for(int i = ID_now_int; i > 0 ; i--){                             
                        try{
                            int prev_id = i - 1;
                            int NoOfDigits = Number.getCount(prev_id) + 1;
                            String final_id;
                            try {
                                final_id = FinalID.getID("H", prev_id, NoOfDigits);                                              
                                PreparedStatement st =  (PreparedStatement)
                                    con.prepareStatement("select * from hybrid where hid=?;");
                                st.setString(1, final_id);
                                ResultSet rs = st.executeQuery();
                                if(rs.next()){
                                    HybridSet(rs);
                                    String a = Number.noOfRecord(tblName, "HID", final_id);
                                    String n = Number.totalRecords(tblName);
                                    Hybrid_lbl_Count.setText(a +" of "+ n);
                                    break;
                                }
                                rs.close();
                                st.close();
                            }   
                            catch (Exception ex) {
                                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                            }    
                        }
                        catch(HeadlessException e){
                            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                        }
                    }
                }     
            }
            con.close();
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
        }
    }//GEN-LAST:event_Hybrid_btn_PreviousActionPerformed

    private void Hybrid_btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hybrid_btn_LastActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            try{
                String tblName = "hybrid";
                String EorNot = checkEmpty.isTableEmpty(tblName);
                if(EorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed further.");
                    setPanelComponentsNull(Panel_Hybrid);     
                    Hybrid_lbl_Count.setText("Empty");
                }
                if(EorNot.equals("notEmpty")){
                    try{
                        PreparedStatement st = (PreparedStatement) con.prepareStatement
                            ("select * from hybrid ORDER BY HID DESC LIMIT 1;");
                        ResultSet rs = st.executeQuery();
                        if(rs.next()){
                            String HID = rs.getString("HID");
                            HybridSet(rs);
                            String a = Number.noOfRecord(tblName, "HID", HID);
                            String n = Number.totalRecords(tblName);
                            Hybrid_lbl_Count.setText(a +" of "+ n);       
                        }
                        st.close();
                        rs.close();
                    }
                    catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
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
    }//GEN-LAST:event_Hybrid_btn_LastActionPerformed

    private void Hybrid_btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hybrid_btn_FirstActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            try{
                String tblName = "hybrid";
                String EorNot = checkEmpty.isTableEmpty(tblName);
                if(EorNot.equals("notEmpty")){
                    for(int i=1 ;i<998 ;i++){
                        int next_id = i + 1;
                        int NoOfDigits = Number.getCount(next_id) + 1;
                        String final_id;
                        try {
                            final_id = FinalID.getID("H", i, NoOfDigits);               
                            try{  
                                PreparedStatement st = (PreparedStatement) con.prepareStatement
                                    ("select * from hybrid where HID=?;");
                                st.setString(1, final_id);
                                ResultSet rs = st.executeQuery();
                                if(rs.next()){
                                    HybridSet(rs);
                                    String a = Number.noOfRecord(tblName, "HID", final_id);
                                    String n = Number.totalRecords(tblName);
                                    Hybrid_lbl_Count.setText(a +" of "+ n);
                                    break;
                                }
                                st.close();
                                rs.close();           
                            }
                            catch(SQLException e){
                                JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
                            }               
                        } 
                        catch (Exception ex) {
                            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    }
                }
                if(EorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed further.");
                    setPanelComponentsNull(Panel_Garden);
                    Hybrid_lbl_Count.setText("Empty");
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
    }//GEN-LAST:event_Hybrid_btn_FirstActionPerformed

    private void Hybrid_btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hybrid_btn_NextActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            try{
                String tblName = "hybrid";
                String EorNot = checkEmpty.isTableEmpty(tblName);
                if(EorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "The record table is empty!\nAdd a record to proceed further.");       
                    setPanelComponentsNull(Panel_Hybrid);
                    Hybrid_lbl_Count.setText("Empty");
                }
                if(EorNot.equals("notEmpty")){
                    if(Hybrid_tb_HID.getText().isEmpty()){
                        try{
                            PreparedStatement st = (PreparedStatement) con.prepareStatement
                                ("select * from hybrid ORDER BY hid DESC LIMIT 1;");
                            ResultSet rs = st.executeQuery();
                            if(rs.next()){
                                String HID = rs.getString("HID");
                                HybridSet(rs);
                                String a = Number.noOfRecord(tblName, "HID", HID);
                                String n = Number.totalRecords(tblName);
                                Hybrid_lbl_Count.setText(a +" of "+ n); 
                            }
                            st.close();
                            rs.close();
                        }
                        catch(SQLException e){
                            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                        }
                    }
                    else{
                        try{
                            String ID_now_str = Hybrid_tb_HID.getText().substring(1,4);
                            int ID_now_int = Integer.parseInt(ID_now_str);
                            try{
                                PreparedStatement st = (PreparedStatement) con.prepareStatement
                                    ("select hid from hybrid ORDER BY hid DESC LIMIT 1;");
                                ResultSet rs = st.executeQuery();
                                if(rs.next()){
                                    String ID_str = rs.getString(1).substring(1, 4);    
                                    int id_int = Integer.parseInt(ID_str);

                                    for(int i = ID_now_int ; i < id_int ; i++){
                                        int next_id = i + 1;
                                        int NoOfDigits = Number.getCount(next_id) + 1;
                                        String final_id;
                                        try{
                                            final_id = FinalID.getID("H", next_id, NoOfDigits);
                                            try{                       
                                                PreparedStatement st1 =  (PreparedStatement)
                                                    con.prepareStatement("select * from hybrid where hid=?;");
                                                st1.setString(1, final_id);
                                                ResultSet rs1 = st1.executeQuery();
                                                if(rs1.next()){
                                                    HybridSet(rs1);
                                                    String a = Number.noOfRecord(tblName, "HID", final_id);
                                                    String n = Number.totalRecords(tblName);
                                                    Hybrid_lbl_Count.setText(a +" of "+ n);
                                                    break; 
                                                }
                                                rs1.close();
                                                st1.close();
                                            }
                                            catch(HeadlessException | SQLException e){
                                                JOptionPane.showMessageDialog(null, e);
                                            }
                                        } 
                                        catch (Exception ex) {
                                            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }    
                                }    
                                rs.close();
                                st.close();
                            }
                            catch(HeadlessException | SQLException e){
                                JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
                            }
                        }
                        catch(HeadlessException e){
                            JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
                        }
                    }    
                }
            }
            catch(HeadlessException | ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
            }
            con.close();
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Connection failed.\n"+e);
        }
    }//GEN-LAST:event_Hybrid_btn_NextActionPerformed

    private void HybridAdd_btn_hsp1ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridAdd_btn_hsp1ClearActionPerformed
        HybridAdd_tb_HSpecies1.setText(null);
    }//GEN-LAST:event_HybridAdd_btn_hsp1ClearActionPerformed

    private void HybridAdd_btn_hsp2ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridAdd_btn_hsp2ClearActionPerformed
        HybridAdd_tb_HSpecies2.setText(null);
    }//GEN-LAST:event_HybridAdd_btn_hsp2ClearActionPerformed

    private void HybridAdd_btn_hsp3ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridAdd_btn_hsp3ClearActionPerformed
        HybridAdd_tb_HSpecies3.setText(null);
    }//GEN-LAST:event_HybridAdd_btn_hsp3ClearActionPerformed

    private void HybridAdd_btn_hsp4ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridAdd_btn_hsp4ClearActionPerformed
        HybridAdd_tb_HSpecies4.setText(null);
    }//GEN-LAST:event_HybridAdd_btn_hsp4ClearActionPerformed

    private void HybridAdd_btn_hsp5ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridAdd_btn_hsp5ClearActionPerformed
        HybridAdd_tb_HSpecies5.setText(null);
    }//GEN-LAST:event_HybridAdd_btn_hsp5ClearActionPerformed

    private void HybridAdd_btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridAdd_btn_AddActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Do you want to add this record to the database?", "Confirm", WIDTH);
        if(JOptionPane.YES_OPTION==result){
            String txtHID = HybridAdd_tb_HID.getText();
            String txtHName = HybridAdd_tb_HName.getText();
            String txtHSpecies1 = HybridAdd_tb_HSpecies1.getText();
            String txtHSpecies2 = HybridAdd_tb_HSpecies2.getText();
            String txtHSpecies3 = HybridAdd_tb_HSpecies3.getText();
            String txtHSpecies4 = HybridAdd_tb_HSpecies4.getText();
            String txtHSpecies5 = HybridAdd_tb_HSpecies5.getText();
            String txtHNote = HybridAdd_ta_HNote.getText().trim();
            if(txtHName.isEmpty()==false){
                if(verify.ComboBoxValidationfor5C2(txtHSpecies1, txtHSpecies2, txtHSpecies3, txtHSpecies4, txtHSpecies5)){
                    if(HybridAdd_dtPicker_HDate.getDate() == null){
                        JOptionPane.showMessageDialog(null, "Please enter the date.");
                    }
                    else{
                        try{
                            Connection con;
                            con = ConnectTo.getConnection();
                            PreparedStatement st = (PreparedStatement) con.prepareStatement
                              ("insert into hybrid values(?,?,?,?,?,?,?,?,?)"); 
                            java.sql.Date sqldtHDate = new java.sql.Date(HybridAdd_dtPicker_HDate.getDate().getTime());
                            st.setString(1, txtHID);
                            st.setString(2, txtHName);
                            st.setString(3, txtHSpecies1);
                            st.setString(4, txtHSpecies2);
                            st.setString(5, txtHSpecies3);
                            st.setString(6, txtHSpecies4);
                            st.setString(7, txtHSpecies5);
                            st.setDate(8, sqldtHDate);
                            st.setString(9, txtHNote);
                            int n = st.executeUpdate();
                            if(n==1){
                                Panel_HybridAdd.setVisible(false);
                                Panel_Hybrid.setVisible(true);
                                JOptionPane.showMessageDialog(null, "Record added.");
                                JOptionPane.showMessageDialog(null, "Press the Previous or the Next button to refresh the records.");
                                setPanelComponentsNull(Panel_NavigateAdd);
                            }             
                            con.close();
                            st.close();
                        }
                        catch(ClassNotFoundException | SQLException e){
                            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                        }
                    } 
                }
                else{
                    JOptionPane.showMessageDialog(null,"At least two species are required to be selected for a hybrid.");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter the name of the hybrid.");
            }  
        }
    }//GEN-LAST:event_HybridAdd_btn_AddActionPerformed

    private void HybridModify_btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridModify_btn_UpdateActionPerformed
        try{
            Connection con;
            con = ConnectTo.getConnection();
            String txtHID = HybridModify_tb_HID.getText();
            String txtHName = HybridModify_tb_HName.getText();
            String txtHSpecies1 = HybridModify_tb_HSpecies1.getText();
            String txtHSpecies2 = HybridModify_tb_HSpecies2.getText();
            String txtHSpecies3 = HybridModify_tb_HSpecies3.getText();
            String txtHSpecies4 = HybridModify_tb_HSpecies4.getText();
            String txtHSpecies5 = HybridModify_tb_HSpecies5.getText();
            String txtHNote = HybridModify_ta_HNote.getText().trim(); 
            if(txtHName.isEmpty()==false){
                if(verify.ComboBoxValidationfor5C2(txtHSpecies1, txtHSpecies2, txtHSpecies3, txtHSpecies4, txtHSpecies5)){
                    if(HybridModify_dtPicker_HDate.getDate() == null){
                        JOptionPane.showMessageDialog(null, "Please enter the expiry date of the contract.");
                    }
                    else{
                        try{
                            PreparedStatement st = (PreparedStatement) con.prepareStatement
                                ("update hybrid set HName=?, HSpecies1=?, HSpecies2=?, "
                                + "HSpecies3=?, HSpecies4=?, HSpecies5=?, HDate=?, HNote=? where hid=?;");
                            java.sql.Date sqldtHDate = new java.sql.Date(HybridModify_dtPicker_HDate.getDate().getTime());
                            st.setString(1, txtHName);
                            st.setString(2, txtHSpecies1);
                            st.setString(3, txtHSpecies2);
                            st.setString(4, txtHSpecies3);
                            st.setString(5, txtHSpecies4);
                            st.setString(6, txtHSpecies5);
                            st.setDate(7, sqldtHDate);
                            st.setString(8, txtHNote);
                            st.setString(9, txtHID);
                            int n = st.executeUpdate();
                            if(n>0){
                                JOptionPane.showMessageDialog(null, "Record updated");
                                Panel_HybridModify.setVisible(false);
                                Panel_Hybrid.setVisible(true);
                                JOptionPane.showMessageDialog(null, "Press the Previous or the Next button to refresh the records.");
                            }
                            st.close();
                        }
                        catch(HeadlessException | SQLException e){
                            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter at least two species for the given hybrid.");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter the name of the hybrid.");
            }
            con.close();
        }
        catch(SQLException | HeadlessException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Connection failed.\n"+e);
        } 
    }//GEN-LAST:event_HybridModify_btn_UpdateActionPerformed

    private void HybridAdd_btn_RDto_HybridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridAdd_btn_RDto_HybridActionPerformed
        Panel_HybridAdd.setVisible(false);
        Panel_Hybrid.setVisible(true);
        setPanelComponentsNull(Panel_HybridAdd);
    }//GEN-LAST:event_HybridAdd_btn_RDto_HybridActionPerformed

    private void HybridModify_btn_RDto_HybridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridModify_btn_RDto_HybridActionPerformed
        Panel_HybridModify.setVisible(false);
        Panel_Hybrid.setVisible(true);
    }//GEN-LAST:event_HybridModify_btn_RDto_HybridActionPerformed

    private void Hybrid_btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hybrid_btn_DeleteActionPerformed
        try{
            btnFunction.Delete(Hybrid_tb_HID.getText(), "hybrid", "HID", Panel_Hybrid, Panel_HybridAdd);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Hybrid_btn_DeleteActionPerformed

    private void HybridModify_btn_hsp1ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridModify_btn_hsp1ClearActionPerformed
        HybridModify_tb_HSpecies1.setText(null);
    }//GEN-LAST:event_HybridModify_btn_hsp1ClearActionPerformed

    private void HybridModify_btn_hsp2ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridModify_btn_hsp2ClearActionPerformed
        HybridModify_tb_HSpecies2.setText(null);
    }//GEN-LAST:event_HybridModify_btn_hsp2ClearActionPerformed

    private void HybridModify_btn_hsp3ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridModify_btn_hsp3ClearActionPerformed
        HybridModify_tb_HSpecies3.setText(null);
    }//GEN-LAST:event_HybridModify_btn_hsp3ClearActionPerformed

    private void HybridModify_btn_hsp4ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridModify_btn_hsp4ClearActionPerformed
        HybridModify_tb_HSpecies4.setText(null);
    }//GEN-LAST:event_HybridModify_btn_hsp4ClearActionPerformed

    private void HybridModify_btn_hsp5ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridModify_btn_hsp5ClearActionPerformed
        HybridModify_tb_HSpecies5.setText(null);
    }//GEN-LAST:event_HybridModify_btn_hsp5ClearActionPerformed

    private void HybridAdd_btn_clearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridAdd_btn_clearAllActionPerformed
        setPanelComponentsNull(Panel_HybridAdd);
    }//GEN-LAST:event_HybridAdd_btn_clearAllActionPerformed

    private void HybridModify_btn_editHNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridModify_btn_editHNameActionPerformed
        HybridModify_tb_HName.setEditable(true);
    }//GEN-LAST:event_HybridModify_btn_editHNameActionPerformed

    private void Notify_btn_setNotificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Notify_btn_setNotificationActionPerformed
        try{
            Connection con;
            con=ConnectTo.getConnection();
            String PName = Notify_tb_PName.getText();           
            if(!PName.isEmpty()){
                if(Notify_dtPicker_NDate.getDate() == null){
                    JOptionPane.showMessageDialog(null, "Please enter the date on which you want to be notified on...");
                }
                else{
                    Date today = Date.valueOf(LocalDate.now());
                    String Note = Notify_ta_Note.getText().trim();
                    java.sql.Date NDate = new java.sql.Date(Notify_dtPicker_NDate.getDate().getTime());
                    if(NDate.after(today) || NDate.equals(today)){
                        PreparedStatement ps = (PreparedStatement) con.prepareStatement
                            ("insert into notify values(?,?,?,?,?,?);");
                        ps.setString(1, Notify_tb_NID.getText());
                        ps.setString(2, (String)Notify_cmb_PID.getSelectedItem());
                        ps.setDate(3, today);
                        ps.setDate(4, NDate);
                        ps.setString(5, Note);
                        ps.setString(6, "Active");
                        int n = ps.executeUpdate();
                        if(n==1){
                            JOptionPane.showMessageDialog(null, "Notification scheduled successfully.");
                            setPanelComponentsNull(Panel_Notify);     
                            String ID = btnFunction.AddNew(Panel_Notify, Panel_Notify, "notify", "NID", 999, 4, "N");
                            Notify_tb_NID.setText(ID);
                        }
                        ps.close();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "The date on which you want to be notified\nshould be the upcoming one.");
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Select the plant to which you want to set the notification for.");
            }
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Notify_btn_setNotificationActionPerformed

    private void Sell_cmb_PNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sell_cmb_PNameActionPerformed
        Sell_tb_PName.setText((String)Sell_cmb_PName.getSelectedItem());
        String PName = (String)Sell_cmb_PName.getSelectedItem();
        try{
            Connection con;
            con = ConnectTo.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement
                ("select PID, P_SciName from plants_data where P_Name=?");
            ps.setString(1, PName);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String PID = rs.getString("PID");
                String PSciName = rs.getString("P_SciName");
                PreparedStatement ps1 = (PreparedStatement) con.prepareStatement
                    ("select Stock_ID, P_Quantity, P_Price from stock where PID=?");
                ps1.setString(1, PID);
                ResultSet rs1 = ps1.executeQuery();
                if(rs1.next()){
                    String stockID = rs1.getString("Stock_ID");
                    String PQuantity = rs1.getString("P_Quantity");
                    String PPrice = rs1.getString("P_Price");
                    Sell_tb_PID.setText(PID);
                    Sell_tb_stockID.setText(stockID);
                    Sell_tb_PSciname.setText(PSciName);
                    Sell_tb_PQuantity_Remaining.setText(PQuantity);
                    Sell_tb_PPrice.setText(PPrice);
                    Sell_tb_PQuantity_toSell.setText(null);
                }
                ps1.close();
                rs1.close();
            }
            ps.close();
            rs.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }//GEN-LAST:event_Sell_cmb_PNameActionPerformed

    private void Sell_btn_checkPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sell_btn_checkPriceActionPerformed
        try{
            String PID = Sell_tb_PID.getText();
            String PName = Sell_tb_PName.getText();
            String Quantity = Sell_tb_PQuantity_toSell.getText();
            String Price = Sell_tb_PPrice.getText();           
            if(!PID.isEmpty() && !Quantity.isEmpty()){
                if(Number.isNumber(Quantity)){
                    int q = Integer.parseInt(Quantity);
                    int p = Integer.parseInt(Price);
                    if(q>=0){
                        int totalPrice = q*p;
                        Sell_IP_lbl_dis_PID.setText(PID);
                        Sell_IP_lbl_dis_PName.setText(PName);
                        Sell_IP_lbl_dis_Quantity.setText(Quantity);
                        Sell_IP_lbl_dis_PricePerUnit.setText(Price);
                        Sell_IP_lbl_dis_totalPrice.setText(Integer.toString(totalPrice));
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Quantity to be sold should not be negative.");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Quantity should be a number.");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Required credentials are not specified.\n\n"
                        + "i) Select a plant\nii) Enter the quantity to sell");
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Sell_btn_checkPriceActionPerformed

    private void Settings_btn_updatePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Settings_btn_updatePasswordActionPerformed
        int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to update your password?");
        if(JOptionPane.YES_OPTION == result){
            int result1 = JOptionPane.showConfirmDialog(null,"You won't be able to access\nyour account with the previous password.\nSure to proceed?");
            if(JOptionPane.YES_OPTION == result1){
                try{
                    String username = top_lbl_username.getText();
                    String newPass = Arrays.toString(Settings_passFld_newPassword.getPassword());
                    String conPass = Arrays.toString(Settings_passFld_conPassword.getPassword());
                    if((newPass.equals(conPass))==true){                   
                        int len = newPass.length();
                        if(len>=24 && len<=48){
                            Connection con;
                            con = ConnectTo.getConnection();
                            PreparedStatement ps =(PreparedStatement) con.prepareStatement
                                ("update login set password = ? where username = ?;");
                            ps.setString(1,newPass);
                            ps.setString(2, username);
                            int n = ps.executeUpdate();
                            if(n==1){
                                JOptionPane.showMessageDialog(null,"Password updated successfully.");
                                Settings_passFld_newPassword.setText(null);
                                Settings_passFld_conPassword.setText(null);
                                Settings_btn_changePassword.setVisible(false);
                                Settings_btn_updateAccountDetails.setVisible(false);
                                Settings_btn_deleteAccount.setVisible(false);
                                makeSettingsPanelVisible(Settings_InsidePanel_3_enterPassword);
                            }
                            else{
                                Settings_passFld_newPassword.setText(null);
                                Settings_passFld_conPassword.setText(null);
                            }
                            con.close();
                            ps.close();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Password must be 8 to 16 characters long.");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Passwords don't match!");
                    }
                }
                catch(ClassNotFoundException | SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_Settings_btn_updatePasswordActionPerformed

    private void Settings_btn_updateDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Settings_btn_updateDetailsActionPerformed
        int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to update your credentials?");
        if(JOptionPane.YES_OPTION == result){
            int result1 = JOptionPane.showConfirmDialog(null,"You won't be able to use the\nprevious credentials in case of account recovery.\n\nSure to proceed?");
            if(JOptionPane.YES_OPTION == result1){
                try{
                    String username = top_lbl_username.getText();
                    String email = Settings_tb_email.getText();
                    String contact = Settings_tb_contact.getText();
                    String secAns = Settings_tb_secAns.getText();
                    if(verify.verifyEmail(email)){
                        if(verify.verifyContact(contact)){
                            try{
                                Connection con;
                                con = ConnectTo.getConnection();
                                PreparedStatement ps = (PreparedStatement) con.prepareStatement
                                    ("update login set email=?, contact=?, sec=? where username=?;");
                                ps.setString(1, email);
                                ps.setString(2, contact);
                                ps.setString(3, secAns);
                                ps.setString(4, username);
                                int n = ps.executeUpdate();
                                if(n==1){
                                    JOptionPane.showMessageDialog(null,"Credentials updated successfully.");
                                    Settings_tb_email.setText(null);
                                    Settings_tb_contact.setText(null);
                                    Settings_tb_secAns.setText(null);
                                    Settings_btn_changePassword.setVisible(false);
                                    Settings_btn_updateAccountDetails.setVisible(false);
                                    Settings_btn_deleteAccount.setVisible(false);
                                    makeSettingsPanelVisible(Settings_InsidePanel_3_enterPassword);
                                }
                                con.close();
                                ps.close();
                            }
                            catch(ClassNotFoundException | SQLException e){
                                JOptionPane.showMessageDialog(null, e);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Enter valid contact details!");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Enter valid email!");
                    }  
                }
                catch(HeadlessException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_Settings_btn_updateDetailsActionPerformed

    private void Notify_cmb_PIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Notify_cmb_PIDActionPerformed
        try{
            String PID = (String)Notify_cmb_PID.getSelectedItem();
            Connection con;
            con= ConnectTo.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement
               ("select P_Name, P_SciName, PTag1, PTag2, PTag3, PTag4, PTag5 from plants_data where PID=?");
            ps.setString(1, PID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String PName = rs.getString("P_Name");
                String PSciName = rs.getString("P_SciName");
                String PTag1 = rs.getString("PTag1");
                String PTag2 = rs.getString("PTag2");
                String PTag3 = rs.getString("PTag3");
                String PTag4 = rs.getString("PTag4");
                String PTag5 = rs.getString("PTag5");
                Notify_tb_PName.setText(PName);
                Notify_tb_PSciName.setText(PSciName);
                Notify_tb_PTag1.setText(PTag1);
                Notify_tb_PTag2.setText(PTag2);
                Notify_tb_PTag3.setText(PTag3);
                Notify_tb_PTag4.setText(PTag4);
                Notify_tb_PTag5.setText(PTag5);
            }
            ps.close();
            rs.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Notify_cmb_PIDActionPerformed

    private void Lists_btn_PlantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lists_btn_PlantsActionPerformed
        makeCheckboxPanelVisible(Lists_InsidePanel_checkboxNavigate);
        displayTable.all("plants_data", Lists_tbl_maintable, Lists_lbl_tblName, Lists_btn_Plants);
        makeListsBasePanelVisible(Lists_basePanel_Plants);
        allListsCheckboxUnselected();
    }//GEN-LAST:event_Lists_btn_PlantsActionPerformed

    private void Lists_btn_GardenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lists_btn_GardenActionPerformed
        makeCheckboxPanelVisible(Lists_InsidePanel_checkboxGarden);
        displayTable.all("garden", Lists_tbl_maintable, Lists_lbl_tblName, Lists_btn_Garden);
        makeListsBasePanelVisible(Lists_basePanel_Garden);
        allListsCheckboxUnselected();
    }//GEN-LAST:event_Lists_btn_GardenActionPerformed

    private void Lists_btn_HybridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lists_btn_HybridActionPerformed
        makeCheckboxPanelVisible(Lists_InsidePanel_checkboxHybrid);
        displayTable.all("hybrid", Lists_tbl_maintable, Lists_lbl_tblName, Lists_btn_Hybrid);
        makeListsBasePanelVisible(Lists_basePanel_Hybrid);
        allListsCheckboxUnselected();
    }//GEN-LAST:event_Lists_btn_HybridActionPerformed

    private void Lists_btn_NotifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lists_btn_NotifyActionPerformed
        makeCheckboxPanelVisible(Lists_InsidePanel_checkboxNotify);
        displayTable.all("notify", Lists_tbl_maintable, Lists_lbl_tblName, Lists_btn_Notify);
        makeListsBasePanelVisible(Lists_basePanel_Blank);
        allListsCheckboxUnselected();
    }//GEN-LAST:event_Lists_btn_NotifyActionPerformed

    private void Lists_btn_SoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lists_btn_SoldActionPerformed
        makeCheckboxPanelVisible(Lists_InsidePanel_checkboxSold);
        displayTable.all("sold", Lists_tbl_maintable, Lists_lbl_tblName, Lists_btn_Sold);
        makeListsBasePanelVisible(Lists_basePanel_Blank);
        allListsCheckboxUnselected();
    }//GEN-LAST:event_Lists_btn_SoldActionPerformed

    private void Lists_btn_StockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lists_btn_StockActionPerformed
        makeCheckboxPanelVisible(Lists_InsidePanel_checkboxStock);
        displayTable.all("stock", Lists_tbl_maintable, Lists_lbl_tblName, Lists_btn_Stock);
        makeListsBasePanelVisible(Lists_basePanel_Blank);
        allListsCheckboxUnselected();
    }//GEN-LAST:event_Lists_btn_StockActionPerformed

    private void Lists_tb_SearchBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Lists_tb_SearchBoxKeyReleased
        try{   
            String abc = Lists_tb_SearchBox.getText().trim();
            Lists_tbl_maintable.setVisible(true);
            if(!abc.isEmpty()){
                Connection con;
                con = ConnectTo.getConnection();
                if(Lists_rdbtn_SearchByPID.isSelected() || Lists_rdbtn_SearchByPtag.isSelected() || Lists_rdbtn_SearchByPName.isSelected()){
                    String TEorNot = checkEmpty.isTableEmpty("plants_data");
                    if(TEorNot.equals("notEmpty")){
                        if(Lists_rdbtn_SearchByPID.isSelected()){
                            displayTable.listCheck("plants_data", "PID", Lists_tbl_maintable, abc);
                        }
                        if(Lists_rdbtn_SearchByPName.isSelected()){
                            displayTable.listCheck("plants_data", "P_Name", Lists_tbl_maintable, abc);
                        }
                        if(Lists_rdbtn_SearchByPtag.isSelected()){                      
                            PreparedStatement ps = (PreparedStatement) con.prepareStatement
                                ("select * from plants_data where REGEXP_LIKE(Ptag1,\'"+abc+"\') || "
                                + "REGEXP_LIKE(Ptag2,\'"+abc+"\') || REGEXP_LIKE(Ptag3,\'"+abc+"\') || "
                                + "REGEXP_LIKE(Ptag4,\'"+abc+"\') || REGEXP_LIKE(Ptag5,\'"+abc+"\');");
                            ResultSet rs = ps.executeQuery();
                            displayTable.setSingle(Lists_tbl_maintable, rs);
                            ps.close();  
                            rs.close();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Plants table is empty!");
                    }
                }
                if(Lists_rdbtn_SearchByGID.isSelected() || Lists_rdbtn_SearchByGName.isSelected()){
                    String TEorNot = checkEmpty.isTableEmpty("garden");
                    if(TEorNot.equals("notEmpty")){
                        
                        if(Lists_rdbtn_SearchByGID.isSelected()){
                            displayTable.listCheck("garden", "GID", Lists_tbl_maintable, abc);
                        }
                        if(Lists_rdbtn_SearchByGName.isSelected()){
                            displayTable.listCheck("garden", "GName", Lists_tbl_maintable, abc);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Garden table is empty!");
                    }
                }
                if(Lists_rdbtn_SearchByHID.isSelected() || Lists_rdbtn_SearchByHybrid.isSelected()
                        || Lists_rdbtn_SearchByHName.isSelected()){
                    String TEorNot = checkEmpty.isTableEmpty("hybrid");
                    if(TEorNot.equals("notEmpty")){
                        if(Lists_rdbtn_SearchByHID.isSelected()){
                            displayTable.listCheck("hybrid", "HID", Lists_tbl_maintable, abc);
                        }
                        if(Lists_rdbtn_SearchByHName.isSelected()){
                            displayTable.listCheck("hybrid", "HName", Lists_tbl_maintable, abc);
                        }
                        if(Lists_rdbtn_SearchByHybrid.isSelected()){                      
                            PreparedStatement ps = (PreparedStatement) con.prepareStatement
                                ("select * from hybrid where REGEXP_LIKE(HSpecies1,\'"+abc+"\') || "
                                + "REGEXP_LIKE(HSpecies2,\'"+abc+"\') || REGEXP_LIKE(HSpecies3,\'"+abc+"\') || "
                                + "REGEXP_LIKE(HSpecies4,\'"+abc+"\') || REGEXP_LIKE(HSpecies5,\'"+abc+"\');");
                            ResultSet rs = ps.executeQuery();
                            displayTable.setSingle(Lists_tbl_maintable, rs);
                            ps.close();  
                            rs.close();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Hybrid table is empty!");
                    }
                }
                if(Lists_rdbtn_SearchByNID.isSelected() || Lists_rdbtn_SearchBynotifyPID.isSelected()
                        || Lists_rdbtn_SearchByEntryDate.isSelected() || Lists_rdbtn_SearchByNotificationDate.isSelected()){
                    String TEorNot = checkEmpty.isTableEmpty("notify");
                    if(TEorNot.equals("notEmpty")){
                        if(Lists_rdbtn_SearchByNID.isSelected()){
                            displayTable.listCheck("notify", "NID", Lists_tbl_maintable, abc);
                        }
                        if(Lists_rdbtn_SearchBynotifyPID.isSelected()){
                            displayTable.listCheck("notify", "PID", Lists_tbl_maintable, abc);
                        }
                        if(Lists_rdbtn_SearchByEntryDate.isSelected()){
                            displayTable.listCheck("notify", "N_entryDate", Lists_tbl_maintable, abc);
                        }
                        if(Lists_rdbtn_SearchByNotificationDate.isSelected()){
                            displayTable.listCheck("notify", "notifyOn", Lists_tbl_maintable, abc);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No notifications are set!");
                    }
                }
                if(Lists_rdbtn_SearchByPlantIssueID.isSelected() || Lists_rdbtn_SearchBysoldPID.isSelected()
                        || Lists_rdbtn_SearchByCustomerName.isSelected() || Lists_rdbtn_SearchBySellingDate.isSelected()){
                    String TEorNot = checkEmpty.isTableEmpty("sold");
                    if(TEorNot.equals("notEmpty")){
                        if(Lists_rdbtn_SearchByPlantIssueID.isSelected()){
                            displayTable.listCheck("sold", "Plant_Issue_ID", Lists_tbl_maintable, abc);
                        }
                        if(Lists_rdbtn_SearchBysoldPID.isSelected()){
                            displayTable.listCheck("sold", "PID", Lists_tbl_maintable, abc);
                        }
                        if(Lists_rdbtn_SearchByCustomerName.isSelected()){  
                            displayTable.listCheck("sold", "Cust_name", Lists_tbl_maintable, abc);
                        }
                        if(Lists_rdbtn_SearchBySellingDate.isSelected()){   
                            displayTable.listCheck("sold", "Plant_Issue_Date", Lists_tbl_maintable, abc);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No plant has been sold yet!");
                    }
                }
                if(Lists_rdbtn_SearchByStockID.isSelected() || Lists_rdbtn_SearchBystockPID.isSelected()
                        || Lists_rdbtn_SearchByPQuantity.isSelected() || Lists_rdbtn_SearchByPPrice.isSelected()){
                    String TEorNot = checkEmpty.isTableEmpty("stock");
                    if(TEorNot.equals("notEmpty")){
                        if(Lists_rdbtn_SearchByStockID.isSelected()){
                            displayTable.listCheck("stock", "Stock_ID", Lists_tbl_maintable, abc);
                        }
                        if(Lists_rdbtn_SearchBystockPID.isSelected()){
                            displayTable.listCheck("stock", "PID", Lists_tbl_maintable, abc);
                        }
                        if(Lists_rdbtn_SearchByPQuantity.isSelected()){                      
                            displayTable.listCheck("stock", "P_Quantity", Lists_tbl_maintable, abc);
                        }
                        if(Lists_rdbtn_SearchByPPrice.isSelected()){  
                            
                            displayTable.listCheck("stock", "P_Price", Lists_tbl_maintable, abc);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No plant have been entered!");
                    }
                }
                con.close();
            }
        }   
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Lists_tb_SearchBoxKeyReleased

    private void top_lbl_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_top_lbl_minimizeMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_top_lbl_minimizeMouseClicked

    private void top_lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_top_lbl_closeMouseClicked
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the application");
        if(result==JOptionPane.YES_OPTION){
            this.dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_top_lbl_closeMouseClicked

    private void top_btn_LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_top_btn_LogOutActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Do you really want to log out?", "Confirm", WIDTH);
        if(JOptionPane.YES_OPTION==result){
            this.dispose();
            LoginPanel out = new LoginPanel();
            out.setVisible(true);
        }
    }//GEN-LAST:event_top_btn_LogOutActionPerformed

    private void btn_RDto_ReportPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RDto_ReportPanelActionPerformed
        makePanelVisible(Panel_Report);
        makeColorPanelVisible(Left_colorPanel_Report);
        Report_tbl_maintable.setVisible(false);
        Report_lbl_tblName.setText(null);
        Report_insidePanel_Print.setVisible(false);       
        setPanelComponentsNull(Panel_Report);
    }//GEN-LAST:event_btn_RDto_ReportPanelActionPerformed

    private void Lists_basePanel_btn_GardenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lists_basePanel_btn_GardenActionPerformed
        try{
            String ID = displayTable.getClickedID(Lists_tbl_maintable);
            Connection con;
            con = ConnectTo.getConnection();
            try{
                PreparedStatement st = (PreparedStatement) con.prepareStatement
                    ("select * from garden where GID=?;");
                st.setString(1, ID);
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    Panel_Lists.setVisible(false);
                    Panel_Garden.setVisible(true);
                    makeColorPanelVisible(Left_colorPanel_Garden);
                    GardenSet(rs);
                }
                st.close();
                rs.close();            
            } 
            catch (SQLException ex) {
                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            }
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Lists_basePanel_btn_GardenActionPerformed

    private void Lists_basePanel_btn_PlantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lists_basePanel_btn_PlantActionPerformed
        try{
            String ID = displayTable.getClickedID(Lists_tbl_maintable);
            Connection con;
            con = ConnectTo.getConnection();
            try{
                PreparedStatement st = (PreparedStatement) con.prepareStatement
                    ("select * from plants_data where PID=?;");
                PreparedStatement st1 = (PreparedStatement) con.prepareStatement
                    ("select P_Quantity, P_Price from stock where PID=?;");
                st.setString(1, ID);
                st1.setString(1, ID);
                ResultSet rs = st.executeQuery();
                ResultSet rs1 = st1.executeQuery();
                if(rs.next() && rs1.next()){
                    Panel_Lists.setVisible(false);
                    Panel_Navigate.setVisible(true);
                    makeColorPanelVisible(Left_colorPanel_Navigate);
                    NavigateSet(rs, rs1);
                }
                st.close();
                st1.close();
                rs.close();
                rs1.close();            
            } 
            catch (SQLException ex) {
                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            }
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Lists_basePanel_btn_PlantActionPerformed

    private void Lists_basePanel_btn_HybridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lists_basePanel_btn_HybridActionPerformed
        try{
            String ID = displayTable.getClickedID(Lists_tbl_maintable);
            Connection con;
            con = ConnectTo.getConnection();
            try{
                PreparedStatement st = (PreparedStatement) con.prepareStatement
                    ("select * from hybrid where HID=?;");
                st.setString(1, ID);
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    Panel_Lists.setVisible(false);
                    Panel_Hybrid.setVisible(true);
                    makeColorPanelVisible(Left_colorPanel_Hybrid);
                    HybridSet(rs);
                }
                st.close();
                rs.close();            
            } 
            catch (SQLException ex) {
                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            }
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Lists_basePanel_btn_HybridActionPerformed

    private void Report_btn_StockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Report_btn_StockActionPerformed
        displayTable.all("stock", Report_tbl_maintable, Report_lbl_tblName, Report_btn_Stock);
        Report_insidePanel_Print.setVisible(true);
    }//GEN-LAST:event_Report_btn_StockActionPerformed

    private void Report_btn_SoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Report_btn_SoldActionPerformed
        displayTable.all("Sold", Report_tbl_maintable, Report_lbl_tblName, Report_btn_Sold);
        Report_insidePanel_Print.setVisible(true);
    }//GEN-LAST:event_Report_btn_SoldActionPerformed

    private void Report_btn_GardenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Report_btn_GardenActionPerformed
        displayTable.all("garden", Report_tbl_maintable, Report_lbl_tblName, Report_btn_Garden);
        Report_insidePanel_Print.setVisible(true);
    }//GEN-LAST:event_Report_btn_GardenActionPerformed

    private void Report_btn_PlantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Report_btn_PlantsActionPerformed
        displayTable.all("plants_data", Report_tbl_maintable, Report_lbl_tblName, Report_btn_Plants);
        Report_insidePanel_Print.setVisible(true);
    }//GEN-LAST:event_Report_btn_PlantsActionPerformed

    private void Report_btn_NotifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Report_btn_NotifyActionPerformed
        displayTable.all("notify", Report_tbl_maintable, Report_lbl_tblName, Report_btn_Notify);
        Report_insidePanel_Print.setVisible(true);
    }//GEN-LAST:event_Report_btn_NotifyActionPerformed

    private void Report_btn_HybridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Report_btn_HybridActionPerformed
        displayTable.all("hybrid", Report_tbl_maintable, Report_lbl_tblName, Report_btn_Hybrid);
        Report_insidePanel_Print.setVisible(true);
    }//GEN-LAST:event_Report_btn_HybridActionPerformed

    private void Report_basePanel_btn_printTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Report_basePanel_btn_printTableActionPerformed
        try {
            printThis.printComponent(Report_tbl_maintable);
        } 
        catch (PrinterException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Report_basePanel_btn_printTableActionPerformed

    private void Navigate_btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Navigate_btn_SearchActionPerformed
        String text = Navigate_tb_SearchBox.getText();
        if(text.isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter the PID!!!");
        }
        else {
            try{
                String TEorNot = checkEmpty.isTableEmpty("plants_data");
                if(TEorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "Table is empty.");
                }
                else{
                    String REorNot = checkEmpty.isRecordExist("plants_data", "PID", text);
                    if(REorNot.equals("notExists")){
                        JOptionPane.showMessageDialog(null, "This record does not exist.\nType in the exact PID");
                    }
                    else{                  
                        Connection con;
                        con = ConnectTo.getConnection();
                        PreparedStatement ps1 = (PreparedStatement) con.prepareStatement
                            ("select * from plants_data where PID = \""+text+"\";");
                        PreparedStatement ps2 = (PreparedStatement) con.prepareStatement
                            ("select P_Quantity, P_Price from stock where PID = \""+text+"\";");
                        ResultSet rs1 = ps1.executeQuery();
                        ResultSet rs2 = ps2.executeQuery();
                        if(rs1.next() && rs2.next()){
                            NavigateSet(rs1, rs2); 
                            Navigate_tb_SearchBox.setText(null);
                        }
                        ps2.close();
                        rs2.close();
                        ps1.close();
                        rs1.close();
                        con.close();                       
                    }
                }
            }
            catch(ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, e);             
            }
        }
    }//GEN-LAST:event_Navigate_btn_SearchActionPerformed

    private void Garden_btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Garden_btn_SearchActionPerformed
        String text = Garden_tb_SearchBox.getText();
        if(text.isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter the GID!!!");
        }
        else {
            try{
                String TEorNot = checkEmpty.isTableEmpty("garden");
                if(TEorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "Table is empty.");
                }
                else{
                    String REorNot = checkEmpty.isRecordExist("garden", "GID", text);
                    if(REorNot.equals("notExists")){
                        JOptionPane.showMessageDialog(null, "This record does not exist.\nType in the exact GID");
                    }
                    else{                  
                        Connection con;
                        con = ConnectTo.getConnection();
                        PreparedStatement ps1 = (PreparedStatement) con.prepareStatement
                            ("select * from garden where GID = \""+text+"\";");
                        ResultSet rs1 = ps1.executeQuery();
                        if(rs1.next()){
                            GardenSet(rs1); 
                            Garden_tb_SearchBox.setText(null);
                        }
                        ps1.close();
                        rs1.close();
                        con.close();                       
                    }
                }
            }
            catch(ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, e);             
            }
        }
    }//GEN-LAST:event_Garden_btn_SearchActionPerformed

    private void Hybrid_btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hybrid_btn_SearchActionPerformed
        String text = Hybrid_tb_SearchBox.getText();
        if(text.isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter the HID!!!");
        }
        else {
            try{
                String TEorNot = checkEmpty.isTableEmpty("hybrid");
                if(TEorNot.equals("Empty")){
                    JOptionPane.showMessageDialog(null, "Table is empty.");
                }
                else{
                    String REorNot = checkEmpty.isRecordExist("hybrid", "HID", text);
                    if(REorNot.equals("notExists")){
                        JOptionPane.showMessageDialog(null, "This record does not exist.\nType in the exact HID");
                    }
                    else{                  
                        Connection con;
                        con = ConnectTo.getConnection();
                        PreparedStatement ps1 = (PreparedStatement) con.prepareStatement
                            ("select * from hybrid where HID = \""+text+"\";");
                        ResultSet rs1 = ps1.executeQuery();
                        if(rs1.next()){
                            HybridSet(rs1); 
                            Hybrid_tb_SearchBox.setText(null);
                        }
                        ps1.close();
                        rs1.close();
                        con.close();                       
                    }
                }
            }
            catch(ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, e);             
            }
        }
    }//GEN-LAST:event_Hybrid_btn_SearchActionPerformed

    private void Report_btn_leastSoldplantFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Report_btn_leastSoldplantFromActionPerformed
        displayTable.top5("least", Report_dtPicker_Soldfrom, Report_dtPicker_Soldto, 
        Report_tbl_maintable, Report_lbl_tblName, Report_insidePanel_Print);
        ReportCode("least");
    }//GEN-LAST:event_Report_btn_leastSoldplantFromActionPerformed

    private void Report_btn_mostSoldplantFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Report_btn_mostSoldplantFromActionPerformed
        displayTable.top5("most", Report_dtPicker_Soldfrom, Report_dtPicker_Soldto, 
        Report_tbl_maintable, Report_lbl_tblName, Report_insidePanel_Print);
        ReportCode("most");
    }//GEN-LAST:event_Report_btn_mostSoldplantFromActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Operations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            String username = null;
            new Operations(username).setVisible(true);
        });      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BasePanelLeft;
    private javax.swing.JPanel BasePanelRight;
    private javax.swing.JPanel BasePanelTop;
    private javax.swing.JPanel GardenAdd_InsidePanel;
    private javax.swing.JScrollPane GardenAdd_ScrPane_GAddress;
    private javax.swing.JScrollPane GardenAdd_ScrPane_GNote;
    private keeptoo.KButton GardenAdd_btn_Add;
    private keeptoo.KButton GardenAdd_btn_RDto_Garden;
    private keeptoo.KButton GardenAdd_btn_clearAll;
    private org.jdesktop.swingx.JXDatePicker GardenAdd_dtPicker_GExpiry;
    private javax.swing.JLabel GardenAdd_lbl_GAddress;
    private javax.swing.JLabel GardenAdd_lbl_GExpiry;
    private javax.swing.JLabel GardenAdd_lbl_GID;
    private javax.swing.JLabel GardenAdd_lbl_GName;
    private javax.swing.JLabel GardenAdd_lbl_GNote;
    private javax.swing.JLabel GardenAdd_lbl_RDto_Garden;
    private javax.swing.JLabel GardenAdd_lbl_Return;
    private javax.swing.JLabel GardenAdd_lbl_bg;
    private javax.swing.JLabel GardenAdd_lbl_dateFormat;
    private javax.swing.JTextArea GardenAdd_ta_GAddress;
    private javax.swing.JTextArea GardenAdd_ta_GNote;
    private javax.swing.JTextField GardenAdd_tb_GID;
    private javax.swing.JTextField GardenAdd_tb_GName;
    private javax.swing.JPanel GardenModify_InsidePanel;
    private javax.swing.JScrollPane GardenModify_ScrPane_GAddress;
    private javax.swing.JScrollPane GardenModify_ScrPane_GNote;
    private keeptoo.KButton GardenModify_btn_RDto_Garden;
    private keeptoo.KButton GardenModify_btn_Update;
    private keeptoo.KButton GardenModify_btn_editGName;
    private org.jdesktop.swingx.JXDatePicker GardenModify_dtPicker_GExpiry;
    private javax.swing.JLabel GardenModify_lbl_GAddress;
    private javax.swing.JLabel GardenModify_lbl_GExpiry;
    private javax.swing.JLabel GardenModify_lbl_GID;
    private javax.swing.JLabel GardenModify_lbl_GName;
    private javax.swing.JLabel GardenModify_lbl_GNote;
    private javax.swing.JLabel GardenModify_lbl_RDto_Garden;
    private javax.swing.JLabel GardenModify_lbl_Return;
    private javax.swing.JLabel GardenModify_lbl_bg;
    private javax.swing.JLabel GardenModify_lbl_dateFormat;
    private javax.swing.JTextArea GardenModify_ta_GAddress;
    private javax.swing.JTextArea GardenModify_ta_GNote;
    private javax.swing.JTextField GardenModify_tb_GID;
    private javax.swing.JTextField GardenModify_tb_GName;
    private javax.swing.JPanel Garden_InsidePanel;
    private javax.swing.JPanel Garden_InsidePanel_2;
    private javax.swing.JPanel Garden_InsidePanel_3;
    private javax.swing.JScrollPane Garden_ScrPane_GAddress;
    private javax.swing.JScrollPane Garden_ScrPane_GNote;
    private javax.swing.JLabel Garden_btnIcon_First;
    private javax.swing.JLabel Garden_btnIcon_Last;
    private javax.swing.JLabel Garden_btnIcon_Next;
    private javax.swing.JLabel Garden_btnIcon_Previous;
    private keeptoo.KButton Garden_btn_AddNew;
    private keeptoo.KButton Garden_btn_Delete;
    private keeptoo.KButton Garden_btn_First;
    private keeptoo.KButton Garden_btn_Last;
    private keeptoo.KButton Garden_btn_Modify;
    private keeptoo.KButton Garden_btn_Next;
    private keeptoo.KButton Garden_btn_Previous;
    private keeptoo.KButton Garden_btn_Search;
    private javax.swing.JLabel Garden_lbl_Count;
    private javax.swing.JLabel Garden_lbl_GAddress;
    private javax.swing.JLabel Garden_lbl_GExpires;
    private javax.swing.JLabel Garden_lbl_GID;
    private javax.swing.JLabel Garden_lbl_GName;
    private javax.swing.JLabel Garden_lbl_GNote;
    private javax.swing.JLabel Garden_lbl_Search;
    private javax.swing.JLabel Garden_lbl_bg;
    private javax.swing.JLabel Garden_lbl_dateFormat;
    private javax.swing.JLabel Garden_lbl_first;
    private javax.swing.JLabel Garden_lbl_last;
    private javax.swing.JLabel Garden_lbl_next;
    private javax.swing.JLabel Garden_lbl_previous;
    private javax.swing.JTextArea Garden_ta_GAddress;
    private javax.swing.JTextArea Garden_ta_GNote;
    private javax.swing.JTextField Garden_tb_GExpiry;
    private javax.swing.JTextField Garden_tb_GID;
    private javax.swing.JTextField Garden_tb_GName;
    private javax.swing.JTextField Garden_tb_SearchBox;
    private javax.swing.JPanel HybridAdd_InsidePanel;
    private javax.swing.JScrollPane HybridAdd_ScrPane_HNote;
    private keeptoo.KButton HybridAdd_btn_Add;
    private keeptoo.KButton HybridAdd_btn_RDto_Hybrid;
    private keeptoo.KButton HybridAdd_btn_clearAll;
    private keeptoo.KButton HybridAdd_btn_hsp1Clear;
    private keeptoo.KButton HybridAdd_btn_hsp2Clear;
    private keeptoo.KButton HybridAdd_btn_hsp3Clear;
    private keeptoo.KButton HybridAdd_btn_hsp4Clear;
    private keeptoo.KButton HybridAdd_btn_hsp5Clear;
    private javax.swing.JComboBox<String> HybridAdd_cmb_HSpecies1;
    private javax.swing.JComboBox<String> HybridAdd_cmb_HSpecies2;
    private javax.swing.JComboBox<String> HybridAdd_cmb_HSpecies3;
    private javax.swing.JComboBox<String> HybridAdd_cmb_HSpecies4;
    private javax.swing.JComboBox<String> HybridAdd_cmb_HSpecies5;
    private org.jdesktop.swingx.JXDatePicker HybridAdd_dtPicker_HDate;
    private javax.swing.JLabel HybridAdd_lbl_HDate;
    private javax.swing.JLabel HybridAdd_lbl_HID;
    private javax.swing.JLabel HybridAdd_lbl_HName;
    private javax.swing.JLabel HybridAdd_lbl_HNote;
    private javax.swing.JLabel HybridAdd_lbl_HSpecies;
    private javax.swing.JLabel HybridAdd_lbl_RDto_Hybrid;
    private javax.swing.JLabel HybridAdd_lbl_Return;
    private javax.swing.JTextArea HybridAdd_ta_HNote;
    private javax.swing.JTextField HybridAdd_tb_HID;
    private javax.swing.JTextField HybridAdd_tb_HName;
    private javax.swing.JTextField HybridAdd_tb_HSpecies1;
    private javax.swing.JTextField HybridAdd_tb_HSpecies2;
    private javax.swing.JTextField HybridAdd_tb_HSpecies3;
    private javax.swing.JTextField HybridAdd_tb_HSpecies4;
    private javax.swing.JTextField HybridAdd_tb_HSpecies5;
    private javax.swing.JPanel HybridModify_InsidePanel;
    private javax.swing.JScrollPane HybridModify_ScrPane_HNote;
    private keeptoo.KButton HybridModify_btn_RDto_Hybrid;
    private keeptoo.KButton HybridModify_btn_Update;
    private keeptoo.KButton HybridModify_btn_editHName;
    private keeptoo.KButton HybridModify_btn_hsp1Clear;
    private keeptoo.KButton HybridModify_btn_hsp2Clear;
    private keeptoo.KButton HybridModify_btn_hsp3Clear;
    private keeptoo.KButton HybridModify_btn_hsp4Clear;
    private keeptoo.KButton HybridModify_btn_hsp5Clear;
    private javax.swing.JComboBox<String> HybridModify_cmb_HSpecies1;
    private javax.swing.JComboBox<String> HybridModify_cmb_HSpecies2;
    private javax.swing.JComboBox<String> HybridModify_cmb_HSpecies3;
    private javax.swing.JComboBox<String> HybridModify_cmb_HSpecies4;
    private javax.swing.JComboBox<String> HybridModify_cmb_HSpecies5;
    private org.jdesktop.swingx.JXDatePicker HybridModify_dtPicker_HDate;
    private javax.swing.JLabel HybridModify_lbl_HDate;
    private javax.swing.JLabel HybridModify_lbl_HID;
    private javax.swing.JLabel HybridModify_lbl_HName;
    private javax.swing.JLabel HybridModify_lbl_HNote;
    private javax.swing.JLabel HybridModify_lbl_HSpecies;
    private javax.swing.JLabel HybridModify_lbl_RDto_Hybrid;
    private javax.swing.JLabel HybridModify_lbl_Return;
    private javax.swing.JTextArea HybridModify_ta_HNote;
    private javax.swing.JTextField HybridModify_tb_HID;
    private javax.swing.JTextField HybridModify_tb_HName;
    private javax.swing.JTextField HybridModify_tb_HSpecies1;
    private javax.swing.JTextField HybridModify_tb_HSpecies2;
    private javax.swing.JTextField HybridModify_tb_HSpecies3;
    private javax.swing.JTextField HybridModify_tb_HSpecies4;
    private javax.swing.JTextField HybridModify_tb_HSpecies5;
    private javax.swing.JPanel Hybrid_InsidePanel;
    private javax.swing.JPanel Hybrid_InsidePanel_2;
    private javax.swing.JPanel Hybrid_InsidePanel_3;
    private javax.swing.JScrollPane Hybrid_ScrPane_HNote;
    private javax.swing.JLabel Hybrid_btnIcon_First;
    private javax.swing.JLabel Hybrid_btnIcon_Last;
    private javax.swing.JLabel Hybrid_btnIcon_Next;
    private javax.swing.JLabel Hybrid_btnIcon_Previous;
    private keeptoo.KButton Hybrid_btn_AddNew;
    private keeptoo.KButton Hybrid_btn_Delete;
    private keeptoo.KButton Hybrid_btn_First;
    private keeptoo.KButton Hybrid_btn_Last;
    private keeptoo.KButton Hybrid_btn_Modify;
    private keeptoo.KButton Hybrid_btn_Next;
    private keeptoo.KButton Hybrid_btn_Previous;
    private keeptoo.KButton Hybrid_btn_Search;
    private javax.swing.JLabel Hybrid_lbl_Count;
    private javax.swing.JLabel Hybrid_lbl_HID;
    private javax.swing.JLabel Hybrid_lbl_HName;
    private javax.swing.JLabel Hybrid_lbl_HNote;
    private javax.swing.JLabel Hybrid_lbl_HSpecies;
    private javax.swing.JLabel Hybrid_lbl_Hdate;
    private javax.swing.JLabel Hybrid_lbl_Search;
    private javax.swing.JLabel Hybrid_lbl_first;
    private javax.swing.JLabel Hybrid_lbl_last;
    private javax.swing.JLabel Hybrid_lbl_next;
    private javax.swing.JLabel Hybrid_lbl_previous;
    private javax.swing.JTextArea Hybrid_ta_HNote;
    private javax.swing.JTextField Hybrid_tb_HDate;
    private javax.swing.JTextField Hybrid_tb_HID;
    private javax.swing.JTextField Hybrid_tb_HName;
    private javax.swing.JTextField Hybrid_tb_HSpecies1;
    private javax.swing.JTextField Hybrid_tb_HSpecies2;
    private javax.swing.JTextField Hybrid_tb_HSpecies3;
    private javax.swing.JTextField Hybrid_tb_HSpecies4;
    private javax.swing.JTextField Hybrid_tb_HSpecies5;
    private javax.swing.JTextField Hybrid_tb_SearchBox;
    private javax.swing.JPanel Left_InsidePanel_1;
    private javax.swing.JPanel Left_InsidePanel_2;
    private javax.swing.JPanel Left_colorPanel_Garden;
    private javax.swing.JLabel Left_colorPanel_Garden_lblIcon;
    private javax.swing.JPanel Left_colorPanel_Hybrid;
    private javax.swing.JLabel Left_colorPanel_Hybrid_lblIcon;
    private javax.swing.JPanel Left_colorPanel_Lists;
    private javax.swing.JLabel Left_colorPanel_Lists_lblIcon;
    private javax.swing.JPanel Left_colorPanel_Navigate;
    private javax.swing.JLabel Left_colorPanel_Navigate_lblIcon;
    private javax.swing.JPanel Left_colorPanel_Notify;
    private javax.swing.JLabel Left_colorPanel_Notify_lblIcon;
    private javax.swing.JPanel Left_colorPanel_Report;
    private javax.swing.JLabel Left_colorPanel_Report_lblIcon;
    private javax.swing.JPanel Left_colorPanel_Sell;
    private javax.swing.JLabel Left_colorPanel_Sell_lblIcon;
    private javax.swing.JPanel Left_colorPanel_Settings;
    private javax.swing.JLabel Left_colorPanel_Settings_lblIcon;
    private javax.swing.JPanel Lists_InsidePanel;
    private javax.swing.JPanel Lists_InsidePanel_basePanel;
    private javax.swing.JPanel Lists_InsidePanel_checkboxBlank;
    private javax.swing.JPanel Lists_InsidePanel_checkboxGarden;
    private javax.swing.JPanel Lists_InsidePanel_checkboxHybrid;
    private javax.swing.JPanel Lists_InsidePanel_checkboxNavigate;
    private javax.swing.JPanel Lists_InsidePanel_checkboxNotify;
    private javax.swing.JPanel Lists_InsidePanel_checkboxPanel;
    private javax.swing.JPanel Lists_InsidePanel_checkboxSold;
    private javax.swing.JPanel Lists_InsidePanel_checkboxStock;
    private javax.swing.JPanel Lists_InsidePanel_tablePanel;
    private javax.swing.JScrollPane Lists_ScrPane_mainTable;
    private javax.swing.JPanel Lists_basePanel_Blank;
    private javax.swing.JPanel Lists_basePanel_Garden;
    private javax.swing.JPanel Lists_basePanel_Hybrid;
    private javax.swing.JPanel Lists_basePanel_Plants;
    private keeptoo.KButton Lists_basePanel_btn_Garden;
    private keeptoo.KButton Lists_basePanel_btn_Hybrid;
    private keeptoo.KButton Lists_basePanel_btn_Plant;
    private keeptoo.KButton Lists_btn_Garden;
    private keeptoo.KButton Lists_btn_Hybrid;
    private keeptoo.KButton Lists_btn_Notify;
    private keeptoo.KButton Lists_btn_Plants;
    private keeptoo.KButton Lists_btn_Sold;
    private keeptoo.KButton Lists_btn_Stock;
    private javax.swing.JLabel Lists_lbl_Search;
    private javax.swing.JLabel Lists_lbl_bg;
    private javax.swing.JLabel Lists_lbl_tblName;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByCustomerName;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByEntryDate;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByGID;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByGName;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByHID;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByHName;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByHybrid;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByNID;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByNotificationDate;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByPID;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByPName;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByPPrice;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByPQuantity;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByPlantIssueID;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByPtag;
    private javax.swing.JRadioButton Lists_rdbtn_SearchBySellingDate;
    private javax.swing.JRadioButton Lists_rdbtn_SearchByStockID;
    private javax.swing.JRadioButton Lists_rdbtn_SearchBynotifyPID;
    private javax.swing.JRadioButton Lists_rdbtn_SearchBysoldPID;
    private javax.swing.JRadioButton Lists_rdbtn_SearchBystockPID;
    private javax.swing.JTextField Lists_tb_SearchBox;
    private javax.swing.JTable Lists_tbl_maintable;
    private javax.swing.JPanel NavigateAdd_InsidePanel;
    private javax.swing.JScrollPane NavigateAdd_ScrPane_PNote;
    private keeptoo.KButton NavigateAdd_btn_Add;
    private keeptoo.KButton NavigateAdd_btn_RDto_Navigate;
    private keeptoo.KButton NavigateAdd_btn_clearAll;
    private javax.swing.JComboBox<String> NavigateAdd_cmb_PABP;
    private javax.swing.JLabel NavigateAdd_lbl_Experimented;
    private javax.swing.JLabel NavigateAdd_lbl_PABP;
    private javax.swing.JLabel NavigateAdd_lbl_PID;
    private javax.swing.JLabel NavigateAdd_lbl_PName;
    private javax.swing.JLabel NavigateAdd_lbl_PNote;
    private javax.swing.JLabel NavigateAdd_lbl_PPrice;
    private javax.swing.JLabel NavigateAdd_lbl_PQuantity;
    private javax.swing.JLabel NavigateAdd_lbl_PSciName;
    private javax.swing.JLabel NavigateAdd_lbl_PTags;
    private javax.swing.JLabel NavigateAdd_lbl_RDto_Navigate;
    private javax.swing.JLabel NavigateAdd_lbl_Return;
    private javax.swing.JLabel NavigateAdd_lbl_bg;
    private javax.swing.JRadioButton NavigateAdd_rdbtn_ExpNo;
    private javax.swing.JRadioButton NavigateAdd_rdbtn_ExpYes;
    private javax.swing.JTextArea NavigateAdd_ta_PNote;
    private javax.swing.JTextField NavigateAdd_tb_PABP;
    private javax.swing.JTextField NavigateAdd_tb_PID;
    private javax.swing.JTextField NavigateAdd_tb_PName;
    private javax.swing.JTextField NavigateAdd_tb_PPrice;
    private javax.swing.JTextField NavigateAdd_tb_PQuantity;
    private javax.swing.JTextField NavigateAdd_tb_PSciName;
    private javax.swing.JTextField NavigateAdd_tb_PTag1;
    private javax.swing.JTextField NavigateAdd_tb_PTag2;
    private javax.swing.JTextField NavigateAdd_tb_PTag3;
    private javax.swing.JTextField NavigateAdd_tb_PTag4;
    private javax.swing.JTextField NavigateAdd_tb_PTag5;
    private javax.swing.JPanel NavigateModify_InsidePanel;
    private javax.swing.JScrollPane NavigateModify_ScrPane_PNote;
    private keeptoo.KButton NavigateModify_btn_EditPName;
    private keeptoo.KButton NavigateModify_btn_EditPSciName;
    private keeptoo.KButton NavigateModify_btn_RDto_Navigate;
    private keeptoo.KButton NavigateModify_btn_Update;
    private javax.swing.JComboBox<String> NavigateModify_cmb_PABP;
    private javax.swing.JLabel NavigateModify_lbl_Experimented;
    private javax.swing.JLabel NavigateModify_lbl_PABP;
    private javax.swing.JLabel NavigateModify_lbl_PID;
    private javax.swing.JLabel NavigateModify_lbl_PName;
    private javax.swing.JLabel NavigateModify_lbl_PNote;
    private javax.swing.JLabel NavigateModify_lbl_PPrice;
    private javax.swing.JLabel NavigateModify_lbl_PQuantity;
    private javax.swing.JLabel NavigateModify_lbl_PSciName;
    private javax.swing.JLabel NavigateModify_lbl_PTags;
    private javax.swing.JLabel NavigateModify_lbl_RDto_Navigate;
    private javax.swing.JLabel NavigateModify_lbl_Return;
    private javax.swing.JLabel NavigateModify_lbl_bg;
    private javax.swing.JRadioButton NavigateModify_rdbtn_ExpNo;
    private javax.swing.JRadioButton NavigateModify_rdbtn_ExpYes;
    private javax.swing.JTextArea NavigateModify_ta_PNote;
    private javax.swing.JTextField NavigateModify_tb_PABP;
    private javax.swing.JTextField NavigateModify_tb_PID;
    private javax.swing.JTextField NavigateModify_tb_PName;
    private javax.swing.JTextField NavigateModify_tb_PPrice;
    private javax.swing.JTextField NavigateModify_tb_PQuantity;
    private javax.swing.JTextField NavigateModify_tb_PSciName;
    private javax.swing.JTextField NavigateModify_tb_PTag1;
    private javax.swing.JTextField NavigateModify_tb_PTag2;
    private javax.swing.JTextField NavigateModify_tb_PTag3;
    private javax.swing.JTextField NavigateModify_tb_PTag4;
    private javax.swing.JTextField NavigateModify_tb_PTag5;
    private javax.swing.JPanel Navigate_InsidePanel;
    private javax.swing.JPanel Navigate_InsidePanel_2;
    private javax.swing.JPanel Navigate_InsidePanel_3;
    private javax.swing.JScrollPane Navigate_ScrPane_PNote;
    private javax.swing.JLabel Navigate_btnIcon_First;
    private javax.swing.JLabel Navigate_btnIcon_Last;
    private javax.swing.JLabel Navigate_btnIcon_Next;
    private javax.swing.JLabel Navigate_btnIcon_Previous;
    private keeptoo.KButton Navigate_btn_AddNew;
    private keeptoo.KButton Navigate_btn_Delete;
    private keeptoo.KButton Navigate_btn_First;
    private keeptoo.KButton Navigate_btn_Last;
    private keeptoo.KButton Navigate_btn_Modify;
    private keeptoo.KButton Navigate_btn_Next;
    private keeptoo.KButton Navigate_btn_Previous;
    private keeptoo.KButton Navigate_btn_Search;
    private javax.swing.JLabel Navigate_lbl_Count;
    private javax.swing.JLabel Navigate_lbl_Experimented;
    private javax.swing.JLabel Navigate_lbl_PABP;
    private javax.swing.JLabel Navigate_lbl_PID;
    private javax.swing.JLabel Navigate_lbl_PName;
    private javax.swing.JLabel Navigate_lbl_PNote;
    private javax.swing.JLabel Navigate_lbl_PPrice;
    private javax.swing.JLabel Navigate_lbl_PQuantity;
    private javax.swing.JLabel Navigate_lbl_PSciName;
    private javax.swing.JLabel Navigate_lbl_PTags;
    private javax.swing.JLabel Navigate_lbl_Search;
    private javax.swing.JLabel Navigate_lbl_bg;
    private javax.swing.JLabel Navigate_lbl_first;
    private javax.swing.JLabel Navigate_lbl_last;
    private javax.swing.JLabel Navigate_lbl_next;
    private javax.swing.JLabel Navigate_lbl_previous;
    private javax.swing.JTextArea Navigate_ta_PNote;
    private javax.swing.JTextField Navigate_tb_PABP;
    private javax.swing.JTextField Navigate_tb_PExp;
    private javax.swing.JTextField Navigate_tb_PID;
    private javax.swing.JTextField Navigate_tb_PName;
    private javax.swing.JTextField Navigate_tb_PPrice;
    private javax.swing.JTextField Navigate_tb_PQuantity;
    private javax.swing.JTextField Navigate_tb_PSciName;
    private javax.swing.JTextField Navigate_tb_Ptag1;
    private javax.swing.JTextField Navigate_tb_Ptag2;
    private javax.swing.JTextField Navigate_tb_Ptag3;
    private javax.swing.JTextField Navigate_tb_Ptag4;
    private javax.swing.JTextField Navigate_tb_Ptag5;
    private javax.swing.JTextField Navigate_tb_SearchBox;
    private javax.swing.JPanel Notify_InsidePanel;
    private javax.swing.JScrollPane Notify_ScrPane_Note;
    private keeptoo.KButton Notify_btn_setNotification;
    private javax.swing.JComboBox<String> Notify_cmb_PID;
    private org.jdesktop.swingx.JXDatePicker Notify_dtPicker_NDate;
    private javax.swing.JLabel Notify_lbl_NDate;
    private javax.swing.JLabel Notify_lbl_NID;
    private javax.swing.JLabel Notify_lbl_Note;
    private javax.swing.JLabel Notify_lbl_PID;
    private javax.swing.JLabel Notify_lbl_PName;
    private javax.swing.JLabel Notify_lbl_PQuantity;
    private javax.swing.JLabel Notify_lbl_PSciName;
    private javax.swing.JTextArea Notify_ta_Note;
    private javax.swing.JTextField Notify_tb_NID;
    private javax.swing.JTextField Notify_tb_PName;
    private javax.swing.JTextField Notify_tb_PSciName;
    private javax.swing.JTextField Notify_tb_PTag1;
    private javax.swing.JTextField Notify_tb_PTag2;
    private javax.swing.JTextField Notify_tb_PTag3;
    private javax.swing.JTextField Notify_tb_PTag4;
    private javax.swing.JTextField Notify_tb_PTag5;
    private javax.swing.JLabel PanelHybridAdd_lbl_bg;
    private javax.swing.JLabel PanelHybridModify_lbl_bg;
    private javax.swing.JLabel PanelHybrid_lbl_bg;
    private javax.swing.JLabel PanelNotify_lbl_bg;
    private javax.swing.JLabel PanelReport_lbl_bg;
    private javax.swing.JLabel PanelSell_lbl_bg;
    private javax.swing.JLabel PanelSetting_lbl_bg;
    private javax.swing.JLabel PanelTop_lbl_bg;
    private javax.swing.JPanel Panel_Garden;
    private javax.swing.JPanel Panel_GardenAdd;
    private javax.swing.JPanel Panel_GardenModify;
    private javax.swing.JPanel Panel_Hybrid;
    private javax.swing.JPanel Panel_HybridAdd;
    private javax.swing.JPanel Panel_HybridModify;
    private javax.swing.JPanel Panel_Lists;
    private javax.swing.JPanel Panel_Navigate;
    private javax.swing.JPanel Panel_NavigateAdd;
    private javax.swing.JPanel Panel_NavigateModify;
    private javax.swing.JPanel Panel_Notify;
    private javax.swing.JPanel Panel_Report;
    private javax.swing.JPanel Panel_Sell;
    private javax.swing.JPanel Panel_Settings;
    private javax.swing.JPanel Panel_Start;
    private javax.swing.JPanel Panel_Top;
    private javax.swing.JPanel Report_InsidePanel;
    private javax.swing.JPanel Report_InsidePanel_functionsPanel;
    private javax.swing.JPanel Report_InsidePanel_tablePanel;
    private javax.swing.JScrollPane Report_ScrPane_mainTable;
    private keeptoo.KButton Report_basePanel_btn_printTable;
    private keeptoo.KButton Report_btn_Garden;
    private keeptoo.KButton Report_btn_Hybrid;
    private keeptoo.KButton Report_btn_Notify;
    private keeptoo.KButton Report_btn_Plants;
    private keeptoo.KButton Report_btn_Sold;
    private keeptoo.KButton Report_btn_Stock;
    private keeptoo.KButton Report_btn_leastSoldplantFrom;
    private keeptoo.KButton Report_btn_mostSoldplantFrom;
    private org.jdesktop.swingx.JXDatePicker Report_dtPicker_Soldfrom;
    private org.jdesktop.swingx.JXDatePicker Report_dtPicker_Soldto;
    private javax.swing.JPanel Report_insidePanel_Print;
    private javax.swing.JLabel Report_lbl_tblName;
    private javax.swing.JTable Report_tbl_maintable;
    private javax.swing.JLabel Sell_IP_lbl_PID;
    private javax.swing.JLabel Sell_IP_lbl_PName;
    private javax.swing.JLabel Sell_IP_lbl_PricePerUnit;
    private javax.swing.JLabel Sell_IP_lbl_QuantitytoSell;
    private javax.swing.JLabel Sell_IP_lbl_dis_PID;
    private javax.swing.JLabel Sell_IP_lbl_dis_PName;
    private javax.swing.JLabel Sell_IP_lbl_dis_PricePerUnit;
    private javax.swing.JLabel Sell_IP_lbl_dis_Quantity;
    private javax.swing.JLabel Sell_IP_lbl_dis_totalPrice;
    private javax.swing.JLabel Sell_IP_lbl_totalPrice;
    private javax.swing.JPanel Sell_InsidePanel;
    private javax.swing.JPanel Sell_InsidePanel_2;
    private keeptoo.KButton Sell_btn_Confirm;
    private keeptoo.KButton Sell_btn_checkPrice;
    private javax.swing.JComboBox<String> Sell_cmb_PName;
    private javax.swing.JLabel Sell_lbl_PID;
    private javax.swing.JLabel Sell_lbl_PName;
    private javax.swing.JLabel Sell_lbl_PPrice;
    private javax.swing.JLabel Sell_lbl_PQuantity_Remaining;
    private javax.swing.JLabel Sell_lbl_PQuantity_toSell;
    private javax.swing.JLabel Sell_lbl_PSciname;
    private javax.swing.JLabel Sell_lbl_custContact;
    private javax.swing.JLabel Sell_lbl_custName;
    private javax.swing.JLabel Sell_lbl_issueDate;
    private javax.swing.JLabel Sell_lbl_issueID;
    private javax.swing.JTextField Sell_tb_PID;
    private javax.swing.JTextField Sell_tb_PName;
    private javax.swing.JTextField Sell_tb_PPrice;
    private javax.swing.JTextField Sell_tb_PQuantity_Remaining;
    private javax.swing.JTextField Sell_tb_PQuantity_toSell;
    private javax.swing.JTextField Sell_tb_PSciname;
    private javax.swing.JTextField Sell_tb_SID;
    private javax.swing.JTextField Sell_tb_custContact;
    private javax.swing.JTextField Sell_tb_custName;
    private javax.swing.JTextField Sell_tb_issueDate;
    private javax.swing.JTextField Sell_tb_stockID;
    private javax.swing.JPanel Settings_InsidePanel;
    private javax.swing.JLabel Settings_InsidePanel_1;
    private javax.swing.JPanel Settings_InsidePanel_2;
    private keeptoo.KGradientPanel Settings_InsidePanel_3_enterPassword;
    private keeptoo.KGradientPanel Settings_InsidePanel_3_updateDetails;
    private keeptoo.KGradientPanel Settings_InsidePanel_3_updatePassword;
    private keeptoo.KButton Settings_btn_Proceed;
    private keeptoo.KButton Settings_btn_changePassword;
    private keeptoo.KButton Settings_btn_deleteAccount;
    private keeptoo.KButton Settings_btn_updateAccountDetails;
    private keeptoo.KButton Settings_btn_updateDetails;
    private keeptoo.KButton Settings_btn_updatePassword;
    private javax.swing.JLabel Settings_lbl_conPass;
    private javax.swing.JLabel Settings_lbl_contact;
    private javax.swing.JLabel Settings_lbl_currPass;
    private javax.swing.JLabel Settings_lbl_email;
    private javax.swing.JLabel Settings_lbl_newPass;
    private javax.swing.JLabel Settings_lbl_place;
    private javax.swing.JLabel Settings_lbl_secAns;
    private javax.swing.JPasswordField Settings_passFld_conPassword;
    private javax.swing.JPasswordField Settings_passFld_currentPassword;
    private javax.swing.JPasswordField Settings_passFld_newPassword;
    private javax.swing.JTextField Settings_tb_contact;
    private javax.swing.JTextField Settings_tb_email;
    private javax.swing.JTextField Settings_tb_secAns;
    private javax.swing.JPanel Start_InsidePanel;
    private javax.swing.JLabel Start_lbl_bg;
    private keeptoo.KButton btn_RDto_GardenPanel;
    private keeptoo.KButton btn_RDto_HybridPanel;
    private keeptoo.KButton btn_RDto_ListsPanel;
    private keeptoo.KButton btn_RDto_NavigatePanel;
    private keeptoo.KButton btn_RDto_NotifyPanel;
    private keeptoo.KButton btn_RDto_ReportPanel;
    private keeptoo.KButton btn_RDto_SellPanel;
    private keeptoo.KButton btn_RDto_SettingsPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel left_lbl_bg;
    private keeptoo.KButton top_btn_LogOut;
    private javax.swing.JLabel top_lbl_close;
    private javax.swing.JLabel top_lbl_minimize;
    private javax.swing.JLabel top_lbl_username;
    // End of variables declaration//GEN-END:variables
}