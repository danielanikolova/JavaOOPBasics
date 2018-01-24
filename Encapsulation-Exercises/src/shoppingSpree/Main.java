package shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Person> persons = new LinkedHashMap<>();
        Map<String,Product>products = new LinkedHashMap<>();


        String[] personInfo = br.readLine().split("[=;]");
        String[] productsInfo = br.readLine().split("[=;]");

        for (int i = 0; i < personInfo.length-1; i+=2) {
            String name = personInfo[i];
            double money = Double.parseDouble(personInfo[i+1]);
            try {
                Person person = new Person(name, money);
                persons.put(name,person);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }

        for (int i = 0; i < productsInfo.length-1; i+=2) {
            String name = productsInfo[i];
            double prise = Double.parseDouble(productsInfo[i+1]);
            try {
                Product product = new Product(name, prise);
                products.put(name,product);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }

        String line = br.readLine();
        while (true){
            if ("end".equalsIgnoreCase(line)){
                break;
            }
            String[] tokens = line.split(" ");
            Person person = persons.get(tokens[0]);
            Product product = products.get(tokens[1]);

            person.buyProduct(product);

            line = br.readLine();
        }

        persons.values().forEach(System.out::println);

    }
}
