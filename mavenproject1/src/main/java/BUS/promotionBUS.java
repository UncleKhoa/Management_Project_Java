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
import Model.NonEditableTableModel;
import static Model.helpers.convertBackgroundOfTable;
import java.awt.Font;
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
    Font font = new Font("Segoe UI", Font.PLAIN, 14);
    DefaultTableModel model;
    private ArrayList<promotionDTO> dsPromo;
    private ArrayList<promotion_detailDTO> dsPromo_detail;
    private promotionDAO promotionDAO;
    private promotion_detailDAO promotion_detailDAO;

    public promotionBUS(){
        list();
    }
    
    public void list() {
        promotionDAO promotionDAO = new promotionDAO();       
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
        list();
        return dsPromo;
    }
    
    public ArrayList<promotion_detailDTO> getList_detail(String id){
        promotion_detailDAO promotion_detailDAO = new promotion_detailDAO();
        dsPromo_detail = new ArrayList<>();
        dsPromo_detail = promotion_detailDAO.list(id);
        return dsPromo_detail;
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
    
    public void Up_Active(String id, String a){
        promotionDAO promotionDAO = new promotionDAO();
        promotionDAO.Activation(id, a);
    }
    
    public String Get_name(String id){
        promotion_detailDAO promotion_detailDAO = new promotion_detailDAO();
        String name = promotion_detailDAO.Get_Name(id);
        return name;

    }
    
    public ArrayList<promotionDTO> getList_Search(String a) {    
        ArrayList<promotionDTO> oldlist = dsPromo;
        ArrayList<promotionDTO> newList = new ArrayList<>();
        for(promotionDTO promo:oldlist){
            if(promo.getPromotionID().toLowerCase().contains(a.toLowerCase())){
                newList.add(promo);
            }
        }
        return newList;
    }
    
    public boolean Check_Code(String code){
        ArrayList<promotionDTO> newlist = dsPromo;
        for(promotionDTO promo:newlist){
            if(promo.getPromotionID().equals(code)){
                return true;
            }
        }
        return false;
    }
    
    public void addLineData(promotionDTO promo)
    {
    model.addRow(new Object[]{
           promo.getPromotionID(), promo.getDescription(), Date_String(promo.getFrom()), Date_String(promo.getTo()), String.format("%.1f", promo.getPromotionPercent()*100) + " %", promo.getStatus()
        });
    }   
    
    public void viewData(JTable tablePromotion, ArrayList<promotionDTO> list){
        
        convertBackgroundOfTable(tablePromotion);
        
        String[] headers = {"MÃ CODE", "MÔ TẢ", "TỪ NGÀY", "ĐẾN NGÀY", "PHẦN TRĂM", "TRẠNG THÁI"}; // Đặt tiêu đề cột của bảng
        model = new NonEditableTableModel(new Object[0][headers.length], headers);       
        
        tablePromotion.setModel(model);
        
        tablePromotion.getColumnModel().getColumn(0).setPreferredWidth(70);
        tablePromotion.getColumnModel().getColumn(1).setPreferredWidth(110);
        tablePromotion.getColumnModel().getColumn(2).setPreferredWidth(90);
        tablePromotion.getColumnModel().getColumn(3).setPreferredWidth(90);
        tablePromotion.getColumnModel().getColumn(4).setPreferredWidth(90);
        tablePromotion.getColumnModel().getColumn(5).setPreferredWidth(98);
        tablePromotion.setRowHeight(30);
        tablePromotion.setFont(font);
        removeData();
        for(promotionDTO promo:list){
            addLineData(promo);
        }
    }
    
    public void removeData(){
        int rowCount = model.getRowCount();
        for (int i=rowCount-1;i>=0;i--){
            model.removeRow(i);
        }
    }
    
//    public int Calculate_Date(Date date_from, Date date_to){
//        
//    }
    
}
