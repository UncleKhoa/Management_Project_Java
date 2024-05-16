/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.supplierDAO;
import DTO.supplierDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MY PC
 */
public class supplierBUS {
    supplierDAO dao;
    private ArrayList <supplierDTO>list;
     public supplierBUS() {
        list();
    }

    public ArrayList<supplierDTO> list() 
    {
        supplierDAO dao = new supplierDAO();
        return dao.list();
    }
    public void add(supplierDTO supplier) throws SQLException
    {
        supplierDAO dao = new supplierDAO();
        dao.add(supplier);
    }
    public void update(supplierDTO supplier) throws SQLException
    {
        supplierDAO dao = new supplierDAO();
        dao.update(supplier);
    }     
    public void delete(supplierDTO supplier) throws SQLException
    {
        supplierDAO dao = new supplierDAO();
        dao.delete(supplier);
    }
     public String createId()
    {
        supplierDAO dao = new supplierDAO();
        String maNcc;
        list = new ArrayList<>();
        list = dao.list();
        int l = list.size();
        l = l + 1;
        if (l < 10) {
            maNcc = "SUP0" + String.valueOf(l);
        } else {
            maNcc = "SUP" + String.valueOf(l);
        }

        return maNcc;

    }
     public ArrayList<supplierDTO> SeardByIdAndName(String s, ArrayList<supplierDTO> list) {
        ArrayList<supplierDTO > ketQua = new ArrayList<>();
        for (supplierDTO supplier : list) {
            if (supplier.getSupplierID().toLowerCase().contains(s.toLowerCase())||supplier.getSupplierName().toLowerCase().contains(s.toLowerCase())) {
                ketQua.add(supplier);
            }
        }
        return ketQua;
    }
}
