import java.util.Scanner;

/**
 * Right-angled triangle made of characters
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */
public class Uppgift3
{
    public static void main(String[] args)
    {
        // Declare variables
        int lengthSide = 0; // Length of triangle sides
        int directionTriangle = 0;
        int iLength = 0;
        int iLine = 0;

        // Creating scanner object for reading from input stream
        Scanner inScanner = new Scanner(System.in);

        do
        {
            System.out.print("Ange längden på de 2 lika länga sidorna (avsluta med -1): ");

            // Input length of triangle side
            lengthSide = inScanner.nextInt();

            // Determine if the input is 1-26
            while(!(lengthSide > 0 && lengthSide < 27) && !(lengthSide == -1))
            {
                System.out.println("Du måste ange ett tal mellan 1-26 eller -1. Försök igen!");

                // Input length of triangle side
                lengthSide = inScanner.nextInt();
            }

            if(lengthSide != -1) // Determine if the program should end here
            {
                System.out.print("Ska den räta vinkeln vara nedåt (0) eller uppåt (1): ");

                // Input direction of triangle
                directionTriangle = inScanner.nextInt();

                // Determine if the input is 0 or 1
                while(!(directionTriangle == 0 || directionTriangle == 1))
                {
                    System.out.println("Du måste ange 0 (nedåt) eller 1 (uppåt). Försök igen!");

                    // Input direction of triangle
                    directionTriangle = inScanner.nextInt();
                }

                System.out.println();

                // Right-angle upwards
                if(directionTriangle == 1)
                {
                    // Set length of printed line
                    for(iLength = lengthSide; iLength > 0; iLength--)
                    {
                        // Print line with characters
                        for(iLine = 0; iLine < iLength; iLine++)
                        {
                            char letter = (char) (iLine + 'A');
                            System.out.print(letter);
                        }
                        System.out.println();
                    }
                }

                // Right-angle downwards
                if(directionTriangle == 0)
                {
                    // Set length of printed line
                    for(iLength = 1; iLength <= lengthSide; iLength++)
                    {
                        // Print line with characters
                        for(iLine = 0; iLine < iLength; iLine++)
                        {
                            char letter = (char) (iLine + 'A');
                            System.out.print(letter);
                        }
                        System.out.println();
                    }
                }
            }

            System.out.println();

            // Determine if the program should end
        } while(lengthSide != -1);
        
        inScanner.close();
    }
}
