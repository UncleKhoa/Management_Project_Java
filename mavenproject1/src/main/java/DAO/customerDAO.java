/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import static DAO.DBConnect.getConnect;
import DTO.customerDTO;
import DTO.staffDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author ThinkBook
 */
public class customerDAO {
    Connection conn = getConnect(); 
      
    public customerDAO(){
        
    }
    public ArrayList<customerDTO> list() {
        ArrayList<customerDTO> customerList = new ArrayList<>();
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
                String gmail = rs.getString("Gmail");
                String address = rs.getString("Address");

                customerDTO cus = new customerDTO(cusid, firstname, lastname, gender, phonenumber,gmail, address);
                customerList.add(cus);
            }
        } 
        catch(SQLException ex){
           System.out.println(ex.getMessage()); 
        }
        return customerList;    
    }
    
    public void add(customerDTO cus) throws SQLException {
        String sql = "INSERT INTO customer VALUES('" + cus.getCusID()+ "', "
                + "'" + cus.getFirstName()+ "', "
                + "'" + cus.getLastName()+ "', "
                + "'" + cus.getGender()+ "', "
                + "'" + cus.getPhoneNumber()+ "', "
                + "'" + cus.getGmail()+ "', "
                + "'" + cus.getAddress()+ "')";
        PreparedStatement stmt_add = conn.prepareStatement(sql);
        stmt_add.executeUpdate();
    }
    
    public void update(customerDTO cus) throws SQLException {
        String sql = "UPDATE customer SET firstname = '" + cus.getFirstName()+ "', "
                + " lastname = '" + cus.getLastName()+ "', "
                + " gender = '" + cus.getGender()+ "', "
                + " phonenumber = '" + cus.getPhoneNumber()+ "', "
                + "gmail = '"+ cus.getGmail()+ "', "
                + " address = '" + cus.getAddress()+ "' WHERE cusID = '" + cus.getCusID()+"'";
        PreparedStatement stmt_add = conn.prepareStatement(sql);
        stmt_add.executeUpdate();
    }
    
    public void delete(String cusID) throws SQLException {
        String sql = "delete from customer where cusID = '"+ cusID +"'";
        PreparedStatement stmt_add = conn.prepareStatement(sql);
        stmt_add.executeUpdate();
    }

    public customerDTO searchsdt(String sdt)throws SQLException {
        customerDTO cus = new customerDTO();
        String sql = "SELECT* FROM customer WHERE PhoneNumber LIKE ?";
         PreparedStatement  pstmt= conn.prepareStatement(sql);
         pstmt.setString(1, "%" + sdt + "%");
         ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            // Create a new customerDTO object and set its attributes
            cus.setCusID(rs.getString("CusID"));
            cus.setFirstName(rs.getString("FirstName"));
            cus.setLastName(rs.getString("LastName"));
            // Set other attributes similarly
        }
        return cus;
    }
    
    public int SL_KH(){
        int s = 0;
        try{
            String sql = "SELECT COUNT(*) AS total_customers from customer";
            PreparedStatement stmt_sl = conn.prepareCall(sql);
            ResultSet rs = stmt_sl.executeQuery();
            
            if(rs.next()){
                s = rs.getInt("total_customers");
            }
            
        }
        catch(SQLException ex){
            System.out.print(ex);
        }
        return s;
    }
   
}
