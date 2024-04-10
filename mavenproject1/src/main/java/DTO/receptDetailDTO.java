/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MY PC
 */
public class receptDetailDTO {
    String receptID,promotionID,productID,quantity;
    double unitPrice,originalTotal,promotionTotal;

    public receptDetailDTO() {
    }

    public receptDetailDTO(String receptID, String promotionID, String productID, String quantity, double unitPrice, double originalTotal, double promotionTotal) {
        this.receptID = receptID;
        this.promotionID = promotionID;
        this.productID = productID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.originalTotal = originalTotal;
        this.promotionTotal = promotionTotal;
    }

    public String getReceptID() {
        return receptID;
    }

    public void setReceptID(String receptID) {
        this.receptID = receptID;
    }

    public String getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getOriginalTotal() {
        return originalTotal;
    }

    public void setOriginalTotal(double originalTotal) {
        this.originalTotal = originalTotal;
    }

    public double getPromotionTotal() {
        return promotionTotal;
    }

    public void setPromotionTotal(double promotionTotal) {
        this.promotionTotal = promotionTotal;
    }
    
    
}
