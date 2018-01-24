package wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{

    private String livingRegion;

    public Mammal(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    protected String getLivingRegion() {
        return livingRegion;
    }

    protected void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public abstract void makeSound() ;

    @Override
    public abstract void eat(String foodType, int foodQuantity);

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                this.getClass().getSimpleName(),
                super.getAnimalName(),
                new DecimalFormat("0.##").format(super.getAnimalWeight()) ,
                this.getLivingRegion(),
                super.getFoodEaten()
        );
    }

}
