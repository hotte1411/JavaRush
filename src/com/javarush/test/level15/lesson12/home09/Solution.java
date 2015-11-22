package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        //add your code here
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String url = scanner.nextLine();
        url = url.substring(url.indexOf('?') + 1, url.length());
        String[] splitUrl = url.split("&");
        LinkedHashMap<String, String> parameters = new LinkedHashMap<>();
        for (String parameter : splitUrl)
        {
            String[] splitParameters = parameter.split("=");
            if (splitParameters.length > 1)
            {
                parameters.put(splitParameters[0], splitParameters[1]);
            } else
            {
                parameters.put(splitParameters[0], null);
            }
        }

        StringBuilder outString = new StringBuilder();

        for (Map.Entry<String, String> pair : parameters.entrySet())
        {
            outString.append(pair.getKey())
                    .append(" ");
        }

        System.out.println(outString.toString());

        if (parameters.containsKey("obj"))
        {
            String objValue = parameters.get("obj");
            if (objValue.matches("\\d*\\.?\\d+"))
            {
                double value = Double.parseDouble(objValue);
                alert(value);
            } else
            {
                alert(objValue);
            }
        }

    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
