package fr.uge.poo.paint.ex6;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.util.List;
import java.util.Objects;

public class Drawing {
    private final List<Shape> shapes;
    private int maxX;
    private int maxY;
    private int posNear = -1;

    public Drawing(List<Shape> shapes) {
        Objects.requireNonNull(shapes);
        this.shapes = shapes;
        this.maxX = shapes.stream().map(Shape::getMaxX).max(Integer::compareTo).get();
        this.maxY = shapes.stream().map(Shape::getMaxY).max(Integer::compareTo).get();
        if(maxX < 500){
            this.maxX = 500;
        }
        if(this.maxY < 500){
            this.maxY = 500;
        }
        System.out.println("maxX: " + maxX);
        System.out.println("maxY: " + maxY);
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
        if(posNear != -1) {
            shapes.get(posNear).setColor(Color.BLACK);
        }
        shape.setColor(Color.ORANGE);
        area.clear(Color.WHITE);
        posNear = pos;
        drawAll(area);
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
