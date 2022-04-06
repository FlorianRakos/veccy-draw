package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


// Fragen
// int oder double?
// position
public class Shape implements DrawableShape{
    protected Vector3 position;
    protected Matrix3 transform;
    protected Color fillColor = Color.WHITE;
    protected Color strokeColor = Color.WHITE;

    public Shape(int x, int y) {
        position = new Vector3(new double[] {x,y,1.0});
    }

    public int getX () {
        return (int) Math.round(position.getValues()[0]);
    }

    public int getY () {
        return (int) Math.round(position.getValues()[1]);
    }

    public void setFillColor (Color c) { fillColor = c;}

    public void setStrokeColor (Color c) {
        strokeColor = c;
    }

    public void setTransform (Matrix3 transform) {
        this.transform = transform;
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(fillColor);
        graphicsContext.setStroke(strokeColor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Shape) {
            Shape other = (Shape) obj;
            return other.position.getValues()[0] == position.getValues()[0] &&
                    other.position.getValues()[1] == position.getValues()[1];
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Shape @ ");
        sb.append(position.getValues()[0]);
        sb.append("/");
        sb.append(position.getValues()[1]);
        return sb.toString();
    }
}
