/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ProductDetailDAO;
import DTO.productDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ProductDetailBUS {

    private ArrayList<productDetailDTO> dsdetail;
    private ProductDetailDAO productdetail;
    ProductDetailDAO dtDAO = new ProductDetailDAO();

    public ProductDetailBUS() {
        list();
    }

    public void list() {
        ProductDetailDAO productdetail = new ProductDetailDAO();
        dsdetail = new ArrayList<>();
        dsdetail = productdetail.list();
    }

    public ArrayList<productDetailDTO> getList() {
        return dsdetail;
    }

    public void add(productDetailDTO SP) throws SQLException {
        dtDAO.add(SP);
    }

    public void update(productDetailDTO SP) throws SQLException {
        dtDAO.update(SP);
    }

}
