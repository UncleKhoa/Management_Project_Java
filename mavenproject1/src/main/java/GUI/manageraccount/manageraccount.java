/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.manageraccount;

import BUS.userBUS;
import DTO.userDTO;
import DAO.DBConnect;
import DAO.userDAO;
import DTO.productDTO;
import GUI.managerproduct.addproduct;
import GUI.managerproduct.managerproduct;
import Model.CustomHeaderRenderer;
import Model.NonEditableTableModel;
import static Model.helpers.convertBackgroundOfTable;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Container;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.text.NumberFormat;
import java.awt.Image;
import javax.swing.table.TableColumnModel;
import java.text.DecimalFormat;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Writer;
import java.sql.SQLException;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import GUI.manageraccount.adduser;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class manageraccount extends javax.swing.JFrame {

    private userBUS stbus = new userBUS();
    private DefaultTableModel model;
    private int selectedRowIndex = -1;

    private void selectRowById(String searchId) {
        boolean found = false;

        for (int row = 0; row < table.getRowCount(); row++) {
            String id = table.getValueAt(row, 0).toString();
            if (id.equals(searchId)) {
                table.setRowSelectionInterval(row, row);
                table.scrollRectToVisible(table.getCellRect(row, 0, true));
                selectedRowIndex = row;
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "Không tồn tại ID trong bảng.");
        }
    }

    static public void Export_Excell(JTable jTable1) {
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                //FileWriter out = new FileWriter(file+".xlsx");
                FileOutputStream out = new FileOutputStream(file + ".xls");
                Writer writer = new java.io.OutputStreamWriter((out), "utf8");
                try (BufferedWriter bwrite = new BufferedWriter(writer)) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                    // ten Cot
                    for (int j = 0; j < jTable1.getColumnCount(); j++) {
                        bwrite.write(model.getColumnName(j) + "\t");
                    }
                    bwrite.write("\n");

                    // Lay du lieu dong
                    for (int j = 0; j < jTable1.getRowCount(); j++) {
                        for (int k = 0; k < jTable1.getColumnCount(); k++) {
                            bwrite.write(model.getValueAt(j, k) + "\t");
                        }
                        bwrite.write("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
                System.out.println(e2);
            }
        }
    }

    class CenterTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setHorizontalAlignment(CENTER); // Căn giữa nội dung của ô
            return cellComponent;
        }
    }

    public void style() {
        table.setRowHeight(40);
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new CustomHeaderRenderer());
        convertBackgroundOfTable(table);
        String[] headers = {"StaffID", "Username", "Passwork", "Gmail", "Enable"};

        model = new NonEditableTableModel(new Object[0][headers.length], headers);

        table.setModel(model);

        table.getColumnModel().getColumn(0).setPreferredWidth(90);
        table.getColumnModel().getColumn(1).setPreferredWidth(90);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        TableCellRenderer centerRenderer = new manageraccount.CenterTableCellRenderer();
        table.setDefaultRenderer(Object.class, centerRenderer);

    }

    public manageraccount() {

        JScrollPane scrollPane = new JScrollPane(table);
        initComponents();

        cbb.addItem("unlock");
        cbb.addItem("locked");

        jTextField1.setEditable(false);
//         table.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        model = new DefaultTableModel();
        model.addColumn("StaffID");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Gmail");
        model.addColumn("Enable");
        model.addColumn("action");

        style();
        getContentPane().add(scrollPane);
        displayData();

        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Export_Excell(table);
            }
        });

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    selectedRowIndex = table.getSelectedRow();
                    if (selectedRowIndex >= 0) {
                        // Lấy dữ liệu từ JTable và hiển thị lên các JTextField tương ứng
                        jTextField1.setText(table.getValueAt(selectedRowIndex, 0).toString());
                        jTextField2.setText(table.getValueAt(selectedRowIndex, 1).toString());
                        jTextField3.setText(table.getValueAt(selectedRowIndex, 3).toString());
                        jTextField4.setText(table.getValueAt(selectedRowIndex, 2).toString());
                        jComboBox1.setSelectedItem(table.getValueAt(selectedRowIndex, 4).toString());
                    }
                }
            }
        });

        buttonxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonsua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        timkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchId = jTextField6.getText();
                selectRowById(searchId);
            }
        });

        hienthi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytable();
            }
        });
    }

    @SuppressWarnings("unchecked")

    private void displaytable() {
        String searchName = jTextField6.getText();
        DefaultTableModel newTableModel = new DefaultTableModel();
        // Lọc các dòng có tên trùng nhau và thêm vào bảng sao (newTableModel)
        ArrayList<userDTO> list = stbus.getlist();
        System.out.print(list);
        // Lọc các đối tượng có tên trùng nhau và thêm vào bảng sao (newTableModel)
        for (userDTO staff : list) {
            String name = staff.getUsername();
            if (name.equalsIgnoreCase(searchName)) {
                newTableModel.addRow(new Object[]{staff.getStaffID(),
                    staff.getUsername(),
                    staff.getPassword(),
                    staff.getGmail(),
                    staff.getEnable(),});
            }
        }
        // Kiểm tra nếu bảng sao không có dữ liệu
        if (newTableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Không có dữ liệu phù hợp", "Bảng Sao", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        // ...
        JTable newTable = new JTable(newTableModel);

        JScrollPane scrollPane = new JScrollPane(newTable);

        JFrame frame = new JFrame("Bảng Sao");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(scrollPane);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        them = new javax.swing.JButton();
        buttonxoa = new javax.swing.JButton();
        buttonsua = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        timkiem = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        hienthi = new javax.swing.JButton();
        cbb = new Model.Combobox();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        export = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setPreferredSize(new java.awt.Dimension(950, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Mã");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Tên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Gmail");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Mật khẩu");

        jTextField4.setPreferredSize(new java.awt.Dimension(64, 28));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Enable");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("MANAGER ACCOUNT");

        them.setBackground(new java.awt.Color(172, 202, 231));
        them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        them.setText("THÊM");
        them.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });

        buttonxoa.setBackground(new java.awt.Color(190, 100, 115));
        buttonxoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonxoa.setText("XÓA");
        buttonxoa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        buttonxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonxoaActionPerformed(evt);
            }
        });

        buttonsua.setBackground(new java.awt.Color(102, 151, 102));
        buttonsua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonsua.setText("SỬA");
        buttonsua.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        buttonsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonsuaActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "unlock", "locked" }));

        timkiem.setBackground(new java.awt.Color(213, 167, 213));
        timkiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        timkiem.setText("TÌM KIẾM");
        timkiem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("ID");

        hienthi.setText("hien thi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(hienthi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(them, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(buttonxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                        .addComponent(buttonsua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9)))))
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(cbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(them)
                    .addComponent(buttonxoa)
                    .addComponent(buttonsua))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(timkiem))
                .addGap(39, 39, 39)
                .addComponent(cbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(jLabel10)
                .addGap(100, 100, 100)
                .addComponent(hienthi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "StaffID", "Username", "Password", "Gmail", "Enable"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setPreferredSize(new java.awt.Dimension(950, 650));
        table.setRowHeight(40);
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );

        export.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        export.setText("export");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(export, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(627, Short.MAX_VALUE)
                .addComponent(export, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exportActionPerformed

    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed
        // TODO add your handling code here:

        try {
            adduser guiuser = new adduser();
//                   

            guiuser.setManager(this);
            JDialog dialog = new JDialog();
            dialog.setUndecorated(true);
            dialog.setContentPane(guiuser);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);

            // Đặt sự kiện cho nút "Đóng" trên Productdetail
            guiuser.getDong().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose(); // Đóng cửa sổ dialog
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(manageraccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_themActionPerformed

    private void buttonxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonxoaActionPerformed
        // TODO add your handling code here:
        if (selectedRowIndex >= 0) {
            // Xóa hàng khỏi JTable
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.removeRow(selectedRowIndex);
            try {
                String staffid = jTextField1.getText();

                // Xóa thông tin trong danh sách dữ liệu
                // Ví dụ: stbus là đối tượng của lớp chứa danh sách dữ liệu
                //            stbus.deleteBus(selectedRowIndex);
                // Xóa nội dung trong các JTextField
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField6.setText("");

                // Reset selectedRowIndex
                selectedRowIndex = -1;

                stbus.delete(staffid);

            } catch (SQLException ex) {
                ex.printStackTrace(); // Hoặc xử lý ngoại lệ theo nhu cầu của bạn
            }
        }
    }//GEN-LAST:event_buttonxoaActionPerformed

    private void buttonsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonsuaActionPerformed
        // TODO add your handling code here:
        if (selectedRowIndex >= 0) {
            try {
                // Lấy thông tin từ các JTextField
                String staffid = jTextField1.getText();
                String username = jTextField2.getText();
                String password = jTextField4.getText();
                String email = jTextField3.getText();
                String enable = jComboBox1.getSelectedItem().toString();

                table.setValueAt(staffid, selectedRowIndex, 0);
                table.setValueAt(username, selectedRowIndex, 1);
                table.setValueAt(password, selectedRowIndex, 2);
                table.setValueAt(email, selectedRowIndex, 3);
                table.setValueAt(enable, selectedRowIndex, 4);

                // Cập nhật thông tin trong danh sách dữ liệu
                userDTO staff = new userDTO(staffid, username, password, email, enable);
                stbus.update(staff);

                // Xóa nội dung trong các JTextField
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField6.setText("");

                // Reset selectedRowIndex
                selectedRowIndex = -1;
            } catch (SQLException ex) {
                ex.printStackTrace(); // Hoặc xử lý ngoại lệ theo nhu cầu của bạn
            }
        }
    }//GEN-LAST:event_buttonsuaActionPerformed

    private void displayData() {
        ArrayList<userDTO> list = stbus.getlist();

        for (userDTO staff : list) {
            Object[] rowData = {
                staff.getStaffID(),
                staff.getUsername(),
                staff.getPassword(),
                staff.getGmail(),
                staff.getEnable(),};
            model.addRow(rowData);
        }

        table.setModel(model);
        if (selectedRowIndex != -1 && selectedRowIndex < table.getRowCount()) {
            table.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
            table.scrollRectToVisible(table.getCellRect(selectedRowIndex, 0, true));
        }
    }

    public void addtodisplayData(userDTO staff) {

        Object[] rowData = {
            staff.getStaffID(),
            staff.getUsername(),
            staff.getPassword(),
            staff.getGmail(),
            staff.getEnable(),};
        model.addRow(rowData);
        table.setModel(model);

    }

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                manageraccount manager = new manageraccount();
                manager.setVisible(true);
                manager.setLocationRelativeTo(null);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonsua;
    private javax.swing.JButton buttonxoa;
    private Model.Combobox cbb;
    private javax.swing.JButton export;
    private javax.swing.JButton hienthi;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable table;
    private javax.swing.JButton them;
    private javax.swing.JButton timkiem;
    // End of variables declaration//GEN-END:variables
}
