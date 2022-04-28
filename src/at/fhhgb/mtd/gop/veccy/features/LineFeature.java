package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Line;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;

public class LineFeature implements NamedFeature {
    private boolean isActive = false;
    private CanvasModel model;

    Line currentLine;
    int originY;
    int originX;

    public LineFeature (CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Line";
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

        currentLine = null;
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


        if (currentLine == null) {
            currentLine = new Line(originX, originY, x, y);
            model.addShape(currentLine);
        } else {
            currentLine.setPoint2(x, y);
        }
        currentLine.setFillColor(model.getCurrentFillColor());
        currentLine.setStrokeColor(model.getCurrentStrokeColor());

    }


}
