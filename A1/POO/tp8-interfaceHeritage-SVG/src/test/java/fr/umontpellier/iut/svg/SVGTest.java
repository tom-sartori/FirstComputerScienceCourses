package fr.umontpellier.iut.svg;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Node;

import static org.junit.jupiter.api.Assertions.*;

public class SVGTest {

    @Test
    void image_SVG_vide() {
        Tag svg = new SVG(1024, 768);
        Node n = Utils.convertStringToXMLNode(svg.toSVG());
        assertEquals("svg", n.getNodeName());
        assertTrue(Utils.hasDoubleAttributes(n, new String[]{"width", "height"}, new double[]{1024, 768}));
    }
}
