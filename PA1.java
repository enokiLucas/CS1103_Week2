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

/**
 *
 */
public class PA1 {

    public static void main(String[] args) {

        String userString = getLine();

        // Character Count
        int userStringLength = userString.length();
        System.out.println("Character Count: " + userStringLength);

        // Word count
        String[] userArray = userString.split(" ");
        int wordCount = userArray.length;
        System.out.println("Word Count: " + wordCount);

        // Most Common Character
        // Character Frequency
        // Word Frequency
        // Unique Words
    }

    public static String getLine() {
        Scanner stdin = new Scanner(System.in);
        String userInput;

        System.out.println("Please input a paragraph or a lengthy text");
        userInput = stdin.nextLine();

        stdin.close();
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
}
