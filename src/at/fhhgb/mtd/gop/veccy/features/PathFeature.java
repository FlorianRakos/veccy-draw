package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.math.Vector3;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Path;
import at.fhhgb.mtd.gop.veccy.shapes.Polygon;

public class PathFeature implements NamedFeature {
    private CanvasModel model;
    private boolean isActive = false;

    Path currentPath;
    Vector3[] points = new Vector3[128];
    int counter = 0;

    public PathFeature (CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Path";
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
        currentPath = null;
    }

    @Override
    public void onMouseClick(int x, int y) {
        if (!isActive) return;

        points[counter] = new Vector3(new double[]{x, y});
        counter++;

        if (currentPath == null) {
            currentPath = new Path(points);
            model.addShape(currentPath);
        } else {
            currentPath.setPoints(points);
        }

        currentPath.setStrokeColor(model.getCurrentStrokeColor());

    }

    @Override
    public void onMouseDrag(int x, int y) {

    }
}
