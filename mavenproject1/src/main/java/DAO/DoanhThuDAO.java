/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import static DAO.DBConnect.getConnect;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.doanhthuDTO;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Bon Nguyen
 */
public class DoanhThuDAO {
    
    Connection conn = getConnect();
    
    public ArrayList<doanhthuDTO> getDT_SanPham(){
        ArrayList<doanhthuDTO> ds_dtsp = new ArrayList<>();
        try{
            String sql = "select sp.ProductName, SUM(cthd.Quantity) as SLBan, SUM(SubTotal) as TongTien "
            + "from receiptdetail cthd, product sp "
            + "where cthd.ProductID = sp.ProductID "
            + "group by cthd.ProductID";
            PreparedStatement stmt_DTSP = conn.prepareStatement(sql);
            ResultSet rs = stmt_DTSP.executeQuery();
            
            while(rs.next()){
                String productname = rs.getString("ProductName");
                int soluong = rs.getInt("SLBan");
                double tongtienban = rs.getDouble("TongTien");               
                doanhthuDTO doanhthuDTO = new doanhthuDTO("", productname, soluong, 0, tongtienban, 0);
                ds_dtsp.add(doanhthuDTO);
            }            
        }
        catch(SQLException ex){
            System.out.print(ex);
        }
        return ds_dtsp;
    }
    
    public ArrayList<doanhthuDTO> getDT_SanPham_Chart(){
        ArrayList<doanhthuDTO> ds_dtsp = new ArrayList<>();
        try{
            String sql = "select sp.ProductName, SUM(cthd.Quantity) as SLBan, SUM(cthd.SubTotal) as TongTien "
            + "from receiptdetail cthd, product sp "
            + "where cthd.ProductID = sp.ProductID "
            + "group by cthd.ProductID desc limit 5";
            PreparedStatement stmt_DTSP = conn.prepareStatement(sql);
            ResultSet rs = stmt_DTSP.executeQuery();
            
            while(rs.next()){
                String productname = rs.getString("ProductName");
                int sl = rs.getInt("SLBan");
                double total = rs.getDouble("TongTien");
                doanhthuDTO doanhthuDTO = new doanhthuDTO("", productname, sl, 0, total, 0);
                ds_dtsp.add(doanhthuDTO);
            }            
        }
        catch(SQLException ex){
            System.out.print(ex);
        }
        return ds_dtsp;
    }
    
    public ArrayList<doanhthuDTO> getDT_TheoNgay(){
        ArrayList<doanhthuDTO> ds_dttn = new ArrayList<>();
        try{
            String sql = "select hd.CreatedTime, count(DISTINCT hd.ReceiptID) as SLdon, sum(cthd.Quantity) as SLSP, sum(DISTINCT hd.Total) as Tongtien "
            + "from receiptdetail cthd, receipt hd "
            + "where hd.ReceiptID = cthd.ReceiptID "
            + "group by hd.CreatedTime DESC";
            PreparedStatement stmt_DTSP = conn.prepareStatement(sql);
            ResultSet rs = stmt_DTSP.executeQuery();
            
            while(rs.next()){
                Date ngayban = rs.getDate("CreatedTime");
                int SLdon = rs.getInt("SLdon");
                int SLSP = rs.getInt("SLSP");
                double tongtien = rs.getDouble("Tongtien");
                doanhthuDTO doanhthuDTO = new doanhthuDTO(SLdon, SLSP, tongtien, ngayban);
                ds_dttn.add(doanhthuDTO);
            }            
        }
        catch(SQLException ex){
            System.out.print(ex);
        }
        return ds_dttn;
    }
    
    public ArrayList<doanhthuDTO> getDT_TheoNgay_Chart(Date Start, Date End){
        ArrayList<doanhthuDTO> ds_dttn = new ArrayList<>();
        try{
            String sql = "select CreatedTime, COUNT(DISTINCT hd.ReceiptID) as SLdon, SUM(cthd.Quantity) as SLSP, SUM(DISTINCT hd.Total) as Tongtien "
                    + "FROM receipt as hd, receiptdetail as cthd "
                    + "WHERE hd.ReceiptID = cthd.ReceiptID AND CreatedTime BETWEEN '"+ Start +"' AND '"+ End +"' "
                    + "GROUP BY hd.CreatedTime";
            PreparedStatement stmt_DTSP = conn.prepareStatement(sql);
            ResultSet rs = stmt_DTSP.executeQuery();
            
            while(rs.next()){
                Date ngayban = rs.getDate("CreatedTime");
                int SLdon = rs.getInt("SLdon");
                int SLSP = rs.getInt("SLSP");
                double tongtien = rs.getDouble("Tongtien");
                doanhthuDTO doanhthuDTO = new doanhthuDTO(SLdon, SLSP, tongtien, ngayban);
                ds_dttn.add(doanhthuDTO);
            }            
        }
        catch(SQLException ex){
            System.out.print(ex);
        }
        return ds_dttn;
    }
    
    public ArrayList<doanhthuDTO> getList_LoiNhuanQuy() {
        ArrayList<doanhthuDTO> doanhthu = new ArrayList<>();
        try {
//            String sql = "select YEAR(hd.CreatedTime) as Year_hd, "
//                    + "CEILING(MONTH(hd.CreatedTime) / 3) as Quarter_hd, "
//                    + "SUM(hd.Total) as Total_hd, "
//                    + "YEAR(nh.Created_Time) as Year_nh, "
//                    + "CEILING(MONTH(nh.Created_Time) / 3) as Quarter_nh, "
//                    + "SUM(nh.Total) as Total_nh "
//                    + "from receipt hd, import nh "
//                    + "where YEAR(hd.CreatedTime) = YEAR(nh.Created_Time) AND QUARTER(hd.CreatedTime) = QUARTER(nh.Created_Time) "
//                    + "GROUP BY YEAR(hd.CreatedTime), CEILING(MONTH(hd.CreatedTime) / 3), YEAR(nh.Created_Time), CEILING(MONTH(nh.Created_Time) / 3) "
//                    + "ORDER BY Year_hd, Quarter_hd ASC";
            String sql = "select YEAR(hd.CreatedTime) as Year_hd, QUARTER(hd.CreatedTime) as Quarter_hd, SUM(hd.Total) as Total_hd, YEAR(MONTH(hd.CreatedTime)) as Year_nh, "
                    + "QUARTER(nh.Created_Time) as Quarter_nh, SUM(nh.Total) as Total_nh from receipt hd, import nh "
                    + "where YEAR(hd.CreatedTime) = YEAR(nh.Created_Time) "
                    + "AND QUARTER(hd.CreatedTime) = QUARTER(nh.Created_Time) GROUP BY YEAR(hd.CreatedTime), CEILING(MONTH(hd.CreatedTime) / 3), YEAR(nh.Created_Time),"
                    + " CEILING(MONTH(nh.Created_Time) / 3) ORDER BY Year_hd, Quarter_hd ASC";
            String sql = "WITH Receipt AS ( "
                    + "SELECT YEAR(CreatedTime) as Year_hd, "
                    + "CEILING(MONTH(CreatedTime) / 3) as Quarter_hd, "
                    + "SUM(Total) as Total_hd "
                    + "FROM receipt "
                    + "GROUP BY YEAR(CreatedTime), CEILING(MONTH(CreatedTime) / 3)), "
                    + "Import AS ( "
                    + "SELECT YEAR(Created_Time) AS Year_nh, "
                    + "CEILING(MONTH(Created_Time) / 3) AS Quarter_nh, "
                    + "SUM(Total) as Total_nh "
                    + "FROM import "
                    + "GROUP BY YEAR(Created_Time), CEILING(MONTH(Created_Time) / 3))"
                    + "SELECT r.Year_hd, r.Quarter_hd, r.Total_hd, i.Year_nh, i.Quarter_nh, i.Total_nh "
                    + "FROM Receipt as r "
                    + "JOIN Import as i "
                    + "ON r.Year_hd = i.Year_nh AND r.Quarter_hd = i.Quarter_nh "
                    + "ORDER BY r.Year_hd, r.Quarter_hd ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int year = rs.getInt("Year_hd");
                int quarter = rs.getInt("Quarter_hd");
                double tienvon = rs.getDouble("Total_nh");
                double tienban = rs.getDouble("Total_hd");
                double loinhuan = tienban - tienvon;
                doanhthuDTO doanhthuDTO = new doanhthuDTO(tienvon, loinhuan, tienban, year, quarter);
                doanhthu.add(doanhthuDTO);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return doanhthu;
    }
    
}