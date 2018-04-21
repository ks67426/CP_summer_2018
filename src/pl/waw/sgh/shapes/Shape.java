package pl.waw.sgh.shapes;

public abstract class Shape {
    protected Double parA = 0d;
    protected Double parB = 0d;
    protected Double parC = 0d;

    public Shape(double a, double b) {
        setParams(a, b);
    }

    public Shape(double a) {
        setParam(a);
    }
    public Shape(double a, double b, double c){
        setParameters(a, b, c);

    }

    public void setParameters(double a, double b, double c){
        parA=a;
        parB=b;
        parC=c;
    }
    public void setParam(double a) {
        parA = a;
    }

    public void setParams(double a, double b) {
        parA = a;
        parB = b;
    }

    public abstract double calcSurface();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [parA=" + parA + ", parB=" + parB + " parC=" +parC+"]";
        //+ super.toString();
    }


}