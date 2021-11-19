package ch.bbw;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class task_4_4_3 {
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

        for (int i = 0; i < championships.getLength(); i++) { // go through all championships
            Node championship = championships.item(i);
            NodeList championshipChildren = championship.getChildNodes();

            for(int j = 0; j < championshipChildren.getLength(); j++) { // go through their children
                Node championshipChild = championshipChildren.item(j);

                if(championshipChild.getNodeName().equals("event")){ // if a child is an event
                    NodeList eventChildren = championshipChild.getChildNodes();

                    for(int k = 0; k < eventChildren.getLength(); k++) { // go through its children
                        Node eventChild = eventChildren.item(k);

                        if(eventChild.getNodeName().equals("issftitle")) { // if a child is the issftitle
                            if(eventChild.getTextContent().equals("Final Double Trap Men")) {
                                System.out.println(championshipChild.getTextContent());
                            }
                        }
                    }
                }
            }
        }
    }
}
