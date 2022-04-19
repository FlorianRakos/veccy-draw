package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;


public class Circle extends Shape {


    //private int x, y;
    private int radius;

    final int CIRCLE_POINTS = 256;

    public Circle(int x, int y, int radius) {
        super(x,y);
        this.radius = radius;
    }

    public int area () {
        return (int) (radius * radius * Math.PI);
    }

    public Rectangle boundingBox () {
        int x = this.getX() - radius;
        int y = this.getY() - radius;
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

                // Overlapping in X
        return ((x1Min < x2Max && x1Max > x2Max)
                ||
                (x2Min < x1Max && x2Max > x1Max))
                &&
                // Overlapping in y
                ((y1Min < y2Max && y1Max > y2Max)
                ||
                (y2Min < y1Max && y2Max > y1Max));
    }

    private double[][] getCoordinates() {

        Matrix3 toShape = TransformFactory.createTranslation(getX(),getY());
        double[][] res = new double[2][CIRCLE_POINTS];

        Vector3[] points = new Vector3[CIRCLE_POINTS];
        double step = (2 * Math.PI) / CIRCLE_POINTS;

        for (int i = 0; i < CIRCLE_POINTS; i++) {
            points[i] = new Vector3(new double[]{Math.cos(i * step) * radius, Math.sin(i * step) * radius, 1.0});
        }

        for (int i = 0; i<CIRCLE_POINTS; i++) {
            //points[i] = toOrigin.mult(points[i]);
            if (this.transform == null) this.transform = TransformFactory.defaultMatrix();
            points[i] = this.transform.mult(points[i]);
            points[i] = toShape.mult(points[i]);
            res[0][i] = points[i].getValues()[0];
            res[1][i] = points[i].getValues()[1];
        }
        return res;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);

        double[][] coords = getCoordinates();
        graphicsContext.fillPolygon(coords[0], coords[1], CIRCLE_POINTS);
        graphicsContext.strokePolygon(coords[0], coords[1], CIRCLE_POINTS);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Circle other) {
            return
                other.position.getValues()[0] == position.getValues()[0] &&
                other.position.getValues()[1] == position.getValues()[1] &&
                other.radius == this.radius;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Circle @ ");
        sb.append(position.getValues()[0]);
        sb.append("/");
        sb.append(position.getValues()[1]);
        sb.append(", Radius: " + radius);
        return sb.toString();
    }


    public void setRadius(int radius) {
        this.radius = radius;
    }
}