package at.fhhgb.mtd.gop.veccy.shapes;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;

public class Polygon extends Shape implements Polymetrical {


    Vector3[] points;
    int numPoints;

    public Polygon (Vector3[] points) {
        super((int)points[0].getValues()[0], (int)points[0].getValues()[1]);
        this.points = points;
        numPoints = numPoints();
    }

    public int numPoints () {
        int i = 0;
        int counter = 0;

        while (i < points.length) {
            if (points[i] != null) {
                counter ++;
            }
            i++;
        }
        return counter;
    }

    public double[][] getCoordinates () {
        double[][] res = new double[2][numPoints];

        for (int i = 0; i<numPoints; i++) {
            res[0][i] = points[i].getValues()[0];
            res[1][i] = points[i].getValues()[1];
        }
        return res;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);

        double[][] coords = getCoordinates();
        graphicsContext.fillPolygon(coords[0], coords[1], numPoints);
        graphicsContext.strokePolygon(coords[0], coords[1], numPoints);
    }

    public void setPoints(Vector3[] points) {
        this.points = points;
        numPoints = numPoints();
        this.setX ((int)points[0].getValues()[0]);
        this.setY ((int)points[0].getValues()[1]);
    }

    public Vector3[] getPoints() {
        return this.points;
    }
}
