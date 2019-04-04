

import java.util.Scanner;

/**
 * Booking system, small airplain
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */
public class Booking {

    public static void main(String[] args) {
        // Ensures the scanner will be closed correctly at the end
        try (Scanner in = new Scanner (System.in)) {

            char[][] seats = new char[7][5]; // 6 rader och 5 kolumner
            char[] bookSeat;
            final char LETTER = 'A'; // första kolumn heter 'A'
            final int SPACE = 2; // där mittgången skall ligga (två säten sedan
                                 // mittgång)
            final char BOOKED = '#';

            setSeatLetters (seats, LETTER);

            printSeats (seats, SPACE);

            System.out.println ("skriv in önskad bokning max 4 tecken!");
            
            while (true) {

                bookSeat = input (in);

                if (bookSeat == null) {
                    break;
                }

                bookSeats ( seats, bookSeat, BOOKED);

                printSeats (seats, SPACE);
                System.out.println ("skriv in önskad bokning max 4 tecken! Avsluta med 'q'");
              
               
            }
            

        }
        catch (Exception e) {
            e.printStackTrace ();
        }

    }

    public static void setSeatLetters(char[][] seats, char start) {

        for (int row = 0; row < seats.length; row++) {

            for (int col = 0; col < seats[row].length; col++) {
                seats[row][col] = (char) (start + col);
            }
        }
    }

    public static void printSeats(char[][] seats, int SPACE) {
        for (int row = 0; row < seats.length; row++) {

            System.out.print (row + 1 + " ");

            for (int col = 0; col < seats[row].length; col++) {

                if (col == SPACE) {
                    System.out.print (" ");

                }
                System.out.print (seats[row][col] + " ");

            }
            System.out.println ();

        }

    }

    /**
     * Takes care of input and turns it into an array
     * 
     * @param input
     * @return
     */
    public static char[] input(Scanner input) {
        String bookRequestStr = null;
        char[] bookRequestAr = null;

        // while (bookRequestAr[0] == '0' && bookRequestAr[1] == '0' &&
        // bookRequestAr[2] == '0' && bookRequestAr[3] == '0' ) {

        while (bookRequestAr == null) {
            bookRequestStr = input.nextLine ();

            if (bookRequestStr.contains ("q")) {
                break;
            }

            if (bookRequestStr.length () > 4) {

                System.out.println ("Du har angett " + bookRequestStr.length () + "tecken. Ange endast 4!");
                
            }
//            if (bookRequestStr.substring(0,1).contains ("5,6")) {
//                System.out.println ("JAAA!!");
//                
//            }

            else {

               // bookRequestAr = new char[4];

               // for (int i = 0; i < bookRequestStr.length (); i++) {

//                    bookRequestAr[i] = bookRequestStr.charAt (i); // translates
                                                                  // the string
                                                                  // into an
                                                                  // array
                    

               // }
                bookRequestAr = bookRequestStr.toCharArray ();
                
                
            }
        }

        return bookRequestAr;

    }
/**
 * Books the seats
 * @param seats the array with all seats
 * @param rowCol the selected seats
 * @param sign the sign for booked seat
 */
    public static void bookSeats(char[][] seats, char[] rowCol, char sign ) {

        int selRow = rowCol[0] - 49;
        int selSeatIn = rowCol[1] - 'A';
        int selSeatOut = selSeatIn;
        
        
        if (rowCol.length == 4) {
 
            selSeatOut = rowCol[3] - 'A';
        }
        

        for (int col = selSeatIn; col <= selSeatOut; col++)
            if (seats[selRow][col] == sign) {
                System.out.println ("Du har anget redan bokad plats. Vänligen gör en ny bokning!");
                break;
            }
            else {
                seats[selRow][col] = sign;
            }

    }

}
