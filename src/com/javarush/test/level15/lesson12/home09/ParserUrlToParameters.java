package com.javarush.test.level15.lesson12.home09;


import java.util.LinkedHashMap;

public class ParserUrlToParameters {

    public static LinkedHashMap<String, String> parse(String URL) {

        String parametersFromUrl = URL.substring(URL.indexOf('?') + 1);
        String[] splittedUrl = parametersFromUrl.split("&");
        LinkedHashMap<String, String> parameters = new LinkedHashMap<>();
        for (String parameter : splittedUrl) {
            String[] splittedParameters = parameter.split("=");
            if (splittedParameters.length > 1) {
                parameters.put(splittedParameters[0], splittedParameters[1]);
            } else {
                parameters.put(splittedParameters[0], null);
            }
        }
        return parameters;
    }

}
