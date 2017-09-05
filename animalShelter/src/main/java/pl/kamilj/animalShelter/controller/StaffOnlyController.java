package pl.kamilj.animalShelter.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import pl.kamilj.animalShelter.domain.Animal;
import pl.kamilj.animalShelter.hibernate.dao.AnimalHbmDAO;
import java.util.List;


public class StaffOnlyController {

    private ObservableList<String> speciesList = FXCollections.observableArrayList();
    private ObservableList<String> healthStatusList = FXCollections.observableArrayList();

    private AnimalHbmDAO animalHbmDAO = new AnimalHbmDAO();
    private Animal animal = new Animal();

    @FXML
    private AnchorPane staffOnlyAnchorPane;

    @FXML
    private TableColumn<Animal, String> speciesCol;

    @FXML
    private TableColumn<Animal, String> healthStatusCol;

    @FXML
    private TableView<Animal> animalsTable;

    @FXML
    private TableColumn<Animal, Integer> idCol;

    @FXML
    private Label title;

    @FXML
    private ChoiceBox<String> speciesChoiceBox;

    @FXML
    private ChoiceBox<String> healthStatusChoiceBox;

    @FXML
    private Label speciesLabel;

    @FXML
    private Label healthStatusLabel;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    public void initialize() {
        fillUpChoiceBoxes();
        loadDataFromDatabase();
    }

    private void fillUpChoiceBoxes(){
        ObservableList<String> speciesList = FXCollections.observableArrayList();
        ObservableList<String> healthStatusList = FXCollections.observableArrayList();
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

    private void loadDataFromDatabase() {
        List<Animal> animals = animalHbmDAO.findAll();
        ObservableList<Animal> animalsData = FXCollections.observableArrayList(animals);

        animalsTable.getItems().setAll(animalsData);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        speciesCol.setCellValueFactory(new PropertyValueFactory<>("species"));
        healthStatusCol.setCellValueFactory(new PropertyValueFactory<>("healthStatus"));
    }

    public void addAnimal(){
        String species = speciesChoiceBox.getValue();
        String healthStatus = healthStatusChoiceBox.getValue();
        animal.setSpecies(species);
        animal.setHealthStatus(healthStatus);
        animalHbmDAO.create(animal);
        loadDataFromDatabase();
    }

    public void deleteAnimal(){
        Animal animal;
        animal = animalsTable.getSelectionModel().getSelectedItem();
        animalHbmDAO.delete(animal);
        loadDataFromDatabase();
    }
}