package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Text extends Shape{
    String textStr;

    public Text(int x, int y, String textStr) {
        super(x, y);
        this.textStr = textStr;
    }

    @Override
    public double[][] getCoordinates() {
        return new double[][] {{getX(), getX() + textStr.length() * 6},
                {getY(), getY() - 12}};
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);

        graphicsContext.strokeText(textStr, getX(), getY());
        graphicsContext.fillText(textStr, getX(), getY());

    }
}
