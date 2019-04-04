
/**
 * Input and output temperature
 * @author Fredrik Wassermeyer, frewas-7
 * 
 */
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Temperature
{
	public static void main(String[] args)
	{
		// declare variables
		double sum, max, min, avg = 0;
		int day, noOfDay;
		
		// initiate variables
		sum = 0;
		max = -100;
		min = 100;

		// input no of days
		String newDay = JOptionPane.showInputDialog(null, "Antal dagar i månaden?", "Dagar", JOptionPane.QUESTION_MESSAGE);
		noOfDay = Integer.parseInt(newDay);
		
		Scanner inTemp = new Scanner(System.in);
		
		//input day temp
		for(day = 1; day <= noOfDay; day++)
		{
		    System.out.println("skriv dagens temperatur för dag " + day + ": ");
		    double temp = inTemp.nextDouble();
		    inTemp.nextLine();
		    
		    sum = sum + temp;
		    
		    if (temp < min)
		    {
		        min = temp;
		    }
		    
		    
		    if (temp > max)
		    {
		        max = temp;
		    }
		    
		}
		//Calculation
		avg = sum / noOfDay;

		// print
		System.out.printf("Medeltemp: \t%.2f°C", avg);
		System.out.println();
		System.out.printf("Minvärdet: \t%.2f°C", min);
		System.out.println();
		System.out.printf("Maxvärdet \t%.2f°C", max);
		System.out.println();
		System.out.println("NoOfDays \t" + noOfDay);

	}
}