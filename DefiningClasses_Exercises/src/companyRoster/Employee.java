package companyRoster;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email = "n/a";
    private int age = -1;


    public Employee(String name, double salary, String position, String department){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }
    public Employee(String name, double salary, String position, String department, String email){
        this(name, salary, position,department);
        this.email = email;
    }

    public Employee(String name, double salary, String position, String department, int age){
        this(name, salary, position,department);
        this.age = age;
    }
    public Employee(String name, double salary, String position, String department,String email, int age){
        this(name, salary, position,department);
        this.age = age;
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
