package fr.uge.poo.paint.ex2;

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
        Path path = Paths.get("draw1.txt");
        SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);
//        area.render(SimpleGraphicsExample::drawAll);

        try (Stream<String> lines = Files.lines(path)) {

            var lineList =  lines.toList();


            area.render(graphics2D -> {
                graphics2D.setColor(Color.BLACK);
                lineList.forEach(line -> {
                    System.out.println(line);
                    String[] tokens = line.split(" ");
                    System.out.println(Arrays.toString(tokens));
                    int x1 = Integer.parseInt(tokens[1]);
                    int y1 = Integer.parseInt(tokens[2]);
                    int x2 = Integer.parseInt(tokens[3]);
                    int y2 = Integer.parseInt(tokens[4]);
                    graphics2D.drawLine(x1, y1, x2, y2);
                });
            });
        }
    }

}
