/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author MY PC
 */


import static DAO.DBConnect.getConnect;
import DTO.productDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 
  
public class productDAO {
   Connection conn = getConnect();
    
  
    public ArrayList<productDTO>productlist = new ArrayList<>();
    public ArrayList<productDTO> list() {
    try {
            String sql = "SELECT * FROM product";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String productId = rs.getString("ProductID");
                String brandId= rs.getString("BrandID");
                String productName = rs.getString("ProductName");
                String unitPrice = rs.getString("UnitPrice");
                String quantity = rs.getString("Quantity");
                String img= rs.getString("IMG");
                productDTO list = new productDTO(productId,brandId, productName,unitPrice, quantity,img);
                 productlist.add(list);
            }
        } 
        catch(SQLException ex){
           System.out.println(ex.getMessage()); 
        }
        return productlist;   
    }
}
