/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khoan
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Connection conn = getConnect();

            // Truy vấn cơ sở dữ liệu để lấy ra mã nhân viên cao nhất
            String query = "SELECT MAX(AccountID) FROM account";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Lấy ra mã nhân viên cao nhất
            int maxId = 0;
            if (resultSet.next()) {
                String maxIdStr = resultSet.getString(1);
                maxId = Integer.parseInt(maxIdStr);
            }

            // Tạo mã mới
            String newId = String.format("staff%03d", maxId + 1);

            // In ra mã nhân viên mới
            System.out.println("New employee ID: " + newId);

            // Đóng kết nối và các tài nguyên
            resultSet.close();
            statement.close();
            conn.close();


        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
