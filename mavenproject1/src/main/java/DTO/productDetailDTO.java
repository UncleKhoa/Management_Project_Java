/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MY PC
 */
public class productDetailDTO {
    String productID,cpu,ram, hardDisk,screen,webCam,pin,operatingSys,weight,color,size;

    public productDetailDTO() {
    }

    public productDetailDTO(String productID, String cpu, String ram, String hardDisk, String screen, String webCam, String pin, String operatingSys, String weight, String color, String size) {
        this.productID = productID;
        this.cpu = cpu;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.screen = screen;
        this.webCam = webCam;
        this.pin = pin;
        this.operatingSys = operatingSys;
        this.weight = weight;
        this.color = color;
        this.size = size;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getWebCam() {
        return webCam;
    }

    public void setWebCam(String webCam) {
        this.webCam = webCam;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getOperatingSys() {
        return operatingSys;
    }

    public void setOperatingSys(String operatingSys) {
        this.operatingSys = operatingSys;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
}
