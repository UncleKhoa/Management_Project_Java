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
    private String ReceptID, CusID, StaffID;
    double Total;

    public receptDTO(String ReceptID, String CusID, String StaffID,Date CreatedTime, double Total) {
        this.CreatedTime = CreatedTime;
        this.ReceptID = ReceptID;
        this.CusID = CusID;
        this.StaffID = StaffID;
        this.Total = Total;
    }

    
      public receptDTO() {
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
