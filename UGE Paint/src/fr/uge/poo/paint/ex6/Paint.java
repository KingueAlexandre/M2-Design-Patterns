package fr.uge.poo.paint.ex6;


import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;


public class Paint {
    public static void main(String[] args) throws IOException {
        var parse = new ParseFileToArray("draw-big.txt");
//        area.render(SimpleGraphicsExample::drawAll);
        var lstshapes = Shape.getShapes(parse.getLinesInFile());
        var draw = new Drawing(lstshapes);
        SimpleGraphics area = new SimpleGraphics("area", draw.getMaxX(), draw.getMaxY());
        area.clear(Color.WHITE);
        draw.drawAll(area);
        area.waitForMouseEvents((x, y) -> draw.callback(area, x, y));
    }

}
