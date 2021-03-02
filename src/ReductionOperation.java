import java.util.ArrayList;
import java.util.Optional;

public class ReductionOperation {
    public static void main(String[] args) {
        // Create a list of Integer values.
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);


        // get max using reduce operation
        int max = myList.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        System.out.println("max as int: " + max);

        // Two ways to obtain the integer product of the elements in myList by use of reduce().
        Optional<Integer> productObj = myList.stream().reduce((a, b) -> a * b);
        if (productObj.isPresent())
            System.out.println("Product as Optional: " + productObj.get());

        int product = myList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product as int: " + product);

        // paralel streams
        product = myList.parallelStream().reduce(1, (a, b) -> a * b);
        System.out.println("Parallel performed Product as int: " + product);

        // combining partial results, other version of reduce() when using the with parallel streams
        // <U> U reduce(U identityVal, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
        // "combiner" defines the function that combines two values that have been produced by the "accumulator" function

        // Demonstrate the use of a combiner with reduce() ->
        //  "combiner" version of "reduce( )" to compute the product of the square roots of each element in the list
        // This is now a list of double values.

        ArrayList<Double> myDoubleList = new ArrayList<>();
        myDoubleList.add(7.0);
        myDoubleList.add(18.0);
        myDoubleList.add(10.0);
        myDoubleList.add(24.0);
        myDoubleList.add(17.0);
        myDoubleList.add(5.0);

        double productOfSqrRoots = myDoubleList.parallelStream().reduce(
                1.0,
                (a, b) -> a * Math.sqrt(b),
                (a, b) -> a * b
        );
        System.out.println("Product of square roots: " + productOfSqrRoots);

    }
}
