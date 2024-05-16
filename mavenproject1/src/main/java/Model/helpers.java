/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Writer;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bon Nguyen
 */
public class helpers {

    static public void addTextChanged(JTextField tf) {

        tf.getDocument().addDocumentListener(new DocumentListener() {
            private void event() {
                Runnable runEvent = new Runnable() {
                    @Override
                    public void run() {

                        String txt = tf.getText().replace(".", "");
                        if (tf.getText() == null || tf.getText().length() == 0) {
                            return;
                        }

                        if (Check_Number(txt)) {
                            txt = String.format(Locale.US, "%,d", Integer.parseInt(txt)).replace(',', '.');
                            tf.setText(txt);
                        } else {
                            tf.setText(tf.getText().substring(0, tf.getText().length() - 1));
                        }
                    }
                };
                SwingUtilities.invokeLater(runEvent);

            }

            public void changedUpdate(DocumentEvent e) {
//                event();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                event();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
//                event();
            }
        }
        );

    }

    static public void convertBackgroundOfTable(JTable table) {
        Color ivory = new Color(255, 255, 255);

        table.setOpaque(true);
        table.setFillsViewportHeight(true);
        table.setBackground(ivory);

    }

    static public void Export_Excell(JTable tableNCC) {
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                //FileWriter out = new FileWriter(file+".xlsx");
                FileOutputStream out = new FileOutputStream(file + ".xls");
                Writer writer = new java.io.OutputStreamWriter((out), "utf8");
                try (BufferedWriter bwrite = new BufferedWriter(writer)) {
                    DefaultTableModel model = (DefaultTableModel) tableNCC.getModel();

                    // ten Cot
                    for (int j = 0; j < tableNCC.getColumnCount(); j++) {
                        bwrite.write(model.getColumnName(j) + "\t");
                    }
                    bwrite.write("\n");

                    // Lay du lieu dong
                    for (int j = 0; j < tableNCC.getRowCount(); j++) {
                        for (int k = 0; k < tableNCC.getColumnCount(); k++) {
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

    static public ArrayList<Object[]> copyTableData(int selectedRow, JTable sourceTable, JTable destinationTable) {
        selectedRow = sourceTable.getSelectedRow();
        ArrayList<Object[]> new_list = new ArrayList<>();
        if (selectedRow != -1) {
            // Lấy dữ liệu từ dòng được chọn
            Object[] rowData = new Object[sourceTable.getColumnCount()];
            for (int i = 0; i < sourceTable.getColumnCount(); i++) {
                rowData[i] = sourceTable.getValueAt(selectedRow, i);
            }

            // Thêm dữ liệu vào bảng đích
            DefaultTableModel model = (DefaultTableModel) destinationTable.getModel();
            model.addRow(rowData);

            Object[] copiedRow = new Object[rowData.length];
            System.arraycopy(rowData, 0, copiedRow, 0, rowData.length);
            new_list.add(copiedRow);

            // Xóa dòng dữ liệu đã thêm
            DefaultTableModel productModel = (DefaultTableModel) sourceTable.getModel();
            productModel.removeRow(selectedRow);

        }
        return new_list;
    }

    static public ArrayList<Object> getItem(ArrayList<Object[]> copiedDataList, ArrayList<Object> newlist) {
        for (Object[] rowData : copiedDataList) {
            newlist.add(rowData);
        }
        return newlist;
    }

    static public ArrayList<String> new_ARR(int t, ArrayList<Object> newList) {
        ArrayList<String> list_add = new ArrayList<>();
        for (Object object : newList) {
            if (object instanceof Object[]) {
                Object[] rowData = (Object[]) object;
                // Kiểm tra xem rowData có đủ phần tử không trước khi truy cập vào phần tử thứ hai
                if (rowData.length > 1) {
//                    System.out.println(rowData[0]);
                    list_add.add(rowData[0].toString());
                } else {
                    System.out.println("Không đủ phần tử trong mảng rowData");
                }
            } else {
                System.out.println("Không phải là một mảng đối tượng");
            }
        }
        return list_add;
    }

    static public boolean Check_Number(String a) {
        if (a.matches("\\d+")) {
            return true;
        }
        return false;
    }

    public static String formatMoney(int amount) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedAmount = formatter.format(amount);
        return formattedAmount.replace(",", ".");
    }

    static public int ConvertDoubleToInt(double a) {
        return (int) a;
    }

    static public boolean Compare_Date(Date date_from, Date date_to) {
        if (date_to.after(date_from) == true) {
            return true;
        } else {
            return false;
        }
    }

    static public String Date_String(Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date);

        return formattedDate;
    }

    static public Date Convert_date(Date date) throws ParseException {
        String date_start = Date_String(date);
        java.util.Date date1 = java.sql.Date.valueOf(date_start);
        return date1;
    }

    static public boolean ComparePrice(int a, int b) {
        return a <= b;
    }

    public static boolean containsDigit(String inputString) {
        for (char c : inputString.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsLetter(String inputString) {
        for (char c : inputString.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }
}
