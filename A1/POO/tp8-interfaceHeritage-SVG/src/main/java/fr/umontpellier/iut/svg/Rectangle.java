package fr.umontpellier.iut.svg;

public class Rectangle extends ElementSVG{
    private double x;
    private double y;
    private double width;
    private double height;
    private Double rx;
    private Double ry;

    public Rectangle(double x, double y, double width, double height) {
        super("rect");
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(double x, double y, double width, double height, double rx, double ry) {
        super("rect");
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rx = rx;
        this.ry = ry;
    }

    @Override
    public String getParameters() {
        if (rx == null)
            return "x=\"" + x + "\" y =\"" + y + "\" width =\"" + width + "\" height =\"" + height + "\"";
        else
            return "x=\"" + x + "\" y =\"" + y + "\" width =\"" + width + "\" height =\"" + height + "\" rx =\"" + rx + "\" ry =\"" + ry + "\"";
    }
}
