/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import static DAO.DBConnect.getConnect;
import DTO.customerDTOs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author MY PC
 */
public class customerDAOs {
      Connection conn = getConnect();
    
    public customerDAOs(){
        
    }
    public ArrayList<customerDTOs>cuslist = new ArrayList<>();
    public ArrayList<customerDTOs> list() {
    try {
            String sql = "SELECT * FROM customer";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String cusid = rs.getString("CusID");
                String firstname = rs.getString("FirstName");
                String lastname = rs.getString("LastName");
                String gender = rs.getString("Gender");
                String phonenumber = rs.getString("PhoneNumber");
                String gmail= rs.getString("Gmail");
                String address = rs.getString("Address");
               

                customerDTOs list = new customerDTOs(cusid, firstname, lastname, gender, phonenumber, address, gmail);
                cuslist.add(list);
            }
        } 
        catch(SQLException ex){
           System.out.println(ex.getMessage()); 
        }
        return cuslist;   
    }
  
  public ArrayList<customerDTOs> list(customerDTOs customer, String phone) throws SQLException {
    ArrayList<customerDTOs> custlist = new ArrayList<>();
    String sql = "SELECT * FROM customer WHERE phone = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, phone);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
        customerDTOs customerDTO = new customerDTOs();
        customerDTO.setCusID(rs.getString("CusID"));
        customerDTO.setFirstName(rs.getString("FirstName"));
        customerDTO.setGender(rs.getString("Gender"));
        customerDTO.setPhoneNumber(rs.getString("PhoneNumber"));
        customerDTO.setGmail(rs.getString("Gmail"));
        customerDTO.setAddress (rs.getString("Address"));
        custlist.add(customerDTO);
    }
    rs.close();
    stmt.close();
    return custlist;
}
    public void add(customerDTOs customer) throws SQLException {
        String sql = "INSERT INTO USER VALUES('" + customer.getCusID() + "', "
                + "'" + customer.getFirstName()+ "', "
                + "'" + customer.getLastName()+ "', "
                + "'" + customer.getGender()+ "', "
                + "'" + customer.getGmail()+ "', "
                + "'" + customer.getPhoneNumber()+ "', "
                + "'" + customer.getAddress()+ "', ";
             
        PreparedStatement stmt_add = conn.prepareStatement(sql);
        stmt_add.executeUpdate();
    }
    }
   
    
 
    
    

