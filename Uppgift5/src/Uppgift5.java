
/**
 * Mathematical methods
 * 
 * @author Fredrik Wassermeyer, frewas-7
 * 
 */
import java.lang.Math;
import java.util.Objects;
import java.util.Scanner;

public class Uppgift5 {
    
    public static void main(String[] args) {
        // ensures the Scanner will be closed at the end
        try (Scanner inputScanner = new Scanner(System.in)) {
            for (int i = 0; i < 50; i++) {
                System.out.print("-");
            }
            
            System.out.println();

            System.out.println("# Test av area och volymmetoderna. Avsluta med 'q'");

            for (int i = 0; i < 50; i++) {
                System.out.print("-");
            }
            
            System.out.println();

            // Calculating base area, cone surface area and volume of cone
            while(true) {
                final Integer radius = readNextInt(inputScanner);
                
                if(radius == null) {
                    break;
                }
                
                final Integer height = readNextInt(inputScanner);
                
                if(height == null) {
                    break;
                }
                
                System.out.print("r = " + radius);
                System.out.println(" h = " + height);
                System.out.printf("Basytans area: \t\t%.2f", area(radius));
                System.out.println();
                System.out.printf("Mantelytans area: \t%.2f", area(radius, height));
                System.out.println();
                System.out.printf("Volym: \t\t\t%.2f", volume(radius, height));
                System.out.println();
                System.out.println();
            }
            
            for (int i = 0; i < 50; i++) {
                System.out.print("-");
            }
            
            System.out.println();

            System.out.println("# Test av bråktalsmetoderna. Avsluta med 'q'");
            
            for (int i = 0; i < 50; i++) {
                System.out.print("-");
            }
            System.out.println();
            
            
            
            // Converting and shortening fractions
            while (true) {
                Integer nominator = readNextInt(inputScanner);
                if (nominator == null) {
                    break;
                }
                
                Integer denominator = readNextInt(inputScanner);
                if (denominator == null) {
                    break;
                }
                
                System.out.print(nominator + "/" + denominator + " = ");
                printFraction(fraction(nominator, denominator));
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    };

    /**
     * Takes input from Scanner in. Takes integers as input and is ignoring
     * everything except "q".
     * 
     * @return input from scanner
     */
    public static Integer readNextInt(Scanner input) {
        Integer result = null;

        while (result == null) {
            if (input.hasNextInt ()) {
                result = Math.abs (input.nextInt ());
            }
            else {
                String str = input.next ();
                if (Objects.equals (str, "q")) {
                    break;
                }
                else {
                    System.out.println ("Du har angett otillåtet tecken: " + str);
                }
            }
        }

        return result;
    };

    /**
     * Calculates the area
     * 
     * @param radius
     *            the radius
     * @return the area
     */
    public static double area(int radius) {
        return Math.PI * radius * radius;
    }

    /**
     * Calculates the surface area of a cone
     * 
     * @param radius
     *            the radius
     * @param height
     *            the height
     * @return the area
     */
    public static double area(int radius, int height) {
        return Math.PI * radius * pythagoras(radius, height);
    }

    /**
     * Calculates the hypotenuse
     * 
     * @param a
     *            the radius
     * @param b
     *            the height
     * @return the hypotenuse
     */
    public static double pythagoras(int a, int b) {
        return Math.sqrt((a * a) + (b * b));
    }

    /**
     * Calculates the volume of a cone
     * 
     * @param radius
     *            the radius
     * @param height
     *            the height
     * @return the volume of the cone
     */
    public static double volume(int radius, int height) {
        return (Math.PI * radius * radius * height) / 3.0;
    }

    /**
     * Takes a nominator and denominator and convert it in to a shortened
     * fraction
     * 
     * @param nominator
     *            the nominator
     * @param denominator
     *            the denominator
     * @return an array containing the shortened fraction
     */
    public static int[] fraction(int nominator, int denominator) {
        int[] fractionArray = { 0, 0, 0 };
        int greatestCommonDivisor;

        if (denominator == 0) {
            return null;
        }
        
        if (nominator == 0) {
            return fractionArray;
        }
        
        fractionArray[0] = nominator / denominator;
        fractionArray[1] = nominator % denominator;
        fractionArray[2] = denominator;

        greatestCommonDivisor = sgd(fractionArray[1], fractionArray[2]);
        fractionArray[1] = fractionArray[1] / greatestCommonDivisor;
        fractionArray[2] = fractionArray[2] / greatestCommonDivisor;

        return fractionArray;

    }

    /**
     * Finds the greatest common divisor using Euclidean algorithm
     * 
     * @param nominator
     *            the nominator
     * @param denominator
     *            the denominator
     * @return returns the greatest common divisor
     */
    public static int sgd(int nominator, int denominator) {
        if (nominator < denominator) {
            int tmpNominator = nominator;
            nominator = denominator;
            denominator = tmpNominator;
        }
        
        while (denominator != 0) {
            int tmpDenominator = nominator % denominator;
            nominator = denominator;
            denominator = tmpDenominator;
        }
        
        return nominator;
    }

    /**
     * Prints a fraction
     * 
     * @param parts
     *            an array with 3 elements. [0] integer, [1] nominator, [2]
     *            denominator
     */
    public static void printFraction(int[] parts) {
        if (parts == null) {
            System.out.println("\"Error\"");
        }
        else if (parts[2] == 0) {
            System.out.println ("0");
        }
        else if (parts[1] == 0) {
            System.out.println(parts[0]);
        }
        else if (parts[0] == 0) {
            System.out.println(Integer.toString(parts[1])
                    + "/" + Integer.toString(parts[2]));
        }
        else {
            System.out.println(Integer.toString(parts[0])
                    + " " + Integer.toString(parts[1])
                    + "/" + Integer.toString(parts[2]));
        }
    }

};
