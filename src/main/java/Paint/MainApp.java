package Paint;

import javax.swing.*;
import java.awt.*;

// CLASSE PRINCIPALE
public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Paint Like");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1400, 800);

            PaintPanel paintPanel = new PaintPanel();
            ToolBar toolBar = new ToolBar(paintPanel);

            frame.add(toolBar, BorderLayout.NORTH);
            frame.add(paintPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}