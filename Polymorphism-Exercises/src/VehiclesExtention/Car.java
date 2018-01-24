package VehiclesExtention;


public class Car extends Vehicle {

    public Car(double fuel, double litersPerKM, double tankCapacity) {
        super(fuel, litersPerKM +0.9, tankCapacity);
    }


    @Override
    public void drive(double km, double peopleConsumption) {
        super.drive(km,peopleConsumption );
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel);
    }
}
