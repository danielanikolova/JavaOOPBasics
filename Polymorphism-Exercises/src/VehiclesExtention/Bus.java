package VehiclesExtention;

import java.text.DecimalFormat;

public class Bus extends Vehicle{

    public Bus(double fuel, double litersPerKM, double tankCapacity) {
        super(fuel, litersPerKM, tankCapacity);
    }

    @Override
    public void drive(double km, double peopleConsumption) {
        super.drive(km, peopleConsumption);
    }


    @Override
    public void refuel(double fuel) {
        super.refuel(fuel);
    }
}
