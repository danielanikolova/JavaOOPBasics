package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Topping {

    private static final Double DEFAULT_TOPPING_MODIFIER =2.0;

    private String type;
    private double weight;

    public Topping(String type, double weight) {
        this.setType(type);
        this.setWeight(weight);
    }

    public void setType(String type) {
        List<String> types = new ArrayList<>();
        types.add("meat");
        types.add("veggies");
        types.add("cheese");
        types.add("sauce");

        if (!types.contains(type.toLowerCase())){
            throw new IllegalArgumentException("Cannot place "+ type +" on top of your pizza.");
        }
        this.type = type;
    }

    public void setWeight(double weight) {
        if (weight>=1 && weight<=50){
            this.weight = weight;
        }else {
            throw new IllegalArgumentException(this.type
                    +" weight should be in the range [1..50].");
        }

    }

    public Double getCalories(){
        double calories =
                DEFAULT_TOPPING_MODIFIER*this.weight*this.getTypeModifier();
        return calories;
    }
    private Double getTypeModifier(){
        String type = this.type.toLowerCase();
        switch (type){
            case "meat":
                return 1.2;
            case "veggies":
                return 0.8;
            case "cheese":
                return 1.1;
            case "sauce":
                return 0.9;
            default:
                return null;

        }
    }

}
