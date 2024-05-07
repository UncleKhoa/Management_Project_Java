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
import java.util.logging.Level;
import java.util.logging.Logger;

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
                + "'" + promo.getDescription() +"', "
                + "'" + promo.getPromotionPercent()+ "', "
                + "'"+ promo.getStatus()+"' "
                + ")";
        PreparedStatement stmt_add = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt_add.executeUpdate();
        conn.close();
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
        conn.close();
    }
    
    public void Activation(String id, String a){
        try {
            String sql = "update promotion set status = '"+ a +"' where PromotionID = '"+ id +"'";
            PreparedStatement stmt_act = conn.prepareStatement(sql);
            stmt_act.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(promotionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<promotionDTO> Search(String a){
        ArrayList<promotionDTO> promotionlist = new ArrayList<>();
        try{            
            String sql = "SELECT * FROM promotion WHERE PromotionID LIKE '%" + a + "%'";
            PreparedStatement stmt_search = conn.prepareStatement(sql);
            ResultSet rs = stmt_search.executeQuery();
            
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
            System.out.print(ex);
        }
        
        return promotionlist;
    }
    
}
