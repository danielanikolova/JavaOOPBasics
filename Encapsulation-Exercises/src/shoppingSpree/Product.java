package shoppingSpree;

public class Product {
    private String name;
    private double prise;

    public Product(String name, double prise) {
        this.setName(name);
        this.setPrise(prise);
    }

    public void setName(String name) {
        if (name.trim().length()==0||name.equalsIgnoreCase(" ")||name.isEmpty()){
            throw  new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setPrise(double prise) {
        if (prise<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.prise = prise;
    }

    public double getPrise() {
        return prise;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
