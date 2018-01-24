package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuel;
    private double litersPerKM;

    public Vehicle(double fuel, double litersPerKM) {
        this.fuel = fuel;
        this.litersPerKM = litersPerKM;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getLitersPerKM() {
        return litersPerKM;
    }

    public void setLitersPerKM(double litersPerKM) {
        this.litersPerKM = litersPerKM;
    }

    public void drive(double km){
        double distance = this.getFuel()/(this.getLitersPerKM());
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (distance>=km){
            this.setFuel(this.getFuel()-km*this.getLitersPerKM());
            String traveledDistance = decimalFormat.format(km);
            System.out.printf("%s travelled %s km\n",this.getClass().getSimpleName(), traveledDistance);
        }else {
            System.out.printf("%s needs refueling\n", this.getClass().getSimpleName());
        }
    };
    public void refuel(double fuel){
        this.setFuel(this.getFuel()+ fuel);
    };
}
