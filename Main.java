import java.awt.*;
import javax.swing.*;
import com.cezarydanilowski.*;

/**
 * @autor Cezary Daniłowski
 * @version v1.0
 */

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            DieteticFrame frame = new DieteticFrame();
            frame.setSize(new Dimension(500, 300));
            frame.setLocation(450, 200);
            frame.setTitle("E-Dietetic");
            frame.setIconImage(new ImageIcon("icon.png").getImage());
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
