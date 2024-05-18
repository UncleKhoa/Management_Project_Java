/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DoanhThuDAO;
import DTO.doanhthuDTO;
import Model.CustomTableCellRenderer;
import Model.NonEditableTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static Model.helpers.*;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bon Nguyen
 */
public class doanhthuBUS {

    DefaultTableModel model;
    Font font = new Font("Segoe UI", Font.PLAIN, 14);
    private ArrayList<doanhthuDTO> ds_dtsp;
    private ArrayList<doanhthuDTO> ds_dtsp_chart;
    private ArrayList<doanhthuDTO> ds_dttn;
    private ArrayList<doanhthuDTO> ds_dttn_chart;
    private ArrayList<doanhthuDTO> ds_dttq;
    private ArrayList<doanhthuDTO> listdata;
    private ArrayList<doanhthuDTO> listdata_chart;

    public doanhthuBUS() {
        list_SP();
        list_SP_chart();
        list_TN();
        List_TheoQuy();
    }

    //Doanh thu sản phẩm
    public ArrayList<doanhthuDTO> getList_DTSP() {
        return ds_dtsp;
    }

    public void list_SP() {
        DoanhThuDAO DoanhthuDao = new DoanhThuDAO();
        ds_dtsp = new ArrayList<>();
        ds_dtsp = DoanhthuDao.getDT_SanPham();
    }

    //Doanh thu sản phẩm chart
    public void list_SP_chart() {
        DoanhThuDAO DoanhthuDao = new DoanhThuDAO();
        ds_dtsp_chart = new ArrayList<>();
        ds_dtsp_chart = DoanhthuDao.getDT_SanPham_Chart();
    }

    public ArrayList<doanhthuDTO> getList_DTSP_Chart() {
        return ds_dtsp_chart;
    }

    //doanh thu theo ngày
    public void list_TN() {
        DoanhThuDAO DoanhthuDao = new DoanhThuDAO();
        ds_dttn = new ArrayList<>();
        ds_dttn = DoanhthuDao.getDT_TheoNgay();
    }

    public ArrayList<doanhthuDTO> getList_DTTN() {
        return ds_dttn;
    }

    public ArrayList<doanhthuDTO> getLoiNhuanBanHang_NgayBan(Date dateStart, Date dateEnd) {
        listdata = getList_DTTN();
        ArrayList<doanhthuDTO> new_listdata = new ArrayList<>();
        for (doanhthuDTO dttn : listdata) {
            try {
                if (compareDate(dttn.getNgayban(), dateStart, dateEnd)) {
                    new_listdata.add(dttn);
                }
            } catch (ParseException ex) {

            }
        }
        return new_listdata;
    }

    //doanh thu theo ngày chart
    public ArrayList<doanhthuDTO> getLoiNhuanBanHang_NgayBan_Chart(Date Start, Date End) {
        try {
            DoanhThuDAO DoanhthuDao = new DoanhThuDAO();
            ds_dttn_chart = new ArrayList<>();
            ds_dttn_chart = DoanhthuDao.getDT_TheoNgay_Chart(Convert_date(Start), Convert_date(End));
        } catch (ParseException ex) {
            Logger.getLogger(doanhthuBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds_dttn_chart;
    }

    public Boolean compareDate(Date dateBanHang, Date dateStart, Date dateEnd) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String datestart2 = sdf.format(dateStart);
        String dateEnd2 = sdf.format(dateEnd);
        Date datestart22 = sdf.parse(datestart2);
        Date dateEnd22 = sdf.parse(dateEnd2);

        return (dateBanHang.compareTo(datestart22) >= 0 && dateBanHang.compareTo(dateEnd22) <= 0);
    }
    
    //Doanh thu theo quý
    public void List_TheoQuy(){
        DoanhThuDAO doanhthuDAO = new DoanhThuDAO();
        ds_dttq = new ArrayList<>();
        ds_dttq = doanhthuDAO.getList_LoiNhuanQuy();
    }
    
    public ArrayList<doanhthuDTO> GetList_DTTQ(){
        return ds_dttq;
    }   

}
