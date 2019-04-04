/*
 * Sorting list
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */
public class Sorting
{
    public static void main(String[] args)
    {
        final int LEN = 30;
        int[] a = new int[LEN];
        int max;

        // Generating random list
        for(int i = 0; i < LEN; i++)
        {
            a[i] = (int) (Math.random() * 100 + 1);
        }

        // Print array unsorted
        for(int i = 0; i < LEN; i++)
        {
            System.out.print(a[i] + ", ");
        }

        // Sorting array
        for(int i = 0; i < LEN - 1; i++)
        {
            max = i;

            for(int k = i + 1; k < LEN; k++)
            {
                if(a[k] > a[max])
                {
                    max = k;
                }
            }
            
            int temp = a[i];
            a[i] = a[max];
            a[max] = temp;
        }
        // Print sorted array
        System.out.println();
        for(int i = 0; i < LEN; i++)
        {
            System.out.print(a[i] + ", ");
        }
    }

}
