package MethodOverriding;

public class Rectangle {

    private double a;
    private double b;

    public Rectangle(double a) {
        this.a = a;
    }

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double calculateArea() {
        return this.getA() * this.getB();
    }

    protected double getA() {
        return a;
    }

    protected double getB() {
        return b;
    }
}
