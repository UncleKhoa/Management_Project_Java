/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author MY PC
 */
import DAO.productDAO;
import DTO.productDTO;
import java.util.ArrayList; 
public class productBUS {
    private ArrayList<productDTO>  productlist;

    public productBUS() {
        list();
    }

    public void list() {
        productDAO productDAO = new productDAO();
        productlist = new ArrayList<>();
        productlist  = productDAO.list();
    }

    public productDTO get(String id) {
        for (productDTO pd : productlist) {
            if (pd .getProductID().equals(id)) {
                return pd;
            }
        }
        return null;
    }
}
