package pizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaInfo = br.readLine().split("\\s+");
        int toppingsCount = Integer.parseInt(pizzaInfo[2]);
        if (toppingsCount>10){
            System.out.println("Number of toppings should be in range [0..10].");
            return;
        }

        String [] doughInfo = br.readLine().split("\\s+");
        Dough dough;

        try {
            dough = new Dough(doughInfo[1], doughInfo[2], Double.parseDouble(doughInfo[3]));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        List<Topping>toppings = new ArrayList<>();
        String line = br.readLine();
        while (true){

            if ("End".equalsIgnoreCase(line)){
                break;
            }
            String [] toppingInfo = line.split("\\s+");

            try {
                Topping topping =new Topping(toppingInfo[1], Double.parseDouble(toppingInfo[2]));
                toppings.add(topping);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                return;
            }


            line = br.readLine();
        }

        try {
            Pizza pizza = new Pizza(pizzaInfo[1],dough, toppings);
            System.out.println(pizza.toString());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}
