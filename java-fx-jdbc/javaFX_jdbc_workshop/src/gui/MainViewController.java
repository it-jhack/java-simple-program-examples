package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
import model.services.DepartmentService;
import model.services.SellerService;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemSellerAction() {
        loadView("/gui/SellerList.fxml", (SellerListController controller) -> {
            controller.setSellerService(new SellerService());
            controller.updateTableView();
        });
    }

    @FXML
    public void onMenuItemDepartmentAction() {
        // second param is initializer lambda func:
        loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        });
    }

    @FXML
    public void onMenuItemAboutAction() {
        // empty lambda func as second param
        loadView("/gui/About.fxml", x -> {});
    }

    @Override
    public void initialize(URL uri, ResourceBundle rb) {
    }

    // func to open another view;
    // synchronized: guarantees all 'try' processing won't be interrupted during multi-threading;
    // func loadView now has generic type <T>;
    //
    // Now we don't need two separate loadView() functions,
    // as the same loadView func can load both non-action and action views;
    private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
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

            // special command to activate lambda func provided as param
            T controller = loader.getController();
            // Exec:
            initializingAction.accept(controller);
        }
        catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
        }
    }
}
