/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bon Nguyen
 */
public class helpers {
    static public void convertBackgroundOfTable(JTable table)
    {        
        Color ivory = new Color(255, 255, 255);

        table.setOpaque(true);
        table.setFillsViewportHeight(true);
        table.setBackground(ivory);
        
    }
    
    static public void Export_Excell(JTable tableNCC){
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                //FileWriter out = new FileWriter(file+".xlsx");
                FileOutputStream out = new FileOutputStream(file+".xls");
                Writer writer = new java.io.OutputStreamWriter((out), "utf8");
                try (BufferedWriter bwrite = new BufferedWriter(writer)) {
                    DefaultTableModel model = (DefaultTableModel) tableNCC.getModel();
                    
                    // ten Cot
                    for (int j = 0; j < tableNCC.getColumnCount(); j++) {
                        bwrite.write(model.getColumnName(j) + "\t");
                    }
                    bwrite.write("\n");
                    
                    // Lay du lieu dong
                    for (int j = 0; j < tableNCC.getRowCount(); j++) {
                        for (int k = 0; k < tableNCC.getColumnCount(); k++) {
                            bwrite.write(model.getValueAt(j, k) + "\t");
                        }
                        bwrite.write("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
                System.out.println(e2);
            }
        }
    }
    
    static public ArrayList<Object[]> copyTableData(int selectedRow, JTable sourceTable, JTable destinationTable) {
        selectedRow = sourceTable.getSelectedRow();
        ArrayList<Object[]> new_list = new ArrayList<>();
        if (selectedRow != -1) {
            // Lấy dữ liệu từ dòng được chọn
            Object[] rowData = new Object[sourceTable.getColumnCount()];
            for (int i = 0; i < sourceTable.getColumnCount(); i++) {
                rowData[i] = sourceTable.getValueAt(selectedRow, i);
            }

            // Thêm dữ liệu vào bảng đích
            DefaultTableModel model = (DefaultTableModel) destinationTable.getModel();
            model.addRow(rowData);
            
            Object[] copiedRow = new Object[rowData.length];
            System.arraycopy(rowData, 0, copiedRow, 0, rowData.length);
            new_list.add(copiedRow);

            // Xóa dòng dữ liệu đã thêm
            DefaultTableModel productModel = (DefaultTableModel) sourceTable.getModel();
            productModel.removeRow(selectedRow);

        }
        return new_list;
    }
    
    static public ArrayList<Object> getItem(ArrayList<Object[]> copiedDataList, ArrayList<Object> newlist) {
        for (Object[] rowData : copiedDataList) {
            newlist.add(rowData);
        }
        return newlist;
    }
   
    
    static public ArrayList<String> new_ARR(int t, ArrayList<Object> newList){
        ArrayList<String> list_add = new ArrayList<>();
        for (Object object : newList) {
            if (object instanceof Object[]) {
                Object[] rowData = (Object[]) object;
                // Kiểm tra xem rowData có đủ phần tử không trước khi truy cập vào phần tử thứ hai
                if (rowData.length > 1) {
//                    System.out.println(rowData[0]);
                    list_add.add(rowData[0].toString());
                } else {
                    System.out.println("Không đủ phần tử trong mảng rowData");
                }
            } else {
                System.out.println("Không phải là một mảng đối tượng");
            }
        }
        return list_add;
    }

    
}
