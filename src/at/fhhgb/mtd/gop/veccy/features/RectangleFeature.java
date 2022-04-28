package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import org.w3c.dom.css.Rect;

public class RectangleFeature implements NamedFeature {
    private boolean isActive = false;
    private CanvasModel model;

    Rectangle currentRect;
    int originY;
    int originX;



    public RectangleFeature (CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Rectangle";
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

        currentRect = null;
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

        //int width = (int) Math.sqrt((originX - x) * (originX - x) + (originY - y) * (originY - y) );
        int width = Math.abs(originX - x);
        int height = Math.abs(originY - y);


        if (currentRect == null) {
            currentRect = new Rectangle(originX, originY, width, height);
            model.addShape(currentRect);
        } else {
            currentRect.setHeight(height);
            currentRect.setWidth(width);
        }

        currentRect.setFillColor(model.getCurrentFillColor());
        currentRect.setStrokeColor(model.getCurrentStrokeColor());

    }
}
