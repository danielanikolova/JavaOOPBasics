package Vehicles;

public class Truck extends Vehicle{

    public Truck(double fuel, double litersPerKM) {
        super(fuel, litersPerKM+1.6);
    }


    @Override
    public void drive(double km) {
        super.drive(km);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel*0.95);
    }
}
