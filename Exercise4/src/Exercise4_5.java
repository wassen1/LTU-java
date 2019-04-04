import javax.swing.JOptionPane;

/*
 * sex check
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */
public class Exercise4_5
{
	public static void main(String[] args)
	{

		// Input
		String strSex = JOptionPane.showInputDialog(null, "Vilket kön har djuret? (hane eller hona)", "Kön",
				JOptionPane.QUESTION_MESSAGE);

		if((strSex.equals("hane")) ^ ((strSex.equals("hona"))))
		{
			if(strSex.equals("hane"))
			{
				JOptionPane.showMessageDialog(null, "Djuret är av typen hane");
			}
			if(strSex.equals("hona"))
			{
				JOptionPane.showMessageDialog(null, "Djuret är av typen hona");
			}
		}

		else
		{
			// if((strSex.equals("hane")) && ((strSex.equals("hona"))))
			// {
			// JOptionPane.showMessageDialog(null, "hermafrodit");
			// }
			// else
			// {
			JOptionPane.showMessageDialog(null, "Fel typ", "Fel", JOptionPane.ERROR_MESSAGE);
			// }
		}

	}
}
