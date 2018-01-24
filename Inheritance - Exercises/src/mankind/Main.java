package mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split("\\s+");
        String[] line2 = br.readLine().split("\\s+");

        try {
            Student student =new Student(line[0], line[1], line[2]);
            Worker worker = new Worker(line2[0], line2[1],
                    Double.parseDouble(line2[2]), Double.parseDouble(line2[3]));

            System.out.println(student.toString());
            System.out.println(worker.toString());

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
