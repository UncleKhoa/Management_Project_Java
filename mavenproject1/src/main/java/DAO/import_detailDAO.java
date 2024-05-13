/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import DTO.import_detailDTO;
import static DAO.DBConnect.getConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Bon Nguyen
 */
public class import_detailDAO {
    
    Connection conn = getConnect();
    
    public ArrayList<import_detailDTO> list(){
        ArrayList<import_detailDTO> list = new ArrayList<>();
        try{
            String sql = "select ctpn.ImportDTID, ctpn.ImportID, sp.ProductName, ctpn.Quantity, ctpn.UnitPrice, ctpn.Subtotal "
                    + "from importdetail ctpn, product sp "
                    + "where ctpn.ProductID = sp.ProductID";
            PreparedStatement stmt_get = conn.prepareStatement(sql);
            ResultSet rs = stmt_get.executeQuery();
            
            while(rs.next()){
                String importDTID = rs.getString("ImportDTID");
                String importID = rs.getString("ImportID");
                String productname = rs.getString("ProductName");
                int quantity = rs.getInt("Quantity");
                double unitprice = rs.getDouble("UnitPrice");
                double subtotal = rs.getDouble("SubTotal");
                import_detailDTO imDTO = new import_detailDTO(importDTID, importID, productname, quantity, unitprice, subtotal);
                list.add(imDTO);
            }
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return list;
    }
    
}
