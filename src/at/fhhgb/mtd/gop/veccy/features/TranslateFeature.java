package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.data.DoubleLinkedList;
import at.fhhgb.mtd.gop.math.Vector3;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Line;
import at.fhhgb.mtd.gop.veccy.shapes.Polygon;
import at.fhhgb.mtd.gop.veccy.shapes.Polymetrical;
import at.fhhgb.mtd.gop.veccy.shapes.Shape;

public class TranslateFeature implements NamedFeature {
    boolean isActive = false;
    CanvasModel model;
    DoubleLinkedList dL;

    public TranslateFeature (CanvasModel model, DoubleLinkedList dL) {
        this.model = model;
        this.dL = dL;
    }

    @Override
    public String getName() {
        return "Translate";
    }

    @Override
    public void onSelect() {
        isActive = true;
    }

    @Override
    public void onDeselect() {
        isActive = false;
    }

    @Override
    public void onMouseClick(int i, int i1) {

    }

    @Override
    public void onMouseDrag(int i, int i1) {
        if (!isActive) return;

        int index = model.getCurrentlySelectedShapeIndex();
        Shape shape;

        try {
            shape = dL.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No Shape selected");
            return;
        }



        if (shape instanceof Line line) {

            int deltaX = i - line.getX();
            int deltaY = i1 - line.getY();

            line.setX(i);
            line.setY(i1);

            line.setPoint2(line.getPoint2()[0] + deltaX, line.getPoint2()[1] + deltaY);
            return;
        }

//        if (shape instanceof Polygon) {
//            Polygon poly = (Polygon) shape;
//            int numPoints = poly.numPoints();
//
//            Vector3[] points = poly.getPoints();
//            Vector3[] newPoints = new Vector3[128];
//
//            System.out.println("P Length" + numPoints);
//
//            int deltaX = i - poly.getX();
//            int deltaY = i1 - poly.getY();
//
//            for (int n = 0; n < numPoints; n++) {
//                double[] values = new double[3];
//
//                values[0] = points[n].getValues()[0] + deltaX;
//                values[1] = points[n].getValues()[1] + deltaY;
//                //values[2] = points[n].getValues()[2];
//
//                newPoints[n] = new Vector3(values);
//            }
//            poly.setPoints(newPoints);
//            return;
//        }

        if (shape instanceof Polymetrical poly) {
            int numPoints = poly.numPoints();

            Vector3[] points = poly.getPoints();
            Vector3[] newPoints = new Vector3[128];

            //System.out.println("P Length" + numPoints);

            int deltaX = i - ((Shape)poly).getX();
            int deltaY = i1 - ((Shape)poly).getY();

            for (int n = 0; n < numPoints; n++) {
                double[] values = new double[3];

                values[0] = points[n].getValues()[0] + deltaX;
                values[1] = points[n].getValues()[1] + deltaY;
                //values[2] = points[n].getValues()[2];

                newPoints[n] = new Vector3(values);
            }
            poly.setPoints(newPoints);
            return;
        }



        shape.setX(i);
        shape.setY(i1);
    }


}
