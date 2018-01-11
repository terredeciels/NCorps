package ncorps;

import javafx.scene.paint.Color;

public interface Constants {

    int NbParticules0 = 500;
    double mCentre = 100000.0;

    double DeltaT = 0.00005;
    // double step = 900000000.0;//nanosec
    double dT = 10000000.0;
    double R = 100.0;
    double mParticle = 1.0;

    double ep = 2.0;
    double multiply_vit_pos = 5000.0;
    double multiply_vit_neg = 5000.0;
    double diamMCentre = 7.0;

    double distCollision = 8;

    double RCouronne = 150.0;
    //double rSphere = 1.0;
    // double P = 768;

    Color graphicsContextsetFill = Color.BLACK;
    Color color_ball_center = Color.BLUE;
    Color color_ball = Color.WHITE;
    double diamPartFact = 1.0;


}
