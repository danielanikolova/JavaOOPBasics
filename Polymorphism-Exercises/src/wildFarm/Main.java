package wildFarm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static Food food;
    private static Animal animal;
    private static List<Animal>animals = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        while (true){
            if ("End".equalsIgnoreCase(line)){
                break;
            }

            String [] animalInfo = line.split("\\s+");
            String [] foodInfo = br.readLine().split("\\s+");

            createFood(foodInfo);
            createAnimal(animalInfo);

            line = br.readLine();
        }

        for (Animal animal:animals) {
            System.out.println(animal.toString());
        }
    }

    private static void createAnimal(String[] animalInfo) {

        String name = animalInfo[1];
        Double weight = Double.parseDouble(animalInfo[2]);
        String livingRegion = animalInfo[3];

        switch (animalInfo[0].toLowerCase()){
            case "cat":
                animal = new Cat(name, weight, livingRegion, animalInfo[4]);
                animal.eat(food.getClass().getSimpleName().toLowerCase(), food.getQuantity());
                animals.add(animal);
                break;
            case "tiger":
                animal = new Tiger(name, weight, livingRegion);
                animal.eat(food.getClass().getSimpleName().toLowerCase(), food.getQuantity());
                animals.add(animal);
                break;
            case "zebra":
                animal = new Zebra(name, weight, livingRegion);
                animal.eat(food.getClass().getSimpleName().toLowerCase(), food.getQuantity());
                animals.add(animal);
                break;
            case "mouse":
                animal = new Mouse(name, weight, livingRegion);
                animal.eat(food.getClass().getSimpleName().toLowerCase(), food.getQuantity());
                animals.add(animal);
                break;

        }
    }

    private static void createFood(String[] foodInfo) {

        String foodType = foodInfo[0];
        int foodQuantity = Integer.parseInt(foodInfo[1]);

        switch (foodType.toLowerCase()) {
            case "vegetable":
                food = new Vegetable(foodQuantity);
                break;
            case "meat":
                food = new Meat(foodQuantity);
                break;

        }

    }
}
