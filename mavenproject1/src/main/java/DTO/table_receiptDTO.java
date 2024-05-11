/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MY PC
 */
public class table_receiptDTO {

   public  String MaSp,sl,giagoc,giaban,tong;
    public String getMaSp() {
        return MaSp;
    }

    public String getSl() {
        return sl;
    }

    public String getGiagoc() {
        return giagoc;
    }

    public String getGiaban() {
        return giaban;
    }

    public String getTong() {
        return tong;
    }
  
     
    public table_receiptDTO() {
    }

    public table_receiptDTO(String MaSp, String sl, String giagoc, String giaban, String tong) {
        this.MaSp = MaSp;
        this.sl = sl;
        this.giagoc = giagoc;
        this.giaban = giaban;
        this.tong = tong;
    }

    public void setMaSp(String MaSp) {
        this.MaSp = MaSp;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public void setGiagoc(String giagoc) {
        this.giagoc = giagoc;
    }

    public void setGiaban(String giaban) {
        this.giaban = giaban;
    }

    public void setTong(String tong) {
        this.tong = tong;
    }
    
  
    
    
    
}
