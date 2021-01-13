package Operations_package;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Akash Pawar
 */
public class ReceiptPrinter extends javax.swing.JFrame implements Printable, ActionListener{
    
    public ReceiptPrinter(String transactionID, String custName, String plantName, String Quantity, String Price, int totalPrice, Date date) {
        this.setUndecorated(true);
        initComponents();
        
        base_lbl_transactionID.setText(transactionID);
        base_lbl_custName.setText(custName);
        base_lbl_plantName.setText(plantName);
        base_lbl_Quantity.setText(Quantity);
        base_lbl_Price.setText(Price);
        base_lbl_totalCost.setText(Integer.toString(totalPrice));
        base_lbl_Date.setText(date.toString());     

        this.setLocationRelativeTo(null);   //jframe to center
        this.setResizable(false); 
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void printComponent(Component component){
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Print Component ");

        pj.setPrintable (new Printable() {    
            public int print(Graphics pg, PageFormat pf, int pageNum){
                if (pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                component.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        if (pj.printDialog() == false)
            return;

        try {
            pj.print();
        } 
        catch (PrinterException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }   
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        receiptPanel = new javax.swing.JPanel();
        base_lbl_title = new javax.swing.JLabel();
        base_lbl_subheading = new javax.swing.JLabel();
        base_lbl_emoticon = new javax.swing.JLabel();
        base_lbl_unchanged_transactionID = new javax.swing.JLabel();
        base_lbl_unchanged_custName = new javax.swing.JLabel();
        base_lbl_unchanged_plantName = new javax.swing.JLabel();
        base_lbl_unchanged_Quantity = new javax.swing.JLabel();
        base_lbl_unchanged_Price = new javax.swing.JLabel();
        base_lbl_unchanged_totalCost = new javax.swing.JLabel();
        base_lbl_unchanged_Date = new javax.swing.JLabel();
        base_lbl_transactionID = new javax.swing.JLabel();
        base_lbl_custName = new javax.swing.JLabel();
        base_lbl_plantName = new javax.swing.JLabel();
        base_lbl_Quantity = new javax.swing.JLabel();
        base_lbl_Price = new javax.swing.JLabel();
        base_lbl_totalCost = new javax.swing.JLabel();
        base_lbl_Date = new javax.swing.JLabel();
        base_lbl_tearHere = new javax.swing.JLabel();
        base_lbl_separator = new javax.swing.JLabel();
        base_logoPanel = new javax.swing.JPanel();
        base_logoPanel_lbl_flowerImage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        base_btn_printReceipt = new keeptoo.KButton();
        jLabel4 = new javax.swing.JLabel();
        top_lbl_close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(255, 255, 255));
        basePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        receiptPanel.setBackground(new java.awt.Color(255, 255, 255));
        receiptPanel.setPreferredSize(new java.awt.Dimension(598, 350));
        receiptPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        base_lbl_title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        base_lbl_title.setText("Plant Nursery");
        receiptPanel.add(base_lbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 220, -1));

        base_lbl_subheading.setText("A greener step towards you");
        receiptPanel.add(base_lbl_subheading, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 170, -1));

        base_lbl_emoticon.setText("    (✿◠‿◠)       (✿◠‿◠)       (✿◠‿◠)       (✿◠‿◠)       (✿◠‿◠)       (✿◠‿◠)       (✿◠‿◠)       (✿◠‿◠)       (✿◠‿◠)       ");
        receiptPanel.add(base_lbl_emoticon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 59, -1, -1));

        base_lbl_unchanged_transactionID.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        base_lbl_unchanged_transactionID.setText("Transaction ID : ");
        receiptPanel.add(base_lbl_unchanged_transactionID, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 93, -1, -1));

        base_lbl_unchanged_custName.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        base_lbl_unchanged_custName.setText("Customer name : ");
        receiptPanel.add(base_lbl_unchanged_custName, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 113, -1, -1));

        base_lbl_unchanged_plantName.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        base_lbl_unchanged_plantName.setText("Plant name : ");
        receiptPanel.add(base_lbl_unchanged_plantName, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 133, -1, -1));

        base_lbl_unchanged_Quantity.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        base_lbl_unchanged_Quantity.setText("Quantity purchased : ");
        receiptPanel.add(base_lbl_unchanged_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 153, -1, -1));

        base_lbl_unchanged_Price.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        base_lbl_unchanged_Price.setText("Price per unit : ");
        receiptPanel.add(base_lbl_unchanged_Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 173, -1, -1));

        base_lbl_unchanged_totalCost.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        base_lbl_unchanged_totalCost.setText("Total cost : ");
        receiptPanel.add(base_lbl_unchanged_totalCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 200, -1, -1));

        base_lbl_unchanged_Date.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        base_lbl_unchanged_Date.setText("Date : ");
        receiptPanel.add(base_lbl_unchanged_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 93, -1, -1));

        base_lbl_transactionID.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        receiptPanel.add(base_lbl_transactionID, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 95, 200, 10));

        base_lbl_custName.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        receiptPanel.add(base_lbl_custName, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 115, 200, 15));

        base_lbl_plantName.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        receiptPanel.add(base_lbl_plantName, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 135, 200, 10));

        base_lbl_Quantity.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        receiptPanel.add(base_lbl_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 155, 200, 10));

        base_lbl_Price.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        receiptPanel.add(base_lbl_Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 175, 200, 10));

        base_lbl_totalCost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        receiptPanel.add(base_lbl_totalCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 192, 200, 30));

        base_lbl_Date.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        receiptPanel.add(base_lbl_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 95, 80, 10));

        base_lbl_tearHere.setText(" -  -  -✂ -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
        receiptPanel.add(base_lbl_tearHere, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 215, -1, -1));

        base_lbl_separator.setText("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - ");
        receiptPanel.add(base_lbl_separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 185, -1, -1));

        base_logoPanel.setBackground(new java.awt.Color(255, 255, 255));
        base_logoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        base_logoPanel_lbl_flowerImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/45x41 red flower zoom.png"))); // NOI18N
        base_logoPanel_lbl_flowerImage.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        base_logoPanel.add(base_logoPanel_lbl_flowerImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        receiptPanel.add(base_logoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel2.setText("Address 1");
        receiptPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 5, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel3.setText("Address 2");
        receiptPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel5.setText("Address 3");
        receiptPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 35, -1, -1));

        jScrollPane1.setViewportView(receiptPanel);

        basePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, 570, 370));

        base_btn_printReceipt.setText("Print Receipt");
        base_btn_printReceipt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        base_btn_printReceipt.setkBorderRadius(30);
        base_btn_printReceipt.setkEndColor(new java.awt.Color(0, 0, 204));
        base_btn_printReceipt.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        base_btn_printReceipt.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        base_btn_printReceipt.setkPressedColor(new java.awt.Color(255, 255, 51));
        base_btn_printReceipt.setkSelectedColor(new java.awt.Color(255, 255, 51));
        base_btn_printReceipt.setkStartColor(new java.awt.Color(0, 204, 204));
        base_btn_printReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                base_btn_printReceiptActionPerformed(evt);
            }
        });
        basePanel.add(base_btn_printReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 540, -1, -1));

        jLabel4.setText("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀");
        basePanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 590, -1));

        top_lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/close-window-45 (2).png"))); // NOI18N
        top_lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                top_lbl_closeMouseClicked(evt);
            }
        });
        basePanel.add(top_lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background/ezgif.com-resize.gif"))); // NOI18N
        basePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 630));

        getContentPane().add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void top_lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_top_lbl_closeMouseClicked
        int result = JOptionPane.showConfirmDialog(null, "Would you like to close the print frame?");
        if(result==JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_top_lbl_closeMouseClicked

    private void base_btn_printReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_base_btn_printReceiptActionPerformed
        try{
            printComponent(receiptPanel);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_base_btn_printReceiptActionPerformed

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
            java.util.logging.Logger.getLogger(ReceiptPrinter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceiptPrinter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceiptPrinter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceiptPrinter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String transactionID = null;
                String custName = null;
                String plantName = null;
                String Quantity = null;
                String Price = null;
                int totalPrice = 0;
                Date date = null;
                new ReceiptPrinter(transactionID, custName, plantName, Quantity, Price, totalPrice, date).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private keeptoo.KButton base_btn_printReceipt;
    private javax.swing.JLabel base_lbl_Date;
    private javax.swing.JLabel base_lbl_Price;
    private javax.swing.JLabel base_lbl_Quantity;
    private javax.swing.JLabel base_lbl_custName;
    private javax.swing.JLabel base_lbl_emoticon;
    private javax.swing.JLabel base_lbl_plantName;
    private javax.swing.JLabel base_lbl_separator;
    private javax.swing.JLabel base_lbl_subheading;
    private javax.swing.JLabel base_lbl_tearHere;
    private javax.swing.JLabel base_lbl_title;
    private javax.swing.JLabel base_lbl_totalCost;
    private javax.swing.JLabel base_lbl_transactionID;
    private javax.swing.JLabel base_lbl_unchanged_Date;
    private javax.swing.JLabel base_lbl_unchanged_Price;
    private javax.swing.JLabel base_lbl_unchanged_Quantity;
    private javax.swing.JLabel base_lbl_unchanged_custName;
    private javax.swing.JLabel base_lbl_unchanged_plantName;
    private javax.swing.JLabel base_lbl_unchanged_totalCost;
    private javax.swing.JLabel base_lbl_unchanged_transactionID;
    private javax.swing.JPanel base_logoPanel;
    private javax.swing.JLabel base_logoPanel_lbl_flowerImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel receiptPanel;
    private javax.swing.JLabel top_lbl_close;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
/*
🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀
*/
