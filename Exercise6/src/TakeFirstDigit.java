import java.util.Scanner;

/*
 * First digit
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */

public class TakeFirstDigit
{
    public static void main(String[] args)
    {

        String input;
        int d; // first digit

        System.out.println("Skriv in ett heltal");
        Scanner in = new Scanner(System.in);

        input = in.next();

        d = firstDigit(input);

        System.out.println("First digit is: " + d);
        // Close scanner
        in.close();
    }

    public static int firstDigit(String input)
    {
        long inputLong;
        int len;
        long divider = 10;

        // Parse from string to long
        inputLong = Long.parseLong(input);

        // length of input
        len = input.length();

        if(len <= 1)
        {
            divider = 1;
        }
        else
        {
            // set divider
            for(int i = 2; i < len; i++)
            {
                divider = divider * 10;
            }

        }
        // Return the first integer
        return (int) (inputLong / divider);
    }
}
