package com.netledger.suitespring;

import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by bedwards on 22/07/15.
 */
public class BootstrapTest {

    @Test
    public void testXML1() throws Exception {

        Bootstrap b = new Bootstrap();
        Map<String, BeanObj> beanGraph = b.importFromXML("test/main/resources/test1.xml");
        assertEquals(2, beanGraph.size());
        assertTrue(beanGraph.containsKey("stringHolder"));
        assertTrue(beanGraph.containsKey("intHolder"));
    }

    @Test
    public void testXML2() throws Exception {
        Bootstrap b = new Bootstrap();
        Map<String, BeanObj> beanGraph = b.importFromXML("test/main/resources/test2.xml");
    }

}