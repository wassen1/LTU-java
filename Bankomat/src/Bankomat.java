
import java.util.Scanner;
/**
 * Bankomat
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */

public class Bankomat {
    private static Scanner in = new Scanner (System.in);

    public static void main(String[] args) {

        int[] transactions = new int[10];
        int balance = 0;
        int testBalance = 0;
        int menuInput = 0;
        int input = 0;

        while (true) {
            menuInput = menu ();
            input = 0;

            switch (menuInput) {
                case 1:
                    System.out.println ();
                    System.out.println ("~Insättning~");
                    System.out.println ();
                    System.out.println ("Skriv in önskat belopp");
                    input = input ();

                    makeTransaction (transactions, input);
                    balance = balance + input;
                    showTransactions (transactions, balance);
                    break;

                case 2:

                    System.out.println ();
                    System.out.println ("~Uttag~");
                    System.out.println ();
                    System.out.println ("Skriv in önskat belopp");

                    // test if the balance will drop below 0
                    while (true) {

                        input = (input ()) * (-1);
                        testBalance = balance + input;

                        if (testBalance >= 0) {
                            break;
                        }

                        System.out.println ();
                        System.out.println ("Du har inte täckning för detta uttag: " + "\"" + input + "\""
                                + " Du kan max ta ut " + balance);
                    }
                    balance = testBalance;
                    makeTransaction (transactions, input);
                    showTransactions (transactions, balance);
                    break;

                case 3:
                    System.out.println ();
                    System.out.println ("~Saldobesked~");
                    showTransactions (transactions, balance);
                    break;

                case 4:
                    System.out.println ();
                    System.out.println ("~Avsluta~");
                    System.out.println ();
                    System.out.println ("Välkommen åter!");
                    break;

                default:
                    break;
            }
            if (menuInput == 4) {
                break;
            }
        }
    };

    /**
     * Shows the menu options
     * 
     * @return the input
     */
    public static int menu() {

        int input = 0;
        
        System.out.println ("Välj något av följande alternativ:");
        System.out.println ("1. Insättning" + "\n2. Uttag" + "\n3. Saldobesked" + "\n4. Avsluta");

        while (true) {
            input = input ();
            
            //checks if the input value is legal
            if (input > 4 || input < 1) {

                System.out
                        .println ("Du har angett felaktigt tal: " + "\"" + input + "\"" + " Anget endast mellan 1-4.");
            }
            else
                break;
        }
        return input;
    };

    /**
     * Handles user input
     * 
     * @return the input
     */
    public static int input() {

        Integer input = null;

        while (input == null) {

            if (in.hasNextInt ()) {
                input = in.nextInt ();

                if (input < 0) {
                    System.out.println (
                            "Du har angett felaktigt tal: " + "\"" + input + "\"" + " Skriv endast positiva tal!");
                    input = null;
                }
            }
            else {
                String str = in.next ();

                System.out.println ("Du har angett felaktigt tal: " + "\"" + str + "\"" + " Skriv endast heltal!");
            }
        }
        return input;
    };

    /**
     * Moves the values in the array to make space for new value
     * 
     * @param trans
     *            the array with transaction values
     */
    private static void moveTrans(int[] trans) {
        
        int length = trans.length;
        
        //moves the values in the array to make new space
        for (int i = 0; i < length - 1; i++) {
            trans[i] = trans[i + 1];
        }
        trans[length - 1] = 0;
        for (int i : trans) {
            System.out.println (i);
        }
    };

    /**
     * Finds the first empty slot
     * 
     * @param trans
     *            the array with transaction values
     * @return the empty position in the array
     */
    private static int findNr(int[] trans) {
        int i;
        
        for (i = 0; i < trans.length; i++)
            if (trans[i] == 0) {
                return i;
            }
        return -1;
    };

    /**
     * Shows the latest transactions (Maximum 10 transaktions)
     * 
     * @param trans
     *            the latest transactions
     * @param balance
     *            the balance of the account
     */
    public static void showTransactions(int[] trans, int balance) {
       // int item;

        System.out.println ();
        System.out.println ("Ditt saldo: " + balance + " kr");
        System.out.println ();
        System.out.println ("Dina senaste transaktioner: ");

        if (trans[0] == 0) {
            System.out.println ("Du har inga transaktioner att visa");
        }

        for (int item : trans) { //Här har jag försökt att flytta variabeldeklarationen högst upp i funktionen som du tycker. 
            //Men får då felmeddelande: "i cannot be resolved to a type"
            if (item == 0) {
                break;
            }
            System.out.println (item + " kr");
        }
        System.out.println ();
    };

    /**
     * Makes the transaction
     * 
     * @param trans
     *            the array of last transactions
     * @param amount
     *            the amount to be transacted
     */
    public static void makeTransaction(int[] trans, int amount) {

        // If the array is full
        if (findNr (trans) == -1) {
            moveTrans (trans);
        }

        // Places the amount into transaction array
        trans[findNr (trans)] = amount;
    };
}
