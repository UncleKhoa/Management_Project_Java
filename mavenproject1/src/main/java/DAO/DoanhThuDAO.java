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
            String sql = "select cthd.ProductID, sp.ProductName, sum(cthd.Quantity) as SL, sum(ctnh.Subtotal) as tienvon, sum(cthd.SubTotal) as tiensauKM, SUM(cthd.SubTotal) - SUM(ctnh.Subtotal)  as tienlai "
            + "from receiptdetail cthd, receipt hd, product sp, importdetail ctnh "
            + "where cthd.ProductID = sp.ProductID and hd.ReceiptID = cthd.ReceiptID and sp.ProductID = ctnh.ProductID "
            + "group by (ProductID)";
            PreparedStatement stmt_DTSP = conn.prepareStatement(sql);
            ResultSet rs = stmt_DTSP.executeQuery();
            
            while(rs.next()){
                String productid = rs.getString("ProductID");
                String productname = rs.getString("ProductName");
                int soluong = rs.getInt("SL");
                double tienvon = rs.getDouble("tienvon");
                double tiensauKM = rs.getDouble("tiensauKM");
                double tienlai = rs.getDouble("tienlai");
                doanhthuDTO doanhthuDTO = new doanhthuDTO(productid, productname, soluong, tienvon, tiensauKM, tienlai);
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
            String sql = "select cthd.ProductID, sp.ProductName, sum(cthd.Quantity) as SL, sum(ctnh.Subtotal) as tienvon, sum(cthd.SubTotal) as tiensauKM, SUM(cthd.SubTotal) - SUM(ctnh.Subtotal)  as tienlai "
            + "from receiptdetail cthd, receipt hd, product sp, importdetail ctnh "
            + "where cthd.ProductID = sp.ProductID and hd.ReceiptID = cthd.ReceiptID and sp.ProductID = ctnh.ProductID "
            + "group by (ProductID) desc limit 5";
            PreparedStatement stmt_DTSP = conn.prepareStatement(sql);
            ResultSet rs = stmt_DTSP.executeQuery();
            
            while(rs.next()){
                String productid = rs.getString("ProductID");
                String productname = rs.getString("ProductName");
                int soluong = rs.getInt("SL");
                double tienvon = rs.getDouble("tienvon");
                double tiensauKM = rs.getDouble("tiensauKM");
                double tienlai = rs.getDouble("tienlai");
                doanhthuDTO doanhthuDTO = new doanhthuDTO(productid, productname, soluong, tienvon, tiensauKM, tienlai);
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
            String sql = "select hd.CreatedTime, count(DISTINCT hd.ReceiptID) as SLdon, sum(cthd.Quantity) as SLSP, sum(hd.Total) as Tongtien "
            + "from receiptdetail cthd, receipt hd "
            + "where hd.ReceiptID = cthd.ReceiptID "
            + "group by (hd.CreatedTime) DESC";
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
            String sql = "SELECT CreatedTime, SLdon, SLSP, Tongtien "
                    + "FROM (SELECT hd.CreatedTime, COUNT(DISTINCT hd.ReceiptID) AS SLdon, SUM(cthd.Quantity) AS SLSP, SUM(hd.Total) AS Tongtien "
                    + "FROM receiptdetail cthd, receipt hd "
                    + "WHERE hd.ReceiptID = cthd.ReceiptID AND hd.CreatedTime BETWEEN '" + Start + "' AND '" + End + "' "
                    + "GROUP BY hd.CreatedTime "
                    + "ORDER BY Tongtien DESC, hd.CreatedTime ASC "
                    + "LIMIT 5) AS Top5Days "
                    + "ORDER BY Tongtien DESC";
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