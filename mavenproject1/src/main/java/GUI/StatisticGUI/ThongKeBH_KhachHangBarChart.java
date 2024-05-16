/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.StatisticGUI;

import BUS.banhangBUS;
import BUS.doanhthuBUS;
import DTO.customerDTO;
import DTO.doanhthuDTO;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Bon Nguyen
 */
public class ThongKeBH_KhachHangBarChart extends javax.swing.JPanel {
    Font font = new Font("Segoe UI", Font.PLAIN, 15); 
    private ArrayList<customerDTO> bh_kh_chart;
    banhangBUS banhangBUS;
    /**
     * Creates new form ThongKeBH_KhachHang_Chart
     */
    public ThongKeBH_KhachHangBarChart() {
        initComponents();
        banhangBUS banhangBUS = new banhangBUS();
        bh_kh_chart = banhangBUS.Get_ListBHKH_Chart();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (customerDTO bh_kh : bh_kh_chart) {
            String cusid = bh_kh.getCusID();
            double revenue = bh_kh.getTongtien();
            dataset.setValue(revenue, "Số tiền đã mua", cusid);
        }
        
        JFreeChart chart = ChartFactory.createBarChart("Top 5 khách hàng có tổng tiền mua cao", "", "Số tiền", dataset, PlotOrientation.VERTICAL, false, true, false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.black);
        chart.getTitle().setFont(font);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.red);
        
        // Lấy đối tượng NumberAxis của trục y và thiết lập định dạng số
        NumberAxis yAxis = (NumberAxis) p.getRangeAxis();
        yAxis.setNumberFormatOverride(java.text.NumberFormat.getInstance());     
        CategoryAxis domainAxis = p.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(507, 420);
        
        pannelBHKH.add(chartPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pannelBHKH = new javax.swing.JPanel();

        javax.swing.GroupLayout pannelBHKHLayout = new javax.swing.GroupLayout(pannelBHKH);
        pannelBHKH.setLayout(pannelBHKHLayout);
        pannelBHKHLayout.setHorizontalGroup(
            pannelBHKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        pannelBHKHLayout.setVerticalGroup(
            pannelBHKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pannelBHKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pannelBHKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pannelBHKH;
    // End of variables declaration//GEN-END:variables
}
