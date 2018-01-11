package ncorps.math;

import static java.lang.Math.sqrt;

public class Vector3D {

    public double x;
    public double y;
    public double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector3D subtract(Vector3D v1, Vector3D v2) {
        return new Vector3D(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public void multiply(double n) {
        x *= n;
        y *= n;
        z *= n;
    }

    public double magnitude() {
        return sqrt((x * x) + (y * y) + (z * z));
    }

}
