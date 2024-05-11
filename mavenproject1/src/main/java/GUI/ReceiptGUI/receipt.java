/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.ReceiptGUI;

import BUS.importBUS;
import DTO.receptDTO;
import BUS.receptBUS;
import DTO.importDTO;
import Model.CustomHeaderRenderer;
import Model.CustomTableCellRenderer;
import Model.MyMessageAlert;
import Model.NonEditableTableModel;
import javax.swing.table.DefaultTableModel;
import static Model.helpers.*;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Bon Nguyen
 */
public class receipt extends javax.swing.JFrame {

    DefaultTableModel model_receipt;
    DefaultTableModel model_import;
    DefaultTableModel model;
    receptBUS receptBUS;
    importBUS importBUS;

    ArrayList<receptDTO> list_hd;
    ArrayList<importDTO> list_nh;
    int selectRow_hd;
    int selectRow_nh;

    

    /**
     * Creates new form receipt
     */
    public receipt() {
        initComponents();
        setLocationRelativeTo(null);
        JTableHeader header = tblReceipt.getTableHeader();
        header.setDefaultRenderer(new CustomHeaderRenderer());
        JTableHeader header1 = tblImport.getTableHeader();
        header1.setDefaultRenderer(new CustomHeaderRenderer());
        receptBUS = new receptBUS();
        importBUS = new importBUS();
        list_hd = receptBUS.getListReceipt();
        list_nh = importBUS.getListImport();
        AddLine_cbRectipt();
        Addline_cbImport();
        OnOff(false);

        try {
            receptBUS.viewTableReceipt(tblReceipt, list_hd);
            importBUS.viewTableImport(tblImport, list_nh);
        } catch (ParseException ex) {
            Logger.getLogger(receipt.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbMethodReceipt = new Model.Combobox();
        txtDateStartReceipt = new javax.swing.JLabel();
        txtDateEndReceipt = new javax.swing.JLabel();
        btnacceptMethodHD = new javax.swing.JButton();
        txtSearchReceipt_label = new javax.swing.JLabel();
        txtSearchReceipt = new javax.swing.JTextField();
        DateStartReceipt = new com.toedter.calendar.JDateChooser();
        DateEndReceipt = new com.toedter.calendar.JDateChooser();
        btnAcceptReceipt = new javax.swing.JButton();
        txtPriceReceiptFrom_src = new javax.swing.JTextField();
        txtPriceReceiptTo_src = new javax.swing.JTextField();
        txtPriceReceiptFrom = new javax.swing.JLabel();
        txtPriceReceiptTo = new javax.swing.JLabel();
        btnAcceptReceiptPrice = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtSearchImport = new javax.swing.JTextField();
        btnAcceptMethodNH = new javax.swing.JButton();
        btnAcceptImport = new javax.swing.JButton();
        txtDateStartImport = new javax.swing.JLabel();
        txtDateEndImport = new javax.swing.JLabel();
        txtSearchImport_label = new javax.swing.JLabel();
        DateStartImport = new com.toedter.calendar.JDateChooser();
        DateEndImport = new com.toedter.calendar.JDateChooser();
        cbMethodImport = new Model.Combobox();
        jLabel4 = new javax.swing.JLabel();
        txtPriceImportFrom_src = new javax.swing.JTextField();
        txtPriceImportTo_src = new javax.swing.JTextField();
        txtPriceImportFrom = new javax.swing.JLabel();
        txtPriceImportTo = new javax.swing.JLabel();
        btnAcceptImportPrice = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReceipt = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblImport = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(950, 650));

        jPanel2.setBackground(new java.awt.Color(246, 246, 250));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Danh sách hóa đơn chứng từ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(246, 246, 250));
        jPanel3.setPreferredSize(new java.awt.Dimension(466, 128));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Tìm kiếm hóa đơn");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel3.add(cbMethodReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 6, 150, -1));

        txtDateStartReceipt.setText("Từ ngày");
        jPanel3.add(txtDateStartReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtDateEndReceipt.setText("Đến ngày");
        jPanel3.add(txtDateEndReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        btnacceptMethodHD.setText("Xác nhận");
        btnacceptMethodHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnacceptMethodHDActionPerformed(evt);
            }
        });
        jPanel3.add(btnacceptMethodHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        txtSearchReceipt_label.setText("Tìm kiếm");
        jPanel3.add(txtSearchReceipt_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtSearchReceipt.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSearchReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchReceiptActionPerformed(evt);
            }
        });
        jPanel3.add(txtSearchReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 450, 40));

        DateStartReceipt.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(DateStartReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 40));

        DateEndReceipt.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(DateEndReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 150, 40));

        btnAcceptReceipt.setText("Xác nhận");
        btnAcceptReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptReceiptActionPerformed(evt);
            }
        });
        jPanel3.add(btnAcceptReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        txtPriceReceiptFrom_src.setPreferredSize(new java.awt.Dimension(160, 40));
        txtPriceReceiptFrom_src.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceReceiptFrom_srcActionPerformed(evt);
            }
        });
        jPanel3.add(txtPriceReceiptFrom_src, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, 40));

        txtPriceReceiptTo_src.setPreferredSize(new java.awt.Dimension(160, 40));
        jPanel3.add(txtPriceReceiptTo_src, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, 40));

        txtPriceReceiptFrom.setText("Từ");
        jPanel3.add(txtPriceReceiptFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtPriceReceiptTo.setText("Đến");
        jPanel3.add(txtPriceReceiptTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        btnAcceptReceiptPrice.setText("Xác nhận");
        btnAcceptReceiptPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptReceiptPriceActionPerformed(evt);
            }
        });
        jPanel3.add(btnAcceptReceiptPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 83, -1, 20));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 80, -1));

        jPanel4.setBackground(new java.awt.Color(246, 246, 250));
        jPanel4.setPreferredSize(new java.awt.Dimension(466, 128));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearchImport.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jPanel4.add(txtSearchImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 450, 40));

        btnAcceptMethodNH.setText("Xác nhận");
        btnAcceptMethodNH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptMethodNHActionPerformed(evt);
            }
        });
        jPanel4.add(btnAcceptMethodNH, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        btnAcceptImport.setText("Xác nhận");
        btnAcceptImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptImportActionPerformed(evt);
            }
        });
        jPanel4.add(btnAcceptImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        txtDateStartImport.setText("Từ ngày");
        jPanel4.add(txtDateStartImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtDateEndImport.setText("Đến ngày");
        jPanel4.add(txtDateEndImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        txtSearchImport_label.setText("Tìm kiếm");
        jPanel4.add(txtSearchImport_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        DateStartImport.setDateFormatString("yyyy-MM-dd");
        jPanel4.add(DateStartImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 40));

        DateEndImport.setDateFormatString("yyyy-MM-dd");
        jPanel4.add(DateEndImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 150, 40));
        jPanel4.add(cbMethodImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 6, 150, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Tìm kiếm phiếu");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtPriceImportFrom_src.setPreferredSize(new java.awt.Dimension(160, 40));
        jPanel4.add(txtPriceImportFrom_src, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 40));

        txtPriceImportTo_src.setPreferredSize(new java.awt.Dimension(160, 40));
        jPanel4.add(txtPriceImportTo_src, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, 40));

        txtPriceImportFrom.setText("Từ");
        jPanel4.add(txtPriceImportFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtPriceImportTo.setText("Đến");
        jPanel4.add(txtPriceImportTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        btnAcceptImportPrice.setText("Xác nhận");
        btnAcceptImportPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptImportPriceActionPerformed(evt);
            }
        });
        jPanel4.add(btnAcceptImportPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 83, -1, 20));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 80, -1));

        tblReceipt.setModel(new javax.swing.table.DefaultTableModel(
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
        tblReceipt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReceiptMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblReceipt);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );

        tblImport.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblImport);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void OnOff(boolean a) {
        //Hóa đơn
        txtSearchReceipt_label.show(a);
        txtSearchReceipt.show(a);

        txtDateStartReceipt.show(a);
        DateStartReceipt.show(a);
        txtDateEndReceipt.show(a);
        DateEndReceipt.show(a);
        btnAcceptReceipt.show(a);

        txtPriceReceiptFrom.show(a);
        txtPriceReceiptFrom_src.show(a);
        txtPriceReceiptTo.show(a);
        txtPriceReceiptTo_src.show(a);
        btnAcceptReceiptPrice.show(a);

        //Phiếu nhập
        txtSearchImport_label.show(a);
        txtSearchImport.show(a);

        txtDateStartImport.show(a);
        DateStartImport.show(a);
        txtDateEndImport.show(a);
        DateEndImport.show(a);
        btnAcceptImport.show(a);

        txtPriceImportFrom.show(a);
        txtPriceImportFrom_src.show(a);
        txtPriceImportTo.show(a);
        txtPriceImportTo_src.show(a);
        btnAcceptImportPrice.show(a);
    }

    public void AddLine_cbRectipt() {
        cbMethodReceipt.addItem("Mã");
        cbMethodReceipt.addItem("Khoảng thời gian");
        cbMethodReceipt.addItem("Khoảng giá");
    }

    public void Addline_cbImport() {
        cbMethodImport.addItem("Mã");
        cbMethodImport.addItem("Khoảng thời gian");
        cbMethodImport.addItem("Khoảng giá");
    }

    public void OnOff_Receipt(boolean a, boolean b, boolean c) {
        txtSearchReceipt_label.show(a);
        txtSearchReceipt.show(a);

        txtDateStartReceipt.show(b);
        DateStartReceipt.show(b);
        txtDateEndReceipt.show(b);
        DateEndReceipt.show(b);
        btnAcceptReceipt.show(b);

        txtPriceReceiptFrom.show(c);
        txtPriceReceiptFrom_src.show(c);
        txtPriceReceiptTo.show(c);
        txtPriceReceiptTo_src.show(c);
        btnAcceptReceiptPrice.show(c);
    }

    public void OnOff_Import(boolean a, boolean b, boolean c) {
        txtSearchImport_label.show(a);
        txtSearchImport.show(a);

        txtDateStartImport.show(b);
        DateStartImport.show(b);
        txtDateEndImport.show(b);
        DateEndImport.show(b);
        btnAcceptImport.show(b);

        txtPriceImportFrom.show(c);
        txtPriceImportFrom_src.show(c);
        txtPriceImportTo.show(c);
        txtPriceImportTo_src.show(c);
        btnAcceptImportPrice.show(c);
    }

    public Date getDateStartReceiptChooser() throws ParseException {
        return Convert_date(DateStartReceipt.getDate());
    }

    public Date getDateEndReceiptChooser() throws ParseException {
        return Convert_date(DateEndReceipt.getDate());
    }

    public Date getDateStartImportChooser() throws ParseException {
        return Convert_date(DateStartImport.getDate());
    }

    public Date getDateEndImportChooser() throws ParseException {
        return Convert_date(DateEndImport.getDate());
    }

    public void CheckDate_Receipt() {
        if (DateStartReceipt.getDate() == null || DateEndReceipt.getDate() == null) {
            MyMessageAlert alert = new MyMessageAlert(this, "Vui lòng chọn đầy đủ ngày");
            alert.setVisible(true);
            return;
        }
    }

    public void CheckDate_Import() {
        if (DateStartImport.getDate() == null || DateEndImport.getDate() == null) {
            MyMessageAlert alert = new MyMessageAlert(this, "Vui lòng chọn đầy đủ ngày");
            alert.setVisible(true);
            return;
        }
    }
    
    public void viewInformation_HD(receptDTO hd){
        System.out.println(hd.getReceptID());
    }

    private void txtSearchReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchReceiptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchReceiptActionPerformed

    private void btnacceptMethodHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnacceptMethodHDActionPerformed
        if (cbMethodReceipt.getSelectedItem().equals("Mã")) {
            OnOff_Receipt(true, false, false);
        }
        if (cbMethodReceipt.getSelectedItem().equals("Khoảng thời gian")) {
            OnOff_Receipt(false, true, false);
        }
        if (cbMethodReceipt.getSelectedItem().equals("Khoảng giá")) {
            OnOff_Receipt(false, false, true);
        }
    }//GEN-LAST:event_btnacceptMethodHDActionPerformed

    private void btnAcceptMethodNHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptMethodNHActionPerformed
        if (cbMethodImport.getSelectedItem().equals("Mã")) {
            OnOff_Import(true, false, false);
        }
        if (cbMethodImport.getSelectedItem().equals("Khoảng thời gian")) {
            OnOff_Import(false, true, false);
        }
        if (cbMethodImport.getSelectedItem().equals("Khoảng giá")) {
            OnOff_Import(false, false, true);
        }
    }//GEN-LAST:event_btnAcceptMethodNHActionPerformed

    private void txtPriceReceiptFrom_srcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceReceiptFrom_srcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceReceiptFrom_srcActionPerformed

    private void btnAcceptReceiptPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptReceiptPriceActionPerformed
        receptBUS = new receptBUS();
        String a = txtPriceReceiptFrom_src.getText();
        String b = txtPriceReceiptTo_src.getText();
        if (!Check_Number(a) || !Check_Number(b)) {
            MyMessageAlert alert = new MyMessageAlert(this, "Vui lòng chỉ nhập kí tự số");
            alert.setVisible(true);
            return;
        } else {
            int c = Integer.parseInt(a);
            int d = Integer.parseInt(b);
            if (!ComparePrice(c, d)) {
                MyMessageAlert alert = new MyMessageAlert(this, "Nhập giá tiền sai");
                alert.setVisible(true);
                return;
            } else {
                ArrayList<receptDTO> newlist_receipt = new ArrayList<>();
                newlist_receipt = receptBUS.getListPrice(c, d);
                try {
                    receptBUS.viewTableReceipt(tblReceipt, newlist_receipt);
                } catch (ParseException ex) {
                    Logger.getLogger(receipt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_btnAcceptReceiptPriceActionPerformed

    private void btnAcceptImportPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptImportPriceActionPerformed
        String a = txtPriceImportFrom_src.getText();
        String b = txtPriceImportTo_src.getText();
        if (Check_Number(a) || Check_Number(b)) {
            MyMessageAlert alert = new MyMessageAlert(this, "Vui lòng chỉ nhập kí tự số");
            alert.setVisible(true);
            return;
        } else {
            int c = Integer.parseInt(a);
            int d = Integer.parseInt(b);
            if (!ComparePrice(c, d)) {
                MyMessageAlert alert = new MyMessageAlert(this, "Nhập giá tiền sai");
                alert.setVisible(true);
                return;
            } else {
                ArrayList<importDTO> newlist_import = new ArrayList<>();
                newlist_import = importBUS.getListPrice(c, d);
                try {
                    importBUS.viewTableImport(tblImport, newlist_import);
                } catch (ParseException ex) {
                    Logger.getLogger(receipt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnAcceptImportPriceActionPerformed

    private void btnAcceptImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptImportActionPerformed
        CheckDate_Import();
        importBUS = new importBUS();
        if (!Compare_Date(DateStartImport.getDate(), DateEndImport.getDate())) {
            MyMessageAlert alert = new MyMessageAlert(this, "Ngày chọn không hợp lệ");
            alert.setVisible(true);
            return;
        }
        else{
            try {
                ArrayList<importDTO> newlist_import = new ArrayList<>();
                newlist_import = importBUS.getPhieunhap_NgayBan(Convert_date(DateStartImport.getDate()), Convert_date(DateEndImport.getDate()));
                importBUS.viewTableImport(tblImport, newlist_import);
            } catch (ParseException ex) {
                Logger.getLogger(receipt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAcceptImportActionPerformed

    private void btnAcceptReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptReceiptActionPerformed
        CheckDate_Receipt();
        receptBUS = new receptBUS();
        if (!Compare_Date(DateStartReceipt.getDate(), DateEndReceipt.getDate())) {
            MyMessageAlert alert = new MyMessageAlert(this, "Ngày chọn không hợp lệ");
            alert.setVisible(true);
            return;
        }
        else{
            try {
                ArrayList<receptDTO> newlist_recept = new ArrayList<>();
                newlist_recept = receptBUS.getHoadon_NgayBan(Convert_date(DateStartReceipt.getDate()), Convert_date(DateEndReceipt.getDate()));
                receptBUS.viewTableReceipt(tblReceipt, newlist_recept);
            } catch (ParseException ex) {
                Logger.getLogger(receipt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAcceptReceiptActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            receptBUS.viewTableReceipt(tblReceipt, list_hd);
        } catch (ParseException ex) {
            Logger.getLogger(receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            importBUS.viewTableImport(tblImport, list_nh);
        } catch (ParseException ex) {
            Logger.getLogger(receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblReceiptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReceiptMouseClicked
        if (evt.getClickCount() == 2) {
            selectRow_hd = tblReceipt.getSelectedRow();
            if (selectRow_hd >= 0 && selectRow_hd < list_hd.size()) {
                receptDTO hd = list_hd.get(selectRow_hd);
                viewInformation_HD(hd);
            } else {
                System.out.println("Invalid row index.");
            }
        }
    }//GEN-LAST:event_tblReceiptMouseClicked

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
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateEndImport;
    private com.toedter.calendar.JDateChooser DateEndReceipt;
    private com.toedter.calendar.JDateChooser DateStartImport;
    private com.toedter.calendar.JDateChooser DateStartReceipt;
    private javax.swing.JButton btnAcceptImport;
    private javax.swing.JButton btnAcceptImportPrice;
    private javax.swing.JButton btnAcceptMethodNH;
    private javax.swing.JButton btnAcceptReceipt;
    private javax.swing.JButton btnAcceptReceiptPrice;
    private javax.swing.JButton btnacceptMethodHD;
    private Model.Combobox cbMethodImport;
    private Model.Combobox cbMethodReceipt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblImport;
    private javax.swing.JTable tblReceipt;
    private javax.swing.JLabel txtDateEndImport;
    private javax.swing.JLabel txtDateEndReceipt;
    private javax.swing.JLabel txtDateStartImport;
    private javax.swing.JLabel txtDateStartReceipt;
    private javax.swing.JLabel txtPriceImportFrom;
    private javax.swing.JTextField txtPriceImportFrom_src;
    private javax.swing.JLabel txtPriceImportTo;
    private javax.swing.JTextField txtPriceImportTo_src;
    private javax.swing.JLabel txtPriceReceiptFrom;
    private javax.swing.JTextField txtPriceReceiptFrom_src;
    private javax.swing.JLabel txtPriceReceiptTo;
    private javax.swing.JTextField txtPriceReceiptTo_src;
    private javax.swing.JTextField txtSearchImport;
    private javax.swing.JLabel txtSearchImport_label;
    private javax.swing.JTextField txtSearchReceipt;
    private javax.swing.JLabel txtSearchReceipt_label;
    // End of variables declaration//GEN-END:variables
}
