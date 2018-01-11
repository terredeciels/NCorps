package ncorps;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static ncorps.Vector3D.subtract;

class Gravity {

    List<Corps3D> allParticles_deltaT;
    private double distCollision;
    private List<Corps3D> allParticules;
    private double deltaT;
    private ArrayList<Corps3D> listCorpsRemove;

    Gravity(List<Corps3D> allParticules, double distCollision, double deltaT) {
        this.listCorpsRemove = new ArrayList<>();
        this.allParticules = allParticules;
        this.deltaT = deltaT;
        this.distCollision = distCollision;
        if (distCollision == 0) this.distCollision = Constants.distCollision;
        allParticles_deltaT = new ArrayList<>();
        allParticules.forEach(this::acc);
    }

    private void acc(Corps3D p) {
        if (!p.centre) {
            for (Corps3D q : allParticules) {
                if (!p.equals(q)) {//equals ?
                    double dist = subtract(q.X, p.X).magnitude();
                    double dist3 = pow(dist, 3);
                    p.a.x += q.m * (q.X.x - p.X.x) / dist3;
                    p.a.y += q.m * (q.X.y - p.X.y) / dist3;
                    p.a.z += q.m * (q.X.z - p.X.z) / dist3;
                    if (dist < distCollision) {// rebond entre 2 corps
                        p.a.x = -p.a.x;
                        p.a.y = -p.a.y;
                        p.a.z = -p.a.z;
                    }
                }
            }

        } else {
            // absoption corps par le centre
            for (Corps3D q : allParticules) {
                if (!p.equals(q)) {
                    double dist = subtract(q.X, p.X).magnitude();
                    if (dist < distCollision) {
                        //p.m += q.m;
                        listCorpsRemove.add(q);
                    }
                }
            }
            // mouvement du centre
            for (Corps3D q : allParticules) {
                if (!p.equals(q)) {//equals ?
                    double dist = subtract(q.X, p.X).magnitude();
                    double dist3 = pow(dist, 3);
                    p.a.x += q.m * (q.X.x - p.X.x) / dist3;
                    p.a.y += q.m * (q.X.y - p.X.y) / dist3;
                    p.a.z += q.m * (q.X.z - p.X.z) / dist3;
                }
            }
        }
        allParticles_deltaT.add(p);
        if (!listCorpsRemove.isEmpty()) {
            allParticles_deltaT.removeAll(listCorpsRemove);
            listCorpsRemove = new ArrayList<>();
        }
    }

    void move() {
        for (Corps3D p : allParticles_deltaT) {
            double deltaT2 = pow(deltaT, 2) / 2;
            //positions
            p.X.x += deltaT2 * p.a.x + deltaT * p.v.x;
            p.X.y += deltaT2 * p.a.y + deltaT * p.v.y;
            p.X.z += deltaT2 * p.a.z + deltaT * p.v.z;
            //vitesses
            p.v.x += p.a.x;
            p.v.y += p.a.y;
            p.v.z += p.a.z;
        }
    }

    private void acc2(Corps3D p) {
        for (Corps3D q : allParticules) {
            if (!p.equals(q)) {
                double dist = subtract(q.X, p.X).magnitude();
                double dist3 = pow(dist, 3);
                p.a.x += q.m * (q.X.x - p.X.x) / dist3;
                p.a.y += q.m * (q.X.y - p.X.y) / dist3;
                p.a.z += q.m * (q.X.z - p.X.z) / dist3;
            }
        }
        allParticles_deltaT.add(p);
    }

    void move2() {
        for (Corps3D p : allParticles_deltaT) {
            double deltaT2 = pow(deltaT, 2) / 2;
            //positions
            p.X.x += deltaT2 * p.a.x + deltaT * p.v.x;
            p.X.y += deltaT2 * p.a.y + deltaT * p.v.y;
            p.X.z += deltaT2 * p.a.z + deltaT * p.v.z;
            //vitesses
            p.v.x += p.a.x;
            p.v.y += p.a.y;
            p.v.z += p.a.z;
        }
    }
}
