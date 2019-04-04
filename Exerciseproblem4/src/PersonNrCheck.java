/**
 * Social number check
 * @author Fredrik Wassermeyer, frewas-7
 */
import javax.swing.JOptionPane;

public class PersonNrCheck
{
	public static void main(String[] args)
	{
		long idNumber; // input ID number
		long divider = 1000000000;
		int sumId = 0; // Sum of 9 first numbers in ID
		int nextDigit = 0; // Next digit in the ID number
		int lastDigit = 0; // Last digit in the ID number to be checked

		// Input ID number
		String strId = JOptionPane.showInputDialog(null, "Skriv in ditt personnummer, 10-siffror", "ID-koll",
				JOptionPane.QUESTION_MESSAGE);
		idNumber = Long.parseLong(strId);

		for(int i = 1; i < 10; i++)
		{
			// extract the first number in ID number.
			nextDigit = (int) (idNumber / divider);

			// every second digit is multiplicated with 2 until digit 9.
			if(i % 2 != 0)
			{
				nextDigit = nextDigit * 2;
			}
			
			// If the result is more than 9 then keep the most right digit
			if(nextDigit > 9)
			{
				nextDigit = (nextDigit % 10) + 1;
			}
			
			// Add nextDigit to sum.
			sumId = sumId + nextDigit;

			// Remove first digit from idNumber
			idNumber = idNumber % divider;

			// Remove one zero from divider
			divider = divider / 10;
		}

		// keep only last digit of sumId
		sumId = sumId % 10;

		// Calculate last digit in ID number
		lastDigit = 10 - sumId;

		// If lastDigit is 10 use only 0
		if(lastDigit == 10)
			lastDigit = 0;

		// Compare last digit in ID with calculated last digit
		if(lastDigit == idNumber)
			JOptionPane.showMessageDialog(null, "Ditt ID-nummer är korrekt!", null, JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Ditt ID-nummer är inte korrekt!", null, JOptionPane.ERROR_MESSAGE);
	}
}
