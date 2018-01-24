package rawData;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<Car> cars = new LinkedHashSet<>();

        String line = null;

        for (int i = 0; i < n; i++) {
            line = br.readLine();

            String [] tokens = line.split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Set<Tire>tires = new HashSet<>();
            int index = 5;
            int index2=6;

            for (int j = 0; j < 4; j++) {
                double tirePressure = Double.parseDouble(tokens[index]);
                int tireAge = Integer.parseInt(tokens[index2]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
                index+=2;
                index2+=2;
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);

        }

        String command = br.readLine();

        if ("fragile".equalsIgnoreCase(command)){
           cars.stream().filter(car ->
                   car.getCargo().getType().equalsIgnoreCase("fragile"))
                   .filter(car -> car.getTires().stream()
                           .filter(tire -> {
                              return tire.getPressure()<1;
                           }).collect(Collectors.toList()).size()>0)
                   .forEach(System.out::println);

        }else if ("flamable".equalsIgnoreCase(command)){

            cars.stream().filter(car ->
                    car.getCargo().getType().equalsIgnoreCase("flamable"))
                    .filter(car -> car.getEngine().getPower()>250)
                    .forEach(System.out::println);


        }

    }
}
