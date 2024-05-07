/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DAO.DBConnect;
import static DAO.DBConnect.getConnect;
import java.sql.Connection;
import java.util.ArrayList;
import DTO.promotion_detailDTO;
import com.mysql.cj.xdevapi.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Bon Nguyen
 */
public class promotion_detailDAO {
    
    Connection conn = getConnect(); 
    
    public ArrayList<promotion_detailDTO> list(String promotionID){
        ArrayList<promotion_detailDTO> promotion_detail_list = new ArrayList<>();
        try {            
            
            String sql = "select * from promotiondetail where PromotionID = '"+promotionID+"'";
            PreparedStatement stmt_getlist = conn.prepareStatement(sql);
            ResultSet rs = stmt_getlist.executeQuery();
            
            while(rs.next()){
                String promotionDTID = rs.getString("PromotionDTID");
                String productid = rs.getString("ProductID");
                float promotionpercent = rs.getFloat("PromotionPercent");
                
                promotion_detailDTO promotionDT = new promotion_detailDTO(promotionDTID, promotionID, productid, promotionpercent);
                promotion_detail_list.add(promotionDT);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(promotion_detailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return promotion_detail_list;   
    }
    
    public int GET_promotiondetail_ID(){
        int t = 0;
        try {
            String sql = "select promotionDTID from promotiondetail order by promotionDTID desc limit 1";
            PreparedStatement stmt_getID = conn.prepareStatement(sql);
            ResultSet rs = stmt_getID.executeQuery();
            String s = null;

            while (rs.next()) {
                s = rs.getString("promotionDTID");
            }

            if (s != null) {
                // Nếu chuỗi không null, trích xuất số từ chuỗi
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(s);

                if (matcher.find()) {
                    String numberStr = matcher.group();
                    t = Integer.parseInt(numberStr);
                } else {
                    System.out.println("Không tìm thấy số trong chuỗi!");
                }
            } else {
                // Nếu chuỗi là null, gán giá trị mặc định là "Detail0"
                t = 0;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return t;
    }
    
    public void add(promotion_detailDTO promo_detail){
        try {
            int t = GET_promotiondetail_ID();
            int s_ = t+1;
            String s = "Detail"+s_;
            String sql = "insert into promotiondetail values ('"+s+"',"
                    + "'"+promo_detail.getPromotionID()+"',"
                    + "'"+promo_detail.getProductID()+"',"
                    + "'"+promo_detail.getPromotionPercent()+"'"
                    + ")";
            PreparedStatement stmt_add = conn.prepareStatement(sql);
            stmt_add.executeUpdate();
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        
    }
    
    public String Get_Name(String id){
        String name = null;
        try{
            String sql = "select ProductName from product where ProductID = '"+ id +"'";
            PreparedStatement stmt_name = conn.prepareStatement(sql);
            ResultSet rs= stmt_name.executeQuery();
            
            if(rs.next()){
                name = rs.getString("ProductName");
            }
            
        }
        catch(SQLException ex){
            System.out.print(ex);
        }
        
        return name;
    }
    
}
