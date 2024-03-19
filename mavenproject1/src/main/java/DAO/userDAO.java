/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnect;
import DTO.userDTO;
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
 * @author khoan
 */
public class userDAO {
    
    Connection conn = getConnect();
    
    public userDAO(){
        
    }
    
    public ArrayList<userDTO> list() {
        ArrayList<userDTO> userlist = new ArrayList<>();
        try {
            String sql = "SELECT * FROM account";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String staffid = rs.getString("StaffID");
                String username = rs.getString("username");
                String password = rs.getString("Password");
                String gmail = rs.getString("Gmail");
                String enable = rs.getString("Enable");

                userDTO uselist = new userDTO(staffid, username, password, gmail, enable);
                userlist.add(uselist);
            }
        } 
        catch(SQLException ex){
           System.out.println(ex.getMessage()); 
        }
        return userlist;    
    }
    
    public void add(userDTO user) throws SQLException {
        String sql = "INSERT INTO USER VALUES('" + user.getStaffID() + "', "
                + "'" + user.getUsername() + "', "
                + "('" + user.getPassword() + "'), "
                + "'" + user.getGmail() + "', "
                + "'" + user.getEnable() + "')";
        PreparedStatement stmt_add = conn.prepareStatement(sql);
        stmt_add.executeUpdate();
    }
    
    public void update(userDTO user) throws SQLException{
        String sql = "UPDATE USER SET Username = '" + user.getUsername() + "'"
                + "Password = '" + user.getPassword()+ "', "
                + " Gmail = '" + user.getGmail() + "', "
                + " Enable = '" + user.getEnable() + "' WHERE AccountID = '" + user.getStaffID()+ "'";
        PreparedStatement stmt_add = conn.prepareStatement(sql);
        stmt_add.executeUpdate();
    }
    
    public void delete(String staffID) throws SQLException{
        String sql = "DELETE FROM USER WHERE StaffID = '" + staffID + "'";
        PreparedStatement stmt_add = conn.prepareStatement(sql);
        stmt_add.executeUpdate();
    }
    
}
