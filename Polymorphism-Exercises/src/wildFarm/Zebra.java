package wildFarm;

public class Zebra extends Mammal{


    public Zebra(String animalName,  double animalWeight, String livingRegion) {
        super(animalName,  animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(String foodType, int foodQuantity) {
        this.makeSound();
        if (foodType.equalsIgnoreCase("meat")){
            System.out.printf("Zebras are not eating that type of food!\n");
        }else {
            super.setFoodEaten(super.getFoodEaten()+foodQuantity);

        }
    }


}
