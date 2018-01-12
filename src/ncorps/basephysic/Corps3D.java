package ncorps.basephysic;

import ncorps.EXForm;
import ncorps.math.Vector3D;

public class Corps3D extends EXForm.Xform
        // extends Region
{

    public final Vector3D v;// vitesse
    public final Vector3D a;
    public final Vector3D X;//position
    public final boolean centre;
    public double m;


    public Corps3D(double masse, Vector3D position, Vector3D velocity,
                   Vector3D acceleration, boolean centre) {
        super();
        m = masse;
        X = position;
        v = velocity;
        a = acceleration;
        this.centre = centre;

    }

}