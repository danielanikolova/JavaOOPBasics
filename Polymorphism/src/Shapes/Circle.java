package Shapes;

public class Circle extends Shape{


    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        this.calculateArea();
        this.calculatePerimeter();
    }


    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2*Math.PI*this.radius);
    }

    @Override
    public void calculateArea() {
        super.setArea(Math.PI*this.radius*this.radius);
    }
}
