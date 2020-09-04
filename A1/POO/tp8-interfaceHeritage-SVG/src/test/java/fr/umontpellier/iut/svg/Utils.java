package fr.umontpellier.iut.svg;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;

import static org.w3c.dom.Node.ELEMENT_NODE;

public class Utils {
    public static ArrayList<Node> getElementChildNodes(Node node) {
        ArrayList<Node> elementChildNodes = new ArrayList<>();
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == ELEMENT_NODE) {
                elementChildNodes.add(childNodes.item(i));
            }
        }
        return elementChildNodes;
    }

    public static boolean containsInOrder(String s, String[] factors) {
        int index = 0;
        for (String factor : factors) {
            index = s.indexOf(factor, index);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    public static Node convertStringToXMLNode(String xmlString) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            return factory.newDocumentBuilder().parse(new InputSource(new StringReader(xmlString))).getFirstChild();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean hasStringAttributes(Node node, String[] names, String[] values) {
        for (int i = 0; i < names.length; i++) {
            Node attr = node.getAttributes().getNamedItem(names[i]);
            if (!values[i].equals(attr.getNodeValue())) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasDoubleAttributes(Node node, String[] names, double[] values) {
        for (int i = 0; i < names.length; i++) {
            Node attr = node.getAttributes().getNamedItem(names[i]);
            if (values[i] != Double.parseDouble(attr.getNodeValue())) {
                return false;
            }
        }
        return true;
    }
}
