import java.util.Scanner;

/*
 * Age check
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */
public class Exercise4_1
{
	public static void main(String[] args)
	{
		int age;

		// Ask question
		System.out.println("Hur gammal är du? (ange i heltal)");

		// Declare scanner
		Scanner inScanner = new Scanner(System.in);

		// Delimiter whitespace
		inScanner.useDelimiter("\\s+");

		// Set input
		age = inScanner.nextInt();

		if(age >= 18)
		{
			System.out.println("Du kan ta körkort!");
		}
		else
		{
			System.out.println("Du är för ung. Återkom när du fyllt 18år!");
		}
		System.out.println("Tack och på återseende.");
	}

}
