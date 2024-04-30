/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Bon Nguyen
 */
public class productDTO {
    String ProducctID, BrandID, ProductName, IMG;
    double UnitPrice;
    int Quantity;

    public productDTO(){
        
    }
    
    public productDTO(String ProducctID, String BrandID, String ProductName, String IMG, double UnitPrice, int Quantity) {
        this.ProducctID = ProducctID;
        this.BrandID = BrandID;
        this.ProductName = ProductName;
        this.IMG = IMG;
        this.UnitPrice = UnitPrice;
        this.Quantity = Quantity;
    }

    public String getProducctID() {
        return ProducctID;
    }

    public String getBrandID() {
        return BrandID;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getIMG() {
        return IMG;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setProducctID(String ProducctID) {
        this.ProducctID = ProducctID;
    }

    public void setBrandID(String BrandID) {
        this.BrandID = BrandID;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    
    
}
