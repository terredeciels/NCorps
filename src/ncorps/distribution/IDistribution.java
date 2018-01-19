package ncorps.distribution;

import ncorps.basephysic.Corps3D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface IDistribution {
    Random random = new Random();
    List<Corps3D> allParticles = new ArrayList<>();

    void addParticule();
}
