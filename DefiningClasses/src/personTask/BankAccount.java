package personTask;

public class BankAccount {

    private final static double DEFAULTS_INTERESTS_RATE = 0.02;

    private static double rate = DEFAULTS_INTERESTS_RATE;
    private static int bankAccountCount;

    private int id;
    private double balance;

    public BankAccount(){
        this.id = ++bankAccountCount;
        this.balance = 0.0;
    }

    public static void setInterest(double interest){
        rate = interest;
    }

    public int getId(){
        return this.id;
    }

    public void deposit(double amount){
        this.balance+=amount;
    }

    public double getInterest(int years){
        return this.balance*rate*years;
    }



}
