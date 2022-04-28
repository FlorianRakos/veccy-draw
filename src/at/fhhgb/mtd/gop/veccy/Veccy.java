package at.fhhgb.mtd.gop.veccy;

import at.fhhgb.mtd.gop.data.DoubleLinkedList;
import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import at.fhhgb.mtd.gop.veccy.features.*;
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
        DoubleLinkedList dL = new DoubleLinkedList();

        VeccyGUI veccyGUI = new VeccyGUI(stage);
        CanvasModel model = veccyGUI.getModel();

        CircleFeature cF = new CircleFeature(model);
        LineFeature lF = new LineFeature(model);
        PointFeature pF = new PointFeature(model);
        RectangleFeature rF = new RectangleFeature(model);
        PolygonFeature polF = new PolygonFeature(model);
        PathFeature paF = new PathFeature(model);
        TextFeature tF = new TextFeature(model);

        model.addFeature(cF);
        model.addFeature(lF);
        model.addFeature(pF);
        model.addFeature(rF);
        model.addFeature(polF);
        model.addFeature(paF);
        model.addFeature(tF);


        model.setCurrentlySelectedShapeHandler(index -> {
            System.out.println("Change curr selected. Index = " + index);
            for (int i =0; i < dL.size(); i++) {
                dL.get(i).setSelected(false);
            }
//            for (Shape shape : dL) {
//                shape.setSelected(false);
//            }
            System.out.println("here");
            dL.get(index).setSelected(true);

        });


        model.setShapeCreationHandler(drawableShape -> {
            System.out.println("Add shape");
            dL.append((Shape) drawableShape);
        });

        model.setShapeDeletionHandler(index -> {
            model.removeShape(dL.get(index));
            dL.remove(index);
        });

    }
}
