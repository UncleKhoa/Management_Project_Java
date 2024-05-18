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
    private ArrayList<supplierDTO> list;

    public supplierBUS() {
        list();
    }

    public ArrayList<supplierDTO> list() {
        supplierDAO dao = new supplierDAO();
        return dao.list();
    }

    public void add(supplierDTO supplier) throws SQLException {
        supplierDAO dao = new supplierDAO();
        dao.add(supplier);
    }

    public void update(supplierDTO supplier) throws SQLException {
        supplierDAO dao = new supplierDAO();
        dao.update(supplier);
    }

    public void delete(supplierDTO supplier) throws SQLException {
        supplierDAO dao = new supplierDAO();
        dao.delete(supplier);
    }

    public String createId() {
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
        ArrayList<supplierDTO> ketQua = new ArrayList<>();
        for (supplierDTO supplier : list) {
            if (supplier.getSupplierID().toLowerCase().contains(s.toLowerCase()) || supplier.getSupplierName().toLowerCase().contains(s.toLowerCase())) {
                ketQua.add(supplier);
            }
        }
        return ketQua;
    }

    public ArrayList<supplierDTO> SearchByName(String a1, String a2, ArrayList<supplierDTO> list) {
        ArrayList<supplierDTO> result = new ArrayList<>();
        char kitu1 = 0, kitu2 = 0;
        boolean empty1 = false, empty2 = false;
        if (a1.trim().isEmpty()) {
            empty1 = true;
            kitu2 = a2.charAt(0);
            kitu2 = Character.toLowerCase(kitu2);

        }
        if (a2.trim().isEmpty()) {
            empty2 = true;
            kitu1 = a1.charAt(0);
            kitu1 = Character.toLowerCase(kitu1);

        }
        if (!a1.trim().isEmpty() && !a2.trim().isEmpty()) {
            kitu1 = Character.toLowerCase(a1.charAt(0));
            kitu2 = Character.toLowerCase(a2.charAt(0));
        }
        for (supplierDTO supplier : list) {
            char firstChar = supplier.getSupplierName().charAt(0);
            char firstCharLower = Character.toLowerCase(firstChar);

            if (empty1 && firstCharLower == kitu2) {
                result.add(supplier);
            } else if (empty2 && firstCharLower == kitu1) {
                result.add(supplier);
            } else if (!empty1 && !empty2 && (firstCharLower == kitu1 || firstCharLower == kitu2)) {
                result.add(supplier);
            }
        }
         return result;
     }
     public boolean checkId(String id,ArrayList<supplierDTO> list)
     {
         String haiKyTuDau = id.substring(0, 3);
         if(!haiKyTuDau.equals("SUP"))
         {
             return true;
         }
         for (supplierDTO supplier : list) {
              if(supplier.getSupplierID().equals(id))
                  return true;
          }
          return false;
     }
     
}
