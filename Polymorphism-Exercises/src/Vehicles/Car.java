package Vehicles;


public class Car extends Vehicle{

    public Car(double fuel, double litersPerKM) {
        super(fuel, litersPerKM +0.9);
    }


    @Override
    public void drive(double km) {
        super.drive(km);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel);
    }
}
