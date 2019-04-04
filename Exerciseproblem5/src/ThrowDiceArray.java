
/*
 * Random dice generator with array
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */
import javax.swing.JOptionPane;

public class ThrowDiceArray
{
	public static void main(String[] args)
	{
		int nrOfThrows = 0;
		// int index = 0;
		int currentThrow = 0;
		// int intDice = 0;
		int roll = 0;

		int noOfOne = 0;
		int noOfTwo = 0;
		int noOfThree = 0;
		int noOfFour = 0;
		int noOfFive = 0;
		int noOfSix = 0;
		final int LENGTH = 7;
        int[] dice = new int[LENGTH];

		// Input noOfThrow
		String strNum = JOptionPane.showInputDialog(null, "Skriv in antal tärningskast", "kast",
				JOptionPane.QUESTION_MESSAGE);
		nrOfThrows = Integer.parseInt(strNum);

		// Throw dice and print
		while(roll < nrOfThrows)
		{

			// Throw random dice
			currentThrow = (int) (Math.random() * 6 + 1);
			roll++;

			System.out.print(currentThrow);

			// set value of the dices
			dice[currentThrow] = (dice[currentThrow]) + 1;
		}

		
		
		// Print hash
		System.out.println();
		
		for(int diceNumb = 1; diceNumb <= 6; diceNumb++)
		{
		    System.out.print("\n" + diceNumb + ": ");
		    for(int i = 0; i < dice[diceNumb]; i++)
		    {
		        System.out.print("#");
		    }
		}
		// diceScanner.close();
	}

}
