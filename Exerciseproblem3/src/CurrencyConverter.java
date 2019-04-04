
/**
 * Currency converter
 * 
 * @author Fredrik Wassermeyer, frewas-7
 * 
 */
import javax.swing.JOptionPane;

public class CurrencyConverter
{
	public static void main(String args[])
	{

		// declare variables
		int money20 = 0, money10 = 0, money5 = 0, money1 = 0, remainderNumber = 0;

		// Input
		String strNumber = JOptionPane.showInputDialog(null, "Skriv in belopp i heltal", "Belopp",
				JOptionPane.QUESTION_MESSAGE);
		
		// Parse input
		int intNumber = Integer.parseInt(strNumber);
		
		// Convert input
		money20 = intNumber / 20;
		remainderNumber = intNumber % 20;
		// System.out.println(intNumber +  "%20 =  " +  (intNumber%20)); // Testutskrift
		
		// Save number of 10-kronor
		money10 = remainderNumber / 10;
		remainderNumber = remainderNumber % 10;
		money5 = remainderNumber / 5;
		remainderNumber = remainderNumber % 5;
		money1 = remainderNumber;
		
		
		//Print the values
		JOptionPane.showMessageDialog(null, "20-sedlar: " + money20 + "\n" + "10-kronor: " + money10 + "\n" +
				"5-kronor: " + money5 + "\n" + "1-kronor: " + money1);

	}

}
