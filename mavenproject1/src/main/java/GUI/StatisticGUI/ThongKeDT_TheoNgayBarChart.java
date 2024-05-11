/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.StatisticGUI;

import BUS.doanhthuBUS;
import DTO.doanhthuDTO;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
public class ThongKeDT_TheoNgayBarChart extends javax.swing.JPanel {
    Font font = new Font("Segoe UI", Font.BOLD, 16);
    private ArrayList<doanhthuDTO> dt_tn_chart;
    doanhthuBUS doanhthuBUS;
    Date start;
    Date end;
    /**
     * Creates new form ThongKeDT_TheoNgayBarChart
     */
    public ThongKeDT_TheoNgayBarChart(Date from, Date to) throws ParseException {
        initComponents();
        doanhthuBUS doanhthuBUS = new doanhthuBUS();
        this.start = from;
        this.end = to;
        dt_tn_chart = doanhthuBUS.getLoiNhuanBanHang_NgayBan_Chart(start, end); 
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (doanhthuDTO dttn : dt_tn_chart) {
            Date date = dttn.getNgayban();
            double revenue = dttn.getTongtien();
            dataset.setValue(revenue, "Doanh thu", date);
        }
        
        JFreeChart chart = ChartFactory.createBarChart("Top 5 ngày có doanh số cao", "", "Doanh thu", dataset, PlotOrientation.VERTICAL, false, true, false);
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
        
        pannelDTTN.add(chartPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pannelDTTN = new javax.swing.JPanel();

        pannelDTTN.setPreferredSize(new java.awt.Dimension(513, 420));

        javax.swing.GroupLayout pannelDTTNLayout = new javax.swing.GroupLayout(pannelDTTN);
        pannelDTTN.setLayout(pannelDTTNLayout);
        pannelDTTNLayout.setHorizontalGroup(
            pannelDTTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        pannelDTTNLayout.setVerticalGroup(
            pannelDTTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pannelDTTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pannelDTTN, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pannelDTTN;
    // End of variables declaration//GEN-END:variables
}