package lambdas;

public class L_07_MethodReference {
    // This method has a functional interface as the type of its first parameter.
    // Thus, it can be passed any instance of that interface, including a method reference.
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambdas add power to Java";
        String outStr;
        // Here, a method reference to strReverse is passed to stringOp().
//        outStr = stringOp((str) -> MyStringOps.strReverse(str), inStr); // or can be written as
        outStr = stringOp(MyStringOps::strReverse, inStr); // strReverse is static
        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);
        /*************************************************************************************/
        // Create a MyStringOps object.
        MyStringOps strOps = new MyStringOps();
        outStr = stringOp(strOps::strReverse2, inStr); //strReverse2 non static
        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);
    }
}

// This class defines a static method called strReverse().
class MyStringOps {
    // A static method that reverses a string.
    static String strReverse(String str) {
        StringBuilder result = new StringBuilder();
        int i;
        for (i = str.length() - 1; i >= 0; i--)
            result.append(str.charAt(i));
        return result.toString();
    }

    String strReverse2(String str) {
        StringBuilder result = new StringBuilder();
        int i;
        for (i = str.length() - 1; i >= 0; i--)
            result.append(str.charAt(i));
        return result.toString();
    }
}