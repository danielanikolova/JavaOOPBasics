package carSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Engine> engines = new HashMap<>();
        List<Car>cars = new LinkedList<>();

        String line = null;

        for (int i = 0; i < n; i++) {
            line = br.readLine();

            String[] tokens = line.split("\\s+");

            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine = new Engine(model, power);

            if (tokens.length==3){
                String displacement = tokens[2];
                if (Character.isDigit(displacement.charAt(0))){
                    engine.setDisplacement(displacement);
                }else {
                    engine.setEfficiency(displacement);
                }

            }
            if (tokens.length==4){
                String displacement = tokens[2];
                String efficiency = tokens[3];

                if (Character.isDigit(displacement.charAt(0))){
                    engine.setDisplacement(displacement);
                    engine.setEfficiency(efficiency);
                }else {
                    engine.setDisplacement(efficiency);
                    engine.setEfficiency(displacement);
                }

            }

            engines.put(model,engine);
        }
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {

            String[] carInfo = br.readLine().split("\\s+");
            String model = carInfo[0];
            String engineModel = carInfo[1];

            Engine engine = engines.get(engineModel);


            Car car = new Car(model,engine);
            if (carInfo.length==3){
                String weight = carInfo[2];
                if (Character.isDigit(weight.charAt(0))){
                    car.setWeight(weight);
                }else car.setColor(weight);

            }
            if (carInfo.length==4){

                String weight = carInfo[2];
                String color = carInfo[3];
                if (Character.isDigit(weight.charAt(0))){
                    car.setWeight(weight);
                    car.setColor(color);
                }else {
                    car.setWeight(color);
                    car.setColor(weight);
                }

            }

            cars.add(car);

        }

        cars.stream().forEach(System.out::println);

    }
}
