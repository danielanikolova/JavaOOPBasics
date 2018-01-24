package personTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private static HashMap<Integer, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();


        while (!"End".equals(command)) {
            String[] cmdArgs = command.split("\\s+");

            String commandType = cmdArgs[0];
            int id = 0;

            switch (commandType) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    accounts.put(bankAccount.getId(), bankAccount);
                    System.out.printf("Account ID%d created\n", bankAccount.getId());
                    break;
                case "Deposit":
                    Double moneyAmount = Double.valueOf(cmdArgs[2]);
                    id = Integer.parseInt(cmdArgs[1]);
                    deposit(id, moneyAmount);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(cmdArgs[1]);
                    int years = Integer.parseInt(cmdArgs[2]);
                    executeGetInterestCommand(id, years);

                    break;

                case "SetInterest":
                    executeSetInterestCommand(cmdArgs);
                    break;

            }

            command = br.readLine();
        }


    }

    private static void executeGetInterestCommand(int id, int years) {
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            BankAccount account = accounts.get(id);
            System.out.printf("%.2f\n", account.getInterest(years));
        }
    }

    private static void executeSetInterestCommand(String[] cmdArgs) {
        double globalInterest = Double.valueOf(cmdArgs[1]);
        BankAccount.setInterest(globalInterest);

    }


    private static void deposit(Integer id, Double moneyAmount) {
        if (accounts.containsKey(id)) {
            BankAccount account = accounts.get(id);
            account.deposit(moneyAmount);
            System.out.printf("Deposited %.0f to ID%d\n", moneyAmount, id);
        } else System.out.printf("Account does not exist\n");

    }


}
