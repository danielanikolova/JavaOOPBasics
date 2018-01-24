package app;

import app.cars.Car;
import app.factories.CarFactory;
import app.factories.RaceFactory;
import app.races.Race;

import java.util.HashMap;
import java.util.Map;

public class CarManager {

    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;


    public CarManager() {
        this.cars  = new HashMap<>();
        this.races  = new HashMap<>();
        this.garage  = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability){

       Car car = CarFactory.createCar(type, brand, model,  yearOfProduction,  horsepower,  acceleration,  suspension,  durability);

        if (!this.cars.containsKey(id)){
            this.cars.put(id, car);
        }

    }

    public 	String check(int id){
        if (this.cars.containsKey(id)){
            return this.cars.get(id).toString();
        }else {
            return null;
        }

    }
    public void open(int id, String type, int length, String route, int prizePool){
           Race race = RaceFactory.openRace(type, length, route, prizePool);
           if (!this.races.containsKey(id)){
               this.races.put(id, race);
           }
    }

    public void participate(int carId, int raceId){
        if (this.cars.containsKey(carId)&& this.races.containsKey(raceId)){
            Car car = this.cars.get(carId);
            if (!this.garage.getParkedCars().contains(car)&&
                    !this.races.get(raceId).getStatus().equalsIgnoreCase("CLOSED")){
                this.races.get(raceId).addCar(car);
            }
        }

    }

    public String start(int id){
        String result =null;
        if (this.races.containsKey(id)&&this.races.get(id).getStatus().equalsIgnoreCase("OPEN")){
            Race race = races.get(id);

            if (race.getParticipants().size()>0){
               result =  race.startRace(race.getClass().getSimpleName());
            }else {
                result = "Cannot start the race with zero participants.\n";
            }
        }
        return result;
    }

    public void park(int id){
        Car car;
        if (this.cars.containsKey(id)){
            car = this.cars.get(id);
            long countOfRaces = this.races.values().stream().filter(r -> r.getParticipants().contains(car)).count();
            if (countOfRaces == 0) {
                this.garage.park(car);
            }
        }

    }

    public void unpark(int id){
        if (this.cars.containsKey(id)&&this.garage.getParkedCars().contains(this.cars.get(id))){
            Car car = cars.get(id);
            this.garage.unParkCar(car);
        }
    }

    public void tune(int tuneIndex, String addOn){
        if (this.garage.getParkedCars().size() != 0) {
            this.garage.tune(tuneIndex, addOn);
        }
    }
}
