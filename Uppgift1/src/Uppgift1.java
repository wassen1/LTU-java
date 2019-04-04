/**
 * Prints a table of content
 * 
 * @author Fredrik Wassermeyer, frewas-7
 * 
 */
public class Uppgift1
{
	public static void main(String[] args)
	{
		// Assigning the variables
		final int ATOM_AG = 47;
		final int ATOM_AU = 79;
		final int ATOM_C = 6;
		
		final double ATOMMASS_AG = 107.8682;
		final double ATOMMASS_AU = 196.96654;
		final double ATOMMASS_C = 12.01;
		
		float masstalAg = 0;
		float masstalAu = 0;
		float masstalC = 0;
		
		int rndMasstalAg = 0;
		int rndMasstalAu = 0;
		int rndMasstalC = 0;
		

		// Calculate masstal
		masstalAg = (float) (ATOMMASS_AG - ATOM_AG);
		masstalAu = (float) (ATOMMASS_AU - ATOM_AU);
		masstalC = (float) (ATOMMASS_C - ATOM_C);

		// Rounding the variables
		rndMasstalAg = Math.round(masstalAg);
		rndMasstalAu = Math.round(masstalAu);
		rndMasstalC = Math.round(masstalC);

		// Printing the variables
		System.out.println("Tecken\tGrundämne\tAtomnummer\tAtommassa\tMasstal");
		System.out.println("================================================================");
		System.out.println("Ag\tSilver\t\t" + ATOM_AG + "\t\t" + ATOMMASS_AG + "\t" + rndMasstalAg);
		System.out.println("Au\tGuld\t\t" + ATOM_AU + "\t\t" + ATOMMASS_AU + "\t" + rndMasstalAu);
		System.out.println("C\tKol\t\t" + ATOM_C + "\t\t" + ATOMMASS_C + "\t\t" + rndMasstalC);
	}
}
