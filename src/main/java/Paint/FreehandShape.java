package Paint;

import java.awt.*;
import java.util.ArrayList;

// DESSIN A MAIN LEVÉ
class FreehandShape extends Shape {
    private ArrayList<Point> points = new ArrayList<>();

    public FreehandShape(int x, int y, Color color) {
        super(x, y, color);
        points.add(new Point(x, y));
    }

    public void addPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    public void draw(Graphics g) {
        g.setColor(color);
        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    public void update(int x2, int y2) {
        // Non utilisé pour le pinceau
    }

    public boolean contains(int x, int y) {
        return false; // Simplifié
    }
}
