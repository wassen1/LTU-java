import java.util.Arrays;

public class Exercise5_3
{
    public static void main(String[] args)
    {
        final int LENGTH = 100;
        int[] index = new int[LENGTH];
        String[] name = new String[LENGTH];
        double[] price = new double[LENGTH];
        int[] volume = new int[LENGTH];
        int selectedIndex;
        boolean sorted;

        index[0] = 1;
        index[1] = 2;
        index[2] = 3;
        index[3] = 4;

        name[0] = "mjöl";
        name[1] = "mjölk";
        name[2] = "smör";
        name[3] = "bröd";

        price[0] = 8.30;
        price[1] = 12.20;
        price[2] = 37.50;
        price[3] = 27.90;

        volume[0] = 1010;
        volume[1] = 100;
        volume[2] = 120;
        volume[3] = 10;
        
        //sorting price array
        do
        {
            sorted = true;

            for(int i = 0; i < (LENGTH - 1); i++)
            {
                //do if not sorted
                if(price[i] > price[i + 1])
                {
                    //swap elements
                    double temp = price[i];
                    price[i] = price[i + 1];
                    price[i + 1] = temp;

                    sorted = false;
                }
            }
        } while(!sorted);
        
        System.out.println(Arrays.toString(price));
    }

}
