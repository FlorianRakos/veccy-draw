package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

// Fragen:
// Vector 3 / Double[]
// Ursprung
// Fill Polygon

public class Rectangle extends Shape {

    private int width, height;


    public Rectangle(int x, int y, int width, int height) {
        super(x,y);
        this.width = width;
        this.height = height;
    }

    public int area() {
        return this.height * this.width;
    }

    public Rectangle boundingBox () {
        return new Rectangle(this.getX(),this.getY(),width,height);
    }

    public boolean isOverlapping (Rectangle other) {
        int x1Min = this.getX();
        int x1Max = this.getX() + this.width;
        int y1Min = this.getY();
        int y1Max = this.getY() + this.height;


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

    private double[][] getCoordinates() {
        Matrix3 toOrigin = TransformFactory.createTranslation(-getX(),-getY());
        Matrix3 toShape = TransformFactory.createTranslation(getX(),getY());
        double[][] res = new double[2][4];

        Vector3[] points = new Vector3[4];
        points[0] = new Vector3(new double[]{this.getX() - width/2,this.getY() - height/2,1});
        points[1] = new Vector3(new double[]{this.getX() + width/2,this.getY() - height/2,1});
        points[2] = new Vector3(new double[]{this.getX() + width/2,this.getY() + height/2,1});
        points[3] = new Vector3(new double[]{this.getX() - width/2,this.getY() + height/2,1});

        for (int i = 0; i<4; i++) {
            points[i] = toOrigin.mult(points[i]);
            points[i] = this.transform.mult(points[i]);
            points[i] = toShape.mult(points[i]);
            res[0][i] = points[i].getValues()[0];
            res[1][i] = points[i].getValues()[1];
        }
        return res;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        //graphicsContext.fillRect(this.getX(), this.getY(),this.width,this.height);
        // get Coord
        double[][] coords = getCoordinates();
        graphicsContext.fillPolygon(coords[0], coords[1], 4);
        graphicsContext.strokePolygon(coords[0], coords[1], 4);
    }
}