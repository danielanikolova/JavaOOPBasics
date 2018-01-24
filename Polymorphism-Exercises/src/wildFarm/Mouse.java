package wildFarm;

public class Mouse extends Mammal{


    public Mouse(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(String foodType, int foodQuantity) {
        this.makeSound();
        if (foodType.equalsIgnoreCase("meat")){
            System.out.print("Mice are not eating that type of food!\n");
        }else {
           super.setFoodEaten(super.getFoodEaten()+foodQuantity);
        }
    }


}
