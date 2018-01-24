package Shapes;

public class Rectangle extends Shape{
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
        this.calculatePerimeter();
        this.calculateArea();
    }


    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2*(this.height+this.width));
    }

    @Override
    public void calculateArea() {
        super.setArea(this.height*this.width);
    }
}
