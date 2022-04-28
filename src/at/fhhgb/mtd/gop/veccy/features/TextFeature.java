package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Text;
import at.fhhgb.mtd.gop.veccy.view.BlockingTextInputDialog;

public class TextFeature implements NamedFeature {
    boolean isActive = false;
    CanvasModel model;

    public TextFeature (CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Text";
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
        if (!isActive) return;
        String textStr = BlockingTextInputDialog.requestTextInput();

        if (textStr == null) return;

        Text text = new Text (x, y, textStr);
        text.setFillColor(model.getCurrentFillColor());
        text.setStrokeColor(model.getCurrentStrokeColor());
        model.addShape(text);
    }

    @Override
    public void onMouseDrag(int i, int i1) {

    }
}
