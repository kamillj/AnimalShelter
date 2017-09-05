package pl.kamilj.animalShelter.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import pl.kamilj.animalShelter.domain.Animal;
import pl.kamilj.animalShelter.hibernate.dao.AnimalHbmDAO;
import java.util.List;


public class AdoptionController{

    private AnimalHbmDAO animalHbmDAO = new AnimalHbmDAO();

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
    private Button adoptButton;

    @FXML
    private Label adoptionLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label statusDescripionLabel;

    @FXML
    public void initialize() {
        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {

        List<Animal> animals = animalHbmDAO.findAll();
        ObservableList<Animal> animalsData = FXCollections.observableArrayList(animals);

        animalsTable.getItems().setAll(animalsData);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        species.setCellValueFactory(new PropertyValueFactory<>("species"));
        healthStatus.setCellValueFactory(new PropertyValueFactory<>("healthStatus"));
    }

    public void adopt(){
        Animal animal;
        animal = animalsTable.getSelectionModel().getSelectedItem();
        if(animalsTable.getSelectionModel().isEmpty()){
            statusLabel.setText("FAILED");
            statusDescripionLabel.setText("Please select an animal");
        } else {
            animalHbmDAO.delete(animal);
            loadDataFromDatabase();
            statusDescripionLabel.setText("");
            statusLabel.setText("SUCCESS");
        }
    }
}