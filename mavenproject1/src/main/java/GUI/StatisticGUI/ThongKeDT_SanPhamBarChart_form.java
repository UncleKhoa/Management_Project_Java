/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.StatisticGUI;

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
import BUS.doanhthuBUS;
/**
 *
 * @author Bon Nguyen
 */
public class ThongKeDT_SanPhamBarChart_form extends javax.swing.JFrame {
    Font font = new Font("Segoe UI", Font.BOLD, 16);    
    private ArrayList<doanhthuDTO> dt_sp_chart;
    doanhthuBUS doanhthuBUS;
    /**
     * Creates new form ThongKeDT_SanPhamBarChart_form
     */
    public ThongKeDT_SanPhamBarChart_form() {
        initComponents();
        setLocationRelativeTo(null);
        doanhthuBUS doanhthuBUS = new doanhthuBUS();
        dt_sp_chart = doanhthuBUS.getList_DTSP_Chart();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (doanhthuDTO dtsp : dt_sp_chart) {
            String productName = dtsp.getProductName();
            double revenue = dtsp.getTiensauKM();
            dataset.setValue(revenue, "Doanh thu", productName);
        }
        
        JFreeChart chart = ChartFactory.createBarChart("Sản phẩm", "", "Doanh thu", dataset, PlotOrientation.VERTICAL, false, true, false);
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
        chartPanel.setSize(513, 410);
        
        pannelDTSP.add(chartPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pannelDTSP = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pannelDTSP.setPreferredSize(new java.awt.Dimension(513, 410));

        javax.swing.GroupLayout pannelDTSPLayout = new javax.swing.GroupLayout(pannelDTSP);
        pannelDTSP.setLayout(pannelDTSPLayout);
        pannelDTSPLayout.setHorizontalGroup(
            pannelDTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        pannelDTSPLayout.setVerticalGroup(
            pannelDTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pannelDTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pannelDTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongKeDT_SanPhamBarChart_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeDT_SanPhamBarChart_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeDT_SanPhamBarChart_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeDT_SanPhamBarChart_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeDT_SanPhamBarChart_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pannelDTSP;
    // End of variables declaration//GEN-END:variables
}
