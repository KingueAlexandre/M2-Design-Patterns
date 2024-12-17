package fr.uge.poo.paint.ex7;

import java.awt.*;
import java.util.Objects;

public class Ellipse implements Shape {
    private final Integer[] coords;

    public Ellipse(final Integer[] coords) {
        Objects.requireNonNull(coords);
        this.coords = coords;
    }

    @Override
    public void draw(Canvas graphics, Canvas.CanvaColor color) {
        graphics.drawEllipse(coords[0], coords[1], coords[2], coords[3], color);

    }

    @Override
    public double distance(int x, int y) {
        int x0 = (coords[0] + coords[0] + coords[2]) / 2;
        int y0 = (coords[1] + coords[1] + coords[3]) / 2;
        return Math.sqrt(Math.pow(x0 - x, 2) + Math.pow(y0 - y, 2));
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
