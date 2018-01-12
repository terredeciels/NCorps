package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ncorps.NCorps3DApp;
import ncorps.parameter.Constants;

import static java.lang.System.exit;

public class EventHandlingController {
    @FXML
    public Button resetButton;
    @FXML
    public TextField rCentre;
    @FXML
    public Slider distCollisionSlider;
    @FXML
    public Button quitButton;
    @FXML
    private Button myButton;
    @FXML
    private Slider mySlider;
    @FXML
    private TextArea outputTextArea;

    private int NbParticules;
    private Stage primestage2;
    private double rCentreVal;
    private double distCollision;

    @FXML
    private void initialize() {
        myButton.setOnAction((event) -> {
            outputTextArea.appendText("Start\n" + NbParticules);
            if (NbParticules == 0) {
                NbParticules = Constants.NbParticules0;
            }
            primestage2 = new Stage();
            new NCorps3DApp(NbParticules, rCentreVal, distCollision).start(primestage2);
        });
        resetButton.setOnAction((event) -> {
            outputTextArea.appendText("Reset\n");
            primestage2.close();
        });
        quitButton.setOnAction((event) -> {
            primestage2.close();
            exit(0);
        });
        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            outputTextArea.appendText("NbParticules : " + newValue.intValue() + "\n");
            NbParticules = newValue.intValue();
        });
        distCollisionSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            outputTextArea.appendText("distCollision : " + newValue.intValue() + "\n");
            distCollision = newValue.intValue();
        });
        rCentre.textProperty().addListener((observable, oldValue, newValue) -> {
            outputTextArea.appendText(String.valueOf(Constants.mCentre));
            outputTextArea.appendText("rCentre : " + newValue + "\n");
            rCentreVal = Double.parseDouble(newValue);
        });

    }

}