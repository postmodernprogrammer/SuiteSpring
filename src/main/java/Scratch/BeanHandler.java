package Scratch;

import com.netledger.suitespring.BeanObj;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.util.Map;

/**
 * Created by bedwards on 01/07/15.
 */
public class BeanHandler extends DefaultHandler {

    private XMLReader reader;
    private BeansHandler parent;

    private String name;
    private String classname;
    public Map<String, Object> properties;

    public BeanHandler(XMLReader reader, BeansHandler parent) {
        this.reader = reader;
        this.parent = parent;
    }

    @Override
    public void startElement(String uri,
            String localName, String qName, Attributes attributes)
            throws SAXException {

        System.out.println("Bean Handler Start :" + qName);
        
        if ("p".equals(qName)) {
            BeanObj b = parent.getCurrentBean();
            b.putValue(attributes.getValue("name"), attributes.getValue("value"));
            
        } else {
            System.out.println("Bean Handler Start Else: " + qName);
        }

    }

    @Override
    public void endElement(String uri,
            String localName, String qName)
            throws SAXException {

        System.out.println("  BeanHandler End " + name + " " + classname);
        if ("bean".equals(qName)) {
            reader.setContentHandler(parent);
        } else {
            System.out.println("Bean Handler End Else: " + localName);
        }
    }

}
