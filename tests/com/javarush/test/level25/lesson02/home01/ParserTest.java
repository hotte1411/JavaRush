package com.javarush.test.level25.lesson02.home01;


import com.javarush.test.level15.lesson12.home09.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;

public class ParserTest {
    @Test
    public void parseURLtest() {
        String URL = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
        LinkedHashMap<String, String> expectedParameters = new LinkedHashMap<>();
        expectedParameters.put("lvl", "15");
        expectedParameters.put("view", null);
        expectedParameters.put("name", "Amigo");
        LinkedHashMap<String, String> actualParameters = Parser.parse(URL);
        Assert.assertEquals(expectedParameters, actualParameters);
    }

    @Test
    public void parseURL2test() {
        String URL = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        LinkedHashMap<String, String> expectedParameters = new LinkedHashMap<>();
        expectedParameters.put("obj", "3.14");
        expectedParameters.put("name", "Amigo");
        LinkedHashMap<String, String> actualParameters = Parser.parse(URL);
        Assert.assertEquals(expectedParameters, actualParameters);
    }
}
