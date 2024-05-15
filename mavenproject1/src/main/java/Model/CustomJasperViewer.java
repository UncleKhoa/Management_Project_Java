package Model;

import javax.swing.*;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class CustomJasperViewer extends JFrame {

    private JRViewer viewer;

    public CustomJasperViewer(JasperPrint jasperPrint) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(950,650);
        viewer = new JRViewer(jasperPrint);
        getContentPane().add(viewer);
//        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    // Phương thức để tắt cửa sổ báo cáo
    public void closeViewer() {
        dispose(); // Đóng cửa sổ
    }

    public static void main(String[] args) {
        // Load your JasperPrint object here
        JasperPrint jasperPrint = null; // Load your JasperPrint object

        SwingUtilities.invokeLater(() -> new CustomJasperViewer(jasperPrint));
    }
}
