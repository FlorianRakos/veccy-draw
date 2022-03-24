package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.NamedFeature;

public class CircleFeature implements NamedFeature {
    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public void onSelect() {
        System.out.println("OnSelect");
    }

    @Override
    public void onDeselect() {
        System.out.println("OnDeselect");
    }

    @Override
    public void onMouseClick(int i, int i1) {
        System.out.println("OnMouseClick");
    }

    @Override
    public void onMouseDrag(int i, int i1) {

    }
}
