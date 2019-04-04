/**
 * Timesheet
 * 
 * @author Fredrik Wassermeyer, frewas-7
 * 
 */
import java.util.Scanner;
public class Uppgift2
{
	public static void main(String[] args)
	{
		// Declare variables
		int beginHours;
		int beginMinutes;
		int endHours;
		int endMinutes;
		double inTime;
		double outTime; 
		double totalTime;
		final double SALARY;

		System.out.println("Skriv in när du började arbeta idag (hh:mm)");

		// Creating scanner object for reading from input stream
		Scanner inScanner = new Scanner(System.in);

		// Delimiter ":" and whitespace
		inScanner.useDelimiter(":|\\s+");

		// Input begin of day
		beginHours = inScanner.nextInt();
		beginMinutes = inScanner.nextInt();

		System.out.println("Skriv in när du slutade arbeta idag (hh:mm)");

		// Input end of day
		endHours = inScanner.nextInt();
		endMinutes = inScanner.nextInt();

		// Calculate begin/end of day in decimal number
		inTime = ((double) beginMinutes / 60) + beginHours;
		outTime = ((double) endMinutes / 60) + endHours;

		// Worked time
		totalTime = outTime - inTime;

		// Salary
		SALARY = totalTime * 190;

		//System.out.printf("Din lön för idag blir: \t%.2f kr", SALARY);
		System.out.printf("Din lön för idag blir:" + "\t%.2f", SALARY);
		System.out.print(" kr");
		System.out.println();

	}

}
