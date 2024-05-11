import javax.swing.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;

public class CustomJasperViewer extends JFrame {
    private JasperViewer jasperViewer;

    public CustomJasperViewer(JasperPrint jasperPrint) {
        super("Custom JasperViewer");
        jasperViewer = new JasperViewer(jasperPrint, false);
        add(jasperViewer.getContentPane());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void closeViewer() {
        // Đóng cửa sổ JasperViewer
        jasperViewer.setVisible(false);
        // Giải phóng tài nguyên liên quan đến JasperViewer
        jasperViewer.dispose();
        // Đóng cửa sổ tùy chỉnh
       // dispose();
    }

    public static void main(String[] args) {
        // Code mẫu để hiển thị báo cáo
        JasperPrint jasperPrint = null; // Thay thế bằng đối tượng JasperPrint thực tế của bạn
        CustomJasperViewer customViewer = new CustomJasperViewer(jasperPrint);
        customViewer.setVisible(true);
        // Sau khi người dùng đóng cửa sổ tùy chỉnh, bạn có thể gọi customViewer.closeViewer() để đóng JasperViewer.
    }
}
