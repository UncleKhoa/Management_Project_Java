/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.receipt_DetailDAO;
import DTO.receptDetailDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MY PC
 */
public class receipt_DetailBUS {
     private ArrayList <receptDetailDTO> cthd ;
    public receipt_DetailBUS(){
        list();
    }
      public void list()
    {
        receipt_DetailDAO dao = new  receipt_DetailDAO ();
        cthd = new ArrayList<>();
        cthd = dao.list();
    }
    public void add(receptDetailDTO receipt) throws SQLException{
        receipt_DetailDAO dao = new receipt_DetailDAO();
                    dao.add(receipt);
    }
     public int list_size()
     {
        receipt_DetailDAO dao = new  receipt_DetailDAO();
        cthd = new ArrayList<>();
        cthd = dao.list();
        int l = cthd.size();
        return l;
     }
    
        public String createId(int l,int row)
    {
        //row = row+1;
        l=l+row;
        String machd;
        if(l<10){ machd = "CHD0" + String.valueOf(l);}
        else{
           machd = "CHD" + String.valueOf(l);
        }
        
        return machd;   
    }  
    
}
