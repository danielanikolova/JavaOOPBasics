package carSalesman;

public class Car {

    private String model;
    private Engine engine;
    private  String weight = "n/a";
    private String color = "n/a";

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("%s:\n" +
                "%s:\n" +
                "Power: %s\n" +
                "Displacement: %s\n" +
                "Efficiency: %s\n" +
                "Weight: %s\n" +
                "Color: %s",
                this.model,
                this.engine.getModel(),
                this.engine.getPower(),
                this.engine.getDisplacement(),
                this.engine.getEfficiency(),
                this.getWeight(), this.getColor());
    }
}
