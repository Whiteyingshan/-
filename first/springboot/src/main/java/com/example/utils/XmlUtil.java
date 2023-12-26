package com.example.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class XmlUtil {
    public static Map<String, Object> parseXML(InputStream inputStream) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);

        Element root = document.getDocumentElement();
        if (root != null) {
            NodeList nodeList = root.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    String key = node.getNodeName();
                    String value = node.getTextContent();
                    resultMap.put(key, value);
                }
            }
        }

        return resultMap;
    }
}
