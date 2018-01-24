package fragileBaseClass;

import java.util.Collections;

public class Predator extends Animal{

    private int health;

    public Predator(int health) {
        this.health = health;
    }
    public void feed(Food food){
        super.eat(food);
        this.health++;
    }

   public void feedAll(Food[] foods){
       Collections.addAll(super.foodEaten, foods);
   }
}
