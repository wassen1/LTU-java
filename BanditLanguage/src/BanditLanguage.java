import java.util.Scanner;

public class BanditLanguage {
    public static void main(String[] args) {

        String phrase = "";
        String convertPhrase = "";

        phrase = input ();
        convertPhrase = convert (phrase);

        System.out.println ("På rövarspårk blir: " + phrase + ": " + convertPhrase);

    }

    public static String convert(String theString) {
        final String CONSONANTS = "bcdfghjklmnpqrstvxzBCDFGHJKLMNPQRSTVXZ";
        String oneChar = "";
        String convertString = "";

        for (int i = 0; i < theString.length (); i++) {
            oneChar = theString.substring (i, i + 1);
            if (CONSONANTS.indexOf(oneChar) != -1) {
                convertString += oneChar + "o" + oneChar.toLowerCase ();

            }
            else {
                convertString += oneChar;
            }
        }
        return convertString;
    }

    public static String input() {
        Scanner keyboard = new Scanner (System.in);
        System.out.print ("Mata in fras!");
        return keyboard.nextLine ();

    }
}
