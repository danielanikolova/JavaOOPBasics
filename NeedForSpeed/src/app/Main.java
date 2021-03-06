package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CarManager carManager = new CarManager();

        String token = br.readLine();


        while (true){

            if ("Cops Are Here".equalsIgnoreCase(token)){
                return;
            }

            String[] line = token.split("\\s+");
            String command = line[0];
            switch (command){
                case "register":

                    carManager.register(Integer.parseInt(line[1]), line[2],line[3],line[4],
                            Integer.parseInt(line[5]),Integer.parseInt(line[6]),
                            Integer.parseInt(line[7]),Integer.parseInt(line[8]),Integer.parseInt(line[9]));
                    break;
                case "check":
                    System.out.print(carManager.check(Integer.parseInt(line[1])));
                    break;
                case "open":
                    carManager.open(Integer.parseInt(line[1]), line[2],Integer.parseInt(line[3]),line[4],
                            Integer.parseInt(line[5]));
                    break;
                case "participate":
                    carManager.participate(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
                    break;
                case "start":
                    System.out.print(carManager.start(Integer.parseInt(line[1])));
                    break;
                case "park":
                    carManager.park(Integer.parseInt(line[1]));
                    break;
                case "unpark":
                    carManager.unpark(Integer.parseInt(line[1]));
                    break;
                case "tune":
                    carManager.tune(Integer.parseInt(line[1]), line[2]);
                    break;

            }


            token = br.readLine();
        }

    }
}
