package app.cars;

public class ShowCar extends Car{

    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    @Override
    public String toString() {

        return super.toString() +
                String.format("%d *\n", this.stars);
    }
    @Override
    public void tuneCar(int index, String addOn) {
        super.tuneCar(index, addOn);
        this.stars += index;
    }
}
