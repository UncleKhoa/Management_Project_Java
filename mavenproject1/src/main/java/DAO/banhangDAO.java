/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import static DAO.DBConnect.getConnect;
import DTO.customerDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bon Nguyen
 */
public class banhangDAO {
    
    Connection conn = getConnect();    
    
    public ArrayList<customerDTO> list(){
        ArrayList<customerDTO> customerlist = new ArrayList<>();
        try{
            String sql = "select kh.CusID, kh.LastName, count(hd.ReceiptID) as sldon, sum(hd.total) as tongtien "
                    + "from receipt hd, customer kh "
                    + "where hd.CusID = kh.CusID "
                    + "group by (hd.CusID)";
            PreparedStatement stmt_bhkh = conn.prepareStatement(sql);
            ResultSet rs = stmt_bhkh.executeQuery();
            
            while(rs.next()){
                String cusid = rs.getString("CusID");
                String cusname = rs.getString("LastName");
                int sldon = rs.getInt("sldon");
                double tongtien = rs.getDouble("tongtien");
                customerDTO customerDTO = new customerDTO(cusid, cusname, sldon, tongtien);
                customerlist.add(customerDTO);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return customerlist;
    }
    
    public ArrayList<customerDTO> list_Chart(){
        ArrayList<customerDTO> customerlist = new ArrayList<>();
        try{
            String sql = "select kh.CusID, kh.LastName, count(hd.ReceiptID) as sldon, sum(hd.total) as tongtien "
                    + "from receipt hd, customer kh "
                    + "where hd.CusID = kh.CusID "
                    + "group by (hd.CusID) "
                    + "ORDER BY tongtien DESC "
                    + "LIMIT 5";
            PreparedStatement stmt_bhkh = conn.prepareStatement(sql);
            ResultSet rs = stmt_bhkh.executeQuery();
            
            while(rs.next()){
                String cusid = rs.getString("CusID");
                String cusname = rs.getString("LastName");
                int sldon = rs.getInt("sldon");
                double tongtien = rs.getDouble("tongtien");
                customerDTO customerDTO = new customerDTO(cusid, cusname, sldon, tongtien);
                customerlist.add(customerDTO);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return customerlist;
    }
    
}
