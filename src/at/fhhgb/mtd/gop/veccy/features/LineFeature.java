package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Line;

public class LineFeature implements NamedFeature {
    private boolean isActive = false;
    private CanvasModel model;

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
    public void onMouseClick(int i, int i1) {
        if (!isActive) return;
        Line lin = new Line (i, i1, (int)(Math.random() * 50 + i), (int)(Math.random() * 50 + i1));
        model.addShape(lin);
    }

    @Override
    public void onMouseDrag(int i, int i1) {

    }
}
