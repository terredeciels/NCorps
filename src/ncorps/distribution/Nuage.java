package ncorps.distribution;

import ncorps.basephysic.Corps3D;
import ncorps.math.Vector3D;

import static java.lang.Math.*;
import static ncorps.parameter.Constants.mParticle;

public class Nuage implements IDistribution {

    @Override
    public void addParticule() {
        double X0 = 50, Y0 = 50, Z0 = 50, R0 = 30;
        double vit_pos = 1000.0;
        double r = R0 * random.nextDouble();
        double theta = random.nextDouble() * 2 * PI;
        double phi = random.nextDouble() * 2 * PI;
        double x = r * sin(phi) * cos(theta) + X0;
        double y = r * sin(phi) * sin(theta) + Y0;
        double z = r * cos(phi) + Z0;
        Vector3D X = new Vector3D(x, y, z);

        Vector3D v = new Vector3D(-vit_pos, 0, 0);

        Vector3D a = new Vector3D(0, 0, 0);
        Corps3D particle = new Corps3D(mParticle, X, v, a, false);
        allParticles.add(particle);
    }
}
