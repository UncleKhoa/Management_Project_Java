/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.promotionDAO;
import DAO.staffDAO;
import DTO.promotionDTO;
import DTO.staffDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bon Nguyen
 */
public class promotionBUS {
    private ArrayList<promotionDTO> dsPromo;
    private promotionDAO promotionDAO;

    public promotionBUS(){
        list();
    }
    
    public void list() {
        promotionDAO promotionDAO = new promotionDAO();
        dsPromo = new ArrayList<>();
        dsPromo = promotionDAO.list();
    }
    
    public ArrayList<promotionDTO> getList() {
        return dsPromo;
    }
    
    public Date Convert_date(String date) throws ParseException{
        java.util.Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        return date1;
    }
    
    public boolean Compare_Date(Date date_from, Date date_to){
        if(date_to.after(date_from) == true){
            return true;
        }
        else return false;
    }
    
    public java.sql.Date Convert_date_SQL(Date date){
        // Chuyển đổi sang kiểu dữ liệu Date của Java
        java.sql.Date Date = new java.sql.Date(date.getTime());

        // Trả về giá trị đã chuyển đổi
        return Date;
    }
    
    
    
//    public int Calculate_Date(Date date_from, Date date_to){
//        
//    }
    
}
