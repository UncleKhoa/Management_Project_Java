/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.productDAO;
import DTO.productDTO;
import java.util.ArrayList;

/**
 *
 * @author Bon Nguyen
 */
public class productBUS {
    private ArrayList<productDTO> dsProduct;
    private productDAO productDAO;
    
    public productBUS(){
        list();
    }
    
    public void list(){
        productDAO productDAO = new productDAO();
        dsProduct = new ArrayList<>();
        dsProduct = productDAO.list();
    }
    
    public ArrayList<productDTO> getList(){
        return dsProduct;
    }
    
    public int ConvertDoubleToInt(double price){
        return (int) price;
    }
    
    public int TotalProduct() {
        int totalProducts = 0;
        try {
            productDAO productDAO = new productDAO();
            totalProducts = productDAO.SL_Sanpham();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return totalProducts;
    }
    
}
