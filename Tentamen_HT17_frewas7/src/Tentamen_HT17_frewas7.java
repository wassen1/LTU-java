import java.util.Scanner;

/**
 * Egyptisk roulette
 * 
 * @author Fredrik Wassermeyer, frewas-7
 *
 */
public class Tentamen_HT17_frewas7 {

    public static void main(String[] args) {
        int markersTotal = 0;
        String[] bettingStrArr;
        String[][] parsedStrArr;
        
        printMessage("***** Egyptisk Roulette *****");

        markersTotal = inputUserInt ("Ange startkapital i marker: ");

        while (true) {
            int betSum = 0;
            int scoreValue = 0;
            int random;
            
            random = getRandom ();
            //random = 25;
            
            printMessage("***** Egyptisk Roulette *****");
            
            bettingStrArr = inputStrBet ("Varsågod satsa: (A,B,C,D) (avsluta med Q,q)");

            if (continuePlay (bettingStrArr) == false) {
                break;
            }
            parsedStrArr = parseArray (bettingStrArr);

             if (checkFormat(parsedStrArr) == false) {
                 printMessage ("Du har inte angett rätt format på inmatningen! Exempel A:2:50 är tillåtet");
                 continue;
             }
            betSum = checkBetSum (markersTotal, parsedStrArr);

            if (checkMarkers (markersTotal, betSum) == false) {
                printMessage("Du har satsat " + betSum + " vilket är för mycket!");
                printMessage("Du har endast " + markersTotal + " markers tillgodo!");
                continue;
            }
            else {
                markersTotal = register (false, markersTotal, betSum);
            }
            
            scoreValue = checkBet(random, parsedStrArr);
            
            markersTotal = register (true, markersTotal, scoreValue);
            
            printMessage ("Rouletten stannade på: " + random);
            printMessage ("Utdelning: " + (scoreValue - betSum));
            printMessage ("Kapital att satsa: " + markersTotal);
            printMessage ("");
        }
        printMessage ("~Tack för en god match! Välkommen åter~");

    }
    
    private static void printMessage(String message) {
        System.out.println (message);
    }

    public static int inputUserInt(String output) {
        int answer;

        System.out.println (output);
        Scanner in = new Scanner (System.in);
        answer = in.nextInt ();
        return answer;
    }

    public static int getRandom() {
        int number;
        number = (int) (Math.random () * 36) + 1;
        return number;
    }

    public static String[] inputStrBet(String output) {

        String[] inputArray = new String[5];
        String input = "";
        Scanner in = new Scanner (System.in);
        int i = 0;

        System.out.print (output);

        while (true) {
            input = in.nextLine ();
            if (input.equalsIgnoreCase ("q")) {
                if (i == 0) {
                    inputArray[i] = input;
                }
                break;
            }
            inputArray[i] = input;
            i++;
        }

        return inputArray;
    }

    public static String[][] parseArray(String[] strArray) {

        String[][] parsedArray = new String[5][3];
        String delimiter = "[:]";
        for (int i = 0; strArray[i] != null; i++) {

            String[] tempArray = strArray[i].split (delimiter);

            for (int j = 0; j < tempArray.length; j++) {
                parsedArray[i][j] = tempArray[j];
            }
        }
        return parsedArray;
    }

    public static boolean continuePlay(String[] strArray) {
        
        if (strArray[0].equalsIgnoreCase("q")) {
            return false;
        }
        return true;
    }

    public static boolean checkFormat(String[][] parsedArray) {

        for (int i = 0; i < parsedArray.length; i++) {
            if (parsedArray[i][0].equalsIgnoreCase ("A") || parsedArray[i][0].equalsIgnoreCase ("B")
                    || parsedArray[i][0].equalsIgnoreCase ("C") || parsedArray[i][0].equalsIgnoreCase ("D")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static int checkBetSum(int markers, String[][] parsedArray) {
        int betSum = 0;

        for (int i = 0; i < parsedArray.length; i++) {
            if (parsedArray[i][0] == null) {
                break;
            }

            switch (parsedArray[i][0]) {
                case "A":
                    betSum += Integer.parseInt (parsedArray[i][2]);
                    break;

                case "B":
                    betSum += Integer.parseInt (parsedArray[i][2]);
                    break;

                case "C":
                    betSum += Integer.parseInt (parsedArray[i][1]);
                    break;

                case "D":
                    betSum += Integer.parseInt (parsedArray[i][2]);
                    break;

                default:
                    break;
            }
        }

        return betSum;
    }

    public static boolean checkMarkers(int markers, int betSum) {
        boolean status = false;

        if (markers - betSum > 0) {
            status = true;
        }
        return status;
    }

    public static int register(boolean addition, int total, int value) {
        total = addition ? total + value : total - value;
        return total;
    }

    public static int checkDozen(int random, String[] parsedArray) {
        int scoreValue = 0;
        int dozenTable;
        int betValue;

        dozenTable = Integer.parseInt (parsedArray[1]);
        betValue = Integer.parseInt (parsedArray[2]);

        switch (dozenTable) {
            case 1:
                if (1 <= random && random <= 12) {
                    scoreValue = 3 * betValue;
                }
                break;
            case 2:
                if (13 <= random && random <= 24) {
                    scoreValue = 3 * betValue;
                }
                break;
            case 3:
                if (25 <= random && random <= 36) {
                    scoreValue = 3 * betValue;
                }
                break;

            default:
                break;
        }

        return scoreValue;
    }

    public static int checkOddEven(int random, String[] parsedArray) {
        int scoreValue = 0;
        String oddEven;
        int betValue;

        oddEven = parsedArray[1];
        betValue = Integer.parseInt (parsedArray[2]);

        if (oddEven.equalsIgnoreCase ("Odd")) {

            if (random % 2 != 0) {
                scoreValue = 2 * betValue;
            }
        }

        if (oddEven.equalsIgnoreCase ("Even")) {
            if (random % 2 == 0) {
                scoreValue = 2 * betValue;
            }
        }

        return scoreValue;
    }

    public static int checkSeven(int random, String[] parsedArray) {
        int scoreValue = 0;
        int betValue;

        betValue = Integer.parseInt (parsedArray[1]);

        if (random % 7 == 0) {
            scoreValue = 8 * betValue;
        }

        return scoreValue;
    }

    public static int checkCorner(int random, String[] parsedArray) {
        int scoreValue = 0;
        int corner;
        int betValue;
        int[] betCorner = new int[4];

        corner = Integer.parseInt (parsedArray[1]);
        betValue = Integer.parseInt (parsedArray[2]);

        betCorner[0] = corner;
        betCorner[1] = corner + 1;
        betCorner[2] = corner + 3;
        betCorner[3] = corner + 4;

        for (int i : betCorner) {
            if (random == i) {
                scoreValue = 9 * betValue;
            }
        }

        return scoreValue;
    }

    public static int checkBetRow(int random, String[] parsedArray) {
        int scoreValue = 0;

        String betRule;
        betRule = parsedArray[0];
        
        if (betRule == null) {
            return scoreValue;
        }

        switch (betRule) {
            case "A":
                scoreValue = checkDozen (random, parsedArray);
                break;

            case "B":
                scoreValue = checkOddEven (random, parsedArray);
                break;

            case "C":
                scoreValue = checkSeven (random, parsedArray);
                break;

            case "D":
                scoreValue = checkCorner (random, parsedArray);
                break;

            default:
                break;
        }

        return scoreValue;
    }

    public static int checkBet(int random, String[][] parsedArray) {
        int scoreValue = 0;
        for (int i = 0; i < parsedArray.length; i++) {
            if (parsedArray[i][0] == null) {
                break;
            }
            
            scoreValue += checkBetRow (random, parsedArray[i]);
        }
        
        return scoreValue;
        
    }
    // public static void playGame() {
    //
    // }

}
