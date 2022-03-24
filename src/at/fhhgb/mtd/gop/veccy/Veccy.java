package at.fhhgb.mtd.gop.veccy;

import at.fhhgb.mtd.gop.data.DoubleLinkedList;
import at.fhhgb.mtd.gop.math.Matrix3;
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
    public void start(Stage stage) throws Exception {
        VeccyGUI veccyGUI = new VeccyGUI(stage);
        CanvasModel model = veccyGUI.getModel();

        CircleFeature cF = new CircleFeature();
        LineFeature lF = new LineFeature();
        PointFeature pF = new PointFeature();
        RectangleFeature rF = new RectangleFeature();

        model.addFeature(cF);
        model.addFeature(lF);
        model.addFeature(pF);
        model.addFeature(rF);



//            DoubleLinkedList list = new DoubleLinkedList();
//            list.prepend(1);
//            list.append(5);

    }
}
