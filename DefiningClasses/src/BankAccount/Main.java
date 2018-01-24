package BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private static HashMap<Integer, BankAccount> accounts = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();


        while (!"End".equals(command)){
            String[]cmdArgs = command.split("\\s+");

            String commandType = cmdArgs[0];

            switch (commandType){
                case "Create":
                    execCreate(Integer.valueOf(cmdArgs[1]));
                    break;
                case "Deposit":
                    Double moneyAmount = Double.valueOf(cmdArgs[2]);
                    deposit(Integer.valueOf(cmdArgs[1]), moneyAmount);
                    break;
                case "Withdraw":
                    Double money = Double.valueOf(cmdArgs[2]);
                    withdraw(Integer.valueOf(cmdArgs[1]), money);
                    break;
                case "Print":
                    printAccount(Integer.valueOf(cmdArgs[1]));
                    break;
            }



            command = br.readLine();
        }



    }

    private static void printAccount(Integer id) {
        if (accounts.containsKey(id)){
            System.out.println(accounts.get(id).toString());
        }else System.out.println("Account does not exist");
    }

    private static void withdraw(Integer id, Double money) {
        if (accounts.containsKey(id)){
          accounts.get(id).withdraw(money);
        }else System.out.println("Account does not exist");
    }

    private static void deposit(Integer id, Double moneyAmount) {
        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        }else {
            accounts.get(id).deposit(moneyAmount);
        }

    }

    private static void execCreate(Integer id) {
        if (accounts.containsKey(id)){
            System.out.println("Account already exists");
        }else {
            BankAccount bankAccount = new BankAccount(id);
            accounts.put(id,bankAccount);
        }
    }
}
