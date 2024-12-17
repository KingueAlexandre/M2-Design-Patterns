package fr.uge.poo.paint.ex7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.uge.poo.paint.ex7.Canvas.CanvaColor;


public interface Shape {
    public void draw(Canvas graphics, CanvaColor color);
    public double distance(int x, int y);
    public int getMaxX();
    public int getMaxY();
    static List<Shape> getShapes(List<String> lines) {
        var shapes = new ArrayList<Shape>();
        lines.forEach(line -> {
            System.out.println(line);
            String[] tokens = line.split(" ");
            Integer[] coords = Arrays.stream(Arrays.copyOfRange(tokens, 1, tokens.length)).map(Integer::parseInt).toArray(Integer[]::new);
            switch (tokens[0]) {
                case "line": shapes.add(new Line(coords)); break;
                case "rectangle": shapes.add(new Rectangle(coords)); break;
                case "ellipse":shapes.add(new Ellipse(coords)); break;
                default: break;
            }

        });
        return shapes;
    }
}
