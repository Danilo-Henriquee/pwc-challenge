import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Task 1
        System.out.println(revertOrder("Hello, World! OpenAI is amazing."));
        System.out.println(revertOrder("amazing. is OpenAI World! Hello,"));
        System.out.println(revertOrder("The stars twinkle in the dark night sky, creating a magical spectacle."));
    }

    public static String revertOrder(String s) {
        String[] arr = s.split(" ");
        StringBuilder newStr = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            newStr.append(arr[i]).append(" ");
        }
        return newStr.toString();
    }
}