package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {

    // Access the stage where my control (that received the event) is
    // Example: when clicking a button, get the stage of that button.
    public static Stage currentStage(ActionEvent event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    public static Integer tryParseToInt(String str) {
        // either return an int number or return null
        try {
            return Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            return null;
        }
    }
}
