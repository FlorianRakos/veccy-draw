package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle implements DrawableShape {
    private int x, y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int area () {
        return (int) (radius * radius * Math.PI);
    }

    public Rectangle boundingBox () {
        int x = this.x - radius;
        int y = this.y - radius;
        int length = radius * 2;

        return new Rectangle(x,y,length,length);
    }

    public boolean isOverlapping (Rectangle other) {
        Rectangle bb = this.boundingBox();

        int x1Min = bb.getX();
        int x1Max = bb.getX() + bb.getWidth();
        int y1Min = bb.getY();
        int y1Max = bb.getY() + bb.getHeight();

        int x2Min = other.getX();
        int x2Max = other.getX() + other.getWidth();
        int y2Min = other.getY();
        int y2Max = other.getY() + other.getHeight();

        if (
            // Overlapping in X
                ((x1Min < x2Max && x1Max > x2Max)
                        ||
                        (x2Min < x1Max && x2Max > x1Max))
                        &&
                        // Overlapping in y
                        ((y1Min < y2Max && y1Max > y2Max)
                                ||
                                (y2Min < y1Max && y2Max > y1Max))
        ) {
            return true;
        }
        return false;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillOval(this.x,this.y,this.radius,this.radius);
    }
}