package pl.kamilj.animalShelter.domain;


public class Animal{

    private Integer id;
    private String species;
    private String healthStatus;

    public Animal() {
    }

    public Animal(String species, String healthStatus) {
        this.species = species;
        this.healthStatus = healthStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
}
