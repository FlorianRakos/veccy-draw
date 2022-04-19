package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.math.Vector3;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Polygon;

import java.util.Vector;

public class PolygonFeature implements NamedFeature {
    private CanvasModel model;
    private boolean isActive = false;

    Polygon currentPoly;
    Vector3[] points = new Vector3[128];
    int counter = 0;

    public PolygonFeature (CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Polygon";
    }

    @Override
    public void onSelect() {
        isActive = true;
    }

    @Override
    public void onDeselect() {

        isActive = false;
        points = new Vector3[128];
        counter = 0;
        currentPoly = null;
    }

    @Override
    public void onMouseClick(int x, int y) {
        if (!isActive) return;

        points[counter] = new Vector3(new double[]{x, y});
        counter++;

        if (currentPoly == null) {
            currentPoly = new Polygon(points);
        } else {
            currentPoly.setPoints(points);
        }

        currentPoly.setFillColor(model.getCurrentFillColor());
        currentPoly.setStrokeColor(model.getCurrentStrokeColor());
        model.addShape(currentPoly);
    }

    @Override
    public void onMouseDrag(int x, int y) {

    }
}
