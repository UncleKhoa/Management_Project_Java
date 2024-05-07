/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnect;
import DTO.receptDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MY PC
 */
public class receptDAO {

    Connection conn = getConnect();

    public ArrayList<receptDTO> list() {
        ArrayList<receptDTO> receptlist = new ArrayList<>();
        try {
            String sql = "select * from recept";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String receptid = rs.getString("ReceptID");
                String cusid = rs.getString("CusID");
                String staffid = rs.getString("StaffID");
                Date createtimesql = rs.getDate("CreatedTime");
                java.util.Date createtime = new java.util.Date(createtimesql.getTime());
                double total = rs.getDouble("Total");
                receptDTO recept = new receptDTO(receptid, cusid, staffid, createtime, total);
                receptlist.add(recept);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return receptlist;
    }

    public void add(receptDTO recept) throws SQLException {
        String sql = "INSERT INTO recept VALUE (" + recept.getReceptID() + "',"
                + "'" + recept.getCusID() + "' ,"
                + "'" + recept.getStaffID() + "' ,"
                + "'" + recept.getCreatedTime() + "' ,"
                + "'" + recept.getTotal() + "' ,"
                + ")";
        PreparedStatement stmt_add = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt_add.executeUpdate();

    }
    
    public void getSP_DT(){
        try{
            String sql = "";
            PreparedStatement stmt_get = conn.prepareCall(sql);
        }
        catch(SQLException ex){
            System.out.print(ex);
        }
    }

}
