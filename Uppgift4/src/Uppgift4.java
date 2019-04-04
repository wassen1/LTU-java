import java.util.Scanner;

/*
 * Sorting list
 *
 * @author Fredrik Wassermeyer, frewas-7
 */
public class Uppgift4 {
    public static void main(String[] args) {
        int maxInt;
        int noOfEven = 0;
        int indexMaxInt;
        int lengthOfArray;
        int[] unsortedArr;
        int[] sortedArr;
        
        System.out.print ("Hur många slumptal i intervallet 0 - 999 önskas? ");
        Scanner in = new Scanner (System.in);
        
        // input number of random integers
        lengthOfArray = in.nextInt ();
        unsortedArr = new int[lengthOfArray];
        sortedArr = new int[lengthOfArray];
        
        // Generating random list
        for (int i = 0; i < lengthOfArray; i++) {
            unsortedArr[i] = (int) (Math.random () * 1000);
        }
        System.out.println ();
        System.out.println ("Här är de slumpade talen: ");
        
        // Print array unsorted
        for (int i = 0; i < lengthOfArray; i++) {
            System.out.print (unsortedArr[i] + " ");
        }
        
        // fin max integer in unsorted array
        for (int i = 0; i < lengthOfArray - 1; i++) {
            maxInt = i;
            for (indexMaxInt = i; indexMaxInt < lengthOfArray; indexMaxInt++) {
                if (unsortedArr[indexMaxInt] > unsortedArr[maxInt]) {
                    maxInt = indexMaxInt;
                }
            }
            
            // Switch position in array in order to get array sorted
            int placeHolder = unsortedArr[i];
            unsortedArr[i] = unsortedArr[maxInt];
            unsortedArr[maxInt] = placeHolder;
        }
        
        // Choose and move even numbers to array 'sortedArr'
        for (int i = 0; i < lengthOfArray; i++) {
            if (unsortedArr[i] % 2 == 0) {
                sortedArr[noOfEven] = unsortedArr[i];
                noOfEven++;
            }
        }
        int noOfUneven = lengthOfArray - noOfEven;
        indexMaxInt = noOfEven;
        
        // Choose and move uneven numbers to array 'sortedArr'
        for (int i = 0; i < lengthOfArray; i++) {
            if (unsortedArr[i] % 2 != 0) {
                sortedArr[indexMaxInt] = unsortedArr[i];
                indexMaxInt++;
            }
        }
        
        // Print array 'sortedArr' sorted with separator
        System.out.println ();
        System.out.println ();
        System.out.println ("Här är de slumpade talen ordnade:");
        for (int i = 0; i < lengthOfArray; i++) {
            System.out.print (sortedArr[i] + " ");
            if (i == noOfEven - 1) {
                System.out.print ("- ");
            }
        }
        
        // Print how many even and uneven
        System.out.println ();
        System.out.println ();
        System.out.println (
                "Av ovanstående " + lengthOfArray + " tal var " + noOfEven + " jämna och " + noOfUneven + " udda");
        
        // Close scanner
        in.close ();
    }
}