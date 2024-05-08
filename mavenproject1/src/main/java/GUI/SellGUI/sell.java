/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.SellGUI;
import BUS.customerBUS;
import BUS.productBUS;
import BUS.promotion_detailBUS;
import BUS.receipt_DetailBUS;
import BUS.receptBUS;
import DAO.promotion_detailDAO;
import DAO.receipt_DetailDAO;
import DTO.customerDTO;
import DTO.receptDTO;
import DTO.receptDetailDTO;
import GUI.MainGUI;
import GUI.SellGUI.raven.cell.TableActionCellRender;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import Model.MyButton;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import Model.CustomHeaderRenderer;
import Model.MyMessageAccept;
import Model.MyMessageAlert;
import Model.helpers;
import static Model.helpers.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import Model.MyMessageAccept;
import Model.MyMessageAlert;
import javax.swing.JOptionPane;

/**
 *
 * @author MY PC
 */
public class sell extends javax.swing.JPanel {

    /**
     * Creates new form sell
     */
     customerBUS customerBUS;
    File file = new File("");
    DefaultTableModel model;
    String currentDirectory = file.getAbsolutePath();
    String relativePath = currentDirectory + "\\src\\main\\java\\IMG\\"; 
    private  LocalDate today ;
    private int sum;
    private DateTimeFormatter formatter;
    private String formattedDate;
    public String adress;
    private String iD;
    MainGUI maingui;
    productBUS productBUS;
    showkm showkm;
    private ImageIcon scaleImage(String filename,int width, int height) {
        try {
            BufferedImage img = ImageIO.read(new File(relativePath+filename));
            Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
   public sell(MainGUI main){
           initComponents();
    

          ImageIcon  hoadon= scaleImage("bill.png", 83, 84);
          lbHD.setIcon(hoadon);

          ImageIcon Sdt = scaleImage("bill.jpg",47, 45);
          lbSdt.setIcon(Sdt);
           this.btnThanhtoan.hide();
           this.btnXuathd.hide();
           this.btnHuy.hide();
           this.lbXemkm.hide();
          customerBUS customer = new customerBUS();
          maingui = main;
          iD= maingui.id;
          this.lbNhanvien.setText(maingui.name);
          receptBUS  receipt = new receptBUS ();
          String mhd =receipt.createId();
          this.lbhd.setText(mhd);
     
           today = LocalDate.now();
          formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
          formattedDate = today.format(formatter);
          lbNgay.setText(formattedDate);
          
         convertBackgroundOfTable(tblProduct);
            String[] header = {"Mã sản phẩm","Hãng","Tên sản phẩm","Số lượng","Giá"};
            model = (DefaultTableModel) 
            tblProduct.getModel();
            model.setColumnIdentifiers(header);
            tblProduct.getColumnModel().getColumn(0).setPreferredWidth(110);
            tblProduct.getColumnModel().getColumn(1).setPreferredWidth(90);
            tblProduct.getColumnModel().getColumn(2).setPreferredWidth(110);
            tblProduct.getColumnModel().getColumn(3).setPreferredWidth(90);
            tblProduct.getColumnModel().getColumn(4).setPreferredWidth(90);
            removeData();
   }
     public sell(MainGUI main,showkm show){
           initComponents();
    

          ImageIcon  hoadon= scaleImage("bill.png", 83, 84);
          lbHD.setIcon(hoadon);

          ImageIcon Sdt = scaleImage("bill.jpg",47, 45);
          lbSdt.setIcon(Sdt);
           this.btnThanhtoan.hide();
           this.btnXuathd.hide();
           this.btnHuy.hide();
           this.lbXemkm.hide();
          customerBUS customer = new customerBUS();
          showkm =show;
          maingui = main;
          iD= maingui.id;
          this.lbNhanvien.setText(maingui.name);
          receptBUS  receipt = new receptBUS ();
          String mhd =receipt.createId();
          this.lbhd.setText(mhd);
     
           today = LocalDate.now();
          formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
          formattedDate = today.format(formatter);
          lbNgay.setText(formattedDate);
          
         convertBackgroundOfTable(tblProduct);
            String[] header = {"Mã sản phẩm","Hãng","Tên sản phẩm","Số lượng","Giá"};
            model = (DefaultTableModel) 
            tblProduct.getModel();
            model.setColumnIdentifiers(header);
            tblProduct.getColumnModel().getColumn(0).setPreferredWidth(110);
            tblProduct.getColumnModel().getColumn(1).setPreferredWidth(90);
            tblProduct.getColumnModel().getColumn(2).setPreferredWidth(110);
            tblProduct.getColumnModel().getColumn(3).setPreferredWidth(90);
            tblProduct.getColumnModel().getColumn(4).setPreferredWidth(90);
            removeData();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbTongtien = new javax.swing.JLabel();
        lbSdt6 = new javax.swing.JLabel();
        lbSdt3 = new javax.swing.JLabel();
        lbSdt9 = new javax.swing.JLabel();
        lbSdt10 = new javax.swing.JLabel();
        lbSdt12 = new javax.swing.JLabel();
        lbTenkhach = new javax.swing.JLabel();
        lbKm = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbSdt13 = new javax.swing.JLabel();
        lbSdt15 = new javax.swing.JLabel();
        lbSdt14 = new javax.swing.JLabel();
        lbThanhtoan = new javax.swing.JLabel();
        txtTiennhan = new javax.swing.JTextField();
        lbTienthua = new javax.swing.JLabel();
        lbhd = new javax.swing.JLabel();
        lbXemkm = new javax.swing.JLabel();
        lbSdt = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbSdt4 = new javax.swing.JLabel();
        lbTenkh = new javax.swing.JLabel();
        lbMakh = new javax.swing.JLabel();
        btnAddkh = new javax.swing.JButton();
        lbSdt7 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lbHD = new javax.swing.JLabel();
        lbNhanvien = new javax.swing.JLabel();
        lbSdt5 = new javax.swing.JLabel();
        lbSdt8 = new javax.swing.JLabel();
        lbNgay = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnXuathd = new javax.swing.JButton();
        btnThanhtoan = new javax.swing.JButton();
        btnChon = new javax.swing.JButton();
        txtSp = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        btnXacnhan = new javax.swing.JButton();
        lbsl = new javax.swing.JLabel();
        btnLammoi = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(950, 650));
        setPreferredSize(new java.awt.Dimension(950, 650));
        setRequestFocusEnabled(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setPreferredSize(new java.awt.Dimension(950, 650));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.setPreferredSize(new java.awt.Dimension(380, 120));
        tblProduct.setRowHeight(40);
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        tblProduct.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tblProductInputMethodTextChanged(evt);
            }
        });
        tblProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblProductKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblProduct);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 510, 440));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbTongtien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTongtien.setText("1.000.000");

        lbSdt6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbSdt6.setText("THANH TOÁN");

        lbSdt3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSdt3.setText("Khuyến mãi");

        lbSdt9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSdt9.setText("Mã hóa đơn");

        lbSdt10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSdt10.setText("Khách hàng");

        lbSdt12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSdt12.setText("Tổng tiền");

        lbTenkhach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTenkhach.setText("Minh Khuê");

        lbKm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbKm.setText("-400.000");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        lbSdt13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbSdt13.setText("Thanh toán");

        lbSdt15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbSdt15.setText("Tiền nhận");

        lbSdt14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbSdt14.setText("Tiền thừa");

        lbThanhtoan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbThanhtoan.setText("16.000.000");

        txtTiennhan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTiennhan.setText("18.000.000");
        txtTiennhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiennhanActionPerformed(evt);
            }
        });

        lbTienthua.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbTienthua.setText("2.000.000");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lbSdt14, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTienthua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lbSdt15, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTiennhan, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 22, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lbSdt13)
                .addGap(18, 18, 18)
                .addComponent(lbThanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbThanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSdt13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSdt15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTiennhan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSdt14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTienthua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        lbhd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbhd.setText("HD01");

        lbXemkm.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbXemkm.setText("Xem chi tiết");
        lbXemkm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbXemkmMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbSdt9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbSdt10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbSdt12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbSdt3))
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTenkhach)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbKm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTongtien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbXemkm, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbhd))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbSdt6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbSdt6)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSdt9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbhd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSdt10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTenkhach, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSdt12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSdt3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbKm, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbXemkm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 381, 440));
        jPanel4.add(lbSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 47, 45));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(253, 114));

        lbSdt4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSdt4.setText("Mã khách hàng");

        lbTenkh.setText("Tên khách hàng");

        lbMakh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMakh.setText("KH01");

        btnAddkh.setForeground(new java.awt.Color(255, 255, 255));
        btnAddkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddkhActionPerformed(evt);
            }
        });

        lbSdt7.setText("Tên khách hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSdt4)
                    .addComponent(lbSdt7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMakh, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnAddkh, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSdt7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSdt4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMakh, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnAddkh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 370, 98));

        txtSdt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtSdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSdtActionPerformed(evt);
            }
        });
        jPanel4.add(txtSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 86, 110, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbHD.setPreferredSize(new java.awt.Dimension(83, 84));

        lbNhanvien.setText("Nhân viên");

        lbSdt5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSdt5.setText("Ngày");

        lbSdt8.setText("Nhân viên");

        lbNgay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNgay.setPreferredSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHD, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSdt8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSdt5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSdt8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSdt5)
                    .addComponent(lbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 380, -1));

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel4.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 83, 29));

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel4.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 580, 100, 33));

        btnXuathd.setText("Xuất hóa đơn");
        btnXuathd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuathdActionPerformed(evt);
            }
        });
        jPanel4.add(btnXuathd, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 580, -1, 33));

        btnThanhtoan.setText("Thanh toán");
        btnThanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhtoanActionPerformed(evt);
            }
        });
        jPanel4.add(btnThanhtoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 580, -1, 33));

        btnChon.setText("Chọn");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });
        jPanel4.add(btnChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 580, 83, 29));
        jPanel4.add(txtSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 79, 29));

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel4.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, 83, 29));

        btnXacnhan.setText("Xác nhận");
        btnXacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacnhanActionPerformed(evt);
            }
        });
        jPanel4.add(btnXacnhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 580, 90, 33));

        lbsl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbsl.setText("Số lượng");
        jPanel4.add(lbsl, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, 72, 25));

        btnLammoi.setText("Làm mới");
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });
        jPanel4.add(btnLammoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 580, 100, 33));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        // TODO add your handling code here:

        int row = this.tblProduct.getSelectedRow();
        Object sl =model.getValueAt(row,3);
        this.txtSp.setText(sl.toString());
    }//GEN-LAST:event_tblProductMouseClicked

    private void tblProductInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblProductInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tblProductInputMethodTextChanged

    private void tblProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductKeyPressed
        // TODO add your handling code here:
        // int cellValue = (int) tlbProduct.getValueAt(1, 3)
    }//GEN-LAST:event_tblProductKeyPressed

    private void txtTiennhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiennhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiennhanActionPerformed

    private void btnAddkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddkhActionPerformed
        // TODO add your handling code here:
        addKh add = new addKh(this);
        add.setVisible(true);

    }//GEN-LAST:event_btnAddkhActionPerformed

    private void txtSdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSdtActionPerformed
        // TODO add your handling code here:
        this.customerBUS = new customerBUS ();
        String sdt= this.txtSdt.getText();
        if (sdt.length() == 10){
            customerDTO cus = new customerDTO();
            try {
                cus = customerBUS.searchsdt(sdt);
                this.lbMakh.setText(cus.getCusID());
                this.lbTenkh.setText(cus.getFirstName() +" "+cus.getLastName());
            } catch (SQLException ex) {
                Logger.getLogger(TestSell.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_txtSdtActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:

        try{
          
            int[] rows  = tblProduct.getSelectedRows();
            for(int i = rows.length - 1; i >= 0; i--)
            {
                model.removeRow(rows[i]);
            }
          //   MyMessageAccept accept = new MyMessageAccept(this, "Đã xóa sản phẩm thành công!");
        }
        catch(Exception ex)
        {
           
        }

    }//GEN-LAST:event_btnXoaActionPerformed


    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.btnXacnhan.show();
        this.btnChon.show();
        this.btnXoa.show();
        this.btnSua.show();
        this.txtSp.show();
        this.lbsl.show();
        this.btnThanhtoan.hide();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXuathdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuathdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuathdActionPerformed
    
    private void btnThanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhtoanActionPerformed
        // TODO add your handling code here:
        this.btnThanhtoan.hide();
        this.btnXuathd.show();
        this.btnHuy.hide();
        this.btnLammoi.show();
        String maHd = this.lbhd.getText();
        String maKh = this.lbMakh.getText();
        String id = iD;
        Date create_day = java.sql.Date.valueOf(today);
        String totalText = this.lbThanhtoan.getText();
        double Total = Double.parseDouble(totalText);
       
        receptDTO receipt = new receptDTO(maHd,maKh,id, create_day,Total);
        receptBUS bus = new receptBUS();
         try {
             bus.add(receipt);
         } catch (SQLException ex) {
             Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
         }
         receptDetailDTO receiptDTO = new receptDetailDTO();
//         for(int row = 1;row<=this.tblProduct.getRowCount();row ++)
//         {
//             receipt_DetailBUS receiptDetailBUS = new receipt_DetailBUS();
//             int l = receiptDetailBUS.list_size();
//             String receiptDetailID = receiptDetailBUS.createId(l, row);
//             String receiptID = this.lbhd.getText();
//             Object proID = model.getValueAt(row, 0);
//             String productID = proID.toString();
//             String PromotionID = "NORMAL";
//             Object sl = model.getValueAt(row, 3);
//             int quantity = ((Integer) sl).intValue();
//             Object dongia = model.getValueAt(row, 4);
//             double unitPrice = Double.parseDouble(dongia.toString());
//             double subTotal = Double.parseDouble(this.lbThanhtoan.getText());
//             receptDetailDTO dto = new receptDetailDTO(receiptDetailID,receiptID,PromotionID,productID,quantity,unitPrice,subTotal);
//             receipt_DetailDAO dao = new receipt_DetailDAO();
//            try {
//                dao.add(dto);
//            } catch (SQLException ex) {
//                Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
//            }
//         }
        // System.out.println(tblProduct.getRowCount());
        receipt_DetailBUS receiptDetailBUS = new receipt_DetailBUS();
         int l = receiptDetailBUS.list_size();
         l=l+1;
        
         for (int row = 0; row < this.tblProduct.getRowCount(); row++) {
         
            String receiptDetailID = receiptDetailBUS.createId(l, row+1);
            String receiptID = this.lbhd.getText();
            Object proID = model.getValueAt(row, 0);
            String productID = proID.toString();
            String promotionID =" ";
           promotion_detailBUS proBUS = new promotion_detailBUS();
           
            try {
                promotionID =  proBUS.getPromotionID(productID);
            } catch (SQLException ex) {
                Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
            }
            //String promotionID = "NORMAL"; // Changed variable name to lowercase for convention
            Object sl = model.getValueAt(row, 3);
            int quantity = sl instanceof Integer ? (int) sl : 0; // Safely cast to Integer
  
            Object dongia = model.getValueAt(row, 4);
            double unitPrice = 0.0; // Default value if parsing fails
            if (dongia instanceof Number) {
                unitPrice = ((Number) dongia).doubleValue(); // Safely parse to double
            }
           
            
            double subTotal = Double.parseDouble(this.lbThanhtoan.getText());
            productBUS product = new productBUS();
            receptDetailDTO dto = new receptDetailDTO(receiptDetailID, receiptID, promotionID, productID, quantity, unitPrice, subTotal);
            receipt_DetailBUS bus = new receipt_DetailBUS();
            try {
                bus.add(dto);
            } catch (SQLException ex) {
                Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                product.update_quantity(productID, quantity);
            } catch (SQLException ex) {
                Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btnThanhtoanActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        chonSP choose = new chonSP(this);
        choose.setVisible(true);
    }//GEN-LAST:event_btnChonActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = this.tblProduct.getSelectedRow();
        Object ID = model.getValueAt(row, 0);
        String id = ID.toString();
        int sl = Integer.valueOf(txtSp.getText());
        productBUS product = new  productBUS();
         try {
             if(product.compareQuantity(id, sl)==0)
             {
               //   MyMessageAlert alert = new MyMessageAlert(,"Giới tính sai định dạng. Vui lòng nhập lại");
                   // alert.setVisible(true);
                   JOptionPane.showMessageDialog(null, "Số lượng còn lại trong kho không đủ ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
             else{
                    model.setValueAt(sl, row, 3);
             }
              
         } catch (SQLException ex) {
             Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
         }

    }//GEN-LAST:event_btnSuaActionPerformed
    private int Tinh(String productID, int sl,int dongia)
    {    
        promotion_detailBUS proBUS = new promotion_detailBUS();
        float km;
        //double quantity = sl;
         float percent=0.0f;
            try {
                 percent = proBUS.promotion_percent(productID);
            } catch (SQLException ex) {
                Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
            }
          //double per = (double) percent;
          
//          System.out.println(percent);
//          System.out.println(sl);
//          System.out.println(dongia);
          km = percent*dongia;
//          System.out.println(km);
          double total = percent*dongia*sl;
          int totalInt = (int) total;
          return  totalInt;
          
    }
    private void btnXacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacnhanActionPerformed
        // TODO add your handling code here:
        this.btnXacnhan.hide();
        this.btnHuy.show();
        this.lbXemkm.show();
        this.btnChon.hide();
        this.btnXoa.hide();
        this.btnSua.hide();
        this.txtSp.hide();
        this.lbsl.hide();
        this.btnThanhtoan.show();
        //object [] o;
        tblProduct.clearSelection();
        int s =0;
         showkm show= new showkm();
        for (int row = tblProduct.getRowCount()- 1; row >= 0; row--)
        {
            
            int tinhkm = 0;
            Object id = model.getValueAt(row,0);
            String productID = id.toString();
            Object sl= model.getValueAt(row,3);
            Object g= model.getValueAt(row,4);
            int sL = ((Integer) sl).intValue();
            int gia = ((Integer) g).intValue();
            int giasp =sL*gia;
            sum = sum+giasp;
            tinhkm = Tinh(productID,sL,gia);
            if (tinhkm<giasp)
            {  s = s+ tinhkm;
            
                Object [] newFormRow = new Object[5];
                newFormRow[0] = model.getValueAt(row,0);//masp
                newFormRow[1] = model.getValueAt(row,4);//gia goc
                promotion_detailBUS proBUS = new promotion_detailBUS();
                try {
                 float per= proBUS.promotion_percent(productID);
                } catch (SQLException ex) {
                    Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
                }
               // Float perObject = Float.valueOf(per);
              //  newFormRow[2] 
                 newFormRow[3] = model.getValueAt(row,3);//so luong
                 Integer tinhkmObject = Integer.valueOf(tinhkm);
                 newFormRow[4]= tinhkmObject;
                 show.model1.addRow(newFormRow);
                
            }
            
        }
        // showkm show = new showkm();
      //   show.setVisible(true);
        int tt = sum - s;

        this.lbKm.setText("- " + Integer.toString(s));
        lbTongtien.setText(Integer.toString(sum));
        lbThanhtoan.setText(Integer.toString(tt));
    }//GEN-LAST:event_btnXacnhanActionPerformed

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:
        this.lbKm.setVisible(false);
        
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void lbXemkmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbXemkmMouseClicked
        // TODO add your handling code here:
        String tienkm = this.lbKm.getText();
        String text = tienkm.substring(2); 
        int value = Integer.parseInt(text);
        if(value>0)
        {
              showkm km = new showkm();
               km.setVisible(true);
        }
      
    }//GEN-LAST:event_lbXemkmMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddkh;
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThanhtoan;
    private javax.swing.JButton btnXacnhan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuathd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbHD;
    private javax.swing.JLabel lbKm;
    public javax.swing.JLabel lbMakh;
    private javax.swing.JLabel lbNgay;
    private javax.swing.JLabel lbNhanvien;
    private javax.swing.JLabel lbSdt;
    private javax.swing.JLabel lbSdt10;
    private javax.swing.JLabel lbSdt12;
    private javax.swing.JLabel lbSdt13;
    private javax.swing.JLabel lbSdt14;
    private javax.swing.JLabel lbSdt15;
    private javax.swing.JLabel lbSdt3;
    private javax.swing.JLabel lbSdt4;
    private javax.swing.JLabel lbSdt5;
    private javax.swing.JLabel lbSdt6;
    private javax.swing.JLabel lbSdt7;
    private javax.swing.JLabel lbSdt8;
    private javax.swing.JLabel lbSdt9;
    public javax.swing.JLabel lbTenkh;
    private javax.swing.JLabel lbTenkhach;
    private javax.swing.JLabel lbThanhtoan;
    private javax.swing.JLabel lbTienthua;
    private javax.swing.JLabel lbTongtien;
    private javax.swing.JLabel lbXemkm;
    private javax.swing.JLabel lbhd;
    private javax.swing.JLabel lbsl;
    public javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSp;
    private javax.swing.JTextField txtTiennhan;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
