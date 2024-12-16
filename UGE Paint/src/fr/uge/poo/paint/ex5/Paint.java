package fr.uge.poo.paint.ex5;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;


public class Paint {
    public static void main(String[] args) throws IOException {
        var parse = new ParseFileToArray("draw2.txt");
        SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);
//        area.render(SimpleGraphicsExample::drawAll);
        var lstshapes = Shape.getShapes(parse.getLinesInFile());
        var draw = new Drawing(lstshapes);
        draw.drawAll(area);
        area.waitForMouseEvents((x, y) -> draw.callback(area, x, y));
    }

}
