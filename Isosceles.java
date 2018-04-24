package pl.waw.sgh.shapes;

public class Isosceles extends Triangle{
    public Isosceles(double a, double b){
        super(a, b);
    }
    @Override
    public double calcSurface() {
        return parA*parB/2;
    }
}
