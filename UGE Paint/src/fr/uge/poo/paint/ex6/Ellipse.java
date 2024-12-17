package fr.uge.poo.paint.ex6;

import java.awt.*;
import java.util.Objects;

public class Ellipse implements Shape {
    private final Integer[] coords;
    private Color color = Color.BLACK;

    public Ellipse(final Integer[] coords) {
        Objects.requireNonNull(coords);
        this.coords = coords;
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(color);
        graphics.drawOval(coords[0], coords[1], coords[2], coords[3]);
    }

    @Override
    public double distance(int x, int y) {
        int x0 = (coords[0] + coords[0] + coords[2]) / 2;
        int y0 = (coords[1] + coords[1] + coords[3]) / 2;
        return Math.sqrt(Math.pow(x0 - x, 2) + Math.pow(y0 - y, 2));
    }

    @Override
    public void setColor(Color color) {
        Objects.requireNonNull(color);
        this.color = color;
    }

    @Override
    public int getMaxX() {
        return coords[0]+coords[2];
    }

    @Override
    public int getMaxY() {
        return  coords[1]+coords[3];
    }
}
