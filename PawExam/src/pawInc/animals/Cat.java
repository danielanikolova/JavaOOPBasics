package pawInc.animals;

public class Cat extends Animal{

    private int intelligence;

    public Cat(String name, int age) {
        super(name, age);
    }

    public Cat(String name, int age, String adoptionCenter, int intelligence) {
        super(name, age, adoptionCenter);
        this.intelligence = intelligence;
    }
}
