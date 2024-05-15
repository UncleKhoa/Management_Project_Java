/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.importDTO;
import DAO.importDAO;
import DTO.receptDTO;
import Model.CustomTableCellRenderer;
import Model.NonEditableTableModel;
import java.util.ArrayList;
import static Model.helpers.*;
import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bon Nguyen
 */
public class importBUS {
    Font font = new Font("Segoe UI", Font.PLAIN, 14);
    DefaultTableModel model;
    ArrayList<importDTO> ds_nh;
    ArrayList<importDTO> listdata;
    
    public importBUS(){
        list_NH();
    }
    
    public void list_NH(){
        importDAO importDAO = new importDAO();
        ds_nh = new ArrayList<>();
        ds_nh = importDAO.list();
    }
    
    public ArrayList<importDTO> getListImport(){
        return ds_nh;
    }
    
    public ArrayList<importDTO> getListPrice(int a, int b){
        ArrayList<importDTO> newlist = new ArrayList<>();
        ArrayList<importDTO> list_old = ds_nh;
        for(importDTO nh:list_old){
            if(ConvertDoubleToInt(nh.getTotal())>=a && ConvertDoubleToInt(nh.getTotal())<=b){
                newlist.add(nh);
            }
        }
        return newlist;
    }
    
    public ArrayList<importDTO> getPhieunhap_NgayBan(Date dateStart, Date dateEnd) {
        listdata = getListImport();
        ArrayList<importDTO> new_listdata = new ArrayList<>();
        for(importDTO nh:listdata){
            try{
                if(compareDate(nh.getCreatedDate(), dateStart, dateEnd)){
                    new_listdata.add(nh);
                }                
            }
            catch(ParseException ex){
                
            }
        }
        return new_listdata;
    }
    
    public Boolean compareDate(Date dateBanHang, Date dateStart, Date dateEnd) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String datestart2 = sdf.format(dateStart);
        String dateEnd2 = sdf.format(dateEnd);
        Date datestart22 = formatter.parse(datestart2);
        Date dateEnd22 = formatter.parse(dateEnd2);

        return (dateBanHang.compareTo(datestart22) >= 0 && dateBanHang.compareTo(dateEnd22) <= 0);
    }
    
    public void addLine_Import(importDTO nh) throws ParseException {
        model.addRow(new Object[]{
            nh.getImporID(), nh.getSupplierID(), nh.getStaffID(), Convert_date(nh.getCreatedDate()), formatMoney(ConvertDoubleToInt(nh.getTotal())) + "đ"
        });
    }

    

    public void viewTableImport(JTable tblImport, ArrayList<importDTO> list) throws ParseException {
        convertBackgroundOfTable(tblImport);
        String[] headers = {"Mã đơn", "Mã NCC", "Mã nhân viên", "Ngày tạo đơn", "Tổng tiền"}; // Đặt tiêu đề cột của bảng
        model = new NonEditableTableModel(new Object[0][headers.length], headers);
        tblImport.setModel(model);
        tblImport.setRowHeight(30);
        tblImport.setFont(font);

        CustomTableCellRenderer centerRenderer = new CustomTableCellRenderer();
        tblImport.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblImport.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblImport.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblImport.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        tblImport.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblImport.getColumnModel().getColumn(1).setPreferredWidth(50);

        removeData();
        for (importDTO nh : list) {
            addLine_Import(nh);
        }
    }
    
    public void removeData() {
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    public void add(importDTO i) throws SQLException
    {
        importDAO dao =new importDAO();
        dao.add(i);
    }
      public String createId()
    {
        importDAO dao = new importDAO();
        String maKh;
        ds_nh = new ArrayList<>();
        ds_nh= dao.list();
        int l = ds_nh.size();
        l = l + 1;
        if (l < 10) {
            maKh = "PN0" + String.valueOf(l);
        } else {
            maKh = "PN" + String.valueOf(l);
        }

        return maKh;

    }
    
}
