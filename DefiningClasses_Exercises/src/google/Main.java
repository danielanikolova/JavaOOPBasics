package google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        Map<String, Person> resultList = new HashMap<>();

        List<String> commands = new LinkedList<>();

        while (!"End".equalsIgnoreCase(line)){
            commands.add(line);

            line = br.readLine();
        }

        for (int i = 0; i < commands.size(); i++) {
            String[] info = commands.get(i).split("\\s+");

            String name = info[0];
            Person person;
            if (!resultList.containsKey(name)){
                person = new Person(name);
            }else {
                person = resultList.get(name);
            }


            switch (info[1].toLowerCase()){
                case "company":
                    String companyName= info[2];
                    String department = info[3];
                    Double salary = Double.parseDouble(info[4]);
                    Company company = new Company(companyName, department,salary);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = info[2];
                    String type = info[3];
                    Pokemon pokemon = new Pokemon(pokemonName, type);

                    person.getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = info[2];
                    String parentBirthday = info[3];
                    Relative parent = new Relative(parentName, parentBirthday);

                    person.getParents().add(parent);
                    break;
                case "children":
                    String childName = info[2];
                    String childBirthday = info[3];
                    Relative child = new Relative(childName, childBirthday);

                    person.getChildren().add(child);
                    break;
                case "car":
                    String model = info[2];
                    String carSpeed = info[3];
                    Car car = new Car(model, carSpeed);
                    person.setCar(car);
                    break;
            }

            resultList.put(name,person);

        }
        line = br.readLine();

        System.out.print(resultList.get(line));
    }
}
