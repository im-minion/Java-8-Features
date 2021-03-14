package lambdas;

public class L_04_PassingLambdasAsExpression {

    public static void main(String[] args) {
        String inStr = "Lambdas add power to Java";
        String outStr;

        System.out.println("Here is input string: " + inStr);
        // Here, a simple expression lambda that upperCases a string is passed to stringOp( ).
        outStr = stringOp((str) -> str.toUpperCase(), inStr);

        System.out.println("The string in uppercase: " + outStr);

        // This passes a block lambda that removes spaces.
        outStr = stringOp((str) -> {
            StringBuilder result = new StringBuilder();
            int i;
            for (i = 0; i < str.length(); i++)
                if (str.charAt(i) != ' ')
                    result.append(str.charAt(i));
            return result.toString();
        }, inStr);

        System.out.println("The string with spaces removed: " + outStr);
    }

    // This method has a functional interface as the type of its first parameter.
    // Thus, it can be passed a reference to any instance of that interface, including the instance created by a lambda expression.
    // The second parameter specifies the string to operate on.
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }
}

// Use lambda expressions as an argument to a method
interface StringFunc {
    String func(String n);
}
