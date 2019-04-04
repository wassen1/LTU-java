import java.util.Scanner;
/*
 * Sort out max
 * @author Fredrik Wassermeyer, frewas-7
 */
public class MinMax
{
    public static void main(String[] args)
    {
        int x;
        int y;
        int d;//the maximum integer from input
        
        System.out.println("skriv in två heltal (x y)");
        Scanner in = new Scanner(System.in);
        in.useDelimiter("[,\\s]+");

        x = in.nextInt();
        y = in.nextInt();
     
        d = max(x, y);
        System.out.println("Det största talet är: " + d);
    }

    public static int max(int a, int b)
    {
        if(a < b)
        {
            return b;
        }
        else
            return a;

    }

}
