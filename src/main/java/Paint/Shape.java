package Paint;

import java.awt.*;

// CLASSE ABSTRAITE POUR LES FORMES
abstract class Shape {
    protected int x, y;
    protected Color color;

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract void draw(Graphics g);
    public abstract void update(int x2, int y2);
    public abstract boolean contains(int x, int y);
}
