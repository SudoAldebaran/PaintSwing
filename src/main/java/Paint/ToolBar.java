package Paint;

import javax.swing.*;
import java.awt.*;

// BARRE D'OUTILS
class ToolBar extends JPanel {
    public ToolBar(PaintPanel paintPanel) {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Sélecteur de couleur
        JButton colorButton = new JButton("Couleur");
        colorButton.addActionListener(e -> {
            Color color = JColorChooser.showDialog(this, "Choisir une couleur", paintPanel.getCurrentColor());
            if (color != null) paintPanel.setCurrentColor(color);
        });

        add(colorButton);

        // Modes de dessin
        String[] modes = {"Pinceau", "Rectangle", "Cercle", "Triangle", "Suppression de forme"};
        JComboBox<String> modeSelector = new JComboBox<>(modes);
        modeSelector.addActionListener(e -> paintPanel.setDrawingMode((String) modeSelector.getSelectedItem()));
        add(modeSelector);
    }
}
