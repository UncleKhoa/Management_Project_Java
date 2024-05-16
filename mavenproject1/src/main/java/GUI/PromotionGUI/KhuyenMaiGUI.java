/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.PromotionGUI;

import BUS.promotionBUS;
import BUS.staffBUS;
import DTO.promotionDTO;
import DTO.staffDTO;
import Model.CustomHeaderRenderer;
import Model.Reload_Event;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import static Model.helpers.*;
import java.awt.Font;
import java.util.Date;
import Model.MyMessageAlert;
import javax.swing.JFrame;
import Model.CustomConfirmDialog;
import GUI.PromotionGUI.XemChiTietKMGUI;
import Model.NonEditableTableModel;
import javax.swing.JTable;

/**
 *
 * @author Bon Nguyen
 */
public class KhuyenMaiGUI extends javax.swing.JPanel {

    Font font = new Font("Segoe UI", Font.PLAIN, 14);
    JFrame parentFrame;
    private ArrayList<promotionDTO> list = new ArrayList<>();
    private ArrayList<promotionDTO> list_search = new ArrayList<>();
    DefaultTableModel model;
    DefaultTableModel model_info;
    public promotionDTO promoDTO;
    private static promotionBUS promotionBUS = new promotionBUS();
    Reload_Event event;
    int selectRow;
    String role;

    /**
     * Creates new form Hello
     */
    public KhuyenMaiGUI(String role) {
        initComponents();
        this.role = role;
        parentFrame = new JFrame();
        this.promotionBUS = new promotionBUS();
        list = promotionBUS.getList();
        JTableHeader header = tablePromotion.getTableHeader();
        header.setDefaultRenderer(new CustomHeaderRenderer());
        viewData(tablePromotion, list);
        OnOff_TaoMoi();
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
        btnCreateKM = new Model.MyButton();
        jPanel3 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePromotion = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtPromoID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescribe = new javax.swing.JTextArea();
        ToDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        FromDate = new com.toedter.calendar.JDateChooser();
        Activate = new javax.swing.JButton();
        Activate1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(950, 650));

        jPanel2.setBackground(new java.awt.Color(246, 246, 250));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Chương trình khuyến mãi");

        btnCreateKM.setBackground(new java.awt.Color(51, 204, 0));
        btnCreateKM.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateKM.setText("Tạo khuyến mãi");
        btnCreateKM.setColor(new java.awt.Color(51, 204, 0));
        btnCreateKM.setColorOver(new java.awt.Color(51, 204, 0));
        btnCreateKM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCreateKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreateKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCreateKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtSearch.setPreferredSize(new java.awt.Dimension(350, 35));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tablePromotion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tablePromotion.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePromotion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePromotionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePromotion);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(372, 650));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã khuyến mãi");

        txtPromoID.setEnabled(false);
        txtPromoID.setPreferredSize(new java.awt.Dimension(71, 35));
        txtPromoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPromoIDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mô tả");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Đến ngày");

        txtDescribe.setColumns(20);
        txtDescribe.setRows(5);
        jScrollPane3.setViewportView(txtDescribe);

        ToDate.setDateFormatString("y-MM-dd");
        ToDate.setPreferredSize(new java.awt.Dimension(71, 35));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Từ ngày");

        FromDate.setDateFormatString("y-MM-dd");
        FromDate.setPreferredSize(new java.awt.Dimension(71, 35));

        Activate.setBackground(new java.awt.Color(255, 0, 0));
        Activate.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Activate.setForeground(new java.awt.Color(255, 255, 255));
        Activate.setText("Active/ Inactive");
        Activate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivateActionPerformed(evt);
            }
        });

        Activate1.setBackground(new java.awt.Color(51, 204, 0));
        Activate1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Activate1.setForeground(new java.awt.Color(255, 255, 255));
        Activate1.setText("Xem chi tiết");
        Activate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Activate1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPromoID, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(FromDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ToDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Activate1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Activate)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(txtPromoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel6))
                    .addComponent(FromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addComponent(ToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Activate1)
                    .addComponent(Activate))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
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
    }// </editor-fold>//GEN-END:initComponents

    public void addLineData(promotionDTO promo) {
        model.addRow(new Object[]{
            promo.getPromotionID(), promo.getDescription(), Date_String(promo.getFrom()), Date_String(promo.getTo()), String.format("%.1f", promo.getPromotionPercent() * 100) + " %", promo.getStatus()
        });
    }

    public void viewData(JTable tablePromotion, ArrayList<promotionDTO> list) {

        convertBackgroundOfTable(tablePromotion);

        String[] headers = {"MÃ CODE", "MÔ TẢ", "TỪ NGÀY", "ĐẾN NGÀY", "PHẦN TRĂM", "TRẠNG THÁI"}; // Đặt tiêu đề cột của bảng
        model = new NonEditableTableModel(new Object[0][headers.length], headers);

        tablePromotion.setModel(model);

        tablePromotion.getColumnModel().getColumn(0).setPreferredWidth(70);
        tablePromotion.getColumnModel().getColumn(1).setPreferredWidth(110);
        tablePromotion.getColumnModel().getColumn(2).setPreferredWidth(90);
        tablePromotion.getColumnModel().getColumn(3).setPreferredWidth(90);
        tablePromotion.getColumnModel().getColumn(4).setPreferredWidth(90);
        tablePromotion.getColumnModel().getColumn(5).setPreferredWidth(98);
        tablePromotion.setRowHeight(30);
        tablePromotion.setFont(font);
        removeData();
        for (promotionDTO promo : list) {
            addLineData(promo);
        }
    }

    public void removeData() {
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    public void OnOff_TaoMoi() {
        if (role.equals("staff")) {
            btnCreateKM.setVisible(false);
        }
    }

    public void viewInformation(promotionDTO promo) throws ParseException {
        this.promoDTO = promo;
        Date from = promo.getFrom();
        Date to = promo.getTo();
        FromDate.setDate(from);
        ToDate.setDate(to);
        txtDescribe.setText(promo.getDescription());
        txtPromoID.setText(promo.getPromotionID());
    }

    public void Load_Event(boolean a) {
        if (a) {
            viewData(tablePromotion, list);
        }
    }

    private void btnCreateKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateKMActionPerformed
        TaoKhuyenMai new_promo = new TaoKhuyenMai(role);
        new_promo.addReloadEvent(new Reload_Event() {
            @Override
            public void load() {
                list = promotionBUS.getList();
                viewData(tablePromotion, list);
            }
        }
        );
        new_promo.setVisible(true);
    }//GEN-LAST:event_btnCreateKMActionPerformed

    private void tablePromotionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePromotionMouseClicked
        try {
            selectRow = tablePromotion.getSelectedRow();
            viewInformation(list.get(selectRow));
        } catch (ParseException ex) {
            Logger.getLogger(KhuyenMaiGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tablePromotionMouseClicked

    private void txtPromoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPromoIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPromoIDActionPerformed

    private void ActivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivateActionPerformed
        String id = txtPromoID.getText();
        promotionBUS promotionBUS = new promotionBUS();
        if (id.equals("")) {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng chọn 1 mã");
            alert.setVisible(true);
        } else {
            promotionDTO promo = list.get(selectRow);
            if (promo.getPromotionID().equals("NORMAL")) {
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Không thể sửa trạng thái mã mặc định");
                alert.setVisible(true);
                return;
            } else {
                String act, act_VN;
                if (promo.getStatus().equals("active")) {
                    act = "inactive";
                    act_VN = "ngừng kích hoạt";
                } else {
                    act = "active";
                    act_VN = "kích hoạt";
                }

                CustomConfirmDialog confirm = new CustomConfirmDialog(parentFrame, "Xác nhận", "Bạn có muốn " + act_VN + " mã này?", "question.png");
                confirm.setVisible(true);

                if (confirm.getSelected()) {
                    promotionBUS.Up_Active(id, act);
                    list = promotionBUS.getList();
                    viewData(tablePromotion, list);
                }
            }

        }
    }//GEN-LAST:event_ActivateActionPerformed

    private void Activate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Activate1ActionPerformed
        String id = txtPromoID.getText();
        list.get(selectRow);
        if (id.equals("")) {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng chọn 1 mã cần xem");
            alert.setVisible(true);
        } else {
            XemChiTietKMGUI xem = new XemChiTietKMGUI(id, promoDTO);
            xem.setVisible(true);
        }
    }//GEN-LAST:event_Activate1ActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (txtSearch.getText().equals("")) {
            viewData(tablePromotion, list);
        } else {
            list_search = promotionBUS.getList_Search(txtSearch.getText());
            viewData(tablePromotion, list_search);
        }
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Activate;
    private javax.swing.JButton Activate1;
    private com.toedter.calendar.JDateChooser FromDate;
    private com.toedter.calendar.JDateChooser ToDate;
    private Model.MyButton btnCreateKM;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablePromotion;
    private javax.swing.JTextArea txtDescribe;
    private javax.swing.JTextField txtPromoID;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
