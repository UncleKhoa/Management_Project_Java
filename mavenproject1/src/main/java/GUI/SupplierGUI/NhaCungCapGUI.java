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
        this.txtMancc.setEditable(false);
        On(false);
        onButton(false,true);
        supplierBUS bus = new supplierBUS();
        listncc = bus.list();
        ViewData(listncc);
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
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnXuat = new javax.swing.JButton();
        btnNhap = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

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

        btnXoa.setBackground(new java.awt.Color(73, 36, 62));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 490, 90, 33));

        btnThem.setBackground(new java.awt.Color(73, 36, 62));
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

        btnLuu.setBackground(new java.awt.Color(73, 36, 62));
        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        jPanel1.add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 90, 33));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tìm kiếm");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 89, 68, -1));

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

        btnHuy.setBackground(new java.awt.Color(73, 36, 62));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy bỏ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel1.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 490, 90, 33));

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
             this.txtTen.setText("");
             this.txtSdt.setText("");
             this.txtDiachi.setText("");
         } catch (SQLException ex) {
             Logger.getLogger(NhaCungCapGUI.class.getName()).log(Level.SEVERE, null, ex);
         }
            }
    }//GEN-LAST:event_btnXoaActionPerformed

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
    }//GEN-LAST:event_btnLuuActionPerformed

    private boolean notice()
    {
        String ten = this.txtTen.getText();
        String sdt = this.txtSdt.getText();
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
       
         
        
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        // TODO add your handling code here:
         Export_Excell(this.tblNc);
    }//GEN-LAST:event_btnXuatActionPerformed

    private void btnNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapActionPerformed
        // TODO add your handling code here:
        
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblNc;
    private javax.swing.JTextArea txtDiachi;
    private javax.swing.JTextField txtMancc;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
