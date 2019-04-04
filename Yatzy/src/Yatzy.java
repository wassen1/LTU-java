import java.util.Scanner;

/**
 * 
 * @author wassen
 *
 */
public class Yatzy {

    public static void main(String[] args) {
        int[] diceArray = new int[7];
        int no;
        int i = 0;
        int sum = 0;
        int save = 0;
        int numberOfsavedDice = 0;
        final int NO_OF_DICES = 5;

        for(int k = 0; k < 3; k++) {

            throwDice (diceArray, NO_OF_DICES - numberOfsavedDice);
            System.out.println ("Du har slagit följande tärningar:");
            printDice (diceArray);

            System.out.println ();
            System.out.println ("Vika tärningar vill du spara?");
            save = inputPlayer ();
            numberOfsavedDice = clearDices (diceArray, save);

            System.out.println ("Du har sparat: " + numberOfsavedDice + " stycken " + save +":or");
            

            sum = sumDices (diceArray, save);
            System.out.println ();
            System.out.println ("Dina totala poäng är nu: " + sum);

            i++;
        }

    }

    public static int inputPlayer() {
        int no;
        Scanner in = new Scanner (System.in);
        no = in.nextInt ();
        return no;
    }
    
    public static void throwDice(int[] diceArray, int no) {
        for (int i = 0; i < no; i++) {
            int number = (int) (Math.random () * 6) + 1;
            diceArray[number]++;
        }

       //return diceArray;
    }

    public static void printDice(int[] diceArray) {

        for (int i : diceArray) {
            System.out.print (i + " ");
        }
        
        
     
        
    }

    public static int clearDices(int[] diceArray, int saveDice) {
        int numberOfSaved = diceArray[saveDice];
        
        for (int i = 0; i < diceArray.length; i++) {
            if (!(i == saveDice)) {
                diceArray[i] = 0;
            }
        }
        return numberOfSaved;
    }

    public static int sumDices(int[] diceArray, int save) {
        int result = diceArray[save] * save;
        return result;
    }
}