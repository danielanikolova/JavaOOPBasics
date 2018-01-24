package pokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer>trainers = new LinkedHashMap<>();
        String line = br.readLine();

        while (!"Tournament".equals(line)){

            String [] tokens= line.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Trainer trainer = new Trainer(trainerName);
            Pokemon pokemon = new Pokemon(pokemonName, element, health);

            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).getPokemons().add(pokemon);


            line = br.readLine();
        }

        line = br.readLine();

        while (!"End".equalsIgnoreCase(line)){

            switch (line){
                case "Fire":
                    manipulatePokemons("Fire", trainers);
                    break;
                case "Water":
                    manipulatePokemons("Water", trainers);
                    break;
                case "Electricity":
                    manipulatePokemons("Electricity", trainers);
                    break;
            }

            line = br.readLine();
        }

        trainers.values().stream().sorted((a,b)-> {
            int first = a.getBadge();
            int second = b.getBadge();
            if (first>second){
                return -1;
            }else return 1;
        } ).forEach(System.out::println);

    }

    private static void manipulatePokemons(String element, Map<String, Trainer> trainers) {

        trainers.values().stream().filter(t->
                t.getPokemons().stream()
                        .filter(p->p.getElement().equalsIgnoreCase(element))
                        .collect(Collectors.toList()).size()>0
        ).forEach(p->p.setBadge(1));

        trainers.values().stream().filter(t->t.getPokemons().stream()
                        .filter(p->p.getElement().equalsIgnoreCase(element))
                        .collect(Collectors.toList()).size()==0
        ).forEach(trainer -> trainer.getPokemons().forEach(pokemon -> {
            pokemon.setHealth(pokemon.getHealth()-10);

        }));

        for (Trainer trainer:trainers.values()) {
            List<Pokemon>current = trainer.getPokemons();

            current = current.stream().filter(p->p.getHealth()>0).collect(Collectors.toList());
            trainer.setPokemons(current);
        }


    }
}
