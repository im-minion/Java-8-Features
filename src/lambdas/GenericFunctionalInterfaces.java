package lambdas;

/*
 * A lambda expression, itself, cannot specify type parameters. Thus, a lambda expression cannot be generic.
 *  (Of course, because of type inference, all lambda expressions exhibit some “generic-like” qualities.)
 * However, the functional interface associated with a lambda expression can be generic.
 */
public class GenericFunctionalInterfaces {
    public static void main(String[] args) {
        // Use a String-based version of SomeFunc.
        SomeFunc<String> reverse = (str) -> {
            StringBuilder result = new StringBuilder();
            int i;
            for (i = str.length() - 1; i >= 0; i--)
                result.append(str.charAt(i));
            return result.toString();
        };

        System.out.println("Lambda reversed is " + reverse.func("Lambda"));
        System.out.println("Expression reversed is " + reverse.func("Expression"));

        // Now, use an Integer-based version of SomeFunc.
        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++)
                result = i * result;
            return result;
        };
        System.out.println("The factoral of 3 is " + factorial.func(3));
        System.out.println("The factoral of 5 is " + factorial.func(5));


        /*********************************************************************/
    }
}

// A generic functional interface.
interface SomeFunc<T> {
    T func(T t);
}