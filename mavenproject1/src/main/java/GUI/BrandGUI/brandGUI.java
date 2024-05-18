/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.BrandGUI;

import BUS.brandBUS;
import DTO.brandDTO;
import Model.CustomConfirmDialog;
import Model.MyMessageAccept;
import Model.MyMessageAlert;
import Model.NonEditableTableModel;
import static Model.helpers.containsDigit;
import static Model.helpers.convertBackgroundOfTable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import Model.CustomHeaderRenderer;
import Model.MyScrollBar;
/**
 *
 * @author MY PC
 */
public class brandGUI extends javax.swing.JFrame {

    /**
     * Creates new form branGUI
     */
    DefaultTableModel model;
    private ArrayList<brandDTO> list;

    public brandGUI() {
        initComponents();
        jScrollPane1.setVerticalScrollBar(new MyScrollBar());
        brandBUS bus = new brandBUS();
        list = bus.list();
        ViewData(list);
        JTableHeader header = tblBrand.getTableHeader();
        header.setDefaultRenderer(new CustomHeaderRenderer());
        this.txtMa.setEditable(false);
        On(true, false);

    }

    private void ViewData(ArrayList<brandDTO> list) {
        convertBackgroundOfTable(this.tblBrand);
        String[] header = {"Mã nhãn hiệu", "Tên nhãn hiệu"};
        model = new NonEditableTableModel(new Object[0][header.length], header);
        tblBrand.setModel(model);
        model.setColumnIdentifiers(header);
        tblBrand.getColumnModel().getColumn(0).setPreferredWidth(70);
        tblBrand.getColumnModel().getColumn(1).setPreferredWidth(90);
        removeData();
        for (brandDTO brand : list) {
            addData(brand);
        }

    }

    private void addData(brandDTO brand) {
        model.addRow(new Object[]{
            brand.getBrandId(), brand.getBrandName()
        }
        );
    }

    private void removeData() {
        int count = model.getRowCount();
        for (int i = count - 1; i >= 0; i--) {
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
        tblBrand = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXacnhan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBrand.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBrand.setRowHeight(30);
        tblBrand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBrandMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBrand);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 56, 378, 290));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tên nhãn hiệu");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 186, 102, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Thông tin nhãn hiệu");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 7, 184, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mã nhãn hiệu");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 82, 102, -1));
        jPanel1.add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 181, 149, 32));
        jPanel1.add(txtMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 77, 149, 32));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tìm kiếm");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 11, -1, -1));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 6, 302, 32));

        btnXoa.setBackground(new java.awt.Color(0, 103, 105));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 286, -1, 25));

        btnThem.setBackground(new java.awt.Color(142, 62, 99));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 286, -1, 25));

        btnSua.setBackground(new java.awt.Color(36, 7, 80));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 286, -1, 25));

        btnXacnhan.setBackground(new java.awt.Color(142, 62, 99));
        btnXacnhan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXacnhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacnhan.setText("Xác nhận");
        btnXacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacnhanActionPerformed(evt);
            }
        });
        jPanel1.add(btnXacnhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 286, -1, 25));

        btnHuy.setBackground(new java.awt.Color(36, 7, 80));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel1.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 286, -1, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void On(boolean a, boolean b) {
        this.btnThem.setVisible(a);
        this.btnSua.setVisible(a);
        this.btnXacnhan.setVisible(b);
        this.btnHuy.setVisible(b);
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        CustomConfirmDialog corfirm = new CustomConfirmDialog(this, "Xác nhận", "Bạn có muốn thêm nhãn?", "question.png");
        corfirm.setVisible(true);
        if (corfirm.getSelected()) {
            this.txtMa.setText("");
            this.txtMa.setEditable(true);
            this.txtTen.setText("");
            On(false, true);

        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (this.txtTen.getText().trim().isEmpty()) {
            MyMessageAlert alert = new MyMessageAlert(this, "Tên không được để trống ");
            alert.setVisible(true);
            return;
        }
        if (containsDigit(this.txtTen.getText())) {
            MyMessageAlert alert = new MyMessageAlert(this, "Tên sai định dạng ");
            alert.setVisible(true);
            return;
        }
        CustomConfirmDialog corfirm = new CustomConfirmDialog(this, "Xác nhận", "Bạn có muốn sửa nhãn không?", "question.png");
        corfirm.setVisible(true);
        if (corfirm.getSelected()) {
            brandBUS bus = new brandBUS();
            String ma = this.txtMa.getText();
            String ten = this.txtTen.getText();
            brandDTO brand = new brandDTO(ma, ten);
            try {
                bus.update(brand);
                MyMessageAccept accept = new MyMessageAccept(this, "Đã sửa nhãn thành công!");
                accept.setVisible(true);
                load();
            } catch (SQLException ex) {
                Logger.getLogger(brandGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        CustomConfirmDialog corfirm = new CustomConfirmDialog(this, "Xác nhận", "Bạn có muốn xóa nhãn không?", "question.png");
        corfirm.setVisible(true);
        if (corfirm.getSelected()) {
            brandBUS bus = new brandBUS();
            String ma = this.txtMa.getText();
            String ten = this.txtTen.getText();
            brandDTO brand = new brandDTO(ma, ten);
            try {
                bus.delete(brand);
                MyMessageAccept accept = new MyMessageAccept(this, "Đã xóa nhãn thành công!");
                accept.setVisible(true);
                this.txtMa.setText("");
                this.txtTen.setText("");
                load();
            } catch (SQLException ex) {
                Logger.getLogger(brandGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblBrandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBrandMouseClicked
        // TODO add your handling code here:
        int row = this.tblBrand.getSelectedRow();
        Object id = model.getValueAt(row, 0);
        Object name = model.getValueAt(row, 1);
        String ma = id.toString();
        String ten = name.toString();
        this.txtMa.setText(ma);
        this.txtTen.setText(ten);
    }//GEN-LAST:event_tblBrandMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:

        String s = txtSearch.getText();
        if (!s.equals("")) {
            ArrayList<brandDTO> brandlist = new ArrayList<>();
            brandBUS bus = new brandBUS();
            brandlist = bus.SeardByIdAndName(s, list);
            ViewData(brandlist);
        } else {
            load();
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnXacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacnhanActionPerformed
        // TODO add your handling code here:
        if (this.txtTen.getText().trim().isEmpty()) {
            MyMessageAlert alert = new MyMessageAlert(this, "Tên không được để trống ");
            alert.setVisible(true);
            return;
        }

        if (containsDigit(this.txtTen.getText())) {
            MyMessageAlert alert = new MyMessageAlert(this, "Tên sai định dạng ");
            alert.setVisible(true);
            return;
        }

        if (this.txtMa.getText().trim().isEmpty()) {
            MyMessageAlert alert = new MyMessageAlert(this, "Mã không được để trống ");
            alert.setVisible(true);
            return;
        }

        if (containsDigit(this.txtMa.getText())) {
            MyMessageAlert alert = new MyMessageAlert(this, "Tên sai định dạng ");
            alert.setVisible(true);
            return;
        }

        brandBUS bus = new brandBUS();
        String ma = txtMa.getText();
        if (bus.checkID(ma, list)) {
            MyMessageAlert alert = new MyMessageAlert(this, "Mã bị trùng, Vui lòng nhập mã khác ");
            alert.setVisible(true);
            return;
        }
        
        String ten = this.txtTen.getText();
        brandDTO brand = new brandDTO(ma, ten);
        try {
            bus.add(brand);
            MyMessageAccept accept = new MyMessageAccept(this, "Đã thêm nhãn thành công!");
            this.txtMa.setText("");
            this.txtTen.setText("");
            accept.setVisible(true);
            this.txtMa.setEditable(false);
            On(true, false);

            load();

        } catch (SQLException ex) {
            Logger.getLogger(brandGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXacnhanActionPerformed
    private void load() {
        brandBUS bus = new brandBUS();
        ArrayList list = new ArrayList<>();
        list = bus.list();
        ViewData(list);
    }
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        On(true, false);
    }//GEN-LAST:event_btnHuyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(brandGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(brandGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(brandGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(brandGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new brandGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXacnhan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBrand;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}