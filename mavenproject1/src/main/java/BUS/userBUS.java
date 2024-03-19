/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.userDAO;
import DTO.userDTO;
import java.util.ArrayList;

/**
 *
 * @author khoan
 */
public class userBUS {
    
    private ArrayList<userDTO> dsUS;
    
    public userBUS(){
       list();
    }
    
    
    public void list() {
        userDAO usDAO = new userDAO();
        dsUS = new ArrayList<>();
        dsUS = usDAO.list();
    }
    
    public void add(){
        userDAO usDao = new userDAO();
        
    }
    
    public userDTO Check(String username, String password){
        for(userDTO us:dsUS){
            if(us.getUsername().equals(username) && us.getPassword().equals(password)){
                return us;
            }
        }
        return null;
    }
    
    public ArrayList<userDTO> getList() {
        return dsUS;
    }
    
    
    
}
