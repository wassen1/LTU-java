
/**
 * Input and output temperature
 * 
 * @author Fredrik Wassermeyer, frewas-7
 * 
 */
import java.util.Scanner;

public class Temperature
{
    public static void main(String[] args)
    {
        // declare variables
        int max, min; 
        double avg = 0;
        int noOfDay, minDay = 0, maxDay = 0, noDaysOverAvg = 0;
       double[] temp = new double[32];
       
        
        // initiate variables
        max = -100;
        min = 100;

       noOfDay = input(temp);
       avg = average(temp, noOfDay);
       max = maxTemp(temp, noOfDay);
       min = minTemp(temp, noOfDay);   
       noDaysOverAvg = nrOfDayPastAvg(temp, avg, noOfDay);
        


        // print
        System.out.printf("Medeltemp: \t%.2f°C", avg);
        System.out.printf("\nMinvärdet \t%.2f°C", temp[min]);
        System.out.println("\nMindagen: \t" + min);
        System.out.printf("Maxvärdet \t%.2f°C", temp[max]);
        System.out.println("\nMaxdagen: \t" + max);
        System.out.println("Antal dagar:  \t" + noOfDay);
        System.out.println("Dagar över medel: " + noDaysOverAvg);

    }

    public static int input(double[] temps)
    {
        int day = 0;
        int noOfDay;
        // input no of days
        Scanner inTemp = new Scanner(System.in);
        System.out.println("Antal dagar i månaden?");
        noOfDay = inTemp.nextInt();

        // input day temperature
        while(day < noOfDay)
        {
            day++;
            System.out.println("skriv dagens temperatur för dag " + day + ": ");
            temps[day] = inTemp.nextDouble();
            inTemp.nextLine();
        }
        return noOfDay;
    }
    
    public static double average(double[] temps, int noOfTemps)
    {
        double sum = 0.0;
        double theAverage = 0.0;
        for ( int i = 1; i <= noOfTemps; i++)
        {
            sum = sum + temps[i];
        }
        theAverage = sum / noOfTemps;
        return theAverage;
    }
    
    public static int maxTemp(double[] temps, int noOfTemps)
    {
        int theMaxIndex = 1;
        for(int i = 2; i <= noOfTemps; i++)
        {
            if (temps[i] > temps[theMaxIndex])
            {
                theMaxIndex = i;
            }
        }
        return theMaxIndex;
    }
    
    public static int minTemp(double[] temps, int noOfTemps)
    {
        int theMinIndex = 1;
        for(int i = 2; i <= noOfTemps; i++)
        {
            if (temps[i] < temps[theMinIndex])
            {
                theMinIndex = i;
            }
        }
        return theMinIndex;
    }
    
    public static int nrOfDayPastAvg(double[] temps, double avgs, int noOfTemps)
    {
        int noDaysOverAvg = 0;
        for(int i = 1; i <= noOfTemps; i++)
        {
            if (temps[i] > avgs)
                noDaysOverAvg++;
        }
        return noDaysOverAvg;
    }
}
