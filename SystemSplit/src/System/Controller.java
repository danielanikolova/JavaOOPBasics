package System;

import hardware.Hardware;
import hardware.HeavyHardware;
import hardware.PowerHardware;
import software.ExpressSoftware;
import software.LightSoftware;
import software.Software;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Controller {

    private Map<String, PowerHardwareComponent> powerHardwares = new LinkedHashMap<>();
    private Map<String, HeavyHardwareComponent>heavyHardwares = new LinkedHashMap<>();

    public Controller() {
        this.powerHardwares = new LinkedHashMap<>();
        this.heavyHardwares = new LinkedHashMap<>();
    }

    public void registerPowerHardware(String name, int capacity, int memory){
        PowerHardwareComponent powerHardware = new PowerHardwareComponent(name, capacity, memory);
        powerHardwares.put(name, powerHardware);
    }
    public void registerHeavyHardware(String name, int capacity, int memory){
        PowerHardwareComponent heavyHardware = new PowerHardwareComponent(name, capacity, memory);
        heavyHardwares.put(name,heavyHardware);
    }

    public void registerLightSoftware(String hardwareComponentName,String name, int capacity, int memory){

        LightSoftwareComponent lightSoftware = new LightSoftwareComponent(name, capacity, memory);
        if (powerHardwares.containsKey(hardwareComponentName)){
            powerHardwares.get(hardwareComponentName).addSoftware(lightSoftware);
        }
        if (heavyHardwares.containsKey(hardwareComponentName)){
            heavyHardwares.get(hardwareComponentName).addSoftware(lightSoftware);
        }
    }
    public void registerExpressSoftware(String hardwareComponentName,String name, int capacity, int memory){

        ExpressSoftwareComponent expressSoftware = new ExpressSoftwareComponent(name, capacity, memory);
        if (powerHardwares.containsKey(hardwareComponentName)){
            powerHardwares.get(hardwareComponentName).addSoftware(expressSoftware);
        }
        if (heavyHardwares.containsKey(hardwareComponentName)){
            heavyHardwares.get(hardwareComponentName).addSoftware(expressSoftware);
        }
    }


    public void releaseSoftwareComponent(String hardwareComponentName,String softwareComponentName){
        if (powerHardwares.containsKey(hardwareComponentName)){
            if(powerHardwares.get(hardwareComponentName).getSoftwares().containsKey(softwareComponentName)){
                powerHardwares.get(hardwareComponentName).releaseSoftware(softwareComponentName);
            }

        }if (heavyHardwares.containsKey(hardwareComponentName)){
            if (heavyHardwares.get(hardwareComponentName).getSoftwares().containsKey(softwareComponentName)){
                heavyHardwares.get(hardwareComponentName).releaseSoftware(softwareComponentName);
            }
        }
    }

    public String analyze(){

        int countOfHardwareComponents=powerHardwares.size()+heavyHardwares.size();
        final int[] countOfSoftwareComponents = {0};

        final int[] totalOperationalMemoryInUse = {0};
        final int[] totalCapacityTaken = {0};

        final int[] freeMemory = {0};
        final int[] freeCapacity = {0};

        powerHardwares.values()
                .forEach(h-> totalOperationalMemoryInUse[0] += h.getTotalOperationalMemoryInUse());
        powerHardwares.values()
                .forEach(h-> totalCapacityTaken[0] += h.getTotalCapacityTaken());

        heavyHardwares.values()
                .forEach(h-> totalOperationalMemoryInUse[0] += h.getTotalOperationalMemoryInUse());
        heavyHardwares.values()
                .forEach(h-> totalCapacityTaken[0] += h.getTotalCapacityTaken());

        powerHardwares.values().forEach(h-> freeMemory[0] +=h.getMaximumMemory());
        powerHardwares.values().forEach(h-> freeCapacity[0] +=h.getMaximumCapacity());

        heavyHardwares.values().forEach(h-> freeMemory[0] +=h.getMaximumMemory());
        heavyHardwares.values().forEach(h-> freeCapacity[0] +=h.getMaximumCapacity());

        powerHardwares.values().forEach(h-> countOfSoftwareComponents[0] +=h.getSoftwares().size());
        heavyHardwares.values().forEach(h-> countOfSoftwareComponents[0] +=h.getSoftwares().size());

        int maximumCapacity = totalCapacityTaken[0] + freeCapacity[0];
        int maximumMemory = totalOperationalMemoryInUse[0] + freeMemory[0];

        StringBuilder sb = new StringBuilder();
        sb.append("System Analysis\n");
        sb.append(String.format("Hardware Components: %d\n", countOfHardwareComponents));
        sb.append(String.format("Software Components: %d\n", countOfSoftwareComponents[0]));
        sb.append(String.format("Total Operational Memory: %d / %d\n",
                totalOperationalMemoryInUse[0], maximumMemory));
        sb.append(String.format("Total Capacity Taken: %d / %d",
                totalCapacityTaken[0], maximumCapacity));

        return sb.toString();
    }

    public String systemSplit(){
        StringBuilder sb = new StringBuilder();

        for (Hardware hardware:powerHardwares.values()) {
            sb.append( getStringInfo(hardware, "Power"));
        }
        for (Hardware hardware:heavyHardwares.values()) {
            sb.append( getStringInfo(hardware, "Heavy"));
        }
        return sb.toString();
    }

    private String getStringInfo(Hardware hardware, String type) {

            StringBuilder sb = new StringBuilder();

        sb.append(String.format("Hardware Component - %s\n", hardware.getName()));
        sb.append(String.format("Express Software Components - %d\n",
                hardware.getSoftwares().values()
                        .stream().filter(s->s.getType().equalsIgnoreCase("Express"))
                        .collect(Collectors.toList()).size()));
        sb.append(String.format("Light Software Components - %d\n",
                hardware.getSoftwares().values()
                        .stream().filter(s->s.getType().equalsIgnoreCase("Light"))
                        .collect(Collectors.toList()).size()));
        sb.append(String.format("Memory Usage: %d / %d\n",
                hardware.getTotalOperationalMemoryInUse(), (hardware.getMaximumMemory()+hardware.getTotalOperationalMemoryInUse())));
        sb.append(String.format("Capacity Usage: %d / %d\n",
                hardware.getTotalCapacityTaken(), (hardware.getMaximumCapacity()+hardware.getTotalCapacityTaken())));
        sb.append(String.format("Type: %s\n", type));
        sb.append("Software Components: ");

        if (hardware.getSoftwares().values().size()==0){
            sb.append("None");
        }else {
            sb.append(hardware.getSoftwares().values().stream()
                    .map(Software::getName).collect(Collectors.joining(", ")));
        }

        return sb.toString();
    }



}
