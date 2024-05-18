/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.customerDTO;
import java.util.ArrayList;
import DAO.banhangDAO;
import Model.CustomTableCellRenderer;
import Model.NonEditableTableModel;
import Model.helpers;
import static Model.helpers.ConvertDoubleToInt;
import static Model.helpers.convertBackgroundOfTable;
import static Model.helpers.formatMoney;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bon Nguyen
 */
public class banhangBUS {
    DefaultTableModel model;
    private ArrayList<customerDTO> ds_bhkh;
    private ArrayList<customerDTO> ds_bhkh_chart;
    
    //bán hàng khách hàng table
    public banhangBUS(){
        list_bhkh();
        list_bhkh_Chart();
    }
    
    public ArrayList<customerDTO> Get_ListBHKH(){
        return ds_bhkh;
    }
    
    public void list_bhkh(){
        banhangDAO banhangDAO = new banhangDAO();
        ds_bhkh = new ArrayList<>();
        ds_bhkh = banhangDAO.list();
    }
    
    //bán hàng khách hàng chart
    public ArrayList<customerDTO> Get_ListBHKH_Chart(){
        return ds_bhkh_chart;
    }
    
    public void list_bhkh_Chart(){
        banhangDAO banhangDAO = new banhangDAO();
        ds_bhkh_chart = new ArrayList<>();
        ds_bhkh_chart = banhangDAO.list_Chart();
    }
    
}
