package fr.uge.poo.paint.ex7;


import fr.uge.poo.paint.ex7.Canvas.CanvaColor;

import java.io.IOException;


public class Paint {
    public static void main(String[] args) throws IOException {
        var parse = new ParseFileToArray("draw-big.txt");
//        area.render(SimpleGraphicsExample::drawAll);
        var lstshapes = Shape.getShapes(parse.getLinesInFile());
        var draw = new Drawing(lstshapes);

        Canvas area;
        if(args.length>=1 && args[0].equals("-legacy")) {
            area = new SimpleGraphicsAdapter("area", draw.getMaxX(),draw.getMaxY());
        }
        else {
            area = new CoolGraphicsAdapter("area",draw.getMaxX(),draw.getMaxY());
        }
        area.clear(CanvaColor.WHITE);
        draw.drawAll(area);
        area.waitForMouseEvents((x, y) -> draw.callback(area, x, y));

    }

}
