package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Dough {
    private static final Double DEFAULT_DOUGH_MODIFIER = 2.0;

    private String type;
    private String bakingTechnique;
    private double weight;

    public Dough(String type, String bakingTechnique, double weight) {
        this.setType(type);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public void setType(String type) {
        List<String> types = new ArrayList<>();
        types.add("white");
        types.add("wholegrain");
        if (!types.contains(type.toLowerCase())){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.type = type;
    }

    public void setBakingTechnique(String bakingTechnique) {
        List<String> techniques = new ArrayList<>();
        techniques.add("crispy");
        techniques.add("chewy");
        techniques.add("homemade");
        if (!techniques.contains(bakingTechnique.toLowerCase())){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public void setWeight(double weight) {
        if (weight>=1&&weight<=200){
            this.weight = weight;
        }else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

    }

    public String getType() {
        return type;
    }

    public String getBakingTechnique() {
        return bakingTechnique;
    }

    public Double getCalories(){
        double calories =
                DEFAULT_DOUGH_MODIFIER*this.weight*this.getTypeModifier()*this.getTechniqueModifier();

        return calories;

    }
    private Double getTypeModifier(){

        switch (this.getType().toLowerCase()){
            case "white":
                return 1.5;
            case"wholegrain":
                return 1.0;
                default:
                    return null;
        }
    }
    private Double getTechniqueModifier(){

        switch (this.getBakingTechnique().toLowerCase()){
            case "crispy":
                return 0.9;
            case"chewy":
                return 1.1;
            case"homemade":
                return 1.0;
            default:
                return null;
        }
    }

}
