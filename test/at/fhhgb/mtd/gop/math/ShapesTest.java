package at.fhhgb.mtd.gop.math;

import at.fhhgb.mtd.gop.veccy.Veccy;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Line;
import at.fhhgb.mtd.gop.veccy.shapes.Point;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;

public class ShapesTest {

//    drawShapeCircle(model, Veccy.ShapeType.Circle, 50, 60, 6,0,0);
//    drawShapeCircle(model, Veccy.ShapeType.Rectangle, 50, 150, 10,0,0);
//    drawShapeCircle(model, Veccy.ShapeType.Line, 80, 150, 10,0,0);
//    drawShapeCircle(model, Veccy.ShapeType.Line, 30, 60, 6,20,20);

    private void drawShapeCircle(CanvasModel model, Veccy.ShapeType shapeType, int shapeWidth, int radius, int iter, int xOffset, int yOffset) {
        float steps = (float) (2 * Math.PI / iter);
        for (float i = 0; i < Math.PI * 2; i += steps) {
            int[] start = {400, 300};
            //int fact = 100;
            int x = (int) (Math.cos(i) * radius + start[0] + xOffset);
            int y = (int) (Math.sin(i) * radius + start[1] + yOffset);

            switch (shapeType) {
                case Circle:
                    Circle cir = new Circle(x, y, 50);
                    model.addShape(cir);
                    break;
                case Rectangle:
                    Rectangle rec = new Rectangle(x, y, shapeWidth, shapeWidth);
                    model.addShape(rec);
                    break;
                case Line:
                    Line lin = new Line(x, y, x + shapeWidth, y + shapeWidth);
                    model.addShape(lin);
                case Point:
                    Point poi = new Point(x, y);
                    model.addShape(poi);
            }
        }
    }
}


