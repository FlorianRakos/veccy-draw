package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.data.DoubleLinkedList;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;

public class TransformFeature implements NamedFeature {

    boolean isActive = false;
    CanvasModel model;
    DoubleLinkedList dL;

    public TransformFeature (CanvasModel model, DoubleLinkedList dL) {
        this.model = model;
        this.dL = dL;
    }

    @Override
    public String getName() {
        return "Transform";
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
        //TransformConfig config = BlockingTransformInputDialog.requestConfigInput();

    }

    @Override
    public void onMouseDrag(int i, int i1) {

    }
}
