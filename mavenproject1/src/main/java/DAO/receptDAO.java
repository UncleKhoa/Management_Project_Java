/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnect;
import DTO.receptDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MY PC
 */
public class receptDAO {

    Connection conn = getConnect();

    public ArrayList<receptDTO> list() {

       ArrayList<receptDTO> receptlist = new ArrayList<>();
        try{
            String sql = "select * from receipt order by ReceiptID desc";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String receptid = rs.getString("ReceiptID");
                String cusid = rs.getString("CusID");
                String staffid = rs.getString("StaffID");
                Date createtimesql = rs.getDate("CreatedTime");
                java.util.Date createtime = new java.util.Date(createtimesql.getTime());
                double total = rs.getDouble("Total");
                receptDTO recept = new receptDTO( receptid, cusid,  staffid, createtime, total);
                receptlist.add(recept);                
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return receptlist;
    }
    
    public void add(receptDTO receipt) throws SQLException{
        String sql = "INSERT INTO receipt VALUES ('" + receipt.getReceptID() + "'," +
                 "'" + receipt.getCusID() + "'," +
                 "'" + receipt.getStaffID() + "'," +
                 "'" + receipt.getCreatedTime() + "'," +
                 "'" + receipt.getTotal() + "'" +
                 ")";
         PreparedStatement stmt_add = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt_add.executeUpdate(); 
        
    }

    public int TongDonHang(){
        int s = 0;
        try{
            String sql = "SELECT COUNT(*) AS total_receipts from receipt";
            PreparedStatement stmt_slhd = conn.prepareStatement(sql);
            ResultSet rs = stmt_slhd.executeQuery();
            
            if(rs.next()){
                s = rs.getInt("total_receipts");
            }
            
        }
        catch(SQLException ex){
            System.out.print(ex);
        }
        return s;
    }
    
    public double DoanhThu_BH(){
        double s = 0;
        try{
            String sql = "select sum(Total) as income from receipt";
            PreparedStatement stmt_income = conn.prepareStatement(sql);
            ResultSet rs = stmt_income.executeQuery();
            
            if(rs.next()){
                s = rs.getDouble("income");
            }
            
        }
        catch(SQLException ex){
            System.out.print(ex);
        }
        return s;
    }
    
    public ArrayList<receptDTO> list_Name(){
        ArrayList<receptDTO> receptlist_name = new ArrayList<>();
        try{
            String sql = "select distinct hd.ReceiptID, hd.CusID, hd.StaffID, kh.LastName, nv.LastName "
                    + "from receipt hd, customer kh, staff nv "
                    + "where hd.CusID = kh.CusID and hd.StaffID = nv.StaffID";
            PreparedStatement stmt_get = conn.prepareStatement(sql);
            ResultSet rs = stmt_get.executeQuery();
            
            while(rs.next()){
                String receiptID = rs.getString("ReceiptID");
                String cusID = rs.getString("CusID");
                String staffID = rs.getString("StaffID");
                String cus_LastName = rs.getString("kh.LastName");
                String stff_LastName = rs.getString("nv.LastName");
                receptDTO receptDTO = new receptDTO(receiptID, cusID, staffID, cus_LastName, stff_LastName);
                receptlist_name.add(receptDTO);
            }
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return receptlist_name;
    }

}

