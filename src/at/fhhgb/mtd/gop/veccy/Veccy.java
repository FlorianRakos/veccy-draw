package at.fhhgb.mtd.gop.veccy;

import at.fhhgb.mtd.gop.data.DoubleLinkedList;
import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import at.fhhgb.mtd.gop.veccy.features.CircleFeature;
import at.fhhgb.mtd.gop.veccy.features.LineFeature;
import at.fhhgb.mtd.gop.veccy.features.PointFeature;
import at.fhhgb.mtd.gop.veccy.features.RectangleFeature;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Veccy extends Application {
    public enum ShapeType {Circle, Rectangle, Point, Line}

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        VeccyGUI veccyGUI = new VeccyGUI(stage);
        CanvasModel model = veccyGUI.getModel();

        CircleFeature cF = new CircleFeature(model);
        LineFeature lF = new LineFeature(model);
        PointFeature pF = new PointFeature(model);
        RectangleFeature rF = new RectangleFeature(model);

        model.addFeature(cF);
        model.addFeature(lF);
        model.addFeature(pF);
        model.addFeature(rF);


        // Temporary Tests
        Circle cir = new Circle(100, 100, 100);
        model.addShape(cir);

        Circle cir2 = new Circle(100, 100, 100);
        System.out.println("Circle: " + cir.equals(cir2));

        Line lin = new Line(10,10,40,40);
        Line lin2 = new Line(10,10,40,40);
        System.out.println("Line: " + lin.equals(lin2));

        Point point = new Point(5, 5);
        Point point1 = new Point(5, 5);
        System.out.println("Point: " + point.equals(point1));

        Rectangle rec = new Rectangle(5,5,5,5);
        Rectangle rec2 = new Rectangle(5,5,5,5);
        System.out.println("Rectangle: " + rec.equals(rec2));

        // Testing toString
        System.out.println(cir);
        System.out.println(lin);
        System.out.println(point);
        System.out.println(rec);

    }
}
