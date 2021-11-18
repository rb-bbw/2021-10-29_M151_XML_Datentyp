package ch.bbw;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Objects;

public class task_4_2_2 {
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

        NodeList nodes = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if(Objects.equals(node.getNodeName(), "championship")) {
                System.out.println("Championship " + node.getAttributes().item(0).getNodeValue());

                NodeList childNodes = node.getChildNodes();
                for(int j = 0; j < childNodes.getLength(); j++) {
                    Node childNode = childNodes.item(j);
                    if(!Objects.equals(childNode.getNodeName(), "#text")){
                        Node id = childNode.getAttributes().item(0);
                        String value = id == null ? childNode.getTextContent() : id.getNodeValue(); // id or text

                        System.out.println("\t" + childNode.getNodeName() + " " + value);
                    }
                }
            }

            System.out.println("\n");
        }
    }
}
