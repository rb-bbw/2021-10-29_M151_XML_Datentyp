package ch.bbw;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Objects;

public class task_4_3_2 {
    private static Document document;
    private static final String fileName = "resources/realtime.xml";

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(fileName);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*Node championship = document.getElementById("421");
        System.out.printf("%s %s%n", championship.getNodeName(), championship.getAttributes().item(0).getNodeValue());*/

        NodeList championships = document.getElementsByTagName("championship");

        for (int i = 0; i < championships.getLength(); i++) {
            Node championship = championships.item(i);
            System.out.printf("%s %s%n", championship.getNodeName(), championship.getAttributes().item(0).getNodeValue());
        }
    }
}
