package com.javarush.test.level15.lesson12.home09;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;

@RunWith(value = Parameterized.class)
public class ParserUrlToParametersTest {

    LinkedHashMap correctMap;
    String testUrl;

    public ParserUrlToParametersTest(LinkedHashMap correctMap, String  testUrl){
        this.correctMap = correctMap;
        this.testUrl = testUrl;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        String url1 = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
        LinkedHashMap<String, String> map1 = new LinkedHashMap<>();
        map1.put("lvl", "15");
        map1.put("view", null);
        map1.put("name", "Amigo");

        String url2 = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        LinkedHashMap<String, String> map2 = new LinkedHashMap<>();
        map2.put("obj", "3.14");
        map2.put("name", "Amigo");

        Object[][] data = new Object[][] {
                {map1, url1}, {map2, url2}
        };

        return Arrays.asList(data);
    }

    @Test
    public void parseUrlTest() {
        LinkedHashMap<String, String> actualMap = ParserUrlToParameters.parse(testUrl);
        Assert.assertEquals(correctMap, actualMap);
    }
}