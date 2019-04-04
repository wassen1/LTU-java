import java.util.Scanner;

public class ProductRegister
{
    public static void main(String[] args)
    {
        final int LENGTH = 100;
        int[] index = new int[LENGTH];
        String[] name = new String[LENGTH];
        double[] price = new double[LENGTH];
        int[] volume = new int[LENGTH];
        int selectedIndex;

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

        System.out.print("Skriv vilket index du vill plocka fram: ");

        // Scanner
        Scanner in = new Scanner(System.in);
        // Input
        selectedIndex = in.nextInt();

        System.out.println();
        if(index[selectedIndex] != 0)
        {
            System.out.print("Index: ");
            System.out.println(index[selectedIndex]);
            
            System.out.print("Name: ");
            System.out.println(name[selectedIndex]);

            System.out.print("Price: ");
            System.out.println(price[selectedIndex]);

            if(volume != null)
            {
                System.out.print("Volume: ");
                System.out.println(volume[selectedIndex]);
            }

        }
        
    }

}
