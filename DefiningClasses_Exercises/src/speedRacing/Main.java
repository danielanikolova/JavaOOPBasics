package speedRacing;

import org.omg.PortableInterceptor.ServerRequestInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String line= null;
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            line = br.readLine();
          String[] tokens = line.split("\\s+");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double costForKm = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, costForKm);
            cars.put(model,car);


        }

        line = br.readLine();

        while (!"End".equalsIgnoreCase(line)){

            String[] tokens = line.split("\\s+");

            String carModel = tokens[1];
            double amountKm = Double.parseDouble(tokens[2]);

            if (cars.containsKey(carModel)){
                cars.get(carModel).executeDrive(amountKm);
            }

            line=br.readLine();
        }

       // cars.values().forEach(System.out::println);

        cars.entrySet().stream().forEach(a->
                System.out.println(a.getValue().toString())
        );
    }
}
