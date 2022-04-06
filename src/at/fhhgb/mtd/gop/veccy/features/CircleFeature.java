package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import org.junit.jupiter.api.BeforeAll;

public class CircleFeature implements NamedFeature {
    private boolean isActive = false;
    private CanvasModel model;

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
    public void onMouseClick(int i, int i1) {
        if(!isActive) return;

        Circle cir = new Circle(i, i1, (int)(Math.random() * 100));
        model.addShape(cir);
    }

    @Override
    public void onMouseDrag(int i, int i1) {

    }
}
