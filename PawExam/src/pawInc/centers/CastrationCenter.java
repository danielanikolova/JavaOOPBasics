package pawInc.centers;

import pawInc.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class CastrationCenter extends Center{


    public CastrationCenter(String name) {
        super(name);
    }

    public List<Animal> castrate() {
        List<Animal> animals = super.getAnimals();

        super.setAnimals(new ArrayList<>());
        return animals;
    }
}
