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
public class doanhthuDTO {
    private String ProductID, ProductName;
    private int SLBan, SLdon, SLSP;
    private double tienvon, tienlai, tiensauKM, tongtien;
    private Date ngayban;
    
    public doanhthuDTO(){
        
    }
    
    public doanhthuDTO(String ProductID, String ProductName, int SLBan, double tienvon, double tiensauKM, double tienlai){
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.SLBan = SLBan;
        this.tienvon = tienvon;
        this.tiensauKM = tiensauKM;
        this.tienlai = tienlai;
    }

    public doanhthuDTO(int SLdon, int SLSP, double tongtien, Date ngayban) {
        this.SLdon = SLdon;
        this.SLSP = SLSP;
        this.tienvon = tienvon;
        this.tongtien = tongtien;
        this.ngayban = ngayban;
    }

    public int getSLdon() {
        return SLdon;
    }

    public int getSLSP() {
        return SLSP;
    }

    public double getTongtien() {
        return tongtien;
    }

    public Date getNgayban() {
        return ngayban;
    }

    public void setSLdon(int SLdon) {
        this.SLdon = SLdon;
    }

    public void setSLSP(int SLSP) {
        this.SLSP = SLSP;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public void setNgayban(Date ngayban) {
        this.ngayban = ngayban;
    }
    
    

    public String getProductID() {
        return ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public int getSLBan() {
        return SLBan;
    }

    public double getTienvon() {
        return tienvon;
    }

    public double getTienlai() {
        return tienlai;
    }

    public double getTiensauKM() {
        return tiensauKM;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setSLBan(int SLBan) {
        this.SLBan = SLBan;
    }

    public void setTienvon(double tienvon) {
        this.tienvon = tienvon;
    }

    public void setTienlai(double tienlai) {
        this.tienlai = tienlai;
    }

    public void setTiensauKM(double tiensauKM) {
        this.tiensauKM = tiensauKM;
    }
    
}
