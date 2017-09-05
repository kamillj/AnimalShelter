package pl.kamilj.animalShelter.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import pl.kamilj.animalShelter.domain.Animal;
import pl.kamilj.animalShelter.hibernate.dao.AnimalHbmDAO;
import java.util.List;


public class AdoptionController{

    @FXML
    private AnchorPane adoptionAnchorPane;

    @FXML
    private TableView<Animal> animalsTable;

    @FXML
    private TableColumn<Animal, Integer> id;

    @FXML
    private TableColumn<Animal, String> species;

    @FXML
    private TableColumn<Animal, String> healthStatus;

    @FXML
    public void initialize() {
        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        AnimalHbmDAO animalHbmDAO = new AnimalHbmDAO();
        Animal dog = new Animal("Dog", "Good");
        Animal cat = new Animal("Cat", "Very good");
        animalHbmDAO.create(dog);
        animalHbmDAO.create(cat);

        List<Animal> animals = animalHbmDAO.findAll();
        ObservableList<Animal> animalsData = FXCollections.observableArrayList(animals);

        animalsTable.getItems().addAll(animalsData);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        species.setCellValueFactory(new PropertyValueFactory<>("species"));
        healthStatus.setCellValueFactory(new PropertyValueFactory<>("healthStatus"));
    }
}
