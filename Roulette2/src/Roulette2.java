

import java.util.Scanner;

/**
 * Roulette play
 * 
 * @author Fredrik Wassermeyer, frewas-7
 *
 */
public class Roulette2 {
    private static Scanner in = new Scanner (System.in);
    static int markers = 0;

    public static void main(String[] args) {

        String[][] betRow = null;

        String startMarkersStr;
        int[] winLooseRandom;

        System.out.println ("***** Turkisk Roulette *****");
        System.out.println ("Ange startkapital i marker: ");

        startMarkersStr = input ();
        markers = Integer.parseInt (startMarkersStr);

        System.out.println ("startmarker är: " + markers);

        while (true) {
            betRow = getBetFromUser ();

            winLooseRandom = checkProfit (betRow);
            System.out.println ();
            System.out.println ("Kulan stannade på: " + winLooseRandom[2]);
            System.out.println ("Du har totalt förlorat " + winLooseRandom[1] + " markers");
            System.out.println ("Du har totalt vunnit " + winLooseRandom[0] + " markers");
            System.out.println ("Netto blir det: " + (winLooseRandom[0] - winLooseRandom[1]));

            System.out.println ("Totala antal markers är: " + markers);
            System.out.println ();
            System.out.println ("Spela igen? (Y/N)");

            if (input ().contains ("N")) {
                System.out.println ("Tack och välkommen åter!");
                break;
            }

        }

    };

    public static int randomScore() {
        int number = (int) (Math.random () * 36) + 1;
        return number;
    };
    
    public static boolean testMarkers(String[][] totalBet) {
        int testMarkers = markers;
        String[] costStrings = new String [5];
        
        
        for (int i = 0; i < totalBet.length; i++) { // iterate thru each bet row
            for (int k = 0; k < totalBet[i].length - 1; k++) { // iterate thru each bet
                if (totalBet[i][k + 1] == null){
                    costStrings[i] = totalBet[i][k];
                    break;
                } 
            }  
        }
        
        for (int i = 0; i < costStrings.length; i++) {
            if (costStrings[i] != null) {
                testMarkers -= Integer.parseInt (costStrings[i]);
            }
            
        }
        
        if (testMarkers < 0) {
            return false;
        }
        
        return true;
    }

    public static String[][] getBetFromUser() {
        String inputString = null;
        String[] inputStringArr = null;
        String[][] totalBet = new String[5][4];
        int i = 0;
        

        System.out.println ("Varsågod satsa: (A,B,E,F) (avsluta med Q,q)");
        while (true) {

            inputString = input (); // string from user

            inputStringArr = inputString.split (":"); // convert to array
                                                      // without
                                                      // ":"
            if (inputStringArr[0].contains ("A") || inputStringArr[0].contains ("B") || inputStringArr[0].contains ("E")
                    || inputStringArr[0].contains ("F")) {

                for (int j = 0; j < inputStringArr.length; j++) {
                    totalBet[i][j] = inputStringArr[j];
                }

                i++;
                if (i > 3) {
                    break;
                }
            }
            else if (inputStringArr[0].contains ("Q") || inputStringArr[0].contains ("q")) {

                break;
            }
            else {
                System.out.println ("Du har inte anget rätt satsning! Endast A, B, E, F är tillåtna. Fyll i igen!");
                totalBet = null;
            }
        }

        if (!testMarkers (totalBet)) {
            System.out.println ("Du kan inte satsa så mycket. Ditt saldo: " + markers);
            totalBet = null;
            getBetFromUser();
        }
        return totalBet;
    };

    public static int[] checkProfit(String[][] betRow) {

        int randomNumber = randomScore ();
        //int randomNumber = 15;
        int winningMarkers = 0;
        int loose = 0;
        int i = 0;
        int[] winLooseRandom = new int[3];

        while (i < 4) {
            if (betRow[i][0] == null) {
                break;
            }
            switch (betRow[i][0]) {
                case "A":
                    
                    if (randomNumber == Integer.parseInt (betRow[i][1])) {
                        System.out.println ("du har vunnit på enkelnummer");
                        winningMarkers += Integer.parseInt (betRow[i][2]) * 35;
                        markers += Integer.parseInt (betRow[i][2]) * 35;

                    }
                    else {
                        System.out.println ("du har förlorat på enkelnummer");
                        loose += Integer.parseInt (betRow[i][2]);
                        markers -= Integer.parseInt (betRow[i][2]);
                    }
                    i++;
                    break;

                case "B":
                    
                    if (checkColumn (betRow, randomNumber, i)) {
                        System.out.println ("du har vunnit på kolumn");
                        winningMarkers += Integer.parseInt (betRow[i][2]) * 2;
                        markers += Integer.parseInt (betRow[i][2]) * 2;
                    }
                    else {
                        System.out.println ("du har förlorat på kolumn");
                        loose += Integer.parseInt (betRow[i][2]);
                        markers -= Integer.parseInt (betRow[i][2]);
                    }
                    i++;
                    break;

                case "E":
                    
                    if (checkRedBlack (betRow, randomNumber, i)) {
                        System.out.println ("Du har vunnit på Röd/Svart");
                        winningMarkers += Integer.parseInt (betRow[i][2]);
                        markers += Integer.parseInt (betRow[i][2]);
                    }
                    else {
                        System.out.println ("Du har förlorat på Röd/Svart");
                        markers -= Integer.parseInt (betRow[i][2]);
                        loose += Integer.parseInt (betRow[i][2]);
                    }
                    i++;
                    break;

                case "F":
                    
                    if (checkFibonacci (randomNumber)) {
                        System.out.println ("Du har vunnit på Fibonacci!");
                        markers += Integer.parseInt (betRow[i][1]) * 5;
                        winningMarkers += Integer.parseInt (betRow[i][1]) * 5;
                    }
                    else {
                        System.out.println ("Du har förlorat på Fibonacci!");
                        markers -= Integer.parseInt (betRow[i][1]);
                        loose += Integer.parseInt (betRow[i][1]);
                    }
                    i++;
                    break;

                default:
                    System.out.println ("Du har inte anget giltigt val (A, B, E eller F)");
                    betRow = getBetFromUser ();
                    checkProfit (betRow);
                    break;
            }
            winLooseRandom[0] = winningMarkers;
            winLooseRandom[1] = loose;
            winLooseRandom[2] = randomNumber;
        }
        return winLooseRandom;
    }

    public static boolean checkFibonacci(int randomNumber) {

        int[] fib = { 1, 2, 3, 5, 8, 13, 21, 34 };
        for (int f : fib) {
            if (f == randomNumber) {

                return true;
            }
        }
        return false;
    };

    public static String input() {
        // in.useDelimiter ("[:\\s]+");
        String input = null;

        input = in.nextLine ();

        return input;
    };

    public static boolean checkColumn(String[][] betRow, int randomNumber, int i) {
        int[] column1 = { 1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34 };
        int[] column2 = { 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 322, 35 };
        int[] column3 = { 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36 };

        switch (betRow[i][1]) {
            case "1":
                for (int columnValue1 : column1) {
                    if (columnValue1 == randomNumber) {

                        return true;
                    }
                }

                return false;

            case "2":
                for (int columnValue2 : column2) {
                    if (columnValue2 == randomNumber) {

                        return true;
                    }
                }
                return false;

            case "3":
                for (int columnValue3 : column3) {
                    if (columnValue3 == randomNumber) {
                        return true;
                    }
                }
                return false;

            default:
                System.out.println ("Du har satsat på ogiltig kolumn");
                return false;
        }

    };

    public static boolean checkRedBlack(String[][] betRow, int randomNumber, int i) {
        int[] redArray = { 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 };
        int[] blackArray = { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 };

        if (betRow[i][1].contains ("Red")) {

            for (int red : redArray) {
                if (red == randomNumber) {

                   
                    return true;
                }
            }
        }
        else if (betRow[i][1].contains ("Black")) {

            for (int black : blackArray) {
                if (black == randomNumber) {

                   
                    return true;
                }
            }
        }
        else {
            System.out.println ("Du har anget fel! Endast Black eller Red");
         

        }
        return false;
    };

    public static int inputMarker() {

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
}
