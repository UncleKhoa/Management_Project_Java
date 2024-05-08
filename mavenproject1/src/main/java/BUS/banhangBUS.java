/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.customerDTO;
import java.util.ArrayList;
import DAO.banhangDAO;

/**
 *
 * @author Bon Nguyen
 */
public class banhangBUS {
    
    private ArrayList<customerDTO> ds_bhkh;
    private ArrayList<customerDTO> ds_bhkh_chart;
    
    //bán hàng khách hàng table
    public banhangBUS(){
        list_bhkh();
        list_bhkh_Chart();
    }
    
    public ArrayList<customerDTO> Get_ListBHKH(){
        return ds_bhkh;
    }
    
    public void list_bhkh(){
        banhangDAO banhangDAO = new banhangDAO();
        ds_bhkh = new ArrayList<>();
        ds_bhkh = banhangDAO.list();
    }
    
    //bán hàng khách hàng chart
    public ArrayList<customerDTO> Get_ListBHKH_Chart(){
        return ds_bhkh_chart;
    }
    
    public void list_bhkh_Chart(){
        banhangDAO banhangDAO = new banhangDAO();
        ds_bhkh_chart = new ArrayList<>();
        ds_bhkh_chart = banhangDAO.list_Chart();
    }
    
}
