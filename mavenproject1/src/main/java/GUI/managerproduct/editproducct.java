/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.managerproduct;
import BUS.productBUS;
import DTO.productDTO;
import GUI.manageraccount.kt;
import Model.MyMessageAccept;
import Model.MyMessageAlert;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author ADMIN
 */
public class editproducct extends javax.swing.JPanel {
private String producctID;
private String brandID;
private String productName;
private double unitPrice;
private String IMG;
private String imageName;
private int quantity;
private managerproduct manager;
productBUS editBUS= new productBUS();
 JFrame parentFrame;
 private String id;

    /**
     * private mân
     * Creates new form editproducct
     */
    public editproducct() {
        initComponents();
        combobox();
        jt1.setEditable(false);
        parentFrame = new JFrame();
    JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) jSpinner1.getEditor();
        editor.getTextField().setEditable(false);
        Component[] components = jSpinner1.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.setEnabled(false);
    }
        }
    }
    public void combobox() {
        ArrayList<productDTO> list = editBUS.getList();

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(); // Tạo một mô hình cho JComboBox
        Set<String> brandSet = new HashSet<>(); // Sử dụng Set để lưu trữ các giá trị brandid duy nhất

        for (productDTO product : list) {
            String brandID = product.getBrandID();
            brandSet.add(brandID); // Thêm brandid vào Set
        }

        for (String brandID : brandSet) {
            comboBoxModel.addElement(brandID); // Thêm từng giá trị brandid vào mô hình
        }

        jComboBox1.setModel(comboBoxModel); // Gán mô hình cho JComboBox
        jComboBox1.setBackground(Color.WHITE);
    }
    
     public void setManager(managerproduct manager) {
        this.manager = manager;
    }
    public JButton getDong() {
        return dong;
    }

public void getinfomationproduct(productDTO pr) {
    this.producctID = pr.getProducctID();
    this.brandID = pr.getBrandID();
    this.productName = pr.getProductName();
    this.unitPrice = pr.getUnitPrice();
    this.IMG = pr.getIMG();
    this.quantity = pr.getQuantity();

    jt1.setText(this.producctID);
    jComboBox1.setSelectedItem(this.brandID);
    jt2.setText(this.productName);
    DecimalFormat df = new DecimalFormat("#,###.##");
    jt3.setText(df.format(this.unitPrice));
    jSpinner1.setValue(this.quantity);
//    System.out.print(this.unitPrice);

    ImageIcon icon = new ImageIcon(this.IMG);
    Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    won.setIcon(new ImageIcon(image));
   
    imageName = new File(icon.toString()).getName();
   
       // Cập nhật dòng tương ứng trong JTable1 của ManagementGUI
    
       
}
   public void openguieditdetail(){
                   editdetai edt = new editdetai(id);
                   edt.setjTextField1(id);

                   JDialog dialog = new JDialog();
                   dialog.setUndecorated(true);
                   dialog.setContentPane(edt);
                   dialog.pack();
                   dialog.setLocationRelativeTo(null);
                   dialog.setVisible(true);
    
            
            // Đặt sự kiện cho nút "Đóng" trên Productdetail
            edt.getDong().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose(); // Đóng cửa sổ dialog
                }
            });
   }
 
    public static void main(String[] args) {
        // Khởi tạo và hiển thị giao diện editproduct
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Tạo mới đối tượng editproducct
        editproducct editPanel = new editproducct();

        // Tạo mới JFrame và đặt editproducct vào đó
        JFrame frame = new JFrame("Edit Product");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(editPanel, BorderLayout.CENTER);

        // Đặt kích thước và vị trí của JFrame
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // Canh giữa màn hình

        // Hiển thị JFrame
        frame.setVisible(true);
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
        jLabel3 = new javax.swing.JLabel();
        jt1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jt2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jt3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        won = new javax.swing.JLabel();
        choose = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        dong = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(756, 538));

        jPanel2.setBackground(new java.awt.Color(66, 100, 220));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("ID sản phẩm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Hãng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Tên");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setText("Giá");

        jt3.setPreferredSize(new java.awt.Dimension(64, 28));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Số lượng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Ảnh");

        choose.setBackground(new java.awt.Color(102, 255, 51));
        choose.setText("Chọn ảnh");
        choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseActionPerformed(evt);
            }
        });

        edit.setBackground(new java.awt.Color(136, 48, 78));
        edit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setText("Sửa");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        dong.setBackground(new java.awt.Color(41, 67, 92));
        dong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dong.setForeground(new java.awt.Color(255, 255, 255));
        dong.setText("Đóng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jt2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(24, 24, 24)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jt1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(118, 118, 118)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(choose)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jt3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(dong, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(won, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jt1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jt2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(choose)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(won, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
     id = jt1.getText();
     kt ktt =new kt();
    String brandID = (String) jComboBox1.getSelectedItem();
    String name = jt2.getText();
     String price1 = jt3.getText();
    String prices = jt3.getText().replace(",", "");
   
    int quantity = (int) jSpinner1.getValue();
    int selectedRow = manager.getjTable1().getSelectedRow();
    
    
    
    if (jt1.getText().isEmpty() || jt2.getText().isEmpty() || jt3.getText().isEmpty()) {
        MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng nhập đủ thông tin");
        alert.setVisible(true);
        return;
    }

 
     if (ktt.kiemtragia(prices)) {
        MyMessageAlert alert = new MyMessageAlert(parentFrame, "Nhập giá không hợp lệ");
        alert.setVisible(true);
        return;
    }
    
    if (selectedRow != -1) {
         NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(2);
        formatter.setGroupingUsed(true);
        String formattedPrice = formatter.format(Double.parseDouble(prices));
        manager.getjTable1().setValueAt(id, selectedRow, 0); // Cột 0 là ProductID
        manager.getjTable1().setValueAt(brandID, selectedRow, 1); // Cột 1 là BrandID
        manager.getjTable1().setValueAt(name, selectedRow, 2); // Cột 2 là ProductName
        manager.getjTable1().setValueAt(formattedPrice, selectedRow, 3); // Cột 3 là UnitPrice
        manager.getjTable1().setValueAt(quantity, selectedRow, 4); // Cột 4 là Quantity
        ImageIcon icon = (ImageIcon) won.getIcon(); 
         manager.getjTable1().setValueAt(icon, selectedRow, 5);
         
        
       
        double price = Double.parseDouble(prices);
        productDTO pr = new productDTO(id, brandID, name, price, quantity, imageName);
        System.out.print(imageName);
        try {
            editBUS.update(pr);           
        } catch (SQLException ex) {
            Logger.getLogger(editproducct.class.getName()).log(Level.SEVERE, null, ex);         
        }
    }
    int result = JOptionPane.showConfirmDialog(
    null,
    "Bạn có muốn thêm chi tiết không?",
    "Thông báo",
    JOptionPane.OK_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE
);  
    if (result == JOptionPane.OK_OPTION) {
        SwingUtilities.getWindowAncestor(editproducct.this).dispose();
    openguieditdetail();
}else {
        MyMessageAccept accept = new MyMessageAccept(parentFrame, "Cập nhật thành công");
        accept.setVisible(true);
        SwingUtilities.getWindowAncestor(editproducct.this).dispose();
    }
    }//GEN-LAST:event_editActionPerformed

    private void chooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseActionPerformed
        // TODO add your handling code here:
          // Create a file chooser dialog
        JFileChooser fileChooser = new JFileChooser();
        
        // Show the dialog and get the result
        int result = fileChooser.showOpenDialog(this);
        
        // Check if a file is selected
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            java.io.File selectedFile = fileChooser.getSelectedFile();
            
            // Set the selected file path to the 'won' JLabel
            won.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));
            String selectedImagePath = selectedFile.getAbsolutePath();
            String selectedImageName = selectedFile.getName(); // Lấy tên của ảnh được chọn
            imageName = selectedImageName;
        }
    }//GEN-LAST:event_chooseActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton choose;
    private javax.swing.JButton dong;
    private javax.swing.JButton edit;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jt1;
    private javax.swing.JTextField jt2;
    private javax.swing.JTextField jt3;
    private javax.swing.JLabel won;
    // End of variables declaration//GEN-END:variables
}
