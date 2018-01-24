package boxDataValidation;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setHeight(height);
        setLength(length);
        setWidth(width);
    }

    public double getSurface(){
        double surface = 2*this.length*this.width +
                2*this.length*this.height + 2*this.width*this.height;
        return surface;
    }

    public double getLateralSurfaceArea(){
        double surface = 2*this.length*this.height + 2*this.width*this.height;
        return surface;

    }

    public  double getVolume(){
        double volume = this.length*this.width*this.height;
        return volume;
    }

    public void setLength(double length) {
        if (length<=0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public void setWidth(double width) {
        if (width<=0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height<=0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f\n" +
                "Lateral Surface Area - %.2f\n" +
                "Volume - %.2f",
                this.getSurface(),
                this.getLateralSurfaceArea(),
                this.getVolume()
                );
    }
}
