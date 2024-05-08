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

    public staffDTO search(int i){
        return dsStaff.get(i);
    }
    
    public void add(staffDTO staff){
        dsStaff.add(staff);
    }
    
    public ArrayList<staffDTO> sortByBirth() {
        ArrayList <staffDTO> list = dsStaff;
        int n = list.size();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                staffDTO staff1 = list.get(j);
                staffDTO staff2 = list.get(j + 1);

                if ((staff1.getYearofbirth())>staff2.getYearofbirth()) {
                    list.set(j, staff2);
                    list.set(j + 1, staff1);
                }
            }
        }
        return list;
    }
    
    public ArrayList<staffDTO> sortByName() {   
        int n = dsStaff.size();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                staffDTO staff1 = dsStaff.get(j);
                staffDTO staff2 = dsStaff.get(j + 1);

                if (staff1.getFirstname().charAt(0) > staff2.getFirstname().charAt(0)) {
                    dsStaff.set(j, staff2);
                    dsStaff.set(j + 1, staff1);
                }
            }
        }
        return dsStaff;
    }
        
    public ArrayList<staffDTO> search(String id) {
        ArrayList<staffDTO> list2 = new ArrayList<>();
        for (staffDTO i : dsStaff) {
            if ((i.getStaffID().equals(id)) || (i.getFirstname().equals(id))) {
                list2.add(i);
            }
        }
        return list2;
    }
    
    public int Get_SLNV(){
        staffDAO staffDAO = new staffDAO();
        int s = staffDAO.SL_NV();
        return s;
    }
    
}
    
