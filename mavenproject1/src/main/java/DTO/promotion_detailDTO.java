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
    String PromotionID, ProductID, Description;
    int PromotionPercent;
    
    public promotion_detailDTO(){
        
    }

    public promotion_detailDTO(String PromotionID, String ProductID, String Description, int PromotionPercent) {
        this.PromotionID = PromotionID;
        this.ProductID = ProductID;
        this.Description = Description;
        this.PromotionPercent = PromotionPercent;
    }

    public String getPromotionID() {
        return PromotionID;
    }

    public String getProductID() {
        return ProductID;
    }

    public String getDescription() {
        return Description;
    }

    public int getPromotionPercent() {
        return PromotionPercent;
    }

    public void setPromotionID(String PromotionID) {
        this.PromotionID = PromotionID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPromotionPercent(int PromotionPercent) {
        this.PromotionPercent = PromotionPercent;
    }
    
    
    
}
