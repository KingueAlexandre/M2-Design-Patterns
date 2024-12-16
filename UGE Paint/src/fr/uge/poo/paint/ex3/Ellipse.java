package fr.uge.poo.paint.ex3;

import java.awt.*;
import java.util.Objects;

public class Ellipse implements Shape{
    private final Integer[] coords;
    public Ellipse(final Integer[] coords) {
        Objects.requireNonNull(coords);
        this.coords = coords;
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawOval(coords[0], coords[1], coords[2], coords[3]);
    }
}
