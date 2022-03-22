package at.fhhgb.mtd.gop.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Matrix3Test {


    @Test
    void testMult() {
        double[][] testVals1 = {{1, 2, 3},{4,5,6}, {7,8,9}};
        double[][] testVals2 = {{1, 1, 1},{2,2,2}, {3,3,3}};
        double[][] solutionVals = {{12,15,18},{24,30,36},{36,45,54}};

        Matrix3 testMat1 = new Matrix3(testVals1);
        Matrix3 testMat2 = new Matrix3(testVals2);

        Vector3 testVec = new Vector3(new double[]{3,4,5});
        double[] vecSolVals = new double[] {54,66,78};


        //Test Matrix * Matrix
        assertTrue(Arrays.deepEquals(testMat1.mult(testMat2).getValues(), solutionVals));
        //Test Matrix * Vector
        assertArrayEquals(vecSolVals,testMat1.mult(testVec).getValues());
    }

    @Test
    void getValues() {
        double[][] testVals1 = {{1, 2, 3},{4,5,6}, {7,8,9}};
        Matrix3 testMat1 = new Matrix3(testVals1);

        assertArrayEquals(testMat1.getValues(),testVals1);

    }
}