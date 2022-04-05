package at.fhhgb.mtd.gop.math;

public class TransformFactory {
    public static Matrix3 createTranslation(int deltaX, int deltaY) {
        return new Matrix3(new double[][]{{1,0,0},{0,1,0},{deltaX,deltaY,1}});
    }

    public static Matrix3 createRotation (double rad) {
        return new Matrix3(new double[][]
                {{Math.cos(rad),Math.sin(rad),0},{-Math.sin(rad),Math.cos(rad),0},{0,0,1}});
    }

    public static Matrix3 createHorizontalMirroring() {
        return new Matrix3(new double[][]{{1,0,0},{0,-1,0},{0,0,1}});
    }

    public static Matrix3 createVerticalMirroring() {
        return new Matrix3(new double[][]{{-1,0,0},{0,1,0},{0,0,1}});
    }

    public static Matrix3 createScaling(double factorX, double factorY) {
        return new Matrix3(new double[][]{{factorX,0,0},{0,factorY,0},{0,0,1}});
    }

    public static Matrix3 defaultMatrix () {
        return new Matrix3 (new double[][]{{1,0,0},{0,1,0},{0,0,1}});
    }

}
