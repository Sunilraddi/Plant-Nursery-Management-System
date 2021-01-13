package Login_package;

import plantshop8.verify;
import Operations_package.Operations;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import plantshop8.ConnectTo;
import plantshop8.myNotification;

/**
 *
 * @author Akash Pawar
 */

public class LoginPanel extends javax.swing.JFrame {  
    public LoginPanel() {     
        this.setUndecorated(true);
        initComponents();
        
        in1.setBackground(new Color(50, 50, 50, 150));
        up1.setBackground(new Color(50, 50, 50, 150));
        forgot1.setBackground(new Color(50, 50, 50, 150));
        change1.setBackground(new Color(50, 50, 50, 150));
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);   //jframe to center
        setResizable(false); 
    }
    
    void setPanelVisible(JPanel panel){
        forgotPanel.setVisible(false);
        in.setVisible(false);
        up.setVisible(false);
        changePanel.setVisible(false);     
        panel.setVisible(true);
    }
    void setForgetPanelComponentsNull(){
        forgot_tb_username.setText(null);
        forgot_tb_email.setText(null);
        forgot_tb_contact.setText(null);
        forgot_tb_secQue.setText(null);
    }
    void setUpPanelComponentsNull(){
        up_tb_newuser.setText(null);
        up_passFld_newpass.setText(null);
        up_passFld_conpass.setText(null);
        up_tb_email.setText(null);
        up_tb_contact.setText(null);
        up_tb_secQue.setText(null);
    }
    void setInPanelComponentsNull(){
        in_tb_username.setText(null);
        in_passFld_password.setText(null);
    }
    void setChangePanelComponentsNull(){
        change_passFld_newPass.setText(null);
        change_passFld_conPass.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        top_lbl_close = new javax.swing.JLabel();
        top_lbl_minimize = new javax.swing.JLabel();
        top_lbl_logo = new javax.swing.JLabel();
        basePanel = new javax.swing.JPanel();
        in = new javax.swing.JPanel();
        in1 = new javax.swing.JPanel();
        in_lbl_username = new javax.swing.JLabel();
        in_lbl_password = new javax.swing.JLabel();
        in_tb_username = new javax.swing.JTextField();
        in_btn_login = new keeptoo.KButton();
        in_lbl_noAccount = new javax.swing.JLabel();
        in_lbl_RDtoCreateAccountfromLogin = new javax.swing.JLabel();
        in_lbl_RDto_ForgotfromLogin = new javax.swing.JLabel();
        in_lbl_haveAccount = new javax.swing.JLabel();
        in_passFld_password = new javax.swing.JPasswordField();
        in_lbl_bg = new javax.swing.JLabel();
        up = new javax.swing.JPanel();
        up1 = new javax.swing.JPanel();
        up_btn_CreateAccount = new keeptoo.KButton();
        up_lbl_haveAccount = new javax.swing.JLabel();
        up_lbl_RDto_LoginfromCreateAccount = new javax.swing.JLabel();
        up_lbl_username = new javax.swing.JLabel();
        up_lbl_password = new javax.swing.JLabel();
        up_lbl_conpassword = new javax.swing.JLabel();
        up_lbl_email = new javax.swing.JLabel();
        up_lbl_contact = new javax.swing.JLabel();
        up_lbl_secQue = new javax.swing.JLabel();
        up_tb_newuser = new javax.swing.JTextField();
        up_tb_email = new javax.swing.JTextField();
        up_tb_contact = new javax.swing.JTextField();
        up_lbl_place = new javax.swing.JLabel();
        up_tb_secQue = new javax.swing.JTextField();
        up_passFld_newpass = new javax.swing.JPasswordField();
        up_passFld_conpass = new javax.swing.JPasswordField();
        up_lbl_91 = new javax.swing.JLabel();
        up_lbl_bg = new javax.swing.JLabel();
        forgotPanel = new javax.swing.JPanel();
        forgot1 = new javax.swing.JPanel();
        forgot_label_remPassword = new javax.swing.JLabel();
        forgot_lbl_RDto_LoginfromForgot = new javax.swing.JLabel();
        forgot_lbl_username = new javax.swing.JLabel();
        forgot_lbl_email = new javax.swing.JLabel();
        forgot_lbl_contact = new javax.swing.JLabel();
        forgot_lbl_secQue = new javax.swing.JLabel();
        forgot_tb_username = new javax.swing.JTextField();
        forgot_tb_email = new javax.swing.JTextField();
        forgot_tb_contact = new javax.swing.JTextField();
        forgot_tb_secQue = new javax.swing.JTextField();
        forgot_lbl_place = new javax.swing.JLabel();
        forgot_lbl_secAns = new javax.swing.JLabel();
        forgot_btn_Check = new keeptoo.KButton();
        forgot_lbl_91 = new javax.swing.JLabel();
        forgot_lbl_bg = new javax.swing.JLabel();
        changePanel = new javax.swing.JPanel();
        change1 = new javax.swing.JPanel();
        change_lbl_newPass = new javax.swing.JLabel();
        change_lbl_conPass = new javax.swing.JLabel();
        change_btn_ConfirmPassword = new keeptoo.KButton();
        change_lbl_RDto_LoginfromChange = new javax.swing.JLabel();
        change_passFld_newPass = new javax.swing.JPasswordField();
        change_passFld_conPass = new javax.swing.JPasswordField();
        change_lbl_bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topPanel.setBackground(new java.awt.Color(0, 0, 0));
        topPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        top_lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/close-window-45 (2).png"))); // NOI18N
        top_lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                top_lbl_closeMouseClicked(evt);
            }
        });
        topPanel.add(top_lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, -1, -1));

        top_lbl_minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/minimize-window-40.png"))); // NOI18N
        top_lbl_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                top_lbl_minimizeMouseClicked(evt);
            }
        });
        topPanel.add(top_lbl_minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 2, -1, -1));

        top_lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/tim-mossholder-fwqB5mJNOcE-unsplash.png"))); // NOI18N
        topPanel.add(top_lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 180));

        getContentPane().add(topPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 180));

        basePanel.setLayout(new java.awt.CardLayout());

        in.setPreferredSize(new java.awt.Dimension(600, 580));
        in.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        in1.setBackground(new java.awt.Color(102, 102, 102));

        in_lbl_username.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        in_lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        in_lbl_username.setText("Username : ");

        in_lbl_password.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        in_lbl_password.setForeground(new java.awt.Color(255, 255, 255));
        in_lbl_password.setText("Password : ");

        in_tb_username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        in_btn_login.setBorder(null);
        in_btn_login.setText("Log in");
        in_btn_login.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        in_btn_login.setkEndColor(new java.awt.Color(0, 0, 204));
        in_btn_login.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        in_btn_login.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        in_btn_login.setkPressedColor(new java.awt.Color(255, 255, 51));
        in_btn_login.setkSelectedColor(new java.awt.Color(255, 255, 51));
        in_btn_login.setkStartColor(new java.awt.Color(0, 204, 204));
        in_btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in_btn_loginActionPerformed(evt);
            }
        });

        in_lbl_noAccount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        in_lbl_noAccount.setForeground(new java.awt.Color(255, 255, 255));
        in_lbl_noAccount.setText("Don't have an account?");

        in_lbl_RDtoCreateAccountfromLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        in_lbl_RDtoCreateAccountfromLogin.setForeground(new java.awt.Color(51, 255, 255));
        in_lbl_RDtoCreateAccountfromLogin.setText("Create one");
        in_lbl_RDtoCreateAccountfromLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                in_lbl_RDtoCreateAccountfromLoginMousePressed(evt);
            }
        });

        in_lbl_RDto_ForgotfromLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        in_lbl_RDto_ForgotfromLogin.setForeground(new java.awt.Color(51, 255, 255));
        in_lbl_RDto_ForgotfromLogin.setText("Forgot Password");
        in_lbl_RDto_ForgotfromLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                in_lbl_RDto_ForgotfromLoginMousePressed(evt);
            }
        });

        in_lbl_haveAccount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        in_lbl_haveAccount.setForeground(new java.awt.Color(255, 255, 255));
        in_lbl_haveAccount.setText("Have an account?");

        in_passFld_password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout in1Layout = new javax.swing.GroupLayout(in1);
        in1.setLayout(in1Layout);
        in1Layout.setHorizontalGroup(
            in1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(in1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(in1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(in1Layout.createSequentialGroup()
                        .addGroup(in1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(in_lbl_haveAccount)
                            .addComponent(in_lbl_noAccount))
                        .addGap(18, 18, 18)
                        .addGroup(in1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(in_lbl_RDtoCreateAccountfromLogin)
                            .addComponent(in_lbl_RDto_ForgotfromLogin))
                        .addGap(103, 103, 103))
                    .addGroup(in1Layout.createSequentialGroup()
                        .addGroup(in1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(in_lbl_password)
                            .addComponent(in_lbl_username))
                        .addGap(18, 18, 18)
                        .addGroup(in1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(in_btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(in_tb_username, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(in_passFld_password, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(59, Short.MAX_VALUE))))
        );
        in1Layout.setVerticalGroup(
            in1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(in1Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(in1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in_tb_username, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(in_lbl_username))
                .addGap(18, 18, 18)
                .addGroup(in1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in_lbl_password)
                    .addComponent(in_passFld_password, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(in_btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(in1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in_lbl_haveAccount)
                    .addComponent(in_lbl_RDto_ForgotfromLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addGroup(in1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in_lbl_noAccount)
                    .addComponent(in_lbl_RDtoCreateAccountfromLogin))
                .addContainerGap())
        );

        in.add(in1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 560));

        in_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/600x580annie-spratt-AtF1jn20qoA-unsplash.png"))); // NOI18N
        in.add(in_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 580));

        basePanel.add(in, "card2");

        up.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        up1.setBackground(new java.awt.Color(102, 102, 102));

        up_btn_CreateAccount.setText("Create Account");
        up_btn_CreateAccount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        up_btn_CreateAccount.setkEndColor(new java.awt.Color(0, 0, 204));
        up_btn_CreateAccount.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        up_btn_CreateAccount.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        up_btn_CreateAccount.setkPressedColor(new java.awt.Color(255, 255, 51));
        up_btn_CreateAccount.setkSelectedColor(new java.awt.Color(255, 255, 51));
        up_btn_CreateAccount.setkStartColor(new java.awt.Color(0, 204, 204));
        up_btn_CreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_btn_CreateAccountActionPerformed(evt);
            }
        });

        up_lbl_haveAccount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        up_lbl_haveAccount.setForeground(new java.awt.Color(255, 255, 255));
        up_lbl_haveAccount.setText("Already have an account?");

        up_lbl_RDto_LoginfromCreateAccount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        up_lbl_RDto_LoginfromCreateAccount.setForeground(new java.awt.Color(51, 255, 255));
        up_lbl_RDto_LoginfromCreateAccount.setText("Log in");
        up_lbl_RDto_LoginfromCreateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                up_lbl_RDto_LoginfromCreateAccountMousePressed(evt);
            }
        });

        up_lbl_username.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        up_lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        up_lbl_username.setText("Username : ");

        up_lbl_password.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        up_lbl_password.setForeground(new java.awt.Color(255, 255, 255));
        up_lbl_password.setText("Password : ");

        up_lbl_conpassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        up_lbl_conpassword.setForeground(new java.awt.Color(255, 255, 255));
        up_lbl_conpassword.setText("Confirm Password : ");

        up_lbl_email.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        up_lbl_email.setForeground(new java.awt.Color(255, 255, 255));
        up_lbl_email.setText("Email : ");

        up_lbl_contact.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        up_lbl_contact.setForeground(new java.awt.Color(255, 255, 255));
        up_lbl_contact.setText("Contact : ");

        up_lbl_secQue.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        up_lbl_secQue.setForeground(new java.awt.Color(255, 255, 255));
        up_lbl_secQue.setText("Security Question : ");

        up_tb_newuser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        up_tb_email.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        up_tb_contact.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        up_lbl_place.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        up_lbl_place.setForeground(new java.awt.Color(255, 255, 255));
        up_lbl_place.setText("Which place would you like to visit?");

        up_tb_secQue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        up_passFld_newpass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        up_passFld_conpass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        up_lbl_91.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        up_lbl_91.setForeground(new java.awt.Color(255, 255, 255));
        up_lbl_91.setText("+91");

        javax.swing.GroupLayout up1Layout = new javax.swing.GroupLayout(up1);
        up1.setLayout(up1Layout);
        up1Layout.setHorizontalGroup(
            up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(up1Layout.createSequentialGroup()
                .addGroup(up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(up1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(up_lbl_haveAccount)
                        .addGap(18, 18, 18)
                        .addComponent(up_lbl_RDto_LoginfromCreateAccount))
                    .addGroup(up1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(up_lbl_conpassword)
                            .addGroup(up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(up_lbl_contact)
                                .addComponent(up_lbl_secQue)
                                .addComponent(up_lbl_email))
                            .addComponent(up_lbl_username, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(up_lbl_password, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(up_tb_newuser, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(up_tb_email)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, up1Layout.createSequentialGroup()
                                    .addComponent(up_lbl_91)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(up_tb_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(up_lbl_place)
                            .addComponent(up_tb_secQue, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(up_passFld_newpass, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(up_passFld_conpass, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(up1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(up_btn_CreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        up1Layout.setVerticalGroup(
            up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, up1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(up_lbl_username)
                    .addComponent(up_tb_newuser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(up_lbl_password)
                    .addComponent(up_passFld_newpass, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(up_lbl_conpassword)
                    .addComponent(up_passFld_conpass, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(up_lbl_email)
                    .addComponent(up_tb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(up_lbl_contact)
                    .addComponent(up_tb_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(up_lbl_91, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(up_lbl_secQue)
                    .addComponent(up_lbl_place))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(up_tb_secQue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(up_btn_CreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(up_lbl_haveAccount)
                    .addComponent(up_lbl_RDto_LoginfromCreateAccount))
                .addContainerGap())
        );

        up.add(up1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 560));

        up_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/jeremy-bishop-yKwJCJuz7Z0-unsplash.png"))); // NOI18N
        up.add(up_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 580));

        basePanel.add(up, "card3");

        forgotPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        forgot1.setBackground(new java.awt.Color(102, 102, 102));

        forgot_label_remPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        forgot_label_remPassword.setForeground(new java.awt.Color(255, 255, 255));
        forgot_label_remPassword.setText("Remember your Password?");

        forgot_lbl_RDto_LoginfromForgot.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        forgot_lbl_RDto_LoginfromForgot.setForeground(new java.awt.Color(51, 255, 255));
        forgot_lbl_RDto_LoginfromForgot.setText("Return to login");
        forgot_lbl_RDto_LoginfromForgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                forgot_lbl_RDto_LoginfromForgotMousePressed(evt);
            }
        });

        forgot_lbl_username.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        forgot_lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        forgot_lbl_username.setText("Username : ");

        forgot_lbl_email.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        forgot_lbl_email.setForeground(new java.awt.Color(255, 255, 255));
        forgot_lbl_email.setText("Email : ");

        forgot_lbl_contact.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        forgot_lbl_contact.setForeground(new java.awt.Color(255, 255, 255));
        forgot_lbl_contact.setText("Contact : ");

        forgot_lbl_secQue.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        forgot_lbl_secQue.setForeground(new java.awt.Color(255, 255, 255));
        forgot_lbl_secQue.setText("Security Question : ");

        forgot_tb_username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        forgot_tb_email.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        forgot_tb_contact.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        forgot_tb_secQue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        forgot_lbl_place.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        forgot_lbl_place.setForeground(new java.awt.Color(255, 255, 255));
        forgot_lbl_place.setText("Which place would you like to visit?");

        forgot_lbl_secAns.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        forgot_lbl_secAns.setForeground(new java.awt.Color(255, 255, 255));
        forgot_lbl_secAns.setText("Answer : ");

        forgot_btn_Check.setText("Check");
        forgot_btn_Check.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        forgot_btn_Check.setkEndColor(new java.awt.Color(0, 0, 204));
        forgot_btn_Check.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        forgot_btn_Check.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        forgot_btn_Check.setkPressedColor(new java.awt.Color(255, 255, 51));
        forgot_btn_Check.setkSelectedColor(new java.awt.Color(255, 255, 51));
        forgot_btn_Check.setkStartColor(new java.awt.Color(0, 204, 204));
        forgot_btn_Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgot_btn_CheckActionPerformed(evt);
            }
        });

        forgot_lbl_91.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        forgot_lbl_91.setForeground(new java.awt.Color(255, 255, 255));
        forgot_lbl_91.setText("+91");

        javax.swing.GroupLayout forgot1Layout = new javax.swing.GroupLayout(forgot1);
        forgot1.setLayout(forgot1Layout);
        forgot1Layout.setHorizontalGroup(
            forgot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(forgot1Layout.createSequentialGroup()
                .addGroup(forgot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(forgot1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(forgot_label_remPassword)
                        .addGap(18, 18, 18)
                        .addComponent(forgot_lbl_RDto_LoginfromForgot))
                    .addGroup(forgot1Layout.createSequentialGroup()
                        .addGroup(forgot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(forgot1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(forgot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(forgot_lbl_contact)
                                    .addComponent(forgot_lbl_email)
                                    .addComponent(forgot_lbl_username)))
                            .addGroup(forgot1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(forgot_lbl_secQue))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forgot1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(forgot_lbl_secAns)))
                        .addGap(18, 18, 18)
                        .addGroup(forgot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(forgot_tb_username, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(forgot_tb_email)
                            .addComponent(forgot_tb_secQue, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(forgot_lbl_place)
                            .addComponent(forgot_btn_Check, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forgot1Layout.createSequentialGroup()
                                .addComponent(forgot_lbl_91)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(forgot_tb_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        forgot1Layout.setVerticalGroup(
            forgot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forgot1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(forgot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forgot_lbl_username)
                    .addComponent(forgot_tb_username, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(forgot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forgot_lbl_email)
                    .addComponent(forgot_tb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(forgot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forgot_lbl_contact)
                    .addComponent(forgot_tb_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forgot_lbl_91, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(forgot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forgot_lbl_place)
                    .addComponent(forgot_lbl_secQue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(forgot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forgot_tb_secQue, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forgot_lbl_secAns))
                .addGap(61, 61, 61)
                .addComponent(forgot_btn_Check, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(forgot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forgot_label_remPassword)
                    .addComponent(forgot_lbl_RDto_LoginfromForgot))
                .addContainerGap())
        );

        forgotPanel.add(forgot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 560));

        forgot_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/carlos-quintero-hAb_8YM2kJw-unsplash.png"))); // NOI18N
        forgotPanel.add(forgot_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 580));

        basePanel.add(forgotPanel, "card4");

        changePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        change1.setBackground(new java.awt.Color(153, 153, 153));

        change_lbl_newPass.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        change_lbl_newPass.setForeground(new java.awt.Color(255, 255, 255));
        change_lbl_newPass.setText("Enter new Password : ");

        change_lbl_conPass.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        change_lbl_conPass.setForeground(new java.awt.Color(255, 255, 255));
        change_lbl_conPass.setText("Confirm new Password : ");

        change_btn_ConfirmPassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        change_btn_ConfirmPassword.setkEndColor(new java.awt.Color(0, 0, 204));
        change_btn_ConfirmPassword.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        change_btn_ConfirmPassword.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        change_btn_ConfirmPassword.setkPressedColor(new java.awt.Color(255, 255, 51));
        change_btn_ConfirmPassword.setkSelectedColor(new java.awt.Color(255, 255, 51));
        change_btn_ConfirmPassword.setkStartColor(new java.awt.Color(0, 204, 204));
        change_btn_ConfirmPassword.setLabel("Confirm Password");
        change_btn_ConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_btn_ConfirmPasswordActionPerformed(evt);
            }
        });

        change_lbl_RDto_LoginfromChange.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        change_lbl_RDto_LoginfromChange.setForeground(new java.awt.Color(0, 255, 255));
        change_lbl_RDto_LoginfromChange.setText("Return to login");
        change_lbl_RDto_LoginfromChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                change_lbl_RDto_LoginfromChangeMousePressed(evt);
            }
        });

        change_passFld_newPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        change_passFld_conPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        change_passFld_conPass.setToolTipText("");

        javax.swing.GroupLayout change1Layout = new javax.swing.GroupLayout(change1);
        change1.setLayout(change1Layout);
        change1Layout.setHorizontalGroup(
            change1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(change1Layout.createSequentialGroup()
                .addGroup(change1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(change1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(change1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(change_lbl_conPass)
                            .addComponent(change_lbl_newPass))
                        .addGap(18, 18, 18)
                        .addGroup(change1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(change_passFld_conPass, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(change_passFld_newPass, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(change1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(change_lbl_RDto_LoginfromChange)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, change1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(change_btn_ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
        );
        change1Layout.setVerticalGroup(
            change1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(change1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(change1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(change_lbl_newPass)
                    .addComponent(change_passFld_newPass, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(change1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(change_lbl_conPass)
                    .addComponent(change_passFld_conPass, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147)
                .addComponent(change_btn_ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(change_lbl_RDto_LoginfromChange)
                .addContainerGap())
        );

        changePanel.add(change1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 560));

        change_lbl_bg.setBackground(new java.awt.Color(153, 153, 153));
        change_lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/sebastian-molina-fotografia-natjj0CTa-s-unsplash.png"))); // NOI18N
        changePanel.add(change_lbl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 580));

        basePanel.add(changePanel, "card5");

        getContentPane().add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 600, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void up_lbl_RDto_LoginfromCreateAccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_up_lbl_RDto_LoginfromCreateAccountMousePressed
        setPanelVisible(in);
        setUpPanelComponentsNull();
    }//GEN-LAST:event_up_lbl_RDto_LoginfromCreateAccountMousePressed

    private void in_lbl_RDtoCreateAccountfromLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_in_lbl_RDtoCreateAccountfromLoginMousePressed
        setPanelVisible(up);
        setInPanelComponentsNull();
    }//GEN-LAST:event_in_lbl_RDtoCreateAccountfromLoginMousePressed

    private void in_btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in_btn_loginActionPerformed
        String loginUser = in_tb_username.getText();
        String loginPass = Arrays.toString(in_passFld_password.getPassword());       
        if(loginUser.isEmpty() == false && loginPass.isEmpty()== false){
            try{
                Connection conn;
                conn = ConnectTo.getConnection();
                PreparedStatement st = (PreparedStatement) conn.prepareStatement
                    ("select username, password from login where username=? and password=?;");
                st.setString(1, loginUser);
                st.setString(2, loginPass);
                ResultSet rs = st.executeQuery();               
                if(rs.next()){
                    this.dispose();
                    Operations o = new Operations(loginUser);
                    o.setVisible(true);              
                    myNotification.set();
                    try{
                        Connection con;
                        con = ConnectTo.getConnection();
                        Date today = Date.valueOf(LocalDate.now());
                        PreparedStatement ps = (PreparedStatement) con.prepareStatement
                            ("update notify set status = \"Dormant\" where notifyOn < \""+today+"\";");
                        ps.executeUpdate();
                        ps.close();
                        con.close();
                    }
                    catch(ClassNotFoundException | SQLException e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password!");
                }
                st.close();
                rs.close();
                conn.close();
            }   
            catch (HeadlessException | ClassNotFoundException | SQLException ex) {
                Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
            }                 
        }
        else{
            JOptionPane.showMessageDialog(null,"Enter username and password");
        }
    }//GEN-LAST:event_in_btn_loginActionPerformed
    
    private void up_btn_CreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_btn_CreateAccountActionPerformed
        String username = up_tb_newuser.getText();
        String password = Arrays.toString(up_passFld_newpass.getPassword());
        String con = Arrays.toString(up_passFld_conpass.getPassword());
        String email = up_tb_email.getText();
        String contact = up_tb_contact.getText().trim();
        String sec = up_tb_secQue.getText();        
        if((password.equals(con))==true){                   
            int len = password.length();
            if(len>=24 && len<=48){
                if((verify.verifyEmail(email))){
                    if(verify.verifyContact(contact)){  
                        try{
                            Connection conn;
                            conn = ConnectTo.getConnection();
                            PreparedStatement ps = (PreparedStatement) conn.prepareStatement
                                    ("select username from login where username=?;");
                            ps.setString(1,username);
                            ResultSet rs0 = ps.executeQuery();
                            if(!rs0.next()){
                                PreparedStatement ps3 = (PreparedStatement) conn.prepareStatement
                                    ("select email from login where email=?;");
                                ps3.setString(1,email);
                                ResultSet rs3 = ps3.executeQuery();
                                if(!rs3.next()){
                                    PreparedStatement ps4 = (PreparedStatement) conn.prepareStatement
                                    ("select contact from login where contact=?;");
                                    ps4.setString(1,contact);
                                    ResultSet rs4 = ps4.executeQuery();
                                    if(!rs4.next()){
                                        PreparedStatement st = (PreparedStatement) conn.prepareStatement
                                            ("insert into login values (?,?,?,?,?);");
                                        PreparedStatement select = (PreparedStatement) conn.prepareStatement
                                            ("select username,contact from login where username=? and contact=?;");
                                        select.setString(1, username);
                                        select.setString(2, contact);
                                        st.setString(1, username);
                                        st.setString(2, password);
                                        st.setString(3, email);
                                        st.setString(4, contact);
                                        st.setString(5, sec);
                                        ResultSet rs = select.executeQuery();
                                        int n = st.executeUpdate();
                                        if(n==1){
                                            JOptionPane.showMessageDialog(null,"Account created");
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null,"Error!");
                                        }
                                        setUpPanelComponentsNull();
                                        st.close();
                                        select.close();
                                        rs.close();    
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "This number is already registered");
                                    }
                                    ps4.close();
                                    rs4.close();
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"This email is already registered!");
                                }
                                rs3.close();                 
                            }                  
                            else{
                                JOptionPane.showMessageDialog(null, "Username already exists");
                            }
                            conn.close();
                            ps.close();
                        }
                        catch(HeadlessException | ClassNotFoundException | SQLException e){
                            System.out.println(e);
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
            else{
                JOptionPane.showMessageDialog(null, "Password must be 8 to 16 characters long.");
            }
        }
        else{           
            JOptionPane.showMessageDialog(null,"Passwords don't match!");
        }     
    }//GEN-LAST:event_up_btn_CreateAccountActionPerformed

    private void in_lbl_RDto_ForgotfromLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_in_lbl_RDto_ForgotfromLoginMousePressed
        setPanelVisible(forgotPanel);
        setInPanelComponentsNull();
    }//GEN-LAST:event_in_lbl_RDto_ForgotfromLoginMousePressed

    private void forgot_lbl_RDto_LoginfromForgotMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgot_lbl_RDto_LoginfromForgotMousePressed
        setPanelVisible(in); 
        setForgetPanelComponentsNull();
    }//GEN-LAST:event_forgot_lbl_RDto_LoginfromForgotMousePressed
    
    public String uname;
    private void forgot_btn_CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgot_btn_CheckActionPerformed
        String Temail = forgot_tb_email.getText();
        String Tcontact = forgot_tb_contact.getText();
        String Tusername = String.valueOf(forgot_tb_username.getText());
        String Tsec = forgot_tb_secQue.getText();
        uname = Tusername;      
        try{
            Connection conn;
            conn = ConnectTo.getConnection();
            PreparedStatement select = (PreparedStatement) conn.prepareStatement
                ("select username, email, contact, sec from login where username=?;");
            select.setString(1, Tusername);
            conn.setAutoCommit(false);
            ResultSet rs = select.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String contact = rs.getString("contact");
                String sec = rs.getString("sec");         
                if(Tusername.equals(username)==true){
                    if(Temail.equals(email)==true){
                        if(Tcontact.equals(contact)==true){
                            if(Tsec.equals(sec)==true){
                                {
                                    setForgetPanelComponentsNull();                                   
                                    setPanelVisible(changePanel);
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Invalid answer to security question");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Invalid contact");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid email");
                    }
                }   
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username");                   
                }
            }             
            else{
                JOptionPane.showMessageDialog(null,"Error!");
            }
            conn.commit();
            conn.close();
            select.close();
            rs.close();
        } 
        catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }             
    }//GEN-LAST:event_forgot_btn_CheckActionPerformed

    private void change_btn_ConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_btn_ConfirmPasswordActionPerformed
        String a = Arrays.toString(change_passFld_newPass.getPassword());
        String b = Arrays.toString(change_passFld_conPass.getPassword());
        if(a.equals(b)==true){
            int len = a.length();
            if(len>=24 && len<=48){
                try{
                    Connection conn1;
                    conn1 = ConnectTo.getConnection();
                    PreparedStatement select = (PreparedStatement) conn1.prepareStatement
                        ("select username, email, contact, sec from login where username=?;");
                    select.setString(1, uname);
                    ResultSet rs = select.executeQuery();
                    if (rs.next()) {
                        String Fusername = rs.getString("username");
                        PreparedStatement ps = (PreparedStatement) conn1.prepareStatement
                            ("update login set password = ? where Username = ?;");
                        ps.setString(1, a);
                        ps.setString(2, Fusername);
                        int n = ps.executeUpdate();
                        if(n==1){
                            JOptionPane.showMessageDialog(null,"Password updated successfully.");                        
                            setChangePanelComponentsNull();
                            setPanelVisible(in);
                        }
                        ps.close();
                    }
                    conn1.close();
                    rs.close();
                }
                catch(HeadlessException | ClassNotFoundException | SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Password must be 8 to 16 characters long.");
            }
        }   
        else{
            JOptionPane.showMessageDialog(null, "Password doesn't match!");
        }                  
    }//GEN-LAST:event_change_btn_ConfirmPasswordActionPerformed

    private void change_lbl_RDto_LoginfromChangeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_change_lbl_RDto_LoginfromChangeMousePressed
        setPanelVisible(in);       
    }//GEN-LAST:event_change_lbl_RDto_LoginfromChangeMousePressed

    private void top_lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_top_lbl_closeMouseClicked
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the application");
        if(result==JOptionPane.YES_OPTION){
            System.exit(0);
            this.dispose();
        }
    }//GEN-LAST:event_top_lbl_closeMouseClicked

    private void top_lbl_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_top_lbl_minimizeMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_top_lbl_minimizeMouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginPanel l = new LoginPanel();
                l.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JPanel change1;
    private javax.swing.JPanel changePanel;
    private keeptoo.KButton change_btn_ConfirmPassword;
    private javax.swing.JLabel change_lbl_RDto_LoginfromChange;
    private javax.swing.JLabel change_lbl_bg;
    private javax.swing.JLabel change_lbl_conPass;
    private javax.swing.JLabel change_lbl_newPass;
    private javax.swing.JPasswordField change_passFld_conPass;
    private javax.swing.JPasswordField change_passFld_newPass;
    private javax.swing.JPanel forgot1;
    private javax.swing.JPanel forgotPanel;
    private keeptoo.KButton forgot_btn_Check;
    private javax.swing.JLabel forgot_label_remPassword;
    private javax.swing.JLabel forgot_lbl_91;
    private javax.swing.JLabel forgot_lbl_RDto_LoginfromForgot;
    private javax.swing.JLabel forgot_lbl_bg;
    private javax.swing.JLabel forgot_lbl_contact;
    private javax.swing.JLabel forgot_lbl_email;
    private javax.swing.JLabel forgot_lbl_place;
    private javax.swing.JLabel forgot_lbl_secAns;
    private javax.swing.JLabel forgot_lbl_secQue;
    private javax.swing.JLabel forgot_lbl_username;
    private javax.swing.JTextField forgot_tb_contact;
    private javax.swing.JTextField forgot_tb_email;
    private javax.swing.JTextField forgot_tb_secQue;
    private javax.swing.JTextField forgot_tb_username;
    private javax.swing.JPanel in;
    private javax.swing.JPanel in1;
    private keeptoo.KButton in_btn_login;
    private javax.swing.JLabel in_lbl_RDtoCreateAccountfromLogin;
    private javax.swing.JLabel in_lbl_RDto_ForgotfromLogin;
    private javax.swing.JLabel in_lbl_bg;
    private javax.swing.JLabel in_lbl_haveAccount;
    private javax.swing.JLabel in_lbl_noAccount;
    private javax.swing.JLabel in_lbl_password;
    private javax.swing.JLabel in_lbl_username;
    private javax.swing.JPasswordField in_passFld_password;
    private javax.swing.JTextField in_tb_username;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel top_lbl_close;
    private javax.swing.JLabel top_lbl_logo;
    private javax.swing.JLabel top_lbl_minimize;
    private javax.swing.JPanel up;
    private javax.swing.JPanel up1;
    private keeptoo.KButton up_btn_CreateAccount;
    private javax.swing.JLabel up_lbl_91;
    private javax.swing.JLabel up_lbl_RDto_LoginfromCreateAccount;
    private javax.swing.JLabel up_lbl_bg;
    private javax.swing.JLabel up_lbl_conpassword;
    private javax.swing.JLabel up_lbl_contact;
    private javax.swing.JLabel up_lbl_email;
    private javax.swing.JLabel up_lbl_haveAccount;
    private javax.swing.JLabel up_lbl_password;
    private javax.swing.JLabel up_lbl_place;
    private javax.swing.JLabel up_lbl_secQue;
    private javax.swing.JLabel up_lbl_username;
    private javax.swing.JPasswordField up_passFld_conpass;
    private javax.swing.JPasswordField up_passFld_newpass;
    private javax.swing.JTextField up_tb_contact;
    private javax.swing.JTextField up_tb_email;
    private javax.swing.JTextField up_tb_newuser;
    private javax.swing.JTextField up_tb_secQue;
    // End of variables declaration//GEN-END:variables
}
