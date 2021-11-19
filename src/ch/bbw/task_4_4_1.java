package ch.bbw;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Objects;

public class task_4_4_1 {
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

                if(Objects.equals(child.getNodeName(), "title")){
                    System.out.println(child.getTextContent());
                    // break; // seems to decrease performance, not sure why
                }
            }
        }
    }
}
