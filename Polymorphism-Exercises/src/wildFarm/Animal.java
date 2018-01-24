package wildFarm;

import java.text.DecimalFormat;

public abstract class Animal {

    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten =0;

    protected int getFoodEaten() {
        return foodEaten;
    }

    protected void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public Animal(String animalName, double animalWeight) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
    }

    protected String getAnimalName() {
        return animalName;
    }

    protected String getAnimalType() {
        return animalType;
    }

    protected double getAnimalWeight() {
        return animalWeight;
    }

    public abstract void makeSound();

    public abstract void eat(String foodType, int foodQuantity);



}
