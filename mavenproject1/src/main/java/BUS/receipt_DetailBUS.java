/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.receipt_DetailDAO;
import DTO.receptDetailDTO;
import DTO.receptDTO;
import Model.CustomTableCellRenderer;
import Model.NonEditableTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import static Model.helpers.*;
import java.awt.Font;
import javax.swing.JTable;

/**
 *
 * @author MY PC
 */
public class receipt_DetailBUS {
    DefaultTableModel model;
    private ArrayList<receptDetailDTO> cthd;
    private ArrayList<receptDetailDTO> xemcthd;    

    public receipt_DetailBUS() {
        list();
        list_info();
    }

    public void list() {
        receipt_DetailDAO dao = new receipt_DetailDAO();
        cthd = new ArrayList<>();
        cthd = dao.list();
    }

    public void add(receptDetailDTO receipt) throws SQLException {
        receipt_DetailDAO dao = new receipt_DetailDAO();
        dao.add(receipt);
    }

    public int list_size() {
        receipt_DetailDAO dao = new receipt_DetailDAO();
        cthd = new ArrayList<>();
        cthd = dao.list();
        int l = cthd.size();
        return l;
    }

    public String createId(int l, int row) {
        //row = row+1;
        l = l + row;
        String machd;
        if (l < 10) {
            machd = "CHD0" + String.valueOf(l);
        } else {
            machd = "CHD" + String.valueOf(l);
        }

        return machd;
    }
    
    public void list_info(){
        receipt_DetailDAO cthd_dao = new receipt_DetailDAO();
        xemcthd = new ArrayList<>();
        xemcthd = cthd_dao.list_Info();
    }
    
    public ArrayList<receptDetailDTO> getList_Xem(){
        return xemcthd;
    }
    
    public ArrayList<receptDetailDTO> XemChiTietHD(receptDTO hd){
        xemcthd = getList_Xem();
        ArrayList<receptDetailDTO> list_new = new ArrayList<>();
        for(receptDetailDTO xem:xemcthd){
            if(xem.getReceptID().equals(hd.getReceptID())){
                list_new.add(xem);
            }
        }
        return list_new;
    }    

}
