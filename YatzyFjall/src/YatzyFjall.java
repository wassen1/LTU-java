import java.util.Scanner;

public class YatzyFjall {

    public static void main(String[] args) {
        YatzyFjall inst = new YatzyFjall ();
        int[] dicesTotal = new int[6];
        String throwAgain = "y";
        int noOfSavedDices = 0;
        int noOfTurns = 0;
        int[] throwedDices = new int[5];
        //int[] throwedDices = {1, 1, 2, 1, 0, 0};
        int dicesToThrow;

        while (noOfTurns < 3) {
            dicesToThrow = 5 - noOfSavedDices;
            throwedDices = throwDices (dicesToThrow);
            dicesTotal = inst.combine (true, dicesTotal, throwedDices);
            
            inst.graphicalPrintDices(dicesTotal);
            
            System.out.println ();
            String saveStr = inst.inputUserStr ("Skriv in vilka tärningar som skall sparas!");
            
            int[] save = inst.dicesToSave (saveStr);
            noOfSavedDices = inst.howManyDicesIsSaved (save);

            //dicesTotal = inst.combine (true, dicesTotal, save);
            dicesTotal = save;
            
            System.out.println ("Du har dessa tärningar nu: ");
            inst.graphicalPrintDices(save);

            System.out.println ();
            throwAgain = inst.inputUserStr ("Vill du kasta igen? (y/n)");
            noOfTurns++;
            if (throwAgain.contains ("n")) {
                break;
            }
        }

    }
    
    public void graphicalPrintDices(int[] dices)
    {
        String[] dice1 = {"|     |", "|*    |", "|*    |", "|*   *|", "|*   *|", "|*   *|"};
        String[] dice2 = {"|  *  |", "|     |", "|  *  |", "|     |", "|  *  |", "|*   *|"};
        String[] dice3 = {"|     |", "|    *|", "|    *|", "|*   *|", "|*   *|", "|*   *|"};

        
        for(int i = 0; i < dices.length; i++)
            for(int j = 0; j < dices[i]; j++)
                System.out.print(dice1[i] + "\t");
        
        System.out.println();
        for(int i = 0; i < dices.length; i++)
            for(int j = 0; j < dices[i]; j++)
                System.out.print(dice2[i] + "\t");  
        System.out.println();
        for(int i = 0; i < dices.length; i++)
            for(int j = 0; j < dices[i]; j++)
                System.out.print(dice3[i] + "\t");  

    }

    public int howManyDicesIsSaved(int[] save) {
        int noOfSavedDices = 0;
        for (int i : save) {
            if (!(i == 0)) {
                noOfSavedDices += i;
            }
        }
        return noOfSavedDices;
    }

    public static int[] throwDices(int no) {
        int[] dices = new int[6];

        for (int i = 0; i < no; i++) {
            int number = (int) (Math.random () * 6) + 1;
            dices[(number - 1)]++;
        }
        return dices;
    }

    public int[] combine(boolean addition, int[] array, int[] arrayToAdd) {
        int length = array.length < arrayToAdd.length ? array.length : arrayToAdd.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = addition ? array[i] + arrayToAdd[i] : array[i] - arrayToAdd[i];
        }

        return result;
    }

    public int inputUserInt(String input) {
        int answer;

        System.out.println (input);
        Scanner s = new Scanner (System.in);
        answer = s.nextInt ();
        return answer;
    }

    public String inputUserStr(String input) {
        String answer;

        System.out.println (input);
        Scanner s = new Scanner (System.in);
        answer = s.next ();
        return answer;
    }

    public int[] dicesToSave(String input) {
        char[] answerChar;
        int[] answerInt = new int[6];
        int j = 0;

        answerChar = input.toCharArray ();

        for (int i = 0; i < answerChar.length; i++) {
            if (!(answerChar[i] == ':')) {
                int index = getIntValueFromChar (answerChar[i]) - 1;
                answerInt[index]++;
            }
        }
        

        return answerInt;
    }

    public int getIntValueFromChar(char charValue) {
        int intValue;
        intValue = Integer.parseInt (String.valueOf (charValue));
        return intValue;
    }

}
