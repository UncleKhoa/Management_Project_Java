/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import static DAO.DBConnect.getConnect;
import DTO.productDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Bon Nguyen
 */
public class productDAO {
    
    Connection conn = getConnect();
    
    public ArrayList<productDTO> list(){
        ArrayList<productDTO> productlist = new ArrayList<>();
        try{
            String sql = "select * from product";
            PreparedStatement stmt_getlist = conn.prepareStatement(sql);
            ResultSet rs = stmt_getlist.executeQuery();
            
            while(rs.next()){
                String ProductID = rs.getString("ProductID");
                String BrandID = rs.getString("BrandID");
                String ProductName = rs.getString("ProductName");
                double UnitPrice = rs.getDouble("UnitPrice");
                int Quantity = rs.getInt("Quantity");
                String IMG = rs.getString("IMG");
                
                productDTO product = new productDTO(ProductID, BrandID, ProductName, IMG, UnitPrice, Quantity);
                productlist.add(product); 
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return productlist;
    }
    
    public int SL_Sanpham(){
        int totalProducts = 0;
        try{
            String sql = "SELECT COUNT(*) AS total_products from product";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                totalProducts = rs.getInt("total_products");
            }
        }
        catch(SQLException ex){
            System.out.print(ex);
        }
        return totalProducts;
    }
    
}
