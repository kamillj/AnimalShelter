package pl.kamilj.animalShelter.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;


public class MainController {

    @FXML private AnchorPane welcomeAnchorPane;
    @FXML private Button openAppButton;
    @FXML private Button openStaffOnlyButton;
    @FXML private Button closeAppButton;

    @FXML
    public void openApp() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu.fxml"));
        AnchorPane loginAnchorPane = loader.load();

        welcomeAnchorPane.getChildren().add(loginAnchorPane);
    }

    @FXML
    public void openStaffOnlyPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        AnchorPane settingsAnchorPane = loader.load();
        welcomeAnchorPane.getChildren().add(settingsAnchorPane);
    }

    @FXML
    public void closeApp() {
        welcomeAnchorPane.getScene().getWindow().hide();
    }
}
