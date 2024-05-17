/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import static DAO.DBConnect.getConnect;
import DTO.SupplierDTO;
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
public class SupplierDAO {
    
    
     Connection conn = getConnect();
    
    public ArrayList <SupplierDTO> list(){
        ArrayList< SupplierDTO> supplierlist = new ArrayList<>();
        try{
            String sql = "select * from supplier";
            PreparedStatement stmt_getlist = conn.prepareStatement(sql);
            ResultSet rs = stmt_getlist.executeQuery();
            
            while(rs.next()){
                String supplierid = rs.getString("SupplierID");
                String suppliername = rs.getString("SupplierName");
                int phonenumber = rs.getInt("PhoneNumber");
                String address = rs.getString("Address");
                
                
                SupplierDTO supplier = new SupplierDTO(supplierid, suppliername,  phonenumber,address);
                supplierlist.add(supplier); 
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return supplierlist;
    }
     public void add(SupplierDTO nc) throws SQLException {
              Connection connection = DBConnect.getConnect();
              String sql = "INSERT INTO supplier (SupplierID, SupplierName, ProductName, PhoneNumber, Address) VALUES (?, ?, ?, ?)";
              PreparedStatement pst = connection.prepareStatement(sql);

              pst.setString(1, nc.getId());
              pst.setString(2, nc.getName());
              pst.setInt(3, nc.getPhonenumber());
              pst.setString(4, nc.getAddress());
            
              pst.executeUpdate();

              pst.close();
          }
            public void update(SupplierDTO nc) {
		try {
			    Connection connection = DBConnect.getConnect();
			
			PreparedStatement pst = connection.prepareStatement("UPDATE account SET SupplierID=?, SupplierName=?,  PhoneNumber=?, Address=?");
                            pst.setString(1, nc.getId());
                            pst.setString(2, nc.getName());
                            pst.setInt(3, nc.getPhonenumber());
                            pst.setString(4, nc.getAddress());
			 System.out.println("update thành công");
			pst.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
                public void delete(String sp) {
                        try {
                              Connection connection = DBConnect.getConnect();

                            PreparedStatement pst = connection.prepareStatement("DELETE FROM supplier WHERE SupplierID = ?");
                            pst.setString(1, sp);
                            pst.executeUpdate();

                            System.out.println("Xóa thành công");
                            pst.close();
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
    
    
    
    
}
