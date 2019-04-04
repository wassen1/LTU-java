
/**
 * Input and output temperature
 * @author Fredrik Wassermeyer, frewas-7
 * 
 */
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TemperatureArray
{
	public static void main(String[] args)
	{
		// declare variables
		double sum, max, min, avg = 0;
		int day, noOfDay, minDay = 0, maxDay = 0, noDaysOverAvg = 0;
        double[] temperature;
		
		// initiate variables
		sum = 0;
		max = -100;
		min = 100;

		// input no of days
		String newDay = JOptionPane.showInputDialog(null, "Antal dagar i månaden?", "Dagar", JOptionPane.QUESTION_MESSAGE);
		noOfDay = Integer.parseInt(newDay);
		
		
		temperature = new double[noOfDay + 1];
		
		Scanner inTemp = new Scanner(System.in);
		
		//input day temperature
		for(day = 1; day <= noOfDay; day++)
		{
		    System.out.println("skriv dagens temperatur för dag " + day + ": ");
		    temperature[day] = inTemp.nextDouble();
		    inTemp.nextLine();
		    
		    //set temperature values in array
		    
		    
		    sum = sum + temperature[day];
		    
		    if (temperature[day] < min)
		    {
		        min = temperature[day];
		        minDay = day;
		    }
		    
		    
		    if (temperature[day] > max)
		    {
		        max = temperature[day];
		        maxDay = day;
		    }
		    
		}
		//Calculation
		avg = sum / noOfDay;
		
		//Calculate number of days over average
		for(int i = 1; i <= noOfDay; i++)
		{
		    if (temperature[i] > avg)
		    {
		        noDaysOverAvg++;
		    }
		}

		// print
		System.out.printf("Medeltemp: \t%.2f°C", avg);
		System.out.printf("\nMinvärdet: \t%.2f°C", min);
		System.out.println("\nMindagen: \t" + minDay);
		System.out.printf("Maxvärdet \t%.2f°C", max);
		System.out.println("\nMaxdagen: \t" + maxDay);
		System.out.println("Antal dagar:  \t" + noOfDay);
		System.out.println("Dagar över medel: " + noDaysOverAvg);

	}
}