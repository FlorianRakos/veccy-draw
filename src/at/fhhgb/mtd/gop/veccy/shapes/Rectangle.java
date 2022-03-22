package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

public class Rectangle implements DrawableShape {
    private int x, y;
    private int width, height;


    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int area() {
        return this.height * this.width;
    }

    public Rectangle boundingBox () {
        return new Rectangle(x,y,width,height);
    }

    public boolean isOverlapping (Rectangle other) {
        int x1Min = this.x;
        int x1Max = this.x + this.width;
        int y1Min = this.y;
        int y1Max = this.y + this.height;

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

    // Für bounding box test
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(this.x, this.y,this.width,this.height);

    }
}