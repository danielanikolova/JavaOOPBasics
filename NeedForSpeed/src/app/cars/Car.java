package app.cars;

public abstract class Car {

    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.setBrand(brand);
        this.setModel(model);
        this.setYearOfProduction(yearOfProduction);
        this.setHorsepower(horsepower);
        this.setAcceleration(acceleration);
        this.setSuspension(suspension);
        this.setDurability(durability);
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public String getBrand() {
        return this.brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    private void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return this.suspension;
    }

    public int getDurability() {
        return this.durability;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }

    protected int getYearOfProduction() {
        return this.yearOfProduction;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s %d\n", this.getBrand(), this.getModel(), this.getYearOfProduction()));
        sb.append(String.format("%d HP, 100 m/h in %d s\n", this.getHorsepower(), this.getAcceleration()));
        sb.append(String.format("%d Suspension force, %d Durability\n", this.suspension,
                this.durability));

        return sb.toString();
    }

    public void tuneCar(int index, String addOn){
        this.setHorsepower(this.getHorsepower() + index);
        this.setSuspension(this.getSuspension() + index/2);
    }

    public int calculatePerformance(String raceType) {
        int result;
        switch (raceType){
            case "CasualRace":
                result = this.getHorsepower() / this.getAcceleration() + (this.getSuspension() + this.getDurability());
                break;
            case "DragRace":
                result = this.getHorsepower()/ this.getAcceleration();
                break;
            case "DriftRace":
                result = this.getSuspension() + this.getDurability();
                break;
                default: result = 0;

        }
         return result;
    }


}
