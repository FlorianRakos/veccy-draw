package at.fhhgb.mtd.gop.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector3Test {

    @Test
    void getValues() {
        double[] vecVals = {1,2,-5};
        Vector3 vec = new Vector3(vecVals);
        assertArrayEquals(vecVals,vec.getValues());
    }
}