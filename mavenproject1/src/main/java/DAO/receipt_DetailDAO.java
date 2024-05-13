/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.getConnect;
import DTO.receptDetailDTO;
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
public class receipt_DetailDAO {

    Connection conn = getConnect();

    public ArrayList<receptDetailDTO> list() {
        ArrayList<receptDetailDTO> receiptlist = new ArrayList<>();
        try {
            String sql = "select * from receiptdetail";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String detailReceiptID = rs.getString("DetailReceiptID");
                String receiptID = rs.getString("ReceiptID");
                String promotionID = rs.getString("PromotionID");
                String productID = rs.getString("ProductID");
                int quantity = rs.getInt("Quantity");
                double unitPrice = rs.getDouble("UnitPrice");
                double subTotal = rs.getDouble("SubTotal");
                receptDetailDTO receipt = new receptDetailDTO(detailReceiptID, receiptID, promotionID, productID, quantity, unitPrice, subTotal);
                receiptlist.add(receipt);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return receiptlist;
    }

    public void add(receptDetailDTO receipt) throws SQLException {
        String sql = "INSERT INTO receiptdetail VALUES ('" + receipt.getDetailReceiptID() + "',"
                + "'" + receipt.getReceptID() + "',"
                + "'" + receipt.getPromotionID() + "',"
                + "'" + receipt.getProductID() + "',"
                + "'" + receipt.getQuantity() + "',"
                + "'" + receipt.getUnitPrice() + "',"
                + "'" + receipt.getSubTotal() + "'"
                + ")";
        PreparedStatement stmt_add = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt_add.executeUpdate();
    }

    public ArrayList<receptDetailDTO> list_Info() {
        ArrayList<receptDetailDTO> receiptInfolist = new ArrayList<>();
        try {
            String sql = "select cthd.DetailReceiptID, cthd.ReceiptID, cthd.PromotionID, sp.ProductName, cthd.Quantity, cthd.UnitPrice, cthd.SubTotal "
                    + "from receiptdetail cthd, product sp "
                    + "where cthd.ProductID = sp.ProductID "
                    + "ORDER BY cthd.DetailReceiptID ASC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String detailReceiptID = rs.getString("DetailReceiptID");
                String receiptID = rs.getString("ReceiptID");
                String promotionID = rs.getString("PromotionID");
                String productname = rs.getString("ProductName");                
                int quantity = rs.getInt("Quantity");
                double unitPrice = rs.getDouble("UnitPrice");
                double subTotal = rs.getDouble("SubTotal");
                receptDetailDTO receptDetailDTO = new receptDetailDTO(detailReceiptID, receiptID, promotionID, productname, quantity, unitPrice, subTotal);
                receiptInfolist.add(receptDetailDTO);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return receiptInfolist;
    }
    
}
