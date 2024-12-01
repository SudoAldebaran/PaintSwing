package Paint;

import java.awt.*;

class Triangle extends Shape {
    private int x2, y2;

    public Triangle(int x, int y, Color color) {
        super(x, y, color);
    }

    public void update(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        int[] xPoints = {x, x2, (x + x2) / 2};
        int[] yPoints = {y, y2, y - Math.abs(y2 - y)};
        g.drawPolygon(xPoints, yPoints, 3);
    }

    public boolean contains(int px, int py) {
        // Coords des sommets du triangle
        int x3 = (x + x2) / 2;
        int y3 = y - Math.abs(y2 - y);

        // Vérifier si le point (px, py) est dans le triangle
        return isPointInTriangle(px, py, x, y, x2, y2, x3, y3);
    }

    private boolean isPointInTriangle(int px, int py, int x1, int y1, int x2, int y2, int x3, int y3) {
        // Calcul des aires des sous-triangles
        double areaOrig = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
        double area1 = Math.abs(px * (y2 - y3) + x2 * (y3 - py) + x3 * (py - y2)) / 2.0;
        double area2 = Math.abs(x1 * (py - y3) + px * (y3 - y1) + x3 * (y1 - py)) / 2.0;
        double area3 = Math.abs(x1 * (y2 - py) + x2 * (py - y1) + px * (y1 - y2)) / 2.0;

        // Vérifier si la somme des sous-triangles est égale à l'aire originale
        return Math.abs(areaOrig - (area1 + area2 + area3)) < 0.1; // Tolérance pour les erreurs de calcul
    }
}
