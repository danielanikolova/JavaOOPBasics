package wildFarm;


import java.text.DecimalFormat;

public class Cat extends Felime{

    private String breed;

    public Cat(String animalName,  double animalWeight, String livingRegion, String breed) {
        super(animalName,  animalWeight, livingRegion);
        this.breed = breed;
    }


    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(String foodType, int foodQuantity) {
        this.makeSound();
        super.setFoodEaten(super.getFoodEaten()+foodQuantity);
    }

    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getClass().getSimpleName(),
                super.getAnimalName(),
                this.breed,
                new DecimalFormat("0.##").format(super.getAnimalWeight()),
                super.getLivingRegion(),
                super.getFoodEaten()
                );
    }

}








