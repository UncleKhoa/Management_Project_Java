/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.staffDAO;
import DTO.staffDTO;
import DTO.userDTO;
import java.util.ArrayList;

/**
 *
 * @author khoan
 */
public class staffBUS {
    private ArrayList<staffDTO> dsStaff;
    
    public staffBUS(){
        list();
    }
    
    public void list() {
        staffDAO staffDAO = new staffDAO();
        dsStaff = new ArrayList<>();
        dsStaff = staffDAO.list();
        System.out.println(dsStaff.size());
    }
    
    public ArrayList<staffDTO> getList() {
        return dsStaff;
    }
    
    public staffDTO Get(String staffID){
        for(staffDTO st:dsStaff){
            if(st.getStaffID().equals(staffID)){
                return st;
            }
        }
        return null;
    }
    
}
