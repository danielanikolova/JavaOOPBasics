package wildFarm;


public class Tiger extends Mammal{
    public Tiger(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(String foodType, int foodQuantity) {
        this.makeSound();
        if (foodType.equalsIgnoreCase("vegetable")){
            System.out.printf("Tigers are not eating that type of food!\n");
        }else {
            super.setFoodEaten(super.getFoodEaten()+foodQuantity);
        }
    }

}
