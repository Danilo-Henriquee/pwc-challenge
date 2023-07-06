import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Task 1
        System.out.println(revertOrder("Hello, World! OpenAI is amazing."));
        System.out.println(revertOrder("amazing. is OpenAI World! Hello,"));
        System.out.println(revertOrder("The stars twinkle in the dark night sky, creating a magical spectacle."));

        // task 2
        System.out.println(removeDuplicatedCharacters("Hello, World!"));
        System.out.println(removeDuplicatedCharacters("The day is beautiful today"));
        System.out.println(removeDuplicatedCharacters("I like the intern program of PwC"));
    }

    public static String revertOrder(String s) {
        String[] arr = s.split(" ");
        StringBuilder newStr = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            newStr.append(arr[i]).append(" ");
        }
        return newStr.toString();
    }

    public static String removeDuplicatedCharacters(String s) {
        char[] letters = new char[s.length()];
        StringBuilder finalWorld = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (letter == ' ') {
                finalWorld.append(' ');
            } else {
                if(!(contains(letters, letter))) {
                    letters[i] = letter;
                    finalWorld.append(letter);
                }
            }
        }
        return finalWorld.toString();
    }
    public static boolean contains(char[] letters, char letter) {
        char[] cloned = new char[letters.length + 1];
        for (int i = 0; i < letters.length; i++) {
            cloned[i] = letters[i];
        }
        cloned[letters.length] = letter;
        int i = 0;
        while(cloned[i] != letter) i++;
        if (i == letters.length) return false;
        return true;
    }
}