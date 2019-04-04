import java.util.Scanner;

public class Trainer060318 {

    public static void main(String[] args) {
        Trainer060318 inst = new Trainer060318 ();

        int tabel;
        int tabelLenth;

        tabelLenth = inst.inputUserInt ("Hur långa tabeller vill du öva på?");
        
        while (true) {
            
            int[] correctAnswers = new int[tabelLenth];
            int[] noOfAnswers = new int[tabelLenth];

                tabel = inst.inputUserInt ("Vilken tabell vill du öva på?");
             
            while (true) {
                int random;
                int randomToUse;
                int correctAnswer;
                int mathAnswer;

                random = inst.getRandom (tabelLenth);
                randomToUse = inst.findFreeSlot (random, correctAnswers);
                
                mathAnswer = inst.inputUserInt ("Vad blir följande tal: " + (randomToUse + 1) + " x " + tabel);
                correctAnswer = inst.getCorrectAnswer(randomToUse, tabel);
                
                
                if (mathAnswer == 0) {
                    break;
                }
                
                if (inst.checkIfCorrectAnswer (correctAnswer, mathAnswer)) {
                    inst.register (randomToUse, true, correctAnswers, noOfAnswers);
                } else {
                    inst.register (randomToUse, false, correctAnswers, noOfAnswers);
                }
                
                if (inst.checkIfDoneTable (correctAnswers, tabelLenth)) {
                    break;
                }
            }
            
            inst.presentStatistics (tabelLenth, correctAnswers, noOfAnswers);
            if (inst.inputUserStr ("Vill du fortsätta öva? (y/n)").contains ("n")) {
                break;
            }
        }
        
        System.out.println ("~Tack för denna gång!~");
    }

    
    
    public void presentStatistics(int tabel, int[] correctAnswers, int[] noOfAnswers) {
        int noOfAnswersTotal;
        noOfAnswersTotal = reduce (true, noOfAnswers);
        
        System.out.println ("Du har svarat på " + noOfAnswersTotal + " frågor");
        System.out.println ("och svarat fel på följande tal i tabellen:");
        
        String answerStatus = "";

        for (int i = 0; i < noOfAnswers.length; i++) {
            if (correctAnswers[i] > 0 && noOfAnswers[i] == correctAnswers[i]) {
                answerStatus = "ok";
            }
            else {

                answerStatus = String.valueOf (noOfAnswers[i] - correctAnswers[i]);

            }
            System.out.println (formatIndexToDisplay(i) + " x " + tabel + ": " + answerStatus);
        }
    }

    public boolean checkIfDoneTable(int[] correctAnswers, int tableLength) {
        int total = tableLength * 3;
        int totalCorrectAnswers = reduce (true, correctAnswers);

        if (totalCorrectAnswers == total) {
            return true;
        }
        else {
            return false;
        }
    }

    public int reduce(boolean addition, int[] correctAnswers) {
        int result = 0;
        for (int i : correctAnswers) {
            result = addition ? result + i : result - i;
        }
        return result;
    }

    public void register(int index, boolean yes, int[] correctAnswers, int[] noOfAnswers) {
        if (yes) {
            correctAnswers[index]++;
        }
        noOfAnswers[index]++;
    }

    public boolean checkIfCorrectAnswer(int correctAnswer, int inputUser) {
        if (correctAnswer == inputUser) {
            return true;
        }
        else {
            return false;
        }
    }

    public void presentQuestion(int randomToUse, int tabel) { 
        int random = formatIndexToDisplay(randomToUse);
        
        System.out.println ("Vad blir följande tal: " + random + " x " + tabel);
    }
    
    public int getCorrectAnswer(int randomToUse, int tabel) {
        int correctAnswer = 0;
        int random = formatIndexToDisplay(randomToUse);
        
        correctAnswer = random * tabel;
        return correctAnswer;
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

    public int findFreeSlot(int offset, int[] slots) {
        int current;
  
        for (int i = 0; i < slots.length; i++) {
            current = (i + offset) % slots.length; 
            
           
            if (slots[current] < 3) { 
                return current;
            }
        }
        return 0;
    }

    public int getRandom(int tabelLenth) {
        int random;
        int randomFormatedForIndex;
        
        random = (int) (Math.random () * tabelLenth) + 1;
        randomFormatedForIndex = random - 1;
        return randomFormatedForIndex;
    }
    
    /**
     * Formats index from e.g. index 0 in array formated to 1
     * @param indexNumber the number to be formated
     * @return the formated number
     */
    public int formatIndexToDisplay(int indexNumber) {
        int displayFormat = indexNumber + 1;
        return displayFormat;
    }

}
