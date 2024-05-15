/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ImportGUI;

/**
 *
 * @author MY PC
 */
import BUS.importBUS;
import BUS.import_detailBUS;
import BUS.productBUS;
import DTO.importDTO;
import DTO.import_detailDTO;
import DTO.productDTO;
import DTO.supplierDTO;
import DTO.table_receiptDTO;
import GUI.MainGUI;
import Model.CustomHeaderRenderer;
import Model.CustomJasperViewer;
import Model.MyMessageAccept;
import Model.MyMessageAlert;
import Model.NonEditableTableModel;
import Model.helpers;
import static Model.helpers.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
     
public class TaoPhieuNhapGUI extends javax.swing.JPanel {

    /**
     * Creates new form TaoPhieuNhapGUI
     */
       File file = new File("");
       DefaultTableModel model;
        DefaultTableModel model1;
       JFrame parentFrame;
        private int sl =1;
        String currentDirectory = file.getAbsolutePath();
        String relativePath = currentDirectory + "\\src\\main\\java\\IMG\\";
        String pdfpath = currentDirectory + "\\src\\main\\java\\pdf\\";
        private LocalDate today;
        private String formattedDate;
        private DateTimeFormatter formatter;
        productBUS productBUS;
        private int tt;
        ArrayList<productDTO> listproduct;
        MainGUI main;
        private String id;
        boolean off;
        productBUS product;
     private ArrayList<table_receiptDTO> datalist;
  private ImageIcon scaleImage(String filename, int width, int height) {
        try {
            BufferedImage img = ImageIO.read(new File(relativePath + filename));
            Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public TaoPhieuNhapGUI(MainGUI mainGUI) {
        initComponents();
        JTableHeader header = tblSp.getTableHeader();
        header.setDefaultRenderer(new CustomHeaderRenderer());
         JTableHeader header1 = tblPn.getTableHeader();
        header1.setDefaultRenderer(new CustomHeaderRenderer());
     ImageIcon lich= scaleImage("calendar-48.png", 40, 40);
      this.lbLich.setIcon(lich);
      ImageIcon ncc = scaleImage("user-48.png", 30, 30);
      this.lbNcc.setIcon(ncc);
      ImageIcon nv = scaleImage("staff-48.png", 40, 40);
      this.lbNv.setIcon(nv);
      this.btnThanhtoan.setVisible(false);
      this.lbtong.setVisible(false);
      this.lbTongtien.setVisible(false);
      today = LocalDate.now();
      formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      formattedDate = today.format(formatter);
      main = mainGUI;
      String id = main.id;
      String name = main.name;
      this.lbManv.setText(id);
      this.lbTennv.setText(name);
       this.productBUS= new productBUS();
       listproduct = productBUS.getList();
       ViewData(listproduct);
        lbNgay.setText(formattedDate);
         convertBackgroundOfTable(tblPn);
          String[] headers= {"Mã sản phẩm ","Hãng","Tên sản phẩm","Số lượng","Giá"};
         model1 = new NonEditableTableModel(new Object[0][headers.length], headers);
         tblPn.setModel(model1);
          model1.setColumnIdentifiers(headers);
    }
      public void ViewData(ArrayList<productDTO> list)
    {
        convertBackgroundOfTable(tblSp);
        String[] header = {"Mã sản phẩm ","Hãng","Tên sản phẩm","Giá"};
      
        model = new NonEditableTableModel(new Object[0][header.length], header);
       
        tblSp.setModel(model);
      
        model.setColumnIdentifiers(header); 
       
        tblSp.getColumnModel().getColumn(0).setPreferredWidth(70);
        tblSp.getColumnModel().getColumn(1).setPreferredWidth(90);
        tblSp.getColumnModel().getColumn(2).setPreferredWidth(110);
        tblSp.getColumnModel().getColumn(3).setPreferredWidth(90);
        removeData();
        
        for(productDTO product:list)
        {
             addData(product);
            
        }
       
    }
  public void addData(productDTO product)
    {
        model.addRow(new Object[]{
            product.getProducctID(), product.getBrandID(),product.getProductName(),ConvertDoubleToInt(product.getUnitPrice()*(1-0.4))
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
        jPanel2 = new javax.swing.JPanel();
        lbTenncc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbMancc = new javax.swing.JLabel();
        lbChonncc = new javax.swing.JLabel();
        lbNcc = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbTennv = new javax.swing.JLabel();
        lbManv = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbNv = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbNgay = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbLich = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPn = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSp = new javax.swing.JTable();
        lbsl = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        btnThanhtoan = new javax.swing.JButton();
        lbtong = new javax.swing.JLabel();
        lbTongtien = new javax.swing.JLabel();
        txtSp = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        btnXacnhan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        lbs = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(950, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(950, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Nhà cung cấp");

        lbChonncc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbChonncc.setForeground(new java.awt.Color(122, 178, 178));
        lbChonncc.setText("Chọn nhà cung cấp");
        lbChonncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbChonnccMouseClicked(evt);
            }
        });

        lbNcc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbMancc, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTenncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(lbChonncc)
                .addGap(94, 94, 94))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMancc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTenncc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbChonncc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 9, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        lbTennv.setText("jLabel1");

        lbManv.setText("jLabel1");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Nhân viên");

        lbNv.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbNv, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTennv, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbManv, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbManv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbNv, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTennv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 6, -1, 117));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("cyberForce122@gmail.com");

        lbNgay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel11.setText("CyberForce");

        lbLich.setBackground(new java.awt.Color(51, 51, 51));
        lbLich.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbLich, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbLich, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        tblPn.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPn.setRowHeight(30);
        tblPn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPn);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 193, 439, 389));

        tblSp.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSp.setRowHeight(30);
        tblSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSpMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSp);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 193, 460, 389));

        lbsl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbsl.setText("Danh sách sản phẩm");
        jPanel1.add(lbsl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 145, 170, 25));

        btnSua.setBackground(new java.awt.Color(93, 14, 65));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.setPreferredSize(new java.awt.Dimension(78, 23));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 142, 90, 33));

        btnThanhtoan.setBackground(new java.awt.Color(128, 61, 59));
        btnThanhtoan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThanhtoan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhtoan.setText("Thanh toán");
        btnThanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhtoanActionPerformed(evt);
            }
        });
        jPanel1.add(btnThanhtoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 590, 100, 33));

        lbtong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbtong.setText("Tổng:");
        jPanel1.add(lbtong, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 593, -1, -1));

        lbTongtien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(lbTongtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 590, 120, 30));
        jPanel1.add(txtSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 142, 144, 33));

        btnXoa.setBackground(new java.awt.Color(0, 34, 77));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 142, 90, 33));

        btnXacnhan.setBackground(new java.awt.Color(0, 60, 67));
        btnXacnhan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXacnhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacnhan.setText("Xác nhận");
        btnXacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacnhanActionPerformed(evt);
            }
        });
        jPanel1.add(btnXacnhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 590, 90, 33));

        btnHuy.setBackground(new java.awt.Color(108, 3, 69));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel1.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 590, 90, 33));

        btnLammoi.setBackground(new java.awt.Color(73, 36, 62));
        btnLammoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLammoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLammoi.setText("Làm mới");
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });
        jPanel1.add(btnLammoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 590, 90, 33));

        lbs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbs.setText("Số lượng");
        jPanel1.add(lbs, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 145, 72, 25));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
            if (this.tblPn.getRowCount() == 0) {
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng chọn sản phẩm ");
                alert.setVisible(true);
                return;
         }
        if (txtSp.getText().trim().isEmpty()) {
            // alert.setVisible(true);
            MyMessageAlert alert1 = new MyMessageAlert(parentFrame, "Vui lòng chọn sản phẩm cần sửa");
            alert1.setVisible(true);
        } else {

            int row = this.tblPn.getSelectedRow();
            Object ID = model.getValueAt(row, 0);
            String id = ID.toString();
            int sl = Integer.valueOf(txtSp.getText());
            if (sl == 0) {
                MyMessageAlert alert2 = new MyMessageAlert(parentFrame, "Số lượng cần sửa lớn hơn 0");
                alert2.setVisible(true);
            } else {
//                productBUS product = new productBUS();
//                try {
//                    if (product.compareQuantity(id, sl) == 0) {
//                        MyMessageAlert alert = new MyMessageAlert(parentFrame, "Số lượng sản phẩm " + id + " không đủ");
//                        alert.setVisible(true);
//                    } else {
                        model1.setValueAt(sl, row, 3);
                        if(this.tblPn.getRowCount()==0)
                        { this.txtSp.setText("");}
//                    }

//                } catch (SQLException ex) {
//                    Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
//                }

            }

        }
       // btnThanhtoan.hide();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhtoanActionPerformed
        // TODO add your handling code here:
        //       this.btnThanhtoan.hide();
        //  this.btnXuathd.show();
        this.btnLammoi.setVisible(true);
        this.btnHuy.setVisible(false);
        importBUS iBus = new importBUS();
        id = iBus.createId();
        String supid = this.lbMancc.getText();
        String staffid = this.lbManv.getText();
        double total = tt;
        Date create_day = java.sql.Date.valueOf(today);
        productBUS product = new  productBUS();
        importDTO iDto = new importDTO (id,supid,staffid,create_day,total);
           try {
               iBus.add(iDto);
//        btnThanhtoan.hide();
           } catch (SQLException ex) {
               Logger.getLogger(TaoPhieuNhapGUI.class.getName()).log(Level.SEVERE, null, ex);
           }
           import_detailBUS idetail = new import_detailBUS();
           int l= idetail.list_size();
            datalist = new ArrayList<>();
         //   List<Integer> rowsToImport = new ArrayList<>();

         //     for (int row = tblPn.getRowCount() - 1; row >= 0; row--) {
    // Kiểm tra và lưu trữ chỉ mục của các hàng cần xử lý
                //rowsToImport .add(row);
             // }
              
           // System.out.println(model1.getRowCount());
         //  for(int row = tblPn.getRowCount() - 1; row >= 0; row--)
               for (int row = 0; row < this.tblPn.getRowCount(); row++)
           {
               //System.out.println(tblPn.getRowCount());
              // System.out.println(row);
               String cid=idetail.createId(l, row+1);
               String importid = id;
               Object proId = model1.getValueAt(row, 0);
               Object sl = model1.getValueAt(row, 3);
               Object gia = model1.getValueAt(row, 4);
               String productid = proId.toString();
               int quantity = (int)sl;
               double unitPrice =((Number) gia).doubleValue();
               double subTotal = quantity*unitPrice;
               Object name = model1.getValueAt(row, 2);
               String proName = name.toString();
               String soLuong = Integer.toString(quantity);
               int g = ConvertDoubleToInt(unitPrice);
               String giaban =formatMoney(g);
               int sum = ConvertDoubleToInt(subTotal);
               String tongCong = formatMoney(sum);
               table_receiptDTO  report = new table_receiptDTO (proName,soLuong,giaban,tongCong);
               
               import_detailDTO dto = new import_detailDTO(cid,importid,productid,quantity,unitPrice,subTotal,true);
               
            try {
                idetail.add(dto);
                datalist.add(report);
                product.sub_quantity(productid, quantity);
                // double total = quantity*unitPrice;
            } catch (SQLException ex) {
                Logger.getLogger(TaoPhieuNhapGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           }
           try {
                add_to_jasper(datalist);
            } catch (JRException ex) {
                Logger.getLogger(TaoPhieuNhapGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
                 this.btnThanhtoan.setVisible(false);
    }//GEN-LAST:event_btnThanhtoanActionPerformed
  
    public void add_to_jasper(ArrayList< table_receiptDTO > data) throws JRException
    {
        String filename = "pn.jrxml";
        int i = datalist.size();
        System.out.println(i);
        JasperReport jasper = JasperCompileManager.compileReport(pdfpath+filename);
        Map<String,Object> parameters = new HashMap<>();
        String maPn = this.id;
        String tenNv = this.lbTennv.getText();
        String maNcc = this.lbMancc.getText();
        String ten = this.lbTenncc.getText();
        String ngay = this.lbNgay.getText();
        String tongCong = this.lbTongtien.getText();
        parameters.put("maHd", maPn);
        parameters.put("tenNv", tenNv);
        parameters.put("maNcc", maNcc);
        parameters.put("tenNcc", ten);
        parameters.put("ngay", ngay);
        parameters.put("tc", tongCong);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper,parameters,dataSource);
        CustomJasperViewer customViewer = new CustomJasperViewer(jasperPrint);
        customViewer.setVisible(true);
        
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
//        chonSP choose = new chonSP(this);
//        choose.setVisible(true);
    if (this.tblPn.getRowCount() == 0) {
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng chọn sản phẩm ");
                alert.setVisible(true);
                return;
         }

          try {

            int[] rows = tblPn.getSelectedRows();
            for (int i = rows.length - 1; i >= 0; i--) {
                Object [] newRow = new Object[4];
                newRow[0]= model1.getValueAt(i, 0);
                newRow[1]= model1.getValueAt(i, 1);
                newRow[2]= model1.getValueAt(i, 2);
                newRow[3]= model1.getValueAt(i, 4);
                model.addRow(newRow);
                model1.removeRow(rows[i]);
                
            }
            //   MyMessageAccept accept = new MyMessageAccept(this, "Đã xóa sản phẩm thành công!");
        } catch (Exception ex) {

        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void lbChonnccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbChonnccMouseClicked
        // TODO add your handling code here:
        ChonNCCGUI chon = new ChonNCCGUI(this);
        chon.show();
    }//GEN-LAST:event_lbChonnccMouseClicked

    private void tblSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSpMouseClicked
        // TODO add your handling code here:
        
          if (evt.getClickCount() == 2 && off == false)
          {
              Object []newRow = new Object[5];
              int select = tblSp.getSelectedRow();
              newRow[0] = model.getValueAt(select, 0);
              newRow[1] = model.getValueAt(select, 1);
              newRow[2] = model.getValueAt(select, 2);
              newRow[3] = sl;
              newRow[4] = model.getValueAt(select, 3);
              model1.addRow(newRow);
              model.removeRow(select);
          }
    }//GEN-LAST:event_tblSpMouseClicked

    private void tblPnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPnMouseClicked
        // TODO add your handling code here:
        int row = tblPn.getSelectedRow();
        String sl = model1.getValueAt(row, 3).toString();
        this.txtSp.setText(sl);
    }//GEN-LAST:event_tblPnMouseClicked

    private void btnXacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacnhanActionPerformed
        // TODO add your handling code here:
            if (this.tblPn.getRowCount() == 0) {
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng chọn sản phẩm ");
                alert.setVisible(true);
                return;
         }
            if(this.lbMancc.getText().trim().isEmpty())
                {
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng chọn nhà cung cấp ");
                alert.setVisible(true);
                return;
         }
        this.lbChonncc.setVisible(false);
        this.txtSp.setVisible(false);
        this.btnSua.setVisible(false);
        this.btnXoa.setVisible(false);
        this.btnLammoi.setVisible(false);
        this.btnHuy.setVisible(true);
        this.btnXacnhan.setVisible(false);
        this.btnThanhtoan.setVisible(true);
        this.lbtong.setVisible(true);
        this.lbTongtien.setVisible(true);
        this.txtSp.setVisible(false);
        this.lbs.setVisible(false);
         off = true;
        tt=0;
        for(int i = 0;i<model1.getRowCount();i++)
        {
            Object sl = model1.getValueAt(i,3);
            int quantity = (int) sl;
            Object gia = model1.getValueAt(i,4);
            int unitPrice = (int) gia;
            int total = quantity*unitPrice;
            tt = tt+total;
            
        }
        String tongTien = formatMoney(tt);
        this.lbTongtien.setText(tongTien);
    }//GEN-LAST:event_btnXacnhanActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.lbChonncc.setVisible(true);
        this.txtSp.setVisible(true);
        this.btnSua.setVisible(true);
        this.btnXoa.setVisible(true);
        this.btnLammoi.setVisible(true);
        this.btnHuy.setVisible(false);
        this.btnXacnhan.setVisible(true);
        this.btnThanhtoan.setVisible(false);
        this.lbtong.setVisible(false);
        this.lbTongtien.setVisible(false);
        this.txtSp.setVisible(true);
        this.lbs.setVisible(true);
        off = false;
    }//GEN-LAST:event_btnHuyActionPerformed

   
    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:

       
       // model1.setRowCount(0);
        this.btnThanhtoan.hide();
        this.btnXacnhan.show();
        this.lbChonncc.setVisible(true);
        this.txtSp.setVisible(true);
        this.btnSua.setVisible(true);
        this.btnXoa.setVisible(true);
        this.lbtong.setVisible(false);
        this.lbTongtien.setVisible(false);
        this.txtSp.setText("");
        this.lbMancc.setText("");
        this.lbTenncc.setText("");
        this.lbs.setVisible(true);
        off = false;
        this.txtSp.setVisible(true);
       
          for (int i = tblPn.getRowCount() - 1; i >= 0; i--) {
                Object[] newRow = new Object[4];
                newRow[0] = model1.getValueAt(i, 0);
                newRow[1] = model1.getValueAt(i, 1);
                newRow[2] = model1.getValueAt(i, 2);
                newRow[3] = model1.getValueAt(i, 4);
                model.addRow(newRow);
                model1.removeRow(i);
    }//GEN-LAST:event_btnLammoiActionPerformed
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThanhtoan;
    private javax.swing.JButton btnXacnhan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbChonncc;
    private javax.swing.JLabel lbLich;
    public javax.swing.JLabel lbMancc;
    private javax.swing.JLabel lbManv;
    private javax.swing.JLabel lbNcc;
    private javax.swing.JLabel lbNgay;
    private javax.swing.JLabel lbNv;
    public javax.swing.JLabel lbTenncc;
    private javax.swing.JLabel lbTennv;
    private javax.swing.JLabel lbTongtien;
    private javax.swing.JLabel lbs;
    private javax.swing.JLabel lbsl;
    private javax.swing.JLabel lbtong;
    private javax.swing.JTable tblPn;
    private javax.swing.JTable tblSp;
    private javax.swing.JTextField txtSp;
    // End of variables declaration//GEN-END:variables
}
