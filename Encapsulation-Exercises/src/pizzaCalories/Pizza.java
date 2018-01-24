package pizzaCalories;

import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;


    public Pizza(String name, Dough dough, List<Topping>toppings) {
        this.setName(name);
        this.setDough(dough);
        this.setToppings(toppings);

    }


    public void setName(String name) {
        if (name.trim().length()<1||name.length()>15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setToppings(List<Topping> toppings) {
        if (toppings.size()<0|| toppings.size()>10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = toppings;
    }

    public double getCalories(){
        double calories = 0.0;

        Dough dough = this.dough;
        calories+= dough.getCalories();

        for (Topping toppimg:this.getToppings()) {
            calories+= toppimg.getCalories();
        }

        return calories;
    }

    public String getName() {
        return name;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.getCalories() ;
    }
}
