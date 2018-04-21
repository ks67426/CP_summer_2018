package pl.waw.sgh.shapes;

public abstract class Triangle extends Shape{
    public Triangle(double a, double b, double c){
        super(a, b, c);
    }
    public Triangle(double a, double b){
        super(a, b);
    }
    public Triangle(double a){
        super(a);
    }
}
