package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Bon Nguyen
 */
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    
    public CustomTableCellRenderer() {
        // Gọi constructor của lớp cha
        super();
        // Thiết lập canh giữa cho dữ liệu trong ô
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}