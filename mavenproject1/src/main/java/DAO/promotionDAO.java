/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnect;
import DTO.promotionDTO;
import DTO.promotion_detailDTO;
import DTO.userDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Bon Nguyen
 */
public class promotionDAO {
    Connection conn = getConnect(); 
    
    public ArrayList<promotionDTO> list() {
        ArrayList<promotionDTO> promotionlist = new ArrayList<>();
        try{
            String sql = "select * from promotion";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String promotionid = rs.getString("PromotionID");
                Date fromsql = rs.getDate("From");
                Date tosql = rs.getDate("To");
                java.util.Date from = new java.util.Date(fromsql.getTime());
                java.util.Date to = new java.util.Date(tosql.getTime());
                String describe = rs.getString("Description");
                float promotionpercent = rs.getFloat("PromotionPercent");
                String status = rs.getString("Status");
                
                promotionDTO promotion = new promotionDTO(promotionid, from, to, describe, promotionpercent, status);
                promotionlist.add(promotion);                
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return promotionlist;
    }
    
    public void add(promotionDTO promo) throws SQLException{
        String sql = "INSERT INTO promotion VALUES('" + promo.getPromotionID() + "', "
                + "'" + promo.getFrom() + "', "
                + "'" + promo.getTo() + "', "
                + "'" +promo.getDescription() +"', "
                + "'" + promo.getStatus() + "'"
                + ")";
        PreparedStatement stmt_add = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt_add.executeUpdate();
    }
    
    public void update(promotionDTO promo) throws SQLException{
        String sql = "update promotion set values ("
                + "From = '"+promo.getFrom()+"' "
                + "To = '"+promo.getTo()+"' "
                + "Status = '"+promo.getStatus()+"'";
        PreparedStatement stmt_up = conn.prepareStatement(sql);
        stmt_up.executeUpdate();
    }
    
    public void Delete(String id) throws SQLException{
        String sql = "delete from promotion where PomotionID = '"+id+"'";
        PreparedStatement stmt_del = conn.prepareCall(sql);
        stmt_del.executeUpdate();
    }
    
//    public ArrayList<promotion_detailDTO> list_detail(String id) throws SQLException{
//        promotion_detailDTO promotion_detailDTO = new promotion_detailDTO();
//        // Lấy dữ liệu từ promotion detail
//        String sql = "Select pdt.Decription from promotiondetail pdt, product p where ";
//        PreparedStatement stmt_detail = conn.prepareStatement(sql);
//        ResultSet result = stmt_detail.executeQuery();
//        
//        while(result.next()){
//            String ProductID = result.getString("ProductID");
//            String Description = result.getString("Description");
//            String Promotion
//        }
//        
//    }
//    
}