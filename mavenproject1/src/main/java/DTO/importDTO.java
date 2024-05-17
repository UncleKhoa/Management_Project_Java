/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Bon Nguyen
 */
public class importDTO {
    String imporID, SupplierID, StaffID, staffName;
    Date CreatedDate;
    double Total;   

    public importDTO(){
        
    }
    
    public importDTO(String imporID, String SupplierID, String StaffID, Date CreatedDate, double Total) {
        this.imporID = imporID;
        this.SupplierID = SupplierID;
        this.StaffID = StaffID;
        this.CreatedDate = CreatedDate;
        this.Total = Total;
    }
    
    public importDTO(String importID, String staffName){
        this.imporID = importID;
        this.staffName = staffName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    
    public String getImporID() {
        return imporID;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public String getStaffID() {
        return StaffID;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public double getTotal() {
        return Total;
    }

    public void setImporID(String imporID) {
        this.imporID = imporID;
    }

    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public void setCreatedDate(Date CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    
}
