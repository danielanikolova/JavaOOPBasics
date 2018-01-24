package shoppingSpree;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product>products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new LinkedList<>();
    }

    public void setName(String name) {
        if (name.trim().length()==0||name.equalsIgnoreCase(" ")||name.isEmpty()){
            throw  new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product){
        if (this.money<product.getPrise()){
            System.out.printf("%s can't afford %s\n", this.name, product.getName());
        }else {
            this.setMoney(this.getMoney()-product.getPrise());
            products.add(product);
            System.out.printf("%s bought %s\n", this.name, product.getName());
        }
    }

    @Override
    public String toString() {
        if (this.products.size()==0){
            return this.name + " - Nothing bought";
        }
        return this.name+ " - " + String.join(", ",
                this.products.stream().map(Product::getName).collect(Collectors.toList()));
    }
}
