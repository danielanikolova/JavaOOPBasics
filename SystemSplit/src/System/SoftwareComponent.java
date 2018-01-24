package System;

public class SoftwareComponent extends Component {

    private long capacityConsumption;
    private long memoryConsumption;

    public SoftwareComponent(String name, long capacityConsumption, long memoryConsumption) {
        super(name);
        this.capacityConsumption = capacityConsumption;
        this.memoryConsumption = memoryConsumption;
    }

    public long getCapacityConsumption() {
        return capacityConsumption;
    }

    public void setCapacityConsumption(long capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    public long getMemoryConsumption() {
        return memoryConsumption;
    }

    public void setMemoryConsumption(long memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }

    @Override
    public String getType() {
        return super.getType();
    }
}
