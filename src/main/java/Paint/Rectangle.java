package Paint;

import java.awt.*;

// FORMES SIMPLES
class Rectangle extends Shape {
    private int width, height;

    public Rectangle(int x, int y, Color color) {
        super(x, y, color);
    }

    public void update(int x2, int y2) {
        width = Math.abs(x2 - x);
        height = Math.abs(y2 - y);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }

    public boolean contains(int x, int y) {
        return x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height;
    }
}