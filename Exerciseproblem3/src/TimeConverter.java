
/**
 * Time converter
 * 
 * @author Fredrik Wassermeyer, frewas-7
 * 
 */
import java.util.Scanner;

public class TimeConverter
{
	public static void main(String[] args)
	{
		int hh, mm, ss, total;

		// Creating scanner object for reading from input stream
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		// Set delimiter to ':', '|', white space
		scanner.useDelimiter(":|\\s+");
		
		// Instructions to the user
		System.out.print("Skriv in tiden (hh:mm:ss)");
		
		hh = scanner.nextInt();
		mm = scanner.nextInt();
		ss = scanner.nextInt();
		
		total = (hh * 3600) + (mm * 60) + ss;
		
		System.out.println("Det blir: " + total + " sekunder.");

	}

}
