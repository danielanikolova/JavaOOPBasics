package BankAccount;

public class BankAccount {

     private int id;
     private double balance;

     public BankAccount(int id){
        this.id = id;
        this.balance = 0.0;
    }


    public void setId(int id) {
        this.id = id;
    }
    public double getBalance(){
         return this.balance;
    }

    void deposit(double amount){
        this.balance+=amount;
    }

    void withdraw(double amount){
        if (this.balance - amount<0){
            System.out.println("Insufficient balance");
        }else {
            this.balance-=amount;
        }

    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.id, this.getBalance());
    }
}


