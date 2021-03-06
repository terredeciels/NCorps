package ncorps;

import gui.DistribType;
import javafx.scene.DepthTest;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ncorps.parameter.Constants;

public class NCorps3DApp extends Action3D implements Constants {

    final int NbParticules;
    final double mCentre;
    final double distCollision;
    final DistribType distribType;

    public NCorps3DApp(int nbPart, double mCentreVal, double distColl, DistribType distribT) {
        NbParticules = nbPart;
        mCentre = mCentreVal;
        distCollision = distColl;
        distribType = distribT;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        root.getChildren().add(Univers.world);
        root.setDepthTest(DepthTest.ENABLE);
        buildCamera();
        buildAxes();
        double W = 900.0;
        double H = 600.0;
        Scene scene = new Scene(root, W, H, true);
        scene.setFill(Color.BLACK);
        handleKeyboard(scene, Univers.world);
        handleMouse(scene, Univers.world);
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
