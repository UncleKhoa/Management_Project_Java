/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Bon Nguyen
 */
public class promotionDTO {
    String PromotionID, Description, Status;
    Date From, To;
    float PromotionPercent;
    
    public promotionDTO(){
        
    }
    
    public promotionDTO(String PromotionID, Date From, Date To, String Description, float PromotionPercent, String Status) {
        this.PromotionID = PromotionID;
        this.From = From;
        this.To = To;
        this.Description = Description;
        this.PromotionPercent = PromotionPercent;
        this.Status = Status;
    }

    public float getPromotionPercent() {
        return PromotionPercent;
    }

    public void setPromotionPercent(float PromotionPercent) {
        this.PromotionPercent = PromotionPercent;
    }
    
    

    public String getPromotionID() {
        return PromotionID;
    }

    public String getDescription() {
        return Description;
    }

    public String getStatus() {
        return Status;
    }

    public Date getFrom() {
        return From;
    }

    public Date getTo() {
        return To;
    }

    public void setPromotionID(String PromotionID) {
        this.PromotionID = PromotionID;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setFrom(Date From) {
        this.From = From;
    }

    public void setTo(Date To) {
        this.To = To;
    }

    
    
}
