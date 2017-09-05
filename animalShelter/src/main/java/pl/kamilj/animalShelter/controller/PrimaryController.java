package pl.kamilj.animalShelter.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import pl.kamilj.animalShelter.domain.Animal;
import pl.kamilj.animalShelter.hibernate.dao.AnimalHbmDAO;
import java.io.IOException;

public class PrimaryController {

    @FXML private AnchorPane mainAnchorPane;

    @FXML
    public void initialize() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        AnchorPane menuAnchorPane = loader.load();
        mainAnchorPane.getChildren().add(menuAnchorPane);
        createExampleAnimals();
    }

    private void createExampleAnimals(){
        AnimalHbmDAO animalHbmDAO = new AnimalHbmDAO();
        Animal dog = new Animal("Dog", "Good");
        Animal cat = new Animal("Cat", "Very bad");
        animalHbmDAO.create(dog);
        animalHbmDAO.create(cat);
    }
}
