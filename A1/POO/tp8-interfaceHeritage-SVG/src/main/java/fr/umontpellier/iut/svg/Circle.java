package fr.umontpellier.iut.svg;

public class Circle extends ElementSVG {

    private double cx;
    private double cy;
    private double r;

    public Circle(double cx, double cy, double r) {
        super("circle");
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }


    @Override
    public String getParameters() {
        return "cx=\"" + cx + "\" cy=\"" + cy + "\" r=\"" + r + "\"";
    }
}
