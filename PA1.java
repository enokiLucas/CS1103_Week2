/**
 * Scenario: You have been asked to create a text analysis tool that will perform various operations on a given text input. This tool will help users gain insights into the text data by performing character and word analysis. 


 Assignment Tasks: 


 User Input: Ask the user to input a paragraph or a lengthy text. Your program should read and store this input. 

 Character Count: Calculate and display the total number of characters in the input text. 

 Word Count: Calculate and display the total number of words in the input text. Assume that words are separated by spaces. 

 Most Common Character: Find and display the most common character in the text. In case of a tie, select any of the tied characters. 

 Character Frequency: Ask the user to input a character. Check and display the frequency of occurrences of this character in the text. Be case-insensitive (e.g., 'a' and 'A' should be considered the same character). 

 Word Frequency: Ask the user to input a word. Check and display the frequency of occurrences of this word in the text. Be case-insensitive. 

 Unique Words: Calculate and display the number of unique words in the text (case-insensitive).

 *
 */

import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

/**
 * ToDo: split whitespace using "\s+"
 */
public class PA1 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String userString = getLine(stdin);

        // Character Count
        //characterCount(userString);

        // Word count
        //wordCount(userString);

        // Most Common Character
        //HashMap<Character, Integer> userHashMap = makeHashMap(userString);
        //mostCommonCharacter(userHashMap);

        // Character Frequency
        String userStringUpper = userString.toUpperCase();
        //HashMap<Character, Integer> userHashMapUpper = makeHashMap(userStringUpper);
        //characterFrequency(userHashMapUpper, stdin);

        // Word Frequency
        //wordFrequency(userStringUpper, stdin);


        // Unique Words
        numberOfUniqueWords(userStringUpper);


        stdin.close();
    }

    public static String getLine(Scanner stdin) {

        String userInput;

        System.out.println("Please input a paragraph or a lengthy text: ");
        userInput = stdin.nextLine();

        return userInput;
    }

    public static int characterCount(String userString) {
        int userStringLength = userString.length();
        System.out.println("Character Count: " + userStringLength);
        return userStringLength;
    }

    public static int wordCount(String userString) {
        String[] userArray = userString.split(" ");
        int wordCount = userArray.length;
        System.out.println("Word Count: " + wordCount);
        return wordCount;
    }

    public static HashMap<Character, Integer> makeHashMap(String userString) {
        HashMap<Character, Integer> userHashMap = new HashMap<Character, Integer>();

        String userStringWithoutSpaces = userString.replaceAll(" ", "");
        char[] userArray = userStringWithoutSpaces.toCharArray();

        for (char c : userArray) {
            if (userHashMap.containsKey(c)) {
                userHashMap.put(c, userHashMap.get(c) + 1);
            }
            else {
                userHashMap.put(c, 1);
            }
        }
        return userHashMap;
    }

    public static char mostCommonCharacter(HashMap<Character, Integer> userHashMap) {
        int mostCommonValue = Collections.max(userHashMap.values());
        System.out.println(mostCommonValue);
        for (Map.Entry<Character, Integer> entry: userHashMap.entrySet()) {
            if (entry.getValue() == mostCommonValue) {
                System.out.println(entry.getKey());
                return entry.getKey();
            }
        }
        throw new Error("No Character found");
    }

    public static int characterFrequency(HashMap<Character, Integer> userHashMap, Scanner stdin) {
        System.out.println("Please type character to check its frequency: ");
        String userInputLetter = stdin.nextLine();

        if (userInputLetter.length() != 1) {
            throw new InputMismatchException("Please only type a single character");
        }
        String userInputLetterUpper = userInputLetter.toUpperCase();
        char userInputChar = userInputLetterUpper.charAt(0);

        for (Map.Entry<Character, Integer> entry: userHashMap.entrySet()) {
            if (entry.getKey() == userInputChar) {
                System.out.println(entry.getValue());
                return entry.getValue();
            }
        }
        throw new Error("No Value found");
    }

    public static int wordFrequency(String userString, Scanner stdin){
        System.out.println("Please type a word to check its frequency: ");
        String userWord = stdin.nextLine();
        String[] userArray = userString.split(" ");
        int frequency = 0;
        for (String word : userArray) {
            if (word.equalsIgnoreCase(userWord)) {
                frequency = frequency + 1;
            }
        }
        System.out.println(frequency);
        return frequency;
    }

    public static int numberOfUniqueWords(String userStringUpper) {
        HashMap<String, Integer> userHashMap = new HashMap<String, Integer>();
        String[] userArray = userStringUpper.split(" ");
        for (String word : userArray) {
            if (userHashMap.containsKey(word)) {
                userHashMap.put(word, userHashMap.get(word) + 1);
            }
            else {
                userHashMap.put(word, 1);
            }
        }

        int uniqueWords = userHashMap.size();
        System.out.println(userHashMap.size());
        System.out.println(userHashMap);
        return uniqueWords;
    }
}
