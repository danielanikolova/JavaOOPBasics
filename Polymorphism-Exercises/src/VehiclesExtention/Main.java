package VehiclesExtention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = br.readLine().split("\\s+");
        String[]trackInfo = br.readLine().split("\\s+");
        String[]busInfo = br.readLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carInfo[1]),
                                Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        Vehicle truck = new Truck(Double.parseDouble(trackInfo[1]),
                                    Double.parseDouble(trackInfo[2]), Double.parseDouble(trackInfo[3]));
        Vehicle bus = new Bus(Double.parseDouble(busInfo[1]),
                Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));

        int n = Integer.parseInt(br.readLine());
        String [] commands = new String[3];

        for (int i = 0; i < n; i++) {
            commands = br.readLine().split("\\s+");

            switch (commands[1].toLowerCase()){
                case "truck":
                    if (commands[0].equalsIgnoreCase("drive")){
                        truck.drive(Double.parseDouble(commands[2]), 0.0);
                    }else if (commands[0].equalsIgnoreCase("refuel")){
                        truck.refuel(Double.parseDouble(commands[2]));
                    }
                    break;
                case "car":
                    if (commands[0].equalsIgnoreCase("drive")){
                        car.drive(Double.parseDouble(commands[2]), 0.0);
                    }else if (commands[0].equalsIgnoreCase("refuel")){
                        car.refuel(Double.parseDouble(commands[2]));
                    }
                    break;
                case "bus":
                    if (commands[0].equalsIgnoreCase("drive")){
                        bus.drive(Double.parseDouble(commands[2]), 1.4);
                    }else if (commands[0].equalsIgnoreCase("refuel")){
                        car.refuel(Double.parseDouble(commands[2]));
                    }else if (commands[0].equalsIgnoreCase("DriveEmpty")){
                        bus.drive(Double.parseDouble(commands[2]), 0.0);
                    }
                    break;

            }
        }

        System.out.printf("Car: %.2f\n", car.getFuel());
        System.out.printf("Truck: %.2f\n", truck.getFuel());
        System.out.printf("Bus: %.2f\n", bus.getFuel());
    }
}
