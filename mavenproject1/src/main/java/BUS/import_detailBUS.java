/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.import_detailDTO;
import DAO.import_detailDAO;
import DTO.importDTO;
import DTO.receptDetailDTO;
import Model.CustomTableCellRenderer;
import Model.NonEditableTableModel;
import static Model.helpers.ConvertDoubleToInt;
import static Model.helpers.convertBackgroundOfTable;
import static Model.helpers.formatMoney;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static Model.helpers.*;
import java.sql.SQLException;

/**
 *
 * @author Bon Nguyen
 */
public class import_detailBUS {

    DefaultTableModel model;
    ArrayList<import_detailDTO> list;    

    public import_detailBUS() {
        list_detail();
    }

    public void list_detail() {
        import_detailDAO imDAO = new import_detailDAO();
        list = new ArrayList<>();
        list = imDAO.list();
    }

    public ArrayList<import_detailDTO> getList_NH() {
        return list;
    }

    //Xem chi tiết phiếu nhập
    public ArrayList<import_detailDTO> XemChiTietNH(importDTO nh) {
        ArrayList<import_detailDTO> new_list = new ArrayList<>();
        for (import_detailDTO pn : list) {
            if (pn.getImportID().equals(nh.getImporID())) {
                new_list.add(pn);
            }
        }
        return new_list;
    }

    public int list_size() {
        import_detailDAO dao = new import_detailDAO();
        list = new ArrayList<>();
        list = dao.list();
        int l = list.size();
        return l;
    }

    public String createId(int l, int row) {
        //row = row+1;
        l = l + row;
        String mapn;
        if (l < 10) {
            mapn = "CPN0" + String.valueOf(l);
        } else {
            mapn = "CPN" + String.valueOf(l);
        }

        return mapn;
    }

    public void add(import_detailDTO a) throws SQLException {
        import_detailDAO dao = new import_detailDAO();
        dao.add(a);
    }

}
