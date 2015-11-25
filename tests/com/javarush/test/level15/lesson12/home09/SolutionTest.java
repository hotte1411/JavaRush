package com.javarush.test.level15.lesson12.home09;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class SolutionTest {

    String correctString;
    String testString;

    public SolutionTest(String corr, String tst) {
        this.correctString = corr;
        this.testString = tst;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        String testStr1 = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
        String correctStr1 = "lvl view name";
        String testStr2 = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        String correctStr2 = "obj name";
        Object[][] data = new Object[][] {
                {correctStr1, testStr1},
                {correctStr2, testStr2}
        };
        return Arrays.asList(data);
    }

    @Test
    public void testGetResultFromUrl() throws Exception {
        String actualString = Solution.getResultFromUrl(testString);
        Assert.assertEquals(correctString, actualString);
    }

    @Test
    public void testInvokeAlert() throws Exception {

    }
}