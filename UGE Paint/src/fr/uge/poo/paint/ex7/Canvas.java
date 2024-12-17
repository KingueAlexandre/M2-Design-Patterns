package fr.uge.poo.paint.ex7;

public sealed interface Canvas permits CoolGraphicsAdapter,SimpleGraphicsAdapter{

    enum CanvaColor{
        BLACK,
        WHITE,
        ORANGE
    }


    @FunctionalInterface
    interface MouseClickCallback{
        void onClick(int x,int y);
    }

    public void clear(CanvaColor color);
    public void drawLine(int x,int y,int x2,int y2,CanvaColor color);
    public void drawEllipse(int x,int y,int width,int height, CanvaColor color);
    public void waitForMouseEvents(MouseClickCallback mouseCallback);

    default public void drawRect(int x,int y,int width,int height,CanvaColor color) {
        drawLine(x,y,x+width,y,color);
        drawLine(x,y+height,x+width,y+height,color);
        drawLine(x,y,x,y+height,color);
        drawLine(x+width,y,x+width,y+height,color);
    }

}
