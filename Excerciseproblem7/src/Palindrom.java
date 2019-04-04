import java.awt.datatransfer.FlavorListener;
import java.util.Scanner;


public class Palindrom {
    public static void main(String[] args) {
        // declaration
        String phrase = "";
        String reversePhrase = "";

        phrase = input ();
        phrase = eliminateBlanks (phrase);
        phrase = lowerCase (phrase);
        reversePhrase = reverseString (phrase);

        if (isPalindrom (phrase, reversePhrase) == true) {
            System.out.println ("Det är palindrom!");
        }
        else {
            System.out.println ("Det inmatade är inte en palindrom!");
        }
    }

    /**
     * Changes the phrase to lower case String
     * @param phrase the input phrase
     * @return the phrase in lower case String
     */
    public static String lowerCase(String phrase) {
        return phrase.toLowerCase ();
        
    }
    
    /**
     * Eliminates blank spaces
     * @param phrase the input phrase
     * @return the phrase without blank spaces
     */
    public static String eliminateBlanks(String phrase) {
        return phrase.replace (" ", "");
        
    }
    /**
     * Checks if the phrase is equal to the reversePhrase
     * @param phrase the input phrase
     * @param reversePhrase the reversed input phrase
     * @return true or false
     */
    public static boolean isPalindrom(String phrase, String reversePhrase) {
        return phrase.equals (reversePhrase);
    }

    /**
     * Reverses the phrase
     * @param phrase the input phrase
     * @return the reversePhrase
     */
    public static String reverseString(String phrase) {
        String reverseString = "";
        
        for (int i = 0; i < phrase.length (); i++) {
            reverseString = phrase.substring (i, i + 1) + reverseString;
        }
        return reverseString;
    }

    /**
     * Takes the input from the keyboard
     * @return the input
     */
    public static String input() {

        Scanner keyboard = new Scanner (System.in);
        System.out.println ("Mata in den sträng som du vill göra till palindrom!");
        
        return keyboard.nextLine ();
    }

}
