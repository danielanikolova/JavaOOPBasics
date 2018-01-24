import BankAccount.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int age;
    private List<BankAccount> bankAccounts;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
        this.bankAccounts = new ArrayList<BankAccount>();
    }

    public Person(String name, int age, List<BankAccount> bankAccounts){
        this(name, age);
        this.bankAccounts = bankAccounts;
    }

    public double getBalance(){
        return this.bankAccounts.stream().mapToDouble(s->s.getBalance()).sum();
    }


}
