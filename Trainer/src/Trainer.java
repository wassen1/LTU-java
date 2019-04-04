import java.util.Scanner;

/**
 * Tränar upp multiplikationstabellerna 1-12
 * 
 * @author susanne
 *
 */
public class Trainer {
    /**
     * Startar multiplikationsträningen
     * 
     * @param args
     *            - används inte
     */
    public static void main(String[] args) {
        int theTable;
        int[] noOfCorrectAnswers = new int[13];
        int[] noOfWrongAnswers = new int[13];

        while (true) {
            // Fråga efter tabell
            theTable = askForNumberInput ("Välj vilken tabell du vill träna på (0 för att avsluta): ");
            if (theTable == 0) // Avbryt
            {
                break;
            }
            // Ligger tabellen inom intervallet 1-12
            else if (theTable >= 1 && theTable <= 12) {
                // Utför träningen på tabellen, avbröt användaren träningen i
                // förtid skrivs ingen statistik ut
                if (multiplication (theTable, noOfCorrectAnswers, noOfWrongAnswers))
                    printStatistics (theTable, noOfWrongAnswers);
            }
            else {
                System.out.println ("Du får bara välja en tabell mellan 1-12, försök igen");
            }
        }
    }

    /**
     * Skriver ut hur många fel man har svarat på respektive tal
     * 
     * @param table
     *            - tabellen man tränat på
     * @param noOfWrongAnswers
     *            - heltalsvektor som innehåller statistiken över hur många
     *            gånger man svarat fel första positioner noOfWrongAnswers[0]
     *            används inte
     */
    public static void printStatistics(int table, int[] noOfWrongAnswers) {
        System.out.println ("Statistik över hur många fel du svarade för varje tal:");
        for (int i = 1; i < noOfWrongAnswers.length; i++) {
            // Skriver inte ut statisktik för tal som inte har något felaktigt
            // svar
            if (noOfWrongAnswers[i] > 0)
                System.out.println (table + "x" + i + ": " + noOfWrongAnswers[i] + " fel");
        }
    }

    /**
     * Skriver ut en fråga och vänta rpå användarens val som ska vara ett tal
     * 
     * @param output
     *            - Frågan som ska ställas till användaren
     * @return ett heltal som matats in av användaren
     */
    public static int askForNumberInput(String output) {
        Scanner in = new Scanner (System.in);
        System.out.print (output);

        String input = in.nextLine ();
        int table = -1;

        // Säkerställ att inmatningen innehåller endast siffror
        // Detta är en lite mer avancerad lösning som inte krävs för uppgiften
        if (input.matches ("[0-9]+")) {
            table = Integer.parseInt (input);
        }
        return table;
    }

    /**
     * Sköter själva multiplikationsträningen
     * 
     * @param table
     *            - tabellen som ska tränas på
     * @param noOfCorrectAnswers
     *            - lagrar antal korrekta svar, noOfCorrectAnswers[0] används ej
     * @param noOfWrongAnswers
     *            - lagrar antal felaktiga svar, noOfWrongAnswers[0] används ej
     * @return
     */
    public static boolean multiplication(int table, int[] noOfCorrectAnswers, int[] noOfWrongAnswers) {
        // Håller reda på hur många gånger användaren har kvar att gissa
        // Varje tal 1-12 ska användaren svara rätt på minst tre gånger
        int noLeft = (noOfCorrectAnswers.length - 1) * 3; // Hårdkodning av
                                                          // antal korrekta svar
                                                          // är inte bra men ok
                                                          // i uppgiften!
        int no = 0;

        while (noLeft > 0) {
            // Hämtar nästa tal som ska multipliceras
            no = getNextRndNumber (noOfCorrectAnswers);

            // Hämtar användarens svar
            int answer = askForNumberInput (table + "x" + no + " = ");

            if (answer == 0) // Avsluta
            {
                return false;
            }
            if (answer == (table * no)) // Rätt svar
            {
                System.out.println (":)\n");
                noOfCorrectAnswers[no]++;
            }
            else // Fel svar
            {
                System.out.println (":(\n");
                noOfWrongAnswers[no]++;
            }
            noLeft--;
        }
        return true;
    }

    /**
     * Hämtar ett tal mellan 1-12 och som inte har tre korrekta svar redan
     * 
     * @param noOfCorrectAnswers
     *            - vektorn med alla korrekta svar noOfCorrectAnswers[0] används
     *            inte
     * @return talet som slumpats fram
     */
    public static int getNextRndNumber(int[] noOfCorrectAnswers) {
        int no = 0;
        do {
            int tempNo = (int) (Math.random () * 12 + 1);

            // Om talet inte besvarats rätt tre gånger
            if (noOfCorrectAnswers[tempNo] < 3)
                no = tempNo;

        } while (no == 0);

        return no;
    }
}
