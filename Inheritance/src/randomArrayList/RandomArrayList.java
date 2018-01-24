package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList{

    Random random = new Random();
    public Object getRandomElement(RandomArrayList ral){
        int index = random.nextInt(super.size()-1);
        Object element = super.get(index);
        ral.remove(index);
        return element;
    }

}
