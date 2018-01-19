package ncorps.distribution;

import ncorps.basephysic.Corps3D;
import ncorps.math.Vector3D;
import ncorps.parameter.Constants;

public class Anneau implements IDistribution, Constants {

    @Override
    public void addParticule() {
        double x = RCouronne * random.nextDouble() * alea();
        double y = RCouronne * random.nextDouble() * alea();
        double z = RCouronne * random.nextDouble() * alea();
        Vector3D X = new Vector3D(x, y, z);
        Vector3D v = new Vector3D(0, 0, 0);
        Vector3D a = new Vector3D(0, 0, 0);
        Corps3D particle = new Corps3D(mParticle, X, v, a, false);
        allParticles.add(particle);
    }

    private int alea() {
        return !random.nextBoolean() ? -1 : 1;
    }
}
