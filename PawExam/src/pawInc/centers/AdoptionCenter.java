package pawInc.centers;

import pawInc.animals.Animal;

import java.util.List;
import java.util.stream.Collectors;

public class AdoptionCenter extends Center{

    public AdoptionCenter(String name) {
        super(name);
    }

    public List<Animal> getUncleansedAnimals(){
        List<Animal> uncleansed = super.getAnimals().stream()
                .filter(a->a.getCleansingStatus().equals("UNCLEANSED")).collect(Collectors.toList());
        List<Animal> cleansed = super.getAnimals().stream()
                .filter(a->a.getCleansingStatus().equals("CLEANSED")).collect(Collectors.toList());
        super.setAnimals(cleansed);

        return uncleansed;
    }

    public List<Animal> getUncleansedAnimalsToCastrate(){
        List<Animal> uncleansed = super.getAnimals().stream()
                .filter(a->a.getCleansingStatus().equals("UNCLEANSED")).collect(Collectors.toList());
//        List<Animal> cleansed = super.getAnimals().stream()
//                .filter(a->a.getCleansingStatus().equals("CLEANSED")).collect(Collectors.toList());
//        super.setAnimals(cleansed);

        super.removeAnimals(uncleansed);

        return uncleansed;
    }


    public List<Animal> adopt() {
        List<Animal> animals = super.getAnimals().stream()
                .filter(a->a.getCleansingStatus().equalsIgnoreCase("CLEANSED"))
                .collect(Collectors.toList());

        super.removeAnimals(animals);
        return animals;
    }

}
