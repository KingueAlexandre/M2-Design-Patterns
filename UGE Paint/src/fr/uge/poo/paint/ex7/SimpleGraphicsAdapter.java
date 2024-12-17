package fr.uge.poo.paint.ex7;

import com.evilcorp.coolgraphics.CoolGraphics;
import com.evilcorp.coolgraphics.CoolGraphics.ColorPlus;
import com.evilcorp.coolgraphics.CoolGraphics.MouseCallback;
import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;

public final class SimpleGraphicsAdapter implements Canvas {

    private final SimpleGraphics graphics;

    SimpleGraphicsAdapter(String name,int width,int height){
        graphics = new SimpleGraphics(name,width,height);
    }

    public void clear(CanvaColor color) {
        graphics.clear(toSimpleGraphicsColor(color));
    }

    @Override
    public void drawLine(int x, int y, int x2, int y2, CanvaColor color) {
        graphics.render (g -> {
            g.setColor(toSimpleGraphicsColor(color));
            g.drawLine(x,y,x2,y2);
        });
    }

    @Override
    public void drawEllipse(int x,int y,int width,int height,CanvaColor color) {
        graphics.render( g->{
            g.setColor(toSimpleGraphicsColor(color));
            g.drawOval(x,y,width,height);
        });
    }

    @Override
    public void waitForMouseEvents(MouseClickCallback mouseCallback) {
        graphics.waitForMouseEvents(mouseCallback::onClick);
    }

    private Color toSimpleGraphicsColor(CanvaColor color) {
        return switch(color) {
            case BLACK -> Color.BLACK;
            case WHITE -> Color.WHITE;
            case ORANGE -> Color.ORANGE;
            default -> throw new UnsupportedOperationException();
        };
    }
}
