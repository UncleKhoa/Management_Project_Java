/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnect;
import DTO.supplierDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MY PC
 */
public class supplierDAO {

    Connection conn = getConnect();

    public ArrayList<supplierDTO> list() {
        ArrayList<supplierDTO> list = new ArrayList<>();
        try {
            String sql = "SELECT* FROM supplier ";
            PreparedStatement s = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                String supplierID = rs.getString("SupplierID");
                String supname = rs.getString("SupplierName");
                String phone = rs.getString("PhoneNumber");
                String address = rs.getString("Address");
                supplierDTO supplier = new supplierDTO(supplierID, supname, phone, address);
                list.add(supplier);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public void add(supplierDTO supplier) throws SQLException {
        String sql = "INSERT INTO supplier VALUES ('" + supplier.getSupplierID() + "',"
                + "'" + supplier.getSupplierName() + "',"
                + "'" + supplier.getPhoneNumber() + "',"
                + "'" + supplier.getAddress() + "'"
                + ")";
        PreparedStatement p = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        p.executeUpdate();
        
//        String sqlq = "INSERT INTO supplier VALUES ('"+supplier.getSupplierID()+"',"
//                + "'"+supplier.getSupplierName()+"'"
//                + ",'"+supplier.getPhoneNumber()+"'"
//                + ",'"+supplier.getAddress()+"')";
//        PreparedStatement p = conn.prepareStatement(sqlq);
//        p.executeUpdate();
    }

    public void update(supplierDTO supplier) throws SQLException {
        String sql = "UPDATE supplier SET "
                + "SupplierName = '"+supplier.getSupplierName()+"', "
                + "PhoneNumber = '"+supplier.getPhoneNumber()+"', "
                + "Address = '"+supplier.getAddress()+"' "
                + "WHERE SupplierID = '"+supplier.getSupplierID()+"'";
        
        PreparedStatement stmt_up = conn.prepareStatement(sql);
        stmt_up.executeUpdate();

//String sql="UPDATE supplier SET SupplierName = '"+supplier.getSupplierName()+"'"
//+ ",PhoneNumber = '"+supplier.getPhoneNumber()+"',"
//        + "Address = '"+supplier.getAddress()+"' Where SupplierID = '"+supplier.getSupplierID()+"'";
//PreparedStatement p = conn.prepareStatement(sql);
//p.executeUpdate();
    }

    public void delete(supplierDTO supplier) throws SQLException {
        String sql = "DELETE FROM supplier WHERE SupplierID = '" + supplier.getSupplierID() + "'";
        PreparedStatement p = conn.prepareStatement(sql);
        p.executeUpdate();
        conn.close();
    }
}
