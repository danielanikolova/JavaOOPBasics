package System;

public class ExpressSoftwareComponent extends SoftwareComponent{

    public ExpressSoftwareComponent(String name, long capacityConsumption, long memoryConsumption) {
        super(name, capacityConsumption, memoryConsumption);
        super.setMemoryConsumption(memoryConsumption*2);
    }
}
