package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Point;

public class PointFeature implements NamedFeature {
    private boolean isActive = false;
    private CanvasModel model;

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
    public void onMouseClick(int i, int i1) {
        if (!isActive) return;
        Point point = new Point(i, i1);
        model.addShape(point);
    }

    @Override
    public void onMouseDrag(int i, int i1) {

    }
}
