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
            String sql = "select hd.CreatedTime, count(hd.ReceiptID) as SLdon, sum(cthd.Quantity) as SLSP, sum(hd.Total) as Tongtien "
            + "from receiptdetail cthd, receipt hd "
            + "where hd.ReceiptID = cthd.ReceiptID "
            + "group by (hd.CreatedTime)";
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
    
    public ArrayList<doanhthuDTO> getDT_TheoNgay_Chart(){
        ArrayList<doanhthuDTO> ds_dttn = new ArrayList<>();
        try{
            String sql = "select hd.CreatedTime, count(hd.ReceiptID) as SLdon, sum(cthd.Quantity) as SLSP, sum(hd.Total) as Tongtien "
            + "from receiptdetail cthd, receipt hd "
            + "where hd.ReceiptID = cthd.ReceiptID "
            + "group by (hd.CreatedTime) "
            + "ORDER BY hd.CreatedTime ASC, Tongtien DESC "
            + "LIMIT 5";
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
    
}