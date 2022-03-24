package at.fhhgb.mtd.gop.math;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class TransformFactoryTest {

    Vector3 vec = new Vector3(new double[]{10,5,1});

    @Test
    void createTranslation() {
        Matrix3 mat = TransformFactory.createTranslation(5,3);
        Vector3 res = mat.mult(vec);
        assertArrayEquals(new double[]{15,8,1},res.getValues());
    }

    @Test
    void createRotation() {
        Matrix3 mat = TransformFactory.createRotation(Math.PI);
        Vector3 res = mat.mult(vec);
        assertArrayEquals(new double[]{-10,-5,1},res.getValues(),0.0000001);
    }

    @Test
    void createHorizontalMirroring() {
        Matrix3 mat = TransformFactory.createHorizontalMirroring();
        Vector3 res = mat.mult(vec);
        assertArrayEquals(new double[]{10,-5,1},res.getValues());
    }

    @Test
    void createVerticalMirroring() {
        Matrix3 mat = TransformFactory.createVerticalMirroring();
        Vector3 res = mat.mult(vec);
        assertArrayEquals(new double[]{-10,5,1},res.getValues());
    }

    @Test
    void createScaling() {
        Matrix3 mat = TransformFactory.createScaling(2,-3);
        Vector3 res = mat.mult(vec);
        assertArrayEquals(new double[]{20,-15,1},res.getValues());
    }
}