package mankind;

public class Worker extends Human{

    private double weekSalary;
    private double workingHours;

    public Worker(String firstName, String lastName, Double weekSalary, double workingHours) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkingHours(workingHours);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length()<3){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary<10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkingHours(double workingHours) {
        if (workingHours<1&&workingHours>12){
            throw  new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workingHours = workingHours;
    }

    private double getSalaryPerHour(){
        double salaryPerHour = this.weekSalary/(7*this.workingHours);

        return salaryPerHour;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("Week Salary: %.2f\n", this.weekSalary));
        sb.append(String.format("Hours per day: %.2f\n", this.workingHours));
        sb.append(String.format("Salary per hour: %.2f\n", this.getSalaryPerHour()));
        return sb.toString();
    }
}
