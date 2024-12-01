package Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// ZONE DE DESSIN
class PaintPanel extends JPanel {
    private Color currentColor = Color.BLACK;
    private Color gommeBlanche = Color.WHITE;
    private String drawingMode = "Pinceau";
    private ArrayList<Shape> shapes = new ArrayList<>();
    private Shape currentShape = null;

    public PaintPanel() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                switch (drawingMode) {
                    case "Rectangle":
                        currentShape = new Rectangle(e.getX(), e.getY(), currentColor);
                        break;
                    case "Cercle":
                        currentShape = new Cercle(e.getX(), e.getY(), currentColor);
                        break;
                    case "Triangle":
                        currentShape = new Triangle(e.getX(), e.getY(), currentColor);
                        break;
                    case "Suppression de forme":
                        removeShapeAt(e.getX(), e.getY());
                        repaint();
                        return;
                    default: // Pinceau
                        currentShape = new FreehandShape(e.getX(), e.getY(), currentColor);
                        break;
                }
                if (currentShape != null) shapes.add(currentShape);
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (drawingMode.equals("Pinceau") && currentShape instanceof FreehandShape) {
                    ((FreehandShape) currentShape).addPoint(e.getX(), e.getY());
                } else if (currentShape != null) {
                    currentShape.update(e.getX(), e.getY());
                }
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                currentShape = null;
            }
        });
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setDrawingMode(String mode) {
        this.drawingMode = mode;
    }

    private void removeShapeAt(int x, int y) {
        shapes.removeIf(shape -> shape.contains(x, y));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}