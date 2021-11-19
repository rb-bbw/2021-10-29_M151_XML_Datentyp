package ch.bbw;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Objects;

public class task_4_4_2 {
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

        NodeList championships = document.getElementsByTagName("championship");

        for (int i = 0; i < championships.getLength(); i++) {
            Node championship = championships.item(i);
            NodeList championshipChildren = championship.getChildNodes();

            for(int j = 0; j < championshipChildren.getLength(); j++) {
                Node child = championshipChildren.item(j);

                if(child.getNodeName().equals("event")){
                    NamedNodeMap attrs = child.getAttributes();

                    for(int k = 0; k < attrs.getLength(); k++) {
                        Node attr = attrs.item(k);

                        if(attr.getTextContent().equals("2482")) { // task asks for 922 but that doesn't exist
                            System.out.println(child.getTextContent());
                        }
                    }
                }
            }
        }
    }
}
