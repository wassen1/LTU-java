import java.util.Scanner;

public class Exercise3_3 {
	public static void main(String args[])
	{
		int age;
		String name;

		Scanner scanner = new Scanner(System.in);
		//scanner.useDelimiter("[/:\\s]+");

		System.out.print("Skriv in din ålder: ");
		age = scanner.nextInt();
		name = scanner.nextLine();

		System.out.print("Skriv in ditt namn: ");
		name = scanner.nextLine();
		
		scanner.close();

		System.out.println("Du heter " + name +" och är " + age + " år");  
	}

}
