package pl.waw.sgh.shapes;
import java.lang.*;
public class Equitelar extends Triangle {
    public Equitelar(double a) {
        super(a);
    }

    @Override
    public double calcSurface() {
        return parA*parA*Math.sqrt(3)/4;
    }
}