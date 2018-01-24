package System;

import java.util.LinkedList;
import java.util.List;


public class PowerHardwareComponent extends HardwareComponent{

    private List<SoftwareComponent> softwares;

    PowerHardwareComponent(String name, int maximumCapacity, int getMaximumMemory) {
        super(name, maximumCapacity, getMaximumMemory);
        this.setType("Power");
        this.setMaximumCapacity(maximumCapacity-((maximumCapacity*3)/4));
        this.setGetMaximumMemory(getMaximumMemory+ ((getMaximumMemory*3)/4));
        this.softwares = new LinkedList<SoftwareComponent>();
    }



}
