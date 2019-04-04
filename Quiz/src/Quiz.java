
public class Quiz {
    public static void main(String[] args) {
        //float a;
  //      a = 1/2f;//0,5
        //a = 1/2; // 0,0
       // a = 1/2.0f; //0,5
       // a = (float)(1/2); //0,0
        //a = (float)1/2; //0,5
       // int short = 10;
        //char heltal = "9";
        int $dollar = 500;
       // int 456 = 123;
        String string = "2";
        long år = 2007;
        
        //System.out.println (a);
            int no = 10;
           System.out.println(++no);
           System.out.println(no++);
           
          // int[] b = null;
           
           int a = 3, b = 3;
           b = metod(a, b);
           System.out.println("a = " + a + " och b = " + b);
           
    }
    public static int metod(int a, int b)
    {
        a = a + b;
        return a;
    }

}
