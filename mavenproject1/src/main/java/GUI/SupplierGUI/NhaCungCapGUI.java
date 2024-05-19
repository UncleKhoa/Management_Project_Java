/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.SupplierGUI;

import BUS.supplierBUS;
import DTO.supplierDTO;
import Model.CustomConfirmDialog;
import Model.CustomHeaderRenderer;
import Model.MyMessageAccept;
import Model.MyMessageAlert;
import Model.NonEditableTableModel;
import static Model.helpers.Export_Excell;
import static Model.helpers.containsDigit;
import static Model.helpers.containsLetter;
import static Model.helpers.convertBackgroundOfTable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import Model.MyScrollBar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JFileChooser;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author MY PC
 */
public class NhaCungCapGUI extends javax.swing.JPanel {

    /**
     * Creates new form NhaCungCapGUI
     */
     DefaultTableModel model;
      int  check = -1;
       JFrame parentFrame;
       private ArrayList<supplierDTO> listncc;
    public NhaCungCapGUI() {
        initComponents();
        jScrollPane1.setVerticalScrollBar(new MyScrollBar());
        jScrollPane2.setVerticalScrollBar(new MyScrollBar());
        this.txtMancc.setEditable(false);
        On(false);
        onButton(false,true);
        supplierBUS bus = new supplierBUS();
        listncc = bus.list();
        ViewData(listncc);
        On_to_search(false,true);
       JTableHeader header = tblNc.getTableHeader();
       header.setDefaultRenderer(new CustomHeaderRenderer());
    }
    public void ViewData(ArrayList<supplierDTO> list)
    {
      
        convertBackgroundOfTable(tblNc);
        String[] header = {"Mã","Tên nhà cung cấp","Số điện thoại","Địa chỉ"};
        model = new NonEditableTableModel(new Object[0][header.length], header);
        tblNc.setModel(model);
        model.setColumnIdentifiers(header);
        tblNc.getColumnModel().getColumn(0).setPreferredWidth(70);
        tblNc.getColumnModel().getColumn(1).setPreferredWidth(90);
        tblNc.getColumnModel().getColumn(2).setPreferredWidth(90);
        tblNc.getColumnModel().getColumn(3).setPreferredWidth(110);
        removeData();
        
        for(supplierDTO sup:list)
        {
             addData(sup);
            
        }
       
    }
    public void addData(supplierDTO sup)
    {
        model.addRow(new Object[]{
           sup.getSupplierID(),sup.getSupplierName(),sup.getPhoneNumber(),sup.getAddress()
        });
    }
      public void removeData()
    {
        int count = model.getRowCount();
        for(int i= count-1;i>=0;i--)
        {
            model.removeRow(i);
        }
    }
      
      

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNc = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiachi = new javax.swing.JTextArea();
        txtSdt = new javax.swing.JTextField();
        txtMancc = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        lbQuayve = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnXuat = new javax.swing.JButton();
        btnNhap = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        lbHoac = new javax.swing.JLabel();
        lbLoc = new javax.swing.JLabel();
        txtKitu1 = new javax.swing.JTextField();
        txtKitu2 = new javax.swing.JTextField();
        lbKitu1 = new javax.swing.JLabel();
        lbTimkiem = new javax.swing.JLabel();
        lbTenncc = new javax.swing.JLabel();
        lbKitu2 = new javax.swing.JLabel();
        lbTim = new javax.swing.JLabel();
        lbLammoi = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(950, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(950, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblNc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblNc.setRowHeight(40);
        tblNc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNcMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNc);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 136, 489, 494));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Nhà cung cấp");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 17, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Tên");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 223, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Mã ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 154, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Số điện thoại");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 292, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Địa chỉ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 366, -1, -1));

        txtDiachi.setColumns(20);
        txtDiachi.setRows(5);
        jScrollPane2.setViewportView(txtDiachi);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 353, 245, 60));
        jPanel1.add(txtSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 289, 186, 37));

        txtMancc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManccActionPerformed(evt);
            }
        });
        jPanel1.add(txtMancc, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 151, 186, 37));
        jPanel1.add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 220, 186, 37));

        btnXoa.setBackground(new java.awt.Color(21, 52, 72));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 490, 90, 33));

        btnThem.setBackground(new java.awt.Color(18, 20, 129));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 490, 90, 33));

        btnSua.setBackground(new java.awt.Color(73, 36, 62));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, 90, 33));

        btnLuu.setBackground(new java.awt.Color(14, 41, 84));
        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        jPanel1.add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 90, 33));

        lbQuayve.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbQuayve.setForeground(new java.awt.Color(122, 178, 178));
        lbQuayve.setText("Quay về");
        lbQuayve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQuayveMouseClicked(evt);
            }
        });
        jPanel1.add(lbQuayve, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 70, -1));

        txtSearch.setPreferredSize(new java.awt.Dimension(350, 35));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 82, 415, 36));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel3.setText("Thông tin nhà cung cấp");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(617, 91, -1, -1));

        btnXuat.setBackground(new java.awt.Color(51, 49, 59));
        btnXuat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnXuat.setText("Xuất excel");
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });
        jPanel1.add(btnXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(826, 21, -1, 28));

        btnNhap.setBackground(new java.awt.Color(18, 20, 129));
        btnNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnNhap.setText("Nhập excel");
        btnNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapActionPerformed(evt);
            }
        });
        jPanel1.add(btnNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 21, 103, 28));

        btnHuy.setBackground(new java.awt.Color(15, 14, 14));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy bỏ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel1.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 490, 90, 33));

        lbHoac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHoac.setText("Hoặc");
        jPanel1.add(lbHoac, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 85, 40, -1));

        lbLoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLoc.setForeground(new java.awt.Color(122, 178, 178));
        lbLoc.setText("Lọc");
        lbLoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLocMouseClicked(evt);
            }
        });
        jPanel1.add(lbLoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 30, -1));
        jPanel1.add(txtKitu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 80, 90, 30));
        jPanel1.add(txtKitu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, 90, 30));

        lbKitu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbKitu1.setText("Chữ cái bắt đầu");
        jPanel1.add(lbKitu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 100, -1));

        lbTimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTimkiem.setText("Tìm kiếm");
        jPanel1.add(lbTimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 68, -1));

        lbTenncc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTenncc.setText("Tên nhà cung cấp ");
        jPanel1.add(lbTenncc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 120, -1));

        lbKitu2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbKitu2.setText("Chữ cái bắt đầu");
        jPanel1.add(lbKitu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 100, -1));

        lbTim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTim.setForeground(new java.awt.Color(255, 144, 188));
        lbTim.setText("Tìm kiếm");
        lbTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTimMouseClicked(evt);
            }
        });
        jPanel1.add(lbTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 70, -1));

        lbLammoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLammoi.setForeground(new java.awt.Color(159, 115, 171));
        lbLammoi.setText("Làm mới");
        lbLammoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLammoiMouseClicked(evt);
            }
        });
        jPanel1.add(lbLammoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 68, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtManccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManccActionPerformed
    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
//        this.hide();
//        _testsell.setVisible(true);
  CustomConfirmDialog confirm = new CustomConfirmDialog(parentFrame,"Xác nhận","Bạn có muốn xóa nhà cung cấp?","question.png");
            confirm.setVisible(true);
            
            if (confirm.getSelected()) {
        supplierBUS bus = new supplierBUS();
        String id = this.txtMancc.getText();
        String name = this.txtTen.getText();
        String phone = this.txtSdt.getText();
        String address = this.txtDiachi.getText();
        supplierDTO sup = new supplierDTO(id,name,phone,address);
         try {
             bus.delete(sup);
             MyMessageAccept accept = new MyMessageAccept(parentFrame, "Đã xóa nhà cung cấp thành công!");
             accept.setVisible(true);
             load();
             this.txtMancc.setText("");
             this.txtTen.setText("");
             this.txtSdt.setText("");
             this.txtDiachi.setText("");
         } catch (SQLException ex) {
             Logger.getLogger(NhaCungCapGUI.class.getName()).log(Level.SEVERE, null, ex);
         }
            }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void On_to_search(boolean a,boolean b)
    {
        this.lbLoc.setVisible(b);
        this.lbTimkiem.setVisible(b);
        this.txtSearch.setVisible(b);
        this.lbKitu1.setVisible(a);
        this.lbKitu2.setVisible(a);
        this.lbQuayve.setVisible(a);
        this.txtKitu1.setVisible(a);
        this.txtKitu2.setVisible(a);
        this.lbHoac.setVisible(a);
        this.lbTenncc.setVisible(a);
        this.lbTim.setVisible(a);
        this.lbLammoi.setVisible(a);
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        this.txtTen.setText("");
        this.txtSdt.setText("");
        this.txtDiachi.setText("");
        supplierBUS bus = new supplierBUS();
        String id = bus.createId();
        this.txtMancc.setText(id);
        check = 1;
        On(true);
        onButton(true,false);
        
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        check = 0;
        On(true);
        onButton(true,false);
    }//GEN-LAST:event_btnSuaActionPerformed
    private void load()
    {
        supplierBUS bus = new supplierBUS();
        listncc = new ArrayList<>();
        listncc = bus.list();
        ViewData(listncc);
    }
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
         CustomConfirmDialog confirm = new CustomConfirmDialog(parentFrame,"Xác nhận","Bạn có muốn lưu thay đổi?","question.png");
            confirm.setVisible(true);
            
            if (confirm.getSelected()) {
        boolean c = notice();
        if(c)
            return;
        supplierBUS bus = new supplierBUS();
        String id = this.txtMancc.getText();
        String name = this.txtTen.getText();
        String phone = this.txtSdt.getText();
        String address = this.txtDiachi.getText();
        supplierDTO sup = new supplierDTO(id,name,phone,address);
        if(check == 1)
        {
            try {
                bus.add(sup);
                check = -1;
                System.out.print("Them");
               MyMessageAccept accept = new MyMessageAccept(parentFrame, "Đã thêm nhà cung cấp thành công!");
               accept.setVisible(true);
                load();
                this.txtMancc.setText("");
                this.txtTen.setText("");
                this.txtSdt.setText("");
                this.txtDiachi.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else 
        {
            if(check == 0)
            {
                try {
                    bus.update(sup);
                    check = -1;
                     MyMessageAccept accept = new MyMessageAccept(parentFrame, "Đã sửa nhà cung cấp thành công!");
                     accept.setVisible(true);
                      System.out.print("Sua");
                        load();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaCungCapGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        On(false);
        onButton(false,true);
       }
    }//GEN-LAST:event_btnLuuActionPerformed

    private boolean notice()
    {
        String ten = this.txtTen.getText();
        String sdt = this.txtSdt.getText();
        if(containsDigit(ten))
        {
              MyMessageAlert alert = new MyMessageAlert(parentFrame, "Tên sai định dạng");
              alert.setVisible(true);
              return true;
        }
              if(containsLetter(sdt))
        {
              MyMessageAlert alert = new MyMessageAlert(parentFrame, "Số điện thoại sai định dạng");
              alert.setVisible(true);
              return true;
        }
                 if (this.txtTen.getText().trim().isEmpty()) {
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng nhập tên ");
                alert.setVisible(true);
                return true;
               }
                  if (this.txtSdt.getText().trim().isEmpty()) {
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng nhập số điện thoại ");
                alert.setVisible(true);
                return true;
               }
                     if (this.txtDiachi.getText().trim().isEmpty()) {
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng nhập địa chỉ ");
                alert.setVisible(true);
                return true;
               }
                       if(this.txtSdt.getText().length()!=10)
        {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Số điện thoại sai định dạng. Vui lòng nhập lại");
            alert.setVisible(true);
            return true;
        }
         return false;
        
    }
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
          supplierBUS bus = new supplierBUS();
          String s = txtSearch.getText();
        if(!s.equals("")){
           ArrayList <supplierDTO> list = new ArrayList<>();
            list =  bus.SeardByIdAndName(s, listncc);
            ViewData(list);
        }
        else{
            load();
        }
       
         
        
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        // TODO add your handling code here:
         Export_Excell(this.tblNc);
    }//GEN-LAST:event_btnXuatActionPerformed

    private boolean khongHopLe(String ma, String ten, String sdt,String diaChi,ArrayList<supplierDTO> listncc)
    {
         supplierBUS bus = new supplierBUS();
        if(containsDigit(ten))
        {
              MyMessageAlert alert = new MyMessageAlert(parentFrame, "Họ sai định dạng");
              alert.setVisible(true);
              return true;
        }
              if(containsLetter(sdt))
        {
              MyMessageAlert alert = new MyMessageAlert(parentFrame, "Số điện thoại sai định dạng");
              alert.setVisible(true);
              return true;
        }
                if (ma.trim().isEmpty()) {
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Mã bị bỏ trống ");
                alert.setVisible(true);
                return true;
               }
                 if (ten.trim().isEmpty()) {
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Tên bị bỏ trống ");
                alert.setVisible(true);
                return true;
               }
                  if (sdt.trim().isEmpty()) {
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Số điện thoại bị bỏ trống");
                alert.setVisible(true);
                return true;
               }
                     if ( diaChi.trim().isEmpty()) {
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Địa chỉ bị bỏ trống");
                alert.setVisible(true);
                return true;
               }
                       if( sdt.length()!=10)
        {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Số điện thoại sai định dạng");
            alert.setVisible(true);
            return true;
        }
         if(bus.checkId(ma, listncc))
         {
              MyMessageAlert alert = new MyMessageAlert(parentFrame, "Mã đã bị trùng");
                alert.setVisible(true);
                return true;
         }
         return false;
    }
    private void btnNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapActionPerformed
        // TODO add your handling code here:
        int check = 0;
        JFileChooser chooser = new JFileChooser();
        supplierBUS bus = new supplierBUS();
        int j = chooser.showOpenDialog(chooser);
        if (j == JFileChooser.APPROVE_OPTION) {
         File file = chooser.getSelectedFile();
            try {
                InputStream input = new FileInputStream(file);
               
               XSSFWorkbook wb = new XSSFWorkbook(input); // Sử dụng XSSFWorkbook trực tiếp

                XSSFSheet sheet = wb.getSheetAt(0);
                Row row;
                for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                    row = sheet.getRow(i);
                    String ma = row.getCell(0).getStringCellValue();
                    String ten = row.getCell(1).getStringCellValue();
                    String sdt = row.getCell(2).getStringCellValue();
                    String diaChi = row.getCell(3).getStringCellValue();
                   if(khongHopLe(ma,ten,sdt,diaChi,listncc))
                   {
                      int dong = i+1;
                      MyMessageAlert alert = new MyMessageAlert(parentFrame, "Dòng "+dong+ " không thế thêm");
                      alert.setVisible(true);
                      check = 1;
                      break;
                   }
                   else{
                   supplierDTO supplier = new supplierDTO(ma,ten,sdt,diaChi);
                   bus.add(supplier);
                  // load();
                   }
            }
             
             load();
             if(check == 0){
             MyMessageAccept accept = new MyMessageAccept(parentFrame, "Đã thêm thành công!");
             accept.setVisible(true);
             }  
                
            }
            catch (IOException ex) {
                 Logger.getLogger(NhaCungCapGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapGUI.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_btnNhapActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        On(false);
        onButton(false,true);
    }//GEN-LAST:event_btnHuyActionPerformed
 
    private void On(boolean a)
    {
      
        this.txtTen.setEditable(a);   
        this.txtSdt.setEditable(a);
        this.txtDiachi.setEditable(a);
    }
    private void onButton(boolean a,boolean b)
    {
        this.btnHuy.setVisible(a);
        this.btnLuu.setVisible(a);
        this.btnThem.setVisible(b);
        this.btnSua.setVisible(b);
        this.btnXoa.setVisible(b);
    }
    private void tblNcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNcMouseClicked
        // TODO add your handling code here:
        int select = tblNc.getSelectedRow();
        Object iD = model.getValueAt(select, 0);
        Object name = model.getValueAt(select, 1);
        Object phone = model.getValueAt(select, 2);   
        Object address = model.getValueAt(select, 3);
        String maNcc = iD.toString();
        String ten = name.toString();
        String sdt = phone.toString();
        String diaChi = address.toString();
        this.txtMancc.setText(maNcc);
        this.txtTen.setText(ten);
        this.txtSdt.setText(sdt);
        this.txtDiachi.setText(diaChi);
              
    }//GEN-LAST:event_tblNcMouseClicked

    private void lbQuayveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQuayveMouseClicked
        // TODO add your handling code here:
        On_to_search(false,true);
        this.txtKitu1.setText("");
        this.txtKitu2.setText("");
        ViewData(listncc);
    }//GEN-LAST:event_lbQuayveMouseClicked

    private void lbLocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLocMouseClicked
        // TODO add your handling code here:
         On_to_search(true,false);
    }//GEN-LAST:event_lbLocMouseClicked

    private void lbTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTimMouseClicked
        // TODO add your handling code here:
         if(this.txtKitu1.getText().trim().isEmpty()&&this.txtKitu2.getText().trim().isEmpty())
         {
              MyMessageAlert alert = new MyMessageAlert(parentFrame, "Không được để trống cả 2 ô nhập");
              alert.setVisible(true);
              return;
         }
        
        if(containsDigit(txtKitu1.getText())||containsDigit(txtKitu2.getText()))
        {
             MyMessageAlert alert = new MyMessageAlert(parentFrame, "Không chấp nhận kí tự số");
              alert.setVisible(true);
              return;
        }
        if(this.txtKitu1.getText().length()>1)
        {
             MyMessageAlert alert = new MyMessageAlert(parentFrame, "Lưu ý chỉ nhập 1 chữ cái trong ô đầu tiên");
              alert.setVisible(true);
              return;
        }
         if(this.txtKitu2.getText().length()>1)
        {
             MyMessageAlert alert = new MyMessageAlert(parentFrame, "Lưu ý chỉ nhập 1 chữ cái trong ô thứ hai");
              alert.setVisible(true);
              return;
        }
         String a1 = this.txtKitu1.getText();
      
         String a2 = this.txtKitu2.getText();
         supplierBUS bus = new supplierBUS();
         ArrayList<supplierDTO> listds = new ArrayList<>();

          listds = bus.SearchByName(a1, a2, listncc);
          if(listds!= null)
          {
               ViewData(listds);
          }
          else
          {
               MyMessageAlert alert = new MyMessageAlert(parentFrame, "Không tìm thấy nhà cung cấp thỏa điều kiện");
              alert.setVisible(true);
          }
         
    }//GEN-LAST:event_lbTimMouseClicked

    private void lbLammoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLammoiMouseClicked
        // TODO add your handling code here:
        this.txtKitu1.setText("");
        this.txtKitu2.setText("");
        ViewData(listncc);
    }//GEN-LAST:event_lbLammoiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNhap;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuat;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbHoac;
    private javax.swing.JLabel lbKitu1;
    private javax.swing.JLabel lbKitu2;
    private javax.swing.JLabel lbLammoi;
    private javax.swing.JLabel lbLoc;
    private javax.swing.JLabel lbQuayve;
    private javax.swing.JLabel lbTenncc;
    private javax.swing.JLabel lbTim;
    private javax.swing.JLabel lbTimkiem;
    private javax.swing.JTable tblNc;
    private javax.swing.JTextArea txtDiachi;
    private javax.swing.JTextField txtKitu1;
    private javax.swing.JTextField txtKitu2;
    private javax.swing.JTextField txtMancc;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
