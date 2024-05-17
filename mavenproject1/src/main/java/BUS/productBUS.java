package BUS;

import DAO.customerDAO;
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

    productDAO spDAO=new productDAO(); 
    
    public productBUS(){

        list();
    }

    public void list() {
        productDAO productDAO = new productDAO();
        dsProduct = new ArrayList<>();
        dsProduct = productDAO.list();
    }

    public ArrayList<productDTO> getList() {
        return dsProduct;
    }

    
     public void add(productDTO SP) throws SQLException {
          spDAO.add(SP);
    
      }
    public void update(productDTO SP) throws SQLException {
              spDAO.update(SP);
              
          }
    public void delete(String sp) throws SQLException {
              spDAO.delete(sp);
              
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
      public String createId()
    {
        productDAO dao = new productDAO();
        String maSP;
        dsProduct = new ArrayList<>();
        dsProduct = dao.list();
        int l = dsProduct.size();
        l = l + 1;
        if (l < 10) {
            maSP = "SP0" + String.valueOf(l);
        } else {
            maSP = "SP" + String.valueOf(l);
        }

        return maSP;
    }
    




    public void sub_quantity(String productID, int sl) throws SQLException {
        productDAO dao = new productDAO();
        dao.sub_quantity(productID, sl);
    }

    public ArrayList<productDTO> searchByIđAnName(String s) {
        ArrayList<productDTO> list = new ArrayList<>();
        for (productDTO product : list) {
            if (product.getProducctID().toLowerCase().contains(s.toLowerCase())
                    && product.getProductName().toLowerCase().contains(s.toLowerCase())) {
                list.add(product);
            }
        }
        return list;
    }


}
