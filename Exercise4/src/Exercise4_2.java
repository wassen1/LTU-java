import java.util.Scanner;

/*
 * temp check
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */
public class Exercise4_2
{
	public static void main(String[] args)
	{
		int temp;

		// Ask question
		System.out.println("Hur varmt är vattnet? (ange i heltal)");

		// Declare scanner
		Scanner tempScanner = new Scanner(System.in);

		// Delimiter whitespace
		tempScanner.useDelimiter("\\s+");

		// Set input
		temp = tempScanner.nextInt();

		if(temp < 100)
		{
			System.out.println("Värmaren står på");
		}
		else
		{
			System.out.println("Värmaren är avstängd");
		}
		if(temp > 100)
		{
			System.out.println("Fel temperatur!");
		}
		if(temp == 100)
		{
			System.out.println("Vattnet kokar");
		}
		tempScanner.close();
	}

}
