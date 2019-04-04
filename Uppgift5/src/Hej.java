import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hej {
    
    private Adder<Integer> adder;

    public Hej(Adder<Integer> adder) {
        this.adder = adder;
    }
    
    public  Integer add(int a, int b) {
        return adder.add(a, b);
    }
    
    public static void main(String[] args) {
        Hej hej = new Hej(new IntegerOperations());
        
        hej.add(1, 2);
    }
    
};
