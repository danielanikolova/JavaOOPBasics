package pawInc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            AnimalCenterManager animalCenterManager = new AnimalCenterManager();

            String[] line = br.readLine().split(" \\| ");

            while (true) {
                if ("Paw Paw Pawah".equalsIgnoreCase(line[0])) {
                    animalCenterManager.printStatistics();
                    break;
                }

                String command = line[0];
                switch (command.trim()) {
                    case "RegisterCleansingCenter":
                        animalCenterManager.registerCleansingCenter(line[1]);
                        break;
                    case "RegisterAdoptionCenter":
                        animalCenterManager.registerAdoptionCenter(line[1]);
                        break;
                    case "RegisterCastrationCenter":
                        animalCenterManager.registerCastrationCenter(line[1]);
                        break;
                    case "RegisterDog":
                        animalCenterManager
                                .registerDog(line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), line[4]);
                        break;
                    case "RegisterCat":
                        animalCenterManager
                                .registerCat(line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), line[4]);
                        break;
                    case "SendForCleansing":
                        animalCenterManager.sendForCleansing(line[1], line[2]);
                        break;
                    case "SendForCastration":
                        animalCenterManager.sendForCastration(line[1], line[2]);
                        break;
                    case "Cleanse":
                        animalCenterManager.cleanse(line[1]);
                        break;
                    case "Castrate":
                        animalCenterManager.castrate(line[1]);
                        break;
                    case "Adopt":
                        animalCenterManager.adopt(line[1]);
                        break;

                    case "CastrationStatistics":
                        animalCenterManager.castrationStatistics();
                        break;
                }

                line = br.readLine().split(" \\| ");
            }
    }
}
