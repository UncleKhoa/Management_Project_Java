/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.SellGUI.raven.cell;

import java.awt.Color;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;
import java.awt.Component;

/**
 *
 * @author MY PC
 */
public class TableActionCellRender extends DefaultTableCellRenderer{
    
  @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
        Component com = super.getTableCellRendererComponent(jtable, o, isSeleted, bln1, row, column);
        ActionPanel action = new ActionPanel();
        if (isSeleted == false && row % 2 == 0) {
            action.setBackground(Color.WHITE);
        } else {
            action.setBackground(com.getBackground());
        }
        return action;
    }
    }
    


