/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author Bon Nguyen
 */
public class promotionDTO {
    String PromotionID, PromotionName, From, To, Description, Status;

    public promotionDTO(){
        
    }
    
    public promotionDTO(String PromotionID, String PromotionName, String From, String To, String Description, String Status) {
        this.PromotionID = PromotionID;
        this.PromotionName = PromotionName;
        this.From = From;
        this.To = To;
        this.Description = Description;
        this.Status = Status;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDescription() {
        return Description;
    }

    public String getPromotionID() {
        return PromotionID;
    }

    public String getPromotionName() {
        return PromotionName;
    }

    public void setPromotionID(String PromotionID) {
        this.PromotionID = PromotionID;
    }

    public void setPromotionName(String PromotionName) {
        this.PromotionName = PromotionName;
    }

    public void setFrom(String From) {
        this.From = From;
    }

    public void setTo(String To) {
        this.To = To;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getFrom() {
        return From;
    }

    public String getTo() {
        return To;
    }

    public String getStatus() {
        return Status;
    }
    
    
    
}
