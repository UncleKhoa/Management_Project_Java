package DAO;

import static DAO.DBConnect.getConnect;
import DTO.productDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bon Nguyen
 */
public class productDAO {

    Connection conn = getConnect();

    public ArrayList<productDTO> list() {
        ArrayList<productDTO> productlist = new ArrayList<>();
        try {
            String sql = "select * from product";
            PreparedStatement stmt_getlist = conn.prepareStatement(sql);
            ResultSet rs = stmt_getlist.executeQuery();

            while (rs.next()) {
                String ProductID = rs.getString("ProductID");
                String BrandID = rs.getString("BrandID");
                String ProductName = rs.getString("ProductName");
                double UnitPrice = rs.getDouble("UnitPrice");
                int Quantity = rs.getInt("Quantity");
                String IMG = rs.getString("IMG");

                productDTO product = new productDTO(ProductID, BrandID, ProductName, IMG, UnitPrice, Quantity);
                productlist.add(product);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return productlist;
    }

    public int getQuantity(String productID) throws SQLException {
        int quantity = 0;
        String sql = "SELECT quantity FROM product WHERE productID = '" + productID + "'";
        PreparedStatement stmt_find = conn.prepareStatement(sql);
        ResultSet rs = stmt_find.executeQuery(sql);
        if (rs.next()) {
            quantity = rs.getInt("Quantity");
        }
        return quantity;
    }

    public int compareQuantity(String productID, int sl) throws SQLException {
        int quantity = getQuantity(productID);
        if (quantity < sl) {
            return 0;
        }
        return 1;

    }

    public void update_quantity(String productID, int sl) throws SQLException {
        productDTO product = new productDTO();
        int quantity = getQuantity(productID);
        int updateQuantity = quantity - sl;
        String sql = "UPDATE product SET Quantity = ? WHERE productID = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, updateQuantity);
        pstmt.setString(2, productID);
        pstmt.executeUpdate();
    }
     public void sub_quantity(String productID, int sl) throws SQLException {
        productDTO product = new productDTO();
        int quantity = getQuantity(productID);
        int updateQuantity = quantity + sl;
        String sql = "UPDATE product SET Quantity = ? WHERE productID = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, updateQuantity);
        pstmt.setString(2, productID);
        pstmt.executeUpdate();
    }

}
