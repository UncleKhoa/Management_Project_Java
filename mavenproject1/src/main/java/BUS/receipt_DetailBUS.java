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
    Font font = new Font("Segoe UI", Font.PLAIN, 14);

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
    
    public void addLine_TN(receptDetailDTO xem_cthd) {
        model.addRow(new Object[]{
            xem_cthd.getPromotionID(), xem_cthd.getProductID(), xem_cthd.getQuantity(), formatMoney(ConvertDoubleToInt(xem_cthd.getUnitPrice()))+"đ", formatMoney(ConvertDoubleToInt(xem_cthd.getSubTotal()))+"đ"
        });
    }
    
    public void viewData(JTable table, ArrayList<receptDetailDTO> list){
        int s = 0;
        convertBackgroundOfTable(table);
        String[] headers = {"Mã khuyến mãi", "Tên sản phẩm", "Số lượng", "Giá thực", "Giá sau KM"}; // Đặt tiêu đề cột của bảng
        model = new NonEditableTableModel(new Object[0][headers.length], headers);
        table.setModel(model);
        table.setRowHeight(30);
        table.setFont(font);

        CustomTableCellRenderer centerRenderer = new CustomTableCellRenderer();        
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        for (receptDetailDTO xem : list) {
            addLine_TN(xem);
        }
//        model.addRow(new Object[]{
//            "", "", "Tổng", formatMoney(s) + "đ"
//        });
    }
    
    public void removeData() {
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

}
