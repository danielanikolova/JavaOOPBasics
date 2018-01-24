package MethodOverriding;

public class Square extends Rectangle {


    public Square(double a) {
        super(a);
    }

    @Override
    public double calculateArea() {
        return this.getA()*this.getA();
    }
}
