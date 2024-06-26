/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.managerproduct;

import BUS.customerBUS;
import BUS.productBUS;
import BUS.staffBUS;
import DTO.productDTO;
import DTO.userDTO;
import GUI.SellGUI.sell;
import Model.CustomHeaderRenderer;
import Model.NonEditableTableModel;
import static Model.helpers.convertBackgroundOfTable;
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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableCellRenderer;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import Model.MyMessageAccept;
import Model.MyMessageAlert;
import java.awt.Color;
import GUI.managerproduct.Productdetail;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JDialog;
import GUI.managerproduct.addproduct;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.plaf.basic.BasicSpinnerUI;
import Model.MyScrollBar;
import GUI.managerproduct.editproducct;
import java.awt.BorderLayout;
import BUS.ProductDetailBUS;
import BUS.brandBUS;
import DTO.brandDTO;
import DTO.productDetailDTO;
import GUI.BrandGUI.brandGUI;
import Model.CustomConfirmDialog;
import java.util.logging.Level;
import java.util.logging.Logger;

// Định dạng số
public class managerproduct extends javax.swing.JPanel {
    ArrayList<productDTO> list = new ArrayList<>();
    productDTO pr;
    sell testSell;
    private productBUS stbus = new productBUS();
    private ProductDetailBUS detail = new ProductDetailBUS();
    private DefaultTableModel model;
    private int selectedRowIndex = -1;
    File file = new File("");
    String currentDirectory = file.getAbsolutePath();
    String relativePath = currentDirectory + "\\src\\main\\java\\betIMG\\"; // Đường dẫn tương đối
    JFrame parentFrame;
    private JFrame frame;

    public DefaultTableModel getModel() {
        return model;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void combobox() {
     {
        //ArrayList<productDTO> list = stbus.getList();
        brandBUS bus = new brandBUS();
        ArrayList<brandDTO> list = bus.list();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(); // Tạo một mô hình cho JComboBox
        Set<String> brandSet = new HashSet<>(); // Sử dụng Set để lưu trữ các giá trị brandid duy nhất

      //  for (productDTO product : list) {
          for (brandDTO brand : list) {
           // String brandID = product.getBrandID();
           String brandID = brand.getBrandId();
            brandSet.add(brandID); // Thêm brandid vào Set
        }

        for (String brandID : brandSet) {
            comboBoxModel.addElement(brandID); // Thêm từng giá trị brandid vào mô hình
        }

        jComboBox1.setModel(comboBoxModel); // Gán mô hình cho JComboBox
        jComboBox1.setBackground(Color.WHITE);
    }
    }

   
  private void selectRowById(String searchId) {
    boolean found = false;

    for (int row = 0; row < jTable1.getRowCount(); row++) {
        String id = jTable1.getValueAt(row, 0).toString().trim();
        if (id.equalsIgnoreCase(searchId)) {
            jTable1.setRowSelectionInterval(row, row);
            jTable1.scrollRectToVisible(jTable1.getCellRect(row, 0, true));
            selectedRowIndex = row;
            found = true;
            break;
        }
    }
 

    if (!found) {
        MyMessageAlert alert = new MyMessageAlert(parentFrame, "không tìm thấy id");
        alert.setVisible(true);
        return;
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



    
    public void style() {
        jTable1.setRowHeight(65);
        JTableHeader header = jTable1.getTableHeader();
        header.setDefaultRenderer(new CustomHeaderRenderer());
        convertBackgroundOfTable(jTable1);
        String[] headers = {"Producid", " Brandid", " Productname", " Unitprice", "Quantity", "IMG"};

        model = new NonEditableTableModel(new Object[0][headers.length], headers);

        jTable1.setModel(model);

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(130);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(180);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(18);
        TableCellRenderer centerRenderer = new CenterTableCellRenderer();
        jTable1.setDefaultRenderer(Object.class, centerRenderer);

    }

    public void openguiedit() {

        editproducct edit = new editproducct();
        edit.setManager(this);
        edit.getinfomationproduct(pr);
        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setContentPane(edit);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        edit.getDong().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Đóng cửa sổ dialog
            }
        });
    }

    public managerproduct() {
        JScrollPane scrollPane = new JScrollPane(jTable1);
        initComponents();
        this.stbus = new productBUS();
        list = stbus.getList();
        parentFrame = new JFrame();

        jScrollPane2.setVerticalScrollBar(new MyScrollBar());
        DefaultEditor editor = (DefaultEditor) jSpinner1.getEditor();
        editor.getTextField().setEditable(false);
        jTextField1.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        Component[] components = jSpinner1.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.setEnabled(false);
            }
        }
        combobox();
        style();
        displayData();

        
        
        
        jTable1.addMouseListener(new MouseAdapter(){
    public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedRow = jTable1.getSelectedRow();
                    jTextField1.setText(jTable1.getValueAt(selectedRow, 0).toString());
                    jComboBox1.setSelectedItem(jTable1.getValueAt(selectedRow, 1).toString());
                    jTextField3.setText(jTable1.getValueAt(selectedRow, 2).toString());
                    jTextField4.setText(jTable1.getValueAt(selectedRow, 3).toString());
                    jSpinner1.setValue(jTable1.getValueAt(selectedRow, 4));
                     ImageIcon imageIcon = (ImageIcon) jTable1.getValueAt(selectedRow, jTable1.getColumnCount() - 1);
                        int newWidth = 113;
                        int newHeight = 110;
                        Image currentImage = imageIcon.getImage();
                        Image scaledImage = currentImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                        ImageIcon scaledIcon = new ImageIcon(scaledImage);

                        won.setIcon(scaledIcon);
                }
            }
});
        
        
        
        
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Kiểm tra nếu là sự kiện nhấp chuột hai lần
                    int selectedRowIndex = jTable1.getSelectedRow();
                    String productid = jTable1.getValueAt(selectedRowIndex, 0).toString();

                    Productdetail productDetail = new Productdetail(productid);

                    JDialog dialog = new JDialog();
                    dialog.setUndecorated(true); // Tắt thanh tiêu đề và nút đóng
                    dialog.setContentPane(productDetail);
                    dialog.pack();
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);

                    // Đặt sự kiện cho nút "Đóng" trên Productdetail
                    productDetail.getDong().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dialog.dispose(); // Đóng cửa sổ dialog
                        }
                    });
                }
            }
        });
        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Export_Excell(jTable1);
            }
        });

        editbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowIndex = jTable1.getSelectedRow();

                if (selectedRowIndex >= 0) {
                    // Lấy giá trị từ JTable
                    String value1 = jTable1.getValueAt(selectedRowIndex, 0).toString();
                    String value2 = jTable1.getValueAt(selectedRowIndex, 1).toString();
                    String value3 = jTable1.getValueAt(selectedRowIndex, 2).toString();

                    String value4Str = jTable1.getValueAt(selectedRowIndex, 3).toString().replaceAll(",", "");
                    Double value4 = Double.parseDouble(value4Str);
                    int value5 = Integer.parseInt(jTable1.getValueAt(selectedRowIndex, 4).toString());
                    String imageName = jTable1.getValueAt(selectedRowIndex, 5).toString();
                    System.out.print(imageName);
                    // Hiển thị giao diện editproducct
                    pr = new productDTO(value1, value2, value3, value4, value5, imageName);
                    openguiedit();
                } else if (selectedRowIndex < 0 || pr == null) {
                    MyMessageAlert alert = new MyMessageAlert(parentFrame, "vui lòng chọn hàng muốn sửa");
                    alert.setVisible(true);
                }
            }
        });
}
    
    private void displayData() {
     
               list = stbus.getList();

    for (productDTO sp : list) {
        try {
            double unitPrice = sp.getUnitPrice();
            DecimalFormat decimalFormat = new DecimalFormat("#,##0");
            String formattedUnitPrice = decimalFormat.format(unitPrice);

            File imgFile;
            String imgPath = sp.getIMG();
            if (imgPath.startsWith("\\")) {
                // Đường dẫn ảnh bắt đầu bằng "\", sử dụng đường dẫn tuyệt đối
                imgFile = new File(imgPath);
            } else {
                // Đường dẫn ảnh không bắt đầu bằng "\", sử dụng đường dẫn tương đối
                imgFile = new File(relativePath + imgPath);
            }

            ImageIcon imageIcon = new ImageIcon(imgFile.getAbsolutePath());

            TableCellRenderer renderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    int newWidth = 80;
                    int newHeight = 70;
                    ImageIcon currentIcon = (ImageIcon) value;
                    Image currentImage = currentIcon.getImage();
                    Image scaledImage = currentImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);
                    label.setIcon(scaledIcon);

                    return label;
                    }
                };

                // Thêm các dữ liệu vào model của bảng
                model.addRow(new Object[]{
                    sp.getProducctID(),
                    sp.getBrandID(),
                    sp.getProductName(),
                    formattedUnitPrice,
                    sp.getQuantity(),
                    imageIcon
                });

                // Đặt renderer cho cột hiển thị hình ảnh
                int columnIndex = model.findColumn("IMG"); // Thay "IMG" bằng tên cột hiển thị hình ảnh
                jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(renderer);

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        jTable1.setModel(model);

        if (selectedRowIndex != -1 && selectedRowIndex < jTable1.getRowCount()) {
            jTable1.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
            jTable1.scrollRectToVisible(jTable1.getCellRect(selectedRowIndex, 0, true));
        }
    }

    public void addtodisplayData(productDTO nc) {
         list = stbus.getList();
        boolean idExists = false;

        // Kiểm tra sự tồn tại của id trong list
        for (productDTO product : list) {
            if (product.getProducctID().equals(nc.getProducctID())) {
                idExists = true;
                break;
            }
        }

        if (!idExists) {
            list.add(nc);
            try {
                double unitPrice = nc.getUnitPrice();
                DecimalFormat decimalFormat = new DecimalFormat("#,##0");
                String formattedUnitPrice = decimalFormat.format(unitPrice);

                File imgFile = new File(relativePath + nc.getIMG());
                ImageIcon imageIcon = new ImageIcon(imgFile.getAbsolutePath());

                TableCellRenderer renderer = new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                        int newWidth = 80;
                        int newHeight = 70;
                        ImageIcon currentIcon = (ImageIcon) value;
                        Image currentImage = currentIcon.getImage();
                        Image scaledImage = currentImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                        ImageIcon scaledIcon = new ImageIcon(scaledImage);
                        label.setIcon(scaledIcon);

                        return label;
                    }
                };

                // Thêm các dữ liệu vào model của bảng
                model.addRow(new Object[]{
                    nc.getProducctID(),
                    nc.getBrandID(),
                    nc.getProductName(),
                    formattedUnitPrice,
                    nc.getQuantity(),
                    imageIcon
                });

                // Đặt renderer cho cột hiển thị hình ảnh
                int columnIndex = model.findColumn("IMG"); // Thay "IMG" bằng tên cột hiển thị hình ảnh
                jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(renderer);

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            jTable1.setModel(model);

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

//    private void showProductDetailGUI() {
//    Productdetail productDetailGUI = new Productdetail();
//    productDetailGUI.setVisible(true);
//}
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Manager Product");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo một instance của JPanel Form
        managerproduct panel = new managerproduct();

        // Thêm JPanel Form vào JFrame
        frame.getContentPane().add(panel);

        // Cấu hình kích thước, vị trí và hiển thị JFrame
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        them = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        editbutton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        timkiem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        won = new javax.swing.JLabel();
        combobox = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        export = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Mã");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Hãng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Tên");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Số lượng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("IMG");

        them.setBackground(new java.awt.Color(36, 7, 80));
        them.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        them.setForeground(new java.awt.Color(255, 255, 255));
        them.setText("Thêm");
        them.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(95, 38, 74));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Xóa");
        delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        editbutton.setBackground(new java.awt.Color(24, 61, 61));
        editbutton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editbutton.setForeground(new java.awt.Color(255, 255, 255));
        editbutton.setText("Sửa");
        editbutton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        editbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbuttonActionPerformed(evt);
            }
        });

        timkiem.setBackground(new java.awt.Color(82, 109, 130));
        timkiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        timkiem.setForeground(new java.awt.Color(255, 255, 255));
        timkiem.setText("Tìm kiếm");
        timkiem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiemActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("ID");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setText("Giá");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("BRAND ID");

        combobox.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        combobox.setText("+");
        combobox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboboxMouseClicked(evt);
            }
        });
        combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(100, 58, 107));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Tạo mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(336, 336, 336)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(combobox))
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(them, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(editbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(won, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(203, 203, 203))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel11)))
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)))
                        .addContainerGap(39, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timkiem)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(3, 3, 3)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(editbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(them, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(won, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ProductID", "BrandID", "ProductName", "UnitPrice", "Quantity", "IMG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setMinWidth(1);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        export.setBackground(new java.awt.Color(86, 7, 100));
        export.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        export.setForeground(new java.awt.Color(255, 255, 255));
        export.setText("Export");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(export, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(export, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exportActionPerformed

    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed
        // TODO add 
        addproduct addProductPanel = new addproduct();
        addProductPanel.setManager(this);

        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setContentPane(addProductPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        // Đặt sự kiện cho nút "Đóng" trên Productdetail
        addProductPanel.getDong().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Đóng cửa sổ dialog
            }
        });
    }//GEN-LAST:event_themActionPerformed

    private void comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxActionPerformed

    private void editbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbuttonActionPerformed


    }//GEN-LAST:event_editbuttonActionPerformed

    private void timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiemActionPerformed

    String searchId = jTextField7.getText();
    String searchName = jTextField6.getText();

    ArrayList<productDTO> ketQua = new ArrayList<>();
     if(!searchId.isEmpty()&&!searchName.isEmpty()){
         MyMessageAlert alert = new MyMessageAlert(parentFrame, "vui lòng nhập tìm kiếm phù hợp");
            alert.setVisible(true);
            return;
    }
    if (!searchId.isEmpty()) {
           selectRowById(searchId);
    } else if (!searchName.isEmpty()) {
        ketQua = stbus.SeardByname(searchName);
    }
//    if(ketQua.isEmpty()){
//         MyMessageAlert alert = new MyMessageAlert(parentFrame, "không tìm thấy tên sản phẩm");
//         alert.setVisible(true);
//         return;
//    }
    if (!ketQua.isEmpty()) {
    ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        for (productDTO nc : ketQua) {          
                    try {
                double unitPrice = nc.getUnitPrice();
                DecimalFormat decimalFormat = new DecimalFormat("#,##0");
                String formattedUnitPrice = decimalFormat.format(unitPrice);

                File imgFile = new File(relativePath + nc.getIMG());
                ImageIcon imageIcon = new ImageIcon(imgFile.getAbsolutePath());

                TableCellRenderer renderer = new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                        int newWidth = 80;
                        int newHeight = 70;
                        ImageIcon currentIcon = (ImageIcon) value;
                        Image currentImage = currentIcon.getImage();
                        Image scaledImage = currentImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                        ImageIcon scaledIcon = new ImageIcon(scaledImage);
                        label.setIcon(scaledIcon);
                        return label;
                    }
                };           
                model.addRow(new Object[]{
                    nc.getProducctID(),
                    nc.getBrandID(),
                    nc.getProductName(),
                    formattedUnitPrice,
                    nc.getQuantity(),
                    imageIcon
                });
                int columnIndex = model.findColumn("IMG"); // Thay "IMG" bằng tên cột hiển thị hình ảnh
                jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(renderer);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            jTable1.setModel(model);
        }
        }
    }//GEN-LAST:event_timkiemActionPerformed
    public void xoadetail(String prID) throws SQLException {
    ArrayList<productDetailDTO> list = new ArrayList<>();
    list = detail.getList();
    for (productDetailDTO pr : list) {
        if (pr.getProductID().equalsIgnoreCase(prID)) {
            String delete=pr.getProductID();
            detail.delete(delete);
        }
    }
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//                ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
//
//    SwingUtilities.getWindowAncestor(managerproduct.this).dispose();
//    SwingUtilities.invokeLater(() -> {
//        createAndShowGUI();
//    });
      displayData();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
     

            int selectedRow = jTable1.getSelectedRow();
    if (selectedRow >= 0) {
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa bản ghi này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String productid = (String) jTable1.getValueAt(selectedRow, 0); // Lấy productid từ hàng đã chọn
                stbus.delete(productid); 
                xoadetail(productid);                // Xóa bản ghi khỏi cơ sở dữ liệu           
                model.removeRow(selectedRow);
                selectedRow = -1; 
                jTextField1.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField6.setText("");
            } catch (SQLException ex) {
                ex.printStackTrace(); // Xử lý ngoại lệ SQL
            }
        }
    }
 
    }//GEN-LAST:event_deleteActionPerformed

    private void comboboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboboxMouseClicked
        // TODO add your handling code here:
        brandGUI brand = new brandGUI(this);
        brand.show();
           
    }//GEN-LAST:event_comboboxMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combobox;
    private javax.swing.JButton delete;
    private javax.swing.JButton editbutton;
    private javax.swing.JButton export;
    private javax.swing.JButton jButton1;
    public javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton them;
    private javax.swing.JButton timkiem;
    private javax.swing.JLabel won;
    // End of variables declaration//GEN-END:variables
}
