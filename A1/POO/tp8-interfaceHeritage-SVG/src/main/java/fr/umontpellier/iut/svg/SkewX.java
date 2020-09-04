package fr.umontpellier.iut.svg;

public class SkewX implements Transform {

    private double a;

    public SkewX(double a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "skewX(" + a + ")";
    }
}
