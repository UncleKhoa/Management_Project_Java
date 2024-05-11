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
    Font font = new Font("Segoe UI", Font.PLAIN, 14);
    
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
    
     public void addLine(customerDTO bh_kh){
        model.addRow(new Object[]{
            bh_kh.getCusID(), bh_kh.getLastName(), bh_kh.getSldon(), formatMoney(ConvertDoubleToInt(bh_kh.getTongtien())) + "đ"
        });  
    }
    
    public void viewData(JTable tblBHKH, ArrayList<customerDTO> list){
        int s=0;
        convertBackgroundOfTable(tblBHKH);
        String[] headers = {"Mã khách hàng", "Tên khách", "Số lượng đơn", "Tổng tiền"}; // Đặt tiêu đề cột của bảng
        model = new NonEditableTableModel(new Object[0][headers.length], headers);            
        tblBHKH.setModel(model);
        tblBHKH.setRowHeight(30);
        tblBHKH.setFont(font);
        
        CustomTableCellRenderer centerRenderer = new CustomTableCellRenderer();
        tblBHKH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblBHKH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        
        removeData();
        for(customerDTO dt_bh:list){
            addLine(dt_bh);
            s+=dt_bh.getTongtien();
        }       
        model.addRow(new Object[]{
            "","","Tổng",formatMoney(s)+"đ"
        });
    }

    public void removeData(){
        int rowCount = model.getRowCount();
        for (int i=rowCount-1;i>=0;i--){
            model.removeRow(i);
        }
    }
    
}