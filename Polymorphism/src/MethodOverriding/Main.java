package MethodOverriding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        List<Rectangle> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split("\\s+");
            if (input.length==1){
                list.add(new Square(Double.parseDouble(input[0])));
            }else {
                list.add(new Rectangle(Double.parseDouble(input[0]),
                        Double.parseDouble(input[1])));
            }
        }

        for (Rectangle r:list) {
            System.out.println(r.calculateArea());
        }
    }
}
