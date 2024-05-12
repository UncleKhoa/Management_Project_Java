/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import static DAO.DBConnect.*;
import DTO.importDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Bon Nguyen
 */
public class importDAO {
    
    Connection conn = getConnect();
    
    public ArrayList<importDTO> list(){
        ArrayList<importDTO> importlist = new ArrayList<>();
        try{
            String sql = "select * from import";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String importid = rs.getString("importID");
                String supplierid = rs.getString("SupplierID");
                String staffid = rs.getString("StaffID");
                double total = rs.getDouble("Total");
                Date createdtime = rs.getDate("Created_Time");
                importDTO importDTO = new importDTO(importid, supplierid, staffid, createdtime, total);
                importlist.add(importDTO);
            }
            
        }
        catch(SQLException ex){
            System.out.print(ex);
        }
        finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(importDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return importlist;
    }
    
    public ArrayList<importDTO> list_name(){
        ArrayList<importDTO> list = new ArrayList<>();
        try{
            String sql = "select nh.ImportID, nv.LastName "
                    + "from import nh, staff nv "
                    + "where nh.StaffID = nv.StaffID";
            PreparedStatement stmt_get = conn.prepareStatement(sql);
            ResultSet rs = stmt_get.executeQuery();
            
            while(rs.next()){
                String importid = rs.getString("ImportID");
                String stfname = rs.getString("LastName");
                importDTO importDTO = new importDTO(importid, stfname);
                list.add(importDTO);
            }
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return list;
    }       
    
}
