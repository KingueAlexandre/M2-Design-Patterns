package fr.uge.poo.paint.ex5;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.util.List;
import java.util.Objects;

public class Drawing {
    private final List<Shape> shapes;
    private int posNear = -1;

    public Drawing(List<Shape> shapes) {
        Objects.requireNonNull(shapes);
        this.shapes = shapes;
    }

    public void drawAll(SimpleGraphics area) {
        area.render(graphics2D -> {
            shapes.forEach(shape -> {
                shape.draw(graphics2D);
            });
        });
    }

    public void callback(SimpleGraphics area, int x, int y) {
        var shape = shapes.stream().min((a,b) -> Double.compare(a.distance(x, y), b.distance(x, y))).get();
        var pos = shapes.indexOf(shape);
        shape.setColor(Color.ORANGE);
        System.out.println(shape);
        System.out.println(pos);
        System.out.println(shapes);
        if(posNear != -1) {
            shapes.get(posNear).setColor(Color.BLACK);
        }
        area.clear(Color.WHITE);
        posNear = pos;
        drawAll(area);
    }
}
