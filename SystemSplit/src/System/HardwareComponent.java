package System;

import java.util.LinkedHashMap;
import java.util.Map;

public class HardwareComponent extends Component {

    private long maximumCapacity;
    private long getMaximumMemory;

    private Map<String, SoftwareComponent> softwares = new LinkedHashMap<>();

    HardwareComponent(String name, int maximumCapacity, int getMaximumMemory) {
        super(name);
        this.maximumCapacity = maximumCapacity;
        this.getMaximumMemory = getMaximumMemory;
        this.softwares = new LinkedHashMap<String, SoftwareComponent>();

    }

    public Map<String,SoftwareComponent> getSoftwares() {
        return softwares;
    }

    public long getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(long maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public long getGetMaximumMemory() {
        return getMaximumMemory;
    }

    public void setGetMaximumMemory(long getMaximumMemory) {
        this.getMaximumMemory = getMaximumMemory;
    }

    public void addSoftware(SoftwareComponent software){
        if (this.maximumCapacity-software.getCapacityConsumption()>0&&
                this.getMaximumMemory-software.getMemoryConsumption()>0){
            softwares.put(software.getName(), software);
            this.setGetMaximumMemory(this.getGetMaximumMemory()-software.getMemoryConsumption());
            this.setMaximumCapacity(this.getMaximumCapacity()-software.getCapacityConsumption());
        }
    }

    public void releaseSoftware(String softwareComponentName) {
    }
}
