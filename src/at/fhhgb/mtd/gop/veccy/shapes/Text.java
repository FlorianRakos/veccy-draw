package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Text extends Shape{
    String textStr;

    public Text(int x, int y, String textStr) {
        super(x, y);
        this.textStr = textStr;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);

        graphicsContext.strokeText(textStr, getX(), getY());
        graphicsContext.fillText(textStr, getX(), getY());

    }
}
