package pl.kamilj.animalShelter.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PrimaryController {

    @FXML private AnchorPane mainAnchorPane;

    @FXML
    public void initialize() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        AnchorPane menuAnchorPane = loader.load();

        mainAnchorPane.getChildren().add(menuAnchorPane);
    }
}
