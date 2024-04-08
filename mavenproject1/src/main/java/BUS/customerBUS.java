/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.customerDAO;
import DTO.customerDTO;
import java.util.ArrayList;
/**
 *
 * @author ThinkBook
 */
public class customerBUS {
    private ArrayList <customerDTO> dsCus ;
    public customerBUS(){
        list();
    }
    public void list()
    {
        customerDAO dao = new customerDAO();
        dsCus = new ArrayList<>();
        dsCus = dao.list();
    }
    public ArrayList<customerDTO> getList(){
        return dsCus;
    }
    public customerDTO get(String cusid){
        
        for (customerDTO i:dsCus){
            if (i.getCusID().equals(cusid)){
                return i;
            }
            
        }
        return null;
    }
    
    
}
