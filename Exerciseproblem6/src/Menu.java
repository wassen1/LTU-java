import java.util.Scanner;

/*
 * Menu
 * 
 * @author Fredrik Wassermeyer, frewas-7
 */
public class Menu
{
    public static void main(String[] args)
    {
        int inChoice = 1;

        while(inChoice != 4)
        {
            inChoice = menu();
            switch(inChoice)
            {
                case 1:
                    System.out.println("Du valde att sätta in");
                    
                    break;
                case 2:
                    System.out.println("Du valde att ta ut");
                    
                    break;
                case 3:
                    System.out.println("Du valde saldobesked");
                    
                    break;
                case 4:
                    System.out.println("Du valde avsluta");
                    
                    break;
                default:
                    System.out.println("Välj något i menyn. Tal mellan 1-4");
                    
                    break;

            }
        }
    }

    public static int menu()
    {
        int choice;
        Scanner in = new Scanner(System.in);

        System.out.println("\nVälj ett av följande nummer i menyn: ");
        System.out.println("1. Sätta in pengar");
        System.out.println("2. Ta ut pengar");
        System.out.println("3. Saldobesked");
        System.out.println("4. Avsluta");
        System.out.println("Ditt val: ");

        choice = in.nextInt();
        System.out.println();

        return choice;
    }

}
