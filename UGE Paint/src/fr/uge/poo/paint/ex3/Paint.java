package fr.uge.poo.paint.ex3;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;


public class Paint {
    public static void main(String[] args) throws IOException {
        var parse = new ParseFileToArray("draw2.txt");
        SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);
//        area.render(SimpleGraphicsExample::drawAll);

        var lstshapes = Shape.getShapes(parse.getLinesInFile());
        area.render(graphics2D -> {
            graphics2D.setColor(Color.BLACK);
            lstshapes.forEach(shape -> {
               shape.draw(graphics2D);
           });
        });
    }

}
