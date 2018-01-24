package pawInc.centers;

import pawInc.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class CleansingCenter extends Center{
    public CleansingCenter(String name) {
        super(name);
    }

    public List<Animal> cleanse(){
        super.getAnimals().forEach(a->a.setCleansingStatus("CLEANSED"));

        return super.getAnimals();
    }

}
