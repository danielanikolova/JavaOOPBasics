package pawInc;

import pawInc.animals.Animal;
import pawInc.animals.Cat;
import pawInc.animals.Dog;
import pawInc.centers.AdoptionCenter;
import pawInc.centers.CastrationCenter;
import pawInc.centers.CleansingCenter;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalCenterManager {

    private Map<String, AdoptionCenter>adoptionCenters;
    private Map<String, CleansingCenter>cleansingCenters;
    private Map<String, CastrationCenter>castrationCenters;
    private Map<String, Animal>cleansedAnimals ;
    private Map<String, Animal>adoptedAnimals;
    private Map<String, Animal>castratedAnimals;


    public AnimalCenterManager() {
        this.adoptionCenters = new LinkedHashMap<>();
        this.cleansingCenters = new LinkedHashMap<>();
        this.castrationCenters = new LinkedHashMap<>();
        this.cleansedAnimals= new LinkedHashMap<>();
        this.adoptedAnimals = new LinkedHashMap<>();
        this.castratedAnimals = new LinkedHashMap<>();

    }

    public void registerCleansingCenter(String name){
        CleansingCenter center = new CleansingCenter(name);
        this.cleansingCenters.put(name, center);
    }

    public void registerAdoptionCenter(String name){
        AdoptionCenter center = new AdoptionCenter(name);
        this.adoptionCenters.put(name, center);
    }
    public void registerCastrationCenter (String name){
        CastrationCenter center = new CastrationCenter(name);
        this.castrationCenters.put(name, center);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName){
        Animal animal = new Dog(name, age, adoptionCenterName,learnedCommands);
        this.adoptionCenters.get(adoptionCenterName).register(animal);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName){
        Animal animal = new Cat(name, age,  adoptionCenterName,intelligenceCoefficient);
        this.adoptionCenters.get(adoptionCenterName).register(animal);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName){

        AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);
        CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);

        cleansingCenter.registerAll(adoptionCenter.getUncleansedAnimals());
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName){

        AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);
        CastrationCenter castrationCenter = this.castrationCenters.get(castrationCenterName);

        castrationCenter.registerAll(adoptionCenter.getUncleansedAnimalsToCastrate());
    }


    public void cleanse(String cleansingCenterName){

        List<Animal> cleansed = this.cleansingCenters.get(cleansingCenterName).cleanse();

        for (Animal animal:cleansed) {
            String centerName = animal.getAdoptionCenter();
            this.adoptionCenters.get(centerName).register(animal);
            this.cleansedAnimals.put(animal.getName(),animal);
        }

    }

    public void castrate (String castrationCenterName){

        List<Animal> castrated = this.castrationCenters.get(castrationCenterName).castrate();

        for (Animal animal:castrated) {
            String centerName = animal.getAdoptionCenter();
            this.adoptionCenters.get(centerName).register(animal);
            this.castratedAnimals.put(animal.getName(),animal);
        }

    }

    public void adopt(String adoptionCenterName){

        List<Animal> toAdopt = this.adoptionCenters.get(adoptionCenterName).adopt();

        for (Animal animal:toAdopt) {
                this.adoptedAnimals.put(animal.getName(), animal);
        }
    }


    public void castrationStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("Paw Inc. Regular Castration Statistics\n");
        sb.append(String.format("Castration Centers: %d\n",castrationCenters.size()) );

        sb.append("Castrated Animals: ");
        sb.append(getSortedAnimals(this.castratedAnimals)).append("\n");
        System.out.print(sb.toString());

    }

    public void printStatistics(){

        StringBuilder sb = new StringBuilder();

        sb.append("Paw Incorporative Regular Statistics\n");
        sb.append(String.format("Adoption Centers: %d\n",this.adoptionCenters.size()));
        sb.append(String.format("Cleansing Centers: %d\n", this.cleansingCenters.size()));
        sb.append("Adopted Animals: ");
        sb.append(getSortedAnimals(this.adoptedAnimals)).append("\n");
        sb.append("Cleansed Animals: ");
        sb.append(getSortedAnimals(this.cleansedAnimals)).append("\n");
        int awaitingAdoption=0;
        for (AdoptionCenter center:this.adoptionCenters.values()) {
            awaitingAdoption += center.getAnimals().stream()
                    .filter(a->a.getCleansingStatus().equalsIgnoreCase("CLEANSED"))
            .collect(Collectors.toList()).size();
        }
        sb.append(String.format("Animals Awaiting Adoption: %d\n", awaitingAdoption));

        int awaitingCleansing = 0;
        for (CleansingCenter center:this.cleansingCenters.values()) {
            awaitingCleansing+= center.getAnimals().stream()
                    .filter(a->a.getCleansingStatus().equalsIgnoreCase("UNCLEANSED"))
                    .collect(Collectors.toList()).size();
        }

        sb.append(String.format("Animals Awaiting Cleansing: %d\n", awaitingCleansing));
        System.out.println(sb.toString());
    }

    public String getSortedAnimals(Map<String, Animal> animals) {
        if (animals.isEmpty()) {
            return "None";
        }

        List<String> sorted = animals.keySet().stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        return String.join(", ", sorted);
    }

}
