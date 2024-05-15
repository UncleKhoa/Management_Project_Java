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
import java.sql.Statement;
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
    public void add(importDTO s) throws SQLException
    {
        String sql = "INSERT INTO import VALUES ('"+ s.getImporID()+"',"+
        "'"+s.getSupplierID()+"',"+
        "'"+s.getStaffID()+"',"+
        "'"+s.getTotal()+"',"+
        "'"+s.getCreatedDate()+"'"
        +")";
        PreparedStatement p = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        p.executeUpdate();
    }
    
}
