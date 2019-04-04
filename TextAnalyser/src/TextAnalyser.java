import java.util.Scanner;

/**
 * Analyzes the text and tells how many characters of each type were used.
 * Presented in a sorted way.
 * 
 * @author Fredrik Wassermeyer, frewas-7
 *
 */
public class TextAnalyser {

    public static void main(String[] args) {
        try (Scanner in = new Scanner (System.in)) {

            char[] textArray = null;
            
            System.out.println ("skriv in en lång text! Avsluta med enter.");

            String theText = in.nextLine ();
            textArray = theText.toCharArray ();
            int[] textArrayTrim = new int[128];
    
            //trim array from whitespaces
            for (int i = 0; i < textArray.length; i++) {
                int t = textArray[i]; //the int position for the character in text
                
                    textArrayTrim[t]++; //adds the corresponding int from character in text into right slot
                    
            }

//            for (int v : textArrayTrim) {
//                System.out.print (v + ", ");
//            }
//            for (char c : textArray) {
//                System.out.print (c + " ");
//            }

            for (int i = 0; i < 6; i++) {
            System.out.print('a' + i  + ": " + textArrayTrim[(97 + i)] + "\t");
            }
        }
    }

}
