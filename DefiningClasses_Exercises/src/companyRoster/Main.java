package companyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Set<Employee>> departments = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();

        for (int i = 0; i < n; i++) {

            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = new Employee(name, salary, position, department);

            if (tokens.length==5){
                if (Character.isDigit(tokens[4].charAt(0))){
                    int age = Integer.parseInt(tokens[4]);
                    employee.setAge(age);
                }else employee.setEmail(tokens[4]);
            }
            if (tokens.length==6){
               int age = Integer.parseInt(tokens[5]);
               employee.setAge(age);
               employee.setEmail(tokens[4]);
            }

            departments.putIfAbsent(department, new HashSet<>());
            departments.get(department).add(employee);


           line = br.readLine();
        }

        departments.entrySet().stream()
                .sorted((d1,d2)->
                Double.compare(
                        d2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        d1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1)
                .forEach(d->{
                    System.out.println("Highest Average Salary: " + d.getKey());
                    d.getValue().stream().sorted((e1, e2)-> Double.compare(
                            e2.getSalary(), e1.getSalary()))
                            .forEach(System.out::println);
                });





    }
}
