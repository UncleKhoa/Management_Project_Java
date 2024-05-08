/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.customerDAO;
import DTO.customerDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ThinkBook
 */
public class customerBUS {

    private ArrayList<customerDTO> dsCus;

    public customerBUS() {
        list();
    }

    public void list() {
        customerDAO dao = new customerDAO();
        dsCus = new ArrayList<>();
        dsCus = dao.list();
    }

    public ArrayList<customerDTO> getList() {
        return dsCus;
    }

    public customerDTO get(String cusid) {

        for (customerDTO i : dsCus) {
            if (i.getCusID().equals(cusid)) {
                return i;
            }

        }
        return null;
    }

    public ArrayList<customerDTO> search(String s) {
        ArrayList<customerDTO> list = new ArrayList<>();
        for (customerDTO i : dsCus) {
            if (i.getCusID().equals(s) || i.getFirstName().equals(s)) {
                list.add(i);
            }
        }
        return list;
    }

    public customerDTO searchsdt(String sdt)throws SQLException
    {
       customerDTO cusDTO = new customerDTO();
        customerDAO cus = new customerDAO();
       // cus_list = new ArrayList<>();
        cusDTO = cus.searchsdt(sdt);
        return cusDTO;
    }
    public int add(customerDTO cus) throws SQLException{
        if(cus.getPhoneNumber().length()!=10)
        {
            return 0;
        }
        else {
            if(!cus.getGender().equals("Nam") && !cus.getGender().equals("Nữ"))
            {    
                return -1;
            }
            else {
                   customerDAO customer = new customerDAO();
                    customer.add(cus);
                    return 1;
            }
        }
     
    }
    
    public String createId()
    {
        customerDAO dao = new customerDAO();
        String maKh;
        dsCus = new ArrayList<>();
        dsCus = dao.list();
        int l = dsCus.size();
        l = l + 1;
        if (l < 10) {
            maKh = "KH0" + String.valueOf(l);
        } else {
            maKh = "KH" + String.valueOf(l);
        }

        return maKh;

    }
    
        public int TotalCustomer() {
        int totalCustomers = 0;
        try {
            customerDAO customerDAO = new customerDAO();
            totalCustomers = customerDAO.SL_KH();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return totalCustomers;
    }

}

