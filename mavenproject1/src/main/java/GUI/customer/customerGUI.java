/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.customer;
import BUS.customerBUS;
import DTO.customerDTO;
import DAO.customerDAO;
import Model.CustomConfirmDialog;
import Model.MyMessageAlert;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import BUS.receptBUS;
import Model.CustomHeaderRenderer;
import static Model.helpers.Export_Excell;
import static Model.helpers.convertBackgroundOfTable;
import java.text.ParseException;
import Model.CustomTableCellRenderer;
import Model.NonEditableTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.table.JTableHeader;
/**
 *
 * @author Lenovo
 */
public class customerGUI extends javax.swing.JPanel {
    private ArrayList <customerDTO> list = new ArrayList<>();
    private customerBUS customerBUS = new customerBUS();
    private customerDAO customerDAO= new customerDAO();
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private JFrame parentFrame;
    private receptBUS receptBUS= new receptBUS();
    /**
     * Creates new form customer2
     */
    public customerGUI() {
        initComponents();
        customerBUS = new customerBUS();
        list= customerBUS.getList();
        
        model = (DefaultTableModel) cusTable.getModel(); 
        model2 = (DefaultTableModel) receiptTable.getModel(); ;
        
        viewData(list);
        viewIcon();
        
        resetdata();
        convertBackgroundOfTable(cusTable);
        convertBackgroundOfTable(receiptTable);
        exportHD.setVisible(false);
        
        JTableHeader header = cusTable.getTableHeader();
        header.setDefaultRenderer(new CustomHeaderRenderer());
        JTableHeader header2 = receiptTable.getTableHeader();
        header2.setDefaultRenderer(new CustomHeaderRenderer());
    } 
    public void viewIcon(){
        //search icon
        File file = new File("");
        String currentDirectory = file.getAbsolutePath();
        String relativePath = currentDirectory + "\\src\\main\\java\\IMG\\"; // Đường dẫn tương đối
        ImageIcon imageIcon = new ImageIcon(relativePath+"search.png");
        searchIcon.setIcon(imageIcon);
    }
    public void addLineData(customerDTO i)
    {
     model.addRow(new Object[]{
         i.getCusID(),i.getFirstName(),i.getLastName(),i.getGender(),i.getPhoneNumber(),i.getGmail(),i.getAddress()
           
     });   
    }
    public void viewData(ArrayList<customerDTO> list){
        convertBackgroundOfTable(cusTable);
        String[] headers = {"Mã KH", "Họ", "Tên", "Giới Tính","SDT","Gmail","Địa chỉ"}; // Đặt tiêu đề cột của bảng
        model = new NonEditableTableModel(new Object[0][headers.length], headers);
        cusTable.setModel(model);
        cusTable.setRowHeight(30);
        CustomTableCellRenderer centerRenderer = new CustomTableCellRenderer();
        cusTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        cusTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        cusTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        cusTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        cusTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        cusTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        cusTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        cusTable.getColumnModel().getColumn(2).setPreferredWidth(50);

        removeData();
        for (customerDTO i:list){
            addLineData(i); 
        }
        headline.setText("Quản lý khách hàng");
        headline2.setText("Khách hàng: "+list.size());
      }
    public void viewdata2(){
        String[] headers = {"Mã đơn", "Mã nhân viên", "Mã khách", "Ngày tạo đơn", "Tổng tiền"}; // Đặt tiêu đề cột của bảng
        model = new NonEditableTableModel(new Object[0][headers.length], headers);
                int selectRow = cusTable.getSelectedRow();
        customerDTO cus = list.get(selectRow);
        viewInformation(cus);
        id.setFocusable(false);
        
        
        try {
            //receipt
            receptBUS.viewTableReceipt(cus.getCusID(), receiptTable);
            exportHD.setVisible(true);
            
        } catch (ParseException ex) {
            Logger.getLogger(customerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeData(){
        int rowCount = model.getRowCount();
        for (int i=rowCount-1;i>=0;i--){
            model.removeRow(i);
        }
    }
    public customerDTO getTextField(){
        Boolean check=true;
        customerDTO cus = new customerDTO();
        cus.setCusID(id.getText());
        cus.setFirstName(fname.getText());
        if (!(checkString(fname.getText()) ==1 )) check=false;
        
        cus.setLastName(lname.getText());
        if (!(checkString(lname.getText()) ==1 )) check=false;
        
        nam.setActionCommand("Nam");
        nu.setActionCommand("Nữ");
        cus.setGender(gender.getSelection().getActionCommand());
        cus.setPhoneNumber(phonenumber.getText());
        if (!(checkString(phonenumber.getText()) ==2 )) check=false;
        cus.setGmail(gmail.getText());
        if (gmail.getText().equals(""))   check = false;
        cus.setAddress(address.getText());
        if (address.getText().equals(""))   check = false;
        if (check == false){
            
             MyMessageAlert alert = new MyMessageAlert(parentFrame, "Dữ liệu không hợp lệ!");
            alert.setVisible(true);
           return null;
        }
        return cus;
      
    }
    public void viewInformation(customerDTO cus){
        id.setText(cus.getCusID());
        fname.setText(cus.getFirstName());
        lname.setText(cus.getLastName());
        if (cus.getGender().equals("Nam"))
            nam.setSelected(true);
        else 
            nu.setSelected(true);
        phonenumber.setText(cus.getPhoneNumber());
        gmail.setText(cus.getGmail());
        address.setText(cus.getAddress());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        gender = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        id = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        phonenumber = new javax.swing.JTextField();
        gmail = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        nam = new javax.swing.JRadioButton();
        nu = new javax.swing.JRadioButton();
        nhacnho = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        headline = new javax.swing.JLabel();
        searchField = new javax.swing.JFormattedTextField();
        reset = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        searchIcon = new javax.swing.JLabel();
        headline2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exportHD = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        receiptTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        cusTable = new javax.swing.JTable();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel2.setText("Chi tiết người dùng");

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(21, 21, 21))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id.setPreferredSize(new java.awt.Dimension(250, 40));

        fname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fname.setPreferredSize(new java.awt.Dimension(250, 40));
        fname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fnameFocusLost(evt);
            }
        });
        fname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fnameMouseExited(evt);
            }
        });
        fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fnameKeyTyped(evt);
            }
        });

        lname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lname.setPreferredSize(new java.awt.Dimension(250, 40));
        lname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lnameFocusLost(evt);
            }
        });
        lname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lnameMouseExited(evt);
            }
        });
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });

        phonenumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phonenumber.setPreferredSize(new java.awt.Dimension(250, 40));
        phonenumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                phonenumberFocusLost(evt);
            }
        });
        phonenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonenumberActionPerformed(evt);
            }
        });

        gmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gmail.setPreferredSize(new java.awt.Dimension(250, 40));
        gmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gmailActionPerformed(evt);
            }
        });

        address.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        address.setPreferredSize(new java.awt.Dimension(250, 40));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });

        jLabel3.setText("Mã KH");

        jLabel4.setText("Tên");

        jLabel5.setText("Họ");

        jLabel6.setText("Giới tính");

        jLabel7.setText("Số điện thoại");

        jLabel8.setText("Gmaill");

        jLabel9.setText("Địa chỉ");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        edit.setBackground(new java.awt.Color(0, 102, 51));
        edit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setText("Lưu");
        edit.setPreferredSize(new java.awt.Dimension(110, 30));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(153, 0, 0));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Xóa");
        delete.setPreferredSize(new java.awt.Dimension(110, 30));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(0, 102, 102));
        update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Cập nhập");
        update.setPreferredSize(new java.awt.Dimension(110, 30));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        gender.add(nam);
        nam.setText("Nam");

        gender.add(nu);
        nu.setText("Nữ");
        nu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nhacnho)
                                    .addComponent(phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(nam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nu)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nam)
                    .addComponent(nu))
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phonenumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nhacnho)
                .addGap(8, 8, 8)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        headline.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        headline.setText("Quản lý khách hàng");

        searchField.setText("Tìm kiếm ....");
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
        });

        reset.setBackground(new java.awt.Color(102, 0, 102));
        reset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Làm mới");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 0, 102));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Xuất Excel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        searchIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchIconMouseClicked(evt);
            }
        });

        headline2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        headline2.setText("Khách hàng : n");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(headline, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(searchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(headline2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(headline)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headline2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Hóa đơn đã mua");

        exportHD.setBackground(new java.awt.Color(102, 0, 102));
        exportHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exportHD.setForeground(new java.awt.Color(255, 255, 255));
        exportHD.setText("Xuất Excel");
        exportHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exportHD)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(exportHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        receiptTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        receiptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Sản phẩm", "Số lượng", "Giá", "Mã giảm giá"
            }
        ));
        receiptTable.setPreferredSize(new java.awt.Dimension(120, 25));
        jScrollPane2.setViewportView(receiptTable);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cusTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Họ", "Tên", "Giới tính", "SDT", "Gmail", "Địa chỉ"
            }
        ));
        cusTable.setGridColor(new java.awt.Color(255, 255, 255));
        cusTable.setRowHeight(40);
        cusTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cusTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cusTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void phonenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonenumberActionPerformed

    private void gmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gmailActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void editCustomer(customerDTO cus){
        if (cus==null) return;
        customerDAO = new customerDAO();
        try {
            customerDAO.update(cus);
        } catch (SQLException ex) {
            Logger.getLogger(customerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        customerBUS = new customerBUS();
        this.list = customerBUS.getList();
        viewData(list);  
    }
    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        customerDTO cus = getTextField();
        CustomConfirmDialog confirm = new CustomConfirmDialog(parentFrame, "Lưu thông tin", "Bạn có thay đổi thông tin khách hàng " + cus.getCusID(), "close_red.png");
        confirm.setVisible(true);
        if (confirm.getSelected()) {
            editCustomer(cus);
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Sửa thành công!");
            alert.setVisible(true);
        }
    }//GEN-LAST:event_editActionPerformed
    private void addCustomer(){
        customerDTO cus = getTextField();
        if (cus==null) return;
        this.list.add(cus);
        try {
            customerDAO.add(cus);
            viewData(list);
        } catch (SQLException ex) {
            Logger.getLogger(customerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    private void removeCustomer(customerDTO cus){
        list.remove(cus);
        customerDAO = new customerDAO();
        try {
            customerDAO.delete(cus.getCusID());
        } catch (SQLException ex) {
            Logger.getLogger(customerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        viewData(list);        
    }
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int selectRow = cusTable.getSelectedRow();
        if (selectRow == -1){
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Vui lòng chọn nhân viên để xóa!");
            alert.setVisible(true);
             return;
        } 
        customerDTO cus = list.get(selectRow);
        CustomConfirmDialog confirm = new CustomConfirmDialog(parentFrame, "Xác nhận xóa", "Bạn có muốn xóa khách hàng " + cus.getCusID(), "close_red.png");
        confirm.setVisible(true);
        if (confirm.getSelected()) {
            removeCustomer(cus);
            MyMessageAlert alert = new MyMessageAlert(parentFrame, "Xóa thành công!");
            alert.setVisible(true);
        }
    }//GEN-LAST:event_deleteActionPerformed
    private void resetdata(){
        // TODO add your handling code here
        String idname ="";
        if (list.size() <10 ) 
            idname="KH0"+(list.size()+1);
        else idname = "KH"+(list.size()+1);
        id.setText(idname);
        fname.setText("");
        lname.setText("");
        nam.setSelected(true);
        phonenumber.setText("");
        gmail.setText("");
        address.setText("");
        id.setFocusable(false);
    }
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        customerBUS = new customerBUS();
        this.list = customerBUS.getList();
        viewData(list);
    }//GEN-LAST:event_resetActionPerformed

    private void cusTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cusTableMouseClicked
        // TODO add your handling code here:
        viewdata2();
        
    }//GEN-LAST:event_cusTableMouseClicked

    private void exportHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportHDActionPerformed
        // TODO add your handling code here:
         Export_Excell(receiptTable);
    }//GEN-LAST:event_exportHDActionPerformed
    private int checkString(String s){
        boolean hasLetter = false;
        boolean hasDigit = false;

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        if (hasLetter && hasDigit) {
            return 3;
        } else if (hasLetter && !hasDigit) {
            return 1;
        } else {
            return 2;
        }
    }
    private void fnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameKeyTyped

    }//GEN-LAST:event_fnameKeyTyped

    private void fnameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fnameMouseExited
        // TODO add your handling code here:
        System.out.println("da roi khoi o ten");
    }//GEN-LAST:event_fnameMouseExited

    private void fnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fnameFocusLost
        // TODO add your handling code here:
        if (!(checkString(fname.getText()) == 1))
            fname.setForeground( Color.RED);
        else
            fname.setForeground(Color.black);
    }//GEN-LAST:event_fnameFocusLost

    private void lnameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lnameMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameMouseExited

    private void lnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lnameFocusLost
        // TODO add your handling code here:
                if (!(checkString(lname.getText()) == 1))
            lname.setForeground( Color.RED);
        else
            lname.setForeground(Color.black);
    }//GEN-LAST:event_lnameFocusLost

    private void phonenumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phonenumberFocusLost

        if (!(checkString(phonenumber.getText()) == 2))
            {
            phonenumber.setForeground( Color.RED);
            }
        else
        {
            phonenumber.setForeground(Color.black);
        }
        if (phonenumber.getText().length() != 10 )
        {
            nhacnho.setText("Vui lòng nhập đủ 10 số!");
            nhacnho.setForeground(Color.red);
        }
        else{
            nhacnho.setForeground(Color.black);
            nhacnho.setText("");
        }
    }//GEN-LAST:event_phonenumberFocusLost

    private void nuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuActionPerformed

    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        // TODO add your handling code here:
        searchField.setText("");
    }//GEN-LAST:event_searchFieldFocusGained

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Export_Excell(cusTable);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void searchIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchIconMouseClicked
        // TODO add your handling code here:
         if (searchField.getText().equals("")){
            viewData(list);
        }else{
            ArrayList <customerDTO> list2 = customerBUS.search(searchField.getText());
            if (list2.size()==0 ){
                MyMessageAlert alert = new MyMessageAlert(parentFrame, "Không tìm thấy khách hàng ");
                alert.setVisible(true);}
            else{
                removeData();
                this.list= list2;
                viewData(list2);
            }}
    }//GEN-LAST:event_searchIconMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        resetdata();
    }//GEN-LAST:event_updateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTable cusTable;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton exportHD;
    private javax.swing.JTextField fname;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JTextField gmail;
    private javax.swing.JLabel headline;
    private javax.swing.JLabel headline2;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lname;
    private javax.swing.JRadioButton nam;
    private javax.swing.JLabel nhacnho;
    private javax.swing.JRadioButton nu;
    private javax.swing.JTextField phonenumber;
    private javax.swing.JTable receiptTable;
    private javax.swing.JButton reset;
    private javax.swing.JFormattedTextField searchField;
    private javax.swing.JLabel searchIcon;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
