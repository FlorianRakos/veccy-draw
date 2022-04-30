package at.fhhgb.mtd.gop.math;

public class Vector3 {
    private double[] defValues = {0.0, 0.0, 1.0};
    private double[] values;

    public Vector3() {
        this.values = defValues;
    }

    public Vector3(double[] values) {
        this.values = values;
    }

    public double[] getValues() {
        return this.values;
    }

    public void setValues(double[] values) {
        this.values = values;
    }


    // Initialisiert this.values mit dem Parameter values (kopieren Sie die Werte!)
    //public Vector3(double[] values) { ... }
    // Initialisiert this.values mit den values aus dem Parameter vector
    // (verwenden Sie this()!)
    //public Vector3(Vector3 vector) { ... }
    // Returniert die Instanzvariable values
    //public double[] getValues() { ... }
}
