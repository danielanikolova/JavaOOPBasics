package MordorsCruelty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] foods = br.readLine().split("\\s+");
        Mordor mordor = new Mordor();
        for (int i = 0; i < foods.length; i++) {
            mordor.eatFood(foods[i]);
        }

        System.out.println(mordor.toString());
    }
}
