import java.util.Scanner;

/*
 * Search for int in arrays
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */

public class SearchArrayInt
{
    public static void main(String[] args)
    {
        int[] test = {1,2,3,4,5,6,7,8,9,10};
      
        int toFind = 1;
        /* int[] d = search(test, toFind);
        for (int print : d)
        {
            //if (print != 0)
        System.out.print(print + ", ");
        }*/
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.println("Vilket tal sökes? Avsluta med -1");
            toFind = in.nextInt();
            System.out.println("Returnerades: " + search(test, toFind));
            
            if (search(test, toFind) == -1)
                break;
        }
    }

    public static int search(int[] arrays, int find)
    {
        int len = arrays.length;
        int tempPos = -1;
        
        for(int i = 0; i < len; i++)
        {
            if(arrays[i] == find)
            {
                tempPos = i;
            }
        }
        
        return tempPos;
    }

}
