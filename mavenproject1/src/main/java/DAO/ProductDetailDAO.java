/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.productDetailDTO;
import static DAO.DBConnect.getConnect;
import DTO.productDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author ADMIN
 */
public class ProductDetailDAO {
    Connection conn = getConnect();
    
    public ArrayList<productDetailDTO> list(){
        ArrayList<productDetailDTO> productlist = new ArrayList<>();
        try{
            String sql = "select * from productdetail";
            PreparedStatement stmt_getlist = conn.prepareStatement(sql);
            ResultSet rs = stmt_getlist.executeQuery();
            
            while(rs.next()){
                String ProductID = rs.getString("ProductID");
                String cpu = rs.getString("CPU");
                String ram = rs.getString("RAM");
                String hardDisk = rs.getString("HaskDisk");
                String screen = rs.getString("Screen");
                String webCam = rs.getString("Webcam");
                String pin = rs.getString("Pin");
                String operatingSys = rs.getString("OperatingSys");
                String weight = rs.getString("Weight");
                String color = rs.getString("Color");
                String size = rs.getString("Size");
              
              productDetailDTO detail = new productDetailDTO( ProductID ,  cpu,  ram, hardDisk,  screen,  webCam,  pin,  operatingSys,  weight,  color, size);
                productlist.add(detail); 
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return productlist;
    }
    public void add(productDetailDTO sp) throws SQLException {
              Connection connection = DBConnect.getConnect();
              String sql = "INSERT INTO productdetail (ProductID ,  CPU,  RAM, HasKDisk,  Screen,  Webcam,  Pin,  OperatingSys,  Weight,  Color, Size) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
              PreparedStatement pst = connection.prepareStatement(sql);

              pst.setString(1, sp.getProductID());
              pst.setString(2, sp.getCpu());
              pst.setString(3, sp.getRam());
              pst.setString(4, sp.getHardDisk());
              pst.setString(5, sp.getScreen());
              pst.setString(6, sp.getWebCam());
              pst.setString(7, sp.getPin());
              pst.setString(8, sp.getOperatingSys());
              pst.setString(9, sp.getWeight());
              pst.setString(10, sp.getColor());
              pst.setString(11, sp.getSize());
              

              pst.executeUpdate();

              pst.close();
          }
    
    public static void main(String[] args) {
    ProductDetailDAO productDetailDAO = new ProductDetailDAO();
    ArrayList<productDetailDTO> productlist = productDetailDAO.list();
    
    if (productlist != null && !productlist.isEmpty()) {
        System.out.println("Dữ liệu trong productlist:");
        for (productDetailDTO product : productlist) {
            System.out.println("ProductID: " + product.getProductID());
            System.out.println("CPU: " + product.getCpu());
            System.out.println("RAM: " + product.getRam());
            // In các thuộc tính khác tương tự
            System.out.println("--------------------------");
        }
    } else {
        System.out.println("Không có dữ liệu trong productlist.");
    }
}

    
    
}
