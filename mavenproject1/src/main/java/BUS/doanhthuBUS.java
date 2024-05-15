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
    private ArrayList<doanhthuDTO> listdata;
    private ArrayList<doanhthuDTO> listdata_chart;

    public doanhthuBUS() {
        list_SP();
        list_SP_chart();
        list_TN();
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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String datestart2 = sdf.format(dateStart);
        String dateEnd2 = sdf.format(dateEnd);
        Date datestart22 = formatter.parse(datestart2);
        Date dateEnd22 = formatter.parse(dateEnd2);

        return (dateBanHang.compareTo(datestart22) >= 0 && dateBanHang.compareTo(dateEnd22) <= 0);
    }

    public void addLine(doanhthuDTO dt_sp) {
        model.addRow(new Object[]{
            dt_sp.getProductName(), dt_sp.getSLBan(), formatMoney(ConvertDoubleToInt(dt_sp.getTiensauKM())) + "đ"
        });
    }

    public void viewData(JTable tblDTSP, ArrayList<doanhthuDTO> list) {
        int s = 0;
        convertBackgroundOfTable(tblDTSP);
        String[] headers = {"Tên sản phẩm", "Số lượng bán", "Doanh thu"}; // Đặt tiêu đề cột của bảng
        model = new NonEditableTableModel(new Object[0][headers.length], headers);
        tblDTSP.setModel(model);
        tblDTSP.setRowHeight(30);
        tblDTSP.setFont(font);

        CustomTableCellRenderer centerRenderer = new CustomTableCellRenderer();
        tblDTSP.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblDTSP.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        removeData();
        for (doanhthuDTO dt_sp : list) {
            addLine(dt_sp);
            s += dt_sp.getTiensauKM();
        }
        model.addRow(new Object[]{
            "", "Tổng", formatMoney(s) + "đ"
        });
    }

    public void addLine_TN(doanhthuDTO dt_tn) {
        model.addRow(new Object[]{
            dt_tn.getNgayban(), dt_tn.getSLdon(), dt_tn.getSLSP(), formatMoney(ConvertDoubleToInt(dt_tn.getTongtien())) + "đ"
        });
    }

    public void viewData_TN(JTable tblDTTheoNgay, ArrayList<doanhthuDTO> list) {
        int s = 0;
        convertBackgroundOfTable(tblDTTheoNgay);
        String[] headers = {"Ngày bán", "Số lượng đơn", "Số lượng SP", "Tổng tiền"}; // Đặt tiêu đề cột của bảng
        model = new NonEditableTableModel(new Object[0][headers.length], headers);
        tblDTTheoNgay.setModel(model);
        tblDTTheoNgay.setRowHeight(30);
        tblDTTheoNgay.setFont(font);

        CustomTableCellRenderer centerRenderer = new CustomTableCellRenderer();
        tblDTTheoNgay.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblDTTheoNgay.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblDTTheoNgay.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        for (doanhthuDTO dttn : list) {
            addLine_TN(dttn);
            s += dttn.getTongtien();
        }
        model.addRow(new Object[]{
            "", "", "Tổng", formatMoney(s) + "đ"
        });

    }

    public void removeData() {
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

}
