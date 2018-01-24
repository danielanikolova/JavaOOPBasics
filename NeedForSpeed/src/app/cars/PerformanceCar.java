package app.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car{

    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.setHorsepower(horsepower + ((horsepower*50)/100));
        this.setSuspension(suspension - ((suspension*25)/100));
        this.addOns = new ArrayList<>();
    }

    @Override
    protected void setHorsepower(int horsepower) {
        super.setHorsepower(horsepower);
    }

    @Override
    protected void setSuspension(int suspension) {
        super.setSuspension(suspension);
    }

    private List<String> getAddOns() {
        return this.addOns;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        if (this.getAddOns().size() == 0){
            sb.append("Add-ons: None\n");
        }else {
            String addOnes = String.join(", ",this.getAddOns());
            sb.append("Add-ons: ");
            sb.append(addOnes).append("\n");
        }

        return sb.toString();
    }

    @Override
    public void tuneCar(int index, String addOn) {
        super.tuneCar(index, addOn);
        this.addOns.add(addOn);
    }


}
