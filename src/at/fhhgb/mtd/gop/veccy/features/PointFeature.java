package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Point;

public class PointFeature implements NamedFeature {
    private boolean isActive = false;
    private CanvasModel model;

    Point currentPoint;

    public PointFeature (CanvasModel model) {
        this.model = model;
    }


    @Override
    public String getName() {
        return "Point";
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
    public void onMouseClick(int x, int y) {
    }

    @Override
    public void onMouseDrag(int x, int y) {
        if(!isActive) return;

        currentPoint = new Point(x, y);

        currentPoint.setFillColor(model.getCurrentFillColor());
        currentPoint.setStrokeColor(model.getCurrentStrokeColor());
        model.addShape(currentPoint);

        currentPoint = null;

    }
}
