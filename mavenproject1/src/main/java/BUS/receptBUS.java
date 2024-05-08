/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.receptDAO;
import DTO.receptDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MY PC
 */
public class receptBUS {
    private ArrayList <receptDTO> dshd ;
    public receptBUS(){
        list();
    }
      public void list()
    {
        receptDAO dao = new receptDAO();
        dshd = new ArrayList<>();
        dshd = dao.list();
    }

    public void add(receptDTO recept) throws SQLException{
        receptDAO dao = new receptDAO();
        dao.add(recept);
    }
    public String createId()
    {
        receptDAO dao = new  receptDAO();
        String maHh;
        dshd = new ArrayList<>();
        dshd = dao.list();
        int l = dshd.size();
        l=l+1;
        if(l<10){ maHh = "HD0" + String.valueOf(l);}
        else{
            maHh = "HD" + String.valueOf(l);
        }
        
        return maHh;
        
        
    }       
   
}
