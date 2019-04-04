
public class Exercise4_8
{
	public static void main(String[] args)
	{
		//Start value = "a"
		int index = 97; 
		
		
		while (index < 123)
		{
			//Casting the index to char
			char number = ((char)(index));
			
			System.out.printf("%c\t", number);
			
			//Increment
			++index;
			
			
			//index = index + 1;
		}
	}

}
