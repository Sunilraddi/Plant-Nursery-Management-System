/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantshop8;

import java.awt.print.PrinterException;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Akash Pawar
 */
public class printThis {
    public static void printComponent(JTable jTable) throws PrinterException{
        /*
        for (int colIdx = 0; colIdx < jTable.getColumnCount(); colIdx++)
{
    for (int rowIdx = 0; rowIdx < jTable.getRowCount(); rowIdx++)
    {
        TableColumnModel columnModel = jTable.getColumnModel();
        TableColumn column = columnModel.getColumn(colIdx);
        TableCellRenderer renderer = column.getCellRenderer();
        Object cellValue = jTable.getValueAt(rowIdx, colIdx);
        renderer.getTableCellRendererComponent(jTable, cellValue, 
                    false, false, rowIdx, colIdx);
    }
}
        */
        /*
        //JTable printTable = new JTable(table.getModel());
        printTable.setSize(printTable.getPreferredSize());
        JTableHeader tableHeader = printTable.getTableHeader();
        tableHeader.setSize(tableHeader.getPreferredSize());

        printTable.setShowHorizontalLines(false);
        printTable.setShowVerticalLines(false);
        printTable.print(JTable.PrintMode.FIT_WIDTH);
        */
        
        /*
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
*/
    }
}
