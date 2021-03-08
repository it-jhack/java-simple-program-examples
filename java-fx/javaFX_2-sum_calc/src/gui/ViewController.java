package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;

public class ViewController {
    // Treats events (clicking, typing forms, etc.)
    // Do not confuse "Controller" class with "controls" (buttons, text boxes, etc.)

    @FXML
    private TextField txtNumber1;

    @FXML
    private TextField txtNumber2;

    @FXML
    private Label labelResult;

    @FXML
    private Button btSum;

    // syntax: on + attribute + treated event
    // action == main event associated to that attribute (in the button case, it's the click)
    @FXML
    public void onBtSumClick() {
        try {
            Locale.setDefault(Locale.UK);

            double number1 = Double.parseDouble(txtNumber1.getText());
            double number2 = Double.parseDouble(txtNumber2.getText());
            double sum = number1 + number2;

            labelResult.setText(Double.toString(sum));

        }
        catch (NumberFormatException e) {
            Alerts.showAlert("Error", "Parse error", e.getMessage(), Alert.AlertType.ERROR);
        }

    }

//    On view (Scene Builder):
//    - Associate view to the controller (Controller tab)
//    - Select the control and associate it to the 'id' (Code tab)
//    - Select the control and associate the method to the event (Code tab)
}
