/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.staffDAO;
import DAO.userDAO;
import DTO.staffDTO;
import DTO.userDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author khoan
 */
public class staffBUS {
    private ArrayList<staffDTO> dsStaff;
    private staffDAO staffDAO;
    
    public staffBUS(){
        list();
    }
    
    public void staffBUS(){
        this.staffDAO = new staffDAO();
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
    
    public staffDTO NewStaffDTO(String staffID, String firstName, String lastName, int yearOfBirth, String gender, String phoneNumber, String address, double salary, String role, String img) {
        staffDTO staff = new staffDTO();
        staff.setStaffID(staffID);
        staff.setFirstname(firstName);
        staff.setLastname(lastName);
        staff.setYearofbirth(yearOfBirth);
        staff.setGender(gender);
        staff.setPhonenumber(phoneNumber);
        staff.setAddress(address);
        staff.setSalary(salary);
        staff.setRole(role);
        staff.setImg(img);

        return staff;
    }
    
    public void Update(staffDTO stf) throws SQLException{
        staffDAO stfDAO = new staffDAO();
        stfDAO.update(stf);
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
