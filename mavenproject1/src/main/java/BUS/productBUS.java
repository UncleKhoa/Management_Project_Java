package BUS;

import DAO.productDAO;
import DTO.productDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bon Nguyen
 */
public class productBUS {
    private ArrayList<productDTO> dsProduct;
    private productDAO productDAO;
    
    public productBUS(){
        list();
    }
    
    public void list(){
        productDAO productDAO = new productDAO();
        dsProduct = new ArrayList<>();
        dsProduct = productDAO.list();
    }
    
    public ArrayList<productDTO> getList(){
        return dsProduct;
    }
    
    public int ConvertDoubleToInt(double price){
        return (int) price;
    }
     public int getQuantity(String productID) throws SQLException
     {
           productDAO dao = new productDAO();
           return dao.getQuantity(productID);
     }
     public int compareQuantity(String productID,int sl) throws SQLException
     {
         productDAO dao = new productDAO();
         return dao.compareQuantity(productID, sl);
     }
       public void update_quantity(String productID,int sl) throws SQLException
       {
             productDAO dao = new productDAO();
             dao.update_quantity(productID, sl);
       }
    
    
}
