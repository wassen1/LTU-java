import java.util.Scanner;

public class RovarSprak {
    public static void main(String[] args) {
        String phrase = "";
        
        
        phrase = input ();
        phrase = rovarSprak (phrase);
        
        System.out.println (phrase);
    }
   
        
    
    public static String eliminateBlanks(String phrase) {
        return phrase.replace (" ", "");
    }
    
    public static String rovarSprak(String phrase) {

        String newChar = "";
        String newString = "";
       
        //gå igenom phrase
        for (int i = 0; i < phrase.length (); i++) {

            newChar = phrase.substring (i, i + 1);
            
            //gå igenom vokallistan
            switch (newChar) {
                case "a":
                    newString = newString + newChar;
                    break;
                case "e":
                    newString = newString + newChar;
                    break;
                case "i":
                    newString = newString + newChar;
                    break;
                case "o":
                    newString = newString + newChar;
                    break;
                case "u":
                    newString = newString + newChar;
                    break;
                case "y":
                    newString = newString + newChar;
                    break;
                case "å":
                    newString = newString + newChar;
                    break;
                case "ä":
                    newString = newString + newChar;
                    break;
                case "ö":
                    newString = newString + newChar;
                    break;
                default:
                    if (newChar.contains (" ")) {
                        newString = newString + newChar;
                        break;
                    }
                    newString += newChar + "o" + newChar.toLowerCase ();
            } 
        }
        return newString;

    }
    public static String input() {
        Scanner in = new Scanner (System.in);
        System.out.println ("Mata in den sträng som du vill göra till Rövarspråk!");
        return in.nextLine ();
        
    }

}
