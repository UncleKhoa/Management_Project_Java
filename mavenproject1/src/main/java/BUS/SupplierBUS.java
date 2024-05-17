/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SupplierDAO;
import DAO.productDAO;
import DTO.SupplierDTO;
import DTO.productDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class SupplierBUS {
    private ArrayList<SupplierDTO> dssupplier;
    private SupplierDAO supplierDAO;
    SupplierDAO ncDAO=new SupplierDAO();

    public SupplierBUS() {
        list();
    }
    public void list(){
        SupplierDTO supplier = new SupplierDTO();
        dssupplier = new ArrayList<>();
        dssupplier = supplierDAO.list();
    }
    
    public ArrayList<SupplierDTO> getList(){
        return dssupplier;
    }
    
     public void add(SupplierDTO nc) throws SQLException {
          ncDAO.add(nc);
      }
    public void update(SupplierDTO nc) throws SQLException {
              ncDAO.update(nc);
          }
    public void delete(String ncID) throws SQLException {
              ncDAO.delete(ncID);
          }
}
