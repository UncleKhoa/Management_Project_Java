/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Bon Nguyen
 */
public class promotion_detailDTO {
    String PromotionDetailID, PromotionID, ProductID;
    float PromotionPercent;
    
    public promotion_detailDTO(){
        
    }

    public promotion_detailDTO(String PromotionDetailID, String PromotionID, String ProductID, float PromotionPercent) {
        this.PromotionDetailID = PromotionDetailID;
        this.PromotionID = PromotionID;
        this.ProductID = ProductID;
        this.PromotionPercent = PromotionPercent;
    }

    public String getPromotionDetailID() {
        return PromotionDetailID;
    }

    public String getPromotionID() {
        return PromotionID;
    }

    public String getProductID() {
        return ProductID;
    }

    public float getPromotionPercent() {
        return PromotionPercent;
    }

    public void setPromotionDetailID(String PromotionDetailID) {
        this.PromotionDetailID = PromotionDetailID;
    }

    public void setPromotionID(String PromotionID) {
        this.PromotionID = PromotionID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public void setPromotionPercent(float PromotionPercent) {
        this.PromotionPercent = PromotionPercent;
    }
    
    @Override
    public String toString() {
        return "promotion_detailDTO{" +
                "id='" + PromotionDetailID + '\'' +
                ", promotionID='" + PromotionID + '\'' +
                ", productID='" + ProductID + '\'' +
                ", promotionPercent=" + PromotionPercent +
                '}';
    }
    
}
