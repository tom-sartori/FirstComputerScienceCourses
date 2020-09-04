package fr.umontpellier.iut.svg;

public class Scale implements Transform {

    private double x;
    private double y;

    public Scale(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "scale(" + x + " " + y + ")";
    }

}
