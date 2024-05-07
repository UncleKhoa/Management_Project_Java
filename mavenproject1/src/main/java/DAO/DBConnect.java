/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author khoan
 */
public class DBConnect {
    
    public static Connection getConnect(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost/computer_management";
        String username = "root";
        String password = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return conn;
    }
    
    // Phương thức để làm mới lại Connection khi cơ sở dữ liệu thay đổi
    public static void refreshConnection() throws SQLException {
        Connection conn = getConnect();
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
