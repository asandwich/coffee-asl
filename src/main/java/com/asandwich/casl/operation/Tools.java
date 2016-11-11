package com.asandwich.casl.operation;

import java.util.HashMap;

public class Tools {
    private static HashMap<String, Integer> properties = new HashMap<String, Integer>();

    public static Integer getProperty(String string) {
        return properties.get(string);
    }

    public static void readPropertiesFile() {

    }
}
