/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author MY PC
 */
import static DAO.DBConnect.getConnect;
import DTO.receptDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class receptDAO {
       Connection conn = getConnect();
       public receptDAO(){}
       //public ArrayList<receptDTO> list() {
       // ArrayList<receptDTO> listrecept = new ArrayList<>();
//       public void add(receptDTO recept) {
//        String CusID = recept.getCusID().equals("") ? null : "'" + recept.getCusID() + "'";
//        String sql = "INSERT INTO recept VALUES('" + recept.getReceptID() + "',"
//                + "" + CusID + ", "
//                + "'" + recept.getStaffID() + "', "
//              //  + "'" + recept.getNgayHD() + "', "
//                + "'" + recept.get() + "')";
//        conn.executeUpdate(sql);
//    }

}
