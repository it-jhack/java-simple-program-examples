package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemSellerAction() {
        System.out.println("onMenuItemSellerAction");
    }

    @FXML
    public void onMenuItemDepartmentAction() {
        System.out.println("onMenuItemDepartmentAction");
    }

    @FXML
    public void onMenuItemAboutAction() {
        loadView("/gui/About.fxml");
    }

    @Override
    public void initialize(URL uri, ResourceBundle rb) {
    }

    // func to open another window
    // synchronized: guarantees all 'try' processing won't be interrupted during multi-threading
    private synchronized void loadView(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            // new vbox
            VBox newVBox = loader.load();

            // calling scene at Main though getMainScene()
            Scene mainScene = Main.getMainScene();
            // getting a reference to VBox on main window
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            // first child of main Window VBOX == main menu
            Node mainMenu = mainVBox.getChildren().get(0);
            // cleaning all children from main vbox
            mainVBox.getChildren().clear();
            // adding main menu to vbox
            mainVBox.getChildren().add(mainMenu);
            // adding children of new vbox
            mainVBox.getChildren().addAll(newVBox.getChildren());
        }
        catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
        }
    }
}
