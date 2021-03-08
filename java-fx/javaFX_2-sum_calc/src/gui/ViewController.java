package gui;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewController implements Initializable {
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 'url' is the location of the .fxml file.
        // 'rb' can be used to use strings of different languages: https://stackoverflow.com/questions/26325403/how-to-implement-language-support-for-javafx-in-fxml-documents

        // Actions to be exec when instantiating Controller:
        Constraints.setTextFieldDouble(txtNumber1);
        Constraints.setTextFieldDouble(txtNumber2);
        Constraints.setTextFieldMaxLength(txtNumber1, 12);
        Constraints.setTextFieldMaxLength(txtNumber2, 12);
    }

//    On view (Scene Builder):
//    - Associate view to the controller (Controller tab)
//    - Select the control and associate it to the 'id' (Code tab)
//    - Select the control and associate the method to the event (Code tab)
}
