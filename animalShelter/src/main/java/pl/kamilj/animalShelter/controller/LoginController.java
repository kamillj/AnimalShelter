package pl.kamilj.animalShelter.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;


import java.io.IOException;


public class LoginController {

    @FXML private GridPane loginGridPane;
    @FXML private AnchorPane loginAnchorPane;
    @FXML private PasswordField passwordField;
    @FXML private Label loginLabel;
    @FXML private Button signInButton;
    @FXML private TextField loginField;
    @FXML private Label passwordLabel;
    @FXML private Label loginStatusLabel;
    @FXML private ImageView dogToAdpot;

    @FXML
    void initialize() {

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Checking login and password...");
                if (!(loginField.getText().equals("user") && passwordField.getText().equals("user"))) {
                    loginStatusLabel.setText("Login FAILED");
                } else {
                    loginStatusLabel.setText("Login SUCCESS");

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu.fxml"));
                    AnchorPane mainPageAnchorPage = null;
                    try {
                        mainPageAnchorPage = loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    loginAnchorPane.getChildren().setAll(mainPageAnchorPage);
                }
            }
        };
        signInButton.addEventHandler(ActionEvent.ACTION, handler);
    }
}
