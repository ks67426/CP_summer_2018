package pl.waw.sgh.shapes;

import java.lang.*;
public class Scalene extends Triangle {
    public Scalene(double a, double b, double c) {
        super(a, b, c);
    }

    @Override
    public double calcSurface() {
        double p = 0.5d*(parA+parB+parC);
        return Math.sqrt(p*(p-parA) * (p-parB)*(p-parC));
    }
}