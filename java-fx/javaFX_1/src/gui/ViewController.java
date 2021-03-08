package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ViewController {
    // Treats events (clicking, typing forms, etc.)
    // Do not confuse "Controller" class with "controls" (buttons, text boxes, etc.)

    @FXML
    private Button btTest;

    // syntax: on + attribute + treated event
    // action == main event associated to that attribute (in the button case, it's the click)
    @FXML
    public void onBtTestAction() {
        Alerts.showAlert("alertTitle",
                "alertHeader", // can be null
                "alertContent",
                Alert.AlertType.INFORMATION);
    }

//    On view (Scene Builder):
//    - Associate view to the controller (Controller tab)
//    - Select the control and associate it to the 'id' (Code tab)
//    - Select the control and associate the method to the event (Code tab)
}
