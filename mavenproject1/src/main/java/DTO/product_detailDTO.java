/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Bon Nguyen
 */
public class product_detailDTO {
    String ProductID, CPU, RAM, HaskDisk, Screen, Webcam, Pin, OperatingSys, Color, Size;
    float Weight;
    
    public product_detailDTO(){
        
    }

    public product_detailDTO(String ProductID, String CPU, String RAM, String HaskDisk, String Screen, String Webcam, String Pin, String OperatingSys, String Color, String Size, float Weight) {
        this.ProductID = ProductID;
        this.CPU = CPU;
        this.RAM = RAM;
        this.HaskDisk = HaskDisk;
        this.Screen = Screen;
        this.Webcam = Webcam;
        this.Pin = Pin;
        this.OperatingSys = OperatingSys;
        this.Color = Color;
        this.Size = Size;
        this.Weight = Weight;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public void setHaskDisk(String HaskDisk) {
        this.HaskDisk = HaskDisk;
    }

    public void setScreen(String Screen) {
        this.Screen = Screen;
    }

    public void setWebcam(String Webcam) {
        this.Webcam = Webcam;
    }

    public void setPin(String Pin) {
        this.Pin = Pin;
    }

    public void setOperatingSys(String OperatingSys) {
        this.OperatingSys = OperatingSys;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public void setWeight(float Weight) {
        this.Weight = Weight;
    }

    public String getProductID() {
        return ProductID;
    }

    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getHaskDisk() {
        return HaskDisk;
    }

    public String getScreen() {
        return Screen;
    }

    public String getWebcam() {
        return Webcam;
    }

    public String getPin() {
        return Pin;
    }

    public String getOperatingSys() {
        return OperatingSys;
    }

    public String getColor() {
        return Color;
    }

    public String getSize() {
        return Size;
    }

    public float getWeight() {
        return Weight;
    }
    
    
    
}
