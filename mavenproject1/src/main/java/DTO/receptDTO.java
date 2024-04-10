/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MY PC
 */
public class receptDTO {

    public receptDTO() {
    }

    public receptDTO(String receptID, String cusID, String staffID, double Total) {
        this.receptID = receptID;
        this.cusID = cusID;
        this.staffID = staffID;
        this.Total = Total;
    }

    public String getReceptID() {
        return receptID;
    }

    public void setReceptID(String receptID) {
        this.receptID = receptID;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    String receptID,cusID,staffID;
    double Total;
}
