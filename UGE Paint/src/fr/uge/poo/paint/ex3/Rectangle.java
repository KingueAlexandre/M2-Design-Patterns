package fr.uge.poo.paint.ex3;

import java.awt.*;
import java.util.Objects;

public class Rectangle implements Shape{
    private final Integer[] coords;
    public Rectangle(final Integer[] coords) {
        Objects.requireNonNull(coords);
        this.coords = coords;
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawLine(coords[0], coords[1], coords[2], coords[3]);
    }
}
