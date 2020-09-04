package fr.umontpellier.iut.svg;

public class Rotate implements Transform {

    private double a;
    private double x;
    private double y;

    public Rotate(double a, double x, double y) {
        this.a = a;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "rotate(" + a + " " + x + " " + y + ")";
    }

}
