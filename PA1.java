import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

/**
 * <p>
 * Text analysis tool that performs the following operations on a user
 * input text:
 * <ul>
 * <li>Character count, including spaces.
 * <li>Word count.
 * <li>Most common character.
 * <li>Frequency of a user typed character.
 * <li>Frequency of a user typed word.
 * <li>Number of unique words.
 * </ul>
 * </p>
 *
 * @author Lucas Enoki Pereira da Silva.
 */
public class PA1 {
    public static void main(String[] args) {
        // Initializes the scanner and reads the user input.
        Scanner stdin = new Scanner(System.in);
        String userString = getLine(stdin);

        // Generates a Hash Map of frequencies from the text.
        HashMap<Character, Integer> userHashMap = makeHashMap(userString);

        // Uppercase the text and create a new Hash Map with it.
        String userStringUpper = userString.toUpperCase();
        HashMap<Character, Integer> userHashMapUpper = makeHashMap(userStringUpper);

        // Calls for the methods that run the analyzes.
        characterCount(userString);
        wordCount(userString);
        mostCommonCharacter(userHashMap);
        characterFrequency(userHashMapUpper, stdin);
        wordFrequency(userStringUpper, stdin);
        numberOfUniqueWords(userStringUpper);

        // Closes the Scanner.
        stdin.close();
    }

    /**
     * Ask the user for an input and reads it, check if the input is empty and return it.
     *
     * @param stdin the Scanner to read input.
     * @return the text the user typed.
     * @throws InputMismatchException if the user types an empty line.
     */
    public static String getLine(Scanner stdin) {
        String userInput;
        System.out.println("Please input a paragraph or a lengthy text: ");
        userInput = stdin.nextLine();

        if (userInput.length() == 0) {
            throw new InputMismatchException("Please type a text!");
        }

        return userInput;
    }

    /**
     * Creates a frequency Hash Map of the characters in a string, not counting the spaces.
     * The keys are the characters and the values are the number of times
     * each character appears on the string.
     *
     * @param userString the string to analyze.
     * @return the Hash Map generated.
     */
    public static HashMap<Character, Integer> makeHashMap(String userString) {
        HashMap<Character, Integer> userHashMap = new HashMap<Character, Integer>();

        String userStringWithoutSpaces = userString.replaceAll("\\s+", "");
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

    /**
     * Counts the total number of characters in a string,
     * including spaces.
     *
     * @param userString the string to analyze.
     * @return the character count
     */
    public static int characterCount(String userString) {
        int userStringLength = userString.length();
        System.out.println("Character Count: " + userStringLength);
        return userStringLength;
    }

    /**
     * Counts the total number of words in a string.
     *
     * @param userString the string to analyze.
     * @return the number of words.
     */
    public static int wordCount(String userString) {
        String[] userArray = userString.split("\\s+");
        int wordCount = userArray.length;
        System.out.println("Word Count: " + wordCount);
        return wordCount;
    }

    /**
     * Determines the most common character in a frequency hash map,
     * iterates over the frequency hash map values until it finds the
     * first values that matches the previously determined.
     * Throw an error in case no match is found.
     *
     * @param userHashMap the hash map of frequencies to analyze.
     * @return the key from the hash map that has a value equal to the highest value.
     * @throws Error if no match is found.
     */
    public static char mostCommonCharacter(HashMap<Character, Integer> userHashMap) {
        int mostCommonValue = Collections.max(userHashMap.values());
        for (Map.Entry<Character, Integer> entry: userHashMap.entrySet()) {
            if (entry.getValue() == mostCommonValue) {
                System.out.println("The most common character is: " + entry.getKey());
                return entry.getKey();
            }
        }
        throw new Error("No Character found!");
    }

    /**
     * Ask the user for a single character and returns the value from
     * the frequency HashMap that has a matching key.
     *
     * @param userHashMap the hash map of frequencies to analyze.
     * @param stdin the Scanner to read input.
     * @return the most common character.
     * @throws InputMismatchException if the user type anything other than a single Character.
     * @throws Error if there is no match between the user input and the keys in the Hash Map.
     */
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
                System.out.println("The frequency of the character of typed is: " + entry.getValue());
                return entry.getValue();
            }
        }
        throw new Error("No Value found!");
    }

    /**
     * Ask the user for a word, tests the user input
     * returns the frequency the word appears on the string it takes as
     * a parameter.
     *
     * @param userString the String to analyze.
     * @param stdin the Scanner to read input.
     * @return the frequency of the typed word.
     * @throws InputMismatchException if the user does not type anything.
     */
    public static int wordFrequency(String userString, Scanner stdin){
        System.out.println("Please type a word to check its frequency: ");
        String userWord = stdin.nextLine();

        if (userWord.length() == 0) {
            throw new InputMismatchException("Please type a word!");
        }

        String[] userArray = userString.split("\\W+");
        int frequency = 0;

        for (String word : userArray) {
            if (word.equalsIgnoreCase(userWord)) {
                frequency = frequency + 1;
            }
        }

        System.out.println("The frequency of the word you typed is: " + frequency);
        return frequency;
    }

    /**
     * Counts the number of unique words, ignoring
     * cases, spaces and punctuation.
     *
     * @param userStringUpper the uppercased text to analyze.
     * @return the number of unique words.
     */
    public static int numberOfUniqueWords(String userStringUpper) {
        HashMap<String, Integer> userHashMap = new HashMap<String, Integer>();
        String[] userArray = userStringUpper.split("\\W+");

        for (String word : userArray) {
            if (userHashMap.containsKey(word)) {
                userHashMap.put(word, userHashMap.get(word) + 1);
            }
            else {
                userHashMap.put(word, 1);
            }
        }

        System.out.println("The number of unique words in the text is: " + userHashMap.size());
        return userHashMap.size();
    }
}
