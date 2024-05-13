/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.StatisticGUI;
import DTO.doanhthuDTO;
import BUS.doanhthuBUS;
import Model.CustomHeaderRenderer;
import Model.CustomTableCellRenderer;
import Model.NonEditableTableModel;
import static Model.helpers.ConvertDoubleToInt;
import static Model.helpers.convertBackgroundOfTable;
import static Model.helpers.formatMoney;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import static Model.helpers.*;
import java.text.ParseException;
import javax.swing.JTable;
/**
 *
 * @author Bon Nguyen
 */
public class ThongKeDT_TheoNgayTable extends javax.swing.JPanel {
    DefaultTableModel model;    
    Date start;
    Date end;
    private ArrayList<doanhthuDTO> ds_dttn;
    Font font = new Font("Segoe UI", Font.PLAIN, 14);
    /**
     * Creates new form ThongKeDT_TheoNgay
     */
    public ThongKeDT_TheoNgayTable(Date from, Date to) throws ParseException {
        initComponents();
        doanhthuBUS doanhthuBUS = new doanhthuBUS();
        this.start = from;
        this.end = to;        
        ds_dttn = doanhthuBUS.getLoiNhuanBanHang_NgayBan(start, end);
        JTableHeader header = tblDTTheoNgay.getTableHeader();
        header.setDefaultRenderer(new CustomHeaderRenderer());
        doanhthuBUS.viewData_TN(tblDTTheoNgay, ds_dttn);
    }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDTTheoNgay = new javax.swing.JTable();

        tblDTTheoNgay.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDTTheoNgay);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public JTable getList_DTTN(){
        return tblDTTheoNgay;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDTTheoNgay;
    // End of variables declaration//GEN-END:variables
}
