package speedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double costForKm;
    private double travelledDistance;

    public Car(String model, double fuelAmount, double costForKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.costForKm = costForKm;
        this.travelledDistance = 0.0;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setTravelledDistance(double travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getTravelledDistance() {
        return travelledDistance;
    }


    public void executeDrive(double amountKM){

        double neededFuel = amountKM*this.costForKm;
        if (this.fuelAmount< neededFuel){
            System.out.println("Insufficient fuel for the drive");
        }else {
            this.setTravelledDistance(this.getTravelledDistance()+amountKM);
            this.setFuelAmount(this.getFuelAmount()-neededFuel);
        }
    }


    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.getTravelledDistance());
    }
}
