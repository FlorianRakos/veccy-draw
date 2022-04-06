package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Point extends Shape  {

    public Point(int x, int y) {
        super(x,y);
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.fillOval(this.getX(),this.getY(),5,5);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Point other) {
            return other.getX() == this.getX() &&
                    other.getY() == this.getY();

        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Point @ ");
        sb.append(position.getValues()[0]);
        sb.append("/");
        sb.append(position.getValues()[1]);
        return sb.toString();
    }

}
