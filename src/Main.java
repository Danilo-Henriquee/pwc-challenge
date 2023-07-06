import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Task 1
        System.out.println(revertOrder("Hello, World! OpenAI is amazing."));
        System.out.println(revertOrder("amazing. is OpenAI World! Hello,"));
        System.out.println(revertOrder("The stars twinkle in the dark night sky, creating a magical spectacle."));

        // Task 2
        System.out.println(removeDuplicatedCharacters("Hello, World!"));
        System.out.println(removeDuplicatedCharacters("The day is beautiful today"));
        System.out.println(removeDuplicatedCharacters("I like the intern program of PwC"));

        // Task 3
        System.out.println(findMajorPalindrome("radar"));
        System.out.println(findMajorPalindrome("rotator"));
        System.out.println(findMajorPalindrome("repaper"));

        // Task 4
        System.out.println(formatter("hello. how are you? i'm fine, thank you."));
        System.out.println(formatter("hey, how was your day? it was okay. nothing special."));
        System.out.println(formatter("and yours? pretty good! i had a productive day at work."));

        // Task 5
        System.out.println(anagramOfPalindrome("racecar"));
        System.out.println(anagramOfPalindrome("aabbc"));
        System.out.println(anagramOfPalindrome("aabbce"));
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

    public static String findMajorPalindrome(String s) {
        List<String> palindromes = new ArrayList<>();

        String palindrome = "";
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            palindrome += letter;

            String toCompare = "";
            for (int j = palindrome.length(); j > 0; j--) {
                toCompare += palindrome.charAt(j - 1);
                if (toCompare.equals(palindrome)) {
                    palindromes.add(palindrome);
                    break;
                }
            }
        }
        return palindromes.get(palindromes.size() - 1);
    }

    public static String formatter(String s) {
        List<String> words = Arrays.asList(s.split(" "));
        String formatted = "";
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (i == 0) {
                String firstLetter = String.valueOf(word.charAt(0));
                word = word.replaceFirst(firstLetter, firstLetter.toUpperCase());
            }
            if (i > 0) {
                String predecessor = words.get(i - 1);
                String lastChar = String.valueOf(predecessor.charAt(predecessor.length() - 1));
                if (lastChar.equals("?") || lastChar.equals("!") || lastChar.equals(".")) {
                    String letterOfWord = String.valueOf(word.charAt(0));
                    word = word.replaceFirst(letterOfWord, letterOfWord.toUpperCase());
                }
            }
            formatted += word + " ";
        }
        return formatted;
    }

    public static String anagramOfPalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] counts = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            String digit = String.valueOf(chars[i]);
            counts[i] = countOccurrence(s, digit);
        }

        int oddCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!(counts[i] % 2 == 0)) {
                oddCount++;
            }
        }
        if (oddCount > 1) {
            return "false";
        }
        return "true";
    }
    public static int countOccurrence(String word, String letter) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            String let = String.valueOf(word.charAt(i));
            if (let.equals(letter)) {
                count++;
            }
        }
        return count;
    }
}