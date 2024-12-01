package Paint;

import java.awt.*;

class Cercle extends Shape {
    private int radius;

    public Cercle(int x, int y, Color color) {
        super(x, y, color);
    }

    public void update(int x2, int y2) {
        radius = (int) Math.hypot(x2 - x, y2 - y);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    public boolean contains(int x, int y) {
        return Math.hypot(x - this.x, y - this.y) <= radius;
    }
}

