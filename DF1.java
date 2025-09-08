import java.util.Scanner;

/**
 * A program to exemplified the concepts of exception handling for the CS1103, Discussion Forum 1.
 *
 * The program will ask from an integer between 1 and 5 from the user,
 * test if it is within the range and throw exceptions in case it is not,
 * and will print the exception and error message
 */
public class DF1 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int userInput;

        try {
            System.out.println("Please type an integer, from 1 to 5: ");
            userInput = stdin.nextInt();
            System.out.println(userInput);

            if (userInput < 1) {
                throw new IllegalArgumentException("number too low");
            }

            if (userInput > 5) {
                throw new IllegalArgumentException("number too high");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0); // This line shutdown the JVM but since the 'finally' block must run, the compiler ignores this line.
        } finally {
            stdin.close();
            System.out.println("End of the program");
        }
    }
}
