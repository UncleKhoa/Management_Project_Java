/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.StatisticGUI;
import BUS.doanhthuBUS;
import DTO.doanhthuDTO;
import Model.CustomHeaderRenderer;
import Model.CustomTableCellRenderer;
import Model.NonEditableTableModel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static Model.helpers.*;
import java.awt.Font;
import java.util.Collection;
import java.util.Collections;
import javax.swing.table.JTableHeader;
/**
 *
 * @author Bon Nguyen
 */
public class ThongKeDT_LoiNhuanTable extends javax.swing.JPanel {
    Font font = new Font("Segoe UI", Font.PLAIN, 14);
    DefaultTableModel model;
    doanhthuBUS doanhthuBUS;
    
    ArrayList<doanhthuDTO> ds_dttq = new ArrayList<>();
    /**
     * Creates new form ThongKeDT_LoiNhuanTable
     */
    public ThongKeDT_LoiNhuanTable() {
        initComponents();
        JTableHeader header1 = tblLoiNhuan.getTableHeader();
        header1.setDefaultRenderer(new CustomHeaderRenderer());
        doanhthuBUS = new doanhthuBUS();
        ds_dttq = doanhthuBUS.GetList_DTTQ();        
        ds_dttq = new ArrayList<>(ds_dttq);
        Collections.reverse(ds_dttq);
        viewData(tblLoiNhuan, ds_dttq);
    }
    
    public void addLineData(doanhthuDTO dtln){
        model.addRow(new Object[]{
           dtln.getYear(), dtln.getQuarter(), formatMoneyLong(ConvertDoubleToLong(dtln.getTienvon()))+"đ", formatMoneyLong(ConvertDoubleToLong(dtln.getTiensauKM()))+"đ", formatMoneyLong(ConvertDoubleToLong(dtln.getTienlai()))+"đ"
        });
    }
    
    public void viewData(JTable tbl, ArrayList<doanhthuDTO> list){
        convertBackgroundOfTable(tbl);
        
        String[] headers = {"Năm", "Quý", "Tiền vốn", "Doanh thu", "Lợi nhuận"};
        model = new NonEditableTableModel(new Object[0][headers.length], headers);
        
        tbl.setModel(model);
        tbl.setRowHeight(30);
        tbl.setFont(font);
        
        CustomTableCellRenderer centerRenderer = new CustomTableCellRenderer();
        tbl.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbl.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        
        tbl.getColumnModel().getColumn(0).setPreferredWidth(2);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(2);
        
        removeData();
        for(doanhthuDTO dtln:list){
            addLineData(dtln);
        }
        
    }
    
    public void removeData(){
        int rowCount = model.getRowCount();
        for(int i=rowCount;i>0;i--){
            model.removeRow(i);
        }
    }   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoiNhuan = new javax.swing.JTable();

        tblLoiNhuan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblLoiNhuan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLoiNhuan;
    // End of variables declaration//GEN-END:variables
}
