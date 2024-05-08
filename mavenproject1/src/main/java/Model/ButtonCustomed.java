package Model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class ButtonCustomed extends JButton {

    private Color background = new Color(69, 191, 71);
    private Color colorHover = new Color(242, 242, 242);
    private Color colorPressed = new Color(242, 242, 242);
    private boolean mouseOver = false;

    public ButtonCustomed() {
        this.setForeground(Color.WHITE);
        init();
    }

    public ButtonCustomed(String Text) {
        setText(Text);
        ButtonCustomed.super.setForeground(Color.WHITE);
        init();
    }

    private void init() {
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(background);
        setForeground(Color.WHITE);
        
        setOpaque(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                setForeground(Color.BLACK);
                ButtonCustomed.super.setBackground(getColorHover());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
                setForeground(Color.WHITE);
                ButtonCustomed.super.setBackground(background);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                ButtonCustomed.super.setBackground(getColorPressed());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (mouseOver) {
                    ButtonCustomed.super.setBackground(getColorHover());
                } else {
                    ButtonCustomed.super.setBackground(background);
                }
            }
            
        });
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Gọi phương thức doClick() để kích hoạt sự kiện nhấp chuột giống như khi button được nhấn
                    doClick();
                }
            }
        });
    }

    @Override
    public void setBackground(Color bg) {
        
        background = bg;
        super.setBackground(bg);
    }
    
    @Override
    public void setForeground(Color bg){
        super.setForeground(bg);
    }

    public Color getColorHover() {
        return colorHover;
    }

    public void setColorHover(Color colorHover) {
        this.colorHover = colorHover;
    }

    public Color getColorPressed() {
        return colorPressed;
    }

    public void setColorPressed(Color colorPressed) {
        this.colorPressed = colorPressed;
    }

}