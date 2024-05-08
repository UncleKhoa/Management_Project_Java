/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author MY PC
 */
public class CustomTableCellRenderer extends DefaultTableCellRenderer{
    private int selectedRow = -1;
     @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

      
        // Kiểm tra xem hàng có được chọn không
        if (row == selectedRow) {
            // Nếu hàng được chọn, thiết lập màu nền
            rendererComponent.setBackground(Color.GREEN); // Thay đổi màu nền tùy ý
             rendererComponent.setForeground(Color.BLACK);
        } else {
            // Nếu không, sử dụng màu nền mặc định
            rendererComponent.setBackground(Color.WHITE);
            rendererComponent.setForeground(Color.BLACK);
        }

        return rendererComponent;
    }
     public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }
}

