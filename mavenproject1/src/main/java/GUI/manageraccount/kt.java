/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.manageraccount;

/**
 *
 * @author ADMIN
 */
public class kt {
    
  public boolean kiemtraten(String ten){     
        if (ten.matches(".*\\d.*")) {
            return true; 
        } else {
           return false; 
    }
  }
  public boolean kiemtragia(String ten) {
    if (ten.matches(".*[a-zA-Z].*")) {
        return true; // Chuỗi chứa chữ cái
    } else {
        return false; // Chuỗi không chứa chữ cái
    }
}
}

