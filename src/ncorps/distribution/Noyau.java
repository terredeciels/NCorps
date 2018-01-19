package ncorps.distribution;

import ncorps.basephysic.Corps3D;
import ncorps.math.Vector3D;
import ncorps.parameter.Constants;

public class Noyau implements IDistribution {

    private double mCentre;

    public Noyau(double mCentre) {
        this.mCentre = mCentre;
    }

    @Override
    public void addParticule() {
        double x = 0;
        double y = 0;
        double z = 0;
        Vector3D X = new Vector3D(x, y, z);
        Vector3D v = new Vector3D(0, 0, 0);
        Vector3D a = new Vector3D(0, 0, 0);
        Corps3D p;
        if (mCentre != 0) {
            p = new Corps3D(mCentre, X, v, a, true);
        } else {
            p = new Corps3D(Constants.mCentre, X, v, a, true);
        }
        allParticles.add(p);
    }
}
