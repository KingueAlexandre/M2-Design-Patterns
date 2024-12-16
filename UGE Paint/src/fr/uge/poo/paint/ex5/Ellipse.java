package fr.uge.poo.paint.ex5;

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
        return Math.sqrt(Math.pow(coords[0] - x, 2) + Math.pow(coords[1] - y, 2));
    }

    @Override
    public void setColor(Color color) {
        Objects.requireNonNull(color);
        this.color = color;
    }
}
