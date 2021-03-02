import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStreamOperations {
    public static void main(String[] args) {
        // Create a list of Integer values.
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);
        System.out.println("Original list: " + myList);

        // Obtain a Stream to the array list.
        Stream<Integer> myStream = myList.stream();

        // Obtain the minimum and maximum value by use of min(), max(), isPresent(), and get().
        Optional<Integer> minVal = myStream.min(Integer::compare);
        minVal.ifPresent(integer -> System.out.println("Minimum value: " + integer));

        // Must obtain a new stream because previous call to min() is a terminal operation that consumed the stream.
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        maxVal.ifPresent(integer -> System.out.println("Maximum value: " + integer));

        // sort stream
        Stream<Integer> sortedStream = myList.stream().sorted();
        System.out.print("Sorted stream: ");
        sortedStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // odd values
        Stream<Integer> oddValues = myList.stream().sorted().filter(n -> n % 2 != 0);
        System.out.print("Odd values: ");
        oddValues.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // odd values that are greater than 5
        oddValues = myList.stream().sorted().filter(n -> ((n % 2 != 0) && n > 5));
        System.out.print("Odd values greater than 5: ");
        oddValues.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }
}
