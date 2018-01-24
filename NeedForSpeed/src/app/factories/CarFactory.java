package app.factories;

import app.cars.Car;
import app.cars.PerformanceCar;
import app.cars.ShowCar;

public final class CarFactory {

    public static Car createCar(String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car car;

        switch (type){
            case "Performance":
                car = new PerformanceCar(brand,model,yearOfProduction,horsepower, acceleration, suspension, durability);
                break;
            case "Show":
                car = new ShowCar(brand,model,yearOfProduction,horsepower, acceleration, suspension, durability);
                break;
                default: car = null;
        }

        return car;
    }

}
