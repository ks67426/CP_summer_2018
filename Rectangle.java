package pl.waw.sgh.shapes;

public class Rectangle extends Shape {


    public Rectangle(double sideA, double sideB) {
        super(sideA, sideB);
    }

    @Override
    public double calcSurface() {
        return parA*parB;
    }

    @Override
    public String toString() {
        return "My " + super.toString();
    }

}