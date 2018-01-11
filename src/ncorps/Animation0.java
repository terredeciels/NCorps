package ncorps;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Animation0 extends AddCorps3D implements Constants {

    private final double distCollision;
    PhongMaterial whitemat;
    private NCorps3DApp ncorps;
    private Xform nbodyGroup;
    private Xform nbodyGroup2;
    private boolean first;
    private long now0 = 0;

    Animation0(NCorps3DApp ncorps) {
        // first = true;
        this.ncorps = ncorps;
        distCollision = ncorps.distCollision;
        allParticles = new ArrayList<>();
        IntStream.range(0, ncorps.NbParticules).forEach(i -> addParticule());
        addParticule_0(ncorps.rCentre);
        whitemat = getPhongMaterial();
    }

    @Override
    public void handle(long now) {

        //System.out.println(now);
//        if (first) {
//            now0 = now;
//            first = false;
//        } else {
//            if (now - now0 > step){
//                stop();
//            }
//        }

        pause(dT); //50000000.0

        nbodyGroup2 = nbodyGroup;
        // AleatoireTest g = new AleatoireTest();
        Gravity g = new Gravity(allParticles, distCollision, DeltaT);
        g.move();
        nbodyGroup = new Xform();
        g.allParticles_deltaT.forEach(this::createSphere);

        allParticles = g.allParticles_deltaT;

        ncorps.world.getChildren().removeAll(nbodyGroup2);
        ncorps.world.getChildren().addAll(nbodyGroup);
    }

    private void pause(double dT) {
        int t = 0;
        while (t < dT) {
            t++;
        }
    }


    private void createSphere(Corps3D p) {

        Sphere sphere;
        PhongMaterial materialCentre = new PhongMaterial();
        materialCentre.setDiffuseColor(Color.ORANGE);
        materialCentre.setSpecularColor(Color.ORANGE);
        if (p.centre) {
            sphere = new Sphere(diamMCentre);
            sphere.setMaterial(materialCentre);
        } else {
            sphere = new Sphere(p.m);
            sphere.setMaterial(whitemat);
        }
        sphere.setTranslateX(p.X.x);
        sphere.setTranslateY(p.X.y);
        sphere.setTranslateZ(p.X.z);
        // System.out.println(p.X.x+","+p.X.y+","+p.X.z);
        nbodyGroup.getChildren().add(sphere);
    }

    private PhongMaterial getPhongMaterial() {
//        final PhongMaterial greymat = new PhongMaterial();
//        greymat.setDiffuseColor(Color.DARKGREY);
//        greymat.setSpecularColor(Color.DARKGREY);
        final PhongMaterial whitemat = new PhongMaterial();
        whitemat.setDiffuseColor(Color.WHITE);
        whitemat.setSpecularColor(Color.WHITE);
        return whitemat;
    }
}
