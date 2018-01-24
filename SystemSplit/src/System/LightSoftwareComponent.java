package System;

public class LightSoftwareComponent extends SoftwareComponent{

    public LightSoftwareComponent(String name, int maximumCapacity, int maximumMemory) {
        super(name, maximumCapacity, maximumMemory);
        this.setType("Light");
        super.setCapacityConsumption( maximumCapacity + maximumCapacity/2);
        super.setMemoryConsumption( maximumMemory - maximumMemory/2);
    }


}
