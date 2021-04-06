package streams.apis.map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// map( ) is an intermediate method.
public class MappingInStreams {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();
        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);

        // Map the square root of the elements in myList to a new stream
        Stream<Double> sqrtRootStrm = myList.stream().map((a) -> Math.sqrt(a));

        // Find the product of the square roots.
        double result = sqrtRootStrm.reduce(1.0, (a, b) -> a * b);
        System.out.println("Product of square roots is " + result);

        // how it looks beautifully in real time apps=> :p
        double x = myList.stream().map((a) -> Math.sqrt(a)).reduce(1.0, (a, b) -> a * b);
        System.out.println("REAL TIME APP " + x);

        /*------------------------------------------------------------------------------------------------------*/

        // A list of names, phone numbers, and e-mail addresses.
        List<NamePhoneEmail> namePhoneEmailList = new ArrayList<>();
        namePhoneEmailList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
        namePhoneEmailList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
        namePhoneEmailList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com"));

        System.out.println("Original values in myList: ");
        namePhoneEmailList.stream().forEach((a) -> {
            System.out.println(a.name + " " + a.phonenum + " " + a.email);
        });
        System.out.println();

        // Map just the names and phone numbers to a new stream.
        Stream<NamePhone> namePhoneStream = namePhoneEmailList.stream().map((obj) -> new NamePhone(obj.name, obj.phonenum));

        System.out.println("List of names and phone numbers: ");
        namePhoneStream.forEach((a) -> {
            System.out.println(a.name + " " + a.phonenum);
        });

        // The following statement uses filter( ) and then map( ) to produce a new stream that contains
        // only the name and phone number of the elements with the name "James":
        namePhoneStream = namePhoneEmailList.stream().map((obj) -> new NamePhone(obj.name, obj.phonenum));
        Stream<NamePhone> namePhoneStream1 = namePhoneEmailList.stream().filter(e -> "James".equals(e.name)).map((obj) -> new NamePhone(obj.name, obj.phonenum));
        System.out.println("List of names and phone numbers after filtering: ");
        namePhoneStream.forEach((a) -> {
            System.out.println(a.name + " " + a.phonenum);
        });


        /*------------------------------------------------------------------------------------------------------*/

        // In addition to the version just described, three other versions of map( ) are provided.
        // They return a primitive stream, as shown here:
        // IntStream mapToInt(ToIntFunction<? super T> mapFunc)
        // LongStream mapToLong(ToLongFunction<? super T> mapFunc)
        // DoubleStream mapToDouble(ToDoubleFunction<? super T> mapFunc)


        // Map the ceiling of the elements in myList to an IntStream.
        IntStream cStrm = myList.stream().mapToInt((a) -> (int) Math.ceil(a));
        int[] arr = cStrm.toArray(); // alowed
        cStrm = myList.stream().mapToInt((a) -> (int) Math.ceil(a));
        System.out.print("The ceilings of the values in myList: ");
        cStrm.forEach((a) -> {
            System.out.print(a + " ");
        });
    }
}
