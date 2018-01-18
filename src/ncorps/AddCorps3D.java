package ncorps;

import gui.DistribType;
import javafx.animation.AnimationTimer;
import ncorps.basephysic.Corps3D;
import ncorps.distribution.Anneau;
import ncorps.distribution.Ellipsoide;
import ncorps.distribution.IDistribution;
import ncorps.distribution.Noyau;
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
                distrib = new Noyau();
                break;
            case "Nuage":
//                distrib = new Nuage();
//                break;
            default:
                distrib = new Ellipsoide();

        }
        return distrib;
    }


//    void addParticule() {
//        double X0 = 50, Y0 = 50, Z0 = 50, R0 = 30;
//        double vit_pos = 1000.0;
//        double r = R0 * random.nextDouble();
//        double theta = random.nextDouble() * 2 * PI;
//        double phi = random.nextDouble() * 2 * PI;
//        double x = r * sin(phi) * cos(theta) + X0;
//        double y = r * sin(phi) * sin(theta) + Y0;
//        double z = r * cos(phi) + Z0;
//        Vector3D X = new Vector3D(x, y, z);
//
//        Vector3D v = new Vector3D(-vit_pos, 0, 0);
//
//        Vector3D a = new Vector3D(0, 0, 0);
//        Corps3D particle = new Corps3D(mParticle, X, v, a, false);
//        allParticles.add(particle);
//    }

//    void addParticule_0(double rCentre) {
//        double x = 0;
//        double y = 0;
//        double z = 0;
//        Vector3D X = new Vector3D(x, y, z);
//        Vector3D v = new Vector3D(0, 0, 0);
//        Vector3D a = new Vector3D(0, 0, 0);
//        Corps3D p;
//        if (rCentre != 0) {
//            p = new Corps3D(rCentre, X, v, a, true);
//        } else {
//            p = new Corps3D(mCentre, X, v, a, true);
//        }
//        allParticles.add(p);
//    }

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
//    void addParticule_0(double rCentre) {
//
//    }
}
