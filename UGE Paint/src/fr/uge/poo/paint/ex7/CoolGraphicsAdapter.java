package fr.uge.poo.paint.ex7;

import com.evilcorp.coolgraphics.CoolGraphics;
import com.evilcorp.coolgraphics.CoolGraphics.ColorPlus;
import com.evilcorp.coolgraphics.CoolGraphics.MouseCallback;

public final class CoolGraphicsAdapter implements Canvas{

    private final CoolGraphics graphics;
    CoolGraphicsAdapter(String name,int width,int height){
        graphics = new CoolGraphics(name,width,height);
    }

    @Override
    public void clear(CanvaColor color) {
        graphics.repaint(toCoolGraphicsColor(color));
    }

    @Override
    public void drawLine(int x, int y, int x2, int y2,CanvaColor color) {
        graphics.drawLine(x,y,x2,y2,toCoolGraphicsColor(color));

    }

    @Override
    public void drawEllipse(int x,int y,int width,int height,CanvaColor color) {
        graphics.drawEllipse(x,y,width,height,toCoolGraphicsColor(color));
    }

    @Override
    public void waitForMouseEvents(MouseClickCallback mouseCallback) {
        graphics.waitForMouseEvents(mouseCallback::onClick);
    }

    private ColorPlus toCoolGraphicsColor(CanvaColor color) {
        return switch(color) {
            case BLACK -> ColorPlus.BLACK;
            case WHITE -> ColorPlus.WHITE;
            case ORANGE -> ColorPlus.ORANGE;
            default -> throw new UnsupportedOperationException();
        };
    }


}
