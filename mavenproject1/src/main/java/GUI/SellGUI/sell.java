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
import DTO.table_receiptDTO;
import GUI.MainGUI;
import GUI.SellGUI.raven.cell.TableActionCellRender;
import Model.CustomConfirmDialog;
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
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import Model.CustomJasperViewer;
import Model.CustomTableCellRenderer;
import javax.swing.table.JTableHeader;
import static Model.helpers.addTextChanged;

/**
 *
 * @author MY PC
 */
public class sell extends javax.swing.JPanel {

    /**
     * Creates new form sell
     */
    JFrame parentFrame;
    customerBUS customerBUS;
    File file = new File("");
    DefaultTableModel model;
    String currentDirectory = file.getAbsolutePath();
    String relativePath = currentDirectory + "\\src\\main\\java\\IMG\\";
    String pdfpath = currentDirectory + "\\src\\main\\java\\pdf\\";
    private LocalDate today;
    private int sum;
    private int s;
    private DateTimeFormatter formatter;
    private String formattedDate;
    public String adress;
    private String iD;
    MainGUI maingui;
    productBUS productBUS;
    showkm showkm;
    receipt_DetailBUS receipt_DetailBUS;
    private int tt;

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

    public sell(MainGUI main) {
        initComponents();

        addTextChanged(txtTiennhan);
        ImageIcon hoadon = scaleImage("bill.png", 83, 84);
        lbHD.setIcon(hoadon);
        //  This.dispose()
        ImageIcon Sdt = scaleImage("bill.jpg", 47, 45);
        lbSdt.setIcon(Sdt);
        this.btnThanhtoan.hide();
        this.btnXuathd.hide();
        this.btnHuy.hide();
        this.lbXemkm.hide();
        this.lbkt.hide();
        this.lbdt.hide();
        this.txtTiennhan.setVisible(false);
        //object [] o;
        customerBUS customer = new customerBUS();
        // showkm = show;
        maingui = main;
        iD = maingui.id;
        this.lbNhanvien.setText(maingui.name);
        receptBUS receipt = new receptBUS();
        String mhd = receipt.createId();
        this.lbhd.setText(mhd);

        today = LocalDate.now();
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        formattedDate = today.format(formatter);

        lbNgay.setText(formattedDate);

        JTableHeader header1 = tblProduct.getTableHeader();
        header1.setDefaultRenderer(new CustomHeaderRenderer());

        convertBackgroundOfTable(tblProduct);
        String[] header = {"Mã sản phẩm", "Hãng", "Tên sản phẩm", "Số lượng", "Giá"};
        model = (DefaultTableModel) tblProduct.getModel();
        model.setColumnIdentifiers(header);
        tblProduct.getColumnModel().getColumn(0).setPreferredWidth(110);
        tblProduct.getColumnModel().getColumn(1).setPreferredWidth(90);
        tblProduct.getColumnModel().getColumn(2).setPreferredWidth(110);
        tblProduct.getColumnModel().getColumn(3).setPreferredWidth(90);
        tblProduct.getColumnModel().getColumn(4).setPreferredWidth(90);

        CustomTableCellRenderer centerRenderer = new CustomTableCellRenderer();
        tblProduct.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblProduct.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblProduct.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        removeData();
    }

    public void removeData() {
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
        lbdt = new javax.swing.JLabel();
        lbTenkh = new javax.swing.JLabel();
        lbMakh = new javax.swing.JLabel();
        btnAddkh = new javax.swing.JButton();
        lbtenk = new javax.swing.JLabel();
        lbkt = new javax.swing.JLabel();
        lbma = new javax.swing.JLabel();
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

        lbKm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        lbSdt13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbSdt13.setText("Thanh toán");

        lbSdt15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbSdt15.setText("Tiền nhận");

        lbSdt14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbSdt14.setText("Tiền thừa");

        lbThanhtoan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        txtTiennhan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTiennhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiennhanActionPerformed(evt);
            }
        });

        lbTienthua.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lbSdt14, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTienthua, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lbSdt15, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTiennhan, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 16, Short.MAX_VALUE))
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
                    .addComponent(lbhd)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTongtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbKm, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbXemkm, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbdt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbdt.setText("Số điện thoại không hợp lệ");
        jPanel1.add(lbdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 26));
        jPanel1.add(lbTenkh, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 13, 90, 26));

        lbMakh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(lbMakh, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 57, 55, 26));

        btnAddkh.setBackground(new java.awt.Color(22, 36, 71));
        btnAddkh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddkh.setForeground(new java.awt.Color(255, 255, 255));
        btnAddkh.setText("thêm");
        btnAddkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddkhActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddkh, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 35, 60, 32));

        lbtenk.setText("Tên khách hàng");
        jPanel1.add(lbtenk, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 13, -1, 26));

        lbkt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbkt.setText("Không tìm thấy khách hàng");
        jPanel1.add(lbkt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 26));

        lbma.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbma.setText("Mã khách hàng");
        jPanel1.add(lbma, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 57, -1, 26));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 360, 98));

        txtSdt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtSdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSdtActionPerformed(evt);
            }
        });
        txtSdt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSdtKeyReleased(evt);
            }
        });
        jPanel4.add(txtSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 86, 130, -1));

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

        btnXoa.setBackground(new java.awt.Color(53, 21, 93));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel4.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 90, 33));

        btnHuy.setBackground(new java.awt.Color(50, 44, 43));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel4.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 580, 90, 33));

        btnXuathd.setText("Xuất hóa đơn");
        btnXuathd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuathdActionPerformed(evt);
            }
        });
        jPanel4.add(btnXuathd, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 580, 90, 33));

        btnThanhtoan.setBackground(new java.awt.Color(128, 61, 59));
        btnThanhtoan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThanhtoan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhtoan.setText("Thanh toán");
        btnThanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhtoanActionPerformed(evt);
            }
        });
        jPanel4.add(btnThanhtoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 580, 100, 33));

        btnChon.setBackground(new java.awt.Color(0, 34, 77));
        btnChon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChon.setForeground(new java.awt.Color(255, 255, 255));
        btnChon.setText("Chọn");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });
        jPanel4.add(btnChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 580, 90, 33));

        txtSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSpActionPerformed(evt);
            }
        });
        jPanel4.add(txtSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 79, 29));

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
        jPanel4.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, 90, 33));

        btnXacnhan.setBackground(new java.awt.Color(60, 7, 83));
        btnXacnhan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXacnhan.setForeground(new java.awt.Color(255, 255, 255));
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

        btnLammoi.setBackground(new java.awt.Color(3, 6, 55));
        btnLammoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLammoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLammoi.setText("Làm mới");
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });
        jPanel4.add(btnLammoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 580, 90, 33));

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
        int row = this.tblProduct.getSelectedRow();
        Object sl = model.getValueAt(row, 3);
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
//        String tien = this.txtTiennhan.getText();
//        if (tien.matches(".*[^a-zA-Z0-9].*")) {
//    MyMessageAlert alert = new MyMessageAlert(parentFrame, "Tiền nhận không hợp lệ");
//    alert.setVisible(true);
//} else {
//    try {
//        int tn = Integer.parseInt(tien);
//        // Sử dụng biến tn ở đây
//    } catch (NumberFormatException e) {
//        MyMessageAlert alert = new MyMessageAlert(parentFrame, "Tiền nhận không hợp lệ");
//        alert.setVisible(true);
//    }
//}
    }//GEN-LAST:event_txtTiennhanActionPerformed

    private void btnAddkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddkhActionPerformed
        // TODO add your handling code here:
        addKh add = new addKh(this);
        add.setVisible(true);

    }//GEN-LAST:event_btnAddkhActionPerformed

    private void txtSdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSdtActionPerformed
        // TODO add your handling code here:
//        this.customerBUS = new customerBUS ();
//        String sdt= this.txtSdt.getText();
//        if (sdt.length() == 10){
//            customerDTO cus = new customerDTO();
//            try {
//                cus = customerBUS.searchsdt(sdt);
//                this.lbMakh.setText(cus.getCusID());
//                this.lbTenkh.setText(cus.getFirstName() +" "+cus.getLastName());
//                this.lbTenkhach.setText(cus.getFirstName() +" "+cus.getLastName());
//            } catch (SQLException ex) {
//                Logger.getLogger(TestSell.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
    }//GEN-LAST:event_txtSdtActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (this.tblProduct.getRowCount() == 0) {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng chọn sản phẩm ");
            alert.setVisible(true);
            return;
        }
        try {

            int[] rows = tblProduct.getSelectedRows();
            for (int i = rows.length - 1; i >= 0; i--) {
                model.removeRow(rows[i]);
            }
            //   MyMessageAccept accept = new MyMessageAccept(this, "Đã xóa sản phẩm thành công!");
        } catch (Exception ex) {

        }

    }//GEN-LAST:event_btnXoaActionPerformed

    public static void printTableReceiptList(List<table_receiptDTO> list) {
        for (table_receiptDTO element : list) {
            System.out.println("Mã SP: " + element.getMaSp());
            System.out.println("Số lượng: " + element.getSl());
            System.out.println("Giá gốc: " + element.getGiagoc());
            System.out.println("Giá bán: " + element.getGiaban());
            System.out.println("Tổng: " + element.getTong());
            System.out.println("----------------------------------");
        }
    }
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.btnXacnhan.show();
        this.btnChon.show();
        this.btnXoa.show();
        this.btnSua.show();
        this.txtSp.show();
        this.lbsl.show();
        this.btnAddkh.show();
        this.btnThanhtoan.hide();
        this.txtTiennhan.setVisible(false);
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXuathdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuathdActionPerformed

    }//GEN-LAST:event_btnXuathdActionPerformed

    private void btnThanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhtoanActionPerformed
        // TODO add your handling code here:
        //       this.btnThanhtoan.hide();
        //  this.btnXuathd.show();
        if (this.txtTiennhan.getText().trim().isEmpty()) {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Chưa nhập tiền nhận");
            alert.setVisible(true);
            return;
        }
        this.btnHuy.hide();
        this.btnLammoi.show();
        String maHd = this.lbhd.getText();
        String maKh = this.lbMakh.getText();
        String id = iD;
        Date create_day = java.sql.Date.valueOf(today);
        String tien = this.txtTiennhan.getText().replace(".", "");

        try {
            int tn = Integer.parseInt(tien);
            String tiennhan = formatMoney(tn);
            this.txtTiennhan.setText(tiennhan);
            if (tn < tt) {
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng nhập đủ số tiền");
                alert.setVisible(true);
                return;
            }
            int tienthua = tn - tt;
            String thua = formatMoney(tienthua);
            this.lbTienthua.setText(thua);
        } catch (NumberFormatException e) {

        }
        double Total = Double.valueOf(tt);

        receptDTO receipt = new receptDTO(maHd, maKh, id, create_day, Total);
        receptBUS bus = new receptBUS();
        try {
            bus.add(receipt);
        } catch (SQLException ex) {
            Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
        }
        receptDetailDTO receiptDTO = new receptDetailDTO();
        receipt_DetailBUS receiptDetailBUS = new receipt_DetailBUS();
        int l = receiptDetailBUS.list_size();
        System.out.println("size: "+l);
        l = l + 1;
        List<table_receiptDTO> dataList = new ArrayList<>();
        for (int row = 0; row < this.tblProduct.getRowCount(); row++) {

            String receiptDetailID = receiptDetailBUS.createId(l, row + 1);
            String receiptID = this.lbhd.getText();
            Object proID = model.getValueAt(row, 0);
            String productID = proID.toString();
            String promotionID = " ";
            promotion_detailBUS proBUS = new promotion_detailBUS();

            try {
                promotionID = proBUS.getPromotionID(productID);
            } catch (SQLException ex) {
                Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object sl = model.getValueAt(row, 3);
            int quantity = sl instanceof Integer ? (int) sl : 0;

            Object dongia = model.getValueAt(row, 4);
            double unitPrice = 0.0;
            if (dongia instanceof Number) {
                unitPrice = ((Number) dongia).doubleValue();
            }

            double subTotal = 0;
            double sub = 0;
            float per = 0;
            try {
                per = proBUS.promotion_percent(productID);
            } catch (SQLException ex) {
                Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (per != 0) {
                sub = Math.floor((1 - per) * unitPrice);
                subTotal = sub * quantity;
            } //  subTotal = Math.floor((1 - per) * quantity * unitPrice);
            else {
                subTotal = quantity * unitPrice;
                sub = unitPrice;
            }

            productBUS product = new productBUS();
            receptDetailDTO dto = new receptDetailDTO(receiptDetailID, receiptID, promotionID, productID, quantity, unitPrice, subTotal);
            String soluong = Integer.toString(quantity);
            Object tenSP = model.getValueAt(row, 2);
            String ten = tenSP.toString();
            int u = ConvertDoubleToInt(unitPrice);
            String giagoc = formatMoney(u);
            int s = ConvertDoubleToInt(sub);
            String giaban = formatMoney(s);
            int stt = ConvertDoubleToInt(subTotal);
            String tong = formatMoney(stt);
            table_receiptDTO table_receipt = new table_receiptDTO(ten, soluong, giagoc, giaban, tong);
            dataList.add(table_receipt);
            try {
                receiptDetailBUS.add(dto);
            } catch (SQLException ex) {
                Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);

            }
            try {
                product.update_quantity(productID, quantity);
            } catch (SQLException ex) {
                Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            add_to_jasper(dataList);
        } catch (JRException ex) {
            Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnThanhtoan.hide();
    }//GEN-LAST:event_btnThanhtoanActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        chonSP choose = new chonSP(this);
        choose.setVisible(true);
    }//GEN-LAST:event_btnChonActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
       
          if (containsLetter(txtSp.getText())) {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng nhập đúng định dạng");
            alert.setVisible(true);
            return;
        }
        if (this.tblProduct.getRowCount() == 0) {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng chọn sản phẩm ");
            alert.setVisible(true);
            return;
        }
        if (txtSp.getText().trim().isEmpty()) {
            MyMessageAlert alert1 = new MyMessageAlert(parentFrame, "Vui lòng chọn sản phẩm cần sửa");
            alert1.setVisible(true);
        } else {

            int row = this.tblProduct.getSelectedRow();
            Object ID = model.getValueAt(row, 0);
            String id = ID.toString();
            int sl = Integer.valueOf(txtSp.getText());
            if (sl == 0) {
                MyMessageAlert alert2 = new MyMessageAlert(parentFrame, "Số lượng cần sửa lớn hơn 0");
                alert2.setVisible(true);
            } else {
                productBUS product = new productBUS();
                try {
                    if (product.compareQuantity(id, sl) == 0) {
                        MyMessageAlert alert = new MyMessageAlert(parentFrame, "Số lượng sản phẩm " + id + " không đủ");
                        alert.setVisible(true);
                    } else {
                        model.setValueAt(sl, row, 3);
                        if (this.tblProduct.getRowCount() == 0) {
                            this.txtSp.setText("");
                        }
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        btnThanhtoan.hide();
    }//GEN-LAST:event_btnSuaActionPerformed
    private int Tinh(String productID, int sl, int dongia) {
        promotion_detailBUS proBUS = new promotion_detailBUS();
        float km;
        //double quantity = sl;
        float percent = 0.0f;
        try {
            percent = proBUS.promotion_percent(productID);
        } catch (SQLException ex) {
            Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
        }

        km = percent * dongia;
        double total = percent * dongia * sl;
        int totalInt = (int) total;
        return totalInt;

    }

    public void add_row_jasper(List<table_receiptDTO> dataList, JasperReport jasperReport, Map<String, Object> parameters) throws JRException {
//         Map<String, Object> parameters = new HashMap<>();
//         parameters.put("yourVariableName", "product_name");
//         parameters.put("yourVariableName", "sl");
//         parameters.put("gia", "sl");
        //   JRBeanCollectionDataSource datasource = new  JRBeanCollectionDataSource();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

    }

    private void add_to_jasper(List<table_receiptDTO> dataList) throws JRException {
        String file_name = "hd.jrxml";
        JasperReport jasperReport = JasperCompileManager.compileReport(pdfpath + file_name);
        // Map parameters = new HashMap();
        Map<String, Object> parameters = new HashMap<>();
        String maHD = this.lbhd.getText();
        String maKH = this.lbMakh.getText();
        String tenKH = this.lbTenkhach.getText();
        String nhanVien = this.lbNhanvien.getText();
        String day = this.lbNgay.getText();
        String tongTien = this.lbNgay.getText();
        String tong = this.lbTongtien.getText();
        String km = this.lbKm.getText();
        String tt = this.lbThanhtoan.getText();
        parameters.put("maHd", maHD);
        parameters.put("maKh", maKH);
        parameters.put("tenKh", tenKH);
        parameters.put("tenNv", nhanVien);
        parameters.put("ngay", day);
        parameters.put("tc", tong);
        parameters.put("km", km);
        parameters.put("tt", tt);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        CustomJasperViewer customViewer = new CustomJasperViewer(jasperPrint); // Sử dụng CustomJasperViewer thay vì JasperViewer
        customViewer.setVisible(true); // Hiển thị cửa sổ báo cáo

    }

    private void btnXacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacnhanActionPerformed
        // TODO add your handling code here:
        String makh = this.lbMakh.getText();

        if (makh == null || makh.trim().isEmpty()) {
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Chưa có thông tin khách hàng");
            alert.setVisible(true);
        } else {
            if (this.tblProduct.getRowCount() == 0) {
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng chọn sản phẩm ");
                alert.setVisible(true);
            } else {
                productBUS product = new productBUS();
                for (int row = 0; row < this.tblProduct.getRowCount(); row++) {
                    Object ID = model.getValueAt(row, 0);
                    String id = ID.toString();
                    Object SL = model.getValueAt(row, 3);
                    int sl = (int) SL;
                    try {
                        if (product.compareQuantity(id, sl) == 0) {
                            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Số lượng sản phẩm " + id + " không đủ");
                            alert.setVisible(true);
                            return;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                this.btnXacnhan.hide();
                this.btnHuy.show();
                this.lbXemkm.show();
                this.btnChon.hide();
                this.btnXoa.hide();
                this.btnSua.hide();
                this.txtSp.hide();
                this.lbsl.hide();
                this.btnThanhtoan.show();
                this.btnAddkh.hide();
                this.txtTiennhan.setVisible(true);
                //object [] o;
                tblProduct.clearSelection();
                s = 0;
                sum = 0;

                for (int row = tblProduct.getRowCount() - 1; row >= 0; row--) {

                    int tinhkm = 0;
                    Object id = model.getValueAt(row, 0);
                    String productID = id.toString();
                    Object sl = model.getValueAt(row, 3);
                    Object g = model.getValueAt(row, 4);
                    int sL = ((Integer) sl).intValue();
                    int gia = ((Integer) g).intValue();
                    int giasp = sL * gia;
                    sum = sum + giasp;
                    System.out.println(sum);
                    tinhkm = Tinh(productID, sL, gia);
                    //float per = 0;
                    if (tinhkm < giasp) {
                        s = s + tinhkm;

                    }

                }

                tt = sum - s;
                String ss = formatMoney(s);
                this.lbKm.setText(ss);
                String tongTien = formatMoney(sum);
                lbTongtien.setText(tongTien);
                String thanhToan = formatMoney(tt);
                lbThanhtoan.setText(thanhToan);

            }

        }

    }//GEN-LAST:event_btnXacnhanActionPerformed

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:

        this.btnChon.setVisible(true);
        this.btnXoa.setVisible(true);
        this.btnSua.setVisible(true);
        this.txtSp.setVisible(true);
        this.btnXuathd.hide();
        this.btnXacnhan.setVisible(true);
        this.btnAddkh.setVisible(true);
        this.txtSdt.setText("");
        this.lbMakh.setText(" ");
        this.lbKm.setText(" ");
        this.lbXemkm.hide();
        this.lbTenkhach.setText(" ");
        this.lbThanhtoan.setText(" ");
        this.lbTongtien.setText(" ");
        this.lbKm.setText(" ");
        receptBUS receipt = new receptBUS();
        String mhd = receipt.createId();
        this.lbhd.setText(mhd);
        this.lbTenkh.setText(" ");
        this.txtTiennhan.setText(" ");
        this.txtTiennhan.setVisible(false);
        this.lbTienthua.setText(" ");
        model.setRowCount(0);
        this.btnThanhtoan.hide();
        this.btnXacnhan.show();


    }//GEN-LAST:event_btnLammoiActionPerformed

    private void lbXemkmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbXemkmMouseClicked
        showkm km = new showkm();
        km.setVisible(true);
        int tinhkm = 0;
        DefaultTableModel modelShowKM = (DefaultTableModel) km.tblkm.getModel();
        for (int row = tblProduct.getRowCount() - 1; row >= 0; row--) {
            Object id = model.getValueAt(row, 0);
            String productID = id.toString();
            Object sl = model.getValueAt(row, 3);
            Object g = model.getValueAt(row, 4);
            int sL = ((Integer) sl).intValue();
            int gia = ((Integer) g).intValue();
            int giasp = sL * gia;
            tinhkm = Tinh(productID, sL, gia);
            Object[] newFormRow = new Object[6];
            newFormRow[0] = id; // Mã sản phẩm
            newFormRow[1] = g; // Giá gốc
            float per = 0;
            promotion_detailBUS proBUS = new promotion_detailBUS();
            try {
                per = proBUS.promotion_percent(productID);
            } catch (SQLException ex) {
                Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
            }
            Float perObject = Float.valueOf(per);
            newFormRow[2] = perObject; // Tỉ lệ khuyến mãi
            newFormRow[3] = sl; // Số lượng
            int tkm = giasp - tinhkm;
            Integer tinhkmObject = Integer.valueOf(tinhkm);
            Integer tienkmbject = Integer.valueOf(tkm);
            newFormRow[4] = tinhkmObject; // Số tiền được giảm giá
            newFormRow[5] = tienkmbject;
            modelShowKM.addRow(newFormRow);

        }

    }//GEN-LAST:event_lbXemkmMouseClicked

    private void txtSdtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSdtKeyReleased
        // TODO add your handling code here:
        this.customerBUS = new customerBUS();
        String sdt = this.txtSdt.getText();
        int check = 0;
        if (sdt.length() == 10) {
            customerDTO cus = new customerDTO();
            try {
                cus = customerBUS.searchsdt(sdt);
                if (cus != null) {
                    this.lbMakh.show();
                    this.lbTenkh.show();
                    this.lbMakh.setText(cus.getCusID());
                    this.lbTenkh.setText(cus.getFirstName() + " " + cus.getLastName());
                    this.lbTenkhach.setText(cus.getFirstName() + " " + cus.getLastName());
                    this.lbtenk.show();
                    this.lbma.show();
                    this.lbdt.hide();
                    this.lbkt.hide();
                } else {
                    this.lbtenk.hide();
                    this.lbTenkh.hide();
                    this.lbMakh.hide();
                    this.lbma.hide();
                    this.lbdt.hide();
                    this.lbkt.show();
                }

            } catch (SQLException ex) {
                Logger.getLogger(TestSell.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            this.lbtenk.hide();
            this.lbma.hide();
            this.lbTenkh.hide();
            this.lbMakh.hide();
            this.lbkt.hide();
            this.lbdt.show();
        }

    }//GEN-LAST:event_txtSdtKeyReleased

    private void txtSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSpActionPerformed


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
    private javax.swing.JLabel lbSdt5;
    private javax.swing.JLabel lbSdt6;
    private javax.swing.JLabel lbSdt8;
    private javax.swing.JLabel lbSdt9;
    public javax.swing.JLabel lbTenkh;
    private javax.swing.JLabel lbTenkhach;
    private javax.swing.JLabel lbThanhtoan;
    private javax.swing.JLabel lbTienthua;
    private javax.swing.JLabel lbTongtien;
    private javax.swing.JLabel lbXemkm;
    private javax.swing.JLabel lbdt;
    private javax.swing.JLabel lbhd;
    private javax.swing.JLabel lbkt;
    private javax.swing.JLabel lbma;
    private javax.swing.JLabel lbsl;
    private javax.swing.JLabel lbtenk;
    public javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSp;
    private javax.swing.JTextField txtTiennhan;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
