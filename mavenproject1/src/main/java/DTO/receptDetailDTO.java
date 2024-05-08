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
    String detailReceiptID,receptID,promotionID,productID;
    int quantity;
    double unitPrice,subTotal;

    public receptDetailDTO(String detailReceiptID,String receptID, String promotionID, String productID, int quantity, double unitPrice, double subTotal) {
        this.detailReceiptID = detailReceiptID;
        this.receptID = receptID;
        this.promotionID = promotionID;
        this.productID = productID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subTotal = subTotal;
    }

    public receptDetailDTO() {
    }

    public String getDetailReceiptID() {
        return detailReceiptID;
    }
    

    public String getReceptID() {
        return receptID;
    }

    public String getPromotionID() {
        return promotionID;
    }

    public String getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setDetailReceiptID(String detailReceiptID) {
        this.detailReceiptID = detailReceiptID;
    }
    

    public void setReceptID(String receptID) {
        this.receptID = receptID;
    }

    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

}
