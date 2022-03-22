package at.fhhgb.mtd.gop.math;

import at.fhhgb.mtd.gop.math.Vector3;


public class Matrix3 {
    double[][] values;

    public Matrix3 () {
        this.values = new double[][] {{1.0,0.0,0.0},{0.0,1.0,0.0},{0.0,0.0,1.0}};
    }

    public Matrix3 (double[][] values) {
        this.values = values;
    }

    public Vector3 mult (Vector3 vec) {
        double vecX = vec.getValues()[0];
        double vecY = vec.getValues()[1];
        double vecZ = vec.getValues()[2];

        double xNew = vecX * values[0][0] + vecY * values[1][0] + vecZ * values[2][0];
        double yNew = vecX * values[0][1] + vecY * values[1][1] + vecZ * values[2][1];
        double zNew = vecX * values[0][2] + vecY * values[1][2] + vecZ * values[2][2];
        double[] result = {xNew,yNew,zNew};
        return new Vector3(result);
    }

    public Matrix3 mult (Matrix3 newMatrix) {
        double[][] mat = newMatrix.getValues();
        double[][] matrixOut = new double[3][3];

        for (int i = 0; i < 3; i++) {
            for (int n = 0; n < 3; n++) {
                matrixOut[i][n] = values[0][n] * mat[i][0] + values[1][n] * mat[i][1] + values [2][n] * mat[i][2];
            }
        }
        return new Matrix3(matrixOut);
    }

    public double[][] getValues() {
        return this.values;
    }
}
