package lambdas;


/*
 *
 * A lambda expression is, essentially, an anonymous (that is, unnamed) method. However, this method is not executed on its own.
 * Instead, it is used to implement a method defined by a functional interface.
 * Thus, a lambda expression results in a form of anonymous class.
 * Lambda expressions are also commonly referred to as closures.
 *
 *
 * A functional interface is an interface that contains one and only one abstract method.
 * FuncInterface represents single action.
 * eg. Runnable Interface's run() method in Thread Programming.
 *
 * Key point: a lambda expression can be used only in a context in which its target type is specified.
 * One other thing: a functional interface is sometimes referred to as a SAM type, where SAM stands for Single Abstract Method.
 *
 * Lambdas :
 * eg. () -> 123.45
 * This lambda expression takes no parameters, thus the parameter list is empty. It returns the constant value 123.45
 * can also be written as : double myMeth() { return 123.45; }
 *
 * eg. () -> Math.random() * 100, here it takes constant value from Math.random() and multiplies with 100 and returns it.
 *
 * eg. (n) -> (n % 2)==0, here it takes parameter n and returns boolean value based on if it is even or odd
 *
 * Functional Interface: only one abstract method
 * Beginning with JDK 8, it is possible to specify default behavior for a method declared in an interface. This is called a default method.
 *
 * Single expression lambda bodies are referred to as "expression bodies".
 * Lambdas that have expression bodies are sometimes called "expression lambdas".
 * */


public class Basics {
    public static void main(String[] args) {
        MyNumber m = () -> 90;
        System.out.println("MyNumber m ::" + m.getValue());

        MyNumberWithArg m2 = (int a) -> a * 2;
        // IMP:: int is not written in the arg, is also valid => (a) -> a * 2;
        // IMP:: without parenthesis around `a` is also valid => a -> a * 2;
        System.out.println("MyNumberWithArg m2 ::" + m2.getValue(4));

        // A lambda expression that tests if a number is even.
        NumericTest isEven = (n) -> (n % 2) == 0; // int is written in the arg, is also valid  => (int n) -> (n % 2) == 0;
        if (isEven.test(10)) System.out.println("10 is even");
        if (!isEven.test(9)) System.out.println("9 is not even");

        // Now, use a lambda expression that tests if a number is non-negative.
        NumericTest isNonNeg = (n) -> n >= 0;
        if (isNonNeg.test(1)) System.out.println("1 is non-negative");
        if (!isNonNeg.test(-1)) System.out.println("-1 is negative");

    }
}

// annotation is optional
@FunctionalInterface
interface MyNumber {
    double getValue();
}

@FunctionalInterface
interface MyNumberWithArg {
    double getValue(int x);
}

// Demonstrate a lambda expression that takes a parameter.
// Another functional interface.
interface NumericTest {
    boolean test(int n);
}