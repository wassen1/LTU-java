import javax.swing.JOptionPane;

/*
 * Glace check
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */
public class Exercise4_3
{
	public static void main(String[] args)
	{
		// declare variables
		long ball3 = 0;
		long ball2 = 0;
		long ball1 = 0;
		long remainderNumber = 0;
		long money = 0;
		long sumBalls = 0;

		// Input
		String strNumber = JOptionPane.showInputDialog(null, "Skriv in hur mycket veckopeng du har, i heltal", "Belopp",
				JOptionPane.QUESTION_MESSAGE);

		// Parse input
		money = Integer.parseInt(strNumber);

		/*
		 * // Less than 10 if (!(money < 10)) { if (money < 15) { // set value of
		 * balls sumBalls = 1; } else if (money < 20) // set value of balls sumBalls
		 * = 2;
		 * 
		 * else if (money >=20) {
		 */

		// save number of 3 balls
		ball3 = money / 20;
		remainderNumber = money % 20;

		// Save number of 2 balls
		ball2 = remainderNumber / 15;
		remainderNumber = remainderNumber % 15;

		// Save number of 1 balls
		ball1 = remainderNumber / 10;

		// Sum of balls
		sumBalls = (ball3 * 3) + (ball2 * 2) + ball1;

		// }
		// }

		if(money < 10)
		{
			// Print the values
			JOptionPane.showMessageDialog(null, "Du får inga kulor. Du har för lite pengar");
		}

		else
		{
			// Print the values
			JOptionPane.showMessageDialog(null, "Antal kulor: " + sumBalls);
		}
	}

}
