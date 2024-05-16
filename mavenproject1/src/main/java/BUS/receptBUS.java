/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.receptDAO;
import DTO.receptDTO;
import Model.CustomTableCellRenderer;
import Model.NonEditableTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import static Model.helpers.*;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MY PC
 */
public class receptBUS {
    DefaultTableModel model;
    private ArrayList<receptDTO> dshd;
    private ArrayList<receptDTO> listdata;
    private ArrayList<receptDTO> listname;

    public receptBUS() {
        list();
        listName();
    }

    public void list() {
        receptDAO dao = new receptDAO();
        dshd = new ArrayList<>();
        dshd = dao.list();
    }
    
    public ArrayList<receptDTO> getListReceipt(){
        return dshd;
    }

    public void add(receptDTO recept) throws SQLException {
        receptDAO dao = new receptDAO();
        dao.add(recept);
    }

    public String createId() {
        receptDAO dao = new receptDAO();
        String maHh;
        dshd = new ArrayList<>();
        dshd = dao.list();
        int l = dshd.size();
        l = l + 1;
        if (l < 10) {
            maHh = "HD0" + String.valueOf(l);
        } else {
            maHh = "HD" + String.valueOf(l);
        }

        return maHh;
    }

    public int Get_SLHD() {
        int s = 0;
        receptDAO receptDAO = new receptDAO();
        s = receptDAO.TongDonHang();
        return s;
    }
    
    //Lọc hóa đơn theo mã
    public ArrayList<receptDTO> timHoaDonTheoMa(String id) {
        ArrayList<receptDTO> ketQua = new ArrayList<>();
        ArrayList<receptDTO> list_old = dshd;
        for (receptDTO hd : list_old) {
            if (hd.getReceptID().toLowerCase().contains(id.toLowerCase())) {
                ketQua.add(hd);
            }
        }
        return ketQua;
    }
    
    //Lọc hóa đơn theo giá tiền
    public ArrayList<receptDTO> getListPrice(int a, int b){
        ArrayList<receptDTO> newlist = new ArrayList<>();
        ArrayList<receptDTO> list_old = dshd;
        for(receptDTO hd:list_old){
            if(ConvertDoubleToInt(hd.getTotal())>=a && ConvertDoubleToInt(hd.getTotal())<=b){
                newlist.add(hd);
            }
        }
        return newlist;
    }
    
    //Lọc hóa đơn theo ngày
    public ArrayList<receptDTO> getHoadon_NgayBan(Date dateStart, Date dateEnd) {
        listdata = getListReceipt();
        ArrayList<receptDTO> new_listdata = new ArrayList<>();
        for(receptDTO hd:listdata){
            try{
                if(compareDate(hd.getCreatedTime(), dateStart, dateEnd)){
                    new_listdata.add(hd);
                }                
            }
            catch(ParseException ex){
                
            }
        }
        return new_listdata;
    }
    
    //Lấy danh sách tên khách hàng và nhân viên ứng với từng hóa đơn
    public void listName(){
        receptDAO receptDAO = new receptDAO();
        listname = new ArrayList<>();
        listname = receptDAO.list_Name();
    }
    
    public ArrayList<receptDTO> get_ListName(){
        return listname;
    }
    
    //Lấy tên khách hàng và nhân viên theo đúng với hóa đơn
    public receptDTO get_Name_HD(receptDTO hd){
        listname = get_ListName();
        receptDTO get_obj = null;
        for(receptDTO name:listname){
            if(hd.getReceptID().equals(name.getReceptID())){
                get_obj = new receptDTO(name.getReceptID(), name.getCusID(), name.getStaffID(), name.getCusName(), name.getStaffName());                
                break;
            }
        }
        return get_obj;
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
    
}
