package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
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
    private ComboBox<DistribType> comboboxType;
    private ObservableList<DistribType> myComboBoxData = FXCollections.observableArrayList();
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

    public EventHandlingController() {
        // Create some sample data for the ComboBox and ListView.
        myComboBoxData.add(new DistribType("Hans"));
        myComboBoxData.add(new DistribType("Ruth"));
        myComboBoxData.add(new DistribType("Heinz"));
        myComboBoxData.add(new DistribType("Cornelia"));
        myComboBoxData.add(new DistribType("Werner"));

    }

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
        // Init ComboBox items.
        comboboxType.setItems(myComboBoxData);

        // Define rendering of the list of values in ComboBox drop down.
        comboboxType.setCellFactory((comboBox) -> {
            return new ListCell<DistribType>() {
                @Override
                protected void updateItem(DistribType item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.getStrType());
                    }
                }
            };
        });
        comboboxType.setConverter(new StringConverter<DistribType>() {
            @Override
            public String toString(DistribType distribType) {
                if (distribType == null) {
                    return null;
                } else {
                    return distribType.getStrType();
                }
            }

            @Override
            public DistribType fromString(String personString) {
                return null; // No conversion fromString needed.
            }
        });
        comboboxType.setOnAction((event) -> {
            DistribType selectedDistribType = comboboxType.getSelectionModel().getSelectedItem();
            outputTextArea.appendText("ComboBox Action (selected: " + selectedDistribType.toString() + ")\n");
        });

    }

}