package fr.umontpellier.iut.svg;

public class Group extends ElementSVG {

    private SVG delegue;

    public Group() {
        super("g");
        delegue = new SVG(0, 0);
    }


    public void add(ElementSVG t) {
        delegue.add(t);
    }


    @Override
    public String getContent() {
        return delegue.getContent();
    }
}
