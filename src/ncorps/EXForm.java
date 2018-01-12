package ncorps;

import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class EXForm {
    final Xform world = new Xform();
    final Xform cameraXform = new Xform();
    final Xform cameraXform2 = new Xform();
    final Xform cameraXform3 = new Xform();
    final Xform axisGroup = new Xform();

    public static class Xform extends Group {

        public Translate t = new Translate();
        //    private Translate p = new Translate();
        //    private Translate ip = new Translate();
        public Rotate rx = new Rotate();
        public Rotate ry = new Rotate();
        Rotate rz = new Rotate();
        Scale s = new Scale();

        {
            rx.setAxis(Rotate.X_AXIS);
        }

        {
            ry.setAxis(Rotate.Y_AXIS);
        }

        {
            rz.setAxis(Rotate.Z_AXIS);
        }

        public Xform() {
            super();
            getTransforms().addAll(t, rz, ry, rx, s);
        }

//    public void setRotateZ(double z) {
//        rz.setAngle(z);
//    }

    }
}
