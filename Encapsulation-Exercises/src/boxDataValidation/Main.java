package boxDataValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(br.readLine());
        double width = Double.parseDouble(br.readLine());
        double height = Double.parseDouble(br.readLine());

        try {
            Box box = new Box(length, width, height);
            System.out.println(box.toString());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
