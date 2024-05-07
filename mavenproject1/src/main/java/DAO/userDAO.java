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
    
    public void add(userDTO user){
        try {
            String sql = "INSERT INTO acount VALUES('" + user.getStaffID() + "', "
                    + "'" + user.getUsername() + "', "
                    + "('" + user.getPassword() + "'), "
                    + "'" + user.getGmail() + "', "
                    + "'" + user.getEnable() + "')";
            PreparedStatement stmt_add = conn.prepareStatement(sql);
            stmt_add.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(userDTO user) {
        try {
            // Câu truy vấn SQL để cập nhật thông tin người dùng
            String sql = "UPDATE account SET Username = ?, Password = ?, Gmail = ?, Enable = ? WHERE AccountID = ?";

            // Tạo một đối tượng PreparedStatement với câu truy vấn SQL
            PreparedStatement stmt_update = conn.prepareStatement(sql);

            // Thiết lập các tham số cho câu truy vấn SQL
            stmt_update.setString(1, user.getUsername());
            stmt_update.setString(2, user.getPassword());
            stmt_update.setString(3, user.getGmail());
            stmt_update.setString(4, user.getEnable());
            stmt_update.setString(5, user.getStaffID());

            // Thực thi truy vấn SQL
            stmt_update.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update_email(String mail, String staffID) throws SQLException{
        String sql = "update account set Gmail= ? where StaffID = ?";
        PreparedStatement stmt_update = conn.prepareStatement(sql);
        stmt_update.setString(1, mail);
        stmt_update.setString(2, staffID);
        
        stmt_update.executeUpdate();
    }
    
    public void delete(String staffID){
        try {
            String sql = "DELETE FROM USER WHERE StaffID = '" + staffID + "'";
            PreparedStatement stmt_add = conn.prepareStatement(sql);
            stmt_add.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UpdatePassword(String password, String gmail){
        try(Connection conn = DBConnect.getConnect()) {
            // Câu truy vấn SQL để cập nhật mật khẩu
            String sql = "UPDATE account SET Password = '"+password+"' "
                    + "WHERE Gmail = '"+gmail+"'";
            
            PreparedStatement stmt_up_pass = conn.prepareStatement(sql);
            stmt_up_pass.executeUpdate();
            
            // Thực thi truy vấn SQL
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
