/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author MY PC
 */
public class receptDTO {

    private Date CreatedTime;
    private String ReceptID, CusID, StaffID, CusName, StaffName;
    double Total;

    public receptDTO(String ReceptID, String CusID, String StaffID, Date CreatedTime, double Total) {
        this.CreatedTime = CreatedTime;
        this.ReceptID = ReceptID;
        this.CusID = CusID;
        this.StaffID = StaffID;
        this.Total = Total;
    }
    
    public receptDTO(String RecceptID, String CusID, String StaffID, String CusName, String StaffName){
        this.ReceptID = RecceptID;
        this.CusID = CusID;
        this.StaffID = StaffID;
        this.CusName = CusName;
        this.StaffName = StaffName;
    }

    public receptDTO() {
    }

    public String getCusName() {
        return CusName;
    }

    public String getStaffName() {
        return StaffName;
    }

    public void setCusName(String CusName) {
        this.CusName = CusName;
    }

    public void setStaffName(String StaffName) {
        this.StaffName = StaffName;
    }

    
    
    public void setCreatedTime(Date CreatedTime) {
        this.CreatedTime = CreatedTime;
    }

    public String getReceptID() {
        return ReceptID;
    }

    public String getCusID() {
        return CusID;
    }

    public String getStaffID() {
        return StaffID;
    }

    public double getTotal() {
        return Total;
    }

    public void setReceptID(String ReceptID) {
        this.ReceptID = ReceptID;
    }

    public void setCusID(String CusID) {
        this.CusID = CusID;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public Date getCreatedTime() {
        return CreatedTime;
    }

}
