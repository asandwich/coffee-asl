package com.asandwich.casl.tools;

import java.util.HashMap;

public class Tools {
    private static HashMap<String, Integer> properties = new HashMap<>();

    public static Integer getProperty(String string) {
        return properties.get(string);
    }

    public static void readPropertiesFile() {

    }
}
