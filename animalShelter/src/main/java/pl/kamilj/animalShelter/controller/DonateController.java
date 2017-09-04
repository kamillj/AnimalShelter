package pl.kamilj.animalShelter.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class DonateController {

    @FXML private Button donateUsButton;
    @FXML private Label donateStatusLabel;
    @FXML private ImageView dogToAdpot;
    @FXML private RadioButton r1;
    @FXML private RadioButton r2;
    @FXML private RadioButton r3;
    @FXML private RadioButton r4;
    @FXML private RadioButton r5;
    @FXML private RadioButton r6;
    @FXML private GridPane donateGridPane;
    @FXML private AnchorPane donateAnchorPage;


    @FXML
    void initialize(){
        ToggleGroup group = new ToggleGroup();
        r1.setToggleGroup(group);
        r2.setToggleGroup(group);
        r3.setToggleGroup(group);
        r4.setToggleGroup(group);
        r5.setToggleGroup(group);
        r6.setToggleGroup(group);
    }

    @FXML
    void donate() {
        if(r1.isSelected() || r2.isSelected() || r3.isSelected() ||
                r4.isSelected() || r5.isSelected() || r6.isSelected()){
            donateStatusLabel.setText("Thank You!\nYou helped our animals so much!");
        } else {
            donateStatusLabel.setText("Please select\nhow much you want help animals.");
        }
    }
}
