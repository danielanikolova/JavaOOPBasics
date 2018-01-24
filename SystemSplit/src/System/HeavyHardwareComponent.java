package System;



public class HeavyHardwareComponent extends HardwareComponent{

    String type;

    HeavyHardwareComponent(String name, int maximumCapacity, int getMaximumMemory) {
        super(name, maximumCapacity, getMaximumMemory);
        this.setMaximumCapacity(maximumCapacity*2);
        this.setGetMaximumMemory(getMaximumMemory -(getMaximumMemory/4));
        this.type ="Heavy";
    }


}
