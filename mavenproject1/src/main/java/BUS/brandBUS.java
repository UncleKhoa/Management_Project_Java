/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.brandDAO;
import DTO.brandDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MY PC
 */
public class brandBUS {
    private ArrayList<brandDTO>listbrand;
    public ArrayList<brandDTO>list()
    {
        brandDAO dao = new brandDAO();
        return dao.list();
    }
    public void add(brandDTO brand) throws SQLException
    {
        brandDAO dao = new brandDAO();
        dao.add(brand);
    }
    public void update(brandDTO brand) throws SQLException
    {
        brandDAO dao = new brandDAO();
        dao.update(brand);
    }
    
   public void delete(brandDTO brand) throws SQLException
   {
       brandDAO dao = new brandDAO();
       dao.delete(brand);
   }
//   public String createId()
//   {
//       brandDAO dao = new brandDAO();
//       String id;
//       ArrayList<brandDTO> list = new ArrayList<>();
//       list = list();
//       int l = list.size();
//       System.out.println(l);
//       l = l+1;
//        if (l < 10) {
//           id= "NH0" + String.valueOf(l);
//        } else {
//           id = "NH" + String.valueOf(l);
//        }
//
//        return id;
//       
//       
//   }
   public boolean checkID(String id,ArrayList<brandDTO> list)
   {
      
       for(brandDTO brand : list)
       {  if(brand.getBrandId().equals(id))
            return true; 
       }
        return false;
   }
    public ArrayList<brandDTO> SeardByIdAndName(String s, ArrayList<brandDTO> list) {
        ArrayList<brandDTO > ketQua = new ArrayList<>();
        for (brandDTO brand : list) {
            if (brand.getBrandId().toLowerCase().contains(s.toLowerCase())||brand.getBrandName().toLowerCase().contains(s.toLowerCase())) {
                ketQua.add(brand);
            }
        }
        return ketQua;
    }
}
