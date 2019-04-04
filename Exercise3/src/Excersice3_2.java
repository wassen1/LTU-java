
/**
 * Input and output
 * @author Fredrik Wassermeyer, frewas-7
 * 
 */
import java.util.Scanner;

public class Excersice3_2 extends Exercise3_1
{
	public static void main(String[] args)
	{

		int number1, number2;
		double divide;

		// Creating scanner object for reading from input stream
		Scanner scanner = new Scanner(System.in);

		// Set delimiter to '-' or '/' or whitespace
		scanner.useDelimiter("[/:\\s]+");

		// Instructions to the user
		System.out.print("Skriv in två heltal");

		// Input
		number1 = scanner.nextInt();
		number2 = scanner.nextInt();

		// Calculations
		int total = number1 + number2;
		int diff = number1 - number2;
		int prod = number1 * number2;
		double average = total / 2.0;
		divide = ((double) number1) / number2;
		int min = Math.min(number1, number2);
		int max = Math.max(number1, number2);
		int dist = Math.abs(number1 - number2);

		scanner.close();

		// Print the result
		System.out.printf("Total: \t\t" + total + "\n" + "Difference: \t" + diff + "\n" + "Product: \t" + prod + "\n");
		System.out.printf("Average: \t%.2f", average);
		System.out.println();
		System.out.printf("Distance: \t" + dist + "\n" + "Max value: \t" + max + "\n" + "Min value: \t" + min + "\n");

	}

}
