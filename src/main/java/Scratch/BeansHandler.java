package Scratch;

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

    @Override
    public void startElement(String uri,
            String localName, String qName, Attributes attributes)
            throws SAXException {
        System.out.println("BeansHandler Start :" + qName);
        if ("bean".equals(qName)) {
            // We have encountered a new bean tag
            // Build up a new BeanObj object by setting a handler and doing 
            // some setup of a working state object
            String name = attributes.getValue("name");
            String classname = attributes.getValue("classname");

            System.out.println("  Parsing: " + attributes.getValue("name") + " of type " + attributes.getValue("classname"));
            if (current != null) {
                System.out.println("Adding: " + current);
                System.out.println(current);
            }
            current = new BeanObj(name, classname);

            reader.setContentHandler(new BeanHandler(reader, this));
        } else {
            System.out.println("BeansHandler Else: " + qName);
        }

    }

    @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {
        if (current != null) {
            beans.add(current);
            System.out.println("Adding: " + current);
        }
        System.out.println("BeansHandler End");
    }

    public BeanObj getCurrentBean() {
        return current;
    }
}
