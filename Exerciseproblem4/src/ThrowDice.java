
/*
 * Random dice generator
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */
import javax.swing.JOptionPane;

public class ThrowDice
{
	public static void main(String[] args)
	{
		int nrOfThrows = 0;
		int currentThrow = 0;
		int roll = 0;
		
		int noOfOne = 0;
		int noOfTwo = 0;
		int noOfThree = 0;
		int noOfFour = 0;
		int noOfFive = 0;
		int noOfSix = 0;

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
			switch(currentThrow)
			{
				case 1:
					noOfOne++;
					break;
				case 2:
					noOfTwo++;
					break;
				case 3:
					noOfThree++;
					break;
				case 4:
					noOfFour++;
					break;
				case 5:
					noOfFive++;
					break;
				case 6:
					noOfSix++;
					break;
				default:
					System.out.println("????");
			}

		}

		// Print hash
		System.out.println("");
		System.out.print("1: ");
		for(int indexOne = 0; indexOne <= noOfOne; indexOne++)
		{
			if(indexOne > 0)
				System.out.print("#");
		}

		// Print hash
		System.out.println("");
		System.out.print("2: ");
		for(int indexTwo = 0; indexTwo <= noOfTwo; indexTwo++)
		{
			if(indexTwo > 0)
				System.out.print("#");
		}

		// Print hash
		System.out.println("");
		System.out.print("3: ");
		for(int indexThree = 0; indexThree <= noOfThree; indexThree++)
		{
			if(indexThree > 0)
				System.out.print("#");
		}

		// Print hash
		System.out.println("");
		System.out.print("4: ");
		for(int indexFour = 0; indexFour <= noOfFour; indexFour++)
		{
			if(indexFour > 0)
				System.out.print("#");
		}

		// Print hash
		System.out.println("");
		System.out.print("5: ");
		for(int indexFive = 0; indexFive <= noOfFive; indexFive++)
		{
			if(indexFive > 0)
				System.out.print("#");
		}

		// Print hash
		System.out.println("");
		System.out.print("6: ");
		for(int indexSix = 0; indexSix <= noOfSix; indexSix++)
		{
			if(indexSix > 0)
				System.out.print("#");
		}
		// diceScanner.close();
	}

}
