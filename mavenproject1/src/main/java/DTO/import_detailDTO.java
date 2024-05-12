/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Bon Nguyen
 */
public class import_detailDTO {
    String importDTID, importID, productID, productName;
    int quantity;
    double unitPrice, subTotal;

    public import_detailDTO(String importDTID, String importID, String productName, int quantity, double unitPrice, double subTotal) {
        this.importDTID = importDTID;
        this.importID = importID;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subTotal = subTotal;
    }
    
    public import_detailDTO(){
        
    }

    public void setImportDTID(String importDTID) {
        this.importDTID = importDTID;
    }

    public void setImportID(String importID) {
        this.importID = importID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    
    
    public String getImportDTID() {
        return importDTID;
    }

    public String getImportID() {
        return importID;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
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
    
    
    
}
