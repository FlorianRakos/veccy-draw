package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import org.junit.jupiter.api.BeforeAll;

public class CircleFeature implements NamedFeature {
    private boolean isActive = false;
    private CanvasModel model;

    private Circle currentCircle;
    private int originX;
    private int originY;

    public CircleFeature (CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Circle";
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
        if(!isActive) return;

        currentCircle = null;
        originY = 0;
        originX = 0;
    }

    @Override
    public void onMouseDrag(int x, int y) {
        if(!isActive) return;

        if (originX == 0 && originY == 0) {
            originX = x;
            originY = y;
        }

        int rad = (int) Math.sqrt((originX - x) * (originX - x) + (originY - y) * (originY - y) );

        if (currentCircle == null) {
            currentCircle = new Circle(originX, originY, rad);
            model.addShape(currentCircle);
        } else {
            currentCircle.setRadius(rad);
        }

        currentCircle.setFillColor(model.getCurrentFillColor());
        currentCircle.setStrokeColor(model.getCurrentStrokeColor());

    }
}
