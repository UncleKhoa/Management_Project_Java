/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnect;
import DTO.staffDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author khoan
 */
public class staffDAO {
    
    Connection conn = getConnect();
    
    public staffDAO(){
        
    }
    
    public ArrayList<staffDTO> list() {
        ArrayList<staffDTO> stafflist = new ArrayList<>();
        try {
            String sql = "SELECT * FROM staff";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String staffid = rs.getString("StaffID");
                String firstname = rs.getString("FirstName");
                String lastname = rs.getString("LastName");
                String gender = rs.getString("Gender");
                String phonenumber = rs.getString("PhoneNumber");
                String address = rs.getString("Address");
                double salary = Double.parseDouble(rs.getString("Salary"));
                String role = rs.getString("Role");
                int yearofbirth = Integer.parseInt(rs.getString("YearOfBirth"));
                String img = rs.getString("IMG");

                staffDTO stflist = new staffDTO(staffid, firstname, lastname, gender, phonenumber, address, salary, role, yearofbirth, img);
                stafflist.add(stflist);
            }
        } 
        catch(SQLException ex){
           System.out.println(ex.getMessage()); 
        }
        return stafflist;    
    }
    
        public void add(staffDTO staff) throws SQLException {
        String sql = "INSERT INTO STAFF VALUES('" + staff.getStaffID() + "', "
                + "'" + staff.getFirstname()+ "', "
                + "'" + staff.getLastname()+ "', "
                + "'" + staff.getYearofbirth()+ "', "
                + "'" + staff.getGender()+ "', "
                + "'" + staff.getPhonenumber()+ "', "
                + "'" + staff.getAddress()+ "', "
                + "'" + staff.getSalary()+ "', "
                + "'" + staff.getRole()+ "', "
                + "'" + staff.getImg()+ "')";
        PreparedStatement stmt_add = conn.prepareStatement(sql);
        stmt_add.executeUpdate();
    }
        
    public void update(staffDTO staff) throws SQLException {
        String sql = "UPDATE STAFF SET firstname = '" + staff.getFirstname()+ "', "
                + " lastname = '" + staff.getLastname()+ "', "
                + " yearofbirth = '" + staff.getYearofbirth()+ "', "
                + " gender = '" + staff.getGender()+ "', "
                + " phonenumber = '" + staff.getPhonenumber()+ "', "
                + " address = '" + staff.getAddress()+ "', "
                + " salary = '" + staff.getSalary()+ "', "
                + " role = '" + staff.getRole()+ "', "
                + " img = '" + staff.getImg()+ "' WHERE staffID = '" + staff.getStaffID()+ "'";
        PreparedStatement stmt_add = conn.prepareStatement(sql);
        stmt_add.executeUpdate();
    }
        
    public void delete(String staffID) throws SQLException {
        String sql = "delete from staff where staffid = '"+ staffID +"'";
        PreparedStatement stmt_add = conn.prepareStatement(sql);
        stmt_add.executeUpdate();
    }
    
}
