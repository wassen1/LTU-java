/**
 * Print path
 * 
 * Input and output
 * @author Fredrik Wassermeyer, frewas-7
 * 
 */
import java.util.Scanner;
public class Exercise3_1 {
	public static void main(String args[]) {
		
		//Representing path to folder
		String disc, folder, subfolder;
		
		//Creating scanner object for reading from input stream
		Scanner scanner = new Scanner(System.in);
		
		//Set delimiter to '-' or '/' or whitespace
		scanner.useDelimiter("[-/:\\s]+");
		
		// Instructions to the user
		System.out.print("Skriv in sökvägen: C://Windows/System/");
		
		//Input
		disc = scanner.next();
		folder = scanner.next();
		subfolder = scanner.next();
		//scanner.close();
		//Print the result
		System.out.println(disc + "\n" + folder + "\n" + subfolder + "");
	}
	

}
