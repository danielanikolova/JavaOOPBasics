package pokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String name;
    private int badge =0;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBadge() {
        return badge;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setBadge(int badge) {
        this.badge += badge;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.getName(), this.getBadge(), this.getPokemons().size());
    }
}
