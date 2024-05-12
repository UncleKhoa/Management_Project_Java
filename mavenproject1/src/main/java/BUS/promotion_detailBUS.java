/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.promotion_detailDAO;
import java.sql.SQLException;

/**
 *
 * @author MY PC
 */
public class promotion_detailBUS {
    
    public float promotion_percent(String productID) throws SQLException
    {
            String id = "NORMAL";
            float percent=0;
            promotion_detailDAO promotion_detail = new promotion_detailDAO();
            String promotionID =  promotion_detail.getIDbyProductID(productID);
            if(promotionID!=null && !promotionID.equals(id))
                percent = promotion_detail.getPromotion_percent(promotionID);
             return percent;
    }
    
    public String getPromotionID(String productID) throws SQLException
            {
                 String id = "NORMAL";
                 promotion_detailDAO promotion_detail = new promotion_detailDAO();
                 String promotionID =  promotion_detail.getIDbyProductID(productID);
                  if(promotionID!=null && !promotionID.equals(id))
                      return promotionID;
//                  else {
//                      if(promotionID==null)
//                          System.out.println("null");
//                      if(promotionID.equals(id))
//                          System.out.println("ID");
//                  }
                  return id;
            }
}
