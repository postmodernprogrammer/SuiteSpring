package com.netledger.suitespring;

import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bedwards on 01/07/15.
 */
public class Bootstrap {

    public Map<String, BeanObj> importFromXML(String filename) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {

            File inputFile = new File(filename);
            SAXParser saxParser = factory.newSAXParser();

            XMLReader reader = saxParser.getXMLReader();
//            BeansHandler handler = new BeansHandler();
            BeansHandler handler = new BeansHandler(reader);
            saxParser.parse(inputFile, handler);
            System.out.println("Parse End");

        } catch (Exception e) {

        }
        return new HashMap<>();
    }
}
