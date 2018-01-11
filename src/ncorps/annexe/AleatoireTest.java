package ncorps.annexe;

import ncorps.parameter.Constants;
import ncorps.basephysic.Corps3D;
import ncorps.math.Vector3D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

class AleatoireTest implements Constants {
    private List<Corps3D> allParticles_deltaT;
    private Random random = new Random();

    AleatoireTest() {
        allParticles_deltaT = new ArrayList<>();
        IntStream.range(0, NbParticules0).forEach(i -> addParticule());
    }

    private void addParticule() {
        double x = RCouronne * random.nextDouble();
        double y = RCouronne * random.nextDouble();
        double z = RCouronne * random.nextDouble();
        Vector3D X = new Vector3D(x, y, z);
        Vector3D v = new Vector3D(0, 0, 0);
        Vector3D a = new Vector3D(0, 0, 0);
        Corps3D particle = new Corps3D(mParticle, X, v, a, false);
        allParticles_deltaT.add(particle);
    }
}
