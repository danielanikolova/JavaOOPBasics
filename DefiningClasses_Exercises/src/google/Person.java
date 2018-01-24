package google;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Person {

    private String name;
    private Company company;
    private Car car;
    private Set<Relative>parents = new LinkedHashSet<>();
    private Set<Relative>children = new LinkedHashSet<>();
    private Set<Pokemon>pokemons = new LinkedHashSet<>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Set<Relative> getParents() {
        return parents;
    }

    public void setParents(Set<Relative> parents) {
        this.parents = parents;
    }

    public Set<Relative> getChildren() {
        return children;
    }

    public void setChildren(Set<Relative> children) {
        this.children = children;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getName()+"\r\n");
        sb.append("Company:\r\n");
        if (this.getCompany()!=null){
            sb.append(String.format("%s %s %.2f\r\n",
                    this.getCompany().getName(),
                    this.getCompany().getDepartment(),
                    this.getCompany().getSalary() ));
        }
        sb.append("Car:\r\n");
        if (this.getCar()!=null){
            sb.append(String.format("%s %s\r\n",
                    this.getCar().getModel(), this.getCar().getSpeed()));
        }
        sb.append("Pokemon:\r\n");
        if (this.getPokemons().size()!=0){
            this.getPokemons().forEach(s->
                    sb.append(String.format("%s %s\n", s.getName(), s.getType()))
            );
        }
        sb.append("Parents:\r\n");
        if (this.getParents().size()!=0){
            this.getParents().forEach(p->
                    sb.append(String.format("%s %s\r\n", p.getName(), p.getBirthday()))
            );
        }

        sb.append("Children:\r\n");
        if (this.getChildren().size()!=0){
            this.getChildren().forEach(p->
                    sb.append(String.format("%s %s\n", p.getName(), p.getBirthday()))
            );
        }

        return sb.toString();
    }
}
