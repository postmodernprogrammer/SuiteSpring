package com.netledger.suitespring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbrook on 01/07/2015.
 */
public class BeanObj {
    private final String name;
    private final String className;
    private final Map<String, String> values;
    private final Map<String, String> references;

    public BeanObj(String name, String className, Map<String, String> values, Map<String, String> references) {
        this.name = name;
        this.className = className;
        this.values = values;
        this.references = references;
    }

    public BeanObj(String name, String className) {
        this(name, className, new HashMap<>(), new HashMap<>());
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public Map<String, String> getReferences() {
        return references;
    }

    public Map<String, String> getValues() {
        return values;
    }

    public void putValue(String name, String value) {
        values.put(name, value);
    }

    @Override
    public String toString() {
        return "BeanObj{" + "name=" + name + ", className=" + className + ", values=" + values + ", references=" + references + '}';
    }
}
