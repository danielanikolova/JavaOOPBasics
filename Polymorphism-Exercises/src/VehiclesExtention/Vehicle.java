package VehiclesExtention;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuel;
    private double litersPerKM;
    private double tankCapacity;

    public Vehicle(double fuel, double litersPerKM, double tankCapacity) {
        this.fuel = fuel;
        this.litersPerKM = litersPerKM;
        this.tankCapacity = tankCapacity;
    }

    public double getTankCapacity() {
        return tankCapacity;
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

    public void drive(double km, double peopleConsumption){

        double distance = this.getFuel()/(this.getLitersPerKM()+peopleConsumption);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (distance>=km){
            this.setFuel(this.getFuel()-km*(this.getLitersPerKM()+ peopleConsumption));
            String traveledDistance = decimalFormat.format(km);
            System.out.printf("%s travelled %s km\n",this.getClass().getSimpleName(), traveledDistance);
        }else {
            System.out.printf("%s needs refueling\n", this.getClass().getSimpleName());
        }
    };
    public void refuel(double fuel){
//        if (this.getClass().getSimpleName().equalsIgnoreCase("car")||
//                this.getClass().getSimpleName().equalsIgnoreCase("bus")){
            if(fuel<=0){
                System.out.println("Fuel must be a positive number");
                return;
            }
            if((this.getFuel() + fuel)>this.getTankCapacity()){
                System.out.println("Cannot fit fuel in tank");
                return;
            }else {
                this.setFuel(this.getFuel()+ fuel);
                return;
            }
//        }else {
//            if(fuel<=0){
//                System.out.println("Fuel must be a positive number");
//                return;
//            }
//
//                this.setFuel(this.getFuel()+ fuel);
//        }

    }
}
