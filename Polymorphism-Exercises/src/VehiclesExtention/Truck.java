package VehiclesExtention;

public class Truck extends Vehicle {

    public Truck(double fuel, double litersPerKM, double tankCapacity) {
        super(fuel, litersPerKM+1.6, tankCapacity);
    }


    @Override
    public void drive(double km, double peopleConsumption) {
        super.drive(km, peopleConsumption);
    }



    @Override
    public void refuel(double fuel) {
        super.refuel(fuel*0.95);
    }
}
