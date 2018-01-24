package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        while (true){
            if ("Beast!".equalsIgnoreCase(line)){
                break;
            }
            String animal = line;
            String[] animalInfo = br.readLine().split("\\s+");
            if (animalInfo.length<3){
                System.out.println("Invalid input!");
                return;
            }
            String name = animalInfo[0];
            String age = animalInfo[1];
            String gender = animalInfo[2];

            switch (animal.toLowerCase()){
                case "cat":
                    try {
                        Cat cat = new Cat(name, age, gender);
                        System.out.println("Cat");
                        System.out.print(cat.toString());
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "dog":
                    try {
                        Dog dog = new Dog(name, age, gender);
                        System.out.println("Dog");
                        System.out.print(dog.toString());
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "frog":
                    try {
                        Frog frog = new Frog(name, age, gender);
                        System.out.println("Frog");
                        System.out.print(frog.toString());
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "kitten":
                    if (gender.equalsIgnoreCase("male")){
                        System.out.println("Invalid input!");
                        return;
                    }
                    try {
                        Kitten kitten = new Kitten(name, age, gender);
                        System.out.println("Kitten");
                        System.out.print(kitten.toString());
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "tomcat":
                    if (gender.equalsIgnoreCase("female")){
                        System.out.println("Invalid input!");
                        return;
                    }
                    try {
                        Tomcat tomcat = new Tomcat(name, age, gender);
                        System.out.println("Tomcat");
                        System.out.print(tomcat.toString());
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;

            }

            line = br.readLine();
        }

    }
}
