/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.promotionDAO;
import DAO.promotion_detailDAO;
import DAO.staffDAO;
import DTO.promotionDTO;
import DTO.promotion_detailDTO;
import DTO.staffDTO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Bon Nguyen
 */
public class promotionBUS {
    private ArrayList<promotionDTO> dsPromo;
    private ArrayList<promotion_detailDTO> dsPromo_detail;
    private promotionDAO promotionDAO;
    private promotion_detailDAO promotion_detailDAO;

    public promotionBUS(){
        list();
    }
    
    public void list() {
        promotionDAO promotionDAO = new promotionDAO();
        promotion_detailDAO promotion_detailDAO = new promotion_detailDAO();
        dsPromo = new ArrayList<>();
        dsPromo = promotionDAO.list();
    }
    
    public void Add(promotionDTO promo){        
        try {
            dsPromo.add(promo);
            promotionDAO promotionDAO = new promotionDAO();
            promotionDAO.add(promo);
        } catch (SQLException ex) {
            Logger.getLogger(promotionBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Add_Detail(promotion_detailDTO promo_detail) {
        try {
            if (this.dsPromo_detail == null) {
                this.dsPromo_detail = new ArrayList<>();
            }
            
            // Thêm promo_detail vào danh sách
            dsPromo_detail.add(promo_detail);
            
            promotion_detailDAO promotion_detailDAO = new promotion_detailDAO();
            promotion_detailDAO.add(promo_detail);
        } catch (Exception ex) {
            // Xử lý exception nếu có lỗi
            System.out.println("Error in Add_Detail: " + ex.getMessage());
        }
    }
    
    public ArrayList<promotionDTO> getList() {
        return dsPromo;
    }
    
    public Date Convert_date(String date) throws ParseException{
        java.util.Date date1 = java.sql.Date.valueOf(date);
        return date1;
    }
    
    public boolean Compare_Date(Date date_from, Date date_to){
        if(date_to.after(date_from) == true){
            return true;
        }
        else return false;
    }
    
    public String Date_String(Date date){        
        if(date == null){
            return null;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date);
        
        return formattedDate;
    }  
    
    static public ArrayList getRow(int t, JTable table){
        ArrayList<Object> list = new ArrayList<>();
        TableModel model = table.getModel();
        
        int desireColumn = t;
        
        for(int row=0; row<model.getRowCount(); row++){
            Object value = model.getValueAt(row, desireColumn);
            list.add(value);
        }
        
        return list;
    }
    
//    public int Calculate_Date(Date date_from, Date date_to){
//        
//    }
    
}