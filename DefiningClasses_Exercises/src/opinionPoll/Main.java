package opinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(br.readLine());
        TreeSet<Person> persons = new TreeSet<>();

        for (int i = 0; i < lines; i++) {

            String[] tokens = br.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            persons.add(person);
        }

        persons.stream().filter(x->x.getAge()>30)
                .forEach(p-> System.out.printf("%s - %d%n", p.getName(), p.getAge()));
    }
}
