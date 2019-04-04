
public class OperationsFactory {

    public static IntegerOpsInterface<Integer> makeInstance() {
        return new IntegerOperations();
    }
    
}
