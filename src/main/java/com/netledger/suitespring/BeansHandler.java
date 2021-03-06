package com.netledger.suitespring;

import com.netledger.suitespring.BeanObj;
import java.util.ArrayList;
import org.xml.sax.XMLReader;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;
import java.util.Map;

/**
 * Created by bedwards on 01/07/15.
 */
public class BeansHandler extends DefaultHandler {

    private final XMLReader reader;

    private final List<BeanObj> beans = new ArrayList<>();
    private BeanObj current = null;

    public BeansHandler(XMLReader reader) {
        this.reader = reader;
    }

    public List<BeanObj> getBeans() {
        return beans;
    }

    @Override
    public void startElement(String uri,
            String localName, String qName, Attributes attributes)
            throws SAXException {
        if ("bean".equals(qName)) {
            // We have encountered a new bean tag
            // Build up a new BeanObj object by setting a handler and doing 
            // some setup of a working state object
            String name = attributes.getValue("name");
            String classname = attributes.getValue("classname");
            if (current != null) {

            }
            current = new BeanObj(name, classname);
            beans.add(current);

            reader.setContentHandler(new BeanHandler(reader, this));
        } else {
        }

    }

    @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {
        if (current != null) {
            beans.add(current);
        }
    }

    public BeanObj getCurrentBean() {
        return current;
    }
}
