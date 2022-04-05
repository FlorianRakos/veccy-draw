package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape {
    private int x1, y1;
    private int x2, y2;

    public Line (int x1, int y1, int x2, int y2) {
        super(x1,y1);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Rectangle boundingBox () {
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int width = Math.max(x1, x2) - Math.min(x1, x2);
        int height = Math.max(y1, y2) - Math.min(y1,y2);

        return new Rectangle(x,y,width,height);
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
        super.draw(graphicsContext);
        graphicsContext.strokeLine(x1, y1, x2, y2);
    }
}
