package classBoxTask;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
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
