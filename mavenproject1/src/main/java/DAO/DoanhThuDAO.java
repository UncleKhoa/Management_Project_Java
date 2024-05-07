/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import static DAO.DBConnect.getConnect;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bon Nguyen
 */
public class DoanhThuDAO {
    
    Connection conn = getConnect();
    
    public ArrayList getDT_SanPham(){
        ArrayList ds_dtsp = new ArrayList<>();
        try{
            String sql = "select ";
            PreparedStatement stmt_ = conn.prepareStatement(sql);
        }
        catch(SQLException ex){
            System.out.print(ex);
        }
        return ds_dtsp;
    }
    
}
