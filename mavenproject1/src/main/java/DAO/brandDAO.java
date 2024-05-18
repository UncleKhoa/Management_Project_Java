/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnect;
import DTO.brandDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MY PC
 */
public class brandDAO {
    Connection conn = getConnect();
    
    
    public ArrayList<brandDTO> list() 
    {
        ArrayList<brandDTO> list = new ArrayList<>();
         try { 
        String sql = "SELECT *FROM brand ";
        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs;
      
            rs = st.executeQuery();
            while(rs.next())
            {
                String brandID = rs.getString("BrandID");
                String brandName = rs.getString("BrandName");
                brandDTO brand = new brandDTO(brandID,brandName);
                list.add(brand);
            }
        } catch (SQLException ex) {
            Logger.getLogger(brandDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return list;
    }
    public void add(brandDTO brand) throws SQLException
    {
        String sql = "INSERT INTO brand VALUES ('" +brand.getBrandId()+"',"
              + "'"+ brand.getBrandName()+"'" 
               + ")";
        PreparedStatement p = conn.prepareStatement(sql);
        p.executeUpdate();
    }
    public void delete(brandDTO brand) throws SQLException{
        String sql = "DELETE FROM brand WHERE BrandID = '"+brand.getBrandId()+"'";
        PreparedStatement p = conn.prepareStatement(sql);
        p.executeUpdate();
    }
    
    public void update(brandDTO brand) throws SQLException
    {
        String sql= "UPDATE brand SET brandName = '" +brand.getBrandName()+"' "
                +"WHERE BrandID = '"+brand.getBrandId()+"'";
        PreparedStatement p = conn.prepareStatement(sql);
        p.executeUpdate();
        
    }
}
