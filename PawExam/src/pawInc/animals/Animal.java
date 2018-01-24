package pawInc.animals;

public abstract class Animal {
    private String name;
    private int age;
    private String cleansingStatus;
    private String adoptionCenter;


    protected Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.cleansingStatus = "UNCLEANSED";

    }
    protected Animal(String name, int age, String adoptionCenter) {
        this(name, age);
        this.adoptionCenter = adoptionCenter;
    }

    public String getCleansingStatus() {
        return cleansingStatus;
    }

    public String getName() {
        return this.name;
    }

    public String getAdoptionCenter() {
        return this.adoptionCenter;
    }

}
