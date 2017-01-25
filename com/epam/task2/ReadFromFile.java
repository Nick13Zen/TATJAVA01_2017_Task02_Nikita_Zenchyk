package com.epam.task2;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class to fill shop with items
 * Created by Nikita_Zenchyk on 1/20/2017.
 */
public class ReadFromFile {
    private File file = new File("store.xml");

    /**
     * Method to read items from xml file and putting them in shop
     * @return collection of item read from file
     * @throws NullPointerException
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public Map<SportEquipment, Integer> read() throws NullPointerException, ParserConfigurationException, IOException, SAXException {
        Map<SportEquipment, Integer> goods = new HashMap<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        NodeList nodes = document.getElementsByTagName("unit");
        SportEquipment key;
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attrs = nodes.item(i).getAttributes();
            String category = attrs.getNamedItem("category").getNodeValue();
            String title = attrs.getNamedItem("title").getNodeValue();
            int price = Integer.parseInt(attrs.getNamedItem("price").getNodeValue());
            key = new SportEquipment(category, title, price);
            goods.put(key, Integer.parseInt(attrs.getNamedItem("count").getNodeValue()));
        }
        return goods;
    }
}
