import java.util.Scanner;
/*
 * Take the length of input long
 * @author Fredrik Wassermeyer, frewas-7
 */
public class TakeLength
{
    public static void main(String[] args)
    {
        long input;
        int d;
        
        System.out.println("Skriv in ett heltal");
        
        Scanner in = new Scanner(System.in);
        input = in.nextLong();
        d = takeLength(input);
        
        System.out.println("Talet är " + d + " tecken långt.");
    }
    
    public static int takeLength(long input)
    {
        long temp = input;
        int i = 0;
        do {
            temp = temp/10;
            i++;
        } while (temp >= 1);
        return i;
    }

}
