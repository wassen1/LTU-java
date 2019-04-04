
import java.util.Scanner;


public class Exercise3__4 {


	public static void main(String[] args)
	{
		int thisYear, 
		birthYear, 
		age;
		String strName;

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Vilket år är det? ");
		thisYear = keyboard.nextInt();
		System.out.print("Vilket år är du född?");
		birthYear =  keyboard.nextInt();

		keyboard.nextLine();
		System.out.print("Vad heter du? ");
		strName =  keyboard.nextLine();
		age = thisYear -  birthYear;
		System.out.println("Hej " +  strName + ", är du "  + age + " år?");
	}
}




