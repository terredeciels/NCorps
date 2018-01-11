package ncorps;

import javafx.scene.DepthTest;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ncorps.parameter.Constants;

public class NCorps3DApp extends Action3D implements Constants {


    final int NbParticules;
    final double rCentre;
    final double distCollision;

    public NCorps3DApp(int nbPart, double rCentreVal, double distColl) {
        NbParticules = nbPart;
        rCentre = rCentreVal;
        distCollision = distColl;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // System.out.println("start()");

        root.getChildren().add(world);
        root.setDepthTest(DepthTest.ENABLE);

        buildCamera();
        buildAxes();
        //buildBody();
        // world.getChildren().addAll(nbodyGroup);

        double W = 900.0;
        double H = 600.0;
        Scene scene = new Scene(root, W, H, true);
        scene.setFill(Color.BLACK);
        handleKeyboard(scene, world);
        handleMouse(scene, world);
        primaryStage.setTitle("NCorps");
        primaryStage.setScene(scene);
        primaryStage.setX(305);
        primaryStage.setY(0);
        primaryStage.show();

        scene.setCamera(camera);

        anim = new Animation0(this);
        anim.start();

    }


}
