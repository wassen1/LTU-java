import javax.swing.JOptionPane;

/*
 * Lunch check
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */
public class Exercise4_4
{
	public static void main(String[] args)
	{
		int time = 0;

		// Input
		String strNumber = JOptionPane.showInputDialog(null, "Vad är klockan? (hhmm)", "Tid", JOptionPane.QUESTION_MESSAGE);

		// Parse input
		time = Integer.parseInt(strNumber);

		if(time < 1300 && time > 1200)
		{
			JOptionPane.showMessageDialog(null, "Ja det är lunch nu");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Nej det är inte lunch nu");
		}
	}

}
