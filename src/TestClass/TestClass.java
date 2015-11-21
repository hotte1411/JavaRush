package TestClass;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestClass {

    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + " --- " + entry.getValue());
        }
    }
}
