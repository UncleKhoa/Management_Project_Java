/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.ProductDetailDAO;
import DTO.productDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author ADMIN
 */
public class ProductDetailBUS {
       private ArrayList<productDetailDTO> dsdetail;
    private ProductDetailDAO productdetail;
    ProductDetailDAO dtDAO=new ProductDetailDAO(); 

    public ProductDetailBUS() {
        list();
    }
    
    
    
    public void list(){
        ProductDetailDAO productdetail = new ProductDetailDAO();
        dsdetail = new ArrayList<>();
        dsdetail = productdetail.list();
    }
    
    public ArrayList<productDetailDTO> getList(){
        return dsdetail;
    }
    
     public void add(productDetailDTO SP) throws SQLException {
      dtDAO.add(SP);
      }
    
    
    public static void main(String[] args) {
    ProductDetailBUS productDetailBUS = new ProductDetailBUS();
    ArrayList<productDetailDTO> dsdetail = productDetailBUS.getList();
    
    if (dsdetail != null && !dsdetail.isEmpty()) {
        System.out.println("Dữ liệu trong dsdetail:");
        for (productDetailDTO product : dsdetail) {
            System.out.println("ProductID: " + product.getProductID());
            System.out.println("CPU: " + product.getCpu());
            System.out.println("RAM: " + product.getRam());
            // In các thuộc tính khác tương tự
            System.out.println("--------------------------");
        }
    } else {
        System.out.println("Không có dữ liệu trong dsdetail.");
    }
}
}
