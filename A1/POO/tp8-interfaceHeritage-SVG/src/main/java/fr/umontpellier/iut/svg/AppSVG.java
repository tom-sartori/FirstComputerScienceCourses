package fr.umontpellier.iut.svg;

//import com.sun.org.apache.bcel.internal.generic.StackProducer;

public class AppSVG {
    public static void main(String[] args) {

        makeSquare();   //square.svg
        makeCircle();   //circle.svg
        makeCircleWithCoord();  //circle1.svg
    }

    public static void makeSquare() {
        SVG svg = new SVG(1000, 1000);

        ElementSVG rectangle = new Rectangle(0, 0, 1000, 1000);
        Style style = new Style();
        style.setFill("lightblue");
        rectangle.setStyle(style);


        Group group = new Group();
        Style style1 = new Style();
        style1.setStroke("black");
        style1.setStrokeWidth(20.0);
        style1.setFillOpacity(0.8);
        group.setStyle(style1);

        ElementSVG rectangle1 = new Rectangle(100, 100, 200, 200);
        Style style2 = new Style();
        style2.setFill("#080");
        rectangle1.setStyle(style2);
        group.add(rectangle1);

        ElementSVG rectangle2 = new Rectangle(200, 200, 400, 400);
        Style style3 = new Style();
        style3.setFill("#0C0");
        rectangle2.setStyle(style3);
        group.add(rectangle2);

        Group group1 = new Group();
        group.add(group1);

        Style style4 = new Style();
        Transform rotate = new Rotate(-45, 100, 50);
        Transform translate = new Translate(0, 700);
        style4.addTransform(rotate);
        style4.addTransform(translate);
        group1.setStyle(style4);

        ElementSVG rectangle3 = new Rectangle(100, 100, 200, 200);
        Style style5 = new Style();
        style5.setFill("#800");
        rectangle3.setStyle(style5);
        group1.add(rectangle3);

        ElementSVG rectangle4 = new Rectangle(200, 200, 400, 400);
        Style style6 = new Style();
        style6.setFill("#C00");
        rectangle4.setStyle(style6);
        group1.add(rectangle4);


        svg.add(rectangle);
        svg.add(group);

        svg.saveAsFile("square.svg");
    }


    public static void makeCircleWithCoord() {
        SVG svg = new SVG(920, 920);

        Group group = new Group();
        Style style = new Style();
        style.setFillOpacity(0.5);
        style.setStroke("black");
        style.setStrokeWidth(8.0);
        group.setStyle(style);


        ElementSVG circle1 = new Circle(310, 310, 300);
        group.add(circle1);
        Style style1 = new Style();
        style1.setFill("green");
        circle1.setStyle(style1);

        ElementSVG circle2 = new Circle(610, 310, 300);
        group.add(circle2);
        Style style2 = new Style();
        style2.setFill("blue");
        circle2.setStyle(style2);

        ElementSVG circle3 = new Circle(460, 610, 300);
        group.add(circle3);
        Style style3 = new Style();
        style3.setFill("red");
        circle3.setStyle(style3);

        svg.add(group);

        svg.saveAsFile("circle1.svg");
    }

    public static void makeCircle() {
        SVG svg = new SVG(1000, 1000);

        ElementSVG circle1 = new Circle(500, 500, 300);
        Style style1 = new Style();
        style1.setFill("green");
        Transform translate1 = new Translate(-150, -150);
        style1.addTransform(translate1);
        circle1.setStyle(style1);

        ElementSVG circle2 = new Circle(500, 500, 300);
        Style style2 = new Style();
        style2.setFill("blue");
        Transform translate2 = new Translate(150, -150);
        style2.addTransform(translate2);
        circle2.setStyle(style2);

        ElementSVG circle3 = new Circle(500, 500, 300);
        Style style3 = new Style();
        style3.setFill("red");
        Transform translate3 = new Translate(0, 150);
        style3.addTransform(translate3);
        circle3.setStyle(style3);


        Group group = new Group();
        Style style = new Style();
        style.setFillOpacity(0.5);
        style.setStroke("black");
        style.setStrokeWidth(8.0);
        group.setStyle(style);

        group.add(circle1);
        group.add(circle2);
        group.add(circle3);


        svg.add(group);

        svg.saveAsFile("circle.svg");
    }
}
