package pl.kamilj.animalShelter.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import pl.kamilj.animalShelter.domain.Animal;
import pl.kamilj.animalShelter.hibernate.dao.AnimalHbmDAO;

import java.io.IOException;


public class MenuController {

    @FXML private AnchorPane menuAnchorPage;
    @FXML private GridPane menuGridPane;
    @FXML private Button openLAnimalList;
    @FXML private Button openAdoptionFormButton;
    @FXML private Button openDonatePageButton;
    @FXML private ImageView dogToAdpot;

    @FXML public void openAnimalList() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/adoption.fxml"));
        AnchorPane adoptionAnchorPane = loader.load();

        menuAnchorPage.getChildren().add(adoptionAnchorPane);
    }

    @FXML
    public void openAdoptionForm() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addingToAdoption.fxml"));
        AnchorPane addingToAdoptionAnchorPane = loader.load();

        menuAnchorPage.getChildren().add(addingToAdoptionAnchorPane);
    }

    @FXML
    public void openDonatePage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/donate.fxml"));
        AnchorPane donateAnchorPage = loader.load();

        menuAnchorPage.getChildren().add(donateAnchorPage);
    }
}
