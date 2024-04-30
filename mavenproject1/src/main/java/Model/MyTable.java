/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Bon Nguyen
 */
public class MyTable extends JTable {
    public MyTable(){
        super();
        initialize();
    }
    
    private void initialize() {
        // Đặt model cho bảng
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Không cho phép chỉnh sửa nội dung trong bảng
                return false;
            }
        };
        
        JTableHeader tableHeader = getTableHeader();
        tableHeader.setBackground(Color.white);
        
    }
    
}
