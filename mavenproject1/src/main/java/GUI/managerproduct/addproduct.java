/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.managerproduct;

import BUS.ProductDetailBUS;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import DTO.productDTO;
import GUI.managerproduct.managerproduct;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JOptionPane;
import BUS.productBUS;
import DTO.productDetailDTO;
import GUI.manageraccount.kt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import GUI.managerproduct.detail;
import Model.MyMessageAccept;
import Model.MyMessageAlert;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author ADMIN
 */
public class addproduct extends javax.swing.JPanel {

    JFrame parentFrame;
    private ProductDetailBUS detailbus = new ProductDetailBUS();
    private productBUS stbus = new productBUS();
    private managerproduct manager;
    private String imagePath;
    File file = new File("");
    String currentDirectory = file.getAbsolutePath();
    String relativePath = currentDirectory + "\\src\\main\\java\\betIMG\\"; // Đường dẫn tương đối

    /**
     * Creates new form addproduct
     *
     */

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setManager(managerproduct manager) {
        this.manager = manager;
    }

    public addproduct() {
        initComponents();
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) jSpinner1.getEditor();
        editor.getTextField().setEditable(false);
        Component[] components = jSpinner1.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.setEnabled(false);
            }
        }
        parentFrame = new JFrame();
        choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseActionPerformed(evt);
            }
        });
    }

    private productDTO createObjectFromInputs() {
        String producid = jTextField1.getText();
        String brandid = jComboBox1.getSelectedItem().toString();
        String productname = jTextField3.getText();
        double unitprice = Double.parseDouble(jTextField4.getText());
        int quantity = Integer.parseInt(jSpinner1.getValue().toString());

        // Tạo đối tượng mới với dữ liệu từ các trường
        productDTO object = new productDTO(producid, brandid, productname, unitprice, quantity, imagePath);

        return object;
    }

    public JButton getDong() {
        return dong;
    }

    private void chooseActionPerformed(java.awt.event.ActionEvent evt) {
        // Create a file chooser dialog
        JFileChooser fileChooser = new JFileChooser();

        // Show the dialog and get the result
        int result = fileChooser.showOpenDialog(this);

        // Check if a file is selected
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            java.io.File selectedFile = fileChooser.getSelectedFile();

            // Set the selected file path to the 'won' JLabel
            won.setIcon(new javax.swing.ImageIcon(selectedFile.getAbsolutePath()));
            String selectedImagePath = selectedFile.getAbsolutePath();
            String selectedImageName = selectedFile.getName(); // Lấy tên của ảnh được chọn
            imagePath = selectedImageName;
        }
    }

    private void jpaneldetail() {
        try {
            // Tạo đối tượng detail
            detail adddetail = new detail();

            // Tạo cửa sổ dialog để hiển thị detail
            JDialog dialog = new JDialog();
            dialog.setUndecorated(true);
            dialog.setContentPane(adddetail);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);

            // Đặt sự kiện cho nút "Đóng" trên Productdetail
//        adddetail.getDong().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dialog.dispose(); // Đóng cửa sổ dialog
//            }
//        });
            // Lấy giá trị từ JTextField trong addproduct
            String textValue = getjTextField1().getText();

            // Đặt giá trị vào JTextField trong detail
            adddetail.setjTextField1(textValue);
        } catch (SQLException ex) {
            Logger.getLogger(addproduct.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        won = new javax.swing.JLabel();
        choose = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        dong = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setPreferredSize(new java.awt.Dimension(756, 538));

        jPanel1.setBackground(new java.awt.Color(66, 100, 220));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Mã sãn phẩm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Hãng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Tên");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setText("Giá");

        jTextField4.setPreferredSize(new java.awt.Dimension(64, 28));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Số lượng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Ảnh");

        choose.setBackground(new java.awt.Color(51, 204, 0));
        choose.setForeground(new java.awt.Color(255, 255, 255));
        choose.setText("chọn ảnh");

        add.setBackground(new java.awt.Color(51, 102, 255));
        add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Thêm");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "ASUS", "Lenovo", "Apple", "Microsoft", "Dell", "HP" }));

        dong.setBackground(new java.awt.Color(255, 0, 51));
        dong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dong.setForeground(new java.awt.Color(255, 255, 255));
        dong.setText("Đóng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(dong, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(choose)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(won, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(choose)))
                        .addGap(18, 18, 18)
                        .addComponent(won, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
//        managerproduct manager = (managerproduct) SwingUtilities.getAncestorOfClass(managerproduct.class, this);

        String kiemtraname = jTextField3.getText();
        String kiemtragia = jTextField4.getText();

        ArrayList<productDTO> list = stbus.getList();
        kt ktt = new kt();

        if (jTextField3.getText().isEmpty() || jTextField4.getText().isEmpty() || jTextField1.getText().isEmpty()) {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng nhập đủ thông tin");
            alert.setVisible(true);
            return;
        }

        if (imagePath == null || imagePath.isEmpty()) {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng chọn ảnh");
            alert.setVisible(true);
            return;
        }

        String idToCheck = jTextField1.getText();
        boolean isIdExist = false;
        for (productDTO product : list) {
            if (product.getProducctID().equals(idToCheck)) {
                isIdExist = true;
                break;
            }
        }

        if (isIdExist) {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "ID đã tồn tại");
            alert.setVisible(true);
            return;
        }

        if (ktt.kiemtraten(kiemtraname)) {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Tên không được chứa số");
            alert.setVisible(true);
            return;
        }

        if (ktt.kiemtragia(kiemtragia)) {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Nhập giá không hợp lệ");
            alert.setVisible(true);
            return;
        }
        if (isIdExist) {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "ID đã tồn tại");
            alert.setVisible(true);
        }
        productDTO sp = createObjectFromInputs();
        manager.addtodisplayData(sp);
        try {
            stbus.add(sp);
            detail adddetail = new detail();
//        adddetail.setclose(this);
        } catch (SQLException ex) {
            Logger.getLogger(addproduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.getWindowAncestor(addproduct.this).dispose();
        jpaneldetail();

    }//GEN-LAST:event_addActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton choose;
    private javax.swing.JButton dong;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel won;
    // End of variables declaration//GEN-END:variables
}
