package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Vector3;

// For Polygon and Path
public interface Polymetrical {
    int numPoints();
    void setPoints(Vector3[] points);
    Vector3[] getPoints();
}
