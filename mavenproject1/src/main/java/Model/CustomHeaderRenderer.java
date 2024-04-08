package Model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class CustomHeaderRenderer implements TableCellRenderer {
    DefaultTableCellRenderer renderer;

    public CustomHeaderRenderer() {
        renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER); // Align header content to left
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        component.setBackground(Color.WHITE); 
        component.setForeground(Color.BLACK);

        Border border = BorderFactory.createLineBorder(new java.awt.Color(204,204,204)); 

        // border 
        ((JComponent) component).setBorder(border);
        
        return component;
    }
}
