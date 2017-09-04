package pl.kamilj.animalShelter.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import pl.kamilj.animalShelter.domain.Animal;
import pl.kamilj.animalShelter.hibernate.configuration.HibernateUtil;
import pl.kamilj.animalShelter.hibernate.dao.AnimalHbmDAO;

public class AddingToAdoptionController {

    ObservableList<String> speciesList = FXCollections.observableArrayList();
    ObservableList<String> healthStatusList = FXCollections.observableArrayList();

    AnimalHbmDAO animalHbmDAO = new AnimalHbmDAO();
    Animal animal = new Animal();

    private String species;
    private String healthStatus;

    @FXML
    private Button giveToAdoptionButton;

    @FXML
    private GridPane giveToAdoptionGridPane;

    @FXML
    private Label healthStatusLabel;

    @FXML
    private ImageView dogToAdpot;

    @FXML
    private ChoiceBox<String> speciesChoiceBox;

    @FXML
    private AnchorPane giveToAdoptionAnchorPane;

    @FXML
    private Label speciesLablel;

    @FXML
    private ChoiceBox<String> healthStatusChoiceBox;

    @FXML
    void initialize() {
        healthStatusList.add(0, "Very good");
        healthStatusList.add(1, "Good");
        healthStatusList.add(2, "Medium");
        healthStatusList.add(3, "Bad");
        healthStatusList.add(4, "Very bad");

        speciesList.add(0, "Dog");
        speciesList.add(1,"Cat");
        speciesList.add(2, "Pig");
        speciesList.add(3, "Parrot");
        speciesList.add(4, "Hamster");

        speciesChoiceBox.setItems(speciesList);
        healthStatusChoiceBox.setItems(healthStatusList);
    }

    public void giveToAdoption() {

        species = speciesChoiceBox.getValue();
        healthStatus = healthStatusChoiceBox.getValue();
        animal.setSpecies(species);
        animal.setHealthStatus(healthStatus);
        animalHbmDAO.create(animal);

        HibernateUtil.shutdown();
    }
}
