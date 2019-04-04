 import java.util.Scanner;
 /* 
  * YATSY - saknar vissa steg men är över godkändgränsen
  * 
  */
public class YatzyTest {
   

    
  

        public static void main(String[] args)
        {
            boolean play;
            do
            {
                play = onePlayerGame();
            } while(play);
        }
        
        //--------------------------------
        // Spelar ett spel för en person
        //--------------------------------
        public static boolean onePlayerGame()
        {   
            Scanner in = new Scanner(System.in);
            
            // Texten som ska skrivas ut före poängen presenteras
            String[] resultBoard = { "", "Ettor", "Tvåor", "Treor", "Fyror", "Femmor", "Sexor" };
            
            // Här lagras poängen för de olika spelhalvorna
            int[] points = new int[resultBoard.length];
            
            startNewTurn(resultBoard.length-1, resultBoard, points);
            System.out.print("Vill du spela ett nytt spel? ");
            String cont = in.nextLine();
            if(cont.equalsIgnoreCase("ja") || cont.equalsIgnoreCase("j"))
                return true;
            return false;
        }
        
        /**
         * En ny omgång
         * @param noOfTurns     Antal kast som görs för en omgång (3)
         * @param resultBoard   Resultatlistan (del 1 eller del 2)
         * @param points        Listan med poängen
         * @return
         */
        public static boolean startNewTurn(int noOfTurns, String[] resultBoard, int[] points)
        {
            final int NO_OF_DICES = 5;
            Scanner in = new Scanner(System.in);
            in.useDelimiter(":|\\s");   // Anger att en inläsning kan avslutas med : förutom av vanliga mellanslag/radbyte
            boolean yatsy = false;
            int[] dices = new int[7];   // 1-6, index noll används ej
            for(int i = 1; i < noOfTurns+1; i++)
            {
                System.out.println("Ny omgång, kastar tärningarna...");
                
                // Se till så att alla tärningar är nollade
                clearDices(dices, 0);
                
                // Kastar tärningarna
                throwDices(dices, NO_OF_DICES);
                // Presenterar kastet
                graphicalPrintDices(dices);
                
                // Två återstående kast, här får man chansen att spara på tärningar mellan kasten
                // Man kan inte avbryta kasten i förtid, utan får alltid göra alla tre kasten
                for(int k = 0; k < 2; k++)
                {
                    System.out.print("\nVilket värde vill du spara på (0 om inget)?");
                    int save = in.nextInt();
                    
                    in.nextLine(); // Nu måste vi rensa inmatningsbufferten så att efterföljande inläsningar ska fungera...
                    save = clearDices(dices, save); 
                    
                    // Nytt kast med färre tärningar om någon tärning ska sparas
                    throwDices(dices, NO_OF_DICES-save);
                    graphicalPrintDices(dices);
                }
                
                int save = 0;
                do
                {
                    printStatistics(resultBoard, points);
                    // Här ska man välja var man vill föra in poängen
                    System.out.printf("\nPoängen ska föras in på vilken rad (1-%d)? ", (resultBoard.length-1));             
                    save = in.nextInt();
                    
                    // Man ska inte kunna skriva över sparade poäng
                    if(points[save] != 0)
                    {
                        System.out.print("\nDu har redan sparat " + resultBoard[save]);     
                        in.nextLine(); // Nu måste vi rensa inmatningsbufferten igen...
                    }
                } while(points[save] != 0);         
                
                // Summerar och sparar valda värden
                points[save] = sumUnits(save, dices);
                // Skriver ut hur många poäng som man tilldelats
                System.out.println("\nDin poäng för " + resultBoard[save] + " " + points[save]);

                in.nextLine(); // Nu måste vi rensa inmatningsbufferten igen...
                printStatistics(resultBoard, points);
            }
            return yatsy;
        }
        
        //------------------------------------------------------------------------------------------
        // Skriver ut resultaten
        // INPARAMETRAR: int[] text   - Text som inleder en rad
        //               int[] points - Arrayen där poängen är sparad, ettor ligger på index 1 
        //------------------------------------------------------------------------------------------
        public static void printStatistics(String[] text, int[] points)
        {
            int sum = 0, bonus = 0;
            for(int i = 1; i < text.length; i++)
            {
                System.out.print("\n" + text[i]);   
                System.out.print("\t" + points[i]);
                sum += points[i];
            }       
            if(sum >= 63)
                bonus = 50;
                
            System.out.println("\n-----------");
            System.out.println("Summa\t" + sum);    
            System.out.println("Bonus\t" + bonus);  
            System.out.println("===========");  
            System.out.println("TOTALT\t" + (sum + bonus)); 
        }   
        
        //------------------------------------------------------------------------------------------
        // Skriver ut resultaten, för flera spelare
        // INPARAMETRAR: int[] text   - Text som inleder en rad
        //               int[] points - Arrayen där poängen är sparad, ettor ligger på index 1 
        //------------------------------------------------------------------------------------------
        public static void printStatistics(String[] text, int[][] points, String[] player)
        {
            // Namnen på deltagarna skrivs ut först
            for(int i = 0; i < player.length; i++)
                System.out.print("\t" + player[i] );
            
            for(int i = 1; i < text.length; i++)
            {
                System.out.print("\n" + text[i]);   
                for(int j = 0; j < player.length; j++)
                    System.out.print("\t" + points[j][i]);
            }       
            System.out.println();           
            System.out.println();   
        }

        //##################//
        // STEG 1 - METODER //
        //##################//
        
        //------------------------------------------------------------------------------------------
        // Metod som simulerar ett kast med ett antal tärningar
        // Frekvensen, alltså antalet ettor, tvåor osv sparas arrayen
        // INPARAMETRAR: int[] dices - Arrayen dit frekvensen ska sparas, ettor sparas till index 1 
        //                             så arrayen ska ha 7 platser 0-6 där index 0 inte används
        //               int   no    - Antalet tärningar som ska slås 
        //------------------------------------------------------------------------------------------
        public static void throwDices(int[] dices, int no)
        {
            for(int i = 0; i < no; i++)
            {
                int number = (int)(Math.random()*6)+1;
                dices[number]++;
            }
        }
        
        //------------------------------------------------------------------------------------------
        // Nollar tidigare kast med tärningarna men sparar alla tärningar med angivet värde
        // INPARAMETRAR: int[] dices - Arrayen där frekvensen är sparad, ettor ligger på index 1 
        //                             så arrayen ska ha 7 platser 0-6 där index 0 inte används
        //               int   save  - Tärningsvärde som ska sparas
        // RETURVÄRDE:               - Antal tärningar som sparas
        //------------------------------------------------------------------------------------------
        public static int clearDices(int[] dices, int save)
        {
            int noOfSaved = dices[save];
            for(int i = 1; i < dices.length; i++)
            {
                if(i == save)
                    continue;
                dices[i] = 0;
            }
            return noOfSaved;
        }
        //------------------------------------------------------------------------------------------
        // Nollar tidigare kast med tärningarna men sparar alla tärningar med angivna värden
        // INPARAMETRAR: int[] dices - Arrayen där frekvensen är sparad, ettor ligger på index 1 
        //                             så arrayen ska ha 7 platser 0-6 där index 0 inte används
        //               int[] save  - Vilka tärningar som ska sparas (antal ettor som ska sparas finns på index 1)
        // RETURVÄRDE:               - Antal tärningar som sparas
        //------------------------------------------------------------------------------------------
        public static int clearDices(int[] dices, int[] save)
        {
            int noOfSaved = 0;
            for(int i = 1; i < dices.length; i++)
            {
                if(save[i] == 0)    // Spara inte
                    dices[i] = 0;   // Nollställ tärningen
                else
                {
                    // Om vi inte vill spara alla av en tärning, vi kanske vill ha en stege så vi vill spara en etta, en tvåa osv.
                    if(dices[i] >= save[i]) 
                        dices[i] = save[i];     // Ta bort eventella extra ettor, tvåor...
                    noOfSaved += dices[i];      // Håller reda på hur många tärningar som sparats
                }
            }
            return noOfSaved;
        }
        
        //------------------------------------------------------------------------------------------
        // Skriver ut genomfört kast med tärningarna
        // INPARAMETRAR: int[] dices - Arrayen där frekvensen är sparad, ettor ligger på index 1 
        //                             så arrayen ska ha 7 platser 0-6 där index 0 inte används
        //------------------------------------------------------------------------------------------
        public static void printDices(int[] dices)
        {
            System.out.println();
            for(int i = 1; i < dices.length; i++)
                for(int j = 0; j < dices[i]; j++)
                    System.out.print(i + "\t"); 
        }
        
        
        //------------------------------------------------------------------------------------------
        // Summerar angivet värde, antalet multipliceras med värdet
        // INPARAMETRAR: int[] dices - Arrayen där frekvensen är sparad, ettor ligger på index 1 
        //                             så arrayen ska ha 7 platser 0-6 där index 0 inte används
        //------------------------------------------------------------------------------------------
        public static int sumUnits(int number, int[] dices)
        {
            return dices[number]*number;
        }
        
        //###############################//
        // GRAFISK UTSKRIFT AV TÄRNINGAR //
        //###############################//

        
        //------------------------------------------------------------------------------------------
        // Skriver ut genomfört kast med tärningarna grafiskt
        // INPARAMETRAR: int[] dices - Arrayen där frekvensen är sparad, ettor ligger på index 1 
        //                             så arrayen ska ha 7 platser 0-6 där index 0 inte används
        //------------------------------------------------------------------------------------------
        public static void graphicalPrintDices(int[] dices)
        {
            String[] dice1 = { "", "|     |", "|*    |", "|*    |", "|*   *|", "|*   *|", "|*   *|"};
            String[] dice2 = { "", "|  *  |", "|     |", "|  *  |", "|     |", "|  *  |", "|*   *|"};
            String[] dice3 = { "", "|     |", "|    *|", "|    *|", "|*   *|", "|*   *|", "|*   *|"};

            
            for(int i = 1; i < dices.length; i++)
                for(int j = 0; j < dices[i]; j++)
                    System.out.print(dice1[i] + "\t");  
            System.out.println();
            for(int i = 1; i < dices.length; i++)
                for(int j = 0; j < dices[i]; j++)
                    System.out.print(dice2[i] + "\t");  
            System.out.println();
            for(int i = 1; i < dices.length; i++)
                for(int j = 0; j < dices[i]; j++)
                    System.out.print(dice3[i] + "\t");  

        }

    }



