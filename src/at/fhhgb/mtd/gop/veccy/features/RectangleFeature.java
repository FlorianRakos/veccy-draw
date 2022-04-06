package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import org.w3c.dom.css.Rect;

public class RectangleFeature implements NamedFeature {
    private boolean isActive = false;
    private CanvasModel model;



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
    public void onMouseClick(int i, int i1) {
        if(!isActive) return;

        Rectangle rec = new Rectangle(i, i1, (int)(Math.random() * 100), (int)(Math.random() * 100));
        model.addShape(rec);
    }

    @Override
    public void onMouseDrag(int i, int i1) {

    }
}
