/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author khoan
 */
public class userDTO {
    private String staffID, username, password, gmail, enable;

    public void userDTO(){
        
    }

    public userDTO(String staffID, String username, String password, String gmail, String enable) {
        this.staffID = staffID;
        this.username = username;
        this.password = password;
        this.gmail = gmail;
        this.enable = enable;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGmail() {
        return gmail;
    }

    public String getEnable() {
        return enable;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }
    
    
    
}
