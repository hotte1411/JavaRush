package com.javarush.test.level15.lesson12.home09;


import java.util.LinkedHashMap;
import java.util.Map;

public class Parser {

    public static LinkedHashMap<String, String> parse(String URL) {

        String parametersFromUrl = URL.substring(URL.indexOf('?') + 1);
        String[] splitUrl = parametersFromUrl.split("&");
        LinkedHashMap<String, String> parameters = new LinkedHashMap<>();
        for (String parameter : splitUrl) {
            String[] splitParameters = parameter.split("=");
            if (splitParameters.length > 1) {
                parameters.put(splitParameters[0], splitParameters[1]);
            } else {
                parameters.put(splitParameters[0], null);
            }
        }
        return parameters;
    }

}
