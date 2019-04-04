import java.util.Scanner;

/**
 * Array
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */
public class Exercise5_1
{
    public static void main(String[] args)
    {
        /*
        int[] a1;
        a1 = new int[7];
        
        
        a1[0] = 2;
        a1[1] = 3;
        a1[2] = 1;
        a1[3] = 4;
        a1[4] = 2;
        a1[5] = 3;
        a1[6] = 6;
        */
        /*
        int[] a1 = {3,5,6,8,2,8,0};
        
        int tal = a1[6];
        
        int len = a1.length;
        
        //new array
        int[] a2 = new int[7];
        
        //fill array a2
        a2[0] = a1[0];
        a2[1] = a1[1];
        a2[2] = a1[2];
        a2[3] = a1[3];
        a2[4] = a1[4];
        a2[5] = a1[5];
        a2[6] = a1[6];
        
        //print array a2
        for (int i = 0; i < 7; i++)
        {
            System.out.print(a2[i]+", ");
        }
        System.out.println();
        System.out.println(tal);
        
        //for-each
        for (int tal2 : a2)
        {
            System.out.println(tal2);
        }
        
        //fill new array a3
        int[] a3 = new int[a2.length];
        for (int i = 0; i < a2.length; i++) {
            a3[i] = a2[i];
        }
        
        //for-each a3
        for(int tal3 : a3)
        {
            System.out.print(tal3 + ", ");
        }
        
        
        */
        final int LENGTH = 100;
        double[] values = new double[LENGTH];

        values[1] = 12;
        
        
        
        int currentSize = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNextDouble())
        {
            if (currentSize < values.length)
            {
                values[currentSize] = in.nextDouble();
                currentSize++;
            }
        }
        
        for (int i = 0; i < currentSize; i++)
        {
            System.out.println(values[i]);
        }

    }

}
