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
        ArrayList <staffDTO> list = dsStaff;    
        int n = list.size();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                staffDTO staff1 = list.get(j);
                staffDTO staff2 = list.get(j + 1);

                if (staff1.getFirstname().charAt(0) > staff2.getFirstname().charAt(0)) {
                    list.set(j, staff2);
                    list.set(j + 1, staff1);
                }
            }
        }
        return list;
    }
        
        public ArrayList<staffDTO> search(String id){
        ArrayList <staffDTO> list = dsStaff;   
        ArrayList<staffDTO> list2 = new ArrayList<>();
        for (staffDTO i:list){
            if ((i.getStaffID().equals(id)) || (i.getFirstname().equals(id)))
            {
                list2.add(i);
            }
        }
        return list2;
        }
    }

