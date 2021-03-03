package streams.apis.collect;

import streams.apis.map.NamePhone;
import streams.apis.map.NamePhoneEmail;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * As the preceding examples have shown, it is possible (indeed, common) to obtain a stream
 * from a collection. Sometimes it is desirable to obtain the opposite: to obtain a collection
 * from a stream. To perform such an action, the stream API provides the collect( ) method. It
 * has two forms. The one we will use first is shown here:
 *
 * <R, A> R collect(Collector<? super T, A, R> collectorFunc
 *
 *
 * The collect( ) method is a terminal operation.
 *
 * The Collectors class defines a number of static collector methods that you can use as-is.
 * The two we will use are toList( ) and toSet( ), shown here:
 * static <T> Collector<T, ?, List<T>> toList( )
 * static <T> Collector<T, ?, Set<T>> toSet( )
 * */
public class CollectingStreams {
    public static void main(String[] args) {

        // A list of names, phone numbers, and e-mail addresses.
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com"));

        // Map just the names and phone numbers to a new stream.
        Stream<NamePhone> nameAndPhone = myList.stream().map(
                (a) -> new NamePhone(a.name, a.phonenum)
        );

        // Use collect to create a List of the names and phone numbers.
        List<NamePhone> npList = nameAndPhone.collect(Collectors.toList());
        System.out.println("Names and phone numbers in a List:");
        for (NamePhone e : npList)
            System.out.println(e.name + ": " + e.phonenum);

        // Obtain another mapping of the names and phone numbers.
        nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));

        // Now, create a Set by use of collect().
        Set<NamePhone> npSet = nameAndPhone.collect(Collectors.toSet());

        System.out.println("\nNames and phone numbers in a Set:");
        for (NamePhone e : npSet)
            System.out.println(e.name + ": " + e.phonenum);

        // a second version that gives you more control over the
        // collection process. It is shown here:
        // <R> R collect(Supplier<R> target, BiConsumer<R, ? super T> accumulator, BiConsumer <R, R> combiner)
        LinkedList<NamePhone> npList2 = nameAndPhone.collect(
                () -> new LinkedList<>(),
                (list, element) -> list.add(element),
                (listA, listB) -> listA.addAll(listB));
        System.out.println("Names and phone numbers in a List:");
        for (NamePhone e : npList2)
            System.out.println(e.name + ": " + e.phonenum);

        HashSet<NamePhone> npSet2 = nameAndPhone.collect(HashSet::new,
                HashSet::add,
                HashSet::addAll);

        System.out.println("\nNames and phone numbers in a Set:");
        for (NamePhone e : npSet2)
            System.out.println(e.name + ": " + e.phonenum);

    }
}
