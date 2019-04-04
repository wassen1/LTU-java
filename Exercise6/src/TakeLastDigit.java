import java.util.Scanner;
/*
 * Take last digit
 * @author Fredrik Wassermeyer, frewas-7
 */
public class TakeLastDigit
{
    public static void main(String[] args)
    {
        long input;
        int d;
        
        System.out.println("Ange ett heltal");
        Scanner in = new Scanner(System.in);
        input = in.nextLong();
        d = lastDigit(input);
        
        System.out.println("Sista siffran är: " + d);
        
    }
    
    public static int lastDigit(long input)
    {
        return (int) (input %10);
    }

}
