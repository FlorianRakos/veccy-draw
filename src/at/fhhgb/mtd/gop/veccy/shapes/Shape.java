package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public abstract class Shape implements DrawableShape{
    boolean isSelected = false;
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

    public void setX (int x) {
        this.position = new Vector3(new double[]{x, this.position.getValues()[1], 0});
    }

    public void setY (int y) {
        this.position = new Vector3(new double[]{this.position.getValues()[0], y, 0});
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected (boolean isSelected) {
        this.isSelected = isSelected;
    }

    public abstract double[][] getCoordinates();

    public Rectangle getBoundingBox() {
        double[][] coords = this.getCoordinates();
        Rectangle rec;

        double left = coords[0][0];
        double right = coords[0][0];
        double top = coords[1][0];
        double bottom = coords[1][0];

        for (int i = 0; i < coords[0].length; i++) {
            if (left > coords[0][i]) left = coords[0][i];
            if (right < coords[0][i]) right = coords[0][i];
            if (top > coords[1][i]) top = coords[1][i];
            if (bottom < coords[1][i]) bottom = coords[1][i];
        }


        return new Rectangle(
                (int)left,(int)top,
                (int)(right-left),(int)(bottom-top));
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
        if (isSelected) {
            graphicsContext.setStroke(Color.LAWNGREEN);
            Rectangle bb = getBoundingBox();
            graphicsContext.strokeRect(bb.getX(), bb.getY(), bb.getWidth(), bb.getHeight());
        }
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
