/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.DoanhThuDAO;
import DTO.doanhthuDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Bon Nguyen
 */
public class doanhthuBUS {
    private ArrayList<doanhthuDTO> ds_dtsp;
    private ArrayList<doanhthuDTO> ds_dtsp_chart;
    private ArrayList<doanhthuDTO> ds_dttn;
    private ArrayList<doanhthuDTO> ds_dttn_chart;
    private ArrayList<doanhthuDTO> listdata;
    private ArrayList<doanhthuDTO> listdata_chart;
    
    public doanhthuBUS(){
        list_SP();
        list_SP_chart();
        list_TN();
        list_TN_chart();
    }
    
    //Doanh thu sản phẩm
    public ArrayList<doanhthuDTO> getList_DTSP(){
        return ds_dtsp;
    }
    
    public void list_SP(){
        DoanhThuDAO DoanhthuDao = new DoanhThuDAO();
        ds_dtsp = new ArrayList<>();
        ds_dtsp = DoanhthuDao.getDT_SanPham();
    }
    
    //Doanh thu sản phẩm chart
    public void list_SP_chart(){
        DoanhThuDAO DoanhthuDao = new DoanhThuDAO();
        ds_dtsp_chart = new ArrayList<>();
        ds_dtsp_chart = DoanhthuDao.getDT_SanPham_Chart();
    }
    
    public ArrayList<doanhthuDTO> getList_DTSP_Chart() {
        return ds_dtsp_chart;
    }
    
    //doanh thu theo ngày
    public void list_TN(){
        DoanhThuDAO DoanhthuDao = new DoanhThuDAO();
        ds_dttn = new ArrayList<>();
        ds_dttn = DoanhthuDao.getDT_TheoNgay();
    }
    
    public ArrayList<doanhthuDTO> getList_DTTN(){
        return ds_dttn;
    }
    
    public ArrayList<doanhthuDTO> getLoiNhuanBanHang_NgayBan(Date dateStart, Date dateEnd) {
        listdata = getList_DTTN();
        ArrayList<doanhthuDTO> new_listdata = new ArrayList<>();
        for(doanhthuDTO dttn:listdata){
            try{
                if(compareDate(dttn.getNgayban(), dateStart, dateEnd)){
                    new_listdata.add(dttn);
                }                
            }
            catch(ParseException ex){
                
            }
        }
        return new_listdata;
    }
    
    //doanh thu theo ngày chart
    public void list_TN_chart(){
        DoanhThuDAO DoanhthuDao = new DoanhThuDAO();
        ds_dttn_chart = new ArrayList<>();
        ds_dttn_chart = DoanhthuDao.getDT_TheoNgay_Chart();
    }
    
    public ArrayList<doanhthuDTO> getList_DTTN_Chart(){
        return ds_dttn_chart;
    }
    
    public ArrayList<doanhthuDTO> getLoiNhuanBanHang_NgayBan_Chart(Date dateStart, Date dateEnd) {
        listdata_chart = getList_DTTN_Chart();
        ArrayList<doanhthuDTO> new_listdata = new ArrayList<>();
        for(doanhthuDTO dttn:listdata_chart){
            try{
                if(compareDate(dttn.getNgayban(), dateStart, dateEnd)){
                    new_listdata.add(dttn);
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
        Boolean flag = false;

        if (dateBanHang.after(datestart22) == true && dateEnd22.after(dateBanHang) == true) {
            flag = true;
        }
        return flag;
    }
    
}
