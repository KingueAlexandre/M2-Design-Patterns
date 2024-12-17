package fr.uge.poo.paint.ex7;

import fr.uge.poo.simplegraphics.SimpleGraphics;
import fr.uge.poo.paint.ex7.Canvas.CanvaColor;


import java.util.List;
import java.util.Objects;

import fr.uge.poo.paint.ex7.Canvas.CanvaColor;

public class Drawing {
    private final List<Shape> shapes;
    private Shape currentShape = null;
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

    public void drawAll(Canvas canva){
        shapes.forEach(e->{
            if(currentShape != null && !currentShape.equals(e)){
                e.draw(canva,CanvaColor.BLACK);
            }else if(currentShape != null){
                e.draw(canva,CanvaColor.ORANGE);
            }
        });
    }


    public void callback(Canvas area, int x, int y) {
        var shape = shapes.stream().min((a,b) -> Double.compare(a.distance(x, y), b.distance(x, y))).get();
        currentShape = shape;
        area.clear(CanvaColor.WHITE);
        drawAll(area);
    }


    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
