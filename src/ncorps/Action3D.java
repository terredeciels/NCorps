package ncorps;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public abstract class Action3D extends Application {

    final PerspectiveCamera camera = new PerspectiveCamera(true);
    final Group root = new Group();
    final EXForm Univers = new EXForm();
    Animation0 anim;
    private double CAMERA_INITIAL_X_ANGLE = 70.0;
    private double CAMERA_INITIAL_Y_ANGLE = 320.0;
    private double CAMERA_NEAR_CLIP = 0.1;
    private double CAMERA_FAR_CLIP = 10000.0;
    private double AXIS_LENGTH = 250.0;
    private double CONTROL_MULTIPLIER = 0.1;
    private double SHIFT_MULTIPLIER = 10.0;
    private double MOUSE_SPEED = 0.1;
    private double ROTATION_SPEED = 2.0;
    private double TRACK_SPEED = 0.3;
    private double CAMERA_INITIAL_DISTANCE = -450;
    private double mousePosX, mousePosY, mouseOldX, mouseOldY, mouseDeltaX, mouseDeltaY;

    void buildCamera() {
        // System.out.println("buildCamera()");
        root.getChildren().add(Univers.cameraXform);
        Univers.cameraXform.getChildren().add(Univers.cameraXform2);
        Univers.cameraXform2.getChildren().add(Univers.cameraXform3);
        Univers.cameraXform3.getChildren().add(camera);
        // cameraXform3.setRotateZ(180.0);
        Univers.cameraXform3.rz.setAngle(180.0);
        camera.setNearClip(CAMERA_NEAR_CLIP);
        camera.setFarClip(CAMERA_FAR_CLIP);
        camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
        Univers.cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
        Univers.cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
    }

    void buildAxes() {
        // System.out.println("buildAxes()");
        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.LIGHTGRAY);
        blueMaterial.setSpecularColor(Color.GREY);

        final Box xAxis = new Box(AXIS_LENGTH, 1, 0.2);
        final Box yAxis = new Box(0.2, AXIS_LENGTH, 1);
        final Box zAxis = new Box(0.2, 1, AXIS_LENGTH);

        xAxis.setMaterial(blueMaterial);
        yAxis.setMaterial(blueMaterial);
        zAxis.setMaterial(blueMaterial);

        Univers.axisGroup.getChildren().addAll(xAxis, yAxis, zAxis);
        Univers.axisGroup.setVisible(true);
        Univers.world.getChildren().addAll(Univers.axisGroup);
    }

    void handleMouse(Scene scene, final Node root) {

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                mousePosX = me.getSceneX();
                mousePosY = me.getSceneY();
                mouseOldX = me.getSceneX();
                mouseOldY = me.getSceneY();
            }
        });
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                mouseOldX = mousePosX;
                mouseOldY = mousePosY;
                mousePosX = me.getSceneX();
                mousePosY = me.getSceneY();
                mouseDeltaX = (mousePosX - mouseOldX);
                mouseDeltaY = (mousePosY - mouseOldY);

                double modifier = 1.0;

                if (me.isControlDown()) {
                    modifier = CONTROL_MULTIPLIER;
                }
                if (me.isShiftDown()) {
                    modifier = SHIFT_MULTIPLIER;
                }
                if (me.isPrimaryButtonDown()) {
                    Univers.cameraXform.ry.setAngle(Univers.cameraXform.ry.getAngle() - mouseDeltaX * MOUSE_SPEED * modifier * ROTATION_SPEED);
                    Univers.cameraXform.rx.setAngle(Univers.cameraXform.rx.getAngle() + mouseDeltaY * MOUSE_SPEED * modifier * ROTATION_SPEED);
                } else if (me.isSecondaryButtonDown()) {
                    double z = camera.getTranslateZ();
                    double newZ = z + mouseDeltaX * MOUSE_SPEED * modifier;
                    camera.setTranslateZ(newZ);
                } else if (me.isMiddleButtonDown()) {
                    Univers.cameraXform2.t.setX(Univers.cameraXform2.t.getX() + mouseDeltaX * MOUSE_SPEED * modifier * TRACK_SPEED);
                    Univers.cameraXform2.t.setY(Univers.cameraXform2.t.getY() + mouseDeltaY * MOUSE_SPEED * modifier * TRACK_SPEED);
                }
            }
        });
    }

    void handleKeyboard(Scene scene, final Node root) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case Z:
                        Univers.cameraXform2.t.setX(0.0);
                        Univers.cameraXform2.t.setY(0.0);
                        camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
                        Univers.cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
                        Univers.cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
                        break;
                    case X:
                        Univers.axisGroup.setVisible(!Univers.axisGroup.isVisible());
                        break;
//                    case V:
//                        nbodyGroup.setVisible(!nbodyGroup.isVisible());
//                        break;
                    case P:
                        anim.stop();
                        break;
                    case S:
                        anim.start();
                        break;

                }
            }
        });
    }
}
