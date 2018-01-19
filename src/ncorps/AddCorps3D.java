package ncorps;

import gui.DistribType;
import javafx.animation.AnimationTimer;
import ncorps.basephysic.Corps3D;
import ncorps.distribution.*;
import ncorps.parameter.Constants;

import java.util.List;
import java.util.Random;

abstract class AddCorps3D extends AnimationTimer implements Constants {
    List<Corps3D> allParticles;
    //  private int index;
    private IDistribution distrib;
    private Random random = new Random();


    IDistribution addCorps3D(DistribType distribType) {
        addCorps3D(distribType.getStrType());
        return distrib;
    }

    IDistribution addCorps3D(String strDistribType) {

        switch (strDistribType) {
            case "Anneau":
                distrib = new Anneau();
                break;
            case "Sphere":
                break;
            case "Ellipsoide":
                distrib = new Ellipsoide();
                break;
            case "Noyau":
                distrib = new Noyau(Constants.mCentre);
                break;
            case "Nuage":
                distrib = new Nuage();
                break;
            default:
                distrib = new Ellipsoide();
                break;
        }
        return distrib;
    }


//    void addParticule3() {
//        double r = R + random.nextDouble() * ep;
//        double theta = random.nextDouble() * 2 * PI;
//        double phi = random.nextDouble() * 2 * PI;
//        double x = r * sin(phi) * cos(theta);
//        double y = r * sin(phi) * sin(theta);
//        double z = r * cos(phi);
//        Vector3D X = new Vector3D(x, y, z);
//
//        // Vector3D v = new Vector3D(0, 0,0);
//        Vector3D v;
//        if (index < NbParticules / 2) {
//            v = new Vector3D(-sin(theta), cos(theta), 0);
//            v.multiply(multiply_vit_pos);
//        } else {
//            v = new Vector3D(sin(theta), -cos(theta), 0);
//            v.multiply(multiply_vit_neg);
//        }
//        index++;
//        Vector3D a = new Vector3D(0, 0, 0);
//        Corps3D particle = new Corps3D(mParticle, X, v, a, false);
//        allParticles.add(particle);
//    }

//
//    void addParticule_0(double mCentre) {
//
//    }
}
