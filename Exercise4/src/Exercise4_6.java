import javax.swing.JOptionPane;

/*
 * Number neg check
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */
public class Exercise4_6
{
	public static void main(String[] agrs)
	{
		int intNum = 1;
		do
		{

			// Input
			String strNum = JOptionPane.showInputDialog(null, "Skriv in ett tal, i heltal", "test",
					JOptionPane.QUESTION_MESSAGE);
			intNum = Integer.parseInt(strNum);

			if(intNum >= 0)
				JOptionPane.showMessageDialog(null, "testa igen!");

		} while(intNum >= 0);

		JOptionPane.showMessageDialog(null, "tack!");
	}

}
