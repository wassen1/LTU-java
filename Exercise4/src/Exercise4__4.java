import javax.swing.JOptionPane;
import javax.swing.Spring;

/*
 * Lunch check
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */
public class Exercise4__4
{
	public static void main(String[] args)
	{
		int time = 0;

		// Input
		String strNumber = JOptionPane.showInputDialog(null, "Vad är klockan? (hhmm)", "Tid", JOptionPane.QUESTION_MESSAGE);

		// Parse input
		time = Integer.parseInt(strNumber);

		if(time < 1300)
		{
			if(time > 1200)
			{
				JOptionPane.showMessageDialog(null, "Ja det är lunch nu");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Nej det är inte lunch nu");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Nej det är inte lunch nu");
		}
	}

}
