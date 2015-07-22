package com.netledger.suitespring;

import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bedwards on 01/07/15.
 */
public class Bootstrap {

    public Map<String, BeanObj> importFromXML(String filename) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        HashMap<String, BeanObj> map = new HashMap<>();
        try {
            File inputFile = new File(filename);
            SAXParser saxParser = factory.newSAXParser();

            XMLReader reader = saxParser.getXMLReader();
//            BeansHandler handler = new BeansHandler();
            BeansHandler handler = new BeansHandler(reader);
            List<BeanObj> beans = handler.getBeans();

            saxParser.parse(inputFile, handler);
            for (BeanObj b : beans ) {
                map.put(b.getName(),b);
            }


        } catch (Exception e) {

        }
        return map;
    }
}
