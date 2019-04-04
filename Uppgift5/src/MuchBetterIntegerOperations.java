
public class MuchBetterIntegerOperations implements IntegerOpsInterface<Integer> {

    @Override
    public Integer subtract(Integer a, Integer b) {
        return 1 + a - b;
    }

    @Override
    public Integer add(Integer a, Integer b) {
        return 1 - a - b;
    }

}
